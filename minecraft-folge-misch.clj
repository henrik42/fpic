;; Wir wollen einen Minion (englisch für "Gehilfe") programmieren. Der Minion
;; soll verschiedene Verhaltensweisen haben. Eine dieser Verhaltensweisen ist,
;; dass er einer anderen Figur (einer Entity; z.B. unserem Spieler) folgen soll. 
;;
;; Das Folge-Misch-Verhalten wird wie folgt implementiert:  
;; a) bestimme die Position der Entity (z.B. des Spielers).  
;; b) bestimme die Position des Minion.  
;; c) berechne den Richtungsvektor
;;    ([Differenzvektor](https://de.wikipedia.org/wiki/Zweipunkteform#Darstellung_2))
;;    vom Minion zur Entity.   
;; d) Setzte die Geschwindigkeit/Bewegungsrichtung des Minion.
;;
;; Dieser Algorithmus wird nun ständig wiederholt. Wir werden den Algorithmus
;; später noch überarbeiten, aber erstmal soll es das sein.

(ns minecraft-folge-misch
  (:require [lambdaisland.witchcraft :as wc]
            [lambdaisland.witchcraft.matrix :as mx]))

(comment 
  (wc/set-time 1000)
  (wc/set-game-rule :do-daylight-cycle false)
  (wc/set-game-rule :do-weather-cycle false)
  (wc/fly! (wc/player))
  )

(comment 
  (position-von (wc/loc (wc/player)))
  )

(defn position-von 
  "Liefert die Postion der Entity als `{:x <x> :y <y> :z <z>}`."
  [entity]
  (wc/loc entity))

(comment 
  (def p {:x 1 :y 2 :z 3})
  (def q {:x 4 :y 6 :z 2})
  (differenz-vektor p q)
  )

(defn differenz-vektor 
  "Liefert den Differenzvektor `q - p = {:x <x> :y <y> :z <z>}` der Vektoren `p` und `q`."
  [p q]
  (mx/v- q p))

(comment 
  (def e [3 3 3])
  (def m [0 0 0])
  (bewegungsrichtung e m)
  (bewegungsrichtung e e)
  )

(defn bewegungsrichtung 
  "Bewegungsrichtung `{:x <x> :y <y> :z <z>}` des Minion `m`, so dass er sich in Richtung der Entity `e` bewegt."
  [e m]
  (let [e-pos (position-von e)
        m-pos (position-von m)
        q-p (differenz-vektor m-pos e-pos)
        ;; Wir normieren/skalieren den Vektor so, dass er Länge 1 hat.  
        ;; https://de.wikipedia.org/wiki/Einheitsvektor
        q-p-length (mx/vlength q-p)
        ;; Falls der Vektor sehr klein ist, liefern wir als Ergebnis den Vektor.
        ;; Damit vermeiden wir einen "Division durch 0"-Fehler.
        q-p-skaliert (if (< q-p-length 0.001) 
                       q-p
                       (mx/v* q-p (/ 1.0 q-p-length)))]
    q-p-skaliert))

(defn setzte-bewegungsrichtung!
  "Setzt die Bewegungsrichtung der des Minion `m`, so dass er sich in Richtung der Entity `e` bewegt."
  [m e]
  ;; Durch den Faktor steuern wir, wie schnell sich die Entität bewegt.
  (let [{:keys [x y z]} (mx/v* (bewegungsrichtung e m) 0.15)]
    (.setVelocity m (wc/vec3 x y z))))

(comment

  ;; Wir spawnen eine Kuh an der Spieler-Postion und geben ihr einen Namen
  (def cow (doto (wc/spawn (wc/player) :cow)
             (.setCustomName "MUUUHHHH!!!")
             (.setCustomNameVisible true)))

  ;; Als "Minion" nutzen wir einfach unseren Spieler.
  (def minion (wc/player))

  ;; Nun können wir die Kuh auf uns zubewegen lassen oder uns auf die Kuh
  ;; zubewegen.
  (setzte-bewegungsrichtung! cow minion)
  (setzte-bewegungsrichtung! minion cow)

  ;; Wir stellen fest:
  ;; 
  ;; 1) Wenn sich zwischen uns und der Kuh ein Hindernis befindet, bleibt die
  ;;    Kuh an diesem Hindernis "hägen".  
  ;;
  ;; 2) Nachdem wir die Geschwindigkeit setzen, bewegt sich die Kuh zwar für
  ;;    eine bestimmte Zeit, aber sie wird gebremst/langsamer. 
  ;;
  ;; Mögliche Verbesserungen:
  ;; 
  ;; 1) Wir müssen die Geschwindigkeit immer wieder setzen -- in einer Schleife!
  ;;    (vgl. wiederhole-setzte-bewegungsrichtung!) Dabei haben wir aber das
  ;;    gleiche Problem wie bei den Mauern: dort hatten wir festgestellt, dass
  ;;    wir die Schleife "verlassen" müssen, damit das Spiel fortgesetzt wird.
  ;;    Wir könnten also z.B. Tasks benutzen, durch die wir immer wieder die
  ;;    Geschwindigkeit setzen.

  (wiederhole-setzte-bewegungsrichtung! cow minion)

  ;; Wenn du die Funktion "umdefinierst", hört die Kuh bzw. die Kühe auf,
  ;; unserem Spieler zu folgen.
  (defn wiederhole-setzte-bewegungsrichtung! [& _]
    (println "Habe fertig"))

  ;; Wie können das Ganz auch machen, ohne dass wir die Kuh an einen Namen
  ;; binden. Dadurch können wir das z.B. auch machen, während der Spieler
  ;; fliegt. Ansonsten würde unsere Kuh ja sofort abstürzen.
  (wiederhole-setzte-bewegungsrichtung!
   (doto (wc/spawn (wc/player) :cow)
     (.setCustomName "MUUUHHHH!!!")
     (.setCustomNameVisible true))
   (wc/player))

  )

;; Ruft einmalig `(setzte-bewegungsrichtung! m e)` auf und stellt einen Task
;; ein, der dann erneut `(wiederhole-setzte-bewegungsrichtung! m e)` aufruft.
;; Dadurch haben wir eine Schleife.  
;; Dieser Schleife fehlt das Abbruchkriterium! Es ist "fast" eine
;; (Endlos-)Rekursion. Durch die Re-definition der Funktion (vgl. oben) kannst
;; du aber während deiner REPL-Sitzung die Schleife bzw. das wiederholte
;; Aufrufen beenden.
(defn wiederhole-setzte-bewegungsrichtung! [m e]
  (#'setzte-bewegungsrichtung! m e)
  (wc/run-task-later
   #(#'wiederhole-setzte-bewegungsrichtung! m e)
   3))

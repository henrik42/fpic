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
  (bewegungs-richtung e m)
  )

(defn bewegungs-richtung 
  "Bewegungsrichtung `{:x <x> :y <y> :z <z>}` des Minion `m`, so dass er sich in Richtung der Entity `e` bewegt."
  [e m]
  (let [e-pos (position-von e)
        m-pos (position-von m)
        q-p (differenz-vektor m-pos e-pos)
        ;; Wir normieren/skalieren den Vektor so, dass er Länge 1 hat.  
        ;; https://de.wikipedia.org/wiki/Einheitsvektor
        q-p-length (mx/vlength q-p)
        q-p-skaliert (mx/v* q-p (/ 1 q-p-length))]
    q-p-skaliert))

(defn setzte-bewegungs-richtung!
  "Setzt die Bewegungsrichtung der des Minion `m`, so dass er sich in Richtung der Entity `e` bewegt."
  [m e]
  (let [{:keys [x y z]} (mx/v* (bewegungs-richtung e m) 0.2 #_ 1.0 #_ 0.1)]
    (.setVelocity m (wc/vec3 x y z))))

(comment

  (def cow (wc/spawn (wc/player) :cow))
  (def minion (wc/player))

  ;; Nun können wir die Kuh auf uns zubewegen lassen oder uns auf die Kuh
  ;; zubewegen.
  (setzte-bewegungs-richtung! cow minion)
  (setzte-bewegungs-richtung! minion cow)

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
  ;;    Dabei haben wir aber das gleiche Problem wie bei den Mauern: dort hatten
  ;;    wir festgestellt, dass wir die Schleife "verlassen" müssen, damit das
  ;;    Spiel fortgesetzt wird. Wir könnten also z.B. Tasks benutzen, durch die
  ;;    wir immer wieder die Geschwindigkeit setzen.

  (def cow (wc/spawn (wc/player) :cow))
  (def minion (wc/player))

  (wiederhole-setzte-bewegungs-richtung! cow minion)

  (defn wiederhole-setzte-bewegungs-richtung! [& _]
    (println "Habe fertig"))

  ;; Ruft einmalig `(setzte-bewegungs-richtung! m e)` auf und stellt einen Task
  ;; ein, der dann erneut `(wiederhole-setzte-bewegungs-richtung! m e)` aufruft.
  ;; Dadurch haben wir eine Schleife. Es ist "fast" eine Rekursion.
  (defn wiederhole-setzte-bewegungs-richtung! [m e]
    (#'setzte-bewegungs-richtung! m e)
    (wc/run-task-later
     #(#'wiederhole-setzte-bewegungs-richtung! m e)
     3))

  )
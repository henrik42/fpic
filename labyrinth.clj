;; https://markbastian.github.io/posts-output/2015-04-11-mazes/

;; Ein Labyrinth wird in unserem Fall als
;; [Matrix](https://de.wikipedia.org/wiki/Matrix_(Mathematik)) dargestellt.
;; 
;; Matrizen können in Clojure mit Hilfe von Vektoren dargestellt werden. Der
;; "äußere" Vektor enthält als Elemente die __Zeilen__ der Matrix, die wiederum
;; Vektoren sind. Diese Vektoren enthalten dann pro __Spalte__ die Elemente
;; (eine __Zelle__) der Matrix.
;; 
;; In unserem Fall werden wir __Mengen__ als Elemente/Zellen der Matrix
;; verwenden. Diese Mengen/Zellen enthalten später die __Verbindungen__ zwischen
;; den __Zellen__ des Labyrinths.

(comment
  (mache-leeres-labyrinth 2 3) ;=> [[#{} #{} #{}] [#{} #{} #{}]]
  
  ;; ACHTUNG: `repeat` (ohne Anzahl der Elemente) erzeugt eine "endlos lange"
  ;; Sequenz. Daher darst du den Ausdruck niemals direkt auswerten, sondern du
  ;; musst immer die Anzahl der Elemente begrenzen, die du aus der Sequenz liest
  ;; (z.B. mit `take`). Oder du gibst die Anzahl direkt bei `repeat` mit an.
  ;;
  ;; `repeat` kannst du also dafür nutzen, um einen Wert "beliebig häufig" zu
  ;; wiederholen.
  
  (take 5 (repeat :a)) ;=> (:a :a :a :a :a)
  (repeat 5 :a)        ;=> (:a :a :a :a :a)
  
  )

;; Ein __leeres__ Labyrinth besteht aus Zellen, die __keine Verbindungen__
;; haben.
(defn mache-leeres-labyrinth
  "Liefert ein leeres Labyrinth."
  [zeilen spalten]
  (vec (repeat zeilen (vec (repeat spalten #{})))))

;; +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

(comment
  (nachbarn-von (mache-leeres-labyrinth 2 3) [1 2]) ;=> ([0 2] [1 1])
  
  ;; `juxt` erzeugt eine Funktion(!!!), die zu einem Argument x einen Vektor v
  ;; liefert. Dieser Vektor enthält die Ergebnisse der Funktions-Auswertungen
  ;; auf x.
  ;;
  ;; `juxt` kannst du also nutzen, wenn du mehrere verschiedene Funktionen auf
  ;; denselben Wert anwenden möchtest.
  
  (juxt inc dec)              ;=> #function[clojure.core/juxt/fn--5895]
  ((juxt inc dec) 5)          ;=> [6 4]
  ((juxt inc dec #(/ % 2)) 6) ;=> [7 5 3]
  
  ;; Manchmal möchtest du den Vektor vielleicht noch "auseinander nehmen". Dafür
  ;; eignet sich let mit Vektor-Destrukturierung.
  
  (let [[erster zweiter dritter] ((juxt inc dec #(/ % 2)) 6)]
    {:erster erster
     :zweiter zweiter
     :dritter dritter}) ;=> {:erster 7, :zweiter 5, :dritter 3}
  
  ;; Mit `map` kannst du "paar-weise" über mehrere Sequenzen schleifen. 
  
  (map vector [1 2 3] [:a :b :c]) ;=> ([1 :a] [2 :b] [3 :c])
  
  (map vector
       ((juxt inc identity dec identity) 3)
       ((juxt identity inc identity dec) 8)) ;=> ([4 8] [3 9] [2 8] [3 7])
  
  ;; Mit `get-in` greifst du auf geschachtelte Strukturen zu. Für Vektoren nutzt
  ;; du den Index/Offset, für Maps nutzt du die Schlüssel.
  
  (get-in [:a [:A :B] :b [:C :D]] [0])     ;=> :a
  (get-in [:a [:A :B] :b [:C :D]] [1])     ;=> [:A :B]
  (get-in [:a [:A :B] :b [:C :D]] [1 0])   ;=> :A
  (get-in [:a [:A :B] :b [:C :D]] [1 1])   ;=> :B
  
  (get-in {:a [:A :B] :b [:C :D]} [:a 0])  ;=> :A
  (get-in {:a {:A :B} :b {:C :D}} [:a :A]) ;=> :B
  
  ;; Falls ein Element einmal nicht vorhanden ist, passiert nichts Schlimmes. Es
  ;; wird einfach `nil` geliefert.
  
  (get-in [:a [:A :B] :b [:C :D]] [5 0])   ;=> nil
  ) 

;; Die Nachbarn einer Zelle in dem Labyrinth sind jene Zellen (in dem
;; Labyrinth), die __direkt__ oberhalb, unterhalb und seitlich zu der
;; angegebenen Zelle liegen.
;;
;; Wir geben die Zelle, deren Nachbarn wir suchen, in diesem Fall als __Vektor__
;; ihrer __0-basierten Indizies__ an (Index-Vektor).
;; 
;; Also ist `[0 0]` die Zelle der ersten Zeile und ersten Spalte. Mit `[1 2]`
;; beziehen wir uns auf die Zelle der zweiten Zeile und dritten Spalte.
;;
;; Die Funktion liefert eine Sequenz/Liste mit den Index-Vektoren der Nachbarn.
(defn nachbarn-von
  "Liefert alle Nachbarn der angegebenen Zelle."
  [labyrinth [zeile spalte]]
  (->> (map vector
            ((juxt inc identity dec identity) zeile)
            ((juxt identity inc identity dec) spalte))
       ;; Wir liefern nur solche Index-Vektoren, die auf eine __vorhandene__
       ;; Zelle im Labyrinth verweisen.
       (filter #(get-in labyrinth %))))

(comment
  (hinzufügen-verbindung
   (mache-leeres-labyrinth 2 3)
   [1 2]   ;; von Zelle
   [0 2])  ;; nach Zelle
   ;=> [[#{} #{} #{[1 2]}] [#{} #{} #{[0 2]}]]
  )

;; Ein Labyrinth besteht aus Zellen, die teilweise mit ihren Nachbarn
;; __verbunden__ sind.
;;
;; Die Verbindungen einer Zelle stellen wir als __Menge__ von Index-Vektoren
;; jener Zellen dar, zu denen sie verbunden ist (Verbindungs-Menge).
;;
;; Wenn wir eine Verbindung zwischen zwei benachbarten Zellen hinzufügen wollen,
;; müssen wir also zu der Verbindungs-Menge jeder der beiden Zellen den
;; Index-Vektor der jeweils anderen Zelle hinzufügen.
(defn hinzufügen-verbindung
  "Liefert ein Labyrinth, das eine __Verbindung__ zwischen den angegebenen Zellen hat."
  [labyrinth von nach]
  (-> labyrinth
      (update-in von conj nach)
      (update-in nach conj von)))

(comment
  (mache-labyrinth (mache-leeres-labyrinth 3 3) [0 0] [2 2])
  )

;; Erzeugt ein Labyrinth.
;;
;; Die Größe des Labyrinths wird durch die Größe des __leeren__ Labyrinths
;; bestimmt, das als Argument zu übergeben wird.
;;
;; In dem Labyrinth ist jede Zelle mit jeder anderen Zelle über Verbindungen zu
;; erreichen. Es gibt also keine "abgeschnittenen" Zellen. Daher ist es auch
;; egal, welche Zellen als `start` und `ziel` ausgewählt werden --- es gibt
;; immer einen Weg von `start` zu `ziel`. Natürlich ist es schwerer einen Weg
;; von `start` zu `ziel` zu finden, wenn diese weit von einander entfernt
;; liegen.
;; 
;; `start` und `ziel` sind die Index-Vektoren der betreffenden Zellen.
;;
;; Die folgende Implementierung lehnt sich an den [Algorithmus von
;; Prim](https://de.wikipedia.org/wiki/Algorithmus_von_Prim) an:
;;
;; #_1: Zu Beginn der Berechnung stellt allein die Start-Zelle den schon
;; __besuchten__ Bereich der Zellen des Labyrinths dar. Die __besuchten__ Zellen
;; erkennt man daran, dass die Verbindungs-Menge der Zelle __nicht leer__ ist.
;; Wir fügen der Verbindungs-Menge der Start-Zelle hier einfach das Keyword
;; `:start` zu, um sie als __besucht__ zu markieren. 
;; 
;; #_2: Die Nachbarn der Start-Zelle stellen die __Grenze__ dar. Die Grenze ist
;; eine Collection, die alle __nicht besuchten__ __Nachbarn__ der bisher
;; __besuchten__ Zellen enthält.
;;
;; #_3: falls die __Grenze__ leer ist, gibt es keine __nicht besuchten__ Zellen
;; mehr. Es wurden also alle Zellen __besucht__. Damit ist das Labyrinth fertig.
;;
;; #_4: Wir fügen der Verbindungs-Menge der Ziel-Zelle noch das Keyword `:ziel`
;; zu (aber das ist für den Algorithmus nicht nötig) und liefern das Labyrinth
;; als Ergebnis.
;;
;; #_5: Da die __Grenze__ nicht leer ist, gibt es weitere noch nicht besuchte
;; Zellen. Wir wählen __zufällig__ eine dieser Zellen aus der __Grenze__ als die
;; "nächste Zelle", die wir betrachten/besuchen.
;;
;; #_6: und wir berechnen die __Nachbarn__ dieser Zelle.
;;
;; #_7/#_8: die Nachbarn dieser Zelle fallen in zwei __Gruppen__: es gibt jene
;; Nachbarn, die bisher noch __nicht besucht__ wurden (zu erkennen an ihren
;; leeren Verbindungs-Mengen) und jene Nachbar, die schon besucht wurden. Wir
;; nutzen hier `group-by`, um die erwähnten __Gruppen__ der __Nachbarn__ zu
;; bilden und `empty` um zu prüfen, ob die Verbindungs-Menge leer ist. Wir
;; nutzen __Map-Destrukturierung__ (#_7), um die beiden Gruppen an lokale Namen
;; zu binden, so dass wir anschließend mit diesen Namen weiterarbeiten können.
;;
;; #_9: Wir fügen dem Labyrinth eine Verbindung zwischen der gerade
;; betrachteten/besuchten Zelle und einer der zufällig ausgewählten schon
;; besuchten __Nachbarn__ dieser Zelle hinzu. 
;;
;; Wichtig: alle bisher besuchten Zellen sind untereinander erreichbar und dies
;; gilt nun auch für die gerade betrachtete Zelle, die wir durch die Verbindung
;; der Menge der erreichbaren Zellen hinzugefügt haben.
;;
;; #_10: aus der Genze entfernen wir jene Zelle, die wir gerade betrachtet haben
;; und fügen die bisher nicht besuchten Nachbarn dieser Zelle der Grenze hinzu.
;;
;; Durch `recur` wiederholen wir das Verfahren bei #_4 mit den neuen __Werten__
;; für `labyrinth` und `grenze`.
;;
;; Es wurde natürlich nichts __geändert__!!! Die Daten in Clojure sind
;; __unveränderlich__. Wir können nur __neue Werte__ erzeugen und dies dann
;; durch `loop/recur` für den anschließenden Durchlauf binden.

(defn mache-labyrinth
  "Liefert ein Labyrinth."
  [leeres-labyrinth start ziel]
  (loop [labyrinth (update-in leeres-labyrinth start conj :start)                    #_1
         grenze    (into #{} (nachbarn-von labyrinth start))]                        #_2
    (if (empty? grenze)                                                              #_3
      (update-in labyrinth ziel conj :ziel)                                          #_4
      (let [nächste-zelle (rand-nth (vec grenze))                                    #_5
            nachbarn (nachbarn-von labyrinth nächste-zelle)                          #_6
            {besucht false nicht-besucht true}                                       #_7
            (group-by #(empty? (get-in labyrinth %)) nachbarn)]                      #_8
           (recur (hinzufügen-verbindung labyrinth (rand-nth besucht) nächste-zelle) #_9
                  (into (disj grenze nächste-zelle) nicht-besucht))))))              #_10

;; +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
;; Die folgenden Funktionen dienen dazu, ein Labyrinth in Minecraft zu bauen.
;; Zuerst wird eine "Bodenplatte" aus Blöcken gebaut. Auf dieser wird eine
;; Schicht aus Blöcken der Höhe 3 gebaut. Aus dieser Schicht werden dann jene
;; Blöcke "entfernt", die die Zellen darstellen. Zwischen diesen Zellen
;; verbleiben Blöcke für die "Mauen", die die Zellen umschließen. Schließlich
;; werden jene Mauen entfernt, die zwischen den "verbundenen" Zellen stehen.

;; Zellen werden als Quadrat von n x n Blöcken dargstellt.
(def zell-größe 2)

;; Damit rechnen wir aus den Zell-Indexen die Block-Offsets aus, die wir
;; brauchen, um die Blöcke setzen zu können.
(defn ->offset 
  "Liefert den Block-Offset für einen Zell-Index."
  [x]
  (inc (* (inc zell-größe) x)))

(comment
  (boden-blöcke 1 1 1)
  (boden-blöcke 2 2 1)
  )

(defn boden-blöcke
  "Liefert die Block-Offsets für die Blöcke der 'Bodenplatte'."
  [zeilen spalten höhe]
  (for [x (range (->offset zeilen))
        y (range höhe)
        z (range (->offset spalten))]
    [x y z]))

(comment
  (zell-blöcke [0 0] 1)
  (zell-blöcke [2 1] 1)
  )

(defn zell-blöcke
  "Liefert die Block-Offsets für die Zell-Blöcke der angegebenen Zelle."
  [[zeile spalte] höhe]
  (let [x0 (->offset zeile)
        z0 (->offset spalte)]
    (for [x (range zell-größe)
          y (range höhe)
          z (range zell-größe)]
      [(+ x0 x) y (+ z0 z)])))

(comment
  (mauer-blöcke [0 0] [1 0] 1)
  (mauer-blöcke [0 0] [0 1] 1)
  )

(defn mauer-blöcke
  "Liefert die Block-Offsets für die Mauer-Blöcke zwischen den angegebenen Zelle."
  [[von-zeile von-spalte] [nach-zeile nach-spalte] höhe]
  (let [x0 (->offset von-zeile)
        z0 (->offset von-spalte)
        dx (- nach-zeile von-zeile)
        dz (- nach-spalte von-spalte)
        x-start (* dx zell-größe)
        x-end (+ dx x-start (* dz zell-größe))
        z-start (* dz zell-größe)
        z-end (+ dz z-start (* dx zell-größe))]
    (for [x (range x-start x-end)
          y (range höhe)
          z (range z-start z-end)]
      [(+ x0 x) y (+ z0 z)]))
  )

(comment
  (require '[lambdaisland.witchcraft :as wc])

  (do 
    (wc/set-time 1000)
    (wc/set-game-rule :do-daylight-cycle false)
    (wc/set-game-rule :do-weather-cycle false)
    (wc/fly! (wc/player)))

  ;; Dies ist der __Ursprung__, an dem wir das Labyrinth mit Blöcken aufbauen werden.
  (def ursprung (wc/xyz-round (wc/loc (wc/player))))

  ;; Die Höhe der Mauen, die das gebaute Labyrinth haben wird. 
  (def mauer-höhe 3)

  ;; Die Größe des Labyrinths (zeilen x spalten Zellen)
  (def labyrinth-zeilen 10)
  (def labyrinth-spalten 10)

  (def labyrinth (mache-labyrinth
                  (mache-leeres-labyrinth labyrinth-zeilen labyrinth-spalten)
                  [0 0]
                  [(dec labyrinth-zeilen) (dec labyrinth-spalten)]))

  (defn set-blocks 
    "Setzt die Blöcke (Offset zu anchor)."
    [anchor blocks material]
    (wc/set-blocks
     blocks
     {:anchor anchor
      :material material}))

  ;; ---------------------------------------------------------------------------------
  ;; Nun bauen wir das Labyrinth.
  ;; ---------------------------------------------------------------------------------
  
  ;; (1) Die Bodenplatte bauen
  (set-blocks
   ursprung
   (boden-blöcke labyrinth-zeilen labyrinth-spalten 1)
   :orange-concrete)

  ;; (2) Den Labyrinth-Block bauen. Aus diesem werden anschließend die Gänge
  ;; "herausgeschnitten"
  (set-blocks
   (wc/add ursprung [0 1 0])
   (boden-blöcke labyrinth-zeilen labyrinth-spalten 3)
   :gold-block)

  ;; (3) Alle Zellen "herausschneiden"
  (doseq [x (range labyrinth-zeilen)
          y (range labyrinth-spalten)]
    (set-blocks
     (wc/add ursprung [0 1 0])
     (zell-blöcke [x y] 3)
     :air))

  ;; (4) Alle Mauern zwischen verbundenen Zellen entfernen und am Start und am
  ;; Ziel eine Kuh erscheinen lassen.
  (doseq [zeile (range labyrinth-zeilen)
          spalte (range labyrinth-spalten)
          :let [verbindungen (get-in labyrinth [zeile spalte])]]
    (doseq [nachbar verbindungen]
      (condp = nachbar
        :start (wc/spawn (wc/add ursprung [1 0 1] [(->offset zeile) 1 (->offset spalte)]) :cow)
        :ziel (wc/spawn (wc/add ursprung [1 0 1] [(->offset zeile) 1 (->offset spalte)]) :cow)
        (set-blocks
         (wc/add ursprung [0 1 0])
         (mauer-blöcke [zeile spalte] nachbar 3)
         :air))))
  
  
  )

;; https://markbastian.github.io/posts-output/2015-04-11-mazes/

;; Ein Labyrinth wird in unserem Fall als
;; [Matrix](https://de.wikipedia.org/wiki/Matrix_(Mathematik)) dargestellt.
;; 
;; Matrizen können in Clojure mit Hilfe von Vektoren dargestellt werden. Der
;; "äußere" Vektor enthält als Elemente die __Zeilen__ der Matrix, die wiederum
;; Vektoren sind. Diese Vektoren enthalten dann pro __Spalte__ die Elemente der
;; Matrix.
;; 
;; In unserem Fall werden wir Mengen als Elemente der Matrix verwenden. Diese
;; Mengen enthalten später die __Verbindungen__ zwischen den __Zellen__ des
;; Labyrinths.

(comment 
  (mache-leeres-labyrinth 2 3)) ;=> [[#{} #{} #{}] [#{} #{} #{}]]

;; Ein __leeres__ Labyrinth besteht aus Zellen, die __keine Verbindungen__
;; haben.
(defn mache-leeres-labyrinth
  "Liefert ein leeres Labyrinth."
  [zeilen spalten]
  (vec (take zeilen (repeat (vec (take spalten (repeat #{})))))))

(comment
  (nachbarn-von (mache-leeres-labyrinth 2 3) [1 2]) ;=> ([0 2] [1 1])
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
  [labyrinth [m n]]
  (->> (map vector
            ((juxt inc identity dec identity) m)
            ((juxt identity inc identity dec) n))
       ;; Wir liefern nur solche Index-Vektoren, die auf eine __vorhandene__
       ;; Zelle im Labyrinth verweisen.
       (filter #(get-in labyrinth %))))

(comment
  (hinzufügen-verbindung (mache-leeres-labyrinth 2 3) [1 2] [0 2]) ;=> [[#{} #{} #{[1 2]}] [#{} #{} #{[0 2]}]]
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
  (loop [labyrinth (update-in leeres-labyrinth start conj :start)                 #_1
         grenze    (into #{} (nachbarn-von labyrinth start))]                     #_2
    (if (empty? grenze)                                                           #_3
      (update-in labyrinth ziel conj :ziel)                                       #_4
      (let [nächste-zelle (rand-nth (vec grenze))                                 #_5
            nachbarn (nachbarn-von labyrinth nächste-zelle)                       #_6
            {besucht false nicht-besucht true}                                    #_7
            (group-by #(empty? (get-in labyrinth %)) nachbarn)]                   #_8
        (recur (hinzufügen-verbindung labyrinth (rand-nth besucht) nächste-zelle) #_9
               (into (disj grenze nächste-zelle) nicht-besucht))))))              #_10


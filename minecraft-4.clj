;; In dieser Datei findest du Beispiele dazu, wie du eine "Wand aus Gold" bauen
;; kannst. Dabei wollen wir die Wand gerne mit einer zeitlichen Verzögerung
;; Block für Block bauen, so dass wir dabei zuschauen können, wie die Wand
;; gebaut wird. Wir werden sehen, dass das gar nicht so leicht ist.

(ns minecraft-4
  (:require [lambdaisland.witchcraft :as wc]))

;; Baut an der Position `at` eine Wand aus Gold. Die X-Breite der Mauer ist 2,
;; die Höhe ist ebenfalls 2. Falls die Funktion mit zwei Argeumenten aufgerufen
;; wird, gibt das zweite die X-Breite an. Falls die Funktion mit drei Argumenten
;; aufgerufen wird, gibt das zweite die X-Breite und das dritte die Höhe an.
;;
;; Diese Funktion ruft die wc/set-block Funktion *IN* der for-Schleife auf.
(defn build-wall-1 [at & [xs ys]]
  (for [x (range (or xs 2))         ;; Schleife über x und y, ergibt die (x,y)-Positionen. Default-Logik: falls xs nicht nil/false ist, 
        y (range (or ys 2))]        ;; liefert die or-Form 2. Sonst den Wert von xs. Ebenso für ys
    (wc/set-block
     (wc/add at [x y 0])
     :gold-block)))

(build-wall-1 (wc/player))
(build-wall-1 (wc/player) 3)
(build-wall-1 (wc/player) 1 4)

;; Diese Funktion liefert eine Liste mit Maps der Form {:x x :y y}, wobei x die
;; Wert 0 bis xs-1 und y die Werte 0 bis ys-1 annimmt.  
;; Cool: diese Funktion können wir testen, ohne irgendwelche Blöcke zu setzen.
(defn wall-positions [xs ys]
  (for [x (range xs)
        y (range ys)]
    {:x x :y y}))

;; Baut an der Position `at` eine Wand aus Gold. Die X-Breite der Mauer ist
;; default-mäßig 2, die Höhe ist ebenfalls default-mäßig 2. Die Funktion kann
;; optional mit `:xs <xs>` und/oder `:ys <ys>` aufgerufen werden, um die
;; X-Breite und die Höhe explizit zu steuern.
;;
;; Diese Funktion ruft die Funktion `wall-positions` auf, um die Positionen der
;; Wand zu berechnen und ruft dann die Funktion `wc/set-blocks` *EINMALIG* auf,
;; um alle Blöcke zu setzen.
(defn build-wall-2 [at & {:keys [xs ys]         ;; &-Rest -- dadurch optionale Angabe
                          :or {xs 2 ys 2}}]     ;; durch :or Angabe der Default-Werte
  (let [positionen (->>                         ;; Thread-Last-Operator: Ergebnisse einer Form in die folgende Form "durchschleusen"
                    (wall-positions xs ys)      ;; Positionen berechnen
                    (map #(conj % [:z 0])))]    ;; den Positionen den Eintrag [:z 0] zufügen
    (wc/set-blocks
     positionen
     {:anchor at
      :material :gold-block})))

(build-wall-2 (wc/player))
(build-wall-2 (wc/player) :xs 3)
(build-wall-2 (wc/player) :xs 1 :ys 4)
(build-wall-2 (wc/player) :ys 4)

;; Unser erster Versuch, die Blöcke mit einer Verzögerung von einer Sekunde zu
;; setzen. Das Funktioniert aber so nicht, weil das wc/set-block erst seine
;; "Wirkung" entfaltet, wenn die Funktion "fertig ist". Wir schlafen also
;; während die Funktion ausgeführt wird, aber nachdem die Funktion fertig ist,
;; erscheinen alle Blöcke gleichzeitig. Minecraft zeigt die Blöcke erst an,
;; *nachdem* die Funktion beendet ist.
(defn build-wall-3 [at & [xs ys]]
  (for [x (range (or xs 2))        ;; Schleife über x und y
        y (range (or ys 2))]
    (do (println "schalfe....")    ;; ein do-Block wertet die einzelnen Formen darin der Reihe nach aus.
        (Thread/sleep 1000)        ;; eine Sekunde warten
        (println "aufgewacht!")
        (wc/set-block              ;; Block setzen
         (wc/add at [x y 0])
         :gold-block))))

(build-wall-3 (wc/player) 2 2)

;; build-wall-4 berechnet erst die Liste von (x,y)-Positionen und wendet darauf
;; max-indexed an. Diese ruft unsere anonyme Funktion mit *zwei* Argumenten auf:
;; einer fortlaufenen Zahl 0,1,2,3... (dem "Index") und dazu nacheinander die
;; (x,y)-Postionen.
;;
;; Die Funktion, die die eigentliche Arbeit macht, nutzt wc/run-task-later, um
;; einem "Scheduler" zeitverzögerte Arbeitsaufträge (Tasks) zu übergeben. Der
;; Zeitversatz ergibt sich aus dem Index-Wert. Der Task ist wiederum eine
;; anonyme Funktio, die wc/set-block aufruft.
;;
;; Durch diesen Ansatz, wartet die Funktion build-wall-4 nicht darauf, dass die
;; Tasks ausgeführt werden: nur das Einstellen dieser Tasks wird in der Funktion
;; erledigt. Die Tasks werden anschließend vom Scheduler mit der eingestellten
;; Verzögerung ausgeführt.
(defn build-wall-4 [at & {:keys [xs ys]       ;; &-Rest -- dadurch optionale Angabe
                          :or {xs 2 ys 2}}]   ;; Default-Werte durch :or
  (let [at (wc/loc at)]                       ;; Da sich `at` (die Spielerposition) über die Zeit ändert, machen wir eine Map raus, die sich nicht ändert!
    (->>                                      ;; Threading-Last-Operator: Ergebnisse werden nacheinander "durchgereicht"
     (wall-positions xs ys)                   ;; Positionen berechnen
     (map-indexed                             ;; map mit Index
      (fn [i {:keys [x y]}]                   ;; wird von map-indexed mit (<index> <position>) aufgerufen (<position> wird destructured).
        (wc/run-task-later                    ;; Task einstellen
         #(wc/set-block                       ;; der Task (eine anonyme Funktion, die vom Scheduler ohne Argument aufgerufen wird)
           (wc/add at [x y 0])                ;; Block setzen
           :gold-block)
         (* 5 i))))                           ;; Zeitversatz = 5 * <index> Ticks
     (dorun))))                               ;; map-indexed liefert eine "lazy list". Diese "forcen" wir mit `dorun`

(build-wall-4 (wc/player) :xs 10 :ys 5)

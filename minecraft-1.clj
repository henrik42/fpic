(ns minecraft-1
  (:require [lambdaisland.witchcraft :as wc]))

(wc/set-game-rule :do-daylight-cycle false)
(wc/set-time 1000)

(def me (wc/player "hugo" #_ "dein-name"))
(def standort (wc/loc me))

;; Aufgabe 1: Definiere `positionen` so, dass 10 Gold-Blöcke übereinander am
;; `standort` gesetzt werden (eine _Säule_ der Höhe 10). Nutze dazu die
;; Funktionen `map` und `range`.

;; Aufgabe 2: Definiere `positionen` so, dass eine _Wand_ von 10x5 (Höhe 10,
;; Breite 5) Gold-Blöcke am `standort` gesetzt werden. Nutze dazu die Funktionen
;; `for` und `range`.

;; Aufgabe 3: Definiere `positionen` so, dass eine Säule der Höhe 8 entsteht.
;; Dabei sollten sich die Blocktypen :gold-block, :dragon-egg und
;; :orange-concrete abwechseln. Nutze dazu die Funktionen `take`, `map`, `range`
;; und `cycle`.

(def positionen [[0 0 0] [0 1 0]])

(def positionen [{:x 0 :y 0 :z 0 :material :gold-block}
                 {:x 0 :y 1 :z 0 :material :orange-concrete}])

(wc/undo!)

(wc/set-blocks
 positionen
 {:anchor standort
  :material :orange-concrete #_ :gold-block})


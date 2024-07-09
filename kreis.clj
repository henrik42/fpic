;; Wir wollen einen Kreis "rastern". D.h., wir berechnen, aus welchen Pixel das
;; "gerasterte" Bild eines Kreises mit einem gegebenen Radius besteht. Das
;; Berechnungsverfahren dazu liefert die [Methode von
;; Horn](https://de.wikipedia.org/wiki/Rasterung_von_Kreisen#Methode_von_Horn).
;; 
;; Der folgende [Pseudocode](https://de.wikipedia.org/wiki/Pseudocode)
;; beschreibt, wie die Pixel berechnet werden. Das Verfahren berechnet nur einen
;; 1/8-Kreisbogen. Die anderen 7/8 des Kreises ergeben sich aus
;; Symmetriebetrachtungen.  
;; 
;; Der Radius des Kreises wird durch den Wert `r` beschrieben. Das
;; Berechnungsverfahren nutzt die Variablen `d`, `x` und `y`.
;;
;; Zu Beginn werden die Variablen mit Startwerten _initialisiert_. Die
;; Berechnung der Pixel erfolgt in einer Scleife mit dem Abbruch-Kriterium `y >
;; x`.
;;
;; In jedem Schleifendurchlauf werden die Werte `x` und `y` direkt als die
;; Koordinaten der Pixel verwendet, die in diesem Schleifendurchlauf berechnet
;; werden.

;; ------------------------------------------------------------------------------ 
;; d = −r
;; x = r
;; y = 0
;; Wiederhole bis y > x
;;     Pixel (x, y) sowie symmetrische Pixel einfärben
;;     d = d + 2×y + 1
;;     y = y + 1
;;     Wenn d > 0
;;         d = d - 2×x + 2
;;         x = x - 1
;; ------------------------------------------------------------------------------ 

;; Aufgabe 1: schreibe eine Funktion `(defn kreis-print-loop [r] ,,,)`, die die
;; Pixel in einer `loop-recur`-Schleife berechnet und via `println` ausgibt.
;;
;; Aufgabe 2: schreibe eine Funktion `(defn kreis-loop [r] ,,,)`, die die Pixel
;; in einer `loop-recur`-Schleife berechnet und als Vektor `[[x1 y1] [x2 y2]
;; ,,,]` liefert.
;; 
;; Aufgabe 3: schreibe eine Funktion `(defn kreis-reduce [r] ,,,)`, die die
;; Pixel mit Hilfe von `reduce` berechnet und als Vektor `[[x1 y1] [x2 y2] ,,,]`
;; liefert.

(defn kreis-print-loop [r])

(defn kreis-loop [r])

(defn kreis-reduce [r])
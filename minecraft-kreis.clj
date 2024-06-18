(require '[lambdaisland.witchcraft :as wc]
         '[clojure.core.async :as async])

(defn set-blocks
  "Setzt die Blöcke (Offset zu anchor)."
  [anchor blocks material]
  (wc/set-blocks
   blocks
   {:anchor anchor
    :material material}))

(defn kreis 
  "Berechnet und liefert die 'Pixel' zu einem Kreis mit dem angegebenen Radius.
   vgl. https://de.wikipedia.org/wiki/Rasterung_von_Kreisen#Methode_von_Horn"
  [radius]
  (loop [d (- radius)
         x radius
         y 0
         pixel []]
    (if (> y x)
      pixel
      (let [pixel (conj pixel
                        [x 0 y] [x 0 (- y)]
                        [(- x) 0 y] [(- x) 0 (- y)]
                        [y 0 x] [y 0 (- x)]
                        [(- y) 0 x] [(- y) 0 (- x)])
            d (+ d (* 2 y) 1)
            y (inc y)]
        (if (pos? d)
          (recur (+ d (* -2 x) 2) (dec x) y pixel)
          (recur d x y pixel))))))

(comment

  (do
    (wc/set-time 1000)
    (wc/set-game-rule :do-daylight-cycle false)
    (wc/set-game-rule :do-weather-cycle false)
    (wc/fly! (wc/player)))

  ;; Zeichnet einen Kreis mit Radius 10.
  (set-blocks
   (wc/xyz-round (wc/loc (wc/player)))
   (kreis 10)
   :gold-block)
  
  ;; `set-blocks` setzt die Blöcke in einem Aufruf. Wenn man sehr viel Blöcke
  ;; auf diese Weise setzt, blockiert die Game-Loop, der Server wird überladen
  ;; und es kommt zu technischen Fehlen im Server.
  ;;
  ;; Daher verteilen wir die Last: die Pixel für den Kreis berechnen wir "in"
  ;; dem Server-Thread/Game-Loop (das könnte man auch noch auslagern). 
  ;;
  ;; Dann schreiben wir die Pixel asynchron (onto-chan!!) - d.h. nicht
  ;; blockierend in den Channel `pixels`. 
  ;;
  ;; Und wir starten eine `go-loop`, die die Pixel aus `picxels` liest und pro
  ;; Pixel via `run-task` einen Pixel setzt (also in der Game-Loop).
  ;;
  ;; Dadurch sollte die Last auf die Server-Ticks verteilt werden, so dass der
  ;; Server nicht überlastet. 
  ;;
  ;; Leider scheint das noch nicht richtig zu funktionieren. Der Server gerät
  ;; weiterhin in Überlast. Analyse steht noch aus.
  (let [pixels (async/chan)
        sync (async/chan)
        radius 500
        pos (wc/add [radius 0 0] (wc/xyz-round (wc/loc (wc/player))))]
    (async/onto-chan!! pixels (shuffle (kreis radius)))
    (async/go-loop []
      (when-let [pixel (async/<! pixels)]
        (wc/run-task 
         #(do (set-blocks pos [pixel] :orange-concrete)
              (async/>!! sync :go)))
        (async/<! sync)
        (recur))))
  )

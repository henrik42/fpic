(ns minecraft-3
  (:require [lambdaisland.witchcraft :as wc]))

;; Wir erzeugen eine Kuh an der Spieler-Location.
(def cow (wc/spawn (wc/player) :cow))

;; Ermittelt die Y-Position der Entity `e`. Falls diese kleiner als 80 ist,
;; erfährt die Entity eine Y-Geschwindigkeit von 0.1 und eine zufällige X- und
;; Z-Geschwindigkeit [-0.25 ... 0.25].
(defn excel-entity [e]
  (let [{vx :x vy :y vz :z :as v} (wc/loc (.getVelocity e))
        {:keys [x y z] :as loc} (wc/loc e)]
    (when (< y 80)
      (.setVelocity e (wc/vec3 (- (rand 0.5) 0.25) 
                               0.1 
                               (- (rand 0.5) 0.25))))))

;; Listener-Funktion, die mit dem Event aufgerufen wird. Falls es sich bei der
;; betroffenen Entity um die aktuelle (als letztes gespawnte) Kuh handelt, wird
;; `excel-entity` mit der Kuh aufgerufen.
(defn cow-fly [{entity :entity}]
  (if (= cow entity)
    (excel-entity cow)))

;; Wir registrieren unseren :entity-move Event-Listener.
(wc/listen! :entity-move :cow-fly #'cow-fly)
(wc/unlisten! :entity-move :cow-fly)


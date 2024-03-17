(ns minecraft-2
  (:require [lambdaisland.witchcraft :as wc]
            [lambdaisland.witchcraft.events :as events]))

(comment
  (wc/set-game-rule :do-daylight-cycle false)
  (wc/set-time 1000))

;; Mit `wc/listen!` registrieren wir einen "Listener" (eine Funktion), der vom
;; Minecraft-Server immer dann aufgerufen wird, wenn ein :player-interact
;; stattfindet. Die Funktion gibt den "Event" (eine Map) aus, so dass wir uns
;; anschauen können, welche Informationen wir durch den Event erhalten. Es gibt
;; viele verschiedene Event-Typen. Die folgende Form gibt alle Event-Typen
;; sortiert aus, die Minecraft kennt.
(comment 
  (-> events/events keys sort prn))

(wc/listen! :player-interact
            :print-event
            (fn [e]
              (prn "event:" e)))
(wc/unlisten! :player-interact :print-event)

;; Diese Funktion erzeugt eine Explosion, wenn der Spieler mit der linken
;; Maustaste klickt. Wenn auf einen Block geklickt wird, wird eine Explosion der
;; Stärke 1 an dem Block erzeugt. Wenn in die Luft geklickt wird, wird eine
;; Explosion der Stärke 10 in einem Abstand von 15 Blöcken vor dem Spieler
;; erzeugt.
(defn explosion-at-click [e]
  (let [action (:action e)
        clicked-block (:clickedBlock e)]
    (condp = action
      :left-click-block (wc/create-explosion clicked-block 1)
      :left-click-air (wc/create-explosion (wc/in-front-of (:player e) 15) 10)
      (println "unknown action " action e))))

(wc/listen! :player-interact :boom #'explosion-at-click)
(wc/unlisten! :player-interact :boom)

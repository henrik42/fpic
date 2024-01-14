;; Diese Datei solltest du mit VSCode öffnen. In VSCode solltest du die
;; Calva-Erweiterung installiert haben. 
;;
;; Diese Datei enthält Clojure-Code, den du "in" einem laufen Minecraft-Server
;; ausführen kannst. Du musst also zuerst den Minecraft-Server inkl. dem
;; Witchcraft-Plugin starten. Das Plugin öffnen dann auf Port 25555 einen
;; nREPL-Server. Mit diesem kannst du dich aus VSCode/Calva heraus verbinden.
;;
;; Drücke dazu CTRL-ALT-c CTRL-ALT-c und wähle aus der Liste, die sich dann
;; öffnet, den Eintrag "Generic". Als Host gibt du dann "localhost:25555" an.
;;
;; Der Clojure-Code in dieser Datei ist so aufgebaut, dass du die ganze Datei
;; mit CTRL-ALT-c ENTER "evaluieren" kannst. Dadurch werden aber nur ein paar
;; Namespaces geladen und ein paar Funktionen definiert. Wirklich passieren tut
;; aber noch nichts.
;;
;; In der Datei wirst du (comment ,,,) Formen finden. Diese habe ich
;; vorbereitet, damit du sie nach belieben auswerten kannst. Das machst du mit
;; ALT-ENTER.
;;
;; Du kannst natürlich auch selber Clojure-Formen in die Datei schreiben. 
;; 
;; Tipp: du solltest deine Formen ebenfalls in (comment ,,,) Formen einbetten.
;; Wenn du sie außerhalb der (comment ,,,) Form in die Datei einfügst, würden
;; sie beim nächsten Mal, wenn du die ganze Datei auswertest (vgl. oben)
;; ebenfalls ausgeführt/ausgewertet werden und dann kommt es vielleicht zu einem
;; Fehler.

;; Mit :require laden wir andere Namespaces, deren Funktionen wir dann über
;; einen Kurznamen (hier "wc") nennen/nutzen können.
(ns minecraft
  (:require [lambdaisland.witchcraft :as wc]
            [lambdaisland.witchcraft.shapes :as shapes]
            [lambdaisland.witchcraft.gallery.big-chicken :as chicken]))

;; Die englische Dokumentation zu lambdaisland.witchcraft findest du unter
;; https://cljdoc.org/d/com.lambdaisland/witchcraft/0.37.324/doc/readme
;; 
;; Leider sind nicht alle Funktionen in der Doku aufgeführt. Du kannst dir aber
;; den Clojure-Code unter https://github.com/lambdaisland/witchcraft anschauen.
;;
;; Die Funktion set-game-rule findest du z.B. hier:
;; https://github.com/lambdaisland/witchcraft/blob/main/src/lambdaisland/witchcraft.clj#L1919
(wc/set-game-rule :do-daylight-cycle false)

(wc/set-time 1000)

;; Wir definieren uns einen Namen (me) für jenen Spieler, unter dessen Namen du
;; dich mit dem Minecraft-Server verbunden hast. Ab jetzt können wir immer "me"
;; nutzen, wenn wir etwas mit diesem Spieler machen wollen.
(def me (wc/player "foobar"))

;; Wir merken uns, an welchem Ort wir gerade sind. Falls du die Datei
;; vollständig auswertest (vgl. oben), ist dies der Ort, an dem dein Spieler
;; gerade steht.
(def start-ort (wc/loc me))

(comment
  
  ;; Du kannst Blöcke setzen.
  ;; https://cljdoc.org/d/com.lambdaisland/witchcraft/0.37.324/api/lambdaisland.witchcraft?q=set-blocks#set-blocks
  (wc/set-blocks
   [[5 0 0 :water]]
   {:anchor me})

  ;; Um etwas rückgängig zu machen, nutze du (undo!)
  ;; https://cljdoc.org/d/com.lambdaisland/witchcraft/0.37.324/api/lambdaisland.witchcraft?q=undo%21#undo!
  (wc/undo!)

  ;; Es gibt verschiedene "Formen"
  ;; https://cljdoc.org/d/com.lambdaisland/witchcraft/0.37.324/api/lambdaisland.witchcraft.shapes#ball
  (wc/set-blocks
   (shapes/ball {:center [0 0 0]
                 :radius 14.5
                 :material :white-terracotta})
   {:anchor start-ort})

  ;; In der
  ;; https://cljdoc.org/d/com.lambdaisland/witchcraft/0.37.324/api/lambdaisland.witchcraft.gallery
  ;; findest du nicht nur Riesenhühner :-)
  (wc/set-blocks
   (chicken/chicken-shape (wc/add start-ort {:y 5})))

  )


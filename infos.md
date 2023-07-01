# Informationen

Dies ist eine lose, ungeordnete Ansammlung von Informationen, die für die
Programmier-AG hilfreich sein können.

* https://ericnormand.me/guide/how-to-install-clojure#windows:
  Installationsanleitung für Java und Leiningen (aber kein clj)

* https://4clojure.oxal.org/ : Übungen und Lösungen

* [Github-Access-Token für das geclonte Repo einrichten](https://levelup.gitconnected.com/fix-password-authentication-github-3395e579ce74)

* https://practical.li/clojure/

* https://en.wikipedia.org/wiki/Referential_transparency
 
* https://fachportal.lernnetz.de/sh/faecher/informatik.html

* https://clojure-arcade.com/ : eine Web-Anwendung, die sich über eine
  Web-Socket mit einem lokal laufenden Server verbindet. Den (Clojure-)Server
  lädst du dir über die Anwendung runter und musst sie dann selber starten.

* [What Every Computer Scientist Should Know About Floating-Point
  Arithmetic](https://docs.oracle.com/cd/E19957-01/806-3568/ncg_goldberg.html) :
  man sollte meinen, dass Computer besonders gut rechnen können. Aber gerade die
  Art und Weise, wie Computer mit Gleitkommazahlen umgehen, führt immer wieder
  zu großen Überraschungen, wenn Programmierer nicht verstehen, was überhaupt
  eine Gleitkommazahl ist. Ich denke, dieser Artikel ist nichts für die
  Mittelstufe, wohl aber für die Oberstufe.

* https://www.codewars.com/collections/clojure-4

* https://news.ycombinator.com/item?id=22087583: eine kontroverse Diskussion um
  die Frage, ob Kinder Programmieren lernen wollen/sollen und ob LISP/Clojure
  eine gute Wahl für so ein Unterfangen ist.

* https://kidscodecs.com/clojure/

* https://github.com/google/clojure-turtle : Eine Clojure-Anwendung/Bibliothek,
  die die
  [Logo-Programmiersprache](https://de.wikipedia.org/wiki/Logo_(Programmiersprache))
  implementiert.

* https://livebook.manning.com/book/get-programming-with-clojure/

* https://clojurebridgelondon.github.io/community-docs/docs/curriculum/ : ein
  Clojure-Curriculum (Englisch)

* http://www.clojure-buch.de/ : "Clojure - Grundlagen, Concurrent Programming, Java"

* https://www.learn-clojurescript.com/ : "Learn ClojureScript"

* https://de.wikipedia.org/wiki/Rosetta_Code

* https://lwhorton.github.io/2018/10/20/clojurescript-interop-with-javascript.html

* https://cljs.info/cheatsheet/

* https://www.learn-clojurescript.com/

## Notizen zu SCI

* https://borkdude.github.io/sci.web/

* https://babashka.org/scittle/

* https://codepen.io/Prestance/pen/PoOdZQw

* https://babashka.org/scittle/bookmarklet.html: eine Seite, mit der du dir
  Browser-Bookmarks erstellen kannst, die "etwas tun". Und das, was sie tun
  sollen, kannst du in eben dieser Seite in ClojureScript programmieren.

* Hier ein Gist: https://gist.github.com/henrik42/8ac2dcc80451e69d42859e21fbef38f1
* Und hier die Einbindung in Bookmarklet:
  https://babashka.org/scittle/bookmarklet.html?gist=henrik42/8ac2dcc80451e69d42859e21fbef38f1

* https://www.educative.io/answers/how-to-dynamically-load-a-js-file-in-javascript:
  wie lädt man JavaScript via JavaScript?
  
```
(eval '(+ 1 2 3)) ;=> 6

(defn speak [s]
  (.speak js/speechSynthesis 
    (doto (js/SpeechSynthesisUtterance. s)
      (aset 'pitch 5))))

(speak "Hallo. Guten Tag. Closchur ist eine tolle Programmiersprache.")

(let [name (js/prompt "Wie ist dein Name?")]
  (speak (str "Hallo " name "wie geht es dir?"))
  (js/alert (str "Hello " name)))

;; https://github.com/babashka/scittle/blob/main/src/scittle/core.cljs

(js/document.body.append
  (doto (js/document.createElement "script")
    (aset 'src "https://babashka.org/scittle/js/scittle.js")
    (aset 'async false)
    (aset 'type "text/javascript")))

(js/scittle.core.eval_string "(+ 1 2 3)")

(js/scittle.core.eval_script_tags)

(js/document.body.append
  (doto (js/document.createElement "script")
    (aset 'src "https://gist.githubusercontent.com/henrik42/8ac2dcc80451e69d42859e21fbef38f1/raw/")
    (aset 'async false)
    (aset 'type "application/x-scittle")))
```


```
(js/document.body.append
  (doto (js/document.createElement "script")
    (aset 'src "https://babashka.org/scittle/js/scittle.js")
    (aset 'async false)
    (aset 'type "text/javascript")))

(def script 
  (let [s (doto (js/document.createElement "script")
            (aset 'async false)
            (aset 'type "application/x-scittle"))]
    (js/document.body.append s)
    s))

(defn load-url [s]
  (aset script 'src s)
  (js/scittle.core.eval_script_tags))

(load-url "https://gist.githubusercontent.com/henrik42/8ac2dcc80451e69d42859e21fbef38f1/raw/3951e9c8e010b97abc7078a32b26caed48628e6c/foo.clj")

(load-url "https://gist.githubusercontent.com/henrik42/8ac2dcc80451e69d42859e21fbef38f1/raw/2491bf1995432469762eeab34ec4fb75e8d959cb/source-c.cljs")

(js/scittle.core.eval_string "foobar/foo")
```

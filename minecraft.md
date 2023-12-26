# Minecraft 

Wir wollen Clojure nutzen, um mit einem Minecraft-Server zu interagieren. 

Ausgangspunkt ist das Github-Repo
https://github.com/lambdaisland/witchcraft-workshop/. Du musst einige Dinge auf
deinem Computer vorbereiten, bevor wir richtig loslegen können.

## Java 17

Du benötigst mind. Java 17. Du kannst dir z.B. ein [Eclipse
Temurin](https://adoptium.net/de/temurin/releases/?os=windows&arch=x86&package=jdk&version=17)
installieren.

## Clojure CLI

Du benötigst die Clojure CLI.

Alternativ kannst du auch `deps.clj` nutzen. Das lässt sich [sehr leicht
installieren](https://github.com/borkdude/deps.clj#quickstart).

## Git

Du benötigst Git (z.B. [Git for Windows](https://gitforwindows.org/)).

## witchcraft-workshop

Am besten legst du dir ein Verzeichnis `c:\clojure\witchcraft\` an. Dann clonst
du dir Witch-Craft-Workshop Repo in das Verzeichnis.

```
cd c:\clojure\witchcraft\
git clone https://github.com/lambdaisland/witchcraft-workshop/
```

## Minecraft Server

```
bin/start-server
```

Das Skript lädt das
[Witchcraft-Plugin](https://github.com/lambdaisland/witchcraft-plugin) nach
`witchcraft-workshop\server\plugins\`. Sobald der Minecraft-Server startet, lädt
das Witchcraft-Plugin u.a.
[Witchcraft](https://github.com/lambdaisland/witchcraft) aus dem Internet runter
und startet einen [nREPL-Server](https://github.com/nrepl/nrepl) **in dem
Minecraft-Server**.

Die Witchcraft-Clojure-Bibliothek bietet dir eine API, um mit dem
Minecraft-Server zu interagieren. Dazu unten mehr.

## Minecraft Client

Du benötigst einen Minecraft Client.

Normalerweise wirst du schon den Minecraft Launcher von Microsoft installiert
haben. Über den Launcher installierst du den Minecraft Client Java Edition 1.18.

***ACHTUNG: Microsoft hat den Zugang auf die Minecraft-Ressourcen für den
Download auf HTTPS beschränkt. Daher funktioniert der Download des Clients
derzeit (26.12.2023; mclauncher-api 0.3.2) nicht. vgl.
https://github.com/tomsik68/mclauncher-api/issues/76. Du kannst dir aber lokal
das Repo https://github.com/LionZXY/mclauncher-api auschecken und lokal mit
Maven bauen. Das führe ich hier aber nicht im Detail aus.***

Falls du noch keinen Minecraft Client (und auch keinen Launcher) installiert
hast, kannst du den Client mit dem Skript `bin/install-client` installieren. Das
Skript wird eine Weile laufen und Dateien aus dem Internet herunter laden. In
diesem Fall nutzt du keinen Minecraft Launcher -- der Launcher ist in dem Skript
enthalten. Gestartet wird der Client in diesem Fall mit `bin/start-client`.

Tipp: in `witchcraft-workshop\client\options.txt` solltest du
`pauseOnLostFocus:false` setzen, damit du später mit `ALT-TAB` zwischen deinem
Minecraft-Client-Fenster und VSCode umschalten kannst, ohne dass das Spiel
automatisch pausiert.

## VSCode / Calva

Du benötigst [VSCode](https://code.visualstudio.com/download) mit der [Calva
Erweiterung](https://calva.io/getting-started/).

Anschließend kannst du dich mit dem nREPL-Server verbinden, der in dem Minecraft
Server läuft.

## Coding

Du hast nun:

* den Server gestartet
* den Client gestartet und dich mit dem Server verbunden
* VSCode gestartet

Nun kannst du mit VSCode die Datei
`witchcraft-workshop\repl_sessions\s01_warmup.clj` öffnen und anfangen, einzelne
Formen auszuwerten.

Als erstes solltest du die `ns`-Form auswerten, damit die Witchcraft-Namespaces
geladen werden.

Anschließend kannst du beliebige Formen auswerten. Du kannst z.B. ein Huhn über
die spawnen. Schau am besten mal nach oben, bevor du diese Form auswertest.

```
(wc/spawn (wc/add (wc/player) [0 20 0]) :chicken)
```

In `witchcraft-workshop\repl_sessions\` findest du weitere Code-Beispiele mit
vielen Erläuterungen (allerdings alles auf Englisch).


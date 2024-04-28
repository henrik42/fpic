# Minecraft 

Wir wollen Clojure nutzen, um mit einem Minecraft-Server zu interagieren. 

Ausgangspunkt ist das Github-Repo
https://github.com/henrik42/witchcraft-workshop. Du musst einige Dinge auf
deinem Computer vorbereiten, bevor wir richtig loslegen können.

## Java 17

Du benötigst mind. Java 17. Du kannst dir z.B. ein [Eclipse
Temurin](https://adoptium.net/de/temurin/releases/?os=windows&arch=x86&package=jdk&version=17)
installieren.

Du kannst das JDK über die MSI-Datei installieren. Du kannst aber auch das ZIP
runterladen und das Verzeichnis z.B. nach `C:\clojure\java` entpacken.

## Clojure CLI

Du benötigst die [Clojure CLI](https://clojure.org/reference/clojure_cli).

Alternativ kannst du auch `deps.clj` nutzen. Das lässt sich [sehr leicht
installieren](https://github.com/borkdude/deps.clj#quickstart).

Am einfachsten ist es, wenn du dir die ZIP-Datei
`https://github.com/borkdude/deps.clj/releases/download/v1.11.1.1435/deps.clj-1.11.1.1435-windows-amd64.zip`
runterlädtst. Darin findest du eine Datei (`deps`). Diese kopierst du nach
`C:\Users\<dein-name>\AppData\Local\Microsoft\WindowsApps`. Du solltest die
Datei unter dem Namen `clojure` in dem Verzeichnis ablegen.

Anschließend solltest du prüfen, ob das auch geklappt hat. Dazu öffnest du eine
CMD-Shell (sog. "Eingabeaufforderung") und gibst `clojure -M -e "(+ 1 2)"` ein.
Wenn alles richtig eingerichtet ist, wird das Programm gestartet und gibt das
Ergebnis `3` aus.

```
clojure -M -e "(+ 1 2)"
3
```

## Git

Du benötigst [Git](https://de.wikipedia.org/wiki/Git) (z.B. [Git for
Windows](https://gitforwindows.org/)). Wir brauchen Git nicht zwingend, um mit
Git-Repos zu arbeiten, sondern wir wollen vor allem die [Git
BASH](https://gitforwindows.org/) nutzen.

## witchcraft-workshop

Am besten legst du dir ein Verzeichnis `c:\clojure\` an. Dann klonst du dir das
Witch-Craft-Workshop Repo in das Verzeichnis.

```
cd c:\clojure\
git clone https://github.com/henrik42/witchcraft-workshop
```

## Minecraft Server

Den Server startest du wie folgt. Die Angabe
`<dein-java-installations-verzeichnis>` musst du mit dem
Installationsverzeichnis ersetzen, unter dem du Java installiert hast (vgl.
oben). Achte dabei auf die richtigen Slashes. Du musst hier die Forward-Slashes
(`/`) verwenden --- nicht die Backward-Slashes (`\`), die unter Windows
verwendet werden.

```
cd 'c:\clojure\witchcraft-workshop'
JAVA_CMD=/c/<dein-java-installations-verzeichnis>/bin/java ./bin/start-server
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
haben. Über den Launcher installierst du den Minecraft Client Java Edition
1.18.2.

In diesem Fall brauchst du den Client nicht zu installieren.

Falls du aber noch keinen Minecraft Client (und auch keinen Launcher)
installiert hast, kannst du den Client mit dem Skript `./bin/install-client`
installieren.

Das Skript rufst du wie folgt auf. Die Angabe `<dein-spitzname>` ersetzt du mit
einem Namen. Mit diesem Namen sehen dich später die anderen Spieler.

```
cd 'c:\clojure\witchcraft-workshop'
JAVA_CMD=/c/<dein-java-installations-verzeichnis>/bin/java ./bin/start-client <dein-spitzname>
```

Das Skript wird eine Weile laufen und Dateien aus dem Internet herunter laden.
In diesem Fall nutzt du keinen Minecraft Launcher -- der Launcher ist in dem
Skript enthalten.

Tipp: in `witchcraft-workshop\client\options.txt` solltest du
`pauseOnLostFocus:false` setzen, damit du später mit `ALT-TAB` zwischen deinem
Minecraft-Client-Fenster und VSCode umschalten kannst, ohne dass das Spiel
automatisch pausiert.

## VSCode / Calva

Du benötigst [VSCode](https://code.visualstudio.com/download) mit der [Calva
Erweiterung](https://calva.io/getting-started/).

Anschließend kannst du dich mit dem [nREPL](https://nrepl.org/nrepl/)-Server
verbinden, der in dem Minecraft Server läuft.

Dazu drückst du in VSCode `ctrl+alt+c` `ctrl+alt+c` (also zweimal
hintereinander) und wählst den Eintrag `Generic`. Als **_location_** gibst du
`localhost:25555` ein.

Weitere Infos findest du
[hier](https://calva.io/connect/#connecting-without-jack-in) (Englisch).

## Coding

Du hast nun:

* den Server gestartet
* den Client gestartet und dich mit dem Server verbunden
* VSCode gestartet
* und dich mit dem nREPL-Server verbunden

Nun kannst du mit VSCode die Datei
`witchcraft-workshop\repl_sessions\s01_warmup.clj` öffnen und anfangen, einzelne
Formen auszuwerten (`alt-enter`; siehe auch [Calvas
Keyboard-Shortcuts](https://calva.io/commands-top10/)).

Als erstes solltest du die `ns`-Form auswerten, damit die Witchcraft-Namespaces
geladen werden.

Anschließend kannst du beliebige Formen auswerten. Du kannst z.B. ein Huhn über
dir spawnen. Schau am besten mal nach oben, bevor du diese Form auswertest.

```
(wc/spawn (wc/add (wc/player) [0 20 0]) :chicken)
```

In `witchcraft-workshop\repl_sessions\` findest du weitere Code-Beispiele mit
vielen Erläuterungen (allerdings alles auf Englisch).


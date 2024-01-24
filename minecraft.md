# Minecraft 

Wir wollen Clojure nutzen, um mit einem Minecraft-Server zu interagieren. 

Ausgangspunkt ist das Github-Repo
https://github.com/lambdaisland/witchcraft-workshop/. Du musst einige Dinge auf
deinem Computer vorbereiten, bevor wir richtig loslegen können.

## Java 17

Du benötigst mind. Java 17. Du kannst dir z.B. ein [Eclipse
Temurin](https://adoptium.net/de/temurin/releases/?os=windows&arch=x86&package=jdk&version=17)
installieren.

Du kannst das JDK über die MSI-Datei installieren. Du kannst aber auch das ZIP
runterladen und das Verzeichnis z.B. nach `C:\clojure\java` entpacken.

## Clojure CLI

Du benötigst die Clojure CLI.

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

Du benötigst Git (z.B. [Git for Windows](https://gitforwindows.org/)).

## witchcraft-workshop

Am besten legst du dir ein Verzeichnis `c:\clojure\witchcraft\` an. Dann klonst
du dir das Witch-Craft-Workshop Repo in das Verzeichnis.

```
cd c:\clojure\witchcraft\
git clone https://github.com/lambdaisland/witchcraft-workshop/
```

## Minecraft Server

Du musst die beiden folgenden Zeilen in `bin/start-server` zufügen:

```
JAVA_CMD='C:\--dein-Pfad-zu-java\jdk-17.0.8+7\bin\java'
MEMORY=1G
```

Nun kannst du den Server starten:

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
haben. Über den Launcher installierst du den Minecraft Client Java Edition
1.18.2.

In diesem Fall brauchst du den Client nicht zu installieren.

Falls du aber noch keinen Minecraft Client (und auch keinen Launcher)
installiert hast, kannst du den Client mit dem Skript `bin/install-client`
installieren.

Bevor du das Skript startest, musst du folgende Anpassung machen:

* in `deps.edn` musst du die Version von `sk.tomsik68/mclauncher-api` auf
  `0.3.7` setzen (`sk.tomsik68/mclauncher-api {:mvn/version "0.3.7"}`).

Dann rufst du das Skript auf:

```
bin/install-client
```

Das Skript wird eine Weile laufen und Dateien aus dem Internet herunter laden.
In diesem Fall nutzt du keinen Minecraft Launcher -- der Launcher ist in dem
Skript enthalten.

Nachdem das Skript den Client installiert hat, musst du das Start-Skript
`bin/start-client` aufrufen.

Bevor du das Skript startest, musst du folgende Anpassung machen:

* in `bin\install-client` musst du die Zeile
  `JAVA_CMD='C:\--dein-Pfad-zu-java\jdk-17.0.8+7\bin\java'` zu Beginn zufügen
  (vgl. oben `bin/start-server`). Außerdem musst du am Ende das `sh` durch `tee
  run-client` ersetzen.

Nun rufst du das Skript auf:

```
bin/install-client hugo
```

Durch diesen Aufruf wird die Datei `run-client` erzeugt. In dieser Datei musst
du folgende Anpassungen machen:

* `-Djava.library.path` muss in Quotes (`'`) eingeschlossen werden.

```
'-Djava.library.path=C:\clojure\.......\client\versions\1.18.2\natives'
```

* Der Wert *hinter* `-cp` muss ebenfalls in Quotes (`'`) eingeschlossen werden.
  Schau ganz genau hin! Der Wert ist seehhhhrrr lang. Insgesamt müsste es am
  Ende etwa wie folgt aussehen. Hinter dem `-cp` fügst du das *öffnende* Quote
  ein und vor `net.minecraft.client.main.Main` fügst du das *schließende* Quote
  ein.

```
-cp 'C:\.......client\versions\1.18.2\1.18.2.jar' net.minecraft.client.main.Main...
```

Tipp: in `witchcraft-workshop\client\options.txt` solltest du
`pauseOnLostFocus:false` setzen, damit du später mit `ALT-TAB` zwischen deinem
Minecraft-Client-Fenster und VSCode umschalten kannst, ohne dass das Spiel
automatisch pausiert.

Nun kannst du den Client starten:

```
./run-client
```

Von nun an nutzt du nur `bin/start-server` und `./run-client`. Die anderen
Sachen brauchst du nicht jedes Mal zu wiederholen.

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


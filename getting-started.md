# Getting Started

[Clojure](https://clojure.org/) ist in
[Java](https://de.wikipedia.org/wiki/Java_(Programmiersprache)) programmiert.
Die Java-Quellen kannst du dir [auf Github](https://github.com/clojure/clojure)
anschauen.

Um Java-Programme (und damit eben auch Clojure-Programme) auszuführen, benötigst
du die [Java Virtual Machine
(JVM)](https://de.wikipedia.org/wiki/Java_Virtual_Machine).

> Neben (JVM-)Clojure (also Clojure, das auf der der JVM läuft), gibt es
> verschiedene Clojure-Abkömmlinge, z.B.
> [ClojureCLR](https://github.com/clojure/clojure-clr),
> [ClojureScript](https://clojurescript.org/) und den [Small Clojure
> Interpreter](https://github.com/babashka/sci). Wir schauen uns hier aber nur
> das JVM-Clojure an.

Die JVM ist in dem [Java Development
Kit](https://de.wikipedia.org/wiki/Java_Development_Kit) enthalten. Du solltest
also auf dem Computer, auf dem du Java und Clojure nutzen möchtest, ein JDK
installieren. Es gibt eine ganze Reihe von JDKs bzw.
[OpenJDK-Varianten](https://de.wikipedia.org/wiki/OpenJDK#OpenJDK-Varianten).

# Java/JDK installieren

Prüfe als erstes, ob auf dem Computer schon Java installiert ist. 

> Ich beschreibe hier nur die Installation unter Windows.

Öffne dazu eine CMD-Shell (wird unter Windows auch *Eingabeaufforderung*
genannt) oder eine *Windows PowerShell*. Dann gibst du `java -version` ein.

Falls Java schon installiert ist, sollte das etwa wie folgt aussehen. Falls die
ausgegebene Version mindestens eine 1.8 ist, hast du eine passende Java-Version
und du kannst mit dem nächsten Abschnitt weitermachen (es spielt keine Rolle,
welche JDK-Variante du nutzt).

```
> java -version
openjdk version "12" 2019-03-19
OpenJDK Runtime Environment (build 12+33)
OpenJDK 64-Bit Server VM (build 12+33, mixed mode, sharing)
```

Falls Java nicht installiert ist, sieht die Ausgabe wie folgt aus:

```
> java -version
Der Befehl "java" ist entweder falsch geschrieben oder
konnte nicht gefunden werden.
```

Oder falls du die PowerShell nutzt:

```
PS> java -version
java : Die Benennung "java" wurde nicht als Name eines Cmdlet, einer Funktion, einer Skriptdatei oder eines
ausführbaren Programms erkannt. Überprüfen Sie die Schreibweise des Namens, oder ob der Pfad korrekt ist (sofern
enthalten), und wiederholen Sie den Vorgang.
In Zeile:1 Zeichen:1
+ java -version
+ ~~~~
    + CategoryInfo          : ObjectNotFound: (java:String) [], CommandNotFoundException
    + FullyQualifiedErrorId : CommandNotFoundException
```

In diesem Fall musst du ein JDK installieren. 

> Du kannst ein JDK deiner Wahl installieren. Ich beschreibe hier die
> Installation von [Adoptium
> (AdoptOpenJDK)](https://de.wikipedia.org/wiki/OpenJDK#Adoptium_(AdoptOpenJDK)).

Unter https://adoptium.net/de/ findest du einen Download für eines der aktuellen
JDKs. Bei dem Download handelt es sich um eine
[Windows-MSI-Datei](https://de.wikipedia.org/wiki/Windows_Installer). Nachdem
der Download abgeschlossen ist, öffnest du die heruntergeladene Datei (z.B.
durch einen Doppelklick) und startest dadurch den Installationsdialog. Folge
dann den Anweisungen.

Nachdem du die Installation durchgeführt hast, prüfst du, ob alles geklappt hat,
indem du wie oben beschrieben eine CMD-Shell öffnest und `java -version`
eingibst.

# Clojure installieren

> Eigentlich braucht Clojure überhaupt nicht __installiert__ zu werden. Da
> Clojure in Java programmiert ist und Java-Programme in kompilierter Form (also
> nicht als Java-Quelltext) als
> [JAR-Datei](https://de.wikipedia.org/wiki/Java_Archive) veröffentlicht werden,
> benötigst du nur eine einzige Datei:
> [clojure-1.8.0.jar](https://repo1.maven.org/maven2/org/clojure/clojure/1.8.0/clojure-1.8.0.jar)
> (das ist die JAR-Datei für Clojure Version 1.8.0). Allerdings werden wir neben
> dem Kern von Clojure (also jenem Teil, der in Java programmiert ist) auch noch
> weitere Dinge (u.a. sog. Bibliotheken) nutzen, die in Java und/oder Clojure
> programmiert sind. Und es wäre sehr lästig, diese Dinge in Form von
> JAR-Dateien alle einzeln "zu Fuß" von den Servern, wo diese veröffentlicht
> sind, herunter zu laden. Daher gibt es Programme, die dich dabei unterstützen,
> (a) Clojure zu programmieren und (b) auszuführen und die auch (c) den Download
> von Dingen/JAR-Dateien durchführen, die du nutzen möchtest.

## Clojure 1.8.0 zu Fuß installieren

## Leiningen

Leiningen ist ein ein Programm, mit dem du sog. Tasks (also Aufgaben)
ausführen/erledigen kannst. Es gibt eine ganze Reihe von Tasks, die du nutzen
kannst und es ist auch möglich, mit Clojure selber solche (Leiningen-)Tasks zu
programmieren. 

## Clojure clj

Das `clj` Programm ist das _offizielle_ Clojure CLI (Command Line Interface) für
Clojure. Es ist relativ neu. Mit `clj` kannst du (genau wie mit Leiningen)
Clojure Programme ausführen und Bibliotheken, die du nutzen möchtest, herunter
laden. Aber `clj` kann noch viel mehr (darauf gehen wir hier aber nicht ein).

Du wirst im Internet viele ältere Beispiele zur Verwendung von Clojure finden,
die Leiningen erwähnen. Neuere Sachen nutzen jedoch verstärkt `clj`. Daher
solltest du dieses Tool auf alle Fälle installieren.

## deps.clj

Das `clj` Tool unter Windows zu installieren, war in der Vergangenheit etwas
sperrig. Daher wurde das Tool `deps.clj` geschaffen. Die Installation ist sehr
einfach und der Erschaffer dieses Tools bemüht sich, das Tool so zur Verfügung
zu stellen, dass es sich genau so verhält wie `clj`.

Falls du also Probleme hast, `clj` zu installieren, kannst du als Alternative
`deps.clj` nutzen.


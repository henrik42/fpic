# Inhalte

> Anmerkungen zu den Inhalten: der folgende Text ist nicht dazu geeignet, als
> Skript von oben nach unten durchgelesen oder durchgearbeitet zu werden. Viele
> Ausführungen sind zu knapp, andere enthalten wiederum viele Fachausdrücke, die
> du nicht unbedingt verstehen musst, um das Programmieren mit Clojure zu
> lernen. Der Text soll eher mir als Leiter der AG als Gedächtnisstütze und
> Rahmen dienen. Während der AG werden wir dann auch spontan andere Sachen
> hinzunehmen und bestimmt auch Teile auslassen.

## Einführung

* Was macht ein [Computer](https://de.wikipedia.org/wiki/Computer)?
* Was ist [Software](https://de.wikipedia.org/wiki/Software)?
* Was ist [Hardware](https://de.wikipedia.org/wiki/Hardware)?
* Was ist ein [Betriebssystem](https://de.wikipedia.org/wiki/Betriebssystem)?
* Was ist ein [BIOS](https://de.wikipedia.org/wiki/BIOS)?
* Was sind [Daten](https://de.wikipedia.org/wiki/Daten#Informatik)? 
* Welche Arten von Daten gibt es? Was ist ein
  [Datentyp](https://de.wikipedia.org/wiki/Datentyp#Elementare_Datentypen)?
* Was ist [Information](https://de.wikipedia.org/wiki/Information)?
* Was ist ein [Algorithmus](https://de.wikipedia.org/wiki/Algorithmus)?
* Was ist ein
  [(Computer-)Programm](https://de.wikipedia.org/wiki/Computerprogramm)?
* Was bedeutet es, ein Programm
  [auszuführen](https://de.m.wikipedia.org/wiki/Computerprogramm#%C3%9Cbersetzung_und_Ausf%C3%BChrung)?
* Was ist der Unterschied zwischen einem [Programm und dem zugehörigen
  Prozess](https://vfhcab.eduloop.de/loop/Vom_Programm_zum_Prozess)?
* [Was ist
  Programmieren](https://www.codefuchs.com/artikel/was-ist-programmieren/)?
* Was ist eine
  [Programmiersprache](https://de.wikipedia.org/wiki/Programmiersprache)?
* Was ist
  [Syntax](https://de.wikipedia.org/wiki/Syntax#Syntax_formaler_Sprachen)?
* Was ist
  [Semantik](https://de.wikipedia.org/wiki/Semantik#Semantik_in_der_Informatik)?

-------------------------------------------------------------------------------
## Clojure und die REPL

[Clojure](https://de.wikipedia.org/wiki/Clojure) ist eine Programmiersprache,
die einen [interaktiven
Programmierstil](https://en.wikipedia.org/wiki/Interactive_programming) erlaubt.
D.h., dass du während des Programmierens schon mit deinem **laufenden Programm**
**interagierst**: du schreibst es, du führst es aus, du änderst den Programmcode
(während das Programm läuft), du führst einen Teil erneut aus, du denkst nach,
wieso das Programm nicht tut, was du wolltest, du findest den Fehler, änderst
den Code erneut, probierst ihn abermals aus und -- et voilà -- dein Programm ist
fertig und fehlerfrei.

> Viele andere Programmiersprachen lassen diese Art des Programmierens nicht zu.
> Wir werden später noch sehen, was du alles mit Clojure auf diese Weise machen
> kannst. 

Was ist eine [Clojure-REPL](https://lambdaisland.com/guides/clojure-repls)?

Die REPL erlaubt dir, dein Programm direkt einzugeben und auszuführen. 

> Später werden wir sehen, dass es viel besser ist, anstatt der REPL einen
> [Texteditor](https://de.wikipedia.org/wiki/Texteditor) wie z.B. [Visual Studio
> Code](https://code.visualstudio.com/) zu nutzen und diesen [mit der REPL zu
> verbinden](https://calva.io/).

Die REPL funktioniert so: Du gibst eine **Form** (also dein Programm) ein, die
REPL **wertet** die Form **aus** und schreibt das **Ergebnis** in die Ausgabe.

**REPL** steht für:
* **Read**: eine **[Form](https://clojure.org/guides/learn/syntax)**
  [**einlesen**](https://clojure.org/reference/reader) (*to read*)
* **Eval**: die eingelesene Form
  [**auswerten**](https://clojure.org/reference/evaluation) (*to evaluate*). Die
  Auswertung ergibt einen **Wert**.
* **Print**: das Ergebnis der Auswertung (also den **Wert**) **ausgeben** (*to
  print something*)
* **Loop**: und das ganz **wiederholen** (*to loop*, *a loop*)

Es gibt verschiedene Möglichkeiten, dies **im Browser** auszuprobieren. Wir
brauchen dafür also vorerst **keine lokal installierte Software auf unserem
Computer**, sondern nur einen Browser und einen Internetzugang.

* https://tryclojure.org/ : du bekommst eine laufende REPL und kannst sofort
  Formen eingeben, die sofort ausgewertet werden. In der REPL kannst du ein
  Tutorial durcharbeiten.

* https://clojurescript.io/

* https://onecompiler.com/clojure

* https://www.jdoodle.com/execute-clojure-online/

* https://www.mycompiler.io/new/clojure

* https://tio.run/#clojure

* https://www.gitpod.io/ : Und eine
  [Anleitung](https://calva.io/get-started-with-clojure/) (Englisch).

* https://www.maria.cloud/

* https://github.com/fredoverflow/clopad

* http://kids.klipse.tech/ : Eine Programmier-Lehranwendung für Clojure. Der
  [Quellcode](https://github.com/viebel/kids.klipse.tech) ist open-source und
  kann angepasst werden.

-------------------------------------------------------------------------------
## Hello, world! 👋

Bevor wir überhaupt wirklich irgendetwas über Clojure lernen, wollen wir gleich
unser erstes
[Hello-World!](https://de.wikipedia.org/wiki/Hallo-Welt-Programm)-Programm
schreiben.

> Ich nutze https://tryclojure.org/ für die Beispiele. Dort solltest du sie also
> auch nachvollziehen und ausprobieren können.

```
(println "Hello, world! 👋")
```

In der REPL sieht das etwas so aus:

```
=> (println "Hello, world! 👋")
 Hello, world! 👋
 nil
=>
```

Der [Prompt](https://de.wikipedia.org/wiki/Prompt) `=>` zeigt dir an, dass die
REPL eine Eingabe von dir erwartet. Wir haben hier `(println "Hello, world!
👋")` eingegeben und dann die
[ENTER](https://de.wikipedia.org/wiki/Eingabetaste)-Taste gedrückt.

> Wenn du das auch ausprobieren möchtest, kannst du dir den Text einfach hier
> mit der Maus markieren, dann kopieren und in die REPL wieder einfügen.
> [Hier](https://unicode.org/emoji/charts/full-emoji-list.html) findest du
> weitere Emojis 🙂.

**Die REPL führt nun unser Programm aus**. In diesem Fall gibt sie den Text
`Hello, world! 👋`, aus, weil wir in unserem Programm die Funktion
[`println`](https://clojuredocs.org/clojure.core/println) nutzen.

Wenn die REPL fertig damit ist, unser Programm auszuführen, gibt sie noch den
**Wert** aus, der von unserem Programm als **Ergebnis** geliefert wurde. In
diesem Fall ist es der Wert `nil`.

> Don't panic! Diese ganzen Sachen machen bisher wenig Sinn und du brauchst sie
> auch noch nicht zu verstehen. Wir wollen uns hier nur etwas mit der REPL
> vertraut machen. Wir werden alles in Ruhe anschauen und ausprobieren.

-------------------------------------------------------------------------------
## Formen

> In der Literatur wirst du sowohl den Bezeichner **Form** als auch den
> Bezeichner **Expression**
> (**[Ausdruck](https://de.wikipedia.org/wiki/Ausdruck_(Programmierung))**)
> finden. Es gibt wohl einen [feinen
> Unterschied](https://stackoverflow.com/questions/17206657/are-lisp-forms-and-lisp-expressions-same-thing),
> den wir aber einfach ignorieren. Für uns ist eine Form/Expression etwas, das
> einen **Wert** hat (dazu unten mehr). Das unterscheidet sie von einer
> [Anweisung](https://de.wikipedia.org/wiki/Anweisung_(Programmierung)). 

Was sind Clojure [Formen](https://clojure.org/guides/learn/syntax)? 

> Die **Formen** in Clojure entsprechen den Wörtern und Sätzen in der
> natürlichen Sprache (das stimmt nicht 100%-tig, aber da wir hier nicht im
> Deutschunterricht sind, ist das ok für uns). Ein Clojure-Programm besteht aus
> einer **Folge** von Formen, d.h. einer Folge von Sätzen.

Wir fangen mit den **einfachen** (d.h. unstrukturierten, den
nicht-zusammengesetzten) **Formen** an. Diese entsprechen den Wörtern der
natürlichen Sprache (aus denen wir anschließend Sätze bilden können).

> *Einfach* bedeutet in diesem Zusammenhang, dass wir die Formen nicht weiter in
> ihre Bestandteile zergliedern können. Wir als Mensch können natürlich Zahlen
> weiter in ihre Ziffern zergliedern, aber aus Sicht von Clojure geht dies in
> diesem Fall nicht. In diesem Sinne sind z.B. Zahlen bzw.
> [Literale](https://de.wikipedia.org/wiki/Literal) für Clojure also **atomar**
> bzw.
> [**elementar**](https://de.wikipedia.org/wiki/Datentyp#Elementare_Datentypen)
> --- eben **einfach**.

> In dem legendären Video [Simple Made
> Easy](https://www.infoq.com/presentations/Simple-Made-Easy/) (Englisch!) geht
> Clojure-Erfinder [Rich Hickey](https://en.wikipedia.org/wiki/Rich_Hickey) auf
> den Unterschied zwischen __einfach__ (engl. *simple*) und __leicht__ (engl.
> *easy*) ein. *Simple* bedeutet in diesem Zusammenhang, dass Clojure aus
> __einfachen__ Teilen besteht, die sich jeweils nur um **einen Aspekt** kümmern
> und Dinge nicht unnötig vermischt werden. Diese Teile können dann wiederum
> durch **einfache** Mechanismen zu größeren Teilen zusammengesetzt werden
> ([Komposition](https://de.wikipedia.org/wiki/Assoziation_(UML)#Komposition)).
> Andererseits bedeutet **[komplex](https://de.wiktionary.org/wiki/komplex)**,
> dass Dinge, die eigentlich unabhängig von einander sein sollten/könnten,
> __unnötigerweise__ mit einander vermischt/verknotet sind, wodurch sie schwer
> zu verstehen sind und vor allem aufgrund ihrer *Verwobenheit* nicht so
> vielfältig verwendet werden können, als wenn sie eben *simple* wären.  
> [Talks von Rich
> Hickey](https://www.youtube.com/playlist?list=PLZdCLR02grLrEwKaZv-5QbUzK0zGKOOcr)
> findest du auf YouTube. Die Vorträge sind zwar alle auf Englisch und du wirst
> vielleicht nicht alles beim ersten Mal verstehen, aber vielleicht findest du
> trotzdem Freude daran.

### Zahlen

Dies sind Beispiele für Zahlen in Clojure: `-5`, `0`, `1`, `2`, `42`, `1.56`,
`4/2`, `5/3`

> Die Kommata zwischen den Zahlen gehören nicht zu den Zahlen. Ich nutze sie, um
> die Zahlen von einander zu trennen und die Lesbarkeit zu erhöhen.

**Übungen**:

* Starte einen Browser und navigiere zu https://tryclojure.org/
* Gib dort die Zahlen (*Formen*) `1`, `2` und `234` ein. Nach jeder Form musst
  du die *ENTER*-Taste drücken. Was passiert?
* Was passiert, wenn du mehrere Formen hintereinander durch Leerzeichen getrennt
  eingibst (z.B. `23 45 67`) und erst dann *ENTER* drückst? Was lernst du
  daraus?
* Was passiert, wenn du eine sehr große Zahl eingibst?
* Gib nun eine negative Zahl ein. Nutze dazu das vorangestellte Minuszeichen
  (`-`).
* Gib eine [Dezimalzahl](https://de.wikipedia.org/wiki/Dezimalsystem) mit zwei
  [Nachkommastellen](https://de.wikipedia.org/wiki/Nachkommastelle) ein. Als
  Dezimaltrenner musst du den Punkt (`.`) nutzen - nicht das Komma (`,`).

### Zeichenfolgen

Dies sind Beispiele für
[Zeichenfolgen](https://de.wikipedia.org/wiki/Zeichenkette) (englisch
*string*/*strings*): `"hallo"`, `"TOLL!"`, `" i j k "`

Zeichenfolgen werden inklusive der doppelten Anführungszeichen (`"`) am Anfang
und am Ende eingegeben.

**Übungen**:

* Gib die Zeichenfolge `"hallo"` ein. Wir sagen, dass diese Zeichenfolge aus 5
  Zeichen besteht. Die Zeichenfolge `"hallo"` hat die Länge 5.
* Gib die Zeichenfolgen `"TOLL!"`, `"A_B_$"`, `"a$b/c:_|<>#~'"` ein.
* Gib eine Zeichenfolge mit nur einem Leerzeichen ein.
* Gib eine Zeichenfolge mit zwei Leerzeichen ein.
* Gib eine leere Zeichenfolge ein (also eine, die aus keinem Zeichen besteht).
  Diese Zeichenfolge hat die Länge 0.
* Was passiert, wenn du am Ende die doppelten Anführungszeichen nicht angibst?
* Was passiert, wenn du zu Beginn die doppelten Anführungszeichen nicht angibst?

-------------------------------------------------------------------------------
## Formen und Werte

Die Form `"hallo"` ist die __äußere Darstellung__ der Zeichenfolge **hallo**.
**hallo** ist also der **Wert**, den wir über die Form `"hallo"` __eingeben__
können. 

Wenn die REPL den Wert **hallo** __ausgibt__, nutzt sie __dieselbe Form__
`"hallo"` dazu. 

Wir müssen also unterscheiden zwischen den **Werten** (Daten), die in unserem
Programm vorhanden sind und der äußeren **Form** (Repräsentation, Darstellung),
mit der wir diese Werte eingeben können und mit der diese Werte auch wieder
ausgegeben werden.

**Übungen**:

* Welche Formen (unabhängig von Clojure) kennst du, mit denen du die Zahl (also
  den Wert) **12** ausdrücken kannst? 

> Denk nochmal über die REPL nach. Die REPL liest deine Eingabe ein (*read*).
Deine Eingabe muss aus **Formen** bestehen. Nach dem Einlesen **wertet** die
REPL deine Formen **aus** (*eval*). Das **Ergebnis dieser Auswertung** ergibt
den **Wert** deiner Eingabe. Und dieser **Wert** wird von der REPL wiederum als
Form **ausgegeben** (*print*).  

-------------------------------------------------------------------------------
## Werte und Datentypen

Bisher haben wir **Zahlen** und **Zeichenfolgen** (sowohl als **Form** als auch
als **Wert**) kennen gelernt. Wir sprechen bei diesen verschiedenen *Arten von
Daten* (also den Werten) auch von **Datentypen**.

Clojure kennt verschiedene Zahl-Datentypen
([Ganzzahl](https://de.wikipedia.org/wiki/Ganze_Zahl), [Rationale
Zahlen](https://de.wikipedia.org/wiki/Rationale_Zahl),
[Gleitkommazahlen](https://de.wikipedia.org/wiki/Gleitkommazahl); dazu später
mehr) und auch verschiedene text-artige Datentypen:
[Zeichenfolgen](https://de.wikipedia.org/wiki/Zeichenkette) (*strings*),
[Zeichen](https://de.wikipedia.org/wiki/Char_(Datentyp)) (*character*).

Durch den jeweiligen Datentyp wird festgelegt, welche Werte wir mit diesem
Datentyp ausdrücken können (**Wertebereich**). Clojure erkennt beim Einlesen
(durch den [**Reader**](https://clojure.org/reference/reader)) an der **äußeren
Form**, welches der **zugehörige Datentyp** des mit der Form beschriebenen
Wertes ist.

* die Form `12` beschreibt der Ganzzahl-Wert **12** (d.h. die Form `12` wertet
  zu dem Ganzzahl-Wert **12** aus)
* die Form `"TOLL!"` beschreibt den String-Wert **TOLL!**.
* die Form `"12"` beschreibt den String-Wert **12**.

-------------------------------------------------------------------------------
## Boolean / Wahrheitswerte

Der Datentyp [**Boolean**](https://de.wikipedia.org/wiki/Boolean) (siehe auch
  [Wahrheitswerte](https://de.wikipedia.org/wiki/Wahrheitswert)) umfasst nur
  zwei mögliche Werte: **wahr** (`true`) und **falsch** (`false`).

**Übungen**:

* Gibt den Boolean-**Wert** **wahr** ein? Welche **Form** musst du nutzen?
* Welche Arten von Daten kennst du aus deinem Alltag? In welcher **Form** werden
  diese dargestellt? Tipp: schau mal in die Kontakte-App in deinem Smartphone -
  welche Dinge kannst du dort eingeben?

-------------------------------------------------------------------------------
## Zusammengesetzte Datentypen

Bisher haben wir nur *einfache* (unstrukturierte) **Datentypen** und die
zugehörigen **Werte** und **Formen** kennen gelernt. Clojure kennt aber auch
[*zusammengesetzte*](https://de.wikipedia.org/wiki/Datentyp#Zusammengesetzte_Datentypen)
(*strukturierte*, *komplexe*) Datentypen.

Ein zusammengesetzter Datentyp besitzt **Werte**, die als **Bestandteil** andere
**Werte** enthalten. 

> Zusammengesetzte Datentypen kannst du also nutzen, um z.B. Eigenschaften einer
> Person auszudrücken (das Geburtsdatum der Person, den Namen der Person, den
> Wohnort der Person).

Clojure kennt u.a. folgende zusammengesetzte Datentypen:

> **Anmerkung**: in Clojure gibt es den Datentyp
> **[Vektor](https://clojure.org/reference/data_structures#Vectors)**. Es gibt
> aber auch **Arrays**. Arrays sind keine Clojure-Datentypen, sondern sie
> gehören zu
> [Java](https://openbook.rheinwerk-verlag.de/javainsel/04_001.html#u4.1) und
> durch die sog. **[Java
> Interop](https://clojure.org/reference/java_interop#_arrays)** kannst du von
> Clojure aus die [Java-Arrays
> nutzen](https://clojuredocs.org/clojure.core/into-array). Ein Clojure-Vektor
> verhält sich so ähnlich wie ein Java-Array, aber es sind wirklich zwei völlig
> verschiedene Dinge. In der Mathematik ist ein
> [Vektor](https://de.wikipedia.org/wiki/Vektor) etwas anders als in Clojure.

* [Vektor](https://de.wikipedia.org/wiki/Array_(Datentyp)) (ich habe hier
  bewusst auf den Array-Datentyp verlinkt! Clojure-Vektoren sind **keine
  Arrays**): eine (ggf. leere) [Folge von
  Werten](https://clojure.org/reference/data_structures#Vectors) 

* [Liste](https://de.wikipedia.org/wiki/Liste_(Datenstruktur)) : eine (ggf.
  leere) [Folge von
  Werten](https://clojure.org/reference/data_structures#Lists).

* [Menge](https://de.wikipedia.org/wiki/Menge_(Datenstruktur)) (engl. *set*):
  eine (ggf. leere) [ungeordnete Sammlung von
  Werten](https://clojure.org/reference/data_structures#Sets), von denen
  **jeweils maximal ein Exemplar enthalten ist** (kein Wert darf mehrfach in der
  Menge enthalten sein).

* [Zuordnungstabelle](https://de.wikipedia.org/wiki/Zuordnungstabelle) (engl.
  *map*) : eine (ggf. leere) [Sammlung von
  Schlüssel-Wert-Paaren](https://clojure.org/reference/data_structures#Maps). Du
  kannst dir eine Map wie eine **zwei-spaltige Tabelle** vorstellen: in der
  **linken Spalte** steht jeweils der **Schlüssel** und in der **rechten
  Spalte** steht dann der (dem Schlüssel zugeordnete) **Wert**.

> Die Bezeichnung *Vektor* kennst du vielleicht aus dem Mathematikunterricht. In
> der Informatik wird auch von einem
> [**Tupel**](https://de.wikipedia.org/wiki/Tupel_(Informatik)) oder von einem
> [**Feld**](https://de.wikipedia.org/wiki/Feld_(Datentyp)) gesprochen. Alle
> drei Bedeutungen entsprechen nicht ganz dem, was ein Vektor in Clojure ist.

Die zusammengesetzten Datentypen schauen wir uns nun im Detail an. Genau so wie
bei den **einfachen** Datentypen werden wir auch im Falle der
**zusammengesetzten** Datentypen zwischen deren **Form** und deren **Werten**
unterscheiden. 

### Vektoren

Ein Vektor besteht aus einer (ggf. leeren) Folge von Werten. In Clojure werden
Vektoren mit eckigen Klammern (`[` ... `]`) geschrieben.

Vektoren werden von der REPL auf eine **besondere Weise eingelesen**: 

* Wenn die REPL beim *read* auf eine eckige öffnende Klammer (`[`) stößt,
  erkennt sie, dass hier eine **Vektor-Form** **beginnt**.

* Die REPL fährt damit fort, Formen einzulesen und **auszuwerten**. Die REPL
  **merkt** sich die **Werte** zu den ausgewerteten Formen. Denn dies sind ja
  die Elemente (Bestandteile) des Vektors, der hier gerade eingelesen wird.

* Sobald die REPL auf die eckige schließende Klammer (`]`) stößt, erkennt sie,
  dass hier die Vektor-Form endet. Die REPL erzeugt einen Vektor (einen
  **Vektor-Wert**), der als Elemente/Bestandteile jene Werte enthält, die seit
  der öffnenden Klammer durch die Auswertung der Formen als Werte aufgesammelt
  wurden. Dieser Vektor-Wert ist jener Wert, **zu dem die Vektor-Form
  auswertet**.

Der Vektor mit den **Elementen** **42** (Ganzzahl), **TOLL!** (String) und
**wahr** (Boolean) wird geschrieben als `[42 "TOLL!" true]`. Die Elemente werden
einfach durch Leerzeichen getrennt. Es wird kein Komma verwendet.

> Weiter unten werden wir sehen, dass du auch Kommata verwenden kannst. Aber es
> ist eben optional. D.h., du kannst es tun, aber du musst es nicht.

Weitere Beispiele für Vektoren:

* `[]` (der leere Vektor)
* `[true]`
* `["k" 2]` (Vektoren können Werte unterschiedlicher Datentypen enthalten)
* `[1 1 0]` (Vektoren können Werte mehrfach enthalten)
* `["A" ["x" "y"] 7]` (Vektoren können auch Vektoren enthalten)
* `[[[]] []]` (**geschachtelte** Datenstrukturen; engl. *nested*)
* Besprich mit deinem Tischnachbarn, an welcher Stelle (durch welche
Formulierung) in der obigen Erläuterung die Entstehung der **geschachtelte**
Datenstrukturen zu erkennen ist.

> Das Komma (`,`) ist in Clojure ein *white space*. D.h., es kann an Stelle
> eines **Leerzeichens** (` `) verwendet werden. Es ist erlaubt (z.B. zur
> besseren Lesbarkeit), in einem Vektor die Elemente durch Kommata zu trennen:
> `[1,2,"x",true]`.

**Übungen**:

* Zu was wertet die Form `,,,` aus? Wieso?
* Zu was wertet die Form `,[,],` aus? Wieso?
* Zu was wertet die Form `[, ,1,,2, ,]` aus? Wieso?
* Zu was wertet die Form `[1, 2, "x", true]` aus? Wieso?
* Wie sieht der Vektor aus (also die Form), mit den Elementen 'dein Vorname',
  'dein Nachname', 'dein Geburtsdatum', 'deine Körpergröße in cm' und 'deine
  Schuhgröße'? Welche Datentypen nutzt du? Wieso?

> Du kannst dir gerne irgendwelche Fantasie-Namen und Daten ausdenken. Du
> brauchst nicht dein echtes Geburtsdatum zu verwenden. Das fällt eindeutig
> unter den Datenschutz.

* Überlege dir zusammen mit deiner Tischnachbarin, welche verschiedenen
  Möglichkeiten ihr habt, ein Geburtsdatum mit Hilfe von Clojure-Datentypen
  darzustellen.

### Mengen

Eine Menge ist eine (ggf. leere) ungeordnete Sammlung von Werten, von denen
jeweils maximal ein Exemplar enthalten ist (kein Wert darf mehrfach in der Menge
enthalten sein).

In Clojure werden Mengen mit geschweiften Klammern mit einem vorangestellten
Lattenkreuz (engl. *hash*) (`#{` ... `}`) geschrieben.

Die Menge mit den **Elementen** **42** (Ganzzahl), **TOLL!** (String) und
**wahr** (Boolean) wird geschrieben als `#{42 "TOLL!" true}`. Die Elemente
werden durch Leerzeichen (und/oder Kommata) getrennt (wie bei den Vektoren).

Weitere Beispiele für Mengen:

* `#{}` (die leere Menge)
* `#{true}`
* `#{"k" 2}` (Mengen können Werte unterschiedlicher Datentypen enthalten)
* `#{"A" #{"x" "y"} 7}` (Mengen können auch Mengen enthalten)
* `#{#{1} #{} #{2}}` (**geschachtelte** Datenstrukturen; engl. *nested*)

> Mengen und Vektoren können Elemente beliebiger Datentypen enthalten. Somit
> können Vektoren auch Mengen enthalten und Mengen können Vektoren enthalten:
> `[[1 2 3] #{1 2 #{"a"} 3 [true #{"TOLL!"}]}]`.

**Übungen**:

* Zu was wertet die Form `#{,,,}` aus? 
* Zu was wertet die Form `#{,"a",}` aus? 
* Zu was wertet die Form `#{,"a","a",}` aus? Macht das Sinn?

### Zuordnungstabellen

Eine Zuordnungstabelle (engl. *map*) ist eine (ggf. leere) Sammlung von
**Schlüssel-Wert-Paaren**. Durch eine Map drückst du einen Zusammenhang zwischen
den jeweiligen **Schlüssel-Werten** und dem jeweils zugeordneten **Wert** aus.

In Clojure werden Maps mit geschweiften Klammern (`{` ... `}`) geschrieben. Die
**Schlüssel-Wert-Paare** werden als aufeinanderfolgende Elemente geschrieben.

Sowohl der **Schlüssel** des Schlüssel-Wert-Paares als auch der **Wert** des
Schlüssel-Wert-Paares sind **Werte**. D.h., dass du als Schlüssel auch z.B.
einen Vektor verwenden kannst.

Außerdem können die Schlüssel einer Map von verschiedenen Datentypen stammen.

> Wichtig: wir sagen, dass es sich um Schlüssel-Wert-Paare handelt, aber die
> Paare werden nicht gesondert *eingeklammert*. Du kannst die Paare zwar durch
> Kommata trennen, so dass sie sich beim Lesen besser von einander abheben, aber
> das ist kein Muss. Man hätte die Paare auch explizit durch z.B. spitze
> Klammern (`<` ... `>`) einklammern können, aber das wird in Clojure nicht
> gemacht.

Beispiele für Maps:

* `{}` (die leere Map)
* `{"HSV" 2 "FCB" 1 "St. Pauli" 2}` 
* `{1 "eins" "zwei" 2}`
* `{[1 2] 3 [5 6] 11 "nix" 0}`

**Übungen**:

* Zu was wertet die Form `{"x" 1 "X" 1}` aus?
* Zu was wertet die Form `{"x" 1, "X" 1}` aus?
* Zu was wertet die Form `{"x" 1, "x" 2}` aus? Macht das Sinn?
* Zu was wertet die Form `{["x" 1]}` aus? Macht das Sinn?
* Zu was wertet die Form `{["x" 1] ["x" 2]}` aus? Macht das Sinn?
* Wie könntest du mit Hilfe einer Map ausdrücken, dass der Merkur der nächste
  Planet zur Sonne ist, die Venus der zweitnächste usw.? Überlege dir **zwei**
  mögliche Darstellungen als Map. Tipp: zeichne dir eine Zuordnungstabelle auf
  ein Stück Papier.

-------------------------------------------------------------------------------
## Funktionen

Bisher haben wir verschiedene Arten von **einfachen** (Zahlen, Strings, Boolean)
und **zusammengesetzten** (Vektoren, Mengen, Maps) **Daten(-typen)**
kennengelernt und wie du diese über ihre **Form** beschreiben und ein- und
ausgeben kannst.

> Diese Daten sind sehr nützlich, aber sie sind **passiv**. Wir können mit ihnen
bestimmte Dinge ausdrücken (z.B. wie alt jemand ist oder wie viele Apps wir auf
unserem Smartphone installiert haben), aber wir können nichts **aktives** mit
ihnen tun. Wir haben bisher keinen Mechanismus, um mit diesen Werten z.B. zu
rechnen.

Nun wollen wir etwas mit den Werten dieser Datentypen **tun**. In Clojure nutzen
wir dazu [**Funktionen**](https://de.wikipedia.org/wiki/Funktion_(Mathematik)).

Aus dem Mathematikunterricht kennst du schon Funktionen:

```
f(x) = x + 1
```

Die Funktion **f** liefert zu jedem Zahl-Wert **x** den um eins erhöhten
Zahl-Wert. So liefert die Funktion **f** für den Wert **5** das Ergebnis **6**. 

```
f(5) = 6
```

In Clojure kannst dir eine Funktion als eine **Maschine** vorstellen, in die du
Werte hinein gibst (*du **rufst** die **Funktion** mit einem **Wert** auf*) und
aus der das **Ergebnis** der Funktion als **Rückgabewert** heraus kommt.

In dem oben aufgeführten Beispiel ist `x` der (formale) **Parameter** der
Funktion `f` und `5` ist das **Argument** bzw. der Argumentwert des
Funktionsaufrufs.

> Wir wollen Funktionen hier als etwas *aktives* (wie z.B. eine Maschine)
> betrachten. In der Mathematik sind Funktionen eine *passive* Beziehung
> zwischen Mengen. Wir werden unsere Funktionen **ausführen**, was auch
> bedeutet, dass wir dafür **Zeit** benötigen werden.

In Clojure gibt es die Funktion
[**inc**](https://clojuredocs.org/clojure.core/inc), die genau das gleiche tut
wie die oben aufgeführte Funktion **f**. Allerdings wird in Clojure der
**Funktionsaufruf** nicht als `inc(5)` geschrieben, sondern als `(inc 5)`. Wir
schließen also den Namen der Funktion mit in die Klammern ein.

> Diese Form ist an die [Polnische
> Notation](https://de.wikipedia.org/wiki/Polnische_Notation) angelehnt. Die
> Klammer-Ausdrücke/Formen werden auch
> [S-Expressions](https://en.wikipedia.org/wiki/S-expression) genannt.

Übung:

* Was liefert `(inc 8)`?

-------------------------------------------------------------------------------
## Funktionsaufruf als Form

Bisher haben wir Formen für u.a. Zahlen, Zeichenketten und Vektoren kennen
gelernt. Der Funktionsaufruf `(inc 5)` führt zwei neue **Arten von Formen** ein:

### Symbole

Die Funktion **inc** wird über das **Symbol** `inc` benannt. 

> Die Symbol-Form `inc` sieht fast so aus, wie die String-Form `"inc"`, nur dass
eben die Anführungszeichen (`"`) fehlen. Achte beim Lesen und Schreiben von
Clojure-Programmen immer darauf, was da ganz genau steht.
[Symbol-Formen](https://clojure.org/reference/reader#_symbols) dürfen nicht alle
Zeichen enthalten, die in Strings verwendet werden dürfen.

Die Funktion **inc** ist ein **Wert** des Datentyps **Funktion**. Über die Form
`inc` können wir diesen Wert (also diese Funktion) **nennen**, so dass wir sie
verwenden können.

> Denke nochmal darüber nach, was der Unterschied zwischen der Funktion und der
> Benennung der Funktion ist. Bei Zahlen nutzen wir Zahl-Formen wie z.B. `42`,
> um die Zahl **42** zu nennen. Bei Funktionen ist es fast genau so. Wir kommen
> später nochmal auf den Unterschied zwischen Symbol und Funktion zu sprechen.

Symbole (d.h. Symbol-Formen) werden also **anders ausgewertet**, als z.B.
Strings oder Zahlen. Wenn die REPL ein Symbol **&lt;sym>** (wie z.B. `inc`)
**auswertet**, schaut sie in einer bestimmten internen Zuordnungstabelle (Map)
unter dem Schlüssel **&lt;sym>** (also z.B. `inc`) nach, welchen zugeordneten
Wert sie dort findet. Dieser zugeordnete Wert ist jener Wert, der als Ergebnis
der Auswertung der Symbol-Form verwendet wird.

In dieser Zuordnungstabelle können den Symbolen (Schlüssel) beliebige
Werte/Datentypen zugeordnet sein --- nicht nur Funktionen.

> Diese Zuordnungstabelle wird **Namespace** genannt und wir lernen später mehr
> darüber.

Übung:

* Was erhältst du, wenn du `inc` eingibst? Wie unterscheidet sich das von den
  bisherigen Ein-Ausgaben?

* Was erhältst du, wenn du `a` eingibt? Macht das Sinn? Wie verstehst du die
  Fehlermeldung?

### Listen

Aber die (Funktionsaufruf-)Form `(inc 5)` führt noch eine weitere Form ein: die
**Liste**.

> Die Listen bzw. die vielen öffnenden und schließenden runden Klammern wirken
> auf viele Programmierer sehr befremdlich. Wir werden uns schnell daran
> gewöhnen und sie schließlich einfach akzeptieren und vielleicht sogar zu
> schätzen lernen. Clojure ist zwar ein
> [LISP](https://de.wikipedia.org/wiki/Lisp)-Dialekt, jedoch werden auch eckige
> und geschweifte Klammern verwendet (vgl. oben), wodurch die Lesbarkeit
> verbessert wird.

Eine Liste besteht aus einer (ggf. leeren) Folge von Werten (wie die Vektoren).
In Clojure werden Listen mit runden Klammern `(` ... `)` geschrieben.

Die Liste mit den **Elementen** **42** (Ganzzahl), **TOLL!** (String) und
**wahr** (Boolean) wird geschrieben als `(42 "TOLL!" true)`. Die Elemente werden
einfach durch Leerzeichen bzw. Kommata (vgl. oben) getrennt.

Weitere Beispiele für Listen:

* `()` (die leere Liste)
* `(true)`
* `("k" 2)` (Listen können Werte unterschiedlicher Datentypen enthalten)
* `(1 1 0)` (Listen können Werte mehrfach enthalten)
* `("A" ("x" "y") 7)` (Listen können auch Listen enthalten)
* `((()) ())` (**geschachtelte** Datenstrukturen; engl. *nested*)

Listen werden von der REPL auf eine **ganz besondere Weise behandelt**: 

* Zuerst wird die Listen-Form genau so ermittelt, wie es bei den anderen
  zusammengesetzten Formen der Fall ist (vgl. die Beschreibung oben zu den
  Vektoren). 

* Sobald die REPL den **Listen-Wert** ermittelt hat, nimmt sie an, dass das
  **erste Element** der Liste eine **Funktion** ist (vgl. oben). D.h., die
  **erste Form** in der Liste muss **zu einer Funktion ausgewertet sein**. Nun
  ruft die REPL diese Funktion mit den restlichen Elementen (den Werten) der
  Liste als [**Argument**](https://de.wikipedia.org/wiki/Parameter_(Informatik))
  auf.

* Der **Rückgabewert** des Funktionsaufrufs (das **Funktionsergebnis**) ist der
  Wert der Auswertung der Liste. Also jener **Wert, zu dem die Listen-Form
  auswertet**.

> Don't Panic! Das schauen wir uns ganz in Ruhe nochmal an ;-)

**Übungen**:

* Erkläre deinem Tischnachbarn, wieso `(inc 5)` zu dem Wert **6** auswertet.
* Zu was wertet `inc` aus?
* Probier aus, zu was `()` auswerten. Macht das Sinn?
* Zu was wertet `(5 inc)` aus. Wieso?
* Zu was wertet `(inc)` aus. Wieso?
* Zu was wertet `(inc 5 8)` aus? Hast du eine Idee, wieso das so sein könnte?
* Zu was wertet `(inc "12")` aus? Macht das Sinn?
* Zu was wertet `(inc false)` aus? Und `(inc true)`? Macht das Sinn?
* Zu was wertet `[inc]` aus? Wieso?
* Zu was wertet `[inc 5]` aus? Wieso?
* Zu was wertet `[(inc 5)]` aus? Wieso?

### Geschachtelte Listen/Funktionsaufrufe

Die oben beschriebene Auswertungsregel für Listen lässt sich auch
[**rekursiv**](https://de.wikipedia.org/wiki/Rekursion) anwenden. Damit ist
gemeint, dass innerhalb einer Listen-Form die einzelnen Elemente auch wiederum
Listen-Formen (und auch andere zusammengesetzte Formen) sein können.

> Man spricht von **rekursiven Datenstrukturen** oder auch von **geschachtelten
> Datenstrukturen** (engl. **nested**).

Somit wird die REPL erst die eingebettete Liste auswerten und dann die
**umschließende**. Die Auswertung erfolgt also **von innen nach außen**.

**Übungen**:
* Zu was wertet `(inc (inc 4))` aus? Wieso?
* Zu was wertet `(inc (inc (inc 4)))` aus?
* Erkläre deiner Tischnachbarin, wieso die Form `((inc 4))` nicht ausgewertet
  werden kann. Welchen Unterschied findest du zwischen den runden Klammern in
  Clojure und den runden Klammern, die du im Mathematikunterricht benutzt?
* Wieso lässt sich `(inc 4` nicht auswerten? 
* Wieso lässt sich `(inc 4))` nicht auswerten?
* Und `inc 4)`?

-------------------------------------------------------------------------------

> An dieser Stelle kannst du auch erstmal den Abschnitte "Mathematische
> Operatoren" lesen und anschließend zu dieser Stelle zurückkehren.

## Zugriff auf die Elemente zusammengesetzter Datentypen

Bisher haben wir die Werte zusammengesetzter Datentypen als Form zwar
hinschreiben können (als Literale). Nun möchten wir aber auf die Teile (also die
Elemente) der Datentyp-Werte **zugreifen** und die Teile so aus den
zusammengesetzten Werten herauslesen.

Für diesen Zugriff bietet Clojure eine Reihe von **Funktionen**:

> Im [Cheatsheet](https://clojure.org/api/cheatsheet) findest du viele
> Funktionen, von denen wir einige im folgenden kennen lernen. In dem Cheatsheet
> werden die zusammengesetzten Datentypen __*collections*__ genannt.  
> Solange wir Clojure bzw. die REPL im Browser verwenden, nutzen wir nicht
> Clojure sondern ClojureScript. Für ClojureScript gibt es ebenfalls ein
> [Cheatsheet](https://cljs.info/cheatsheet/).

* `first` liefert dir das erste Element einer Collection. 
* `second` liefert dir das zweite Element einer Collection. 
* `last` liefert dir das letzte Element einer Collection. 

> Wir werden später sehen, dass diese Aussage nicht 100% korrekt ist. Du kannst
> ja mal ausprobieren, zu was `(second "abc")` auswertet. Macht das Sinn?

Für den Zugriff auf Vektoren, Maps und Sets kannst du die Funktion `get` nutzen.

* Zugriff auf Vektoren: `(get ["foo" "bar" "foobar"] 2) ;=> "foobar"`
* Zugriff auf Maps: `(get {"a" "foo" "b" "bar" "c" "foobar"} "b") ;=> "bar"`
* Zugriff auf Sets: `(get #{"foo" "bar" "foobar"} "foo") ;=> "foo"`

> Der Zugriff auf Vektoren erfolgt über den **Index**, wobei das **erste**
> Element des Vektors dem Index **0** entspricht (dazu im folgenden Abschnitt
> mehr).  

**Übungen**:

* Zu was wertet `(first [1 true "a"])` aus?
* Zu was wertet `(first [[1 true "a"]])` aus?
* Zu was wertet `(first 1 true "a")` aus?
* Zu was wertet `(first)` aus? Macht das Sinn?
* Zu was wertet `(first [])` aus?
* Zu was wertet `(first {1 true "a" 42})` aus? Macht das Sinn?
* Zu was wertet `(first {})` aus?
* Zu was wertet `(first #{1 true "a" 42})` aus? Macht das Sinn?
* Zu was wertet `(first #{})` aus?
* Denk dir zusammen mit deiner Tischnachbarin weitere Beispiele aus, in denen
  ihr `first`, `second` und `last` zusammen mit Vektoren, Maps und Sets
  verwendet.
* Greife mit Hilfe von `first`, `second` und `last` auf folgende Datenstruktur
  zu: `[1 [[2 3 4] 5 6] 7]`. Wie muss die Form aussehen, die zu `4` auswertet?
  Wenn du nicht gleich drauf kommst, nutze einfach die REPL, um dich **von
  außen** der Lösung zu nähern.

-------------------------------------------------------------------------------

## Collections erzeugen und ändern

Wir können Collections nicht nur als **Literal** hinschreiben, sondern sie auch
**programmatisch konstruieren**. 

> In diesen einfachen Beispielen gewinnen wir dadurch noch nicht so viel, weil
> wir die Element hier noch explizit als Literal hinschreiben. Später werden wir
> aber Collections mit Elementen füllen, die wir vorab nicht kennen und somit
> auch nicht vorab hinschreiben können.
 
```
(vector "a" 42 "TOLL!" 42)       ;=> ["a" 42 "TOLL!" 42]
(set (vector "a" 42 "TOLL!" 42)) ;=> #{"a" 42 "TOLL!"}
(hash-map "a" 42 "TOLL!" 42)     ;=> {"TOLL!" 42, "a" 42}
```

Wir können einer **bestehenden Collection** mit Hilfe von `conj` (gesprochen
*konsch*; von engl. *conjoin*) auch Elemente **hinzufügen**:

> Beachte, dass `conj` einem Vektor die Elemente **am Ende** zufügt!

```
(conj ["a" 42 "TOLL!" 42] "foo" false)                 ;=> ["a" 42 "TOLL!" 42 "foo" false]
(conj #{"a" 42 "TOLL!"} "foo" false)                   ;=> #{"a" 42 "TOLL!" "foo" false}
(conj {"TOLL!" 42, "a" 42} ["foo" false] ["bar" true]) ;=> {"TOLL!" 42, "a" 42, "foo" false, "bar" true}
```

> In Clojure sind alle Datentypen **unveränderlich** (engl. *immutable*). D.h.,
> wenn ich hier schreibe, dass einer Collection Elemente **hinzugefügt** werden,
> dann meine ich damit, dass eine **neue Collection erzeugt wird**, die zu
> Beginn die gleichen Werte enthält wie die Collection, der die Elemente
> hinzugefügt werden sollen. Und dieser neuen Collection werden die Elemente
> dann hinzugefügt. Die ursprüngliche Collection kann gar nicht geändert werden,
> weil Clojure das eben **nicht zulässt**.

Mit `assoc` können wir Elemente einer assoziativen Collection (Maps, Vektoren)
**ändern**:

> Vektoren sind über ihre Indexposition auch **assoziativ** wie eine Map! Dabei
> ist der **Schlüssel 2** die **dritte Stelle** im Vektor (0-based; vgl. `nth`
> weiter unten).

```
(assoc ["a" 42 "TOLL!" 42] 2 "foobar" 0 true) ;=> [true 42 "foobar" 42]
(assoc {"TOLL!" 42, "a" 42} "a" 38 "b" 39)    ;=> {"TOLL!" 42, "a" 38, "b" 39}
```

Wir können auch Element aus einer Collection **entfernen**:

> Es ist nicht einfach, Elemente an einer beliebigen Stelle eines Vektors zu
> entfernen. Wir kommen später nochmal darauf zu sprechen.

```
(pop ["a" 42 "TOLL!" 42 "foo" false])                            ;=> ["a" 42 "TOLL!" 42 "foo"]
(disj #{"a" 42 "TOLL!" "foo" false} "foo" 42)                    ;=> #{"a" "TOLL!" false}
(dissoc {"TOLL!" 42, "a" 42, "foo" false, "bar" true} "foo" "a") ;=> {"TOLL!" 42, "bar" true}
```

**Übungen**:

* Benutze `assoc-in`, um im Vektor `[{"foo" 42} {"bar" 23}]` die `23` gegen
  `4711` zu tauschen, so dass `[{"foo" 42} {"bar" 4711}]` entsteht.


-------------------------------------------------------------------------------
## `nth`

Die Funktion `nth` liefert dir das __n__-te Element eines zusammengesetzten
Wertes.

> Kannst du dir vorstellen, wieso die Funktion gerade `nth` heißt? Kennst du die
> Buchstaben **n** bzw. **N** aus dem Mathematikunterricht? Welche Bedeutung hat
> der Buchstabe dort?

Dabei ist **n** der __Versatz__ (engl. *offset*; man könnte auch _Abstand_ oder
_Differenz_ sagen) zum ersten Element. Somit liefert dir `(nth ,,, 0)` das
__erste__ Element (da der __Versatz__ zum __ersten__ Element 0 ist), `(nth ,,,
1)` das zweite Element (da der __Versatz__ zum __ersten__ Element 1 ist), `(nth
,,, 2)` das dritte Element usw. Häufig wirst du auch die Bezeichnung __Index__
anstatt Versatz hören/lesen. Und man spricht dann auch vom __*zero-based
index*__ (oder _0-based index_) oder __[zero-based
numbering](https://en.wikipedia.org/wiki/Zero-based_numbering)__.

> In der Form `(nth ,,, 2)` nutze ich die drei Kommata (`,,,`) so, wie du es in
> der Schriftsprache vielleicht mit den drei Punkten (`...`) tun würdest
> ([Auslassungspunkte](https://de.wikipedia.org/wiki/Auslassungspunkte)). Damit
> drückst du aus, dass an dieser Stelle etwas steht, was du hier aber nicht
> explizit/konkret hinschreiben möchtest. Das nennt man
> [Ellipse](https://de.wikipedia.org/wiki/Ellipse_(Sprache)). Da in Clojure das
> Komma wie ein Leerzeichen wirkt, kannst du es in bestimmten Situationen auch
> tatsächlich in dein Programm schreiben. Wir nutzen es als Ersatz für die drei
> Punkte. Ich hätte also in dem Beispiel auch `(nth ... 2)` schreiben können,
> nur wäre das eben keine korrekte Clojure-Form. Du wirst sehen, dass auch
> andere Leute diese drei Kommata als Stilmittel nutzen, wenn sie Clojure-Code
> schreiben oder __über__ Clojure schreiben.

> __Das Problem mit der
> [Metasprache](https://de.wikipedia.org/wiki/Metasprache)__: wir schreiben hier
> mit Deutsch und teilweise Englisch und zusätzlich auch noch mit Clojure
> __über__ Clojure. D.h., wie nutzen verschiedene __Sprachen__, um __über__ eine
> __Sprache__ (Clojure) zu schreiben. Bei deinen Recherchen im Internet und in
> Büchern wirst du verschiedene Arten finden, wie die Autorinnen Sprache
> benutzen, um __über__ Clojure zu schreiben. Um z.B. zu beschreiben, [wie die
> Funktion `nth` aufgerufen werden
> kann](https://clojuredocs.org/clojure.core/nth), nutzen viele Autoren die
> Schreibweise `(nth coll index)`. Damit möchte der Autor ausdrücken, dass die
> Funktion zwei Argumente erwartet, von denen das erste ein zusammengesetzter
> Datentyp(-wert) ist (eine *Collection*) und das zweite ist eine Zahl, die als
> Index/Offset verwendet wird. Der Autor hätte natürlich auch `(nth c i)`
> schreiben können, aber dann hätte wir noch mehr Schwierigkeiten zu verstehen,
> was der Autor uns eigentlich sagen will. Du findest aber auch die Schreibweise
> `(nth <coll> <index>)`. Mit dieser Schreibweise soll deutlich gemacht werden,
> dass du das `nth` wirklich als `nth` hinschreiben musst, die Ausdrücke
> `<coll>` und `<index>` aber nur *Platzhalter* sind für __Formen__, die du bei
> der Verwendung (d.h. beim Aufruf) der Funktion `nth` angeben musst. Ich werde
> diese zweite Art der Schreibweise verwenden.

Die Funktion `nth` kannst du mit __zwei__ oder __drei__ __Argumenten__ aufrufen.

> Clojure-Funktionen können also verschiedene
> [**Stelligkeiten**](https://de.wikipedia.org/wiki/Stelligkeit) (Arität) haben.
> Viele Funktionen haben nur eine Stelligkeit. Die Funktion `nth` hat zwei.
> Dabei wird in Clojure die Stelligkeit nur nach der **Anzahl der erwarteten
> Argumente** unterschieden. In anderen Programmiersprachen wird im Zusammenhang
> mit den erwarteten Datentypen auch von
> [**Signatur**](https://de.wikipedia.org/wiki/Signatur_(Programmierung))
> gesprochen.

* `(nth <coll> <n>)` : liefert das n-te (0-based) Element der Collection. Falls
  n größer oder gleich der Anzahl der Elemente der Collection ist, wird ein
  Fehler geliefert.

> Wir gehen später noch auf das Thema **Fehler** ein. 

* `(nth <coll> <n> <not-found>)` : liefert das n-te (0-based) Element der
  Collection. Falls n größer oder gleich der Anzahl der Elemente der Collection
  ist, wird der Nicht-Gefunden-Wert geliefert.

**Übungen**:

* Zu was wertet `(nth [2020 2021 2022 2023] 0)` aus?
* Zu was wertet `(nth [] 0)` aus?
* Zu was wertet `(nth [,,,] 0)` aus?
* Zu was wertet `(nth [2020 2021 2022 2023] 3)` aus?
* Zu was wertet `(nth [2020 2021 2022 2023] 4)` aus?
* Zu was wertet `(nth [2020 2021 2022 2023] 4 99)` aus?
* Zu was wertet `(nth [2020 2021 2022 2023] -3)` aus?
* Zu was wertet `(nth [2020 2021 2022 2023] 2 (println "oops"))` aus? Wieso?
* Zu was wertet `(nth [2020 2021 2022 2023] -3 99)` aus? Macht das Sinn? Was
  hättest du erwartet? Zu was wertet `(nth [2020 2021 2022 2023] 3 (nth [] 0))`
  aus? Macht das Sinn? Was hättest du erwartet? Schau dir nochmal genau an, wie
  die Auswertung von (geschachtelten) Funktionsaufrufen in Clojure erfolgt. Was
  passiert wann? In welcher Reihenfolge werden die Formen ausgewertet? Zu was
  wertet `(nth [2020 (nth [] 1) 2022 2023] 3 (nth [] 0))` aus?
* Was ist der Unterschied zwischen `(first [])` und `(nth [] 0)` und `(nth [] 0
  nil)`?

-------------------------------------------------------------------------------
## Was ist `nil`?

Vielleicht hast du bei den Übungen schon bemerkt, dass `(first [])` zu `nil`
auswertet. Aber was ist `nil`? 

`nil` ist das **Literal** (also eine **Form**) für den **Wert** __nil__. 

> Ich werde ab jetzt immer `nil` schreiben. Aus dem Kontext sollte sich ergeben,
> ob ich dabei über die Form `nil` oder den Wert **nil** spreche.

`nil` ist ein Wert, dessen Datentyp keinen expliziten Namen in Clojure hat.

Der Wert `nil` wird i.d.R. verwendet, um auszudrücken, dass *etwas nicht
vorhanden ist*. Aber du kannst ihn verwenden wie jeden anderen Wert. Du wirst
aber feststellen, dass viele der Funktionen, die von Clojure mitgeliefert
werden, `nil` in dem Sinne *etwas ist nicht vorhanden* verwenden.

> Clojure ist eine [**LISP**](https://de.wikipedia.org/wiki/Lisp)-Sprache. In
> diesen gibt es verschiedene Arten, *nichts* (oder *nicht vorhanden*)
> auszudrücken. So spielt in LISP die leere Liste `()` eine Sonderrolle -- nicht
> aber in Clojure. Mehr zu dem Thema findest du in dem [Wikipedia-Artikel
> **Nullwert**](https://de.wikipedia.org/wiki/Nullwert).

**Übungen**:

* Zu was wertet `nil` aus?
* Zu was wertet `[nil]` aus?
* Zu was wertet `[nil nil]` aus?
* Zu was wertet `(nil)` aus?
* Zu was wertet `(inc nil)` aus? Macht das Sinn?
* Zu was wertet `(first nil)` aus? Macht das Sinn?
* Zu was wertet `(nth nil 1)` aus? Macht das Sinn?

-------------------------------------------------------------------------------
## Weitere Funktionen für zusammengesetzte Datentypen

Es gibt sehr viele Funktionen in Clojure, um auf Collections zuzugreifen und
Collections zu erzeugen. Hier führe ich einfach etwas willkürlich einige davon
auf, einfach damit du diese Funktionen kennen lernst und anschließend verwenden
kannst.

* `(count <coll>)` : liefert die Anzahl der Elemente in `<coll>`.

* `(into <to-coll> <from-coll>)` : fügt die Elemente von `<from-coll>` zu der
  Collection `<to-coll>` hinzu und liefert das Resultat als Ergebnis. Das
  Resultat ist vom **gleichen Datentyp** wie `<to-coll>`.

* `(rest <coll>)` : liefert die Elemente aus `<coll>`, die **nach** dem ersten
  Element (also `(first <coll>)`) in `<coll>` vorhanden sind, als **Liste**.
  Falls es ein solches Element nicht gibt, wird die leere Liste `()` geliefert.

> Wir werden später über den Unterschied zwischen **Listen** und **Sequenzen**
> sprechen. Aber bis dahin sind das alles Listen für uns.

* `(next <coll>)` : liefert die Elemente aus `<coll>`, die **nach** dem ersten
  Element (also `(first <coll>)`) in `<coll>` vorhanden sind, als **Liste**.
  Falls es ein solches Element nicht gibt, wird `nil` geliefert.

> Wir werden später sehen, dass wir uns genau überlegen müssen, ob wir `next`
> oder `rest` nutzen möchten/müssen.

**Übungen**:

* Zu was wertet `(count)` aus? Macht das Sinn?
* Zu was wertet `(count [])` aus? Macht das Sinn?
* Zu was wertet `(count [[1 2]])` aus? Macht das Sinn?
* Zu was wertet `(into [] [1 2 3 4])` aus?
* Zu was wertet `(into {} {1 2 3 4})` aus?
* Zu was wertet `(into ["a"] {1 2 3 4})` aus? Macht das Sinn? Lies dir nochmal
  durch, was Maps genau sind und wie sie als Literal/Form geschrieben werden?
* Oben hatten wir gesehen, dass `#{"a" "a"}` keine zulässige Mengen-Form ist.
  Wieso? Probiere aus, zu was `(into #{} ["a" "a"])` auswertet. Macht das Sinn?

-------------------------------------------------------------------------------
## Listen, Symbole und `quote`

Weiter oben hatten wir schon Listen kennen gelernt und erfahren, dass eine
Listen-Form auf eine ganz besondere Weise zu einem Wert ausgewertet wird.

Manchmal möchten wir aber Listen nicht nutzen, um eine **Funktion aufzurufen**,
sondern wir möchten die Liste als **Datenstruktur** nutzen --- genau wie z.B.
Vektoren.

Um aber die Liste mit den Elementen `1`, `"a"` und `nil` zu konstruieren, können
wir nicht `(1 "a" nil)` schreiben (wieso nicht?). Wir müssen Clojure bzw. die
REPL davon abhalten, das erste Element als Funktion zu interpretieren und diese
aufzurufen. Stattdessen möchten wir einfach nur die Liste mit den Werten `1`,
`"a"` und `nil` erhalten.

Genau für diesen Zweck gibt es die Funktion `quote`.

> `quote` ist tatsächlich keine Funktion sondern eine [special
> form](https://clojure.org/reference/special_forms#quote). Wir brauchen uns
> damit aber noch nicht zu beschäftigen. Später lernen wir noch den Unterschied
> kennen.

Mit `quote` können wir also verhindern, dass **Listen und Symbole**, die als
Argument zu `quote` angegeben werden, ausgewertet werden.

Es gibt noch eine Kurzform zu `quote`: das **einfache vorangestellte
Anführungszeichen** (`'`).

> Don't panic! Das mit den Listen ist am Anfang sehr ungewohnt. In Clojure
> werden Listen(-Formen) sowohl als **Datenstruktur** genutzt, in der Werte
> stehen, die unser Programm verarbeitet, als auch als Mechanismus, um das
> Programm an sich zu schreiben --- um eben **Funktionen aufzurufen**.  
> Beim Lesen eines Clojure-Programms musst du also verstehen, welche
> Listen-Formen eine Datenstruktur beschreiben und welche Listen-Formen
> Programmcode sind.  
> Am Anfang kann es da schon vor den Augen etwas flimmern 🙂 Du wirst dich aber
> schnell daran gewöhnen.  

* `inc` wertet zu `#object[Ke]` aus. Dies ist die Art, wie Clojure uns die
  Funktion in der REPL anzeigt, die über die Zuordnungstabelle unter dem
  Schlüssel `inc` zu finden ist.

* `'inc` und `(quote inc)` werten zu `inc` aus. In diesem Fall handelt es sich
  also nicht um die Funktion **inc**, sondern um das Symbol `inc`.

* `(inc 2)` wertet zu `3` aus.

* `'(inc 2)` wertet zu `(inc 2)` aus. Das ist die Liste mit den Elementen `inc`
  (ein Symbol) und der Zahl `2`. Das `quote` hat also sowohl die Auswertung von
  `inc` als auch die Auswertung der Liste verhindert.

Anstatt eine Liste als Listen-Form (Literal) mit Hilfe des `quotes`
aufzuschreiben, kannst du auch die **Funktion** `list` nutzen, um eine Liste zu
erzeugen.

* `(list 1 "a" nil)` wertet zu `(1 "a" nil)` aus. Das ist das gleiche wie `'(1
  "a" nil)`

**Übungen**: Versuche die Ergebnisse zusammen mit deinem Tischnachbarn zu verstehen.
Könnt ihr erklären, wieso die Auswertung jeweils genau so erfolgt?

* Zu was wertet `inc` aus?
* Zu was wertet `(quote inc)` aus? 
* Zu was wertet `a` aus?
* Zu was wertet `'a` aus?
* Zu was wertet `'  a` aus? Macht das Sinn?
* Zu was wertet `',,aa` aus? 
* Zu was wertet `(inc 2)` aus?
* Zu was wertet `'(inc 2)` aus?
* Zu was wertet `'(a 2)` aus?
* Zu was wertet `(list inc 2)` aus?
* Zu was wertet `(list inc 'inc 2)` aus?
* Zu was wertet `(list a 2)` aus?
* Zu was wertet `(conj '(1 2 3) 4 5)` aus? Wie unterscheidet sich das zu `(conj
  [1 2 3] 4 5)`? Macht das Sinn? 

-------------------------------------------------------------------------------
## Mathematische Operatoren

Bisher haben wir einfache und strukturierte Daten(-typen) kennengelernt. Wir
haben Funktionen genutzt, um auf die Eigenschaften (z.B. `count`) und Teile
(z.B. `nth`) dieser Daten zuzugreifen und wir haben mit `into` eine Funktion
genutzt, um Daten **zusammenzuführen**.

Nun möchten wir
[Operatoren](https://de.wikipedia.org/wiki/Operator_(Mathematik)) nutzen, um mit
Zahlen zu rechnen.

Aus dem Mathematikunterricht kennst du
[Terme](https://de.wikipedia.org/wiki/Term) wie **4 + 7** und **(9 - 2) * 3**.
In Clojure möchten wir auch gerne rechnen und brauchen daher auch eine
Möglichkeit, solche Terme zu formulieren.

In Clojure schreiben wir aber nicht `4 + 7` oder `(4 + 7)`. Diese Art, Ausdrücke
zu schreiben, wird [Infixnotation](https://de.wikipedia.org/wiki/Infixnotation)
genannt. Bei der Infixnotation steht der **Operator** zwischen den beiden
[Operanden](https://de.wikipedia.org/wiki/Operator_(Mathematik)#Operand).

> Wieso können wir in Clojure nicht `(4 + 7)` schreiben? Schau nochmal oben, wie
> eine solche **Form** in Clojure ausgewertet wird.

Stattdessen schreiben wir `(+ 4 7)`. In diesem Fall wird die **Funktion** `+`
aufgerufen. Wir schreiben den Operator also an die erste Stelle der Listen-Form.
Diese Form wertet zu `11` aus.

> In Clojure ist es völlig ok, Sonderzeichen als **Symbol** und damit als
> **Namen für eine Funktion** zu verwenden. Das Plus-Zeichen spielt also keine
> Sonderrolle: es ist ein *normales* Symbol und damit ein Name für eine
> Funktion. Genau wie die Symbole/Namen `count`, `inc` und `next`.

Es gibt neben `+` weitere arithmetische Funktionen:

* `-` : Subtraktion
* `*` : Multiplikation
* `/` : Division

Die Infixnotation ist dir natürlich aus dem Mathematikunterricht viel vertrauter
als die [Präfixnotation](https://de.wikipedia.org/wiki/Polnische_Notation) von
Clojure.

Die Präfixnotation hat aber einige Vorteile:

* [Operatorrangfolge](https://de.wikipedia.org/wiki/Operatorrangfolge): aus dem
  Mathematikunterricht kennst du die **Punkt-vor-Strich-Rechenregel**. Diese
  besagt, dass der Term **1 + 2 * 3** gleich **7** und nicht gleich **9** ist.
  Die Operatorrangfolge legt also fest, in welcher **Reihenfolge die Operatoren
  anzuwenden sind**.  
  In Clojure brauchen wir das nicht, weil wir durch die Klammern ausdrücken, in
  welcher Reihenfolge die Formen auszuwerten sind und damit, in welcher
  Reihenfolge die Funktionen anzuwenden sind.  
  So wertet `(+ 1 (* 2 3))` zu `7` aus und `(* (+ 1 2) 3)` zu `9`.

* [Stelligkeiten](https://de.wikipedia.org/wiki/Stelligkeit): Bei der
  Infixnotation haben die Operatoren immer eine Stelligkeit von **zwei**. D.h.
  du kannst damit immer nur **zwei Operanden** verarbeiten. Wenn du also die
  Zahlen 1, 2, 3 und 4 addieren möchtest, musst du **1 + 2 + 3 + 4** schreiben.  
  In Clojure können die Funktionen aber viele Stelligkeiten haben. D.h. die
  Funktion `+` kann mit null, einem, zwei, drei bzw. vielen Operanden (wir
  nennen sie Argumente) aufgerufen werden.  
  In Clojure können wir also `(+ 1 2 3 4)` schreiben.

**Übungen**:

* Zu was wertet `(+ 4)` aus? Macht das Sinn?
* Zu was wertet `(+ 4 7)` aus?
* Zu was wertet `(+ 4 7 23)` aus?
* Schreibe die Clojure-Form für **1 + 2 * 14 / 7 - 2 * 3** auf.
* Zu was wertet `+` aus?
* Zu was wertet `(+)` aus? Macht das Sinn?
* Zu was wertet `(*)` aus? Macht das Sinn? Weißt du, was ein [neutrales
  Element](https://de.wikipedia.org/wiki/Neutrales_Element) ist?
* Zu was wertet `(-)` aus? Macht das Sinn?

-------------------------------------------------------------------------------
## Prädikate

> Wenn du etwas programmierst, wirst du häufig prüfen müssen, ob eine bestimmte
Aussage **wahr** oder **falsch** ist. Du musst eine **Fallunterscheidung**
treffen. Wenn jemand z.B. ein falsches Passwort eingibt, muss dein Programm
vielleicht erneut nach dem Passwort fragen. Wird das Passwort korrekt
eingegeben, gewährt dein Programm vielleicht den Zugriff auf weitere
Informationen. Du musst also zum einen eine **Prüfung** programmieren und zum
anderen brauchst du eine Möglichkeit, dein Programm abhängig vom Ergebnis der
Prüfung in die **eine oder andere Richtung** weiterlaufen zu lassen ([Bedingte
Anweisung und
Verzweigung](https://de.wikipedia.org/wiki/Bedingte_Anweisung_und_Verzweigung)).
In diesem Abschnitt schauen wir uns erstmal an, wie du eine solche **Prüfung**
programmieren kannst.

Im Mathematikunterricht hast du es häufig mit **Aussagen** wie **4 ist kleiner
als 7** (4 < 7), **7 ist kleiner als 5** (7 < 5) und **7 ist gleich 9** (7 = 9)
zu tun. Es gibt **wahre** und **falsche** **Aussagen**.

Manchmal findest du auch Aussagen wie **x plus 1 ist gleich 6** (x + 1 = 6). In
diesem Fall besteht deine Aufgabe aber nicht darin, zu entscheiden, ob die
Aussage wahr oder falsch ist. Stattdessen besteht deine Aufgabe darin, eine
**Zahl** zu finden, die du für **x** einsetzen kannst und die dann zu einer
**wahren Aussage** führt. Die gesuchte Zahl ist dann Element der
**Lösungsmenge**. Einige Gleichungen haben auch mehrere Lösungen -- d.h. es gibt
mehr als ein Element in der Lösungsmenge.

In Clojure gibt es **Funktionen**, die eine Aussage prüfen und dir dann den
**Wert** `true` oder `false` liefern. Solche Funktionen, die einen Wahrheitswert
liefern, nennt man
*[Prädikate](https://de.wikipedia.org/wiki/Pr%C3%A4dikat_(Logik))*.

> Also nochmal nachdenken: im Mathematikunterricht ist **4 < 7** eine Aussage,
> über deren Wahrheit wir entscheiden können. In Clojure ist `(< 4 7)` **ein
> Wert** (d.h., die Form wertet zu einem Wert aus), mit dem wir anschließend
> weiter arbeiten können.

Es gibt weitere Prädikate in Clojure:

* `>` (größer als?) 
* `<=` (kleiner oder gleich?)
* `=` (ist gleich?) 
* `even?`/`odd?` (ist die Zahl gerade/ungerade?)
* `pos?`/`neg?` (ist die Zahl positiv/negativ?)

Clojure liefert dir aber nicht nur Prädikate für Zahlen sondern auch für die
anderen Datentypen, die wir schon kennen gelernt haben:

* `distinct?` : prüft, ob jeder der Argumentwerte nur einmalig vorkommt?
  `(distinct? 1 "a" true)` liefert `true`. `(distinct? 1 "a" true 1)` liefert
  `false`.

> `(distinct? <x> <xs*>)` erwartet nicht eine Collection `<coll>` als Argument,
> sondern **1 oder mehrere Argumente**. Wieso die Funktion so programmiert
> wurde, kann ich nicht sagen. Ich nutze die Notation `<xs*>`, um auszudrücken,
> dass es sich um 0 oder mehrere Vorkommen eines beliebigen Datentyps handelt.
> Im Internet findest du auch die Schreibweise `(distinct? x & xs)`. Wir werden
> später verstehen, wie es zu dieser Schreibweise kommt.

* `string?` : prüft, ob das Argument ein String ist. `(string "foo")` liefert
  `true`. 

> nerd fact: Die Wörter [**foobar**](https://de.wikipedia.org/wiki/Fubar),
> **foo**, **bar**, **baz** etc. wirst du häufiger mal im Zusammenhang mit
> Programmiersprachen sehen. Ich nutze sie auch gerne. In deutschen Beiträgen
> werden als [Metasyntaktische
> Variablen](https://de.wikipedia.org/wiki/Metasyntaktische_Variable) auch gerne
> **bla**, **blubb**, **blabla**, **blablabla** und **blafasel** verwendet.

**Übungen**:

* Ist die Zahl 0 positiv?
* Zu was wertet `(even? 1.4)` aus? Macht das Sinn?
* Zu was wertet `(= '(1 2 3) [1 2 3])` aus? Macht das Sinn?
* Zu was wertet `(distinct? '(1 2 3) [1 2 3])` aus? Macht das Sinn?
* Zu was wertet `(distinct '[(1 2 3) [1 2 3]])` aus? Macht das Sinn?

> Es wundert sich bestimmt, dass `(= '(1 2 3) [1 2 3])` zu `true` auswertet. Wir
> werden später lernen, wieso das in Clojure so ist.

-------------------------------------------------------------------------------
## Funktionen, die Funktionen als Argument nutzen (higher order functions)

Clojure ist eine [funktionale
Programmiersprache](https://de.wikipedia.org/wiki/Funktionale_Programmierung#Funktionale_Programmiersprachen).
Wir wollen nicht im Detail darauf eingehen, was das genau bedeutet, aber
zumindest können wir sagen, dass **Funktionen** in einer funktionalen
Programmiersprache eine zentrale Rolle spielen sollten.

Bisher haben wir den Funktionen, die wir verwendet haben, als **Argumente**
immer irgendwelche **Daten** übergeben: Zahlen, Strings, Vektoren, etc.

Nun werden wir Funktionen kennen lernen, denen wir als **Argument** eine (und
später auch mehrere) **Funktionen** übergeben. Wieso man so etwas tun sollte,
wird hoffentlich im Laufe der Zeit klar werden. 

Funktionen, die wiederum Funktionen als Argument verwenden, werden **[Funktion
höherer Ordnung](https://de.wikipedia.org/wiki/Funktion_h%C3%B6herer_Ordnung)**
(engl. **higher-order functions**; HOFs) genannt.

> Don't panic! Wir lassen uns Zeit und schauen uns alles in Ruhe an.

### `every?`

Oben haben wir **Prädikate** kennengelernt: Funktionen, die prüfen, ob eine
bestimmte Aussage wahr oder falsch ist.

Hier übergeben wir der Funktion/Prädikat den Wert **2**  `(even? 2)` und
erhalten als Ergebnis `true`.

Die Funktion `every?` ist auch ein Prädikat, das prüft, ob eine bestimmte
Aussage für **alle** Elemente einer Collection `<c>` wahr ist. Falls dies der
Fall ist, liefert `every?` den Wert `true` --- andernfalls liefert sie `false`.

Nur im Gegensatz zu den Prädikaten (wie z.B. `even?`), die wir bisher
kennengelernt haben, weiß `every?` aber nicht, **welche** Aussage bzgl. der
Elemente denn betrachtet/entschieden werden soll. Das Prädikat `even?` hingegen
*weiß*, dass es prüfen soll, ob der übergebene Wert **gerade** ist. Der Funktion
`every?` müssen wir den zu **prüfenden Aspekt/Sachverhalt** beim Aufruf mit
Hilfe einer **Funktion (Prädikat!) als Argument mitteilen**.

> Kennst du aus dem Mathematikunterricht den
> **[Allquantor](https://de.wikipedia.org/wiki/Quantor#Schreib-_und_Sprechweise)**
> "*Für alle*"? Die Funktion `every?` verhält sich im Prinzip wie dieser
> Allquantor.

Der Aufruf sieht also so aus: `(every? <pred> <coll>)`

Dabei ist `<pred>` unsere Prädikats-Funktion und `<coll>` die Collection.

Beispiel: `(every? even? [1 2 3])`

Die Funktion `every?` wendet das Prädikat `even?` der Reihe nach auf die Element
der Collection (hier ein Vektor) an. Als erstes wird also `(even? 1)`
ausgeführt. Da dies schon `false` liefert, beendet `every?` sofort die
Ausführung und liefert `false`.

> Probiere es doch einfach mal selber aus.  
> Überlege nochmal, was der **Wert** der **Form** `even?` ist. Wieso haben wir
> nicht `(every? (even?) [1 2 3])` geschrieben? Was ist der **Wert** der
> **Form** `(even?)`?

### `filter`

Als nächstes möchten wir von einer Collection nur all jene Werte **behalten**,
die eine **gerade Zahl** sind. Alle anderen Elemente der Collection sollen
entfernt werden. Dazu nutzen wir die Funktion `(filter <pred> <coll>)`.

> Die allermeisten Informationen zu Clojure im Internet sind auf Englisch. Schau
dir doch einfach mal die Beschreibung zu
[filter](https://clojuredocs.org/clojure.core/filter) an. Du wirst zu Beginn
nicht alles verstehen, aber wenn du regelmäßig in die Dokumentation schaust,
wirst du feststellen, dass das verwendete Englisch relativ einfach gehalten ist
und auch die Art und Weise, wie die Dinge beschrieben sind, einem gewissen
einheitlichen Stil folgen. Nach einiger Zeit wirst du dich daran gewöhnt haben
und die Sachverhalten/Texte besser verstehen.

Das erste Argument `<pred>` muss ein **einstelliges Prädikat** sein (vgl. oben).
Also eine **Funktion**, die **ein** Argument erwartet und `true` oder `false`
liefert.

Das zweite Argument von `filter` ist die Collection, aus der wir die
nicht-geraden Werte entfernen wollen.

Die Funktion `filter` wendet das Prädikat `<pred>` der Reihenfolge nach auf die
Element/Werte `<e>` von `<coll>` an und behält nur jene Werte `<e>`, für die
`(<pred> <e>)` den Wert `true` liefert.

Da wir nur die geraden Zahlen aus `<coll>` behalten wollen, nutzen wir `even?`
als Prädikat.

Wenn wir `(filter even? [1 2 3 4])` auswerten, erhalten wir die Liste `(2 4)`. 

> Tatsächlich handelt es sich nicht um eine Liste sondern um eine Sequenz. Wir
> schauen uns weiter unten den Unterschied zwischen Listen und Sequenzen an. Für
> jetzt sprechen wir nur von Listen.

Es gibt eine ganze Reihe von Funktionen, die als Ergebnis eine Liste liefern,
selbst wenn wir ihnen z.B. Vektoren, Sets oder Maps als Argument übergeben. Aber
wenn wir gerne wieder einen Vektor als Ergebnis haben möchten, können wir die
Funktion [`into`](https://clojuredocs.org/clojure.core/into) nutzen.

```
(into [] (filter even? [1 2 3 4])) ;=> [2 4]
```

> In Clojure ist das Semikolon (`;`) das Kommentar-Zeichen. Wenn du das
> Semikolon außerhalb von Strings nutzt, ist alles vom Semikolon bis zum Ende
> der Zeile ein Kommentar, der von der REPL ignoriert bzw. nicht ausgewertet
> wird. Wenn wir also `;=> [2 4]` schreiben, tun wir das, um zum einen
> auszudrücken, dass eine Form zu einem bestimmten Wert auswertet. Und wir tun
> das auf eine Weise, die es uns sogar erlauben würde, diese Angabe in ein
> Programm zu schreiben, ohne dass das Programm sich dadurch anders verhalten
> würde. Denn es handelt sich ja um einen Kommentar.  
> Wir hätten auch `(into [] (filter even? [1 2 3 4])) --> [2 4]` schreiben
> können, aber das wäre dann kein korrektes Clojure-Programm mehr. Die
> Verwendung von `;=>` anstatt z.B. `;->` soll an die Ausgabe `=>` der REPL
> erinnern. Ansonsten hat das keine besondere Bedeutung.

### `map`

Mit `filter` konnten wir **unerwünschte** Elemente aus der Collection `<coll>`
**entfernen**.

Nun möchten wir eine Funktion `<f>` auf alle Elemente `<e>` einer Collection
`<coll>` anwenden und als Ergebnis die Collection der **Funktionsergebnisse**
`(<f> <e>)`. Die Funktion `<f>` muss in diesem Fall wieder einstellig sein.

Dazu nutzen wir die Funktion `(map <f> <coll>)`.

```
(into #{} (map inc [4 22 56])) ;=> #{5 23 57}
```

Die Funktion `map` kann aber auch mit mehr als einer Collection als Argument
aufgerufen werden: `(map <f> <coll-1> <coll-2> ,,, <coll-n>)`. In diesem Fall
wird die Funktion `<f>` mit `(<f> <e-1> <e-2> ,,, <e-n>)` aufgerufen. D.h., die
**Stelligkeit** der Funktion `<f>` muss zu der Anzahl der Argumente passen, die
wir beim Aufruf von `map` angeben.

> Wir könnten die Funktion auch so schreiben: `(map <f> <coll> <colls*>)`. Das
> `*`-Zeichen soll hier bedeuten, dass die betreffende Form optional ist und
> beliebig häufig vorkommen kann. Also 0-mal, 1-mal oder eben viele Male.  
> Wir werden später auch das `?`-Zeichen verwenden, um auszudrücken, dass eine
> Form 0-mal oder 1-mal auftritt (z.B. `<coll?>`), also optional ist.  
> Diese Schreibweise ist an die [Regulären
> Ausdrücke](https://de.wikipedia.org/wiki/Regul%C3%A4rer_Ausdruck) angelehnt,
> die wir uns später auch noch anschauen werden.

Wir können z.B. `+` nutzen:

> Die Funktion `(+ <nums*>)` hat eine **beliebige Stelligkeit**. Sie akzeptiert
> 0 bis n Argumente, die jedoch Zahlen sein müssen.

```
(map + [9 5 1] [3 6 8] [1 2 3]) ;=> (13 13 12)
```

**Übungen**:

* Zu was wertet `(list? (filter even? [1 2 3 4]))` aus?
* Zu was wertet `(seq? (filter even? [1 2 3 4]))` aus? 
* Zu was wertet `(filter odd? [2 4])` aus?
* Zu was wertet `(filter odd? nil)` aus? Macht das Sinn?
* Nutze `filter` und das Prädikat `number?`, um die Zahlen aus der Liste `(1
  "zwei" drei 4 )` zu filtern.
* Nutze `filter`, `into` und das Prädikat `pos?`, um die positiven Zahlen aus
  der Menge `#{0 "a" 1 foo -3.14 42}` zu filtern und als Menge zu liefern.
* Zu was wertet `(map str "foobar")` aus? Macht das Sinn? 
* Zu was wertet `(map > [9 5 1] [3 6 8] [1 2 3])` aus?
* Nutze `into`, `map` und `vector`, um aus `[1 2 3]` und `"abc"` die Map `{1
  "a", 2 "b", 3 "c"}` zu erzeugen.

-------------------------------------------------------------------------------
## Lokale Namen: `let`

**Aufgabe**: erstelle einen Vektor mit drei Elementen, der als erstes Element
die Summe von **5**, **3** und **54** enthält. Das zweite Element des Vektors
soll die Summe des ersten Elements und **42** sein. Und als drittes Element soll
der Vektor die Differenz von **100** und dem ersten Element enthalten.

Die Lösung könnte so aussehen:

```
[(+ 5 3 54), (+ (+ 5 3 54) 42), (- 100 (+ 5 3 54))] ;=> [62 104 38]
```

Das ist aber doch sehr umständlich und wir müssen die gleiche Form `(+ 5 3 54)`
mehrfach wiederholen.

> Durch diese Wiederholung entsteht zum einen die Gefahr, dass wir uns vertun
> und versehentlich vielleicht **45** anstatt **54** schreiben und zum anderen
> muss die Form `(+ 5 3 54)` ja mehrfach berechnet werden und das ist ja völlig
> überflüssig.

Mit [`let`](https://clojuredocs.org/clojure.core/let) haben wir die Möglichkeit,
einen **Wert** an einen **Namen zu binden** und diesen Namen anschließend (ggf.
mehrfach) zu verwenden.

In dem folgenden Beispiel **binden** wir den **Wert** der Form `(+ 5 3 54)` --
also **62** -- an den Namen `s`. Die Form wird nur einmalig ausgewertet und an
den Namen gebunden. Anschließend nutzen wir den **Namen** `s` mehrfach. Wir
wiederholen in diesem Fall den **Namen** `s` mehrfach, aber es besteht nicht die
Gefahr, dass wir uns vertun und der Wert wird nur einmal berechnet.

```
(let [s (+ 5 3 54)]
  [s, (+ s 42), (- 100 s)]) ;=> [62 104 38]
```

Die Form `(let [<name-form-paare*>] <forms*>)` wertet dabei zu dem **Wert** der
letzten `<form>` aus. Die `name-form-paare` bestehen jeweils aus einem **Namen**
(einem **Symbol**) und einer **Form**. `let` wertet die `form` der
`<name-form-paare*>` in dem Vektor der Reihe nach aus und **bindet** das
jeweilige Ergebnis/Wert an den angegeben Namen/Symbol. Sobald ein Name gebunden
ist, kann er anschließend sowohl in den folgenden `name-form`-Paaren verwendet
werden als auch in den anschließenden `<forms*>`.

Du kannst also auch dies schreiben:

> In dem folgenden Beispiel habe ich einige Zeilen **eingerückt**, um die
> Lesbarkeit zu verbessern. Die Einrückungen helfen dir, zu verstehen, welche
> Teile/Formen auf welche Weise zueinander gehören. Für die REPL sind die
> Einrückungen völlig irrelevant. Wir könnten den Code auch so schreiben: `(let
> [s (+ 5 3 54) m (+ s 42) q (- 100 s)] [s m q])`. Aber das wäre deutlich
> schwerer zu verstehen. Es gibt auch
> [Empfehlungen](https://github.com/bbatsov/clojure-style-guide#body-indentation),
> wie Einrückungen erfolgen sollten. 

```
(let [s (+ 5 3 54)
      m (+ s 42)
      q (- 100 s)]
  [s m q])
```

Hier haben wir den Namen `m` an den Wert der Form `(+ s 42)` gebunden. Das
können wir, weil wir den Namen `s` in dem `let` **zuvor** schon an den Wert `62`
gebunden haben.

> Oben hatten wir uns angeschaut, wie **Symbole** von der REPL ausgewertet
> werden. Lies es dir gerne nochmal durch. Wir müssen nun hinzufügen, dass die
> REPL bei der Auswertung eines Symbols (wie z.B. `m`) erst prüft, ob der Name
> in einem **umschließenden** `let` gebunden ist. Falls ja, wertet das Symbol zu
> diesem Wert dieser Bindung aus. Andernfalls wird, wie oben erläutert, in dem
> **Namespace** nachgeschaut.  
> Wir sprechen in diesem Fall von einem **lexikalischen Scope** --- der
> **Sichtbarkeit** des Namen. In dem Artikel zu
> [Variablen](https://de.wikipedia.org/wiki/Variable_(Programmierung)#Sichtbarkeitsbereich_von_Variablen_(Scope))
> findest du vielleicht ein paar hilfreiche Erläuterungen.  
> **WICHTIG**: in vielen Programmiersprachen gibt es **Variablen** --- das sind
> Namen, die über die Zeit ihren Wert durch eine **Wertzuweisung** **ändern**
> können. Die Namen, die durch `let` an Werte gebunden werden, sind **keine**
> **Variablen**. Wir schauen uns das später nochmal an. 

Die `let` Formen können auch geschachtelt sein. Jedes `let` baut seinen eigenen
Sichtbarkeitsbereich auf: alle Formen **in** bzw. **unter** einem `let` können
die Namen dieses `lets` **sehen** --- d.h., **unter** dem `let` kannst du die in
dem `let` gebundenen Namen verwenden.

```
(let [s (+ 5 3 54)]
  (let [m (+ s 42)]
    (let [q (- 100 s)]
      [s m q])))
```

> Ist dir aufgefallen, dass das `let` **ganz anders ausgewertet** wird als alle
> anderen Formen, die wir bisher gesehen haben? Bisher hatten wir immer gesagt,
> dass in einer Liste alle Formen in der Liste ausgewertet werden und dass das
> erste Element zu einer **Funktion** auswerten muss und dann diese **Funktion
> aufgerufen** wird. Im Fall von `let` wird aber der Vektor mit den
> `<name-form-paare*>` nicht **ausgewertet** --- ansonsten müsste ja in dem
> Beispiel oben das Symbol `s` **ausgewertet** werden und genau das passiert ja
> gerade **nicht**. Stattdessen wird **ein Name definiert** und an einen Wert
> gebunden (der durch die Auswertung der Form entsteht).   
> `let` ist eine **[special
> form](https://clojure.org/reference/special_forms#let)** und die **special
> forms** haben individuelle Auswertungsregeln. Zum Glück gibt es nur wenige
> **[special
> forms](https://en.wikibooks.org/wiki/Learning_Clojure/Special_Forms)**.

**Übungen**:

* Zu was wertet `(let [a 1])` aus? Macht das Sinn? 
* Zu was wertet `(let [a 1] [a 1])` aus? Wieso?
* Zu was wertet `(let [a 1] [a 1] [a 2])` aus? Wieso?
* Zu was wertet die folgende Form aus? Wieso?
```
(let [a 1]
  (let [a 2] 
    a)
  a)
```
* Zu was wertet die folgende Form aus? Wieso? Erkennst du die *Falle*?
```
(let [a 1]
  (let [a 2] 
    a
  a))
```

### Sichtbarkeit und Verschattung

Zu was wertet diese Form aus?

```
(let [s 1
      s 2]
  s)      
```

Sie wertet zu **2** aus. Die Erklärung ist ganz einfach: das `let` baut einen
**Scope** auf und in diesem **bindet** es den Wert **1** an den Namen `s`.
Anschließend baut das `let` **unter** (geschachtelt) diesem ersten **Scope**
einen **zweiten** Scope auf und in **diesem** wird der Name `s` an den Wert
**2** gebunden. Nun wird **unter** diesem zweiten Scope der Name `s`
**ausgewertet**. Die REPL schaut nun **von unten** die geschachtelten Scopes
**nach oben** und findet als erstes die Bindung von `s` an den Wert **2** im
zweiten Scope. Die REPL sucht nun nicht weiter in dem oberen Scope, wo sie für
den Namen `s` ja den Wert **1** finden würde.

Wir sagen, dass die Bindung im unteren oder **inneren** Scope den Namen bzw. die
Bindung im oberen/äußeren Scope **verschattet** oder **überlagert**. Die
obere/äußere Bindung ist also aus dem inneren Scope heraus nicht
**[sichtbar](https://de.wikipedia.org/wiki/Sichtbarkeit_(Programmierung))**.

**WICHTIG**: Oben haben wir gesagt, dass es **keine Variablen** in Clojure gibt.
Auch das vorangegangene Beispiel ist **kein** Beispiel für eine **Variable**!!
Hier wurde **nichts geändert**! Wenn ein Name in einem Scope einmal an einen
Wert gebunden ist, dann ist diese Bindung **unveränderlich**.

**Beispiel**:

> Wir nutzen hier die Tatsache aus, dass wir im `let` mehrere Formen angeben
> können. Dazu kommen wir gleich im folgenden Abschnitt noch im Detail.

```
(let [s 1]
  (println "a: s =" s)
  (let [s 2]
    (println "b: s =" s))
  (println "c: s =" s))
```

**Ausgabe**:

```
a: s = 1
b: s = 2
c: s = 1
nil
```

An der Ausgabe kannst du gut erkennen, dass es sich bei `s` um **keine
Variable** handelt. Das `let` ist **keine Wertzuweisung**. Andernfalls würde für
den Fall "c:" der Wert **2** anstatt **1** ausgegeben.

Du kannst aber nicht nur **lokale** Namen verschatten, sondern auch Namen, die
in Namespaces gebunden sind (wie z.B. die Funktion `+`).

**Übungen**:

* Zu was wertet die folgende Form aus? Wieso?

> So etwas solltest du niemals tun! Das ist extrem verwirrend!

```
(let [+ -]
  (+ 4 1))
```

* Zu was wertet die folgende Form aus? Wieso?

```
((let [+ -] +) 4 1)
```

* Zu was wertet die folgende Form aus? Wieso?

```
((let [* - - +] + - *) 4 1)
```

* Zu was wertet die Form `let` aus? Wie deutest du das Ergebnis?

### Seiteneffekte

Oben haben wir gesagt, dass die `let`-Special-Form folgende Syntax hat: `(let
[<name-form-paare*>] <forms*>)`. D.h., nach dem Vektor mit den
`<name-form>`-Paaren steht eine ggf. leere Folge von Formen `<forms*>`. Diese
Formen werden alle der Reihe nach ausgewertet und der **Wert der letzten Form
ist der Wert, zu dem die `let`-Form auswertet**.

Wenn aber nur der Wert der **letzten** Form als Rückgabewert nach außen gegeben
wird, welchen Sinn macht es dann überhaupt, mehrere Formen angeben zu können?!
Diese können ja weder **etwas nach außen geben** (da ja nur der Wert der letzten
Form als Wert des `let` geliefert wird), noch können sie innerhalb der
`let`-Form **verwendet** werden, weil sie ja nirgends als Argument auftreten
können, da sie ja nicht an einen Namen gebunden sind!?!?!?

Die Antwort ist, dass wir mit diesen *unnützen* Formen *Dinge* tun können, die
man **Seiteneffekte** nennt.

> Die Bedeutung der Bezeichnung *Seiteneffekt* wird von verschiedenen Leuten
> durchaus unterschiedlich gesehen. Wir wollen im Zusammenhang mit Clojure unter
> der Bezeichnung *Seiteneffekt* alle Dinge verstehen, die nicht direkt etwas
> mit der Auswertung von Formen zu tun hat. Wir werden davon einige wenige
> kennenlernen.  
> Falls dich das Thema interessiert, findest du
> [hier](https://de.wikipedia.org/wiki/Wirkung_(Informatik)) und
> [hier](https://de.wikipedia.org/wiki/Funktionale_Programmierung) noch
> weiterführende Information. Seiteneffekte solltest du so weit wie möglich
> vermeiden, weil sie dazu führen, dass deine Funktionen nicht [referenziell
> transparent](https://en.wikipedia.org/wiki/Referential_transparency) sind.

Die erste Art von Seiteneffekt ist die **Ausgabe** von Werten mit Hilfe der
Funktion [`println`](https://clojuredocs.org/clojure.core/println). Wir haben
die Funktion ja schon mehrfach verwendet, um Texte/Werte auszugeben. Nun wollen
wir sie nutzen, um Werte auszugeben, die in einem `let` an Namen gebunden sind,
aber nicht explizit über den Rückgabewert nach außen geliefert werden.

**Beispiel**: die folgende Form wertet zu **78** aus. Wir können aber nicht
direkt erkennen, welchen Wert die Namen `a` und `b` intern haben. Wir erfahren
nur das Endergebnis.

```
(let [a (+ 4 8)
      b (* a 3)]
  (+ b 42)) ;=> 78
```

Wir könnten die Form ändern:

```
(let [a (+ 4 8)
      b (* a 3)]
  [a b (+ b 42)]) ;=> [12 36 78]
```

Oder so:

```
(let [a (+ 4 8)
      b (* a 3)]
  {"a" a "b" b "Ergebnis" (+ b 42)}) ;=> {"a" 12, "b" 36, "Ergebnis" 78}
```

> Aber beide *Lösungen* ändern ja unser Programm! Das ursprüngliche Programm hat
> eine **Zahl** geliefert. Die beiden Alternativen liefern einen **Vektor** bzw.
> eine **Map**. Falls also jemand unser Programm nutzt, um in ihrem/seinen
> Programm eine Zahl zu berechnen und auch davon ausgeht, dass er eine Zahl von
> unserem Programm geliefert bekommt, würde das Programm wohl nach unserer
> Änderung **scheitern**. D.h., es würde nicht mehr funktionieren und zu einer
> Fehlermeldung führen.
> 
> So eine Änderung wie jene, die wir oben gemacht haben, nennt man einen
> *Breaking Change* (eine *brechende Änderung*). Also eine Programmänderung, die
> dazu führt, dass andere Programme, die dieses Programm nutzen, nach der
> Änderung nicht mehr korrekt funktionieren -- eben **zerbrechen**.

Aber wir können `println` nutzen:

> Ich schreibe `;a, b = 12 , 36` um zu verdeutlichen, dass es sich um eine
> **Ausgabe** durch einen Seiteneffekt handelt. Die Schreibweise `;=> 78`
> bedeutet, dass die REPL den **Rückgabewert** der Form **ausgibt** (was auch
> eine Form von Seiteneffekt ist).

```
(let [a (+ 4 8)
      b (* a 3)]
  (println "a, b = " a "," b)
  (+ b 42))
;a, b = 12 , 36
;=> 78  
```

Du kannst Seiteneffekte aber auch innerhalb des `<name-form-paare*>` Vektors
nutzen:

```
(let [a (+ 4 8)
      b (* a 3)
      _ (println "a, b = " a "," b)]
  (+ b 42))
;a, b = 12 , 36
;=> 78  
```

> Der **Unterstrichs** (`_`) (engl. *underscore*) ist in Clojure ein *ganz
> normales Zeichen* und kann als Symbol/Name verwendet werden. Es gibt eine
> Konvention in der Clojure-Community, den Underscore zu nutzen, um
> auszudrücken, dass eine gewisse Stelle im Code zwar mit einem Namen oder Wert
> versorgt/besetzt werden muss, dass wir uns für diesen Namen/Wert aber nicht
> interessieren. Du kannst ihn aber genau so einsetzen wie den Namen `s` oder
> `a`. Beispiel: `(let [_ 42] _) ;=> 42` Oder auch: `(let [_egal 42] _egal) ;=>
> 42` oder `(let [ganz_egal 42] ganz_egal) ;=> 42`.
>
> Hinweis: in Clojure ist es üblich, als *Worttrenner* das Minuszeichen und
> nicht den Underscore zu verwenden. Wir würden also nicht `ganz_egal`
> (*snake_case*) sondern eher `ganz-egal`
> ([*kebab-case*](https://juniortoexpert.com/de/namenskonvention-fur-variablen/))
> oder von mir aus auch `_ganz-egal` schreiben.

Oder auch:

> Im folgenden Beispiel verschattet die zweite Bindung von `_` die erste. Da wir
> aber weder an der ersten noch an der zweiten interessiert sind, ist das kein
> Problem.

```
(let [a (+ 4 8)
      _ (println "a = " a)
      b (* a 3)
      _ (println "b = " b)]
  (+ b 42))
;a = 12
;b = 36
;=> 78
```

**Übungen**:

* Zu welchem **Wert** wertet `(println "foobar")` aus?
* Zu welchem **Wert** wertet `[(println "foo") (println "bar")]` aus?

-------------------------------------------------------------------------------
## `prn` und `println`

Wir werden beim Debuggen regelmäßig `println` nutzen, um nachvollziehen zu
können, was unser Programm eigentlich tut. 

Dabei musst du berücksichtigen, dass `println` für Strings den **Wert** aber
nicht die **Form** ausgibt.

In dem folgenden Beispiel können wir in der `println` Ausgabe nicht erkennen,
dass es sich bei `42` um einen String handelt und nicht um eine Zahl (wie bei
`4711`).

```
(println ["42" 4711])
;[42 4711]
;=> nil
```

Wir sollten uns daher angewöhnen, für Debug-Ausgaben `prn` anstatt `println` zu
verwenden. `prn` gibt die Werte als **Form** aus, so wie es auch die REPL tut.
Damit können wir dann auch Strings von Zahlen unterscheiden.

```
(let [v ["42" 4711]] (println v) (prn v) v)
;[42 4711]
;["42" 4711]
;=> ["42" 4711]

(let [x #{1 2 3} y #{"1" "2" "3"}] (println x y) (prn x y))
;#{1 2 3} #{1 2 3}
;#{1 2 3} #{"1" "2" "3"}
;=> nil
```

-------------------------------------------------------------------------------
## Funktionen definieren

Bisher haben wir viele Funktionen kennengelernt und wir wissen, wie wir diese
Funktionen **ausführen** und dabei Daten/Werte als **Argumente** übergeben
können und wie wir den **Rückgabewert** der Funktionen weiterverarbeiten können.
All das wird durch die **Auswertungsregeln** der REPL festgelegt.

Aber bisher konnte wir selber noch keine **neue Funktion erschaffen** --- wir
konnten sie nur nutzen.

### `fn`

Um eine Funktion zu erschaffen nutzen wir `(fn [<parameter*>] <forms*>)`.

> Klar -- um eine Funktion zu definieren, nutzen wir eine Funktion ....

> `fn` ist keine Funktion, sondern eine special form. `fn` bietet sehr viele
> verschiedene Features, die dir helfen, deine Funktionen zu definieren. Wir
> führen hier erstmal nur wenige auf. Später kommt dann mehr.

Wir können z.B. eine Funktion definieren, die zu einer Zahl `x` das Quadrat `(*
x x)` liefert: `(fn [x] (* x x)) ;=> #object[Function]`

Der Parameter-Vektor `[<parameter*>]` beschreibt, an welche **lokale Namen**
(vgl. `let`) beim Aufruf der Funktion die **Argumentwerte** gebunden werden. Das
`fn` macht also (genau wie `let`) einen Scope auf, in dem die angegebenen
Namen/Symbole an die übergebenen Werte/Argumente gebunden sind.

> Allerdings haben wir bei `let` Name-**Wert**-Paare. Das ist ja auch klar, weil
> das `let` ja die Bindung der Werte an die Namen übernimmt. Bei `fn` geben wir
> nur die **Namen** an. Die Bindung an die konkreten Werte erfolgt dann ja durch
> den **Funktionsaufruf**, bei dem die **Argument-Werte** an die
> **Funktions-Parameter** gebunden werden.

Die Formen `<forms*>` beschreiben, was deine Funktion tun soll. Dabei kannst du
auf die gebundenen Namen (und damit auf die Argumentwerte) zugreifen. Der Wert
der **letzten Form** ist jener Wert, der von deiner Funktion als
**Rückgabewert** geliefert wird (genau so wie bei `let`).

> Es gibt in Clojure keine `return`-Anweisung, einfach, weil wir sie nicht
> brauchen. Die letzte Form einer `fn`-Form bestimmt, welches der Rückgabewert
> ist.

OK, jetzt haben wir zwar eine Funktion definiert, aber wie rufen wir sie auf?

> Lies dir nochmal den Abschnitt mit der Auswertungsregel durch.

Wir setzen sie an die **erste Stelle einer Listen-Form** --- so wie wir es die
ganze Zeit schon getan haben.

> Schau dir die Form genau an: die Form `(fn ,,,)` **liefert eine Funktion** ---
> sie wertet die Funktion **nicht** aus! Erst die **umschließend Form** (die
> Liste/Klammern) `((fn ,,,) ,,,)` wertet die Funktion aus bzw. ruft die
> Funktion auf.

```
((fn [x] (* x x)) 5) ;=> 25
```

Du kannst natürlich auch eine Funktion mit mehr als einem Parameter definieren.
Das erste Argument (in diesem Fall **5**) wird an den ersten Parameter/Namen (in
diesem Fall `x`) gebunden, das zweite Argument an den zweiten Parameter usw.
Diese Art der Parameterübergabe nennt man
[**Positionsparameter**](https://de.wikipedia.org/wiki/Parameter_(Informatik)#Unterschiedliche_Parameter-Begriffe).

> Positionsparameter haben den Nachteil, dass du an der Stelle, an der du die
> Funktion aufrufst (engl. [call
> site](https://en.wikipedia.org/wiki/Call_site)), nicht direkt erkennen kannst,
> an welchen Namen die von dir übergebenen Werte in der Funktion gebunden
> werden. Z.B. kann es vorkommen, dass du anstatt `(map inc [1 2 3])` zu
> schreiben, versehentlich `(map [1 2 3] inc)` schreibst, weil du irrtümlich
> denkst, dass bei `map` erst die Collection und dann die Funktion übergeben
> wird. Wir werden später sehen, dass es andere Arten der Parameterübergabe
> gibt, die dieses Problem nicht haben.

```
((fn [x y] (+ x y)) 5 3) ;=> 8
```

Du kannst der Funktion aber auch einen lokalen Namen geben, dann wird
deutlicher, was die Funktion tut (bzw. tun **soll**).

> Niemand kann garantieren, dass eine Funktion mit dem Namen `plus` wirklich
> eine Addition durchführt.

```
(let [plus (fn [x y] 
             (+ x y))]
  [(plus 3 5) (plus 7 8)])
;=> [8 15]
```

Neben der *ausführlichen* Definitionsform einer Funktion mit Hilfe von `fn` gibt
es noch eine **Kurzform**: `#(<form-mit-%>)`

> Diese Kurzform fügt **keine neue Funktionalität hinzu**. Wir brauchen sie
> eigentlich nicht, denn wir könnten immer `fn` anstatt der Kurzform nutzen.
> Aber die Kurzform erspart uns etwas Schreibarbeit und der Code wird noch
> kompakter. Wir mögen sie --- vielleicht wie ein Stück Schokolade. Daher nennt
> man solche Kurzformen allgemein auch [syntaktischen
> Zucker](https://de.wikipedia.org/wiki/Syntaktischer_Zucker).

In der Kurzform kannst du das Prozentzeichen (`%`) zusammen mit einer Zahl (1,
2, ...) nutzen, um auf die Argumentwerte zuzugreifen. Dabei ist `%1` das erste
Argument, `%2` das zweite Argument u.s.w.

Wir können also anstatt `((fn [x y] (+ x y)) 5 3) ;=> 8` folgendes schreiben:

```
(#(+ %1 %2) 5 3) ;=> 8
```

Du könntest aber auch folgendes schreiben:

```
(#(+ %2 %1) 5 3) ;=> 8
```

Die Kurzform `#(+ %1 %2)` anspricht der Langform `(fn [x y] (+ x y))`.

> Schau dir die Kurzform und die Form in der `fn` an: siehst du die Ähnlichkeit?

Die Kurzform wird häufig im Zusammenhang mit anderen HOFs genutzt.

**Beispiele:**

> Die Angabe `%` ohne Zahl ist gleichbedeutend mit `%1`. Das `%` darf auch
> mehrfach vorkommen: `(#(+ % %) 2) ;=> 4`

```
(filter #(> % 3) (range 10)) ;=> (4 5 6 7 8 9)
(map #(* %1 %1) (range 5)) ;=> (0 1 4 9 16)
```

**Übungen:**

* Zu was wertet `fn` aus? Macht das Sinn?
* Zu was wertet `(fn)` aus? Macht das Sinn?
* Zu was wertet `((fn [x x] x) 1 2)` aus? Macht das Sinn? Könnte das mit `let`
  zusammenhängen?
* Zu was wertet `((fn [x _] x) 1 2)` aus? Macht das Sinn?
* Zu was wertet `(fn [] *)` aus? Wieso?
* Zu was wertet `((fn [] *))` aus? Wieso?
* Zu was wertet `(((fn [] *)))` aus? Wieso?
* Zu was wertet `((((fn [] *))))` aus? Wieso?

### `defn`

Mit `fn` kannst du zwar Funktionen definieren und aufrufen, aber du musst die
Funktion immer **lokal definieren**, um sie verwenden zu können. Die anderen
Funktionen, die wir die ganze Zeit schon nutzen (wie z.B. `inc` und `pos?`),
können wir scheinbar nutzen, ohne sie zuvor lokal definieren zu müssen. Wieso?

Der Grund ist, dass diese Symbole (`inc`, `pos?`) in einem **Namespace** an die
jeweilige Funktion **gebunden** sind. Oben hatte wir schon darüber gesprochen,
dass die REPL bei der **Auswertung von Symbolen** erst in den lokalen `let`/`fn`
Scopes nach den Bindungen der Symbole sucht und am Ende noch im Namespace, falls
in den lokalen Scopes keine Bindung gefunden wird.

> Wir sagen im Falle der Namespaces auch *gebunden* wie bei `let` und `fn`, aber
> der Mechanismus funktioniert ganz anders. Wir schauen uns das später noch
> genauer an.

Daher können wir sie von überall her nutzen.

Mit `(defn <name> [<parameter*>] <forms*>)` kannst du **deine eigenen
Funktionen** auch in diesen Namespace hinterlegen/binden, so dass die REPL deine
Funktionsnamen **anschließend** ebenfalls dort findet.

Im Vergleich zu `fn` ist hier nur der Name der Funktion `<name>` hinzugekommen.

```
(defn plus [x y]
  (+ x y))
;=> #'user/plus

plus
;=> #object[Function]

(plus 4 6)
;=> 10
```

> Ich hatte schon mehrfach gesagt, dass es in Clojure keine **Variablen** gäbe.
> Das ist im Prinzip auch richtig, aber es gibt dennoch Dinge, die sich
> **ändern** können. Die Namespaces sind so ein Ding.  
> Mit `defn` tust du **zwei** Dinge.  
> 1) Du konstruierst eine Funktion (so wie mit `fn`)  
> 2) Du bindest diese Funktion im Namespace (mit dem Namen `user`; dazu später
>    mehr) an den angegebenen Namen/Symbol.  
> Und dies kannst du **beliebig häufig wiederholen**. Und jedes Mal, **nachdem**
> du mit `defn` die Funktion definiert/gebunden hast, **ändert** sich vielleicht
> das, was diese Funktion tut. Man könnte also der Meinung sein, es handelt sich
> um eine **Variable**. Wir müssen also erkennen, dass es in Clojure zwar keine
> **änderbaren** **Variablen** wie in vielen anderen Programmiersprachen gibt,
> aber dennoch gibt es sog. **Vars**, die ähnlich funktionieren. Wir lernen
> später noch die Vars kennen und werden dann aber sehen, dass sie viel mehr
> können, als gewöhnliche Variablen.

**Beispiel:** Wir `defn` erst die Funktion `plus`, rufen sie auf und erhalten
den Wert **10**: `(plus 4 6) ;=> 10`. Anschließend `defn` wir **erneut** die
Funktion `plus` und nun liefert die gleiche Form `(plus 4 6) ;=> 24` einen
**anderen Wert** (**24**).

```
(defn plus [x y]
  (+ x y))
;=> #'user/plus

(plus 4 6)
;=> 10

(defn plus [x y]
  (* x y))
;=> #'user/plus

(plus 4 6)
;=> 24
```

> Die Erklärung ist ganz einfach: beim zweiten `plus` Aufruf wird jene Funktion
> aufgerufen, die wir mit dem zweiten `defn` definiert und an den Namen `plus`
> in dem Namespace gebunden haben. D.h., es kommt nun darauf an, **wann** bzw.
> in welchem **Zustand des Namespaces** wir die Funktion `plus` aufrufen.  
> Das ist nicht gut! In der Funktionalen Programmierung möchte man sich gerne
> darauf verlassen, dass ein Ausdruck wie `(plus 4 6)` **immer den gleichen
> Wert** liefert, egal wann oder wie häufig man ihn aufruft.  
> Daher werden wir `defn` (und später auch `def`) nicht dazu nutzen, **während
> unseres Programmlaufs** Dinge zu verändern, sondern wir nutzen die Möglichkeit
> zur Veränderung nur **während wir programmieren**.

-------------------------------------------------------------------------------
## Wahrheit und nochmal Prädikate

Wir haben gesagt, dass Prädikate Funktionen sind, die `true` oder `false`
liefern. Also Werte des **Boolean** Datentyps. Und diese Prädikate kannst du
nutzen, um z.B. die Elemente einer Collection zu filtern.

In diesem Beispiel ist `#(> % 3)` ein Prädikat.

```
(filter #(> % 3) (range 10)) ;=> (4 5 6 7 8 9)
(#(> % 3) 4) ;=> true
(#(> % 3) 2) ;=> false
```

Für den Boolean-Datentyp gibt es einige Operatoren/Funktionen/Makros, mit denen
wir **Boolean-Werte** verknüpfen können. Wir nennen diese Operatoren logische
bzw. [boolsche Operatoren](https://de.wikipedia.org/wiki/Boolescher_Operator):
`and`, `or` und `not`.

```
(and true true) ;=> true
(and true false) ;=> false
(or true true) ;=> true
(or true false) ;=> true
(or false false) ;=> false
(not true) ;=> false
(not false) ;=> true
```

In Clojure unterscheiden wir jedoch zwischen **Boolean** (`true` und `false`)
und **logisch wahr** und **logisch falsch**. Es gibt genau zwei Werte, die
**logisch falsch** sind: `false` und `nil`. **Alle anderen Werte sind logisch
wahr**.

Da die Bezeichnungen **logisch wahr** und **logisch falsch** etwas umständlich
und vielleicht auch irreführend sind, wollen wir stattdessen die Bezeichnungen
**truthy** und **falsy** verwenden.

Wir wollen aber weiterhin nur Funktionen, die `true` oder `false` liefern, als
Prädikat bezeichnen. Funktionen, die wir im Sinn von einem **Entscheider**
verwenden (und wir können im Prinzip ja **jede** Funktion in diesem Sinn
verwenden, weil **jeder** Wert entweder **truthy** oder **falsy** ist!), nennen
wir Ja-Nein-Funktion.

Die boolschen Operatoren berücksichtigen diese **erweiterte** Sichtweise von
**Wahrheit** und sind somit Ja-Nein-Funktionen:

```
(and "foo" true) ;=> true
(and true "foo") ;=> "foo"
(or true "foo") ;=> true
(or "foo" true) ;=> "foo"
(not nil) ;=> true
(not "foo") ;=> false
```

Falls du zu einem **truthy** oder **falsy** Wert den zugehörigen Boolean-Wert
`true` oder `false` haben möchtest, kannst du die Funktion `(boolean x)` nutzen:

```
(boolean "foo") ;=> true
(boolean []) ;=> true
(boolean #{42}) ;=> true
(boolean nil) ;=> false
```

> Beachte: `(boolean 0) ;=> true`

**Übungen**:

* Versuche eine Funktion `(und [x y] ,,,)` zu definieren, die sich wie `and`
  verhält. Du darfst dabei gerne `and` verwenden. Teste deine Funktion mit
  folgenden Testfällen: `(und false false)`, `(und false true)`, `(und true
  false)` und `(und true true)`. Liefert deine Funktion immer die richtigen
  Ergebnisse?
* Zu was wertet `(and false 2)` aus? Zu was wertet `(und false 2)`?
* Zu was wertet `(and false (println "oops"))` aus? Zu was wertet `(und false
  (println "oops"))`? Was passiert genau? Kannst du dir das erklären? Lies dir
  den Wikipedia-Artikel zu
  [Kurzschlussauswertung](https://de.wikipedia.org/wiki/Kurzschlussauswertung)
  durch.

-------------------------------------------------------------------------------
## Keywords

Bisher haben wir schon einige **einfache** (d.h., **unstrukturierte**)
Datentypen kennengelernt (z.B. Zahlen, Strings, Symbole). Nun kommt ein weiterer
Datentyp hinzu: **Keywords**

Keywords haben die Form `:<name>`, z.B. `:foo`, `:foobar`, `:_`. Keywords werten
(genau wie Zahlen) **zu sich selbst aus**. D.h., `:foobar ;=> :foobar`

Du kannst Keywords einfach über ihre Form als Literal hinschreiben und du kannst
sie aus einem String konstruieren: `(keyword "bar") ;=> :bar`

Keywords werden in Clojure vor allem als Schlüssel in Maps verwendet.

**Beispiel**: `{:vorname "Lena" :nachname "Schmidt" :größe-in-cm 174}`

Du kannst nun mit `get` und den Keywords auf den Wert in der Map zugreifen:

```
(get {:vorname "Lena" :nachname "Schmidt" :größe-in-cm 174} :nachname) ;=> "Schmidt"
```

```
(get {:vorname "Lena" :nachname "Schmidt" :größe-in-cm 174} :foo) ;=> nil
```

Aber Keywords haben ein **spezielles Feature**: das Keyword `<keyword>`
**verhält** sich (wenn es an der **ersten Position einer Liste** steht; also
dort, wo normalerweise immer eine **Funktion** stehen muss) wie eine **Funktion
mit einem Parameter**: `(fn [m] ,,,)`. Diese (gedachte) Funktion geht davon aus,
dass das Argument, das du bei einem **Aufruf** übergibst, eine **Map** ist. Die
Funktion zu `<keyword>` liefert dann den Wert `(get m <keyword>)`.

Die *gedachte* Funktion zum Keyword `:foo` sieht also etwa so aus:

```
(fn [m]
  (get m :foo))
```

Dadurch kannst du noch kompakteren Code schreiben:

```
(:nachname {:vorname "Lena" :nachname "Schmidt" :größe-in-cm 174}) ;=> "Schmidt"
```

Die anderen Datentypen (wie Strings und Zahlen) kannst du natürlich auch als
Schlüssel in deiner Map verwenden, nur verhalten sich diese **nicht** wie eine
Funktion.

```
(get {"foo" 42 "bar" 23} "bar") ;=> 23
("bar" {"foo" 42 "bar" 23}) ---> Cannot call "bar" as a function.
```

Da sich Keywords wie eine Funktion verhalten, kannst du sie auch zusammen mit
higher-order-functions als **Funktions-Argument** verwenden:

**Beispiele**: 

* Wir nutzen `:foo`, um alle jene Map-Elemente aus der Collection zu liefern,
  die einen `:foo` Eintrag haben.

```
(filter :foo [{:bar 2 :foobar 4} {:bar 1 :foo 2} {:foo 5}])
;=> ({:bar 1, :foo 2} {:foo 5})
```

> Das müssen wir uns nochmal in Ruhe anschauen: wir wollen aus einer Folge von
> Maps jene Maps erhalten, die den Schlüssel `:foo` enthalten. Dafür müssten wir
> eigentlich ein Prädikat schreiben: `(fn [x] (contains? x :foo))` bzw.
> `#(contains? % :foo)`

```
(filter #(contains? % :foo) [{:bar 2 :foobar 4} {:bar 1 :foo 2} {:foo 5}])
;=> ({:bar 1, :foo 2} {:foo 5})
```

> Aber wir können die Tatsache ausnutzen, dass uns `:foo` ja den **Wert**
> liefert, der zu dem Schlüssel `:foo` gehört und falls der Schlüssel `:foo`
> nicht enthalten ist, erhalten wir `nil` und das ist **falsy**. Das Keyword
> `:foo` verhält sich also wie eine **Ja-Nein-Funktion** (vgl. oben).  
> Allerdings hat unser Idee eine gemeine Lücke (einen **Bug!**): es könnte ja
> sein, das zu dem Schlüssel `:foo` der Wert `nil` oder `false` in der Map
> steht. Und dann würde unser *Trick* nicht funktionieren.  
> In dem folgenden Beispiel habe ich die Werte `nil` und `false` anstatt der
> Werte `2` und `5` eingesetzt. Wir sehen, dass das Programm, das `contains?`
> verwendet, **weiterhin korrekt arbeitet**. Unser Trick mit `:foo`
> **scheitert** aber, weil eben `(:foo {:bar 1 :foo nil}) ;=> nil` ist --- also
> **falsy**: `(boolean (:foo {:bar 1 :foo nil})) ;=> false` ist.

```
(filter #(contains? % :foo) [{:bar 2 :foobar 4} {:bar 1 :foo nil} {:foo false}])
({:bar 1, :foo nil} {:foo false})

(filter :foo [{:bar 2 :foobar 4} {:bar 1 :foo nil} {:foo false}])
;=> ()
```

* Und hier wenden wir `:foo` auf Mengen an: `(:foo #{:bar :foo}) ;=> :foo`

> In diesem Fall haben wir nicht das Problem mit `nil` und `false` (vgl. oben)

```
(filter :foo [#{42 :bar :foo} #{:foobar :foo} #{:bar}]) ;=> (#{42 :bar :foo} #{:foobar :foo})
```

```
(map :name [{:name "Peter" :nachname "Pan"}
            {:name "Emma" :nachname "Frost"}])
;=> ("Peter" "Emma")
```

**Übungen**:

* Zu was wertet `(fn? inc)` aus? Was macht das Prädikat `fn?`?
* Zu was wertet `(fn? :foobar)` aus? Macht das Sinn? Wie interpretierst du das
  Ergebnis?

-------------------------------------------------------------------------------
## Bedingte Verzweigung (`if`, `when`, `cond`)

Bisher wurden unsere Programme immer **der Reihe nach ausgeführt**. Die
Auswertungsregel hat den
[Kontrollfluss](https://de.wikipedia.org/wiki/Kontrollfluss) festgelegt:

> Die logischen Operatoren `and` und `or` stellen eine Ausnahme zu dieser Regel
> dar. Kannst du erklären, in welcher Weise es sich um eine Ausnahme handelt?

**Listen-Formen** werden dadurch ausgewertet, dass die **Elemente der Liste**
ausgewertet werden (dies ist eine rekursive Definition! Die Elemente können
ihrerseits wieder Listen sein) und dann jene **Funktion** aufgerufen wird, die
sich durch die Auswertung des ersten Listen-Elements ergibt. Die
Auswertungs-Werte der übrigen Listen-Elemente werden dieser Funktion beim Aufruf
als Argumente übergeben.

Durch diese Regel ist es **unmöglich**, **Fallunterscheidungen** zu treffen: wir
können bisher nicht ausdrücken, dass wir unsere Programm in bestimmten Fällen
anders fortsetzen möchten, als in anderen, weil die Auswertungsregel dies nicht
zulässt: **sie wertet immer alle Formen aus**. Um unser Programm
situationsbedingt in **verschiedene** Richtungen weiter laufen zu lassen,
brauchen wir [bedingte
Anweisungen](https://de.wikipedia.org/wiki/Bedingte_Anweisung_und_Verzweigung).

> In Clojure gibt es keine **Anweisungen**, sondern es handelt sich auch bei
> [`if` und `cond` um **Ausdrücke**](https://clojure.org/guides/learn/flow) ---
> also Dingen, die einen **Wert** haben.

### `if`

Mit `if` können wir eine **Fallunterscheidung** treffen. D.h., wir prüfen, ob
ein bestimmter **Sachverhalt gilt oder nicht**. Und je nachdem, ob die Antwort
*ja* oder *nein* ist, wird unser Programm in die eine Richtung oder die andere
fortgesetzt.

Die `if`-Form sieht wie folgt aus: `(if <cond> <then-form> <else-form>)` 

Der **Sachverhalt**, den wir prüfen, wird als **Konditional** (Bedingung)
`<cond>` formuliert. Der Wert von `<cond>` wird als Ja-Nein-Wert interpretiert.
D.h., wir sind nicht gezwungen, `true` oder `false` zu verwenden, sondern können
auch `nil` oder `"TOLL!"` als Bedingung verwenden.

Wenn die `if`-Form ausgewertet wird, wird als erstes `<cond>` ausgewertet. Die
`<then-form>` und die `else-form` werden **noch nicht ausgewertet**.

> Das ist eine Ausnahme, zu der oben beschriebenen Auswertungsregel. Kannst du
> erklären, wieso?

Falls `<cond>` zu **truthy** auswertet, wird anschließend die `<then-form>`
ausgewertet und der Auswertungs-Wert wird als Wert der `if`-Form geliefert. Die
`<else-form>` wird in diesem Fall also **gar nicht ausgewertet**.

Andernfalls (also falls `<cond>` **nicht** zu **truthy** auswertet) wird
anschließend die `<else-form>` ausgewertet und der Auswertungs-Wert wird als
Wert der `if`-Form geliefert. Die `<then-form>` wird in diesem Fall also **gar
nicht ausgewertet**.

**Beispiele**:

```
(if (even? 2) :gerade :ungerade) ;=> :gerade
(if (even? 7) :gerade :ungerade) ;=> :ungerade
(if false :ja :nein)             ;=> :nein
(if nil :ja :nein)               ;=> :nein
(if true :ja :nein)              ;=> :ja
(if "TOLL!" :ja :nein)           ;=> :ja
```

In der `if`-Form ist die `<else-form>` **optional**. Das schreibe ich so auf:
`(if <cond> <then-form> <else-form?>)` 

> Das `?` bedeutet, dass die Form **optional** ist. Wir hatten weiter oben schon
> über diese Notation gesprochen.

Falls `<cond>` nicht **truthy** ist, wird `nil` geliefert, falls die
`<else-form>` nicht angegeben ist.

```
(if :foo :bar :foobar)  ;=> :bar
(if :foo :bar)          ;=> :bar
(if false :bar :foobar) ;=> :foobar
(if false :bar)         ;=> nil
```

**Übungen**:

* Schreibe die Funktion `(falls <cond> <then-form> <else-form>)`. Sie soll den
  `<then-form>`-Wert liefern, falls `<cond>` **truthy** ist, andernfalls soll
  sie den `<else-form>`-Wert liefern. Du darfst dabei gerne `if` verwenden.

* Was liefert `(if :foo :bar :foobar)`? Was liefert `(falls :foo :bar :foobar)`

* Was liefert `(if :foo :bar (prn "oops"))`? Was liefert `(falls :foo :bar (prn
  "oops"))`? Kannst du das Verhalten erklären? Wieso ist `falls` nicht das, was
  wir eine **bedingte Verzweigung** nennen sollten?

* Versuche mit Hilfe von `and` und `or` (und ggf. weiteren Funktionen) **einen
  Ausdruck/Form** zu schreiben, der sich wie `if` verhält. Oben haben wir schon
  gesehen, dass es nicht möglich ist, eine Funktion `falls` zu definieren, die
  sich wie `if` verhält, da die Argumente zu dieser Funktion immer schon
  ausgewertet werden, bevor die Funktion überhaupt aufgerufen wird. Der
  Ausdruck, den du finden sollst, nutzt die Kurzschluss-Semantik von `and` und
  `or`, um eben diese *vorzeitige* Auswertung der `<then-form>` und der
  `<else-form>` zu vermeiden. Teste deinen Ausdruck gründlich. Nutze dabei auch
  `<then-form>` und `<else-form>`, die zu **falsy** auswerten. Fertige eine
  Tabelle an, in der du die verschiedenen Kombinationen (bzgl. Wahrheit oder
  nicht) von `<cond>`, `<then-form>` und `<else-form>` zusammen mit dem
  Auswertungsergebnis deines Ausdrucks aufführst.

### `when`

Manchmal möchtest du bei einer Fallunterscheidung nur im Ja-Fall weitere
Berechnungen anstellen. Im Nein-Fall soll das Programm *nichts tun*.

Für diesen Fall gibt es `(when <cond> <then-forms*>)`

Die `when`-Form wertet erst `<cond>` aus und falls dies zu **truthy** auswertet,
werden anschließend die `<then-forms*>` der Reihe nach ausgewertet und der Wert
der letzten Form wird als Ergebnis der `when`-Form geliefert.

Falls `<cond>` zu **falsy** auswertet, wertet die `when`-Form zu `nil` aus.

```
(defn teile-durch [x y]
  (when (not= y 0) (/ x y)))

(teile-durch 3 2)         ;=> 1.5
(teile-durch 3 0)         ;=> nil

(when :foo :bar)          ;=> :bar
(when :foo :bar :foobar)  ;=> :foobar
(when false :bar)         ;=> nil
(when false :bar :foobar) ;=> nil
```

**Übungen:**

* Schreibt die Funktion `teile-durch` so um, dass sie statt `when` die
  Funktion/Makro `when-not` nutzt. Teste deine Funktion.
* Zu was wertet `(when (prn 0) (prn 1) (prn 2))` aus? Wieso?
* Zu was wertet `(when (or (prn 0) :yes!) (prn 1) (prn 2))` aus?

### `cond`

### `condp`

### `cond->`

### `case`


### Ausführungsbäume vs. Ausführungsfolgen

> TBD: In diesem Abschnitt möchte ich darauf hinweisen, dass imperative
> Programme vor allem aus __Folgen von Anweisungen__ bestehen. Der Programmfluss
> ergibt sich aus dieser Folge. Natürlich gibt es auch die Ausdrücke und
> Funktionsaufrufe, die am ehesten den Formen von Clojure entsprechen.  
> 
> In Clojure gibt es bis auf wenige Ausnahmen (u.a. `do`, `let`, `when`) keine
> __Folgen von Formen__. Stattdessen ergibt sich der Programmfluss durch die
> __Auswertung von rekursiven/ineinander geschachtelten Formen__. Dies kann man
> sich als einen __(Ausführungs-)Baum__ vorstellen, bei dem während der
> Auswertung beginnend an der Wurzel durch die Astgabelungen (rekursiver Abstieg
> in die geschachtelten Formen) hin zu den Blättern aufgestiegen wird. Die
> (terminalen) Werte stehen an den __Blättern__ und werden durch Auswertung (von
> Formen/Funktionen) als Wert wieder hinab zur Wurzel _reduziert_. Der _Wert des
> Programms_ ist schließlich jener, der am Ende hin zur Wurzel reduziert wurde.

-------------------------------------------------------------------------------
## Schleifen

Manchmal möchtest du in deinem Programm bestimmte Dinge *immer wieder tun*. Du
möchtest sie also **wiederholen**.

Einige Dinge möchtest du vielleicht **endlos** häufig wiederholen oder zumindest
so lange, bis dein Programm beendet wird und nicht mehr läuft.

> Kennst du technische (digitale) Geräte/Computer, die *endlos* laufen und immer
> wieder das gleiche oder zumindest etwas ähnliches tun?

Andere Dinge möchtest du so häufig wiederholen, bis **alle Daten**, die deinem
Programm übergeben wurden (z.B. die Elemente eines Vektors), **verarbeitet**
sind. 

> Fällt dir hierzu auch ein Beispiel ein? 

Und es gibt Fälle, in denen du **vorab** gar nicht sagen kannst, wie häufig du
sie wiederholen möchtest, denn die **Anzahl der Wiederholungen** ergibt sich
erst **während der Wiederholung** selbst. Du brauchst also ein
**Abbruchkriterium** (ein Prädikat), mit dem dein Programm **entscheidet**, ob
die Wiederholung beendet oder fortgeführt wird.

> Fällt dir hierzu auch ein Beispiel ein?

In der Programmierung sprechen wir im Zusammenhang mit solchen Wiederholungen
häufig von **Schleifen**. Bei jedem Durchlauf einer Schleife, wird mit dem
**aktuellen Element** (also der Information, die du in diesem
**Schleifendurchlauf** betrachten möchtest) etwas getan --- die Information (das
*Datum*; Einzahl von *Daten*, nicht im Sinne von *Tagesdatum*) wird
**verarbeitet**.

Neben der **Anzahl** der Wiederholungen unterscheiden wir aber auch, was denn
überhaupt das **Ergebnis** der wiederholten Ausführung sein soll? 

Manchmal möchtest du bei jedem Schleifendurchlauf etwas bestimmtes mit dem
aktuellen Element/Datum tun (z.B. mit `pos?` prüfen, ob eine Zahl positiv ist)
und das **Ergebnis** der **Schleife** ist eine **Folge** (z.B. ein Vektor) von
Maps der Form `[{:z <zahl> :p <boolean>},,,]` (also der betrachteten Zahl und
dem Prüfungsergebnis). In diesem Fall liefert deine Schleife also eine **Folge**
von Werten (die Maps) und die **Anzahl der Element** der Folge entspricht der
**Anzahl der Schleifendurchläufe**.

> Fällt dir dazu auch ein Beispiel ein?

Es kann aber auch sein, dass du in jedem Schleifendurchlauf prüfst, ob das
aktuelle Element eine positive Zahl ist und falls ja, soll diese Zahl als
Element in der Ergebnisfolge enthalten sein. Falls die Zahl jedoch nicht positiv
ist, soll diese Zahl eben **nicht in der Ergebnisfolge enthalten sein**. Die
**Ergebnisfolge** hat also u.U. **weniger Elemente** als die **Anzahl der
Schleifendurchläufe**.

> Fällt dir dazu auch ein Beispiel ein?

In wieder anderen Fällen möchtest du etwas berechnen, wobei du bei jedem
Schleifendurchlauf das aktuelle Element/Datum in deine Berechnung **mit
einbeziehst**, das Ergebnis deiner Berechnung ergibt sich aber erst am Ende,
wenn der letzte Schleifendurchlauf erfolgt ist. Das Ergebnis könnte z.B. die
Summe über die Elemente sein. In diesem Fall wäre das Ergebnis auch **keine**
Folge sondern nur ein Wert.

> Fällt dir dazu auch ein Beispiel ein?

> **[Schleifen](https://de.wikipedia.org/wiki/Schleife_(Programmierung))** sind
> in der Informatik ein sehr umfangreiches Thema. Wir schauen uns einfach
> mehrere Beispiele an, um Schleifen besser zu verstehen.  
> Ein sehr wichtiger Unterschied zwischen Clojures Schleifen-Konstrukten und
> jenen aus den **[imperativen
> Programmiersprachen](https://de.wikipedia.org/wiki/Imperative_Programmierung)**
> ist, dass viele von Clojures Schleifen **Ausdrücke/Expressions** sind --- sie
> also **einen Wert haben**. In den imperativen Programmiersprachen sind
> Schleifen i.d.R. **Anweisungen/Statements** --- diese beeinflussen zwar den
> Programmfluss (d.h., die steuern, welche Codezeile als nächstes ausgeführt
> wird und wie häufig die Schleife durchlaufen wird), aber sie **haben keinen
> Wert**. Ihre *Wirkung* entfalten sie ausschließlich durch **Seiteneffekte**
> (vgl. oben) --- d.h., sie setzen eine **Variable** (um z.B. eine Summe zu
> bilden) oder geben etwas aus oder sorgen dafür, dass die Methode verlassen
> wird etc. 

In vielen Fällen, in denen du in einer imperativen Programmiersprache eine
Schleife nutzen würdest, kannst du in Clojure einfach HOFs verwenden (z.B. `map`
und `filter`). D.h., du **brauchst für diese Fälle überhaupt kein
eigenständiges/explizites Schleifen-Konstrukt**.

> Das ist eine *gute Sache*. Schleifen können tückisch sein. Häufig wählt man
> Abbruchkriterien falsch, [so dass die Schleife einen Durchlauf zu viel oder zu
> wenig macht](https://de.wikipedia.org/wiki/Off-by-one-Error#Beispiele).

Wir schauen uns nun einige von Clojures Schleifen-artigen Funktionen/Makros an:

* `map`, `filter`, `remove`, `keep`
* `dotimes`
* `for`
* `reduce`
* `iterate`
* `loop`/`recur`

> Ich nutze hier den Bezeichner _Schleife_ und spreche von
> _Schleifendurchläufen_. Eigentlich wäre es besser, wenn ich stattdessen von
> _Iterationen_ und _iterieren_ sprechen würde. Denn beim _Wiederholen_ von
> Dingen ist es nicht entscheidend, dass ein Schleifenkonstrukt verwendet wird,
> sondern dass eine gewisse Funktionalität wiederholt ausgeführt wird. Und für
> diesen Sachverhalt nutzt man den Bezeichner _Iteration_. Später werden wir
> auch sehen, dass man durch _Rekursion_ ein _iteratives_ Verfahren (einen
> iterativen Prozess) implementieren kann und das ist dann eben auch keine
> Schleife. Aber ich werde einfach weiterhin von _Schleifen_ sprechen und hoffe,
> dass du verstehst, was gemeint ist. 

### `map`, `filter`, `remove`, `keep`

Diese HOFs haben wir schon kennen gelernt und ich führe sie hier nur auf, weil
sie es dir erlauben, _etwas_ wiederholt auf den Elementen einer Collection zu
tun. Sie alle nehmen eine Collection als Eingabe und liefern eine Liste/Sequence
von Funktionsauswertungen als Ergebnis, die ggf. weniger (aber niemals mehr)
Elemente hat als die Eingabe. 

Diese Formen sehen nicht aus wie _typische_ Schleifen. Sie haben und brauchen
kein explizites Abbruchkriterium, weil sie immer alle Elemente der
Eingabe-Collection verarbeiten.

### `dotimes`

`(dotimes [<name> <n>] <body>)` ist eine Funktion, die _etwas_ (den `<body>`)
`<n>`-mal ausführt und `nil` liefert.

Die Funktion verhält sich so ähnlich wie eine imperative Schleife: sie
liefert/hat __keinen Wert__ und ihr Nutzen besteht darin, dass du im `<body>`
Dinge tun kannst, die einen Seiteneffekt haben.

> Alle Clojure-Funktionen, die mit `do` beginnen, sind _imperative_ Konstrukte.
> Diese `do***` Formen, haben keinen Wert.

```
(dotimes [a 5]
  (println a))
```

### `for`

Mit [`for`](https://clojuredocs.org/clojure.core/for) kannst du über eine Folge
von Werten **schleifen**. Das Ergebnis (der Wert der `for`-Form) ist wiederum
eine Folge/Liste.

```
(for [x [3 7 9]] 
  (inc x)) ;=> (4 8 10)
```

Schauen wir uns die Form genauer an --- sie (die Form/Liste) hat **drei**
Element: hinter dem ersten Element (dem Symbol `for`) steht als zweites Element
ein **Vektor**, dessen **erstes** Element das **Symbol** `x` ist und dessen
**zweites** Element ein Vektor mit Elementen/Werten (eine **Collection**/Folge)
ist (`name-collection`-Paar).

> Das erinnert dich vielleicht an die `name-form`-Paare von `let`. Bei `for`
> muss der Wert der `form` aber eine Collection sein.

Als drittes und letztes Element in der Form steht die Form `(inc x)`. Diesen
Teil der `for`-Form nennt man *Rumpf* bzw. *Body*. Also insgesamt:

```
(for [<name-collections*>] 
  <body>)
```

> Anders als bei `let` muss der `<body>` im Fall von `for` jedoch aus **genau
> einer** Form bestehen.

Der **Wert** der `for`-Form (Auswertung) ergibt sich wie folgt: es wird eine
**leere** Liste erzeugt, das erste Element des Vektors/Collection (hier der Wert
**3**) wird an den Namen `x` gebunden (wie bei `let`) und dann wird das dritte
Element `(inc x)` als Form mit der aktuellen Bindung für `x` ausgewertet (wie
bei `let`). In diesem Fall erhalten wir also **4**. Dieser Wert wird nun der
Ergebnisliste (am Ende; zu Beginn ist sie ja noch leer) zugefügt. Damit erhalten
wir nach dem ersten **Schleifendurchlauf** als **Zwischenergebnis** die Liste
`(4)`.

Nun erfolgt der zweite Schleifendurchlauf und der Name `x` wird an den zweiten
Wert der Collection **7** gebunden, `(inc x)` wird zu **8** ausgewertet und
dieser Wert wieder der Liste angehängt. Ergibt `(4 8)`.

So geht es weiter, bis alle Elemente der Collection auf diese Weise verarbeitet
wurden. Damit endet die Ausführung der Schleife. Die **Anzahl der
Schleifendurchläufe** entspricht der **Anzahl der Elemente der
Eingabe-Collection/Folge**.

> Wir werden später lernen, dass `for` **keine** Liste erstellt, sondern dass
> wir eine **Sequenz** erhalten. Das tolle an Sequenzen ist, dass sie sich
> **lazy** (*faul*) verhalten und dadurch kann man z.B. **unendliche** Folgen
> bzw. **beliebig lange** Folgen von Werten erzeugen. Aber dazu später mehr. Im
> Moment können wir uns vorstellen, dass `for` wie beschrieben eine Liste
> konstruiert.

> Bestimmt ist dir schon aufgefallen, dass `for` auch keine *normale* Funktion
> sein kann (genau so wenig wie `let`). Denn dann müsste in dem obigen Beispiel
> die Form `[x [3 7 9]]` ja **ausgewertet** werden und das geht ja nicht, weil
> das Symbol `x` sich ja gar nicht auswerten lässt und ja auch gar nicht
> ausgewertet werden soll. `for` ist ein **Makro** und Makros werden anders
> ausgewertet als Funktionen. Wir kommen später noch zum Thema Makros.

Anstatt den Vektor mit den Werten direkt als Literal `[3 7 9]` hinzuschreiben,
können wir die Collection/Liste auch mit Hilfe der Funktion `range` erzeugen
(falls wir eine solche aufsteigende Folge von Zahlen verarbeiten wollen)

```
(for [x (range 1 5)] 
  (str "<" x ">"))
;=> ("<1>" "<2>" "<3>" "<4>")
```

> Achtung: um die Werte 1, 2, 3 und 4 zu erhalten, es muss wirklich `(range 1
> 5)` und nicht `(range 1 4)` lauten. Kannst du dir vorstellen, wieso das Sinn
> machen könnte?

Der Operator `for` wird auch als *Listen-Erzeuger* (engl. [*list
comprehension*](https://de.wikipedia.org/wiki/List_Comprehension)) bezeichnet.
Du kannst sogar mehrere `name-collection`-Paare angeben. Das Ergebnis ist, dass
`for` **alle Kombinationen** der angegebenen Bindungen erzeugt und den Rumpf mit
diesen ausführt und die Ergebnisse in der Liste liefert:

```
(for [x [:a :b :c]
      y (range 1 4)]
  [x  y]) ;=> ([:a 1] [:a 2] [:a 3] [:b 1] [:b 2] [:b 3] [:c 1] [:c 2] [:c 3])
```

Es handelt sich dabei um zwei **ineinander geschachtelte Schleifen**, wobei die
**äußere** Schleife über `[:a :b :c]` schleift und die **innere** Schleife über
`(range 1 4)` schleift.

> Achte darauf, dass erst *über* `y`
> hochgezählt/[**iteriert**](https://de.wikipedia.org/wiki/Iteration#Informatik)
> wird (innere Schleife) und dann *über* `x` (äußere Schleife). Aus dem
> Mathematikunterricht kennst du vielleicht das [**kartesische
> Produkt**](https://de.wikipedia.org/wiki/Kartesisches_Produkt): `for` erzeugt
> eben dieses kartesische Produkt.

Aber `for` hat noch weitere *coole* Features: du kannst `:when <condition>`
(ggf. auch mehrfach) benutzen, um zu steuern, welche Elemente (nicht) durch den
Rumpf verarbeitet und der Ergebnisliste hinzugefügt werden sollen (also so
ähnlich wie bei `filter`).

Im folgenden Beispiel wird der Body nur ausgewertet, falls `x` gerade ist.

```
(for [x (range 0 3)
      :when (even? x)
      y (range 0 3)]
  [x y])
;=> ([0 0] [0 1] [0 2] [2 0] [2 1] [2 2])
```

> Wir hatten oben erwähnt, dass wir bei Schleifen vielleicht nicht zu jedem
> Eingabe-Element (die 2-Tupel des kartesischen Produkts) auch ein
> Ausgabe-Element liefern möchten. Mit `:when` kannst du genau dies umsetzen.
> Beachte, wo wir das `:when` hingeschrieben haben.

Und du kannst (wie bei `let`) mit `:let` Namen an Werte binden:

```
(for [x (range 0 3)
      y (range 0 3)
      :let [s (+ x y)
            d (- x y)
            _ (println "x,y,s,d" x y s d)]
      :when (even? s)
      :when (pos? d)]
  [x y s d])
;x,y,s,d 0 0 0 0
;x,y,s,d 0 1 1 -1
;x,y,s,d 0 2 2 -2
;x,y,s,d 1 0 1 1
;x,y,s,d 1 1 2 0
;x,y,s,d 1 2 3 -1
;x,y,s,d 2 0 2 2
;x,y,s,d 2 1 3 1
;x,y,s,d 2 2 4 0
;=> ([2 0 2 2])
```

Mit `:while <condition>` kannst du steuern, *wie lange* (also bis zu welchem
Element) eine Schleife durchlaufen wird. Mit `:when` konntest du Elemente zwar
*herausfiltern*, aber die Schleife wurde dann mit dem nächsten Element
**fortgesetzt**. Mit `:while` kannst du die Verarbeitung der Schleife(n) an
einem bestimmten Element **beenden**. 

**Beispiel**: 

```
(for [x (range 1 10) :while (< x 6) :when (even? x)
      y (range 1 10) :while (< y x)]
  [x y])
```

**Übungen**:

* Zu was wertet `(for [x [1 2 3 4]] (println "x=" x) x)` aus? Was lernen wir
  daraus?

* Zu was wertet die Form `for` aus? Macht das Sinn?

* Berechne mit Hilfe von `for`/`:when`, `range`, `=` und `mod` alle Zahlen
  zwischen **1** und **28** (inklusive), die durch **7** teilbar sind. Überlege
  dir zusammen mit deiner Tischnachbarin, wie ihr euch der Lösung *nähern*
  könnt? Womit fangt ihr an? Tipp: ihr schleift über die Zahlen 1 bis 28.

* Berechne mit Hilfe von `for`/`:when`/`let`/`while`, `range`, `*`, `pos?` und
  `<=` alle Zahlen zwischen **1** und **28** (inklusive), die durch **7**
  teilbar sind. Überlege dir zusammen mit deiner Tischnachbarin, wie ihr euch
  der Lösung *nähern* könnt? Womit fangt ihr an? Tipp: ihr schleift über die
  Zahlen 1 bis unendlich und brecht die Schleife ab, sobald ihr das passende
  Abbruchkriterium erreicht habt.

* Schaue dir die beiden folgenden Beispiele an. Was fällt dir auf? Liefern die
  beiden Programm das gleiche Ergebnis? Tun die beiden Programm das gleiche? Was
  könnte der Unterschied sein? Wie könntest du die Programme so erweitern, dass
  du deine Vermutung bestätigen/widerlegen kannst?

```
(for [x (range 1 5)
      y (range 1 5) 
      :while (< x 3) 
      :while (< y x)]
  [x y])
```

```
(for [x (range 1 5)
      :while (< x 3) 
      y (range 1 5) 
      :while (< y x)]
  [x y])
```

### `reduce`/`reduced`/`reductions`

Falls du die Elemente während der Schleifendurchläufe nicht einzeln/isoliert
betrachten möchtest sondern sie auf ein bestimmte Weise **zusammenfassen**
möchtest, benötigst du eine Möglichkeit, dir etwas zu **merken**.

> Mit `for` geht das nicht. Du kannst dir von einem zum anderen
> Schleifendurchlauf nichts merken.

Die Funktion `(reduce <f> <val> <coll>)` erlaubt dir, über eine Collection/Folge
zu **schleifen** und dabei von einem Schleifendurchlauf zum jeweils nächsten
Schleifendurchlauf einen **Wert** zu liefern. **Dieser (Zwischen-)Wert** ist das
*Gedächtnis*, das uns z.B. erlaubt, Zahlen zu summieren.

Im ersten Durchlauf wird die Funktion `<f>` auf den Wert `<val>` und das erste
Element `<e_1>` der Collection `<coll>` anwendet. Dies liefert den Wert `<f_1>`.
Im zweiten Durchlauf wird die Funktion `<f>` auf dem Ergebnis `<f_1>` des ersten
Durchlaufs und dem zweiten Element `<e_2>` der Collection angewendet, dies
liefert `<f_2>` u.s.w. Als Ergebnis der `reduce`-Form/Schleife wird der letzte
Wert von `<f_x>` geliefert.

```
(reduce str :a [:b :c])  ;=> ":a:b:c"
(reduce + 0 (range 10))  ;=> 45
```

Mit `(reduced <x>)` kann die `reduce`-Schleife vorzeitig beendet werden. In
diesem Fall wertet die `reduce`-Form zum Wert `<x>` aus.

```
(reduce #(let [s (+ %1 %2)]
           (if (> s 10)
             (reduced s) ;; vorzeitiges Schleifenende
             s))
        (range 10))      ;=> 15
```

Mit `reductions` erhältst du die Liste aller Zwischenergebnisse anstatt nur das
Endergebnis:

```
(reductions #(let [s (+ %1 %2)]
               (if (> s 10)
                 (reduced s)
                 s))
            (range 10))  ;=> (0 1 3 6 10 15)
```

### `iterate`

`(iterate <f> <x>)` liefert die __unendliche__ Liste/Sequenz `((<f> <x>) (<f>
(<f> <x>)) (<f> (<f> (<f> <x>))) ,,,)`. 

> Du solltest vorsichtig sein, wenn du diese Funktion benutzt, da das Ergebnis
> nicht ausgegeben werden kann, weil es ja .... unendlich ist :-) Daher nutzen
> wir hier `(take <n> <coll>)`, um nur die ersten `<n>` Element auszugeben.

```
(take 6 (iterate inc 5)) ;=> (5 6 7 8 9 10)
```

### `loop`/`recur`

`(loop <bindings> <body>)` ist eine Schleife, die im ersten Durchlauf in
`<bindings>` lokale Namen an die angegebenen Werte bindet und damit den `<body>`
auswertet. Über `recur` im `<body>` kann ein weiterer Schleifendurchlauf inkl.
Angabe von neuen Werten für die `<bindings>` erfolgen. Als Ergebnis der
`loop`-Form wird der Wert der letzten `<body>`-Auswertung geliefert. 

```
(loop [x 0                       ; Initial-Zustand: x ist "Zähler"
       y []]                     ;                  y als "Aggregation" ist zu Beginn leer.
  (if (< x 5)                    ; Abbruch- bzw. Fortsetzungs-Kriterium
    (recur                       ; weiterer Schleifendurchlauf inkl. Ergebnis-Aggregation
      (inc x)                    ; Wert für x für den neuen Schleifendurchlauf
      (conj y (str "<" x ">")))  ; Wert für y für den neuen Schleifendurchlauf
    [x y]))                      ;=> [5 ["<0>" "<1>" "<2>" "<3>" "<4>"]] ;; Ergebnis der Schleife.
```

-------------------------------------------------------------------------------
## TBD: Rekursion, der Stack, Endrekursion


-------------------------------------------------------------------------------
## Funktionen, die Funktionen liefern (nochmal "higher order functions")

Oben haben wir Funktionen (HOFs) kennengelernt, denen wir beim Aufruf als
Argument Funktionen übergeben. Während der Ausführung unseres Funktionsaufrufs
nutzt die HOF die übergebene Funktion, indem sie diese selber aufruft.

__Beispiel__: Wir rufen die HOF `every?` auf und übergeben ihr die
Funktion/Prädikat `even?`. Während `every?` ausgeführt wird, ruft sie die
Funktion `even?` auf. 

Als Ergebnis erhalten wir `true` oder `false`.

```
(every? even? [2 4 6]) ;=> true
```

Es gibt aber auch HOFs, die nicht selber die übergebene Funktion aufrufen,
sondern die uns als **Ergebnis** eine **neue Funktion** liefern und diese neue
Funktion ruft (falls/wenn wir sie aufrufen) dann die von uns übergebene Funktion
auf.

> Aus dem Mathematikunterricht kennst du vielleicht die
> **[Komposition](https://de.wikipedia.org/wiki/Komposition_(Mathematik))** von
> Funktionen. Wenn ich z.B. die Funktionen **f(x)** und **g(x)** habe, dann kann
> ich durch **Komposition ∘** die Funktion **h = g ∘ f** bilden. D.h., durch die
> Kompositions-Operation **∘** __schaffe ich eine neue Funktion__. Dabei ist
> **h(x) = (g ∘ f)(x) = g(f(x))**. Das kannst du in Clojure auch machen.

### `comp`

Die Funktion `(comp <fs*>)` liefert als **Ergebnis** die
**Kompositions-Funktion** (also eine __neue Funktion!__) der übergebenen
Argumente (__Funktionen__). 

Wenn wir diese neue Funktion mit Argumenten aufrufen, wird sie die zuvor
übergebenen Funktionen *der Reihe nach* auf den Argumenten aufrufen und das
Ergebnis liefern.

**Beispiel**: wir konstruieren die Komposition der Funktionen `/` und `-`, indem
wir `(comp - /)` aufrufen. Die gelieferte Funktion wird erst `/` auf ihren
Argumenten aufrufen und anschließend auf dem Ergebnis der Division die Funktion
`-` aufrufen. Schließlich liefert sie das Ergebnis.

> Lies dir nochmal durch, wie die Auswertungsregel für Listen aussieht. Die
> ersten Position einer Liste muss eine Funktion sein und diese wird bei der
> Auswertung der Liste aufgerufen. Wenn wir also schreiben `((comp <fs*>) ,,,)`,
> dann wertet `(comp <fs*>)` zu einer Funktion `<f>` aus und diese Funktion
> `<f>` wird dann in der Liste `(<f> ,,,)` das erste Element sein und bei der
> Auswertung der Liste mit den restlichen Elementen der Liste als Argumente
> aufgerufen.

> Beachte die Reihenfolge, in der die Funktionen/Argument von `comp` ausgeführt
> werden: die Reihenfolge der Ausführung erfolgt von *rechts nach links*. Genau
> wie bei der Komposition **∘** (vgl. oben).

```
(comp - /) ;=> #object[g]
((comp - /) 8 3) ;=> -2.6666666666666665
(- (/ 8 3)) ;=> -2.6666666666666665
((comp inc - /) 8 3) ;=> -1.6666666666666665
(inc (- (/ 8 3))) ;=> -1.6666666666666665
```

**Übungen**:

* Nutze `comp`, `inc` und `-` um eine Funktion zu konstruieren, die ihr Argument
  erst negiert und dann um eins erhöht: `((comp ,,,) 4) ;=> -3`
* Nutze `map`, um diese Funktion auf den Vektor mit den Werten `4`, `10` und `0`
  anzuwenden: `(map ,,,) ;=> (-3 -9 1)`

### `partial`

Die Funktion `(partial <f> <xs*>)` liefert eine Funktion, die, wenn/falls sie
mit Argumenten `<ys*>` aufgerufen wird, die Form `(<f> <xs*> <ys*>)` auswertet.
D.h., die von uns angegebene Funktion `<f>` mit den Argumenten `<xs*>` und
`<ys*>` *hintereinander geschrieben* aufruft.

Die Funktion `partial` *merkt* sich also, welche Argumente `<xs*>` übergeben
wurden, wenn sie ausgeführt wird und liefert uns eine **neue Funktion**, in der
diese Information hinterlegt ist. Und wenn/falls wir später diese **neue
Funktion** aufrufen und dabei möglicherweise Argumente übergeben, dann wird die
ursprünglich Funktion `<f>` mit all diesen Argumenten (also `<xs*>` und `<ys*>`)
aufgerufen.

**Beispiel**

```
(partial + 42) ;=> #object[g]
((partial + 42) 10) ;=> 52
((partial + 42) 10 4) ;=> 56
((partial (comp - /) 8) 3) ;=> -2.6666666666666665
```

**Übungen**:

* Nutze `partial`, um eine Funktion zu definieren, die ihre Argumente mit
  **zwei** multipliziert und wende diese Funktion auf die Zahl **5** an:
  `((partial ,,,) 5) ;=> 10`
* Nutze `filter` und `partial`, um aus dem Vektor mit den Zahlen 0, 1, 2, 3 und
  4 alle Element zu entfernen, die **kleiner 2** sind: `(,,, [0 1 2 3 4]) ;=> (2
  3 4)`

-------------------------------------------------------------------------------
## TBD: Datentypen als Funktion

-------------------------------------------------------------------------------
## TBD: Destructuring

-------------------------------------------------------------------------------
## TBD: Threading

-------------------------------------------------------------------------------
## TBD: Reguläre Ausdrücke

-------------------------------------------------------------------------------
## TBD: Was ist der Unterschied zwischen einem Datentyp und einer Sequenz?

-------------------------------------------------------------------------------
## TBD: Gleichheit

-------------------------------------------------------------------------------
## TBD: Meta-Programmierung / Makros

* https://de.wikipedia.org/wiki/Homoikonizit%C3%A4t

-------------------------------------------------------------------------------
## TBD: Transducer

-------------------------------------------------------------------------------
## TBD: Lazy Evaluation

* doseq
* run!
* doall
* dorun
* lazy-seq
* lazy-cat

Was gibt dieses Programm aus? Wieso?

```
(let [x (map prn [1 2 3])
      y (map prn [:a :b :c])])
```

Und dieses?

```
(let [x (map prn [1 2 3])
      y (map prn [:a :b :c])]
  y)
```

Und dieses?

```
(let [x (map prn [1 2 3])
      y (map prn [:a :b :c])]
  x)
```

Und dieses?

```
(let [x (map prn [1 2 3])
      y (map prn [:a :b :c])]
  x
  y)
```

Und dieses?

```
(let [x (map prn [1 2 3])
      y (map prn [:a :b :c])]
  x
  y
  [y x])
```

Und dieses?

```
(let [x (seq (map prn [1 2 3]))
      y (map prn [:a :b :c])])
```

Und dieses?

```
(let [x (seq (map prn [1 2 3]))
      y (vec (map prn [:a :b :c]))])
```

-------------------------------------------------------------------------------
## TBD: Nebenläufigkeit und Parallelität

-------------------------------------------------------------------------------
## TBD: Vars und Namensräume

-------------------------------------------------------------------------------

## Experimente im Browser

### ClojureScript und der Browser

Wenn du https://tryclojure.org/ aufrufst, erhältst du eine Seite, in der du
Clojure bzw. [**ClojureScript**](https://clojurescript.org/) Formen auswerten
kannst. 

> ClojureScript ist im Prinzip "Clojure im Browser". Wir wollen auf die
> Unterschiede zwischen Clojure und ClojureScript und viele Details hier im
> Moment aber nicht eingehen. Du solltest aber wissen, dass ClojureScript zu
> [JavaScript](https://de.wikipedia.org/wiki/JavaScript) **übersetzt**
> ([transpiliert](https://de.wikipedia.org/wiki/Compiler#Sonderformen)) wird und
> der Browser auch **nur JavaScript** (und
> [WASM](https://de.wikipedia.org/wiki/WebAssembly)) direkt ausführen kann.
> Daher verwundert es nicht, dass viele Dinge, die du übers Programmieren im
> Zusammenhang mit Browsern findest, JavaScript-Beispiele enthalten. Wir werden
> aber sehen, dass es ziemlich einfach ist, die Beispiele für ClojureScript
> anzupassen.  
> Für `tryclojure` wird allerdings nicht ein
> [ClojureScript](https://github.com/clojure/clojurescript)-[Compiler](https://de.wikipedia.org/wiki/Compiler)
> sondern der
> ClojureScript-[Interpreter](https://de.wikipedia.org/wiki/Interpreter)
> [SCI](https://github.com/babashka/sci) verwendet.   

Du kannst aber nicht nur **Formen auswerten** (was ja eigentlich bedeutet,
Funktionen auf Werten aufzurufen und sich dann über das richtige Ergebnis zu
freuen), sondern du kannst durch ClojureScript **auf den Browser zugreifen**.
D.h., du kannst **lesend** auf die Daten im Browser zugreifen, aber du kannst
auch aktiv Dinge im Browser **tun** --- also Dinge im Browser **ändern**. Und
genau das wollen wir jetzt machen.

Mit der Form `js/document` greifst du auf die aktuelle Seite zu: **[das
Dokument](https://wiki.selfhtml.org/wiki/JavaScript/DOM#Allgemeines)**. 

> Mit `js/` greifst du auf den [Namespace
> `js`](https://cljs.github.io/api/syntax/js-namespace) zu. Über diesen
> Namensraum kannst du auf alle globalen
> JavaScript-[Objekte](https://wiki.selfhtml.org/wiki/JavaScript/Tutorials/OOP/Objekte_und_ihre_Eigenschaften)
> zugreifen.  
> Die Form `js/document` wertet zu dem Wert aus, der an den **Namen** (das
> Symbol) `document` im **Namespace** `js` gebunden ist. Das funktioniert also
> genau so, wie bisher auch die Auswertung von Clojure-Symbolen (wie z.B. `inc`)
> funktioniert hat.

Dieses **Dokument** ist aus Sicht von ClojureScript eine **verschachtelte Map**.
Allerdings handelt es sich um eine Map, die du **verändern** kannst. Und diesmal
meinen wir **wirklich verändern**: d.h., es wird nicht wie bei Clojure-Maps
immer eine **neue Map** erzeugt, sondern es wird wirklich eine Map
**manipuliert**.

> Das nennen wir einen **Seiteneffekt**. Diese Art der **Manipulation** ist
> typisch für imperative und viele Objekt-orientierten Sprachen. Der Browser
> funktioniert auch auf diese Weise. Und wir sprechen in diesem Fall nicht von
> Maps sondern von (änderbaren) **Objekten**. Objekte können sich auch
> gegenseitig **enthalten** und dadurch entstehen **Objekt-Bäume** oder auch
> **Objekt-Geflechte** (bzw. **Objekt-Graphen**).

```
js/document ;=> #object[HTMLDocument [object HTMLDocument]]
```

Im Fall von Maps haben wir immer von deren **Schlüsseln** gesprochen und wir
konnten mit Hilfe von `get` auf die Werte der Schlüssel zugreifen und wir
konnten ausnutzen, dass sich **Keywords** und **Maps** wie
**Zugriffsfunktionen** verhalten.

```
(get {"foo" "bar" "foobar" "quox"} "foobar") ;=> "quox"
(:foobar {:foo "bar" :foobar "quox"})        ;=> "quox"
({"foo" "bar" "foobar" "quox"} "foobar")     ;=> "quox"

```

Die "Schlüssel" von **Objekten** werden **Eigenschaften** bzw. **Properties**
(Einzahl **Property**) genannt. Um auf die Properties von JavaScript-Objekten
zuzugreifen, nutzen wir die Funktion `.` (Punkt). So greifst du auf die Property
`title` des Objekts `js/document` zu:

> `.` ist nicht wirklich eine **Funktion**. Es handelt sich um die [**dot
> special form**](https://cljs.github.io/api/cljs.core/DOT). Beim Zugriff auf
> Properties müssen wir dem Namen der Property **ein Minus (`-`) voranstellen**.

```
(. js/document -title) ;=> "Try Clojure"
```

> Du kannst im Firefox mit der Taste F12 die [Entwickler
> Werkzeuge](https://de.wikipedia.org/wiki/Entwicklerwerkzeuge_in_Webbrowsern)
> öffnen. Dort findest du auch die [Web
> Console](https://firefox-source-docs.mozilla.org/devtools-user/web_console/).
> Auf diese Konsole kannst du mit `(js/console.log js/document)` das **Objekt
> ausgeben**. Anschließend kannst du dich **durch das Objekt "klicken"** und so
> sehen, welche Eigenschaften und Werte das Objekt hat. Probiere es einfach mal
> aus.

Es gibt aber auch noch *syntaktischen Zucker*: du kannst den Punkt und den
Property-Namen (hier also `.-title`) dem Objekt (hier `js/document`) gemeinsam
voranstellen:

```
(.-title js/document) ;=> "Try Clojure"
```

Du kannst sogar den Punkt und den Property-Namen (ohne vorangestelltes `-`) an
das Objekt anhängen (diese Form wird aber **nicht empfohlen**). 

> HINWEIS: in diesem Fall darfst du **keine Klammern verwenden**! 

```
js/document.title ;=> "Try Clojure"
```

Diese Form ist an die [Dot-Property-Schreibweise von
JavaScript](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Property_accessors)
angelehnt. Diese Form funktioniert aber **nicht mit lokalen/globalen Namen**,
sondern nur mit Namen im `js/` Namespace.

Das folgende Beispiel zeigt, dass du zwar den Namen `x` im Namespace `user` an
das `js/document`-Objekt binden kannst. Du kannst aber nicht via `x.title` auf
die Eigenschaft `js/document.title` zugreifen.

```
(def x js/document)                           ;=> #'user/x
x                                             ;=> #object[HTMLDocument [object HTMLDocument]]
[(. x -title) (.-title x) js/document.title]  ;=> ["Try Clojure" "Try Clojure" "Try Clojure"]
x.title                                       ;=> Could not resolve symbol: x.title
```

Du kannst dir mit `js-keys` zu einem Objekt **die Namen aller Properties**
holen. Als Rückgabewert erhältst du ein
**[JavaScript-Array](https://www.mediaevent.de/javascript/array.html)** (das
erkennst du an `#js [,,,]`). Du kannst das JavaScript-Array mit Hilfe von
`js->clj` in einen ClojureScript-Vektor umformen.

> Du kannst von ClojureScript aus ohne Probleme [auf JavaScript-Arrays
> zugreifen](https://www.learn-clojurescript.com/section-2/lesson-13-interacting-with-javascript-data/#using-arrays).

```
(js-keys js/document)
;=> #js ["location" "__reactEvents$0r167g6smgt" "getElementsByTagName" "getElementsByTagNameNS" "getElementsByClassName" "getElementById" "createElement" "createElementNS" "createDocumentFragment" "createTextNode" "createComment" "createProcessingInstruction" "importNode" "adoptNode" "createEvent" "createRange" "createNodeIterator" "createTreeWalker" "createCDATASection" "createAttribute" ...]

(js->clj (js-keys js/document))
;=> ["location" "__reactEvents$0r167g6smgt" "getElementsByTagName" "getElementsByTagNameNS" "getElementsByClassName" "getElementById" "createElement" "createElementNS" "createDocumentFragment" "createTextNode" "createComment" "createProcessingInstruction" "importNode" "adoptNode" "createEvent" "createRange" "createNodeIterator" "createTreeWalker" "createCDATASection" "createAttribute" ...]
```

Anschließend können wir dann wieder auf die Werte der Properties zugreifen. Dazu
kannst du auch [`aget`](https://cljs.github.io/api/cljs.core/aget) nutzen. Für
den **geschachtelten Zugriff** hilft dir die [**dot-dot special
form**](https://cljs.github.io/api/cljs.core/DOTDOT).

```
(aget js/document "location") ;=> #object[Location https://tryclojure.org/]
(aget js/document 'location)  ;=> #object[Location https://tryclojure.org/]
(.-location js/document)      ;=> #object[Location https://tryclojure.org/]
js/document.location          ;=> #object[Location https://tryclojure.org/]

(js-keys js/document.location)
;=> #js ["href" "origin" "protocol" "host" "hostname" "port" "pathname" "search" "hash" "assign" "replace" "reload" "toString"]

(. (. js/document -location) -hostname)  ;=> "tryclojure.org"
(.. js/document -location -hostname)     ;=> "tryclojure.org"
(aget js/document "location" "hostname") ;=> "tryclojure.org"
(aget js/document 'location 'hostname)   ;=> "tryclojure.org"
js/document.location.hostname            ;=> "tryclojure.org"
```

Vielleicht ist dir schon aufgefallen, dass einige der Properties von
`js/document` Namen haben, die sich wie **Funktionsnamen** anhören (z.B.
`getElementsByTagName`). Tatsächlich ist es in JavaScript so, dass die Objekte
sog. **Methoden** besitzen. Dabei handelt es sich einfach um [**Funktionen** als
**Wert von
Properties**](https://www.mediaevent.de/javascript/Javascript-Objekte-3.html).
Du kannst diese Methoden/Funktionen auch von ClojureScript aus aufrufen.
Allerdings können wir das nicht so machen, wie wir es von Clojure aus kennen:

> Details findest du
> [hier](https://lwhorton.github.io/2018/10/20/clojurescript-interop-with-javascript.html#pitfalls).

```
(. js/document -getElementById) ;=> #object[getElementById]
(.-getElementById js/document)  ;=> #object[getElementById]
((.-getElementById js/document) "app") ;=> 'getElementById' called on an object that does not implement interface Document.
```

Stattdessen müssen wir bei Methoden den Namen der Property **ohne vorangestellte
Minus-Zeichen** angeben. Auch in diesem Fall kannst du `..` verwenden.

```
(. js/document getElementById "app") ;=> #object[HTMLDivElement [object HTMLDivElement]]
(.getElementById js/document "app")  ;=> #object[HTMLDivElement [object HTMLDivElement]]
(.. js/document (getElementById "app")) ;=> #object[HTMLDivElement [object HTMLDivElement]]
(.. js/document (getElementById "app") (getElementsByTagName "script")) ;=> #object[HTMLCollection [object HTMLCollection]]
```

Du kannst aber auch direkt auf die Funktion als Property-Wert zugreifen
(`js/document.getElementById`) und die Funktion dann auch aufrufen:

```
(js/document.getElementById "app") ;=> #object[HTMLDivElement [object HTMLDivElement]]
(.. (js/document.getElementById "app") (getElementsByTagName "script"))
;=> #object[HTMLCollection [object HTMLCollection]]
```

Die `.`-Form sieht also so aus: `(. <object> <method-name> <args*>)`

Um die `.`-Form auszuwerten, greift die REPL auf die Property `<method-name>`
des Objects `<object>` zu und erwartet, dass dieser Wert eine **Funktion** ist.
Diese Funktion wird nun mit den Argumenten `<args*>` aufgerufen. Der
Rückgabewert dieses Funktionsaufrufs ist der Wert, zu dem die `.`-Form
auswertet.

Die `..`-Form sieht so aus: `(.. <object> <method-name-args-lists*>)`

Um die `..`-Form auszuwerten, führt die REPL zuerst die **erste Methode** mit
den angegebenen Argumenten auf dem Object `<object>` aus (so wie es für die
`.`-Form beschrieben wurde). Der Wert dieser Auswertung muss wiederum **ein
Objekt** sein. Und auf diesem Objekt wird nun die **zweite Methode** mit den
angegebenen Argumenten aufgerufen usw. Die `..`-Form wertet zu jenem Wert aus,
der als Ergebnis der **letzten Methodenanwendung** geliefert wurde.

**Beispiel**: wir rufen auf dem Objekt `js/document` die Funktion/Methode
`getElementById` mit dem Argument `"app"` auf und erhalten ein Objekt (ein
**[`div`-Element](https://wiki.selfhtml.org/wiki/HTML/Elemente/div)**).

```
(.. js/document (getElementById "app")) ;=> #object[HTMLDivElement [object HTMLDivElement]]
```

Durch eine weitere `<method-name-args-list>` (`(getElementsByTagName "script")`)
können wir nun auf diesem Objekt eine weitere Funktion aufrufen. In diesem Fall
erhalten wir ein
**[`script`-Element](https://wiki.selfhtml.org/wiki/HTML/Elemente/script)**.

```
(.. js/document (getElementById "app") (getElementsByTagName "script"))
;=> #object[HTMLCollection [object HTMLCollection]]
```

### Die Seite manipulieren

Du kannst aber nicht nur **lesend** auf die Eigenschaften der Objekte im Browser
zugreifen, sondern auch **schreibend** bzw. **ändernd**.

Dazu kannst du zum einen ändernde Methoden der Objekte verwenden und zum anderen
die ClojureScript-Funktion `set!`.

Um das auszuprobieren, suchen wir uns auf der Seite das
[`blockquote`](https://wiki.selfhtml.org/wiki/HTML/Elemente/blockquote)-Objekt
(mit dem Zitat "If you want everything to be familiar, you'll never learn
anything new." von Rich Hickey, dem Erfinder von Clojure).

```
(js/document.getElementsByTagName 'blockquote) ;=> #object[HTMLCollection [object HTMLCollection]]
```

Wir erhalten kein JavaScript-Array, sondern eine
[`HTMLCollection`](https://wiki.selfhtml.org/wiki/JavaScript/DOM/HTMLElement#Zugriff_auf_Elementobjekte).
Das macht aber nichts, weil wir daraus via `seq` eine Liste bzw. Sequenz machen
können. So erhalten wir eine Liste mit einem
[`HTMLQuoteElement`](https://developer.mozilla.org/en-US/docs/Web/API/HTMLQuoteElement)-Objekt.

```
(seq (js/document.getElementsByTagName 'blockquote)) ;=> (#object[HTMLQuoteElement [object HTMLQuoteElement]])
```

Und da `first` intern `seq` aufruft, können wir uns wie folgt via `def` das
`HTMLQuoteElement` unter dem Namen `bq` merken:

> Bitte bedenke, dass die folgenden Beispiele den Namen `bq` verwenden. Und das
> funktioniert nur, wenn du **zuvor** den Namen via `(def bq ,,,)` `def`iniert
> hast. Falls du also F5/Reload in deinem Browser drückst und dann, **ohne**
> `bq` erneut zu `def`inieren, den Namen `bq` verwendest, wirst du die
> Fehlermeldung `Could not resolve symbol: bq` erhalten. Unsere
> `tryclojure`-Sitzung ist also **zustandsbehaftet**: wir müssen **erst** den
> Namen definieren, bevor wir ihn **anschließend** verwenden können. Probiere es
> doch einfach mal aus!

```
(def bq (first (js/document.getElementsByTagName "blockquote"))) ;=> #'user/bq
bq ;=> #object[HTMLQuoteElement [object HTMLQuoteElement]]
```

Nun möchten wir die Hintergrundfarbe ändern. Die Hintergrundfarbe
(`background-color`) eines Elements kann über die [Property
`style`](https://wiki.selfhtml.org/wiki/HTML/Attribute/style) gesteuert werden.
Diese Property können wir über die **Methode**
[`setAttribute`](https://wiki.selfhtml.org/wiki/JavaScript/DOM/Element/setAttribute)
setzen. Mit Hilfe von `getAttribute` können wir auf den aktuellen Property-Wert
zugreifen (wir erhalten als Wert einen String!).

```
(.setAttribute bq "style" "background-color: red") ;=> nil
(.getAttribute bq "style") ;=> "background-color: red"
```

Anstatt der Methode `getAttribute` kannst du auch `.` verwenden, um auf die
`style`-Property zuzugreifen. In diesem Fall erhalten wir jedoch ein
`CSS2Properties`-**Objekt** und nicht einen String! 

```
(. bq -style) ;=> #object[CSS2Properties [object CSS2Properties]]
(.. bq -style -background-color) ;=> "red"
```

Mit der ClojureScript-Funktion `set!` kannst du diese Eigenschaft setzen:

> Hinweis: die Form `(.. bq -style -background-color)` wird also auf **zwei ganz
> unterschiedliche Weisen verwendet**. Zum einen wertet die Form zu dem
> Property-**Wert** des Objekts aus (z.B. dem String `"red"`). Wenn die Form
> allerdings als **Argument** zu `set!` verwendet wird, steuert sie, welche
> Object-**Property** **gesetzt werden soll**. Das entspricht den [R-Werten und
> L-Werten von
> Variablen](https://de.wikipedia.org/wiki/Variable_(Programmierung)#L-Wert_und_R-Wert_von_Variablen),
> die du vielleicht schon aus einer imperativen Programmiersprache kennst.

```
(set! (.. bq -style -background-color) "greenyellow") ;=> nil
```

> Don't panic! Dieses Kapitel hat es wirklich in sich! Das Zusammenspiel
> zwischen ClojureScript, JavaScript und den Objekten des Browsers ist sehr
> verwirrend und schwer zu durchschauen. Lass dich nicht entmutigen!!!  

### Einen Kreis malen

Wir wollen nun geometrische Figuren *malen*. 

> In den folgenden Beispielen nutze ich das HTML-Canvas-Element. Eine bessere
> Alternative wären wohl [Scalable Vector Graphics
> (SVG)](https://de.wikipedia.org/wiki/Scalable_Vector_Graphics). Vielleicht
> machen wir das später noch.

Dazu nutzen wir ein
[`Canvas`](https://wiki.selfhtml.org/wiki/JavaScript/Canvas)-Element/Objekt, das
wir via
[`js/document.createElement`](https://wiki.selfhtml.org/wiki/JavaScript/DOM/Document/createElement)
erzeugen und an den Namen `canvas` binden, damit wir anschließend über diesen
Namen auf das Objekt zugreifen können. Wir legen fest, wie
[breit](https://wiki.selfhtml.org/wiki/HTML/Attribute/width) und wie
[hoch](https://wiki.selfhtml.org/wiki/HTML/Attribute/height) der Zeichenbereich
sein soll und fügen das `Canvas`-Objekt dem
[`body`](https://wiki.selfhtml.org/wiki/HTML/Tutorials/Grundger%C3%BCst#Der_body:_sichtbarer_und_strukturierter_Aufbau)
der Seite zu.

```
(def canvas (js/document.createElement "canvas"))
(set! (.-width canvas) 800)
(set! (.-height canvas) 300)
(.prepend js/document.body canvas)
```

> Das ist cool! Wir nutzen ein HTML-Dokument, das einen
> ClojureScript-Interpreter enthält, um eben dieses HTML-Objekt interaktiv zu
> verändern 🤯

Um aber wirklich etwas auf dem Canvas malen zu können, benötigen wir den
[`CanvasRenderingContext2D`](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D)
zu dem Canvas. Wir binden den Kontext an den Namen `ctx` und setzen den
[Füllstil](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/fillStyle),
[starten](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/beginPath)
einen
[Pfad](https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API/Tutorial/Drawing_shapes?retiredLocale=de#drawing_paths),
zeichnen einen
[Kreis](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/arc)
und
[füllen](https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/fill)
diesen.

```
(def ctx (.getContext canvas "2d"))
(set! (.-fillStyle ctx) "green")
(.beginPath ctx)
(.arc ctx 160 120 72 0.0 (* 2.0 js/Math.PI) false)
(.fill ctx)
```

> Vielleicht ist es dir schon aufgefallen: als wir angefangen haben, Clojure zu
> lernen, haben wir die ganze Zeit **Funktionen auf Werte (Argumente)
> angewendet** und haben **Werte** als Rückgabewert/**Ergebnis** erhalten. Die
> Argumente/Werte konnten wir mit Hilfe der Funktion **nicht ändern**. Wir haben
> grundsätzlich **neue Werte als Ergebnis** erhalten.  
> Beim Zugriff auf den [DOM](https://wiki.selfhtml.org/wiki/JavaScript/DOM)
> rufen wir vor allem **Funktionen/Methoden** auf **änderbaren Objekten** auf,
> um bestimmte **Effekte** zu bewirken. Dadurch **ändern** wir den **Zustand der
> Objekte** (und damit den Seiteninhalt). Als Rückgabewert erhalten wir häufig
> `nil`. Wir erhalten also weder ein neues Objekt noch das jenige Objekt, auf
> dem wir die Methode aufgerufen haben.  
> Diese unterschiedliche Weise, mit **Werten und (änderbaren) Objekten**
> umzugehen, ist charakteristisch für den Unterschied zwischen
> **objekt-orientierten Programmiersprachen** (OO-Sprachen wie z.B. Java und
> C++) und **funktionalen Programmiersprachen** (wie z.B. Clojure).  
> Du solltest aber wissen, dass es in OO-Sprachen auch möglich ist, funktional
> zu programmieren und in Clojure ist es auch möglich, objekt-orientiert zu
> programmieren. Die Sprachen haben nur jeweils einen anderen Fokus/Schwerpunkt.

Oben links auf der Seite, müsste nun ein grüner Kreis erschienen sein. OK, das
sieht schon ganz gut aus.

Wir können den Code aber noch etwas kompakter schreiben. Dazu nutzen wir das
[`doto`](https://clojuredocs.org/clojure.core/doto)-Makro.


`(doto <form-x> <forms*>)` erspart uns, immer wieder den Namen `canvas`
schreiben zu müssen.

Die `doto`-Form wird wie folgt ausgewertet: als erstes wird `<form-x>`
ausgewertet. Anschließen werden die folgenden `<forms*>` der Reihe nach
ausgewertet, jedoch wird jeweils an die **zweite** Stelle der Form der Wert (das
**Objekt**!) von `<form-x>` gesetzt. Ganz am Ende liefert `doto` den
(möglicherweise **geänderten**) Wert/Objekt von `<form-x>`.

> Zu was wertet `(doto "foo" (first) (last))` aus? Wieso? Zu was wertet `(last
> (first "foo"))` aus? Wieso?

Wir können damit also an Stelle von `<form-x>` das Canvas-Objekt via
`(js/document.createElement "canvas")` erzeugen und anschließend via
`setAttribute` die Eigenschaften des Canvas-Objekts ändern und erhalten
schließlich das geänderte Canvas-Objekt als Wert der `doto`-Form.

**Übung**: besprich mit deiner Tischnachbarin, wieso wir in diesem Fall die
Funktion/Methode `setAttribute` anstatt `set!` nutzen müssen. Lest euch nochmal
durch, was `doto` genau macht!

Das sieht kompakter aus.

```
(def canvas 
  (doto (js/document.createElement "canvas")
    (.setAttribute 'width 800)
    (.setAttribute 'height 300)))
(.prepend js/document.body canvas)
```

Mit Hilfe von `let` kannst du etwas ähnliches schreiben, nur musst du in diesem
Fall den Namen `x` eben mehrmals wiederholen.

```
(def canvas 
  (let [x (js/document.createElement "canvas")]
    (.setAttribute x 'width 800)
    (.setAttribute x 'height 300)
    x))
(.prepend js/document.body canvas)
```

Für den zweiten Teil unseres kurzen Programms können wir ebenfalls `doto`
nutzen:

**Übung**: besprich mit deinem Tischnachbarn, wieso wir in diesem Fall `aset`
anstatt `set!` nutzen müssen. Gibt es eine Alternative?

> Lies dir nochmal durch, was
> [hier](https://lwhorton.github.io/2018/10/20/clojurescript-interop-with-javascript.html#setters)
> zum Thema [`aset`](https://clojuredocs.org/clojure.core/aset) steht. Wir
> sollten es nicht nutzen, da die Funktion für den Zugriff auf **Arrays**
> gedacht ist und nicht, um auf **Objekt-Eigenschaften** zuzugreifen. Aber es
> ist an dieser Stelle eben sehr praktisch `¯\_(ツ)_/¯`.

In diesem Fall nutzen wir die `doto`-Form nur, um uns Schreibarbeit zu ersparen.
Wir brauchen noch nicht einmal einen Namen zu `def`inieren (vgl. oben).

```
(doto (.getContext canvas "2d")
  (aset 'fillStyle "green")
  (.beginPath)
  (.arc 160 120 72 0.0 (* 2.0 js/Math.PI) false)
  (.fill))
```

### Eine Animation

> Die Idee zu dieser Aufgabe/Lösung habe ich von
> [hier](https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API/Tutorial/Basic_animations).  
> Dieser Abschnitt ist ziemlich schwer. Du wirst beim ersten Mal wahrscheinlich
> nicht alles verstehen. Lass dir Zeit, sprich mit deinem Tischnachbarn.
> Gemeinsam könnt ihr es euch gegenseitig erklären.

Nachdem du nun weißt, wie du einen (ganzen) Kreis zeichnen kannst, möchten wir
nun eine kleine **Animation** programmieren: anstatt immer einen ganzen Kreis zu
zeichnen, möchten wir nur **einen Teil des Kreises** zeichnen und dieser Teil
wird dann immer größer, bis schließlich der ganze Kreis zu sehen ist. Danach
beginnt die Animation von vorne.

Es gibt viele verschiedene Möglichkeiten, diese Aufgabe umzusetzen. Ich stelle
hier eine von ihnen vor. 

Die Grundidee ist, dass wir die **voranschreitende Zeit messen** und damit eine
**Zahl** haben, die **gleichmäßig (bezogen auf die Zeit) immer größer wird**
(eine Uhr).

> Bei dieser speziellen Zahl handelt es sich um die [Anzahl der Millisekunden,
> die seit dem 1.1.1970 vergangen
> sind](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date/getTime).

```
(.getTime (js/Date.)) ;=> 1685483934165
(.getTime (js/Date.)) ;=> 1685483935569
(.getTime (js/Date.)) ;=> 1685483936593
```

Diese Zahl taugt direkt aber noch nicht für unsere Animation. Wir brauchen ja
eine Zahl, mit der wir beschreiben können, dass erst ganz wenig von dem Kreis
gezeichnet wird, dann mehr und schließlich der ganze Kreis. Die Zahl, die wir
suchen, könnte z.B. bei 0 beginnen, dann immer größer werden und dann bei 100
enden und dann wieder bei 0 anfangen. So eine Zahl kannst du mit Hilfe der
Funktion [`mod`](https://cljs.github.io/api/cljs.core/mod) erzeugen, die dir den
[ganzzahligen Rest einer
Division](https://de.wikipedia.org/wiki/Division_mit_Rest#Modulo) liefert.

```
(mod (.getTime (js/Date.)) 100) ;=> 58
```

> Zu was wertet `(mod 99 100)` aus? Zu was wertet `(mod 100 100)` aus? Welche
> möglichen Werte erhalten wir also **ganz genau** durch `(mod (.getTime
> (js/Date.)) 100)`?

Damit haben wir einen Ausdruck, den wir nutzen können, um 0..100 Prozent vom
Kreis zu zeichnen. Den ganzen Kreis zeichnen wir mit `(* 2.0 js/Math.PI)` (vgl.
[Kreisumfang](https://de.wikipedia.org/wiki/Kreis#Umfang)). Nun teilen wir
diesen Umfang in 100 Teile und multiplizieren mit unserem 0-100-Faktor: 

```
(* 2.0 js/Math.PI 1/100 (mod (.getTime (js/Date.)) 100)) ;=> 4.775220833456486
```

OK, nun schreiben wir unser Programm. Wie zuvor definieren wir den Canvas und
fügen ihn in unsere Seite ein. Das `doto` schreiben wir nun in eine Funktion
`draw`:

```
(def canvas 
  (doto (js/document.createElement "canvas")
    (.setAttribute 'width 800)
    (.setAttribute 'height 300)))
(.prepend js/document.body canvas)

(defn draw []
  (doto (.getContext canvas "2d")
    (.clearRect 0 0 800 300)
    (aset 'fillStyle "green")
    (.beginPath)
    (.arc 160 120 72 0.0 (* 2.0 js/Math.PI 1/100 (mod (.getTime (js/Date.)) 100)) false)
    (.fill)))
```

Nun kannst du die Funktion `draw` aufrufen. Jedes Mal wenn du die Funktion
aufrufst, wird der Kreis zu einem bestimmten Anteil gezeichnet.

```
(draw) ;=> #object[CanvasRenderingContext2D [object CanvasRenderingContext2D]]
(draw) ;=> #object[CanvasRenderingContext2D [object CanvasRenderingContext2D]]
(draw) ;=> #object[CanvasRenderingContext2D [object CanvasRenderingContext2D]]
```

Nun möchten wir aber, dass die Funktion `draw` **automatisch immer wieder
ausgeführt wird**. Schließlich möchten wir ja eine Animation erstellen.

> An dieser Stelle denken wir sofort an Schleifen. Leider funktioniert das in
> diesem Fall nicht. Wir kommen noch dazu, warum das so ist.

Wir nutzen dazu die Funktion/Methode
[`js/window.requestAnimationFrame`](https://developer.mozilla.org/en-US/docs/Web/API/window/requestAnimationFrame).
Mit dieser können wir dem Browser den **Auftrag** geben, eine Funktion, die wir
ihm mitgeben, **bei der nächsten Gelegenheit aufzurufen**. 

Wir definieren jetzt die Funktion `draw-loop`. Diese ruft erst `draw` auf, damit
der Kreis gezeichnet wird. Anschließend nutzt sie
`js/window.requestAnimationFrame` um **sich selbst** für die erneute Ausführung
**anzumelden**. Und das führt dann zu .....

```
(defn draw-loop []
  (draw)
  (js/window.requestAnimationFrame draw-loop))
```

Nun kannst du `(draw-loop)` aufrufen.

**Et voilà -- du hast eine Animation!**

> Oops! Das hört ja gar nicht wieder auf 😬  
> Überlegt euch, wie ihr die Animation stoppen könnt.

**Übungen**:

* Besprich mit deinem Tischnachbarn, wie der *Trick* mit dem
  `js/window.requestAnimationFrame` funktioniert. Ist euch aufgefallen, dass der
  Aufruf von `(draw-loop)` sofort einem Wert liefert, obwohl doch der Kreis die
  ganze Zeit immer wieder gezeichnet wird. D.h., ihr könnt in der REPL **weiter
  arbeiten**, während **gleichzeitig** euer Programm ausgeführt wird.

* Anstatt den Kreis in 100 Schritte zu teilen, nutze einen globalen Namen
  `resolution`, um die Anzahl der Teile darüber steuern zu können. Wie muss dann
  die Formel für die Kreisberechnung aussehen.

* Anstatt die `resolution` als globalen Namen zu führen, nutze einen Parameter
  für `draw-loop` und `draw`, um die Anzahl der Teile als Argument beim Aufruf
  von `draw-loop` angeben zu können: `(draw-loop 5000)`

* Ändere das Programm so, dass der Kreis wechselnd größer und kleiner wird. Er
  könnte z.B. mit einem Radius von 0 beginnen und dann schrittweise bis zu einem
  Radius von 90 zunehmen und dann wieder kleiner werden, bis der Radius wieder 0
  ist. Dann beginnt diese Animation von vorne. Kannst du die Radius-Animation
  und die Kreis-Anteil-Animation in einer Animation kombinieren?
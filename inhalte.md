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
* Was sind [Daten](https://de.wikipedia.org/wiki/Daten#Informatik)? 
* Welche Arten von Daten gibt es? Was ist ein
  [Datentyp](https://de.wikipedia.org/wiki/Datentyp#Elementare_Datentypen)?
* Was ist [Information](https://de.wikipedia.org/wiki/Information)?
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
die u.a. einen [interaktiven
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
  eingibst und erst dann *ENTER* drückst?
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
* Gib eine leere Zeichenfolge ein (also eine, aus keinem Zeichen besteht). Diese
  Zeichenfolge hat die Länge 0.
* Was passiert, wenn du am Ende die doppelten Anführungszeichen nicht angibst?
* Was passiert, wenn du zu Beginn die doppelten Anführungszeichen nicht angibst?

-------------------------------------------------------------------------------
## Formen und Werte

Die Form `"hallo"` ist die __äußere Darstellung__ der Zeichenfolge `hallo`.
`hallo` ist also der **Wert**, den wir über die Form `"hallo"` __eingeben__
können. 

Wenn die REPL den Wert `hallo` __ausgibt__, nutzt sie __dieselbe Form__
`"hallo"` dazu. 

Wir müssen also unterscheiden zwischen den **Werten** (Daten), die in unserem
Programm vorhanden sind und der äußeren **Form**, mit der wir diese Werte
eingeben können und mit der diese Werte auch wieder ausgegeben werden.

**Übungen**:

* Welche Formen (unabhängig von Clojure) kennst du, mit denen du die Zahl (also
  den Wert) 12 ausdrücken kannst? 

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

* die Form `12` beschreibt der Ganzzahl-Wert *12* (d.h. die Form `12` wertet zu
  dem Ganzzahl-Wert *12* aus)
* die Form `"TOLL!"` beschreibt den String-Wert *TOLL!*.
* die Form `"12"` beschreibt den String-Wert *12*.

-------------------------------------------------------------------------------
## Boolean / Wahrheitswerte

Der Datentyp [**Boolean**](https://de.wikipedia.org/wiki/Boolean) (siehe auch
  [Wahrheitswerte](https://de.wikipedia.org/wiki/Wahrheitswert)) umfasst nur
  zwei mögliche Werte: *wahr* (`true`) und *falsch* (`false`).

**Übungen**:

* Gibt den Boolean-**Wert** *wahr* ein? Welche **Form** musst du nutzen?
* Welche Arten von Daten kennst du aus deinem Alltag? In welcher Form werden
  diese dargestellt? Tipp: schau mal in die Kontakte-App in deinem Smartphone -
  welche Dinge kannst du dort eingeben?

-------------------------------------------------------------------------------
## Zusammengesetzte Datentypen

Bisher haben wir nur *einfache* (unstrukturierte) **Datentypen** und die
zugehörigen **Werte** und **Formen** kennen gelernt. Clojure kennt aber auch
[*zusammengesetzte*](https://de.wikipedia.org/wiki/Datentyp#Zusammengesetzte_Datentypen)
(*strukturierte*, *komplexe*) Datentypen.

Ein zusammengesetzter Datentyp besitzt Werte, die als **Bestandteil** andere
Werte enthalten. 

> Zusammengesetzte Datentypen kannst du also nutzen, um z.B. Informationen zu
> einer Person auszudrücken (das Geburtsdatum der Person, den Namen der Person,
> den Wohnort der Person).

Clojure kennt u.a. folgende zusammengesetzte Datentypen:

* [Vektor](https://de.wikipedia.org/wiki/Vektor) : eine (ggf. leere) Folge von
  Werten
* [Liste](https://de.wikipedia.org/wiki/Liste_(Datenstruktur)) : eine (ggf.
  leere) Folge von Werten
* [Menge](https://de.wikipedia.org/wiki/Menge_(Datenstruktur)) (engl. *set*):
  eine (ggf. leere) ungeordnete Sammlung von Werten, von denen jeweils maximal
  ein Exemplar enthalten ist (kein Wert darf mehrfach in der Menge enthalten
  sein).
* [Zuordnungstabelle](https://de.wikipedia.org/wiki/Zuordnungstabelle) (engl.
  *map*) : eine (ggf. leere) Sammlung von Schlüssel-Wert-Paaren. Du kannst dir
  eine Map wie eine zwei-spaltige Tabelle vorstellen: in der linken Spalte steht
  jeweils der Schlüssel und in der rechten Spalte steht dann der (dem Schlüssel
  zugeordnete) Wert.

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
> Kommata trennen, so dass sie sich bei Lesen besser von einander abheben, aber
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
  ein Stück Papier. Kommst du drauf?

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

Du kannst dir eine Funktion als eine **Maschine** vorstellen, in die du Werte
hinein gibst (*du **rufst** die **Funktion** mit einem **Wert** auf*) und aus
der das **Ergebnis** der Funktion als **Rückgabewert** heraus kommt.

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

> Diese Zuordnungstabellen wird **Namespace** genannt und wir lernen später mehr
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
## Zugriff auf die Elemente zusammengesetzter Datentypen

Bisher haben wir die Werte zusammengesetzter Datentypen als Form zwar
hinschreiben können (als Literale). Nun möchten wir aber auf die Teile (also die
Elemente) der Datentyp-Werte **zugreifen** und die Teile so aus den
zusammengesetzten Werten herauslesen.

Für diesen Zugriff bietet Clojure eine Reihe von **Funktionen**:

> Im [Cheatsheet](https://clojure.org/api/cheatsheet) findest du viele
> Funktionen, von denen wir einige im folgenden kennen lernen. In dem Cheatsheet
> werden die zusammengesetzten Datentypen __*collections*__ genannt.

* `first` liefert dir das erste Element einer Collection. 
* `second` liefert dir das zweite Element einer Collection. 
* `last` liefert dir das letzte Element einer Collection. 

> Wir werden später sehen, dass diese Aussage nicht 100% korrekt ist. Du kannst
> ja mal ausprobieren, zu was `(second "abc")` auswertet. Macht das Sinn?

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
## `nth`

Die Funktion `nth` liefert dir das __n__-te Element eines zusammengesetzten
Wertes.

> Kannst du dir vorstellen, wieso die Funktion gerade `nth` heißt? Kennst du die
> Buchstaben **n** bzw. **N** aus dem Mathematikunterricht? Welche Bedeutung hat
> der Buchstabe dort?

Dabei ist **n** der __Versatz__ (engl. *offset*) zum ersten Element. Somit
liefert dir `(nth ,,, 0)` das __erste__ Element (da der __Versatz__ zum
__ersten__ Element 0 ist), `(nth ,,, 1)` das zweite Element (da der __Versatz__
zum __ersten__ Element 1 ist), `(nth ,,, 2)` das dritte Element usw. Häufig
wirst du auch die Bezeichnung __Index__ anstatt Versatz hören/lesen. Und man
spricht dann auch vom __*zero-based index*__ oder __[zero-based
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

> In Clojure sind alle Datentypen **unveränderlich** (engl. *immutable*). D.h.,
> wenn ich hier schreibe, dass einer Collection Elemente **hinzugefügt** werden,
> dann meine ich damit, dass eine **neue Collection erzeugt wird**, die zu
> Beginn die gleichen Werte enthält wie `<to-coll>` und dass dann dieser **neuen
> Collection** die Elemente von `<from-coll>` hinzugefügt werden. Weder
> `<from-coll>` noch `<to-coll>` werden geändert --- sie können gar nicht
> geändert werden, weil Clojure das eben **nicht zulässt**.

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
aufzuschreiben, kannst du auch die Funktion `list` nutzen, um eine Liste zu
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
`every?` müssen wir dies beim Aufruf mit Hilfe einer **Funktion (Prädikat!) als
Argument** mitteilen.

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

> Wir könnten die Funktion auch so schreiben: `(map <f> <coll> <colls*>)`.

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

**Aufgabe**: erstelle einen Vektor, der als erstes Element die Summe von **5**,
**3** und **54** hat, als zweites Element soll die Summe des ersten Elements und
**42** enthalten sein und als drittes Element soll die Differenz von **100** und
dem ersten Element im Vektor sein.

Die Lösung könnte so aussehen:

```
[(+ 5 3 54), (+ (+ 5 3 54) 42), (- 100 (+ 5 3 54))] ;=> [62 104 38]
```

Das ist aber doch sehr umständlich und wir müssen die gleiche Form mehrfach
wiederholen.

> Durch diese Wiederholung entsteht zum einen die Gefahr, dass wir uns vertun
> und versehentlich **45** anstatt **54** schreiben und zum anderen muss die
> Form `(+ 5 3 54)` ja mehrfach berechnet werden und das ist ja völlig
> überflüssig.

Mit `[let](https://clojuredocs.org/clojure.core/let)` haben wir die Möglichkeit,
einen **Wert** an einen **Namen zu binden** und diesen Namen anschließend (ggf.
mehrfach) zu verwenden.

In dem folgenden Beispiel **binden** wir den **Wert** der Form `(+ 5 3 54)` ---
also **62** -- an den Namen `s`. Die Form wird nur einmalig ausgewertet und an
den Namen gebunden. Anschließend nutzen wir den **Namen** `s` mehrfach. Wir
wiederholen in diesem Fall den **Namen** `s` mehrfach, aber es besteht nicht die
Gefahr, dass wir uns vertun und der Wert wird nur einmal berechnet.

```
(let [s (+ 5 3 54)]
  [s, (+ s 42), (- 100 s)]) ;=> [62 104 38]
```

Die Form `(let [<name-form-paare*>] <forms*>)` wertet dabei zu dem **Wert** der
letzten `<form>` aus. Die `name-form-paare` bestehen jeweils aus einem Namen
(einem Symbol) und einer Form. `let` wertet die `form`s in dem Vektor der Reihe
nach aus und **bindet** das jeweilige Ergebnis/Wert an den angegeben
Namen/Symbol. Sobald ein Name gebunden ist, kann er anschließend sowohl in den
folgenden `name-form`-Paaren verwendet werden als auch in den anschließenden
`<forms*>`.

Du kannst also auch dies schreiben:

```
(let [s (+ 5 3 54)
      m (+ s 42)
      q (- 100 s)]
  [s m q])
```

Hier haben wir den Namen `m` an den Wert der Form `(+ s 42)` gebunden. Das
konnten wir, weil der Name `s` in dem `let` zuvor schon an den Wert `62`
gebunden war.

> Oben hatten wir uns angeschaut, wie **Symbole** von der REPL ausgewertet
> werden. Lies es dir gerne nochmal durch. Wir müssen nun hinzufügen, dass die
> REPL bei der Auswertung eines Symbols (wie z.B. `m`) erst prüft, ob der Name
> in einem **umschließenden** `let` gebunden ist. Falls ja, wertet das Symbol zu
> diesem Wert aus. Andernfalls wird wie oben erläutert in dem **Namespace**
> nachgeschaut.  
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
> anderen Forms, die wir bisher gesehen haben? Bisher hatten wir immer gesagt,
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

TBD

-------------------------------------------------------------------------------
## Schleifen

> **[Schleifen](https://de.wikipedia.org/wiki/Schleife_(Programmierung))** sind
> in der Informatik ein sehr umfangreiches Thema. Wir wollen das Thema hier aber
> eher pragmatisch/praktisch betrachten und ignorieren den theoretischen Teil.  
> Ein sehr wichtiger Unterschied zwischen Clojures Schleifen-Konstrukten und
> jenen aus den [imperativen
> Programmiersprachen](https://de.wikipedia.org/wiki/Imperative_Programmierung)
> ist, dass Clojures Schleifen **Ausdrücke/Expressions** sind --- sie also
> **einen Wert haben**. In den imperativen Programmiersprachen sind Schleifen
> i.d.R. **Anweisungen/Statements** --- diese beeinflussen zwar den
> Programmfluss (d.h., die steuern, welche Codezeile als nächstes ausgeführt
> wird), aber sie **haben keinen Wert**. Ihre *Wirkung* entfalten sie
> ausschließlich durch **Seiteneffekte** --- d.h., sie setzen eine Variable oder
> geben etwas aus etc. 

In vielen Fällen, in denen du in einer imperativen Programmiersprache eine
Schleife nutzen würdest, kannst du in Clojure einfach HOFs verwenden (z.B. `map`
und `filter`). D.h., du brauchst überhaupt kein eigenständiges/explizites
Schleifen-Konstrukt.

> Das ist eine *gute Sache*. Schleifen können tückisch sein. Häufig wählt man
> Abbruchkriterien falsch, [so dass die Schleife einen Durchlauf zu viel oder zu
> wenig macht](https://de.wikipedia.org/wiki/Off-by-one-Error#Beispiele).

### `for`

Mit `for` kannst du eine Liste erzeugen: 

```
(for [x [1 2 3 4]] x) ;=> (for [x [1 2 3 4]] x)
```

Das ist noch so spannend 😉

Aber schauen wir uns die Form genauer an --- sie (die Liste) hat **drei**
Element: hinter dem ersten Element `for` steht als zweites Element ein
**Vektor**, dessen **erstes** Element das **Symbol** `x` ist und dessen
**zweites** Element ein Vektor mit Elementen (eine **Collection**) ist. 

Als drittes und letztes Element in der Form steht wieder das Symbol `x`.

Der **Wert** der `for`-Form (Auswertung) ergibt sich wie folgt: es wird eine
Liste erzeugt, das erste Element des Vektors (hier der Wert `1`) wird an den
Namen `x` gebunden und dann wird das dritte Element (`x`) als Form ausgewertet.

TBD

### `loop`/`recur`

-------------------------------------------------------------------------------
## Funktionen, die Funktionen liefern (higher order functions)

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
## Funktionen definieren

-------------------------------------------------------------------------------
## TBD: Wahrheit und nochmal Prädikate

-------------------------------------------------------------------------------
## TBD: Was ist der Unterschied zwischen einem Datentyp und einer Sequenz?

-------------------------------------------------------------------------------
## TBD: Bedingte Verzweigung

-------------------------------------------------------------------------------
## TBD: Rekursion, der Stack, Endrekursion

-------------------------------------------------------------------------------
## TBD: Threading

-------------------------------------------------------------------------------
## TBD: Datentypen als Funktion

-------------------------------------------------------------------------------
## TBD: Gleichheit

-------------------------------------------------------------------------------
## TBD: Destructuring

-------------------------------------------------------------------------------
## TBD: Meta-Programmierung / Makros

-------------------------------------------------------------------------------
## TBD: Transducer

-------------------------------------------------------------------------------
## TBD: Nebenläufigkeit und Parallelität

-------------------------------------------------------------------------------
## TBD: Vars und Namensräume

-------------------------------------------------------------------------------

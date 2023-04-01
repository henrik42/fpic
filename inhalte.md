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
* Was sind [Daten](https://de.wikipedia.org/wiki/Daten#Informatik)? 
* Welche Arten von Daten gibt es? Was ist ein
  [Datentyp](https://de.wikipedia.org/wiki/Datentyp#Elementare_Datentypen)?
* Was ist [Information](https://de.wikipedia.org/wiki/Information)?
* Was ist ein
  [(Computer-)Programm](https://de.wikipedia.org/wiki/Computerprogramm)?
* Was bedeutet es, ein Programm auszuführen?
* [Was ist
  Programmieren](https://www.codefuchs.com/artikel/was-ist-programmieren/)?
* Was ist eine
  [Programmiersprache](https://de.wikipedia.org/wiki/Programmiersprache)?
* Was ist
  [Syntax](https://de.wikipedia.org/wiki/Syntax#Syntax_formaler_Sprachen)?

-------------------------------------------------------------------------------
## Die REPL

Was ist eine [Clojure-REPL](https://lambdaisland.com/guides/clojure-repls)?

Du gibst eine *Form* ein, die REPL *wertet* die Form *aus* und schreibt das
*Ergebnis* in die Ausgabe.

**REPL** steht für:
* **Read**: eine [Form](https://clojure.org/guides/learn/syntax)
  [**einlesen**](https://clojure.org/reference/reader) (*to read*)
* **Eval**: die eingelesene Form
  [**auswerten**](https://clojure.org/reference/evaluation) (*to evaluate*). Die
  Auswertung ergibt einen **Wert**.
* **Print**: das Ergebnis der Auswertung (den **Wert**) **ausgeben** (*to print
  something*)
* **Loop**: und das ganz **wiederholen** (*to loop*, *a loop*)

Es gibt verschiedene Möglichkeiten, dies im Browser auszuprobieren. Wir brauchen
dafür keine lokal installierte Software auf unserem Computer, sondern nur einen
Browser und einen Internetzugang.

* https://tryclojure.org/ : du bekommst eine laufende REPL und kannst sofort
  Formen eingeben, die sofort ausgewertet werden. In der REPL kannst du ein
  Tutorial durcharbeiten.

* https://clojurescript.io/ : eine weitere REPL, die im Browser läuft. 

-------------------------------------------------------------------------------
## Hello, world! 👋

Bevor wir überhaupt wirklich irgend etwas über Clojure lernen, wollen wir gleich
unser erstes Programm schreiben.

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

Der Prompt `=>` zeigt dir an, dass die REPL eine Eingabe von dir erwartet. Wir
haben hier `(println "Hello, world! 👋")` eingegeben und dann die ENTER-Taste
gedrückt.

> Wenn du das auch ausprobieren möchtest, kannst du dir den Text einfach hier
> mit der Maus markieren, dann kopieren und in die REPL wieder einfügen.
> [Hier](https://unicode.org/emoji/charts/full-emoji-list.html) findest du
> weitere Emojis.

Die REPL führt nun unser Programm aus. In diesem Fall gibt sie den Text `Hello,
world! 👋`, aus, weil wir in unserem Programm die Funktion `println` nutzen.

Wenn die REPL fertig damit ist, unser Programm auszuführen, gibt sie noch den
*Wert* aus, der von unserem Programm als Ergebnis geliefert wurde. In diesem
Fall ist es der Wert `nil`.

> Don't panic! Diese ganzen Sachen machen bisher wenig Sinn und du brauchst sie
> auch noch nicht zu verstehen. Wir wollen uns hier nur etwas mit der REPL
> vertraut machen. Wir werden alles in Ruhe anschauen und ausprobieren.

-------------------------------------------------------------------------------
## Formen

Was sind Clojure [Formen](https://clojure.org/guides/learn/syntax)? 

> Die Formen in Clojure entsprechen den Sätzen in der natürlichen Sprache (das
> stimmt nicht wirklich, aber da wir hier nicht im Deutschunterricht sind, ist
> das ok für uns). Ein Clojure-Programm besteht aus einer Folge von Formen, d.h.
> Sätzen.

Wir fangen mit den *einfachen* (d.h. unstrukturierten, den
nicht-zusammengesetzten) Formen an. Diese entsprechen den Wörtern der
natürlichen Sprache (aus denen wir anschließend Sätze bilden können).

> *Einfach* bedeutet in diesem Zusammenhang, dass wir die Formen nicht weiter in
> ihre Bestandteile zergliedern können. Wir als Mensch können natürlich Zahlen
> weiter in ihre Ziffern zergliedern, aber aus Sicht von Clojure geht dies in
> diesem Fall nicht. In diesem Sinne sind z.B. Zahlen bzw.
> [Literale](https://de.wikipedia.org/wiki/Literal) für Clojure also **atomar**
> bzw.
> [**elementar**](https://de.wikipedia.org/wiki/Datentyp#Elementare_Datentypen).

### Zahlen

Zahlen: `-5`, `0`, `1`, `2`, `42`, `1.56`, `4/2`, `5/3`

Übungen zu Zahlen:
* Starte einen Browser, navigiere zu https://tryclojure.org/
* Gib dort die Zahlen (*Formen*) `1`, `2` und `234` ein. Nach jeder Form musst
  du die *ENTER*-Taste drücken. Was passiert?
* Was passiert, wenn du mehrere Formen hintereinander durch Leerzeichen getrennt
  eingibst und erst dann *ENTER* drückst?
* Was passiert, wenn du eine sehr große Zahl eingibst?
* Gib nun eine negative Zahl ein. Nutze dazu das vorangestellte Minuszeichen
  (`-`).
* Gib eine Dezimalzahl ein. Als Dezimaltrenner musst du den Punkt (`.`) nutzen -
  nicht das Komma (`,`).

### Zeichenfolgen

Zeichenfolgen (englisch *string*/*strings*): `"hallo"`, `"TOLL!"`, `" i j k "`

Zeichenfolgen werden inklusive der doppelten Anführungszeichen (`"`) am Anfang
und am Ende eingegeben.

Übungen zu Zeichenfolgen
* Gib die Zeichenfolge `"hallo"` ein. Wir sagen, dass diese Zeichenfolge aus 5
  Zeichen besteht. Die Zeichenfolge `"hallo"` hat die Länge 5.
* Gib die Zeichenfolgen `"TOLL!"`, `"A_B_$"`, `"a$b/c:_|<>#~'"` ein.
* Gib eine Zeichenfolge mit nur einem Leerzeichen ein.
* Gib eine Zeichenfolge mit zwei Leerzeichen ein.
* Gib eine leere Zeichenfolge ein (also eine, aus keinem Zeichen besteht). Diese
  Zeichenfolge hat die Länge 0.
* Was passiert, wenn du am Ende die Anführungszeichen nicht angibst?
* Was passiert, wenn du zu Beginn die Anführungszeichen nicht angibst?

-------------------------------------------------------------------------------
## Formen und Werte

Die Form `"hallo"` ist die äußere Darstellung der Zeichenfolge `hallo`. `hallo`
ist also der **Wert**, den wir über die Form `"hallo"` eingeben können. 

Wenn die REPL den Wert `hallo` ausgibt, nutze sie dieselbe Form `"hallo"` dazu. 

Wir müssen also unterscheiden zwischen den **Werten** (Daten), die in unserem
Programm vorhanden sind und der äußeren **Form**, mit der wir diese Werte
eingeben können und mit der diese Werte auch wieder ausgegeben werden.

Übungen:
* Welche Formen (unabhängig von Clojure) kennst du, mit denen du die Zahl (also
  den Wert) 12 ausdrücken kannst? 

> Denk nochmal über die REPL nach. Die REPL liest deine Eingabe ein (*read*).
Deine Eingabe muss aus Formen bestehen. Nach dem Einlesen **wertet** die REPL
deine Formen **aus** (*eval*). Das Ergebnis dieser Auswertung ergibt den
**Wert** deiner Eingabe. Und dieser Wert wird von der REPL wiederum als Form
**ausgegeben** (*print*).

-------------------------------------------------------------------------------
## Werte und Datentypen

Bisher haben wir **Zahlen** und **Zeichenfolgen** (sowohl als **Form** als auch
als **Wert**) kennen gelernt. Wir sprechen bei diesen verschiedenen *Arten von
Daten* (also die Werte) auch von **Datentypen**.

Clojure kennt verschiedene Zahl-Datentypen
([Ganzzahl](https://de.wikipedia.org/wiki/Ganze_Zahl), [Rationale
Zahlen](https://de.wikipedia.org/wiki/Rationale_Zahl),
[Gleitkommazahlen](https://de.wikipedia.org/wiki/Gleitkommazahl); dazu später
mehr) und auch verschiedene text-artige Datentypen:
[Zeichenfolgen](https://de.wikipedia.org/wiki/Zeichenkette) (*strings*),
[Zeichen](https://de.wikipedia.org/wiki/Char_(Datentyp)) (*character*).

Durch den jeweiligen Datentyp wird festgelegt, welche Werte wir mit diesem
Datentyp ausdrücken können (**Wertebereich**). Clojure erkennt beim Einlesen
(durch den [Reader](https://clojure.org/reference/reader)) an der **äußeren
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

Übung:
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

* [Vektor]((https://de.wikipedia.org/wiki/Vektor)) : eine (ggf. leere) Folge von
  Werten
* [Liste](https://de.wikipedia.org/wiki/Liste_(Datenstruktur)) : eine (ggf.
  leere) Folge von Werten
* [Menge](https://de.wikipedia.org/wiki/Menge_(Datenstruktur)) (engl. *set*):
  eine (ggf. leere) ungeordnete Sammlung von Werten, von denen jeweils maximal
  ein Exemplar enthalten ist (kein Wert darf mehrfach in der Menge enthalten
  sein).
* [Zuordnungstabelle](https://de.wikipedia.org/wiki/Zuordnungstabelle) (engl.
  *map*) : eine (ggf. leere) Sammlung von Schlüssel-Wert-Paaren.

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

Übungen:

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
werden durch Leerzeichen (bzw. Kommata) getrennt (wie bei den Vektoren).

Weitere Beispiele für Mengen:

* `#{}` (die leere Menge)
* `#{true}`
* `#{"k" 2}` (Mengen können Werte unterschiedlicher Datentypen enthalten)
* `#{"A" #{"x" "y"} 7}` (Mengen können auch Mengen enthalten)
* `#{#{1} #{} #{2}}` (**geschachtelte** Datenstrukturen; engl. *nested*)

> Mengen und Vektoren können Elemente beliebiger Datentypen enthalten. Somit
> können Vektoren auch Mengen enthalten und Mengen können Vektoren enthalten:
> `[[1 2 3] #{1 2 #{"a"} 3 [true #{"TOLL!"}]}]`.

Übungen:

* Zu was wertet die Form `#{,,,}` aus? 
* Zu was wertet die Form `#{,"a",}` aus? 
* Zu was wertet die Form `#{,"a","a",}` aus? Macht das Sinn?

### Zuordnungstabellen

Eine Zuordnungstabelle (engl. *map*) ist eine (ggf. leere) Sammlung von
**Schlüssel-Wert-Paaren**. Durch eine Map drückst du einen Zusammenhang zwischen
den jeweiligen **Schlüssel-Werten** und dem (einen) zugeordneten **Wert** aus.

In Clojure werden Maps mit geschweiften Klammern (`{` ... `}`) geschrieben. Die
**Schlüssel-Wert-Paare** werden als aufeinanderfolgende Elemente geschrieben.

Sowohl der **Schlüssel** des Schlüssel-Wert-Paares als auch der **Wert** des
Schlüssel-Wert-Paares sind **Werte**. D.h., dass du als Schlüssel auch z.B.
einen Vektor verwenden kannst.

Außerdem brauchen die Schlüssel einer Map nicht alle vom gleichen Datentyp sein.

> Wichtig: wir sagen, dass es sich um Schlüssel-Wert-Paare handelt, aber die
> Paare werden nicht gesondert *eingeklammert*. Du kannst die Paare zwar durch
> Kommata trennen, so dass sie sich bei Lesen besser von einander abheben, aber
> das ist kein Muss. Man hätte die Paare auch explizit durch z.B. spitze
> Klammern (`<` ... `>`) einklammern können, aber das wird in Clojure nicht
> gemacht.

Beispiele für Maps:

* `{}` (die leere Map)
* `{"HSV" 2 "FCB" 1 "St. Pauli" 2}` 
* `{[1 2] 3 [5 6] 11 "nix" 0}`

Übungen:

* Zu was wertet die Form `{"x" 1 "X" 1}` aus?
* Zu was wertet die Form `{"x" 1, "X" 1}` aus?
* Zu was wertet die Form `{"x" 1, "x" 2}` aus? Macht das Sinn?
* Zu was wertet die Form `{["x" 1]}` aus? Macht das Sinn?
* Zu was wertet die Form `{["x" 1] ["x" 2]}` aus? Macht das Sinn?
* Wie könntest du mit Hilfe einer Map ausdrücken, dass der Merkur der nächste
  Planet zur Sonne ist, die Venus der zweitnächste usw.? Überlege dir **zwei**
  mögliche Darstellungen als Map. Tipp: zeichnet dir eine Zuordnungstabelle auf
  ein Stück Papier. Kommst du drauf?

-------------------------------------------------------------------------------
## Funktionen

Bisher haben wir verschiedene Arten von einfachen (Zahlen, Strings, Boolean) und
zusammengesetzten (Vektoren, Mengen, Maps) Daten(-typen) kennen gelernt und wie
du diese über ihre Form beschreiben und ein- und ausgeben kannst.

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
gelernt. Der Funktionsaufruf `(inc 5)` führt zwei neue Arten von Formen ein:

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

Übung:

* Was erhältst du, wenn du `inc` eingibst? Wie unterscheidet sich das von den
  bisherigen Ein-Ausgaben?

### Listen

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

Übungen:

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

Die oben beschrieben Auswertungsregel für Listen lässt sich auch *geschachtelt*
anwenden.

Übungen:
* Zu was wertet `(inc (inc 4))` aus? Wieso?
* Zu was wertet `(inc (inc (inc 4)))` aus?
* Erkläre deiner Tischnachbarin, wieso die Form `((inc 4))` nicht ausgewertet
  werden kann. Welchen Unterschied findest du zwischen den Klammern in Clojure
  und den Klammern, die du im Mathematikunterricht benutzt?
* Wieso lässt sich `(inc 4` nicht auswerten? 
* Wieso lässt sich `(inc 4))` nicht auswerten?
* Und `inc 4)`?

-------------------------------------------------------------------------------
## Zugriff auf die Elemente zusammengesetzter Datentypen

Bisher haben wir die Werte zusammengesetzter Datentypen als Form zwar
hinschreiben können (als Literale). Nun möchten wir aber auf die Teile (also die
Elemente) der Datentyp-Werte **zugreifen** und die Teile so aus den
zusammengesetzten Werten herauslesen.

Für diesen Zugriff bietet Clojure eine Reihe von Funktionen:

> Im [Cheatsheet](https://clojure.org/api/cheatsheet) findest du viele
> Funktionen, von denen wir einige im folgenden kennen lernen. In dem Cheatsheet
> werden die zusammengesetzten Datentypen __*collections*__ genannt.

* `first` liefert dir das erste Element eines zusammengesetzten Wertes. 
* `second` liefert dir das zweite Element eines zusammengesetzten Wertes. 
* `last` liefert dir das letzte Element eines zusammengesetzten Wertes. 

Übungen:

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
> [Stelligkeiten](https://de.wikipedia.org/wiki/Stelligkeit) (Arität) haben.
> Viele Funktionen haben nur eine Stelligkeit. Die Funktion `nth` hat zwei.
> Dabei wird in Clojure die Stelligkeit nur nach der **Anzahl der erwarteten
> Argumente** unterschieden. In anderen Programmiersprachen wird im Zusammenhang
> mit den erwarteten Datentypen auch von
> [Signatur](https://de.wikipedia.org/wiki/Signatur_(Programmierung))
> gesprochen.

* `(nth <coll> <n>)` : liefert das n-te (0-based) Element der Collection. Falls
  n größer oder gleich der Anzahl der Elemente der Collection ist, wird ein
  Fehler geliefert.

> Wir gehen später noch auf das Thema **Fehler** ein. 

* `(nth <coll> <n> <not-found>)` : liefert das n-te (0-based) Element der
  Collection. Falls n größer oder gleich der Anzahl der Elemente der Collection
  ist, wird der Nicht-Gefunden-Wert geliefert.

Übungen:

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
aber feststellen, dass die Funktionen, die von Clojure mitgeliefert werden,
`nil` in dem Sinne *etwas ist nicht vorhanden* verwenden.

> Clojure ist eine [LISP](https://de.wikipedia.org/wiki/Lisp)-Sprache. In diesen
> gibt es verschiedene Arten, *nichts* (oder *nicht vorhanden*) auszudrücken. So
> spielt in LISP die leere Liste `()` eine Sonderrolle -- nicht aber in Clojure.
> Mehr zu dem Thema findest du in dem [Wikipedia-Artikel
> **Nullwert**](https://de.wikipedia.org/wiki/Nullwert).

Übungen:

* Zu was wertet `nil` aus?
* Zu was wertet `[nil]` aus?
* Zu was wertet `[nil nil]` aus?
* Zu was wertet `(nil)` aus?
* Zu was wertet `(inc nil)` aus? Macht das Sinn?
* Zu was wertet `(first nil)` aus? Macht das Sinn?
* Zu was wertet `(nth nil 1)` aus? Macht das Sinn?

-------------------------------------------------------------------------------
## Weitere Funktionen für den Zugriff auf zusammengesetzte Datentypen

Es gibt sehr viele Funktionen in Clojure, um auf Collections zuzugreifen. Hier
führe ich einfach etwas willkürlich einige davon auf, einfach damit du diese
Funktionen kennen lernst und anschließend verwenden kannst.

* `(count <coll>)` : liefert die Anzahl der Elemente in `<coll>`.

* `(into <to-coll> <from-coll>)` : fügt die Elemente von `<from-coll>` zu der
  Collection `<to-coll>` hinzu und liefert das Resultat als Ergebnis. Das
  Resultat ist vom **gleichen Datentyp** wie `<to-coll>`.

> In Clojure sind alle Datentypen **unveränderlich** (engl. *immutable*). D.h.,
> wenn ich hier schreibe, dass einer Collection Elemente hinzugefügt werden,
> dann meine ich damit, dass eine neue Collection erzeugt wird, die zu Beginn
> die gleichen Werte enthält wie `<to-coll>` und dass dann dieser neuen
> Collection die Elemente von `<from-coll>` hinzugefügt werden. Weder
> `<from-coll>` noch `<to-coll>` werden geändert --- sie können gar nicht
> geändert werden, weil Clojure das eben nicht zulässt.

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

Übungen:

* Zu was wertet `(count)` aus? Macht das Sinn?
* Zu was wertet `(count [])` aus? Macht das Sinn?
* Zu was wertet `(count [[1 2]])` aus? Macht das Sinn?
* Zu was wertet `(into [] [1 2 3 4])` aus?
* Zu was wertet `(into {} {1 2 3 4})` aus?
* Zu was wertet `(into ["a"] {1 2 3 4})` aus? Macht das Sinn? Lies dir nochmal
  durch, was Maps genau sind und wie sie als Literal/Form geschrieben werden?

-------------------------------------------------------------------------------
## Mathematische Operatoren

Aus dem Mathematikunterricht kennst du
[Terme](https://de.wikipedia.org/wiki/Term) wie **4 + 7** und **(9 - 2) * 3**.
In Clojure möchten wir auch gerne rechnen und brauchen daher auch eine
Möglichkeit, solche Terme zu formulieren.

In Clojure schreiben wir aber nicht `4 + 7` oder `(4 + 7)`. Diese Art, Ausdrücke
zu schreiben, wird [Infixnotation](https://de.wikipedia.org/wiki/Infixnotation)
genannt. Bei der Infixnotation steht der
[Operator](https://de.wikipedia.org/wiki/Operator_(Mathematik)) zwischen den
beiden [Operanden](https://de.wikipedia.org/wiki/Operator_(Mathematik)#Operand).

> Wieso können wir nicht `(4 + 7)` schreiben? Schau nochmal oben, wie eine
> solche **Form** in Clojure ausgewertet wird.

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
  anzuwenden sind*.  
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

Übungen:

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
## Prädikate und Wahrheit

Wenn du etwas programmierst, wirst du häufig prüfen müssen, ob eine bestimmte
Aussage **wahr** oder **falsch** ist.

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

Es gibt weitere Prädikate:

* `>` (größer als) 
* `<=` (kleiner oder gleich)
* `even?`/`odd?` (ist die Zahl gerade/ungerade?)
* `pos?`/`neg?` (ist die Zahl positiv/negativ?)

Clojure liefert dir aber nicht nur Prädikate für Zahlen sondern auch für die
anderen Datentypen, die wir schon kennen gelernt haben:

* `distinct` : prüft, ob jeder der Argumentwerte nur einmalig vorkommt?
  `(distinct? 1 "a" true)` liefert `true`. `(distinct? 1 "a" true 1)` liefert
  `false`.

* `string?` : prüft, ob das Argument ein String ist. `(string "foo")` liefert
  `true`. 

Übungen:

* Ist die Zahl 0 positiv?
* Zu was wertet `(even? 1.4)` aus? Macht das Sinn?

-------------------------------------------------------------------------------
## Was ist der Unterschied zwischen einem Datentyp und einer Sequenz?

-------------------------------------------------------------------------------
## Funktionen, die Funktionen als Argument nutzen (higher order functions)


# Inhalte

## Einführung

* Was macht ein [Computer](https://de.wikipedia.org/wiki/Computer)?
* Was ist [Software](https://de.wikipedia.org/wiki/Software)?
* Was sind [Daten](https://de.wikipedia.org/wiki/Daten#Informatik)? 
* Welche Arten von Daten gibt es? Was ist ein [Datentyp](https://de.wikipedia.org/wiki/Datentyp#Elementare_Datentypen)?
* Was ist [Information](https://de.wikipedia.org/wiki/Information)?
* Was ist ein [(Computer-)Programm](https://de.wikipedia.org/wiki/Computerprogramm)?
* Was bedeutet es, ein Programm auszuführen?
* [Was ist Programmieren](https://www.codefuchs.com/artikel/was-ist-programmieren/)?
* Was ist eine [Programmiersprache](https://de.wikipedia.org/wiki/Programmiersprache)?
* Was ist [Syntax](https://de.wikipedia.org/wiki/Syntax#Syntax_formaler_Sprachen)?

## Die REPL

Was ist eine [Clojure-REPL](https://lambdaisland.com/guides/clojure-repls)?

Du gibst eine *Form* ein, die REPL *wertet* die Form *aus* und schreibt das
*Ergebnis* in die Ausgabe.

**REPL** steht für:
* **Read**: eine [Form](https://clojure.org/guides/learn/syntax) [**einlesen**](https://clojure.org/reference/reader) (*to read*)
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

## Formen und Werte

Die Form `"hallo"` ist die äußere Darstellung der Zeichenfolge `hallo`. `hallo`
ist also der **Wert**, den wir über die Form `"hallo"` eingeben können. 

Wenn die REPL den Wert `hallo` ausgibt, nutze sie dieselbe Form `"hallo"` dazu. 

Wir müssen also unterscheiden zwischen den **Werten** (Daten), die in unserem
Programm vorhanden sind und der äußeren **Form**, mit der wir diese Werte
eingeben können und mit der diese Werte auch wieder ausgegeben werden.

Übungen:
* Welche Formen (unabhängig von Clojure) kennst du, mit denen du die Zahl 12
  ausdrücken kannst?

> Denk nochmal über die REPL nach. Die REPL liest deine Eingabe ein (*read*).
Deine Eingabe muss aus Formen bestehen. Nach dem Einlesen **wertet** die REPL
deine Formen **aus** (*eval*). Das Ergebnis dieser Auswertung ergibt den
**Wert** deiner Eingabe. Und dieser Wert wird von der REPL wiederum als Form
**ausgegeben** (*print*).

## Werte und Datentypen

Bisher haben wir Zahlen und Zeichenfolgen kennen gelernt. Wir sprechen bei
diesen verschiedenen *Arten von Daten* auch von **Datentypen**.

Clojure kennt verschiedene Zahl-Datentypen
([Ganzzahl](https://de.wikipedia.org/wiki/Ganze_Zahl), [Rationale
Zahlen](https://de.wikipedia.org/wiki/Rationale_Zahl),
[Gleitkommazahlen](https://de.wikipedia.org/wiki/Gleitkommazahl); dazu später
mehr) und auch verschiedene text-artige Datentypen:
[Zeichenfolgen](https://de.wikipedia.org/wiki/Zeichenkette) (*strings*),
[Zeichen](https://de.wikipedia.org/wiki/Char_(Datentyp)) (*character*).

Durch den Datentyp wird festgelegt, welche Werte wir mit diesem Datentyp
ausdrücken können. Clojure erkennt beim Einlesen (durch den
[Reader](https://clojure.org/reference/reader)) an der äußeren Form, welches der
zugehörige Datentyp des mit der Form beschriebenen Wertes ist.

* die Form `12` ist der Ganzzahl-Wert *12*.
* die Form `"TOLL!"` ist der String-Wert *TOLL!*.
* die Form `"12"` ist der String-Wert *12*.

### Boolean / Wahrheitswerte

Der Datentyp [**Boolean**](https://de.wikipedia.org/wiki/Boolean) (siehe auch
  [Wahrheitswerte](https://de.wikipedia.org/wiki/Wahrheitswert)) umfasst nur
  zwei mögliche Werte: *wahr* (`true`) und *falsch* (`false`).

Übung:
* Gibt den Boolean-**Wert** *wahr* ein? Welche **Form** musst du nutzen?
* Welche Arten von Daten kennst du aus deinem Alltag? In welcher Form werden
  diese dargestellt? Tipp: schau mal in die Kontakte-App in deinem Smartphone -
  welche Dinge kannst du dort eingeben?

## Funktionen

Bisher haben wir verschiedene Arten von Daten(-typen) kennen gelernt (Zahlen,
Strings, Boolean) und wie du diese über ihre Form beschreiben und ein- und
ausgeben kannst.

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
> Formen werden auch [S-Expressions](https://en.wikipedia.org/wiki/S-expression)
> genannt.

Übung:
* Was liefert `(inc 8)`?

## Funktionsaufruf als Form

Bisher haben wir Formen für Zahlen, Zeichenketten und Wahrheitswerte kennen
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

Bisher haben wir nur *einfache* (unstrukturierte) **Datentypen** und die
zugehörigen **Werte** und **Formen** kennen gelernt. Clojure kennt aber auch
[*zusammengesetzte*](https://de.wikipedia.org/wiki/Datentyp#Zusammengesetzte_Datentypen)
(*strukturierte*, *komplexe*) Datentypen --- z.B. **Listen**.

Ein zusammengesetzter Datentyp besitzt Werte, die als **Bestandteil** andere
Werte enthalten. 

Eine Liste ist (bzw. enthält) eine (möglicherweise leere) **Folge von Werten**.
Die Liste mit den Werten **42** (Zahl), **TOLL!** (String) und **falsch**
(Boolean) wird geschrieben als:

```
(42 "TOLL!" false)
```

> Die Liste an sich ist ebenfalls ein **Wert**. Ein Wert des Datentyps *Liste*.

Listen werden von der REPL auf eine besondere Weise behandelt: 
* Wenn die REPL beim *read* auf eine runde öffnende Klammer (`(`) stößt, erkennt
  sie, dass hier eine **Listen-Form** **beginnt**.
* Die REPL fährt damit fort, Formen einzulesen und **auszuwerten**. Die REPL
  **merkt** sich die **Werte** zu den ausgewerteten Formen. Denn dies sind ja
  die Elemente (Bestandteile) der Liste, die hier gerade eingelesen wird.
* Sobald die REPL auf die runde schließende Klammer (`)`) stößt, erkennt sie,
  dass hier die Listen-Form endet. Die REPL erzeugt eine Liste (einen
  **Listen-Wert**), die als Elemente/Bestandteile jene Werte enthält, die seit
  der öffnenden Klammer durch die Auswertung der Formen als Werte aufgesammelt
  wurden.
* Nun **wertet** die REPL die soeben erzeugte Liste **aus** (so wie jede andere
  Form ja auch!). Dabei nimmt sie an, dass das erste Element der Liste eine
  **Funktion** ist. Nun ruft die REPL diese Funktion mit den restlichen
  Elementen als
  [**Argument**](https://de.wikipedia.org/wiki/Parameter_(Informatik)) auf.
* Der Rückgabewert des Funktionsaufrufs (das **Funktionsergebnis**) ist der Wert
  der Auswertung der Liste.

> Don't Panic! Das schauen wir uns ganz in Ruhe nochmal an ;-)

Übungen:
* Erkläre deinem Tischnachbarn, wieso `(inc 5)` zu dem Wert **6** auswertet.
* Zu was wertet `inc` aus?
* Probier aus, zu was `()` auswerten.
* Zu was wertet `(5 inc)` aus. Wieso?
* Zu was wertet `(inc)` aus. Wieso?
* Zu was wertet `(inc 5 8)` aus? Hast du eine Idee, wieso das so sein könnte?
* Zu was wertet `(inc "12")` aus? Macht das Sinn?
* Zu was wertet `(inc false)` aus? Und `(inc true)`? Macht das Sinn?

### Geschachtelte Listen

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


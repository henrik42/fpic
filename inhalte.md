# Inhalte

## Einführung

* Was macht ein [Computer](https://de.wikipedia.org/wiki/Computer)?
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
* **Read**: eine Form **einlesen** (*to read*)
* **Eval**: die eingelesene Form **auswerten** (*to evaluate*)
* **Print**: das Ergebnis der Auswertung **ausgeben** (*to print something*)
* **Loop**: und das ganz **wiederholen** (*to loop*, *a loop*)

Es gibt verschiedene Möglichkeiten, dies online im Browser auszuprobieren. Wir
brauchen dafür keine lokale Installation, sondern nur einen Browser und einen
Internetzugang.

* https://tryclojure.org/ : du bekommst eine laufende REPL und kannst sofort
  Formen eingeben, die sofort ausgewertet werden. In der REPL kannst du ein
  Tutorial durcharbeiten.

* https://clojurescript.io/ : eine weitere REPL, die im Browser läuft. 

## Formen

Was sind Clojure [Formen](https://clojure.org/guides/learn/syntax)? 

Wir fangen mit den "einfachen" (d.h. unstrukturierten, den
nicht-zusammengesetzten) Formen an.

### Zahlen

Zahlen: `1` `2` `42` `1.56` `4/2` `5/3`

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

Zeichenfolgen: `"hallo"` `"TOLL!"` `" i j k "`

Zeichenfolgen werden inklusive der doppelten Anführungszeichen (`"`) am Anfang
und am Ende eingegeben.

Übungen zu Zeichenfolgen
* Gib die Zeichenfolge `"hallo"` ein.
* Gib die Zeichenfolgen `"TOLL!"`, `"A_B_$"`, `"a$b/c:_|<>#~'"` ein.
* Gib eine Zeichenfolge mit nur einem Leerzeichen ein.
* Gib eine leere Zeichenfolge ein.
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
* Welche Formen kennst du, mit denen du die Zahl 12 ausdrücken kannst?

## Werte und Datentypen

Bisher haben wir Zahlen und Zeichenfolgen kennen gelernt. Wir sprechen bei
diesen verschiedenen *Arten von Daten* auch von **Datentypen**.

Clojure kennt verschiedene Zahl-Datentypen (Ganzzahl, Rationale Zahlen,
Fließkommazahlen) und auch verschiedene text-artige Datentypen: Zeichenfolgen
(*strings*), Zeichen (*character*).

Durch den Datentyp wird festgelegt, welche Werte wir mit diesem Datentyp
ausdrücken können. 

### Boolean

Der Datentyp *Boolean* umfasst nur zwei mögliche Werte: *wahr* (`true`) und
  *falsch* (`false`).

Übung:
* Gibt den **Wert** *wahr* ein? Welche **Form** musst du nutzen?



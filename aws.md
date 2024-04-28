# Installation auf AWS

In `minecraft.md` beschreibe ich, wie du den Minecraft-Server auf deinem
Computer installieren kannst. Anschließend kannst du dann Minecraft lokal auf
deinem Computer spielen und du kannst mit Clojure und VSCode/Calva das Spiel
beeinflussen.

Du wirst aber in der Regel nicht in der Lage sein, mit Freunden gemeinsam zu
spielen, weil deine Freunde von außen über das Internet nicht auf deinen Rechner
werden zugreifen können.

Es gibt [viele
Möglichkeiten](https://www.howtogeek.com/58968/how-to-start-your-own-minecraft-server/),
diesen Zugriff zu ermöglichen. Allerdings möchten viele Leute (und
wahrscheinlich auch deine Eltern) ungern, ihr Heimnetz für Zugriffe aus dem
Internet öffnen, weil dadurch gewisse Sicherheitsprobleme entstehen.

Eine Alternative ist, einen Minecraft-Server im Internet auf [Amazon Web
Services](https://aws.amazon.com/) (AWS) zu betreiben. Es gibt aber auch [andere
Cloud-Anbieter](https://de.wikipedia.org/wiki/Cloud_Computing#Liste_an_Clouds).

## AWS/EC2 Instanz erstellen

In [Setting up a Minecraft Java server on Amazon
EC2](https://aws.amazon.com/de/blogs/gametech/setting-up-a-minecraft-java-server-on-amazon-ec2/)
findest du eine Anleitung, wie du auf
[AWS](https://de.wikipedia.org/wiki/Amazon_Web_Services) einen __virtuellen
Computer__ (wird von AWS eine __EC2 Instanz__ genannt) erzeugst.

Du brauchst der Anleitung nur bis zu dem Punkt zu folgen, an dem deine
EC2-Instanz läuft. 

Für meine EC2-Instanz habe ich auf AWS folgende Dinge gewählt:

* Instanz-Typ: t4g.medium
* RAM: 4 GB
* Plattenplatz: 8 GB

__Hinweis__: In der Anleitung wird eine Liste von IP-Ranges erwähnt, aus der du
die Angabe der `ip_prefix` entnehmen sollst. Diese Liste findest du [hier
https://ip-ranges.amazonaws.com/ip-ranges.json](https://ip-ranges.amazonaws.com/ip-ranges.json).
In deinem Browser wählst du dann die __Rohdaten__-Ansicht. Dann suchst du (mit
Hilfe von `Strg-f`) in der Seite nach `EC2_INSTANCE_CONNECT` und
`"network_border_group": "eu-central-1"`. Damit findest du die Angabe
`ip_prefix`. 

Derzeit sieht der Eintrag so aus:

```
{
      "ip_prefix": "3.120.181.40/29",
      "region": "eu-central-1",
      "service": "EC2_INSTANCE_CONNECT",
      "network_border_group": "eu-central-1"
    },
```

Du kannst dich dann über die Web-Konsole mit der EC2-Instanz verbinden und damit
eine Bash-Shell öffnen. Beim Login musst du die Benutzerkennunf `ec2-user`
angeben. In diese Shell gibst du dann die folgenden Befehle ein.

## SWAP-Space einrichten

Die `t4g.medium` Instanz hat 4 GB RAM. Allerdings steht dir dieser Speicher
nicht vollständig für deinen Minecraft-Server-Prozess zur Verfügung, weil eine
ganze Reihe weiterer laufender Prozesse ebenfalls RAM belegen. 

Du kannst den Speicher aber um einen
[SWAP-Space](https://de.wikipedia.org/wiki/Swapping) erweitern. Dadurch hast du
mehr (virtuellen) Speicher für deine Prozesse zur Verfügung. Allerdings bremst
dieser Speicher deine Prozess u.U. aus, weil das Betriebssystem bei Bedarf
Speicherbereiche auf die Festplatte auslagert und/oder sie von der Festplatte in
das RAM liest. Und das ist im Vergleich zu einem direkten Zugriff ins RAM
erheblich langsamer.

Am besten, du probierst es einfach aus uns justierst deine Einstellungen (vgl.
unten).

Den SWAP-Space richtest du [wie folgt in deiner EC2-Instanz
ein](https://repost.aws/knowledge-center/ec2-memory-swap-file). Hier richte ich
einen SWAP-Space mit 3 GB ein.

```
sudo bash
fallocate -l 3G /swapfile
chmod 600 /swapfile
mkswap /swapfile
swapon /swapfile
echo '/swapfile swap swap defaults 0 0' >> /etc/fstab
```

## Java installieren

In [Install using the yum Package Manager on Amazon
Linux](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/amazon-linux-install.html#amazon-linux-install-instruct) findest du die Installationsanleitung.

```
sudo yum install java-17-amazon-corretto-headless
```

Anschließend prüfst du, ob es geklappt hat:

```
[ec2-user@ip-172-31-**-** ~]$ java -version
openjdk version "17.0.10" 2024-01-16 LTS
OpenJDK Runtime Environment Corretto-17.0.10.7.1 (build 17.0.10+7-LTS)
OpenJDK 64-Bit Server VM Corretto-17.0.10.7.1 (build 17.0.10+7-LTS, mixed mode, sharing)
```

## Clojure installieren

In [Linux
instructions](https://clojure.org/guides/install_clojure#_linux_instructions)
findest du die Installationsanleitung. 

```
curl -L -O https://github.com/clojure/brew-install/releases/latest/download/linux-install.sh
chmod +x linux-install.sh
sudo ./linux-install.sh
```

## Minecraft Workshop downloaden

Du kannst den Workshop via `git clone` downloaden. Aber wir brauchen nicht
unbedingt `git`, daher zeige ich hier, wie du den Download via `wget` machst.

```
wget https://github.com/lambdaisland/witchcraft-workshop/archive/refs/heads/main.tar.gz
tar -vzxf main.tar.gz
cd witchcraft-workshop-main/
```

## Minecraft Server starten

**ACHTUNG:** Sobald du in AWS den Port 25565 für **alle** Zugriffe aus dem
Internet geöffnet hast, kann jeder auf deinen Minecraft-Server zugreifen und
*mitspielen*. Sicher, man muss erstmal die IP deiner EC2-Instanz erraten, aber
es gibt Tools, die Port-Scans durchführen, um gezielt offene Minecraft-Server im
Internet zu finden. Du solltest dir also unbedingt Gedanken darüber machen, wie
du den __Zugriff durch Unbefugte unterbinden kannst__. Dazu gibt es viele Infos
im Internet.
[Hier](https://www.spigotmc.org/threads/how-to-secure-your-minecraft-server-from-hackers-bots-and-ddos-attacks.606262/)
ist einer, den ich gefunden habe. Weiter unten beschreibe ich, wie du deinen
Server schützen kannst. __Vorerst solltest du den Zugriff aus dem Internet auf
Port 25555 nicht erlauben/einrichten__.

Nun kannst du den Server starten. Hier starte ich den Server mit 3 GB
Heap-Größe. Da wir 7 GB (4 GB RAM + 3 GB SWAP) insgesamt zur Verfügung haben,
sollten 3 GB eine gute Wahl sein. Wenn wir den Heap zu groß wählen, laufen wir
Gefahr, dass ständig geswappt wird und unser Server dadurch extrem ausgebremst
wird. Aber probiere ruhig etwas rum mit verschiedenen Heap-Größen. Ein größerer
Heap erlaubt dir, mehr Spieler gleichzeitig am Server angemeldet zu haben.

```
MEMORY=3G ./bin/start-server
```

Beim ersten Mal musst du noch der Lizenz zustimmen, indem du `y` und ENTER
eingibst.

```
[start-server] eula.txt not found. Do you agree to the Minecraft End User License Agreement (https://account.mojang.com/documents/minecraft_eula)? [y/N]
```

Beim ersten Start benötigt der Server-Start auch eine ganze Weile, weil noch
viele Dateien aus dem Internet nachgeladen werden.

Wenn der Server vollständig gestartet ist, solltest du als letzte Zeile
folgendes sehen:

```
nREPL server started on port 25555 on host localhost - nrepl://localhost:25555
```

Du kannst den Server durch `strg-c` (bzw. `ctrl-c`) oder das Kommando `stop`
runterfahren. Der Server sichert dann noch die Spielinformationen und beendet
sich.

## Zugriff via SSH-Tunnel

Wir wollen unseren Minecraft-Server und den nREPL-Server über das Internet
ansprechen können. Wir möchten aber nicht, dass jeder, der zufällig die
IP-Adresse unserer EC2-Instanz errät und dann auf Port 25555 den
Minecraft-Server kontaktiert, auch auf unserem Server mitspielt (vgl. oben).

### SSH

Daher werden wir unseren Minecraft-Server über einen
[SSH](https://de.wikipedia.org/wiki/Secure_Shell)-Tunnel (sog.
[Portweiterleitung](https://de.wikipedia.org/wiki/Portweiterleitung))
ansprechen. 

Um deinen AWS-Minecraft-Server anzusprechen, musst du (und deine Freund, die auf
demselben Server mit dir zusammen spielen möchten) __erst__ den __SSH-Tunnel
aufbauen__ und anschließend kannst du dich dann mit deinem Minecraft-Client (den
du z.B. über deinen Windows-Minecraft-Launcher startest) mit dem Server
verbinden (Multi-Player-Modus)

### OpenSSH / PuTTY

Um den SSH-Tunnel aufzubauen, benötigst du [OpenSSH für
Windows](https://learn.microsoft.com/de-de/windows-server/administration/openssh/openssh_overview)
oder [PuTTY](https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html).

### Digitaler Schlüssel

Für den Aufbau des SSH-Tunnels benötigst du einen (digitalen) _Schlüssel_. Wie
man diesen Schlüssel erzeugt, zeige ich weiter unten. Du wirst diesen Schlüssel
(es handelt sich um eine Datei) erstellen und ihn (z.B. als Datei-Anhang an eine
E-Mail) an jene Freunde weitergeben, die auch auf dem Server spielen können
sollen.

Wir werden erstmal nur __einen Schlüssel__ erzeugen. Alle deine Freunde werden
also __diesen einen Schlüssel__ nutzen. Du kannst später den Schlüssel zwar
entwerten, aber dann kann keiner deiner Freunde mehr auf den Minecraft-Server
zugreifen. Falls du jedem Spieler einzeln den Zugriff erlauben möchtest, musst
du __mehrere Schlüssel__ erzeugen und diese verteilen.

Durch den Schlüssel, den du erzeugen wirst, ermöglichst du deinen Freunden nur
den Zugriff auf den Minecraft-Server. Wir werden den Zugang so beschränken, dass
deine Freund nicht in der Lage sein werden, sich auf der EC2-Instanz
__anzumelden__ und z.B. Dateien lesen oder ändern zu können. Der SSH-Tunnel wird
__ausschließlich die Portweiterleitung__ ermöglichen -- sonst nichts.

### Schlüsselerzeugung

Wir werden den Schlüssel auf der AWS-EC2-Instanz erzeugen. Dazu startest du
deine EC2-Instanz, falls du das noch nicht gemacht hast und öffnest eine Shell.

Als erstes erstellen wir das Verzeichnis `/home/ec2-user/ssh-keys` und erzeugen
darin den digitalen Schlüssel. Das Programm fragt dich nach einem Passwort. Das
solltest du unbedingt vergeben. Dieses Passwort musst du deinen Freunden
ebenfalls mitteilen.

```
mkdir /home/ec2-user/ssh-keys
ssh-keygen -f /home/ec2-user/ssh-keys/minecraft_rsa -t rsa
```

Es handelt sich bei dem erzeugten Schlüssel um ein __Schlüsselpaar__. Die Datei
`/home/ec2-user/ssh-keys/minecraft_rsa` enthält den __privaten Schlüssel__.
Diese Datei musst du normalerweise geheim halten. Wir werden sie aber später mit
unseren Freunden teilen (unten mehr dazu). Da du ein Passwort vergeben hast, ist
es nicht so schlimm, falls die Datei doch einmal in die Hände Unbefugter gerät
-- sie kennen dann ja hoffentlich nicht das Passwort und können nichts mit der
Datei anfangen.

Die Datei sieht etwa so aus:

```
-----BEGIN OPENSSH PRIVATE KEY-----
b3BlbnNzaC1rZXktdjEAAAAACmFlczI1Ni1jdHIAAAAGYmNyeXB0AAAAGAAAABAlAXxWm6
[...]
MvMaUPHUTgieCaMuZAH7SNdYL0GWngOWwzMHYI7STvbSzuayJ4ueebPdjCFuAjcvkX1h8g
==
-----END OPENSSH PRIVATE KEY-----

```

Die Datei `/home/ec2-user/ssh-keys/minecraft_rsa.pub` enthält den __öffentlichen
Schlüssel__. Diesen kannst du bedenkenlos mit anderen teilen.

Die Datei hat nur eine Zeile und sieht etwa so aus:

```
ssh-rsa AAAAB3[...]6hZ0= ec2-user@ip-172-67-0-255.eu-central-1.compute.internal
```

### Ein No-Shell-Benutzer für den SSH-Tunnel

Nun legen wir den Benutzer `minecraft` an, den ihr für den Aufbau des
SSH-Tunnels nutzen werdet.

```
sudo adduser minecraft --shell /bin/false
```

Der Benutzer wird so angelegt, dass er keine Shell öffnen kann. Der Benutzter
soll ja nur den SSH-Tunnel öffnen können.

### `minecraft_rsa.pub` _installieren_

Nun kopieren wir den öffentlichen Schlüssel
`/home/ec2-user/ssh-keys/minecraft_rsa.pub` nach
`~minecraft/.ssh/authorized_keys`.

```
sudo mkdir ~minecraft/.ssh
sudo cp /home/ec2-user/ssh-keys/minecraft_rsa.pub ~minecraft/.ssh/authorized_keys
sudo chown -R minecraft:minecraft ~minecraft/.ssh
sudo chmod go-rwx ~minecraft/.ssh
```

Ab diesem Zeitpunkt kann jeder, der über den __privaten Schlüssel__
`/home/ec2-user/ssh-keys/minecraft_rsa` zu dem soeben installierten öffentlichen
Schlüssel verfügt, einen SSH-Tunnel aufbauen.

### `/home/ec2-user/ssh-keys/minecraft_rsa` auf deinen Computer kopieren

Nun kopierst du den Inhalt von `/home/ec2-user/ssh-keys/minecraft_rsa` in eine
Datei auf deinem Computer. Das kannst du z.B. so machen, dass du den Inhalt der
Datei auf deiner EC2-Instanz mit `cat` ausgibst und dann via copy&paste in eine
Datei schreibst. Ich schreib den privaten Schlüssel nach
`C:\clojure\minecraft_rsa`.

```
cat /home/ec2-user/ssh-keys/minecraft_rsa
```

__HINWEIS:__ Die Datei `C:\clojure\minecraft_rsa` muss im UNIX-Zeilenende-Format
sein. Und die letzte Zeile `-----END OPENSSH PRIVATE KEY-----` muss mit einem
`LF`-Zeichen abgeschlossen sein! Du kannst das Git-Bash-Tools `dos2unix`
benutzen, um die Zeilenenden in das UNIX-Format zu bringen.

### SSH-Tunnel aufbauen

Nun kannst du von deinem Windows-Computer aus mit Hilfe des privaten Schlüssels
den SSH-Tunnel aufbauen. Ich zeige hier, wie das in der Windows-CMD-Shell
aussieht. Du musst noch die `<ec2-ip-adresse>` deiner EC2-Instanz eintragen.

```
ssh -v -i c:\clojure\minecraft_rsa minecraft@<ec2-ip-adresse> -L 35555:localhost:25555 -L 35565:localhost:25565 -N
```

Auf einigen Windows-Rechnern kann es zu folgender Fehlermeldung kommen:

```
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@         WARNING: UNPROTECTED PRIVATE KEY FILE!          @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
Permissions for 'minecraft_rsa' are too open.
It is required that your private key files are NOT accessible by others.
```

Das ssh-Programm macht dich darauf aufmerksam, dass der Zugriff auf die Datei
`minecraft_rsa` nicht genügend eingeschränkt ist und damit könnten u.U. andere
Benutzer, die ebenfalls an deinem Rechner arbeiten können, diese Datei lesen.
Das stellt aber ein Sicherheitsrisiko dar, weil die Datei ja ein __privater__
Schlüssel ist.

Du musst den Zugriff auf die Datei also erst einmal einschränken, bevor du sie
nutzen kannst.

Das machst du unter Windows-CMD wie folgt:

```
Set Key="minecraft_rsa"
Icacls %Key% /Inheritance:d
TakeOwn /F %Key%
Icacls %Key% /Grant:r %UserName%:F
Icacls %Key% /Remove:g "Authenticated Users" BUILTIN\Administrators BUILTIN Everyone System Users
```

### Minecraft spielen

Nun startest du über deinen Windows-Minecaft-Launcher die Java Edition 1.18.2,
wählst den Multiplayer Modus und fügst einen Server mit der Server-Adresse
`localhost:35565` zu.

Und los geht's!

Falls alles funktioniert, kannst du nun den __privaten__ Schlüssel
`minecraft_rsa` an deine Freunde weitergeben und ihnen das Passwort verraten.
Deine Freunde können nun ebenfalls einen SSH-Tunnel öffenen und ihr könnte auf
deinem Minecraft-Server zusammen spielen.

Viel Spaß dabei!

### nREPL testen

Von der CMD-Shell aus kannst du auch prüfen, ob deine nREPL-Verbindung zum
Minecraft-Server funktioniert. Wenn du die folgenden beiden Zeilen eingibst,
müsstest du auf einem Server die Ausgabe `Hello, world!` sehen.

```
deps -Sdeps "{:deps {nrepl/nrepl {:mvn/version ""1.0.0""}}}" -M -m nrepl.cmdline -c --host 127.0.0.1 --port 35555
(.println System/out "Hello, world!")
```

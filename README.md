# JAVA-Hangman
Author: <br />Goca Andelkovic<br />
LBS Eibiswald | 2aAPC | Gruppe A |  13.10.2025

## Hangman
Das folgende Java-Programm ist ein einfaches Hangman-Spiel. Es bietet die folgenden Funktionen:
- Es richtet ein einfaches Hangman-Spiel ein, bei dem der Benutzer die Buchstaben eines zufällig ausgewählten Wortes erraten kann.
- Standardmäßig beträgt die Anzahl der zulässigen Fehler 9, kann jedoch vom Benutzer geändert werden.
- Die Wörter werden zufällig aus einer separaten Datei ausgewählt.
- Mit jedem Fehler erscheint ein weiterer Teil des Bildes, bis das vollständige Hangman-Bild entsteht.
- Es gibt außerdem eine Option, mit der der Benutzer sehen kann, welche Buchstaben er bereits erraten hat.

## Wie funktioniert das Programm?
Das Programm verwendet drei Klassen:
- **ErrorNumber.java** – fügt bei jedem Fehler das entsprechende Bild hinzu.
- **Hangman.java** – wählt ein zufälliges Wort aus und stellt Getter und Setter bereit. Außerdem richtet sie die entsprechenden Unterstriche ein und verwaltet die Hauptlogik des Spiels.
- **HangmanGUI.java** – richtet die grafische Benutzeroberfläche (GUI) und ihre Komponenten ein. Sie verwaltet auch die Logik für die einzelnen Komponenten (z. B. für das Menü).
- Zusätzlich gibt es die Datei **words**, die alle Wörter enthält, aus denen das Spiel zufällig auswählt.

### Verwendung
Technologien im Einsatz:<br />
- **Java**
- **Swing**

### Screenshots
![alt text](https://github.com/dannyfox9898/HangmanITL/blob/main/src/hm1.png)
![alt text](https://github.com/dannyfox9898/HangmanITL/blob/main/src/hm2.png)

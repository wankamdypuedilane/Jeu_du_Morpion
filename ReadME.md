# Jeu de Morpion (Tic-Tac-Toe)

Description
- Application console Java pour jouer au morpion à deux joueurs.
- Le jeu demande les noms des joueurs, puis alterne les tours. Les cases sont choisies par un chiffre entre 1 et 9.
- Commandes spéciales : `exit` ou `quit` pour quitter.

Prérequis
- Java 11 ou supérieur
- IntelliJ IDEA (optionnel)
- Système Linux (instructions en ligne de commande fournies)

Installation & exécution

Avec IntelliJ IDEA
1. Ouvrir le projet dans IntelliJ IDEA.
2. Vérifier/configurer le JDK (Java 11+).
3. Lancer la classe `Main` (point d'entrée : `src/Main.java`).

En ligne de commande (sans outil de build)
1. Se placer à la racine du projet (contenant le dossier `src`).
2. Compiler :
   ```bash
   javac -d out $(find src -name '*.java')


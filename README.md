# Java Hangman Game

A simple and interactive **Hangman** console game written in Java. The program reads a list of words from `words.txt`, randomly picks one, and challenges the player to guess it one letter at a time.

---

##  Features

- Reads a list of words from a file (`words.txt`)
- Picks a random word for each game session
- Displays masked word state with underscores (e.g., `_ _ _ _`)
- Shows dynamic Hangman ASCII art progression for each wrong guess
- Allows up to 6 incorrect guesses before ending the game
- Informs the player if they win or lose, revealing the correct word at the end

---

##  Getting Started

### Prerequisites

- Java JDK (11 or later is recommended)
- Git (optional, for cloning the repo)

### Installing & Running

1. Clone the repository (if you haven't already):
   ```bash
   git clone https://github.com/hnh-zeal/hangman-game.git
   cd hangman-game

2. Ensure there's a words.txt file in the project root, listing one word per line, for example:
    ```bash
    apple
    orange
    banana
    coconut
    pineapple
    grape
    lime
    lemon

3. Compile the game:
    ```bash
    mvn compile

4. Run the game:
    ```bash
    mvn exec:java -Dexec.mainClass="org.example.Main"

🎲 How to Play

1. The game starts and selects a random word.

2. You see the initial Hangman figure and the hidden word (underscores).

3. Type a single letter and press Enter.

- If correct, the letter is revealed in all its positions.

- If incorrect, the hangman drawing progresses one step closer to completion.

4. Continue guessing until:

- You reveal the entire word (You Win!), or

- The hangman is fully drawn after 6 wrong guesses (Game Over!).

5. The correct word is revealed afterward.


### ⚙️ Customization

- Add more words: Simply append to words.txt.

- Adjust difficulty: Change the value of MAX_WRONG_GUESSES in Main.java.

- Track guessed letters: Prevent repeat guesses by enhancing the logic.

- Improve visuals: Add colors or emojis for better console interaction.

---

### 🤝 Contributions

- You’re welcome to enhance the game by:

- Adding a GUI interface (JavaFX or Swing)

- Tracking and displaying previous guesses

- Categorizing words (fruits, animals, countries, sports, etc.)

- Accepting full-word guesses

- Adding difficulty levels

Feel free to fork, improve, and open pull requests!

---

## 📜 License

This project is free to use and modify.

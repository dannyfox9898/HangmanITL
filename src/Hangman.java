import java.io.File;
import java.util.*;
import java.io.*;

public class Hangman {
    private static List<String> WORDS = new ArrayList<>();

    private String secretWord;
    private StringBuilder currentWord;
    private int mistakes;
    private int maxMistakes = 9;
    private Set<Character> guessedLetters =  new LinkedHashSet<>();

    static {
        File file = new File("src/words");
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim().toUpperCase();
                    if (!line.isEmpty()) {
                        WORDS.add(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (WORDS.isEmpty()) {
            System.err.println("words.txt not found, using default list.");
            WORDS = Arrays.asList("JAVA", "SWING", "PROGRAMMING", "HANGMAN");
        }
    }


    public Hangman() {
        Random rand = new Random();
        secretWord = WORDS.get(rand.nextInt(WORDS.size()));

        currentWord = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            currentWord.append("_");
        }
        mistakes = 0;
        guessedLetters.clear();
    }

    public boolean guess(char c) {
        c = Character.toUpperCase(c);

        if (guessedLetters.contains(c)) {
            return false;
        }

        guessedLetters.add(c);

        boolean correct = false;

        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == c) {
                currentWord.setCharAt(i, c);
                correct = true;
            }
        }

        if (!correct) {
            mistakes++;
        }

        return correct;
    }

    public String getCurrentWord() {
        return currentWord.toString();
    }

    public int getMistakes() {
        return mistakes;
    }

    public boolean isSolved() {
        return currentWord.toString().equals(secretWord);
    }

    public boolean isGameOver() {
        return mistakes >= maxMistakes || isSolved();
    }

    public String getSecretWord() {
        return secretWord;
    }

    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public void setMaxMistakes(int maxMistakes) {
        this.maxMistakes = maxMistakes;
    }

    public int getMaxMistakes() {
        return maxMistakes;
    }
}

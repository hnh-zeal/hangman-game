package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int MAX_WRONG_GUESSES = 6;

    public static void main(String[] args) {
        String filePath = "words.txt";
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find file.");
        }
        catch (IOException e) {
            System.out.println("Something went wrong.");
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        Scanner scanner = new Scanner(System.in);

        List<Character> wordState = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        int wrongGuesses = 0;

        System.out.println("************************");
        System.out.println(" Welcome to Java Hangman!");
        System.out.println("************************");

        while (wrongGuesses < MAX_WRONG_GUESSES) {
            // show hangman
            System.out.println(getHangmanArt(wrongGuesses));

            // show current word state
            System.out.print("Word: ");
            for (char ch : wordState) {
                System.out.print(ch + " ");
            }
            System.out.println();

            // ask for input
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (word.indexOf(guess) >= 0) {
                System.out.println("✅ Correct guess!");
                updateWordState(wordState, word, guess);

                if (!wordState.contains('_')) {
                    System.out.println(getHangmanArt(wrongGuesses));
                    System.out.println("🎉 YOU WIN!");
                    System.out.println("The word was: " + word);
                    break;
                }
            } else {
                wrongGuesses++;
                System.out.println("❌ Wrong guess!");
            }
        }

        if (wrongGuesses >= MAX_WRONG_GUESSES) {
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("💀 GAME OVER!");
            System.out.println("The word was: " + word);
        }

        scanner.close();
    }

    private static void updateWordState(List<Character> wordState, String word, char guess) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                wordState.set(i, guess);
            }
        }
    }

    static String getHangmanArt(int wrongGuesses) {
        return switch (wrongGuesses) {
            case 0 -> """
                 
                 
                 
                      """;

            case 1 -> """
                       o
                      
                      
                      """;

            case 2 -> """
                       o
                       |
                      
                      """;

            case 3 -> """
                       o
                      /|
                      
                      """;

            case 4 -> """
                       o
                      /|\\
                      
                      """;

            case 5 -> """
                       o
                      /|\\
                      /
                      """;

            case 6 -> """
                       o
                      /|\\
                      / \\
                      """;

            default -> "";
        };
    }
}
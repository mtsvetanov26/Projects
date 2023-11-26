package GameInstantiation;

import Data.RandomWordGenerator;
import PrinterInstantiation.Printer;

import java.util.HashSet;

import java.util.Set;

import static GameInstantiation.Game.*;

public class GameLogic {
    private final String difficulty;
    private int lives;

    public GameLogic(String difficulty, int lives) {

        this.difficulty = difficulty;
        this.lives = lives;
        playGame();
    }

    private void playGame() {

        RandomWordGenerator randomWordGenerator = new RandomWordGenerator();
        String generatedWord = randomWordGenerator.randomWord(this.difficulty.toLowerCase());
        String dashedWord = returnDashes(generatedWord);
        Set<Character> usedCharacters = new HashSet<>();

        Printer.word(dashedWord);

        while (lives > 0) {
            char letterInput = correctLetter();

            usedCharacters.add(letterInput);

            if(!generatedWord.contains(letterInput + "")) {

                lives--;
                Printer.word(dashedWord);

                if(lives == 0) {
                    Printer.lossMSG(generatedWord);
                    break;
                }

                Printer.wrongLetter(lives);

            }else {

                dashedWord = modifiedWord(letterInput,dashedWord,generatedWord);
                Printer.word(dashedWord);


            }

            Printer.usedChars(usedCharacters);

            if(dashedWord.equals(generatedWord)) {
                stats.putSuccessfulAttempt(difficulty);
                Printer.winMSG();
                break;

            }
        }

        stats.putAttempt(difficulty);
        stats.updateSuccessRate(difficulty);
        occurrences.putOccurrence(generatedWord);
    }

    private String returnDashes(String word) {

        String replacementWord = "";

        for (int i = 0; i < word.length(); i++) {
            replacementWord = replacementWord.concat("_");
        }

        return replacementWord;
    }

    private String modifiedWord(char letterInput, String dashedWord, String generatedWord) {

        char[] dashedWordArr = dashedWord.toCharArray();

        for (int i = 0; i < dashedWordArr.length; i++) {
            if(generatedWord.charAt(i) == letterInput) {
                dashedWordArr[i] = letterInput;
            }
        }

        return new String(dashedWordArr);
    }

    private char correctLetter() {

        while (true) {

            try {

                char inputLetter = sc.nextLine().toLowerCase().charAt(0);

                if((int) inputLetter >= 97 && (int) inputLetter <= 122) {
                    return inputLetter;
                }

            }catch (StringIndexOutOfBoundsException ignored) {

            }

            Printer.inputError();
        }
    }
}

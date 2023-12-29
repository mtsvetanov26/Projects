package GameInstantiation;

import Data.DataInput;
import Data.WordGenerator;
import Occurances.OccurrenceNumber;
import PrinterInstantiation.Printer;
import Stats.Statistics;

import java.util.HashSet;
import java.util.Set;

import static GameInstantiation.Game.*;

public class GameLogic {
    private final String DIFFICULTY;
    private int lives;


    public GameLogic(String difficulty, int lives) {

        this.DIFFICULTY = difficulty;
        this.lives = lives;
        playGame();
    }

    private void playGame() {

        String generatedWord = WordGenerator.randomWord(DIFFICULTY.toLowerCase(),DataInput.getInstance());
        String dashedWord = WordGenerator.wordDashed(generatedWord);

        Set<Character> usedCharacters = new HashSet<>();

        Statistics stats = (Statistics) Loader.getInstance().getCurrentData(0);
        OccurrenceNumber occurances = (OccurrenceNumber) Loader.getInstance().getCurrentData(1);

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
                stats.putSuccessfulAttempt(DIFFICULTY);
                Printer.winMSG();
                break;

            }
        }

        stats.putAttempt(DIFFICULTY);
        stats.updateSuccessRate(DIFFICULTY);
        occurances.putOccurrence(generatedWord);
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

                char inputLetter = SC.nextLine().toLowerCase().charAt(0);

                if((int) inputLetter >= 97 && (int) inputLetter <= 122) {
                    return inputLetter;
                }

            }catch (StringIndexOutOfBoundsException ignored) {

            }

            Printer.inputError();
        }
    }
}

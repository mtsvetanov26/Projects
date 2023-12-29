package PrinterInstantiation;

import Data.DataInput;
import GameInstantiation.Loader;
import Interfaces.Selectable;
import Occurances.OccurrenceNumber;
import Stats.Statistics;

import java.io.*;
import java.util.*;



public class Printer{


    public static void errorMsg() {
        System.out.println("Invalid Selection ! Please select again.");
    }

    public static void menuOptions(List<Selectable> selectable) {
        for (int i = 0; i < selectable.size(); i++) {
            System.out.printf("%d.%s ",i + 1,selectable.get(i).getName());
        }
        System.out.printf("%d.Quit%n",selectable.size() + 1);
    }

    public static void difficultyOptions() {
        System.out.println("1.Easy 2.Medium 3.Hard 4.Back");
    }

    public static void word(String word) {
        System.out.println(word);
    }

    public static void customError(String error) {
        System.out.println(error);
    }

    public static void usedChars(Set<Character> usedLetters) {
        System.out.print("Used letters: ");
        usedLetters.stream().forEach(letters -> System.out.printf("%c, ",letters));
        System.out.println();
    }

    public static void winMSG() {
        System.out.println("Congratulations you got the word right !");
    }

    public static void lossMSG(String correctWord) {
        System.out.printf("Sorry you lost, the word you were searching for was - %s%n",correctWord);
    }

    public static void wrongLetter(int lives) {
        System.out.printf("Sorry there is no such character, lives left -  %d%n",lives);
    }

    public static void inputError() {
        System.out.println("Allowed input is only a number of the given options - No numbers, No symbols, No empty spaces, No enter key");
    }

    public static void onlyNumbersError() {
        System.out.println("You should use only from the listed numbers, also no use of LETTERS or WORDS");
    }

    public static void objectSaved(int currentLoader) {
        System.out.printf("%s have been saved...%n",Loader.getInstance().getCurrentData(currentLoader).getName());
    }

    public static void statsSuccessRate() {
        System.out.println("Success Rates:\n");
        Statistics statistics = (Statistics) Loader.getInstance().getCurrentData(0);

        statistics.getStats()
                .entrySet()
                .stream()

                .forEach(entry -> System.out.printf("Success rate for %s mode %.0f/%.0f %.2f%c %n",entry.getKey(),entry.getValue()[0],entry.getValue()[1],
                        entry.getValue()[2],'%'));
        double attempt = 0;
        double successfulAttempt = 0;

        for (var values:statistics.getStats().values()) {

            successfulAttempt += values[0];
            attempt += values[1];

        }
        if(attempt == 0) {
            System.out.println("No statistics yet!");
        }else {
            System.out.printf("Total Successful Attempts Percentage: %.0f/%.0f - %.2f%c %n", successfulAttempt, attempt, (successfulAttempt / attempt) * 100, '%');
        }

        System.out.println();
        System.out.println("1.Back 2.Reset Statistics 3.Save Statistics");
    }

    public static void occurrences() {

        System.out.println("Ranking for most frequent word:\n");

        OccurrenceNumber occNum = (OccurrenceNumber)Loader.getInstance().getCurrentData(1);
//        occNum.getOccurrences().entrySet().stream()
//                .sorted((e1,e2) -> Integer.compare(e2.getValue(),e1.getValue()));


        if(occNum.getOccurrences().entrySet().size() == 0) {
            System.out.println("No words added yet !");
        }

        occNum.getOccurrences().entrySet()
                .stream().forEach(elements -> System.out.printf("%s -> %d%n",elements.getKey(),elements.getValue()));

        System.out.println();
        System.out.printf("1.Back 2.Reset %s%n",occNum.getName());
    }

    public static void invalidFile() {
        System.out.println("No files to delete");
    }
    public static void reset(int currentLoader) {
        System.out.println(Loader.getInstance().getCurrentData(currentLoader).getName().concat(" successfully reset !"));
    }

    public static void wordsMenu() {
        System.out.println("1.View Words List 2.Add Words 3.Remove Words 4.Back");
    }

    public static void printWordsList() {

        try {
            File file = new File(System.getProperty("user.dir").concat("\\src\\main\\java\\words.txt"));
            BufferedReader bf = new BufferedReader(new FileReader(file));

            int wordsCounter = 0;
            String word = bf.readLine();

            while (word != null) {

                if(wordsCounter % 10 == 0) {
                    System.out.println();
                }

                System.out.print(word + " ");

                word = bf.readLine();
                wordsCounter++;
            }

            System.out.println(wordsCounter);
            System.out.println();
            bf.close();

        } catch (IOException fnfe) {
            fnfe.printStackTrace();

        }

    }

}

package PrinterInstantiation;

import Interfaces.Selectable;
import Stats.Statistics;

import java.util.List;
import java.util.Set;

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
        System.out.println("Allowed input is only a letter - No numbers, No symbols, No empty spaces, No enter key");
    }

    public static void onlyNumbersError() {
        System.out.println("You should use only from the listed numbers, also no use of LETTERS or WORDS");
    }

    public static void objectSaved() {
        System.out.println("Statistics have been saved...");
    }

    public static void statsSuccessRate(Statistics stats) {
        System.out.println("Success Rates:\n");

        stats.getStats()
                .entrySet()
                .stream()

                .forEach(entry -> System.out.printf("Success rate for %s mode %.0f/%.0f %.2f%c %n",entry.getKey(),entry.getValue()[0],entry.getValue()[1],
                        entry.getValue()[2],'%'));
        double attempt = 0;
        double successfulAttempt = 0;

        for (var values:stats.getStats().values()) {

            successfulAttempt += values[0];
            attempt += values[1];

        }

        System.out.printf("Total Successful Attempts Percentage: %.0f/%.0f - %.2f%c %n",successfulAttempt,attempt,(successfulAttempt / attempt) * 100,'%');
        System.out.println();
        System.out.println("1.Back 2.Reset Statistics 3.Save Statistics");
    }

    public static void invalidFile() {
        System.out.println("No files to delete");
    }
    public static void statsReset() {
        System.out.println("Statistics sucessfully reset !");
    }
}

package GameInstantiation;

import Interfaces.DataLoader;
import Occurances.OccurrenceNumber;
import PrinterInstantiation.Printer;
import Stats.Statistics;

import java.io.*;
import java.util.*;
@SuppressWarnings("unused")

public class Game {
    public static final Scanner sc = new Scanner(System.in);
    public static Statistics stats = new Statistics();
    public static OccurrenceNumber occurrences = new OccurrenceNumber();

    public Game() {

        loadData(stats);
        loadData(occurrences);

        MainMenu.main();
        sc.close();
        saveOccurances();

    }

    private void loadData(DataLoader dataLoader) {
        FileInputStream filePath;

            try {

                if (dataLoader.getFileName().equals("stats")) {
                    filePath = new FileInputStream("E:\\Programming\\Hangman\\src\\main\\java\\Stats\\stats_sav.ser");
                } else {
                    filePath = new FileInputStream("E:\\Programming\\Hangman\\src\\main\\java\\Occurances\\occ_sav.ser");
                }

                ObjectInputStream fileWriter = new ObjectInputStream(filePath);
                dataLoader = (DataLoader) fileWriter.readObject();

                filePath.close();
                fileWriter.close();

            } catch (IOException ioe) {

                Printer.customError("Invalid path or save was not created yet");

            } catch (ClassNotFoundException coe) {

                Printer.customError("No such class exists");
            }
    }

    private void saveOccurances() {

        try {
            FileOutputStream filePath = new FileOutputStream("E:\\Programming\\Hangman\\src\\main\\java\\Occurances\\occ_sav.ser");
            ObjectOutputStream file = new ObjectOutputStream(filePath);

            file.writeObject(occurrences);

            filePath.close();
            file.close();

        }catch (IOException ioe) {
            Printer.customError("Invalid path");
        }

    }

}

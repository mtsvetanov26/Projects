package Stats;

import Interfaces.Selectable;
import PrinterInstantiation.Printer;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static GameInstantiation.Game.sc;
import static GameInstantiation.Game.stats;


public class StatisticsMenu implements Selectable {

    @Override
    public void selectableSegments() {
        Printer.statsSuccessRate(stats);

        while (true) {
            char input = '\0';

            try {
                input = sc.nextLine().charAt(0);

            } catch (StringIndexOutOfBoundsException ignore) {

            }

            switch (input) {
                case '1':
                    return;

                case '2':
                    resetStats();
                    return;

                case '3':
                    saveStats();
                    return;

                default:
                    Printer.inputError();
            }


        }
    }

    @Override
    public String getName() {
        return "View Statistics";
    }

    private void resetStats() {
        boolean isValid = true;

        try {
            File file = new File("E:\\Programming\\Hangman\\src\\main\\java\\Stats\\stats_sav.ser");
            boolean isFileDeleted = file.delete();

        }catch (NullPointerException npe) {

            Printer.invalidFile();
            isValid = false;

        }

        if(isValid) {
            Printer.statsReset();
        }
    }

    private void saveStats() {

        try {
            FileOutputStream filePath = new FileOutputStream("E:\\Programming\\Hangman\\src\\main\\java\\Stats\\stats_sav.ser");
            ObjectOutputStream file = new ObjectOutputStream(filePath);

            file.writeObject(stats);

            filePath.close();
            file.close();

        }catch (IOException ioe) {
            Printer.customError("Invalid path");
        }finally {
            Printer.objectSaved();
        }

    }
}

package Data;

import GameInstantiation.Loader;
import Interfaces.DataLoader;
import PrinterInstantiation.Printer;

import java.io.*;

public class DataManager {

    public static void reset(int currentLoader) {
        boolean isValid = true;

        try {
            File file = new File(Loader.getInstance().getCurrentData(currentLoader).getFileName());
            boolean isFileDeleted = file.delete();


        }catch (NullPointerException npe) {

            Printer.invalidFile();
            isValid = false;

        }

        if(isValid) {
            Printer.reset(currentLoader);
        }
    }

    public static void load(Loader loader) {
        for (int i = 0; i < loader.getLoaderSize(); i++) {
            DataLoader dataLoader = loader.getCurrentData(i);

            File file = new File(dataLoader.getFileName());

            try {
                FileInputStream filePath = new FileInputStream(dataLoader.getFileName());

                if (file.exists()) {
                    ObjectInputStream fileWriter = new ObjectInputStream(filePath);
                    dataLoader = (DataLoader) fileWriter.readObject();

                    loader.setCurrentData(i,dataLoader);
                    fileWriter.close();

                }

                filePath.close();


            } catch (IOException ioe) {

                Printer.customError("Invalid path or save was not created yet");

            } catch (ClassNotFoundException coe) {

                Printer.customError("No such class exists");
            }
        }
    }

    public static void save(int currentLoader) {
        try {
            FileOutputStream filePath = new FileOutputStream(Loader.getInstance().getCurrentData(currentLoader).getFileName());
            ObjectOutputStream file = new ObjectOutputStream(filePath);

            file.writeObject(Loader.getInstance().getCurrentData(currentLoader));

            filePath.close();
            file.close();

        }catch (IOException ioe) {
            Printer.customError("Invalid path");
        }finally {
            Printer.objectSaved(currentLoader);
        }
    }
}

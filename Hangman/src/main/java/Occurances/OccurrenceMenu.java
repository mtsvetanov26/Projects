package Occurances;

import Data.DataManager;
import GameInstantiation.Loader;
import Interfaces.Selectable;
import PrinterInstantiation.Printer;

import static GameInstantiation.Game.SC;

public class OccurrenceMenu implements Selectable {


    @Override
    public void selectableSegments() {
        Printer.occurrences();
        while (true) {
            char input = '\0';

            try {
                input = SC.nextLine().charAt(0);

            } catch (StringIndexOutOfBoundsException ignore) {

            }

            switch (input) {
                case '1':

                    return;

                case '2':
                    DataManager.reset(1);
                    Loader.getInstance().setCurrentData(1, new OccurrenceNumber());
                    return;

                default:
                    Printer.inputError();
            }

        }
    }

    @Override
    public String getName() {
        return "Occurrences";
    }
}

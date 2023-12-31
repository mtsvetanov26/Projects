package Stats;

import Data.DataManager;
import GameInstantiation.Loader;
import Interfaces.Selectable;
import PrinterInstantiation.Printer;


import java.io.File;

import static GameInstantiation.Game.*;


public class StatisticsMenu implements Selectable {

    @Override
    public void selectableSegments() {
        Printer.statsSuccessRate();

        while (true) {
            char number = '\0';

            try {
                number = SC.nextLine().charAt(0);

            } catch (StringIndexOutOfBoundsException ignore) {

            }

            switch (number) {
                case '1':

                    return;

                case '2':
                    DataManager.reset(0);
                    Loader.getInstance().setCurrentData(0, new Statistics());
                    return;

                case '3':
                    DataManager.save(0);
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



}

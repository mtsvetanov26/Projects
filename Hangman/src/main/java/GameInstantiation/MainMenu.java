package GameInstantiation;

import Interfaces.Selectable;
import PrinterInstantiation.Printer;
import Stats.StatisticsMenu;

import java.util.List;

import static GameInstantiation.Game.sc;

public class MainMenu {
    private static List<Selectable> selectableOptions = List.of(
                                                        new DifficultySelectionLogic(),
                                                        new StatisticsMenu());


    static void main() {

        while (true) {

            Printer.menuOptions(selectableOptions);

            int optionNumber = getOptionNumber();

            if(optionNumber >= 1 && optionNumber <= selectableOptions.size()) {
                selectableOptions.get(optionNumber - 1).selectableSegments();

            }else if(optionNumber == selectableOptions.size() + 1) {
                break;
            }else {
                Printer.errorMsg();
            }

        }
    }

    private static int getOptionNumber() {


        while (true) {
            String input = sc.nextLine();

            try {
                return Integer.parseInt(input);
            }catch (IllegalArgumentException iae) {
                Printer.onlyNumbersError();
            }
        }
    }

}

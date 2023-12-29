package GameInstantiation;


import Interfaces.Selectable;
import PrinterInstantiation.Printer;


import static GameInstantiation.Game.SC;

public class WordsMenu implements Selectable {

    @Override
    public void selectableSegments() {


        while (true) {
            Printer.wordsMenu();
            char number = '\0';

            try {
                number = SC.nextLine().charAt(0);

            } catch (StringIndexOutOfBoundsException ignore) {

            }

            switch (number) {
                case '1':
                    Printer.printWordsList();
                    break;

                case '2':

                    return;

                case '3':

                    return;
                case '4':
                    return;

                default:
                    Printer.inputError();
            }
        }
    }

    @Override
    public String getName() {
        return "Words";
    }
}

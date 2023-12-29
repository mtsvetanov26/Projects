package GameInstantiation;

import Data.DataInput;
import Data.DataManager;

import java.util.*;
@SuppressWarnings("unused")

public class Game {
    public static final Scanner SC = new Scanner(System.in);
    private final Loader LOADER = Loader.getInstance();
    public final DataInput DATAINPUT = DataInput.getInstance();


    public Game() {

        DataManager.load(LOADER);
        MainMenu.main();
        SC.close();

        DataManager.save(1);

    }

}

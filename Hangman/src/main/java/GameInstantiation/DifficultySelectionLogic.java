package GameInstantiation;

import Interfaces.Selectable;
import PrinterInstantiation.Printer;


import static GameInstantiation.Game.sc;

public class DifficultySelectionLogic implements Selectable {

    @Override
    public void selectableSegments() {
        while (true) {

            Printer.difficultyOptions();
            String input = sc.nextLine();

            if(input.equals("1") || input.equals("2") || input.equals("3")) {
                String difficulty = getDifficultyInfo(input)[0];
                int lives = Integer.parseInt(getDifficultyInfo(input)[1]);

                GameLogic gameLogic = new GameLogic(difficulty,lives);

            }else if(input.equals("4")) {
                break;

            }else {
                Printer.errorMsg();
            }
        }
    }

    private String[] getDifficultyInfo(String difficulty) {
        String lives;
        String[] difficultyInfo = new String[2];

        switch (difficulty) {

            case "1":

                difficultyInfo[0] = "easy";
                difficultyInfo[1] = lives = String.valueOf(Difficulty.EASY.lives);
                break;

            case "2":
                difficultyInfo[0] = "medium";
                difficultyInfo[1] = lives = String.valueOf(Difficulty.MEDIUM.lives);
                break;

            case "3":
                difficultyInfo[0] = "hard";
                difficultyInfo[1] = lives = String.valueOf(Difficulty.HARD.lives);

        }

        return difficultyInfo;
    }

    @Override
    public String getName() {
        return "New game";
    }

}

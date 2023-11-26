package GameInstantiation;

public enum Difficulty {
    EASY(1,5),
    MEDIUM(2,7),
    HARD(3,8);

    final int levelDifficulty;
    final int lives;

    Difficulty(int levelDifficulty, int lives) {
        this.levelDifficulty = levelDifficulty;
        this.lives = lives;

    }




}

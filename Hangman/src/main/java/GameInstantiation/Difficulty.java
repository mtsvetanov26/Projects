package GameInstantiation;

public enum Difficulty {
    EASY(1,4),
    MEDIUM(2,5),
    HARD(3,6);

    final int levelDifficulty;
    final int lives;

    Difficulty(int levelDifficulty, int lives) {
        this.levelDifficulty = levelDifficulty;
        this.lives = lives;

    }




}

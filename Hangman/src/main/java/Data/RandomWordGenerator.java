package Data;

import java.util.Random;

public class RandomWordGenerator {
    private final DataInput dataInput;

    public RandomWordGenerator() {
        this.dataInput = new DataInput();
    }

    public String randomWord(String command) {
        String returnWord = "";
        Random random = new Random();
        var words = dataInput.getWordsMap();

        return returnWord = words.get(command).get(random.nextInt(words.get(command).size()));
    }

}

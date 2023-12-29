package Data;

import java.util.Random;

public class WordGenerator {


    public static String randomWord(String difficulty, DataInput dataInput) {

        Random random = new Random();
        var words = dataInput.getWordsMap();

        return words.get(difficulty).get(random.nextInt(words.get(difficulty).size()));
    }

    public static String wordDashed(String word) {

        String replacementWord = "";

        for (int i = 0; i < word.length(); i++) {
            replacementWord = replacementWord.concat("_");
        }

        return replacementWord;
    }

}

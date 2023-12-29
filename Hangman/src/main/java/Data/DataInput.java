package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataInput {
    private static DataInput dataInput;
    private final HashMap<String, List<String>> words = new HashMap<>();


    private DataInput() {
        createWordsMap();
    }

    public static DataInput getInstance() {
        if(dataInput == null) {
            dataInput = new DataInput();
        }
        return dataInput;
    }
    private void createWordsMap() {

        words.put("easy", new ArrayList<>());
        words.put("medium", new ArrayList<>());
        words.put("hard", new ArrayList<>());

        try {
            BufferedReader bf = new BufferedReader(new FileReader(System.getProperty("user.dir").concat("\\src\\main\\java\\words.txt")));
            String word = bf.readLine();

            while (word != null) {
                correctValue(word.toLowerCase());
                word = bf.readLine();
            }
            bf.close();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    private void correctValue(String input) {

        if(input.length() >= 3 && input.length() <= 4) {
            words.get("hard").add(input);
        }else if(input.length() >= 5 && input.length() <= 7) {
            words.get("medium").add(input);
        }else if(input.length() >= 8){
            words.get("easy").add(input);
        }
    }

    public HashMap<String, List<String>> getWordsMap() {
        return this.words;
    }

    public void addWords(String wordsInput) {
        String[]words = wordsInput.split(", ");

        for (int i = 0; i < words.length; i++) {
            if(isWordLegit(words[i].toLowerCase())) {

            }

        }
    }

    private boolean isWordLegit(String word) {
        boolean isLegit = false;

        for (int i = 0; i < word.length(); i++) {
            if((int)word.charAt(i) >= 97 && (int)word.charAt(i) <= 122) {
                isLegit = true;
            }else {
                return false;
            }
        }

        return isLegit;
    }


}

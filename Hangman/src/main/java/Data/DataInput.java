package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataInput {
    private HashMap<String, List<String>> words = new HashMap<>();


    public DataInput() {
        createWordsMap();
    }

    private void createWordsMap() {

        words.put("easy", new ArrayList<>());
        words.put("medium", new ArrayList<>());
        words.put("hard", new ArrayList<>());

        try {
            BufferedReader bf = new BufferedReader(new FileReader("E:\\Programming\\Hangman\\src\\main\\java\\words.txt"));
            while (bf.readLine() != null) {
                correctValue(bf.readLine().toLowerCase(Locale.ROOT));
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


}

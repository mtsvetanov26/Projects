package Occurances;

import Interfaces.DataLoader;
import java.util.HashMap;

public class OccurrenceNumber extends DataLoader {
    private final HashMap<String, Integer> numberOccurrences;


    public OccurrenceNumber() {
        super();
        this.numberOccurrences = new HashMap<>();

    }
    public void putOccurrence(String input) {

        if(!numberOccurrences.containsKey(input)) {
            numberOccurrences.put(input,1);
        }else {
            numberOccurrences.put(input, numberOccurrences.get(input) + 1);
        }
    }

    @Override
    protected String setFileName() {
        return "occ";
    }



}

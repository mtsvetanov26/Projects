package Occurances;

import Interfaces.DataLoader;
import java.util.HashMap;

public class OccurrenceNumber extends DataLoader {
    private final HashMap<String, Integer> NUMBER_OCCURENCES;
    private final String NAME = "Occurrences";

    public OccurrenceNumber() {
        super();
        this.NUMBER_OCCURENCES = new HashMap<>();

    }
    public void putOccurrence(String wordInput) {

        if(!NUMBER_OCCURENCES.containsKey(wordInput)) {
            NUMBER_OCCURENCES.put(wordInput,1);
        }else {
            NUMBER_OCCURENCES.put(wordInput, NUMBER_OCCURENCES.get(wordInput) + 1);
        }
    }

    public HashMap<String, Integer> getOccurrences() {
        return this.NUMBER_OCCURENCES;
    }

    @Override
    protected String setFileName() {
        return "occ_sav.ser";
    }

    @Override
    public String getName() {
        return this.NAME;
    }



}

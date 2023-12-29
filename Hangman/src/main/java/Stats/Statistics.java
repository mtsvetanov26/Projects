package Stats;


import Interfaces.DataLoader;
import java.util.LinkedHashMap;


public class Statistics extends DataLoader {
    private final LinkedHashMap<String, double[]> STATS;
    private final String NAME = "Statistics";
    public Statistics() {
        super();
        this.STATS = instantiateStats();

    }
    private LinkedHashMap<String, double[]>instantiateStats() {
        LinkedHashMap<String, double[] > statistics = new LinkedHashMap<>();


        statistics.put("easy", new double[]{0, 0, 0});
        statistics.put("medium",new double[]{0, 0, 0});
        statistics.put("hard", new double[]{0, 0, 0});


        return statistics;
    }

    public void putAttempt(String difficulty) {

        this.STATS.get(difficulty)[1]++;

    }

    public void putSuccessfulAttempt(String difficulty) {

        this.STATS.get(difficulty)[0]++;

    }

    public void updateSuccessRate(String difficulty) {
        double successfulAttempt = STATS.get(difficulty)[0];
        double attempt = STATS.get(difficulty)[1];

        STATS.get(difficulty)[2] = (successfulAttempt / attempt) * 100;
    }

    public LinkedHashMap<String, double[]> getStats() {
        return this.STATS;
    }


    @Override
    protected String setFileName() {
        return "stats_sav.ser";
    }

    @Override
    public String getName() {
        return this.NAME;
    }
}

package Stats;


import Interfaces.DataLoader;

import java.util.LinkedHashMap;


public class Statistics extends DataLoader {
    private final LinkedHashMap<String, double[]> stats;

    public Statistics() {
        super();
        this.stats = instantiateStats();

    }
    private LinkedHashMap<String, double[]>instantiateStats() {
        LinkedHashMap<String, double[] > statistics = new LinkedHashMap<>();


        statistics.put("easy", new double[]{0, 0, 0});
        statistics.put("medium",new double[]{0, 0, 0});
        statistics.put("hard", new double[]{0, 0, 0});



        return statistics;
    }

    public void putAttempt(String difficulty) {

        stats.get(difficulty)[1]++;

    }

    public void putSuccessfulAttempt(String difficulty) {

        stats.get(difficulty)[0]++;

    }

    public void updateSuccessRate(String difficulty) {
        double successfulAttempt = stats.get(difficulty)[0];
        double attempt = stats.get(difficulty)[1];

        stats.get(difficulty)[2] = (successfulAttempt / attempt) * 100;
    }

    public LinkedHashMap<String, double[]> getStats() {
        return this.stats;
    }


    @Override
    protected String setFileName() {
        return "stats";
    }
}

package GameInstantiation;

import Interfaces.DataLoader;
import Occurances.OccurrenceNumber;
import PrinterInstantiation.Printer;
import Stats.Statistics;

import java.util.ArrayList;
import java.util.List;

public class Loader {
    private static Loader loader;
    private List<DataLoader> dataLoaders = new ArrayList<>();

    private Loader() {
        instantiateData();
    }

    public static Loader getInstance() {
        if(loader == null) {
            loader = new Loader();
        }
        return loader;
    }


    public int getLoaderSize() {
        return this.dataLoaders.size();
    }

    public DataLoader getCurrentData(int currentLoader) {

        return this.dataLoaders.get(currentLoader);

    }
    public void setCurrentData(int currentLoader, DataLoader loader) {

        try {
            this.dataLoaders.set(currentLoader,loader);
        }catch (NullPointerException npe) {
            Printer.customError("No data to be loaded");
        }

    }

    private void instantiateData() {
        Statistics stats = new Statistics();
        OccurrenceNumber occurrenceNumber = new OccurrenceNumber();

        dataLoaders.add(stats);
        dataLoaders.add(occurrenceNumber);
    }

}

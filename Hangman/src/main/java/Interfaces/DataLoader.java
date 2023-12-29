package Interfaces;

import java.io.Serializable;

public abstract class DataLoader implements Serializable {
    private final String fileName;

    public DataLoader() {
        this.fileName = setFolderPath();
    }

    private String setFolderPath() {
        String firstPartPath = System.getProperty("user.dir");

        return firstPartPath.concat("\\src\\main\\java")
                .concat("\\".concat(this.getClass().getPackageName()
                        .concat("\\")).concat(setFileName()));
    }

    protected abstract String setFileName();
    public abstract String getName();

    public String getFileName() {
        return this.fileName;
    }



}

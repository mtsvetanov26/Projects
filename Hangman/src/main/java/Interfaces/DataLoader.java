package Interfaces;

import java.io.Serializable;

public abstract class DataLoader implements Serializable {
    private final String fileName;

    public DataLoader() {
        this.fileName = setFileName();
    }

    protected abstract String setFileName();

    public String getFileName() {
        return this.fileName;
    }





}

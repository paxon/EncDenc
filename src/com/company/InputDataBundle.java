package com.company;

public class InputDataBundle {
    private String pathToFile;
    private String fileContents;
    private int shiftkey;
    private int maxShiftKey;
    private boolean encrypt;


    public InputDataBundle(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getFileContents() {
        return fileContents;
    }

    public void setFileContents(String fileContents) {
        this.fileContents = fileContents;
    }

    public int getShiftkey() {
        return shiftkey;
    }

    public void setShiftkey(int shiftkey) {
        this.shiftkey = shiftkey;
    }

    public int getMaxShiftKey() {
        return maxShiftKey;
    }

    public void setMaxShiftKey(int maxShiftKey) {
        this.maxShiftKey = maxShiftKey;
    }
}

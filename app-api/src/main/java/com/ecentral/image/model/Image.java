package com.ecentral.image.model;

import java.awt.*;
import java.io.File;

public class Image {
    private File file;
    private String filename;
    private String filePath;

    public Image() {
    }



    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Image{" +
                "file=" + file +
                ", filename='" + filename + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

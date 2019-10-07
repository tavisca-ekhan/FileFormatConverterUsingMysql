package com.ebran.api.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler {

    private String path;
    private String fileType;
    private File file;

    public FileHandler(String path, String fileType) {
        this.path = path;
        this.fileType = fileType;
    }

    public boolean createNewFile() throws IOException {
        File targetFolder = new File(this.path);

        if (!targetFolder.exists()) targetFolder.mkdirs();

        String newFileName = generateUniqueNameForFile() + "." + this.fileType;
        this.file = new File(targetFolder, newFileName);

        return this.file.createNewFile();
    }

    public void writeToFile(String data) {
        if (this.file.exists()) {
            try (FileWriter writer = new FileWriter(this.file)) {
                writer.write(data.toCharArray());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateUniqueNameForFile() {
        SimpleDateFormat targetFormat = new SimpleDateFormat("ddHHmmss");
        return targetFormat.format(new Date());
    }

    public String getFullPathOfTheNewCreatedFile(){
        return  this.file.getAbsolutePath();
    }
}

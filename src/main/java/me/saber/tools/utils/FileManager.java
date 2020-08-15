package me.saber.tools.utils;


import me.saber.tools.SaberTools;

import java.io.*;

public class FileManager {

    private CustomFile config = new CustomFile(new File(SaberTools.getInstance().getDataFolder() + "/config.yml"));
    private CustomFile messages = new CustomFile(new File(SaberTools.getInstance().getDataFolder() + "/messages.yml"));


    public void setup() {
        config.setup(true, "");
        messages.setup(true, "");
    }


    public void copyFile(File sourceFile, File destinationFile) {
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
            File afile = sourceFile;
            File bfile = destinationFile;
            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);
            byte[] buffer = new byte[1024];
            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            inStream.close();
            outStream.close();
            //delete the original file
            afile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CustomFile getConfig() {
        return config;
    }

    public CustomFile getMessages() {
        return messages;
    }
}
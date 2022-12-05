package com.kerrrusha.util;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.apache.log4j.LogManager.getLogger;

public class FileUtil {

    private static final Logger logger = getLogger(FileUtil.class);

    public static void writeToFile(String filename, String data) {
        File file = new File(filename);
        createIfNotExists(file);
        try (FileOutputStream oFile = new FileOutputStream(file, false)) {
            oFile.write(data.getBytes());
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    private static void createIfNotExists(File file) {
        try {
            logger.debug("File "+file.getName()+" was created - " + file.createNewFile());
        } catch (IOException e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }
}

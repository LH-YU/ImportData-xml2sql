package com.importData.xml2sql.Tools;

import java.io.File;
import java.io.FileOutputStream;

public class MyTools {
    public boolean writeStringToFile(String fileName, String content, boolean append) {
        File writefile = new File(fileName);
        String newline = "\r\n";
        try {
            if (!writefile.exists()) {
                writefile.createNewFile();
                writefile = new File(fileName);
            }
            FileOutputStream fw = new FileOutputStream(writefile, append);
            fw.write(content.getBytes());
            fw.write(newline.getBytes());
            fw.flush();
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public String  inputFileName(String inFileName) {
        String nowpath = System.getProperty("user.dir");
        System.out.println(nowpath);
        String inputFileName = String.valueOf(nowpath) + "/"+ inFileName;
        return inputFileName;
    }

    public String outputFileName(String inFileName) {
        String nowpath = System.getProperty("user.dir");
        String outFileName = outFileName(inFileName);
        String outputFileName = String.valueOf(nowpath) + "/CNAPSBaseData/" + outFileName;
        return outputFileName;
    }

    public String outFileName(String inFileName) {
        String outFileName = String.valueOf(inFileName.split("\\.")[0]) + ".sql";
        return outFileName;
    }

    public String outputFileNameCSV(String inFileName) {
        String nowpath = System.getProperty("user.dir");
        String outFileNameCSV = outFileNameCSV(inFileName);
        String outputFileNameCSV = String.valueOf(nowpath) + "/CNAPSBaseData/" + outFileNameCSV;
        return outputFileNameCSV;
    }

    public String outFileNameCSV(String inFileName) {
        String outFileNameCSV = String.valueOf(inFileName.split("\\.")[0]) + ".csv";
        return outFileNameCSV;
    }
}


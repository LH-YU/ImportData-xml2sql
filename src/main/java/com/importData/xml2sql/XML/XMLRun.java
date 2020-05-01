package com.importData.xml2sql.XML;

public class XMLRun {

    public static void main(String[] args) {
        CCMSZDT0301 cc0301 = new CCMSZDT0301();
        CCMSZDT0401 cc0401 = new CCMSZDT0401();
        CCMSZDT0414 cc0414 = new CCMSZDT0414();
        CCMSZDT0417 cc0417 = new CCMSZDT0417();
        CCMSZDT0437 cc0437 = new CCMSZDT0437();
        cc0301.readXmlToSQL();
        cc0401.readXmlToSQL();
        cc0414.readXmlToSQL();
        cc0417.readXmlToSQL();
        cc0437.readXmlToSQL();
    }

}

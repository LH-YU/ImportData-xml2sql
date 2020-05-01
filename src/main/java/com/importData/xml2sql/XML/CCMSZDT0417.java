package com.importData.xml2sql.XML;

import com.importData.xml2sql.Tools.MyTools;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.util.List;

public class CCMSZDT0417 {
    public void readXmlToSQL() {
        MyTools myTools = new MyTools();
        String inFileName = "CCMSZDT0417.xml";
        String inputFileName = myTools.inputFileName(inFileName);
        String outputFileName = myTools.outputFileName(inFileName);
        String content = "";
        boolean append = true;
        try {
            SAXReader saxb = new SAXReader();
            Document doc = saxb.read(new FileInputStream(inputFileName));
            Element root = doc.getRootElement();

            String msgid = "";
            String credttm = "";
            String bankcode = "";
            String  rigstflg= "";
            String  sndbizauth= "";
            String  rcvbizauth= "";

            Element elms = null;
            List<Element> list0 = root.elements();
            Element root2 = list0.get(0);
            List<Element> list1 = root2.elements();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list1.size(); i++) {
                elms = list1.get(i);
                int elmlength = elms.elements().size();
                if (elmlength >= 2) {
                    bankcode= elms.elementText("SYSCODE");
                    sndbizauth = elms.elementText("SENDBANK");
                    rcvbizauth = elms.elementText("RECVBANK");
                    msgid= elms.elementText("MSGTYPE");
                    credttm = elms.elementText("");

                    sb.append("delete from ccm_rigst where bankcode = '" + bankcode + "' and rcvbizauth = '" + rcvbizauth + "' and sndbizauth = '" + sndbizauth + "';");
                    content = sb.toString();
                    myTools.writeStringToFile(outputFileName, content, append);
                    sb.delete(0, sb.length());
                    sb.append("INSERT INTO ccm_rigst (msgid, credttm, bankcode, rigstflg, sndbizauth, rcvbizauth) VALUES ('" +
                            msgid + "','" + credttm + "','" + bankcode + "','" + rigstflg + "','" + sndbizauth + "','" + rcvbizauth+ "');");
                    content = sb.toString();
                    myTools.writeStringToFile(outputFileName, content, append);
                    sb.delete(0, sb.length());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



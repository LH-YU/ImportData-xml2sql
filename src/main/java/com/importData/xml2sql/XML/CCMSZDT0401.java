package com.importData.xml2sql.XML;

import com.importData.xml2sql.Tools.MyTools;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.util.List;

public class CCMSZDT0401 {
    public void readXmlToSQL() {
        MyTools myTools = new MyTools();
        String inFileName = "CCMSZDT0401.xml";
        String inputFileName = myTools.inputFileName(inFileName);
        String outputFileName = myTools.outputFileName(inFileName);
        String content = "";
        boolean append = true;
        try {
            SAXReader saxb = new SAXReader();
            Document doc = saxb.read(new FileInputStream(inputFileName));
            Element root = doc.getRootElement();
            String bankcode       = "";
            String bankname       = "";
            String ptcpttp        = "";
            String bkctgycd       = "";
            String altrntyp       = "";
            String fctvtp         = "";
            String fctvdt         = "";
            String ifvctdt        = "";
            String drctbkcd       = "";
            String lglprsn        = "";
            String hghptcpt       = "";
            String hghptcpt1     = "";
            String agtbkcd        = "";
            String chrgbkcd       = "";
            String ndcd           = "";
            String citycd         = "";
            String ptcptshrtnm    = "";
            String sgn            = "";
            String adr            = "";
            String postcd         = "";
            String tel            = "";
            String email          = "";
            String remark         = "";

            Element elms = null;
            List<Element> list0 = root.elements();
            Element root2 = list0.get(0);
            List<Element> list1 = root2.elements();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < list1.size(); i++) {
                elms = list1.get(i);
                int elmlength = elms.elements().size();
                if (elmlength >= 2) {

                    bankcode = elms.elementText("BANKCODE");
                    bankname = elms.elementText("BANKNAME");
                    ptcpttp = elms.elementText("BANKCATALOG");
                    bkctgycd = elms.elementText("DRECCODE");
                    if (elms.elementText("PBCCODE") == null) {
                        chrgbkcd = "";
                    } else {
                        chrgbkcd = elms.elementText("PBCCODE");
                    }
                    tel = elms.elementText("TEL");
                    ndcd = elms.elementText("CCPC");
                    fctvdt = elms.elementText("EFFECTDATE");
                    ifvctdt = elms.elementText("EXPDATE");
                    sgn = elms.elementText("SYSCODE");
                    citycd = elms.elementText("DEBTORCITY");
                    agtbkcd = elms.elementText("SBSTITNBK");
                    hghptcpt = elms.elementText("SUPRLIST");
                    hghptcpt1 = hghptcpt.replace(",", "|");
                    lglprsn = elms.elementText("AGENTSETTBANK");
                    altrntyp = elms.elementText("BANKTYPE");

                    sb.append("delete from ccm_bankdata where bankcode = '" + bankcode + "';");
                    content = sb.toString();
                    myTools.writeStringToFile(outputFileName, content, append);
                    sb.delete(0, sb.length());
                    sb.append("insert into ccm_bankdata (bankcode,bankname,ptcpttp,bkctgycd,altrntyp,fctvtp,fctvdt,ifvctdt,drctbkcd,lglprsn,hghptcpt,agtbkcd,chrgbkcd,ndcd,citycd,ptcptshrtnm,sgn,adr,postcd,tel,email,remark   ) values ('" +
                            bankcode + "','" + bankname + "','" + ptcpttp + "','" + bkctgycd + "','" + altrntyp + "','" + fctvtp + "','" + fctvdt + "','" + ifvctdt + "','" + drctbkcd + "','" + lglprsn + "','" + hghptcpt1 + "','" + agtbkcd + "','" + chrgbkcd + "','" + ndcd+ "','" + citycd + "','" + ptcptshrtnm + "','" + sgn + "','" + adr + "','" + postcd  + "','" + tel  + "','" + email  + "','" + remark  + "');");
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


package main;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.docx.preprocessor.sax.DocxPreprocessor;

import java.io.*;

public class CreatePreprocessedXml {
    public static void main(String[] args) {
        try {
            DocxPreprocessor preprocessor = new DocxPreprocessor();
            InputStream stream = new FileInputStream(new File("document.xml"));
            StringWriter stringWriter = new StringWriter();
            preprocessor.preprocess("test", stream, stringWriter, null, null, null);

            FileWriter fileWriter = new FileWriter("document_after_preprocessing (plain).xml");
            fileWriter.write(stringWriter.toString());
            fileWriter.close();
        }
        catch (XDocReportException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

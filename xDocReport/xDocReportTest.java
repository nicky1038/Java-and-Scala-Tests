package main;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class xDocReportTest {
    public static void main(String[] args) {
        try {
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(new FileInputStream(new File("Template.docx")), TemplateEngineKind.Velocity);
            IContext docxMappings = report.createContext();
            FieldsMetadata fieldsMetadata = new FieldsMetadata();

            docxMappings.put("someCondition", true);

            docxMappings.put("beans", new ArrayList<MyBean>() {{
                add(new MyBean("Element1", "aa", "bb", "cc", 35, 65, 87, "-", "dd", "ee", "ff", "gg", "hh", 93, 23, "ii", "jj", "kk"));
                add(new MyBean("Element2", "ll", "mm", "nn", 43, 33, 21, "=", "oo", "pp", "qq", "rr", "ss", 82, 32, "tt", "uu", "vv"));
                add(new MyBean("Element3", "ww", "xx", "yy", 87, 54, 12, "_", "zz", "a1", "a2", "a3", "a4", 72, 44, "a5", "a6", "a7"));
                add(new MyBean("Element4", "a8", "a9", "b1", 90, 29, 47, "/", "b2", "b3", "b4", "b5", "b6", 33, 51, "b7", "b8", "b9"));
                add(new MyBean("Element5", "c1", "c2", "c3", 32, 83, 89, "c4", "c5", "c6", "c7", "c8",  "*", 92, 65, "c9", "d1", "d2"));
                add(new MyBean("Element6", "d3", "d4", "d5", 77, 92, 33, "d6", "d7", "d8", "d9", "e1",  "#", 22, 54, "e2", "e3", "e4"));
            }});

            fieldsMetadata.addFieldAsList("beans.variableOne");
            fieldsMetadata.addFieldAsList("beans.variableTwo");
            fieldsMetadata.addFieldAsList("beans.variableThree");
            fieldsMetadata.addFieldAsList("beans.variableFour");
            fieldsMetadata.addFieldAsList("beans.variableFive");
            fieldsMetadata.addFieldAsList("beans.variableSix");
            fieldsMetadata.addFieldAsList("beans.variableSeven");
            fieldsMetadata.addFieldAsList("beans.variableEight");
            fieldsMetadata.addFieldAsList("beans.variableNine");
            fieldsMetadata.addFieldAsList("beans.variableTen");
            fieldsMetadata.addFieldAsList("beans.variableEleven");
            fieldsMetadata.addFieldAsList("beans.variableTwelve");
            fieldsMetadata.addFieldAsList("beans.variableThirteen");
            fieldsMetadata.addFieldAsList("beans.variableFourteen");
            fieldsMetadata.addFieldAsList("beans.variableFifteen");
            fieldsMetadata.addFieldAsList("beans.variableSixteen");
            fieldsMetadata.addFieldAsList("beans.variableSeventeen");
            fieldsMetadata.addFieldAsList("beans.variableEighteen");

            docxMappings.put("print", new ArrayList<Print>() {{
                add(new Print(true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true));
            }});

            fieldsMetadata.addFieldAsList("print.variableOne");
            fieldsMetadata.addFieldAsList("print.variableTwo");
            fieldsMetadata.addFieldAsList("print.variableThree");
            fieldsMetadata.addFieldAsList("print.variableFour");
            fieldsMetadata.addFieldAsList("print.variableFive");
            fieldsMetadata.addFieldAsList("print.variableSix");
            fieldsMetadata.addFieldAsList("print.variableSeven");
            fieldsMetadata.addFieldAsList("print.variableEight");
            fieldsMetadata.addFieldAsList("print.variableNine");
            fieldsMetadata.addFieldAsList("print.variableTen");
            fieldsMetadata.addFieldAsList("print.variableEleven");
            fieldsMetadata.addFieldAsList("print.variableTwelve");
            fieldsMetadata.addFieldAsList("print.variableThirteen");
            fieldsMetadata.addFieldAsList("print.variableFourteen");
            fieldsMetadata.addFieldAsList("print.variableFifteen");
            fieldsMetadata.addFieldAsList("print.variableSixteen");
            fieldsMetadata.addFieldAsList("print.variableSeventeen");
            fieldsMetadata.addFieldAsList("print.variableEighteen");

            report.setFieldsMetadata(fieldsMetadata);

            OutputStream outputStream = new FileOutputStream(new File(String.format("Output %d.docx", (new Random()).nextInt())));
            report.process(docxMappings, outputStream);
        }
        catch ( XDocReportException e )
        {
            e.printStackTrace();
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
    }
}
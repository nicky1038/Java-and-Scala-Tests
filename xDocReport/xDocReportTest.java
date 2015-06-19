import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

class MyBean
{
    public String variableOne;
    public Integer variableTwo;
    public String variableThree;

    MyBean(String varOne, Integer varTwo, String varThree)
    {
        variableOne = varOne;
        variableTwo = varTwo;
        variableThree = varThree;
    }

    public String getVariableOne() { return variableOne; }
    public void setVariableOne(String varOne) { variableOne = varOne; }

    public Integer getVariableTwo() { return variableTwo; }
    public void setVariableTwo(Integer varTwo) { variableTwo = varTwo; }

    public String getVariableThree() { return variableThree; }
    public void setVariableThree(String varThree) { variableThree = varThree; }
}

class Print
{
    public Boolean variableOne;
    public Boolean variableTwo;
    public Boolean variableThree;

    Print(Boolean varOne, Boolean varTwo, Boolean varThree)
    {
        variableOne = varOne;
        variableTwo = varTwo;
        variableThree = varThree;
    }

    public Boolean getVariableOne() { return variableOne; }
    public void setVariableOne(Boolean varOne) { variableOne = varOne; }

    public Boolean getVariableTwo() { return variableTwo; }
    public void setVariableTwo(Boolean varTwo) { variableTwo = varTwo; }

    public Boolean getVariableThree() { return variableThree; }
    public void setVariableThree(Boolean varThree) { variableThree = varThree; }
}

public class xDocReportTest {
    public static void Main() {
        try {
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(new FileInputStream(new File("TestTemplate.docx")), TemplateEngineKind.Velocity);
            IContext docxMappings = report.createContext();
            FieldsMetadata fieldsMetadata = new FieldsMetadata();


            docxMappings.put("justBean", new ArrayList<MyBean>() {{
                add(new MyBean("JustVar", 100, "+"));
            }});
            fieldsMetadata.addFieldAsList("justBean.variableOne");
            fieldsMetadata.addFieldAsList("justBean.variableTwo");

            docxMappings.put("someCondition", true);

            docxMappings.put("tableBeans", new ArrayList<MyBean>() {{
                add(new MyBean("Var1", 35, "-"));
                add(new MyBean("Var2", 43, "="));
                add(new MyBean("Var3", 87, "_"));
                add(new MyBean("Var4", 90, "/"));
                add(new MyBean("Var5", 32, "*"));
                add(new MyBean("Var6", 77, "#"));
            }});

            fieldsMetadata.addFieldAsList("tableBeans.variableOne");
            fieldsMetadata.addFieldAsList("tableBeans.variableTwo");
            fieldsMetadata.addFieldAsList("tableBeans.variableThree");

            docxMappings.put("print", new ArrayList<Print>() {{
                add(new Print(true, true, true));
            }});

            fieldsMetadata.addFieldAsList("print.variableOne");
            fieldsMetadata.addFieldAsList("print.variableTwo");

            report.setFieldsMetadata(fieldsMetadata);

            OutputStream outputStream = new FileOutputStream(new File(String.format("Output {0}.docx", (new Random()).nextInt())));
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
package reports

import java.io.{File, FileOutputStream}
import java.util

import fr.opensagres.xdocreport.document.registry.XDocReportRegistry
import fr.opensagres.xdocreport.template.TemplateEngineKind
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata

import scala.reflect.io.Path
import scala.util.Random

object xDocReportTest extends App {
    class MyBean(var variableOne: String,
                 var variableTwo: Int,
                 var variableThree: String) {
      def getVariableOne: String = variableOne

      def setVariableOne(variableOne: String): Unit = this.variableOne = variableOne

      def getVariableTwo: Int = variableTwo

      def setVariableTwo(variableTwo: Int): Unit = this.variableTwo = variableTwo

      def getVariableThree: String = variableThree

      def setVariableThree(variableThree: String): Unit = this.variableThree = variableThree
    }

    class Print(var variableOne: Boolean,
                var variableTwo: Boolean,
                var variableThree: Boolean) {
      def getVariableOne: Boolean = variableOne

      def setVariableOne(variableOne: Boolean): Unit = this.variableOne = variableOne

      def getVariableTwo: Boolean = variableTwo

      def setVariableTwo(variableTwo: Boolean): Unit = this.variableTwo = variableTwo

      def getVariableThree: Boolean = variableThree

      def setVariableThree(variableThree: Boolean): Unit = this.variableThree = variableThree
    }

    val report = XDocReportRegistry.getRegistry.loadReport(Path("TestTemplate.docx").toFile.inputStream(), TemplateEngineKind.Velocity)
    val docxMappings = report.createContext
    val fieldsMetadata = new FieldsMetadata()

    docxMappings.put("justBean", new util.ArrayList[MyBean]() {
      add(new MyBean("JustVar", 100, "+"))
    })
    fieldsMetadata.addFieldAsList("justBean.variableOne")
    fieldsMetadata.addFieldAsList("justBean.variableTwo")
    fieldsMetadata.addFieldAsList("justBean.variableThree")

    docxMappings.put("someCondition", true)

    docxMappings.put("tableBeans", new util.ArrayList[MyBean]() {
      add(new MyBean("Var1", 35, "-"))
      add(new MyBean("Var2", 43, "="))
      add(new MyBean("Var3", 87, "_"))
      add(new MyBean("Var4", 90, "/"))
      add(new MyBean("Var5", 32, "*"))
      add(new MyBean("Var6", 77, "#"))
    })

    fieldsMetadata.addFieldAsList("tableBeans.variableOne")
    fieldsMetadata.addFieldAsList("tableBeans.variableTwo")
    fieldsMetadata.addFieldAsList("tableBeans.variableThree")

    docxMappings.put("print", new util.ArrayList[Print]() {
      add(new Print(true, true, true))
    })

    fieldsMetadata.addFieldAsList("print.variableOne")
    fieldsMetadata.addFieldAsList("print.variableTwo")

    report.setFieldsMetadata(fieldsMetadata)

    val outputStream = new FileOutputStream(new File(s"Output ${Random.nextInt()}.docx"))
    report.process(docxMappings, outputStream)
}
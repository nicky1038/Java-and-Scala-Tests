import java.io.StringWriter

import fr.opensagres.xdocreport.core.io.IOUtils
import fr.opensagres.xdocreport.document.docx.preprocessor.sax.DocxPreprocessor

object DocxPreprocessorWithSplittedBeforeCellMergefield extends App {
      val preprocessor = new DocxPreprocessor()
      val stream = IOUtils.toInputStream((
        "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
          "<w:document" +
          " xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\"" +
          " xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\"" +
          " xmlns:o=\"urn:schemas-microsoft-com:office:office\"" +
          " xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"" +
          " xmlns:v=\"urn:schemas-microsoft-com:vml\"" +
          " xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\"" +
          " xmlns:w10=\"urn:schemas-microsoft-com:office:word\"" +
          " xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\"" +
          " xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\"" +
          " xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\"" +
          " xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\"" +
          " xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\"" +
          " xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\"" +
          " xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\"" +
          " xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\" mc:Ignorable=\"w14 wp14\">" +

          "<w:tbl>" +
            "<w:tr>" +
              "<w:tc>" +
                "<w:tcPr>" +
                  "<w:tcW w:w=\"2916\" w:type=\"dxa\" />" +
                "</w:tcPr>" +
                "<w:p>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:fldChar w:fldCharType=\"begin\" />" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:instrText xml:space=\"preserve\"> </w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:instrText>MERGEFIELD</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:instrText xml:space=\"preserve\">  @</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:instrText>before</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:instrText>-</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:instrText>cell</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:instrText>#</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                    "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:instrText>if</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:instrText>($</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:instrText>print</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:instrText>.</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                     "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:instrText>variableThree</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:instrText xml:space=\"preserve\">)  \\* </w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:instrText>MERGEFORMAT</w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:instrText xml:space=\"preserve\"> </w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:fldChar w:fldCharType=\"separate\" />" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                    "</w:rPr>" +
                    "<w:t>«@</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                    "<w:noProof />"
                ) + (
                    "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:t>before</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                    "</w:rPr>" +
                    "<w:t>-</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:t>cell</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                    "</w:rPr>" +
                    "<w:t>#</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:t>if</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                    "</w:rPr>" +
                    "<w:t>($</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:t>print</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>\n" +
                      "<w:noProof />" +
                    "</w:rPr>" +
                    "<w:t>.</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:t>variableThree</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                      "</w:rPr>" +
                    "<w:t>)»</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:fldChar w:fldCharType=\"end\" />" +
                  "</w:r>" +
                "</w:p>" +
                "<w:p>" +
                  "<w:pPr>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                  "</w:pPr>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                    "<w:t>Variable 3</w:t>" +
                  "</w:r>" +
                "</w:p>" +
                "<w:p>" +
                  "<w:pPr>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                  "</w:pPr>" +
                  "<w:r>" +
                    "<w:fldChar w:fldCharType=\"begin\" />" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:instrText xml:space=\"preserve\"> MERGEFIELD  @after-cell#end  \\* MERGEFORMAT </w:instrText>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:fldChar w:fldCharType=\"separate\" />" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                    "</w:rPr>" +
                    "<w:t>«@after-c</w:t>" +
                  "</w:r>" +
                  "<w:bookmarkStart w:id=\"0\" w:name=\"_GoBack\" />" +
                  "<w:bookmarkEnd w:id=\"0\" />" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                    "</w:rPr>" +
                    "<w:t>ell#end»</w:t>" +
                  "</w:r>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:noProof />" +
                    "</w:rPr>" +
                    "<w:fldChar w:fldCharType=\"end\" />" +
                  "</w:r>" +
                "</w:p>" +
                "<w:p>" +
                  "<w:pPr>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\" />" +
                    "</w:rPr>" +
                  "</w:pPr>" +
                "</w:p>" +
              "</w:tc>" +
            "</w:tr>" +
          "</w:tbl>" +
        "</w:document>"), "UTF-8")

      val writer = new StringWriter()
      preprocessor.preprocess( "test", stream, writer, null, null, null )

      assert( "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
        "<w:document" +
        " xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\"" +
        " xmlns:mc=\"http://schemas.openxmlformats.org/markup-compatibility/2006\"" +
        " xmlns:o=\"urn:schemas-microsoft-com:office:office\"" +
        " xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"" +
        " xmlns:v=\"urn:schemas-microsoft-com:vml\"" +
        " xmlns:w=\"http://schemas.openxmlformats.org/wordprocessingml/2006/main\"" +
        " xmlns:w10=\"urn:schemas-microsoft-com:office:word\"" +
        " xmlns:w14=\"http://schemas.microsoft.com/office/word/2010/wordml\"" +
        " xmlns:wne=\"http://schemas.microsoft.com/office/word/2006/wordml\"" +
        " xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\"" +
        " xmlns:wp14=\"http://schemas.microsoft.com/office/word/2010/wordprocessingDrawing\"" +
        " xmlns:wpc=\"http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas\"" +
        " xmlns:wpg=\"http://schemas.microsoft.com/office/word/2010/wordprocessingGroup\"" +
        " xmlns:wpi=\"http://schemas.microsoft.com/office/word/2010/wordprocessingInk\"" +
        " xmlns:wps=\"http://schemas.microsoft.com/office/word/2010/wordprocessingShape\" mc:Ignorable=\"w14 wp14\">" +
        "<w:tbl>" +
          "<w:tr>" +
            "#if($print.variableThree)" +
              "<w:tc>" +
                "<w:tcPr>" +
                  "<w:tcW w:w=\"2916\" w:type=\"dxa\"/>" +
                "</w:tcPr>" +
                "<w:p>" +
                "</w:p>" +
                "<w:p>" +
                  "<w:pPr>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\"/>" +
                    "</w:rPr>" +
                  "</w:pPr>" +
                  "<w:r>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\"/>" +
                    "</w:rPr>" +
                    "<w:t>Variable 3</w:t>" +
                  "</w:r>" +
                "</w:p>" +
                "<w:p>" +
                  "<w:pPr>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\"/>" +
                    "</w:rPr>" +
                  "</w:pPr>" +
                  "<w:bookmarkStart w:id=\"0\" w:name=\"_GoBack\"/>" +
                  "<w:bookmarkEnd w:id=\"0\"/>" +
                "</w:p>" +
                "<w:p>" +
                  "<w:pPr>" +
                    "<w:rPr>" +
                      "<w:lang w:val=\"en-US\"/>" +
                    "</w:rPr>" +
                  "</w:pPr>" +
                "</w:p>" +
              "</w:tc>" +
            "#end" +
            "</w:tr>" +
        "</w:tbl>" +
        "</w:document>" == writer.toString )
}
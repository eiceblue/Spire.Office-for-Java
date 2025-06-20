import com.spire.doc.*;

public class checkFileFormat {
    public static void main(String[] args) {

        String input = "data/Template.docx";

        //Create a document
        Document doc = new Document();

        //Load from disk
        doc.loadFromFile(input);

        //Get the file format
        FileFormat ff = doc.getDetectedFormatType();
        String fileFormat ="The file format is ";

        //Check the format info
        switch (ff) {
            case Doc:
                fileFormat += "Microsoft Word 97-2003 document.";
                break;
            case Dot:
                fileFormat += "Microsoft Word 97-2003 template.";
                break;
            case Docx:
                fileFormat += "Office Open XML WordprocessingML Macro-Free Document.";
                break;
            case Docm:
                fileFormat += "Office Open XML WordprocessingML Macro-Enabled Document.";
                break;
            case Dotx:
                fileFormat += "Office Open XML WordprocessingML Macro-Free Template.";
                break;
            case Dotm:
                fileFormat += "Office Open XML WordprocessingML Macro-Enabled Template.";
                break;
            case Rtf:
                fileFormat += "RTF format.";
                break;
            case Word_ML:
                fileFormat += "Microsoft Word 2003 WordprocessingML format.";
                break;
            case Html:
                fileFormat += "HTML format.";
                break;
            case Word_Xml:
                fileFormat += "Microsoft Word xml format for word 2007-2013.";
                break;
            case Odt:
                fileFormat += "OpenDocument Text.";
                break;
            case Ott:
                fileFormat += "OpenDocument Text Template.";
                break;
            case Doc_Pre_97:
                fileFormat += "Microsoft Word 6 or Word 95 format.";
                break;
            default:
                fileFormat +="Unknown format.";
                break;
        }

        //Print the file format
        System.out.println(fileFormat);

        //Dispose the document
        doc.dispose();
    }
}

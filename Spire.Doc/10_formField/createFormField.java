import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.awt.*;
import java.io.*;

public class createFormField {
    private static DocumentBuilder documentBuilder = null;
    private static DocumentBuilderFactory documentBuilderFactory = null;
    private static org.w3c.dom.Document xmlDocument = null;

    static {
        try {
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static  String inputXml="data/form.xml";
    static  String inputFooter="data/footer.png";
    static  String inputHeader="data/header.png";
    public static void main(String[] args) throws Exception {
        String output="output/createFormField.doc";
        //create Word document.
        com.spire.doc.Document document = new  com.spire.doc.Document();
        Section section = document.addSection();

        //page setup.
        setPage(section);

        //insert header and footer.
        insertHeaderAndFooter(section);

        //add title.
        addTitle(section);

        //add form.
        addForm(section);

        //save doc file.
        document.saveToFile(output, FileFormat.Doc);
    }

    private static void setPage(Section section) {
        //the unit of all measures below is point, 1point = 0.3528 mm
        section.getPageSetup().setPageSize(PageSize.A4);
        section.getPageSetup().getMargins().setTop(72f);
        section.getPageSetup().getMargins().setBottom(72f);
        section.getPageSetup().getMargins().setLeft(89.85f);
        section.getPageSetup().getMargins().setRight(89.85f);
    }

    private static void insertHeaderAndFooter(Section section) throws IOException {
        //insert picture and text to header
        Paragraph headerParagraph = section.getHeadersFooters().getHeader().addParagraph();
        DocPicture headerPicture = headerParagraph.appendPicture(inputHeader);

        //header text
        TextRange text = headerParagraph.appendText("Demo of Spire.Doc");
        text.getCharacterFormat().setFontName("Arial");
        text.getCharacterFormat().setFontSize(10);
        text.getCharacterFormat().setItalic(true);
        headerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        //border
        headerParagraph.getFormat().getBorders().getBottom().setBorderType(BorderStyle.Single);
        headerParagraph.getFormat().getBorders().getBottom().setSpace(0.05F);

        //header picture layout - text wrapping
        headerPicture.setTextWrappingStyle(TextWrappingStyle.Behind);

        //header picture layout - position
        headerPicture.setHorizontalOrigin(HorizontalOrigin.Page);
        headerPicture.setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        headerPicture.setVerticalOrigin(VerticalOrigin.Page);
        headerPicture.setVerticalAlignment(ShapeVerticalAlignment.Top);

        //insert picture to footer
        Paragraph footerParagraph = section.getHeadersFooters().getFooter().addParagraph();
        DocPicture footerPicture
                = footerParagraph.appendPicture(inputFooter);

        //footer picture layout
        footerPicture.setTextWrappingStyle(TextWrappingStyle.Behind);
        footerPicture.setHorizontalOrigin(HorizontalOrigin.Page);
        footerPicture.setHorizontalAlignment(ShapeHorizontalAlignment.Left);
        footerPicture.setVerticalOrigin(VerticalOrigin.Page);
        footerPicture.setVerticalAlignment(ShapeVerticalAlignment.Bottom);

        //insert page number
        footerParagraph.appendField("page number", FieldType.Field_Page);
        footerParagraph.appendText(" of ");
        footerParagraph.appendField("number of pages", FieldType.Field_Num_Pages);
        footerParagraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);

        //border
        footerParagraph.getFormat().getBorders().getTop().setBorderType(BorderStyle.Single);
        footerParagraph.getFormat().getBorders().getTop().setSpace(0.05F);
    }

    private static void addTitle(Section section) {
        Paragraph title = section.addParagraph();
        TextRange titleText = title.appendText("Create Your Account");
        titleText.getCharacterFormat().setFontSize(18);
        titleText.getCharacterFormat().setFontName("Arial");
        titleText.getCharacterFormat().setTextColor(new Color(0x00, 0x71, 0xb6));
        title.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        title.getFormat().setAfterSpacing(8);
    }

    private static void addForm(Section section) throws Exception {
        ParagraphStyle descriptionStyle = new ParagraphStyle(section.getDocument());
        descriptionStyle.setName("description");
        descriptionStyle.getCharacterFormat().setFontSize(12);
        descriptionStyle.getCharacterFormat().setFontName("Arial");
        descriptionStyle.getCharacterFormat().setTextColor(new Color(0x00, 0x71, 0xb6));
        section.getDocument().getStyles().add(descriptionStyle);

        Paragraph p1 = section.addParagraph();
        String text1
                = "So that we can verify your identity and find your information, "
                + "please provide us with the following information. "
                + "This information will be used to create your online account. "
                + "Your information is not public, shared in anyway, or displayed on this site";
        p1.appendText(text1);
        p1.applyStyle(descriptionStyle.getName());

        Paragraph p2 = section.addParagraph();
        String text2
                = "You must provide a real email address to which we will send your password.";
        p2.appendText(text2);
        p2.applyStyle(descriptionStyle.getName());
        p2.getFormat().setAfterSpacing(8);

        //field group label style
        ParagraphStyle formFieldGroupLabelStyle = new ParagraphStyle(section.getDocument());
        formFieldGroupLabelStyle.setName("formFieldGroupLabel");
        formFieldGroupLabelStyle.applyBaseStyle("description");
        formFieldGroupLabelStyle.getCharacterFormat().setBold(true);
        formFieldGroupLabelStyle.getCharacterFormat().setTextColor(Color.white);
        section.getDocument().getStyles().add(formFieldGroupLabelStyle);

        //field label style
        ParagraphStyle formFieldLabelStyle = new ParagraphStyle(section.getDocument());
        formFieldLabelStyle.setName("formFieldLabel");
        formFieldLabelStyle.applyBaseStyle("description");
        formFieldLabelStyle.getParagraphFormat().setHorizontalAlignment(HorizontalAlignment.Right);
        section.getDocument().getStyles().add(formFieldLabelStyle);

        //add table
        Table table = section.addTable();
        //2 columns of per row
        table.setDefaultColumnsNumber(2);
        //default height of row is 20point
        table.setDefaultRowHeight(20);

        InputStream stream = new FileInputStream(new File(inputXml));
        xmlDocument = documentBuilder.parse(stream);
        NodeList nodeList = xmlDocument.getElementsByTagName("section");

        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);
            TableRow row = table.addRow(false);
            row.getCells().get(0).getCellFormat().setBackColor(new Color(0x00, 0x71, 0xb6));
            row.getCells().get(0).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);

            //label of field group
            Paragraph cellParagraph = row.getCells().get(0).addParagraph();
            NamedNodeMap namedNodeMap = node.getAttributes();
            cellParagraph.appendText(namedNodeMap.getNamedItem("name").getNodeValue());
            cellParagraph.applyStyle(formFieldGroupLabelStyle.getName());
            NodeList childList = node.getChildNodes();

            for (int j = 0; j < childList.getLength(); j++) {
                Node childNode = childList.item(j);
                String str = childNode.getNodeName();
                if ("field".equals(str)) {
                    NamedNodeMap childMap = childNode.getAttributes();
                    TableRow fieldRow = table.addRow(false);
                    //field label
                    fieldRow.getCells().get(0).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
                    Paragraph labelParagraph = fieldRow.getCells().get(0).addParagraph();
                    labelParagraph.appendText(childMap.getNamedItem("label").getNodeValue());
                    labelParagraph.applyStyle(formFieldLabelStyle.getName());

                    fieldRow.getCells().get(1).getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
                    Paragraph fieldParagraph = fieldRow.getCells().get(1).addParagraph();
                    String fieldId = childMap.getNamedItem("id").getNodeValue();
                    String attr = childMap.getNamedItem("type").getNodeValue();
                    if ("text".equals(attr)) {
                        //add text input field
                        TextFormField field = (TextFormField) fieldParagraph.appendField(fieldId, FieldType.Field_Form_Text_Input);

                        //set default text
                        field.setDefaultText("");
                        field.setText("");
                    } else if ("list".equals(attr)) {
                        //add dropdown field
                        DropDownFormField list
                                = (DropDownFormField) fieldParagraph.appendField(fieldId, FieldType.Field_Form_Drop_Down);

                        NodeList items = childNode.getChildNodes();
                        for (int h = 0; h < items.getLength(); h++) {
                            Node item = items.item(h);
                            if ("item".equals(item.getNodeName())){
                                list.getDropDownItems().add(item.getTextContent());
                            }
                        }
                    } else if ("checkbox".equals(attr)) {
                        //add checkbox field
                        fieldParagraph.appendField(fieldId, FieldType.Field_Form_Check_Box);
                        break;
                    }
                }
            }

            table.applyHorizontalMerge(row.getRowIndex(), 0, 1);
        }
    }
}

import com.spire.pdf.*;
import com.spire.pdf.actions.PdfSubmitAction;
import com.spire.pdf.automaticfields.*;
import com.spire.pdf.fields.*;
import com.spire.pdf.graphics.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

public class addFormField {
    public static void main(String[] args) throws Exception{
        String outputFile = "output/formField.pdf";
        String inputFile = "data/FormField.xml";
        addFormField form = new addFormField();
        // Create a pdf document.
        PdfDocument doc = new PdfDocument();
        //Set margin
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter,
                PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter,
                PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());
        form.setDocumentTemplate(doc, PdfPageSize.A4, margin);
        // Create one page
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, new PdfMargins(0));
        double y = 10;
        //Set title
        y = form.drawPageTitle(page, y);
        //Load form config data
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(inputFile);
        Document document = builder.parse(file);
        try {
            Element root = document.getDocumentElement();
            NodeList children = root.getChildNodes();
            int fieldIndex = 0;
            for (int i = 0; i < children.getLength(); i++) {
                Node sectionNode = children.item(i);
                if (sectionNode instanceof Element) {
                    String sectionLabel = sectionNode.getAttributes()
                            .getNamedItem("name").getNodeValue();
                    //Draw section label
                    y = form.drawFormSection(sectionLabel, page, y);
                    NodeList fieldNodes = sectionNode.getChildNodes();
                    for (int j = 0; j < fieldNodes.getLength(); j++) {
                        Node fieldNode = fieldNodes.item(j);
                        if (fieldNode instanceof Element) {
                            y = form.drawFormField(fieldNode, doc.getForm(),
                                    page, y, fieldIndex++);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Draw button
        y = y + 10;
        double buttonWidth = 80;
        double buttonX = (page.getCanvas().getClientSize().getWidth() - buttonWidth) / 2;
        Rectangle2D.Float buttonBounds = new Rectangle2D.Float();
        buttonBounds.setFrame(buttonX, y, buttonWidth, 16f);
        PdfButtonField button = null;
        try {
            button = new PdfButtonField(page, "submit");
        } catch (Exception e) {
            e.printStackTrace();
        }
        button.setText("Submit");
        button.setBounds(buttonBounds);
        PdfSubmitAction submitAction = new PdfSubmitAction("http://www.e-iceblue.com");
        button.getActions().setMouseUp(submitAction);
        doc.getForm().getFields().add(button);
        // Save pdf file.
        doc.saveToFile(outputFile);
        doc.close();
    }

    private void setDocumentTemplate(PdfDocument doc, Dimension2D pageSize, PdfMargins margin) {
        String headerImageFile = "data/header.png";
        String footerImageFile = "data/footer.png";
        PdfPageTemplateElement leftSpace = new PdfPageTemplateElement(
                margin.getLeft(), pageSize.getHeight());
        doc.getTemplate().setLeft(leftSpace);
        PdfPageTemplateElement topSpace = new PdfPageTemplateElement(
                pageSize.getWidth(), margin.getTop());
        topSpace.setForeground(true);
        doc.getTemplate().setTop(topSpace);
        //Draw header label
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC,9),9f,true);
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);
        String label = "Demo of Spire.Pdf";
        Dimension2D size = font.measureString(label, format);
        double y = topSpace.getHeight() - font.getHeight() - 1;
        PdfRGBColor black = new PdfRGBColor(new Color(0xff, 0xeb, 0xcd));
        PdfPen pen = new PdfPen(black, 0.75f);
        topSpace.getGraphics().setTransparency(0.5f);
        topSpace.getGraphics().drawLine(pen, margin.getLeft(), y,
                pageSize.getWidth() - margin.getRight(), y);
        y = y - 1 - size.getHeight();
        topSpace.getGraphics().drawString(label, font, PdfBrushes.getBlack(),
                pageSize.getWidth() - margin.getRight(), y, format);
        PdfPageTemplateElement rightSpace = new PdfPageTemplateElement(
                margin.getRight(), pageSize.getHeight());
        doc.getTemplate().setRight(rightSpace);
        PdfPageTemplateElement bottomSpace = new PdfPageTemplateElement(
                pageSize.getWidth(), margin.getBottom());
        bottomSpace.setForeground(true);
        doc.getTemplate().setBottom(bottomSpace);
        //Draw footer label
        y = font.getHeight() + 1;
        bottomSpace.getGraphics().setTransparency(0.5f);
        bottomSpace.getGraphics().drawLine(pen, margin.getLeft(), y,
                pageSize.getWidth() - margin.getRight(), y);
        y = y + 1;
        PdfPageNumberField pageNumber = new PdfPageNumberField();
        PdfPageCountField pageCount = new PdfPageCountField();
        PdfCompositeField pageNumberLabel = new PdfCompositeField();
        pageNumberLabel.setAutomaticFields(new PdfAutomaticField[]{
                pageNumber, pageCount});
        pageNumberLabel.setBrush(PdfBrushes.getBlack());
        pageNumberLabel.setFont(font);
        pageNumberLabel.setStringFormat(format);
        pageNumberLabel.setText("page {0} of {1}");
        pageNumberLabel.draw(bottomSpace.getGraphics(),
                pageSize.getWidth() - margin.getRight(), y);
        PdfImage headerImage = PdfImage.fromFile(headerImageFile);

        Point2D.Float pageLeftTop = new Point2D.Float();
        pageLeftTop.setLocation(-margin.getLeft(),-margin.getTop());

        PdfPageTemplateElement header = new PdfPageTemplateElement(pageLeftTop,
                headerImage.getPhysicalDimension());
        header.setForeground(false);
        header.getGraphics().setTransparency(0.5f);
        header.getGraphics().drawImage(headerImage, 0, 0);
        doc.getTemplate().getStamps().add(header);
        PdfImage footerImage = PdfImage.fromFile(footerImageFile);
        y = pageSize.getHeight() - footerImage.getPhysicalDimension().getHeight();
        Point2D.Float footerLocation = new Point2D.Float();
        footerLocation.setLocation(-margin.getLeft(),y);

        PdfPageTemplateElement footer = new PdfPageTemplateElement(
                footerLocation, footerImage.getPhysicalDimension());
        footer.setForeground(false);
        footer.getGraphics().setTransparency(0.5f);
        footer.getGraphics().drawImage(footerImage, 0, 0);
        doc.getTemplate().getStamps().add(footer);
    }

    private double drawPageTitle(PdfPageBase page, double y) {
        PdfBrush brush1 = PdfBrushes.getMidnightBlue();
        PdfBrush brush2 = PdfBrushes.getRed();
        PdfTrueTypeFont font1= new PdfTrueTypeFont(new Font("Arial", Font.PLAIN,12),12f,true);
        String title = "Your Account Information(* = Required)";
        Dimension2D size = font1.measureString(title);
        double x = (page.getCanvas().getClientSize().getWidth() - size.getWidth()) / 2;
        page.getCanvas().drawString("Your Account Information(", font1, brush1,
                x, y);
        size = font1.measureString("Your Account Information(");
        x = x + size.getWidth();
        page.getCanvas().drawString("* = Required", font1, brush2, x, y);
        size = font1.measureString("* = Required");
        x = x + size.getWidth();
        page.getCanvas().drawString(")", font1, brush1, x, y);
        y = y + size.getHeight();
        y = y + 3;
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC,8),8f,true);

        String p = "Your information is not public, shared in anyway, or displayed on this site.";
        page.getCanvas().drawString(p, font2, brush1, 0, y);
        return y + font2.getHeight();
    }

    private double drawFormSection(String label, PdfPageBase page, double y) {
        PdfBrush brush1 = PdfBrushes.getLightYellow();
        PdfBrush brush2 = PdfBrushes.getDarkSlateGray();
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD,9),9f,true);
        double height = font.measureString(label).getHeight();
        page.getCanvas().drawRectangle(brush2, 0, y,
                page.getCanvas().getClientSize().getWidth(), height + 2);
        page.getCanvas().drawString(label, font, brush1, 2, y + 1);
        y = y + height + 2;
        PdfPen pen = new PdfPen(PdfBrushes.getLightSkyBlue(), 0.75f);
        page.getCanvas().drawLine(pen, 0, y,
                page.getCanvas().getClientSize().getWidth(), y);
        return y + 0.75f;
    }

    private double drawFormField(Node fieldNode, PdfForm form, PdfPageBase page,
                                 double y, int fieldIndex) throws Exception {
        addFormField draw = new addFormField();
        double width = page.getCanvas().getClientSize().getWidth();
        double padding = 2;
        //Measure field label
        String label = fieldNode.getAttributes().getNamedItem("label")
                .getNodeValue();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN,9 ),9f,true);
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right,
                PdfVerticalAlignment.Middle);
        double labelMaxWidth = width * 0.4f - 2 * padding;
        Dimension2D labelSize = font1.measureString(label, labelMaxWidth, format);
        //Measure field height
        double fieldHeight = draw.measureFieldHeight(fieldNode);
        double height = labelSize.getHeight() > fieldHeight ? labelSize.getHeight()
                : fieldHeight;
        height = height + 2;
        //Draw background
        PdfBrush brush = PdfBrushes.getSteelBlue();
        if (fieldIndex % 2 == 1) {
            brush = PdfBrushes.getLightGreen();
        }
        page.getCanvas().drawRectangle(brush, 0, y, width, height);
        //Draw field label
        PdfBrush brush1 = PdfBrushes.getLightYellow();
        Rectangle2D.Float labelBounds = new Rectangle2D.Float();
        labelBounds.setFrame(padding, y, labelMaxWidth,height);
        page.getCanvas().drawString(label, font1, brush1, labelBounds, format);
        // daw field
        double fieldMaxWidth = width * 0.57f - 2 * padding;
        double fieldX = labelBounds.getX()+labelBounds.getWidth() + 2 * padding;
        double fieldY = y + (height - fieldHeight) / 2;
        String fieldType = fieldNode.getAttributes().getNamedItem("type")
                .getNodeValue();
        int fieldTypeInt = 0;
        if (fieldType.trim().equals("text"))
            fieldTypeInt = 1;
        if (fieldType.trim().equals("password"))
            fieldTypeInt = 2;
        if (fieldType.trim().equals("checkbox"))
            fieldTypeInt = 3;
        if (fieldType.trim().equals("list"))
            fieldTypeInt = 4;
        String fieldId = fieldNode.getAttributes().getNamedItem("id")
                .getNodeValue();
        boolean required = false;
        if (fieldNode.getAttributes().getNamedItem("required") != null) {
            if (fieldNode.getAttributes().getNamedItem("required")
                    .getNodeValue().trim().equals("true")) {
                required = true;
            }
        }
        switch (fieldTypeInt) {
            case 1:
            case 2:
                PdfTextBoxField textField = new PdfTextBoxField(page, fieldId);
                Rectangle2D.Float bounds = new Rectangle2D.Float();
                bounds.setFrame(fieldX, fieldY, fieldMaxWidth,fieldHeight);
                textField.setBounds(bounds);
                textField.setBorderWidth(0.75f);
                textField.setBorderStyle(PdfBorderStyle.Solid);
                textField.setRequired(required);
                if ("password" == fieldType) {
                    textField.setPassword(true);
                }
                if (fieldNode.getAttributes().getNamedItem("multiple") != null) {
                    if ("true" == fieldNode.getAttributes()
                            .getNamedItem("multiple").getNodeValue()) {
                        textField.setMultiline(true);
                        textField.setScrollable(true);
                    }
                }
                form.getFields().add(textField);
                break;
            case 3:
                PdfCheckBoxField checkboxField = new PdfCheckBoxField(page, fieldId);
                double checkboxWidth = fieldHeight - 2 * padding;
                double checkboxHeight = checkboxWidth;
                Rectangle2D.Float bounds2 = new Rectangle2D.Float();
                bounds2.setFrame(fieldX, fieldY + padding,
                        checkboxWidth, checkboxHeight);
                checkboxField.setBounds(bounds2);
                checkboxField.setBorderWidth(0.75f);
                checkboxField.setStyle(PdfCheckBoxStyle.Cross);
                checkboxField.setRequired(required);
                form.getFields().add(checkboxField);
                break;
            case 4:
                
                NodeList itemNodes = fieldNode.getChildNodes();
                if (fieldNode.getAttributes().getNamedItem("multiple") != null) {
                    if ("true" == fieldNode.getAttributes()
                            .getNamedItem("multiple").getNodeValue()) {
                        PdfListBoxField listBoxField = new PdfListBoxField(page,
                                fieldId);
                        Rectangle2D.Float bounds4 = new Rectangle2D.Float();
                        bounds4.setFrame(fieldX, fieldY,
                                fieldMaxWidth, fieldHeight);
                        listBoxField.setBounds(bounds4);
                        listBoxField.setBorderWidth(0.75f);
                        listBoxField.setMultiSelect(true);
                        listBoxField
                                .setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN,9),9,true));
                        listBoxField.setRequired(required);
                        // add items into list box.
                        for (int i = 0; i < itemNodes.getLength(); i++) {
                            Node itemNode = itemNodes.item(i);
                            if (itemNode instanceof Element) {
                                String text = ((Element) itemNode).getTagName();
                                listBoxField.getItems().add(
                                        new PdfListFieldItem(text, text));
                            }
                        }
                        listBoxField.setSelectedIndex(0);
                        form.getFields().add(listBoxField);
                        break;
                    }
                }
                if (itemNodes != null && itemNodes.getLength() <= 7) {
                    PdfRadioButtonListField radioButtonListFile = new PdfRadioButtonListField(
                            page, fieldId);
                    radioButtonListFile.setRequired(required);
                    // add items into radio button list.
                    double fieldItemHeight = fieldHeight
                            / (itemNodes.getLength() / 2);
                    double radioButtonWidth = fieldItemHeight - 2 * padding;
                    double radioButtonHeight = radioButtonWidth;
                    for (int j = 0; j < itemNodes.getLength(); j++) {
                        Node itemNode = itemNodes.item(j);
                        if (itemNode instanceof Element) {
                            String text = itemNode.getTextContent();
                            PdfRadioButtonListItem fieldItem = new PdfRadioButtonListItem(
                                    text);
                            fieldItem.setBorderWidth(0.75f);
                            Rectangle2D.Float bounds1 = new Rectangle2D.Float();
                            bounds1.setFrame(fieldX, fieldY
                                    + padding, radioButtonWidth, radioButtonHeight);
                            fieldItem.setBounds(bounds1);
                            radioButtonListFile.getItems().add(fieldItem);
                            double fieldItemLabelX = fieldX + radioButtonWidth
                                    + padding;
                            Dimension2D fieldItemLabelSize = font1.measureString(text);
                            double fieldItemLabelY = fieldY
                                    + (fieldItemHeight - fieldItemLabelSize.getHeight())
                                    / 2;
                            page.getCanvas().drawString(text, font1, brush1,
                                    fieldItemLabelX, fieldItemLabelY);
                            fieldY = fieldY + fieldItemHeight;
                        }
                    }
                    form.getFields().add(radioButtonListFile);
                    break;
                }
                //Combo box
                PdfComboBoxField comboBoxField = new PdfComboBoxField(page, fieldId);
                Rectangle2D.Float bounds3 = new Rectangle2D.Float();
                bounds3.setFrame(fieldX, fieldY, fieldMaxWidth,
                        fieldHeight);
                comboBoxField.setBounds(bounds3);
                comboBoxField.setBorderWidth(0.75f);
                comboBoxField.setFont(new PdfTrueTypeFont((new Font("Arial", Font.PLAIN,9)) ,9f,true));
                comboBoxField.setRequired(required);
                // Add items into combo box.
                for (int index = 0; index < itemNodes.getLength(); index++) {
                    Node itemNode = itemNodes.item(index);
                    if (itemNode instanceof Element) {
                        String text = itemNode.getTextContent();
                        comboBoxField.getItems().add(
                                new PdfListFieldItem(text, text));
                    }
                }
                form.getFields().add(comboBoxField);
                break;
        }
        if (required) {
            // Draw *
            double flagX = width * 0.97f + padding;
            PdfTrueTypeFont font3 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN,10 ),10f,true);
            Dimension2D size = font3.measureString("*");
            double flagY = y + (height - size.getHeight()) / 2;
            page.getCanvas().drawString("*", font3, PdfBrushes.getRed(), flagX,
                    flagY);
        }
        return y + height;
    }

    private double measureFieldHeight(Node fieldNode) {
        String fieldType = fieldNode.getAttributes().getNamedItem("type")
                .getNodeValue();
        double defaultHeight = 16f;
        int fieldTypeInt = 0;
        if (fieldType.trim().equals("text"))
            fieldTypeInt = 1;
        if (fieldType.trim().equals("password"))
            fieldTypeInt = 2;
        if (fieldType.trim().equals("checkbox"))
            fieldTypeInt = 3;
        if (fieldType.trim().equals("list"))
            fieldTypeInt = 4;
        switch (fieldTypeInt) {
            case 1:
                if (fieldNode.getAttributes().getNamedItem("multiple") != null) {
                    if ("true" == fieldNode.getAttributes()
                            .getNamedItem("multiple").getNodeValue()) {
                        return defaultHeight * 3;
                    }
                }
                return defaultHeight;
            case 2:
                if (fieldNode.getAttributes().getNamedItem("multiple") != null) {
                    if ("true" == fieldNode.getAttributes()
                            .getNamedItem("multiple").getNodeValue()) {
                        return defaultHeight * 3;
                    }
                }
                return defaultHeight;
            case 3:
                return defaultHeight;
            case 4:
                if (fieldNode.getAttributes().getNamedItem("multiple") != null) {
                    if ("true" == fieldNode.getAttributes()
                            .getNamedItem("multiple").getNodeName()) {
                        return defaultHeight * 3;
                    }
                }

                NodeList itemNodes = fieldNode.getChildNodes();
                if (itemNodes != null && itemNodes.getLength() <= 7) {
                    return defaultHeight * 3;
                }
                return defaultHeight;

        }
        String message = String.format("Invalid field type: %s", fieldType);
        throw new IllegalArgumentException(message);
    }
}

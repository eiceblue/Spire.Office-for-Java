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
         // Specify the output and input file paths
        String outputFile = "output/formField.pdf";
        String inputFile = "data/FormField.xml";

        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Create a PdfUnitConvertor for unit conversion
        PdfUnitConvertor unitCvtr = new PdfUnitConvertor();

        // Set up the page margins
        PdfMargins margin = new PdfMargins();
        margin.setTop(unitCvtr.convertUnits(2.54f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setBottom(margin.getTop());
        margin.setLeft(unitCvtr.convertUnits(3.17f, PdfGraphicsUnit.Centimeter, PdfGraphicsUnit.Point));
        margin.setRight(margin.getLeft());

        // Set the document template with specified page size and margins
        setDocumentTemplate(doc, PdfPageSize.A4, margin);

        // Add a new page to the document
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, new PdfMargins(0));

        // Initialize the y-coordinate for drawing content on the page
        double y = 10;

        // Draw the page title and update the y-coordinate
        y = drawPageTitle(page, y);

        // Parse the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File(inputFile);
        Document document = builder.parse(file);

        try {
            // Get the root element of the XML document
            Element root = document.getDocumentElement();

            // Get the child nodes of the root element
            NodeList children = root.getChildNodes();

            // Initialize the field index
            int fieldIndex = 0;

            // Iterate over the child nodes
            for (int i = 0; i < children.getLength(); i++) {
                Node sectionNode = children.item(i);

                // Process only if the node is an Element
                if (sectionNode instanceof Element) {
                    // Get the name attribute of the section
                    String sectionLabel = sectionNode.getAttributes().getNamedItem("name").getNodeValue();

                    // Draw the form section label and update the y-coordinate
                    y = drawFormSection(sectionLabel, page, y);

                    // Get the field nodes of the section
                    NodeList fieldNodes = sectionNode.getChildNodes();

                    // Iterate over the field nodes
                    for (int j = 0; j < fieldNodes.getLength(); j++) {
                        Node fieldNode = fieldNodes.item(j);

                        // Process only if the node is an Element
                        if (fieldNode instanceof Element) {
                            // Draw the form field and update the y-coordinate
                            y = drawFormField(fieldNode, doc.getForm(), page, y, fieldIndex++);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Update the y-coordinate and calculate the button position
        y = y + 10;
        double buttonWidth = 80;
        double buttonX = (page.getCanvas().getClientSize().getWidth() - buttonWidth) / 2;

        // Create a rectangle representing the button's bounds
        Rectangle2D.Float buttonBounds = new Rectangle2D.Float();
        buttonBounds.setFrame(buttonX, y, buttonWidth, 16f);

        // Create a PdfButtonField for the submit button
        PdfButtonField button = null;
        try {
            button = new PdfButtonField(page, "submit");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the text and bounds for the button
        button.setText("Submit");
        button.setBounds(buttonBounds);

        // Create a PdfSubmitAction for the button's mouse up action
        PdfSubmitAction submitAction = new PdfSubmitAction("http://www.e-iceblue.com");
        button.getActions().setMouseUp(submitAction);

        // Add the button field to the document's form fields collection
        doc.getForm().getFields().add(button);

        // Save the document to the output file
        doc.saveToFile(outputFile);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

     private static void setDocumentTemplate(PdfDocument doc, Dimension2D pageSize, PdfMargins margin) {
        // Set up paths to header and footer image files
        String headerImageFile = "data/header.png";
        String footerImageFile = "data/footer.png";

        // Create the left space template element
        PdfPageTemplateElement leftSpace = new PdfPageTemplateElement(margin.getLeft(), pageSize.getHeight());
        doc.getTemplate().setLeft(leftSpace);

        // Create the top space template element
        PdfPageTemplateElement topSpace = new PdfPageTemplateElement(pageSize.getWidth(), margin.getTop());
        topSpace.setForeground(true);
        doc.getTemplate().setTop(topSpace);

        // Create a TrueType font using Arial, italic style, and size 9
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 9), 9f, true);

        // Create a string format for aligning text to the right
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right);

        // Define the label text
        String label = "Demo of Spire.Pdf";

        // Measure the size of the label text using the specified font and format
        Dimension2D size = font.measureString(label, format);

        // Calculate the y-coordinate for positioning the label at the top space
        double y = topSpace.getHeight() - font.getHeight() - 1;

        // Create a RGB color object representing black
        PdfRGBColor black = new PdfRGBColor(new Color(0xff, 0xeb, 0xcd));

        // Create a pen with black color and thickness of 0.75
        PdfPen pen = new PdfPen(black, 0.75f);

        // Set the transparency of the graphics in the top space to 0.5
        topSpace.getGraphics().setTransparency(0.5f);

        // Draw a line using the pen from the left margin to the right margin at y-coordinate
        topSpace.getGraphics().drawLine(pen, margin.getLeft(), y, pageSize.getWidth() - margin.getRight(), y);

        // Update the y-coordinate for positioning the label below the line
        y = y - 1 - size.getHeight();

        // Draw the label text using the specified font, black color, and alignment format
        topSpace.getGraphics().drawString(label, font, PdfBrushes.getBlack(), pageSize.getWidth() - margin.getRight(), y, format);

        // Create the right space template element
        PdfPageTemplateElement rightSpace = new PdfPageTemplateElement(margin.getRight(), pageSize.getHeight());
        doc.getTemplate().setRight(rightSpace);

        // Create the bottom space template element
        PdfPageTemplateElement bottomSpace = new PdfPageTemplateElement(pageSize.getWidth(), margin.getBottom());
        bottomSpace.setForeground(true);
        doc.getTemplate().setBottom(bottomSpace);

        // Calculate the initial y-coordinate for positioning the footer label
        y = font.getHeight() + 1;

        // Set the transparency of the graphics in the bottom space to 0.5
        bottomSpace.getGraphics().setTransparency(0.5f);

        // Draw a line using the pen from the left margin to the right margin at y-coordinate
        bottomSpace.getGraphics().drawLine(pen, margin.getLeft(), y, pageSize.getWidth() - margin.getRight(), y);

        // Update the y-coordinate for positioning the page number label below the line
        y = y + 1;

        // Create a PdfPageNumberField object for displaying the current page number
        PdfPageNumberField pageNumber = new PdfPageNumberField();

        // Create a PdfPageCountField object for displaying the total number of pages
        PdfPageCountField pageCount = new PdfPageCountField();

        // Create a composite field to combine the page number and page count fields
        PdfCompositeField pageNumberLabel = new PdfCompositeField();

        // Set the automatic fields for the composite field
        pageNumberLabel.setAutomaticFields(new PdfAutomaticField[]{pageNumber, pageCount});

        // Set the brush color of the composite field to black
        pageNumberLabel.setBrush(PdfBrushes.getBlack());

        // Set the font of the composite field to the previously defined font
        pageNumberLabel.setFont(font);

        // Set the string format of the composite field to the previously defined format
        pageNumberLabel.setStringFormat(format);

        // Set the text format of the composite field to display "page {0} of {1}"
        pageNumberLabel.setText("page {0} of {1}");

        // Draw the page number label on the bottom space graphics at the specified position
        pageNumberLabel.draw(bottomSpace.getGraphics(), pageSize.getWidth() - margin.getRight(), y);

        // Create a PdfImage object from the header image file
        PdfImage headerImage = PdfImage.fromFile(headerImageFile);

        // Create a Point2D.Float object to store the top-left coordinates of the page
        Point2D.Float pageLeftTop = new Point2D.Float();

        // Set the coordinates of the top-left corner to be outside the page margins
        pageLeftTop.setLocation(-margin.getLeft(), -margin.getTop());

        // Create a PdfPageTemplateElement for the header, using the top-left coordinates and the physical dimensions of the header image
        PdfPageTemplateElement header = new PdfPageTemplateElement(pageLeftTop, headerImage.getPhysicalDimension());

        // Set the foreground (drawn content) of the header to be transparent
        header.setForeground(false);

        // Set the transparency of the header's graphics context to 0.5
        header.getGraphics().setTransparency(0.5f);

        // Draw the header image at the coordinates (0, 0) on the header template element's graphics context
        header.getGraphics().drawImage(headerImage, 0, 0);

        // Add the header template element to the document's template stamps collection
        doc.getTemplate().getStamps().add(header);

        // Create a PdfImage object from the footer image file
        PdfImage footerImage = PdfImage.fromFile(footerImageFile);

        // Calculate the y-coordinate for the footer, based on the page size and the height of the footer image
        y = pageSize.getHeight() - footerImage.getPhysicalDimension().getHeight();

        // Create a Point2D.Float object to store the coordinates of the footer's top-left corner
        Point2D.Float footerLocation = new Point2D.Float();

        // Set the coordinates of the top-left corner to be outside the page margins, with the calculated y-coordinate
        footerLocation.setLocation(-margin.getLeft(), y);

        // Create a PdfPageTemplateElement for the footer, using the top-left coordinates and the physical dimensions of the footer image
        PdfPageTemplateElement footer = new PdfPageTemplateElement(footerLocation, footerImage.getPhysicalDimension());

        // Set the foreground (drawn content) of the footer to be transparent
        footer.setForeground(false);

        // Set the transparency of the footer's graphics context to 0.5
        footer.getGraphics().setTransparency(0.5f);

        // Draw the footer image at the coordinates (0, 0) on the footer template element's graphics context
        footer.getGraphics().drawImage(footerImage, 0, 0);

        // Add the footer template element to the document's template stamps collection
        doc.getTemplate().getStamps().add(footer);
    }

    private static double drawPageTitle(PdfPageBase page, double y) {
        // Set up brushes and fonts
        PdfBrush brush1 = PdfBrushes.getMidnightBlue();
        PdfBrush brush2 = PdfBrushes.getRed();
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 12), 12f, true);

        // Draw the first part of the title: "Your Account Information("
        String titlePart1 = "Your Account Information(";
        Dimension2D size = font1.measureString(titlePart1);
        double x = (page.getCanvas().getClientSize().getWidth() - size.getWidth()) / 2;
        page.getCanvas().drawString(titlePart1, font1, brush1, x, y);

        // Update x-coordinate position
        x = x + size.getWidth();

        // Draw the second part of the title: "* = Required"
        String titlePart2 = "* = Required";
        size = font1.measureString(titlePart2);
        page.getCanvas().drawString(titlePart2, font1, brush2, x, y);

        // Update x-coordinate position
        x = x + size.getWidth();

        // Draw the closing bracket ")"
        String closingBracket = ")";
        page.getCanvas().drawString(closingBracket, font1, brush1, x, y);

        // Update y-coordinate position
        y = y + size.getHeight();

        // Add some vertical spacing
        y = y + 3;

        // Set up font and text for the informational paragraph
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.ITALIC, 8), 8f, true);
        String infoParagraph = "Your information is not public, shared in anyway, or displayed on this site.";

        // Draw the informational paragraph
        page.getCanvas().drawString(infoParagraph, font2, brush1, 0, y);

        // Return the updated y-coordinate position
        return y + font2.getHeight();
    }

    private static double drawFormSection(String label, PdfPageBase page, double y) {
        // Set up brushes and font
        PdfBrush brush1 = PdfBrushes.getLightYellow();
        PdfBrush brush2 = PdfBrushes.getDarkSlateGray();
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 9), 9f, true);

        // Measure the height of the label
        double height = font.measureString(label).getHeight();

        // Draw the section header rectangle
        page.getCanvas().drawRectangle(brush2, 0, y, page.getCanvas().getClientSize().getWidth(), height + 2);

        // Draw the section label
        page.getCanvas().drawString(label, font, brush1, 2, y + 1);

        // Update y-coordinate position
        y = y + height + 2;

        // Draw a horizontal line below the section
        PdfPen pen = new PdfPen(PdfBrushes.getLightSkyBlue(), 0.75f);
        page.getCanvas().drawLine(pen, 0, y, page.getCanvas().getClientSize().getWidth(), y);

        // Return the updated y-coordinate position
        return y + 0.75f;
    }

    private static double drawFormField(Node fieldNode, PdfForm form, PdfPageBase page,
                                 double y, int fieldIndex) throws Exception {
        // Get the width of the canvas
        double width = page.getCanvas().getClientSize().getWidth();

        // Set the padding value
        double padding = 2;

        // Get the label from the field node's attributes
        String label = fieldNode.getAttributes().getNamedItem("label").getNodeValue();

        // Create a TrueType font for the label
        PdfTrueTypeFont font1 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9), 9f, true);

        // Create a string format for the label alignment
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle);

        // Calculate the maximum width for the label
        double labelMaxWidth = width * 0.4f - 2 * padding;

        // Measure the size of the label text using the font and format
        Dimension2D labelSize = font1.measureString(label, labelMaxWidth, format);

        // Measure the height of the field
        double fieldHeight = measureFieldHeight(fieldNode);

        // Determine the overall height based on the label and field heights
        double height = labelSize.getHeight() > fieldHeight ? labelSize.getHeight() : fieldHeight;

        // Add extra space to the height
        height = height + 2;

        // Set the brush color for drawing the rectangle
        PdfBrush brush = PdfBrushes.getSteelBlue();

        // Alternate brush color for odd field indexes
        if (fieldIndex % 2 == 1) {
            brush = PdfBrushes.getLightGreen();
        }

        // Draw a rectangle on the canvas using the specified brush, width, and height
        page.getCanvas().drawRectangle(brush, 0, y, width, height);

        // Set the brush color for drawing the label text
        PdfBrush brush1 = PdfBrushes.getLightYellow();

        // Create a bounding rectangle for the label
        Rectangle2D.Float labelBounds = new Rectangle2D.Float();
        labelBounds.setFrame(padding, y, labelMaxWidth, height);

        // Draw the label text on the canvas using the font, brush, bounds, and format
        page.getCanvas().drawString(label, font1, brush1, labelBounds, format);

        // Calculate the maximum width for the field
        double fieldMaxWidth = width * 0.57f - 2 * padding;

        // Calculate the x-coordinate for the field
        double fieldX = labelBounds.getX() + labelBounds.getWidth() + 2 * padding;

        // Calculate the y-coordinate for the field
        double fieldY = y + (height - fieldHeight) / 2;

        // Get the type attribute from the field node's attributes
        String fieldType = fieldNode.getAttributes().getNamedItem("type").getNodeValue();

        // Map the field type to an integer value
        int fieldTypeInt = 0;
        if (fieldType.trim().equals("text"))
            fieldTypeInt = 1;
        if (fieldType.trim().equals("password"))
            fieldTypeInt = 2;
        if (fieldType.trim().equals("checkbox"))
            fieldTypeInt = 3;
        if (fieldType.trim().equals("list"))
            fieldTypeInt = 4;

        // Get the id attribute from the field node's attributes
        String fieldId = fieldNode.getAttributes().getNamedItem("id").getNodeValue();

        // Initialize required flag to false
        boolean required = false;

        // Check if the "required" attribute exists and set the required flag accordingly
        if (fieldNode.getAttributes().getNamedItem("required") != null) {
            if (fieldNode.getAttributes().getNamedItem("required").getNodeValue().trim().equals("true")) {
                required = true;
            }
        }

        // Process based on the field type
        switch (fieldTypeInt) {
            case 1:
            case 2:
                // Create a PDF text box field
                PdfTextBoxField textField = new PdfTextBoxField(page, fieldId);

                // Set bounds for the text box field
                Rectangle2D.Float bounds = new Rectangle2D.Float();
                bounds.setFrame(fieldX, fieldY, fieldMaxWidth, fieldHeight);
                textField.setBounds(bounds);

                // Set border properties for the text box field
                textField.setBorderWidth(0.75f);
                textField.setBorderStyle(PdfBorderStyle.Solid);

                // Set the required flag for the text box field
                textField.setRequired(required);

                // Set password property if field type is "password"
                if ("password" == fieldType) {
                    textField.setPassword(true);
                }

                // Check if the "multiple" attribute exists and set multiline and scrollable properties
                if (fieldNode.getAttributes().getNamedItem("multiple") != null) {
                    if ("true" == fieldNode.getAttributes().getNamedItem("multiple").getNodeValue()) {
                        textField.setMultiline(true);
                        textField.setScrollable(true);
                    }
                }

                // Add the text box field to the form
                form.getFields().add(textField);
                break;

            case 3:
                // Create a PDF checkbox field
                PdfCheckBoxField checkboxField = new PdfCheckBoxField(page, fieldId);

                // Calculate dimensions for the checkbox
                double checkboxWidth = fieldHeight - 2 * padding;
                double checkboxHeight = checkboxWidth;

                // Set bounds for the checkbox field
                Rectangle2D.Float bounds2 = new Rectangle2D.Float();
                bounds2.setFrame(fieldX, fieldY + padding, checkboxWidth, checkboxHeight);
                checkboxField.setBounds(bounds2);

                // Set border properties for the checkbox field
                checkboxField.setBorderWidth(0.75f);
                checkboxField.setStyle(PdfCheckBoxStyle.Cross);

                // Set the required flag for the checkbox field
                checkboxField.setRequired(required);

                // Add the checkbox field to the form
                form.getFields().add(checkboxField);
                break;

            case 4:
                // Process list box field

                // Get the child nodes of the field node
                NodeList itemNodes = fieldNode.getChildNodes();

                // Check if the "multiple" attribute exists and create a multi-select list box field
                if (fieldNode.getAttributes().getNamedItem("multiple") != null) {
                    if ("true" == fieldNode.getAttributes().getNamedItem("multiple").getNodeValue()) {
                        // Create a PDF list box field
                        PdfListBoxField listBoxField = new PdfListBoxField(page, fieldId);

                        // Set bounds for the list box field
                        Rectangle2D.Float bounds4 = new Rectangle2D.Float();
                        bounds4.setFrame(fieldX, fieldY, fieldMaxWidth, fieldHeight);
                        listBoxField.setBounds(bounds4);

                        // Set border properties for the list box field
                        listBoxField.setBorderWidth(0.75f);

                        // Enable multi-select for the list box field
                        listBoxField.setMultiSelect(true);

                        // Set font for the list box field
                        listBoxField.setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9), 9, true));

                        // Set the required flag for the list box field
                        listBoxField.setRequired(required);

                        // Add items to the list box field
                        for (int i = 0; i < itemNodes.getLength(); i++) {
                            Node itemNode = itemNodes.item(i);
                            if (itemNode instanceof Element) {
                                String text = ((Element) itemNode).getTagName();
                                listBoxField.getItems().add(new PdfListFieldItem(text, text));
                            }
                        }

                        // Set the selected index to the first item
                        listBoxField.setSelectedIndex(0);

                        // Add the list box field to the form
                        form.getFields().add(listBoxField);
                        break;
                    }
                }
                // Check if itemNodes is not null and the length is less than or equal to 7
                if (itemNodes != null && itemNodes.getLength() <= 7) {
                    // Create a PDF radio button list field
                    PdfRadioButtonListField radioButtonListFile = new PdfRadioButtonListField(page, fieldId);

                    // Set the required flag for the radio button list field
                    radioButtonListFile.setRequired(required);

                    // Calculate the height of each field item
                    double fieldItemHeight = fieldHeight / (itemNodes.getLength() / 2);

                    // Calculate dimensions for the radio button
                    double radioButtonWidth = fieldItemHeight - 2 * padding;
                    double radioButtonHeight = radioButtonWidth;

                    // Iterate over itemNodes to add radio button items
                    for (int j = 0; j < itemNodes.getLength(); j++) {
                        Node itemNode = itemNodes.item(j);
                        if (itemNode instanceof Element) {
                            // Get the text content of the itemNode
                            String text = itemNode.getTextContent();

                            // Create a PDF radio button list item
                            PdfRadioButtonListItem fieldItem = new PdfRadioButtonListItem(text);

                            // Set border properties for the radio button list item
                            fieldItem.setBorderWidth(0.75f);

                            // Set bounds for the radio button list item
                            Rectangle2D.Float bounds1 = new Rectangle2D.Float();
                            bounds1.setFrame(fieldX, fieldY + padding, radioButtonWidth, radioButtonHeight);
                            fieldItem.setBounds(bounds1);

                            // Add the radio button list item to the radio button list field
                            radioButtonListFile.getItems().add(fieldItem);

                            // Calculate position for the label of the radio button list item
                            double fieldItemLabelX = fieldX + radioButtonWidth + padding;
                            Dimension2D fieldItemLabelSize = font1.measureString(text);
                            double fieldItemLabelY = fieldY + (fieldItemHeight - fieldItemLabelSize.getHeight()) / 2;

                            // Draw the label on the page canvas
                            page.getCanvas().drawString(text, font1, brush1, fieldItemLabelX, fieldItemLabelY);

                            // Update fieldY for the next field item
                            fieldY = fieldY + fieldItemHeight;
                        }
                    }

                    // Add the radio button list field to the form
                    form.getFields().add(radioButtonListFile);
                    break;
                }

                // Create a PDF combo box field
                PdfComboBoxField comboBoxField = new PdfComboBoxField(page, fieldId);

                // Set bounds for the combo box field
                Rectangle2D.Float bounds3 = new Rectangle2D.Float();
                bounds3.setFrame(fieldX, fieldY, fieldMaxWidth, fieldHeight);
                comboBoxField.setBounds(bounds3);

                // Set border properties for the combo box field
                comboBoxField.setBorderWidth(0.75f);

                // Set font for the combo box field
                comboBoxField.setFont(new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 9), 9f, true));

                // Set the required flag for the combo box field
                comboBoxField.setRequired(required);

                // Iterate over itemNodes to add items to the combo box field
                for (int index = 0; index < itemNodes.getLength(); index++) {
                    Node itemNode = itemNodes.item(index);
                    if (itemNode instanceof Element) {
                        // Get the text content of the itemNode
                        String text = itemNode.getTextContent();

                        // Add an item to the combo box field
                        comboBoxField.getItems().add(new PdfListFieldItem(text, text));
                    }
                }

                // Add the combo box field to the form
                form.getFields().add(comboBoxField);
                break;
        }
        // Check if the field is required
        if (required) {
            // Calculate position for the required flag
            double flagX = width * 0.97f + padding;
            PdfTrueTypeFont font3 = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN, 10), 10f, true);
            Dimension2D size = font3.measureString("*");
            double flagY = y + (height - size.getHeight()) / 2;

            // Draw the required flag on the page canvas
            page.getCanvas().drawString("*", font3, PdfBrushes.getRed(), flagX, flagY);
        }

        // Return the updated y-coordinate position after processing the field
        return y + height;
    }

    // This method measures the height of a form field based on its XML node representation.
    private static double measureFieldHeight(Node fieldNode) {
        // Get the field type from the "type" attribute of the field node
        String fieldType = fieldNode.getAttributes().getNamedItem("type").getNodeValue();

        // Set the default height for the field
        double defaultHeight = 16f;

        // Initialize the field type integer value
        int fieldTypeInt = 0;

        // Determine the field type integer value based on the field type string
        if (fieldType.trim().equals("text"))
            fieldTypeInt = 1;
        if (fieldType.trim().equals("password"))
            fieldTypeInt = 2;
        if (fieldType.trim().equals("checkbox"))
            fieldTypeInt = 3;
        if (fieldType.trim().equals("list"))
            fieldTypeInt = 4;

        // Calculate the field height based on the field type
        switch (fieldTypeInt) {
            case 1: // Text field
                // Check if the field supports multiple lines
                if (fieldNode.getAttributes().getNamedItem("multiple") != null) {
                    if ("true" == fieldNode.getAttributes().getNamedItem("multiple").getNodeValue()) {
                        return defaultHeight * 3; // Return three times the default height
                    }
                }
                return defaultHeight;
            case 2: // Password field
                // Check if the field supports multiple lines
                if (fieldNode.getAttributes().getNamedItem("multiple") != null) {
                    if ("true" == fieldNode.getAttributes().getNamedItem("multiple").getNodeValue()) {
                        return defaultHeight * 3; // Return three times the default height
                    }
                }
                return defaultHeight;
            case 3: // Checkbox field
                return defaultHeight;
            case 4: // List field
                // Check if the field supports multiple selections
                if (fieldNode.getAttributes().getNamedItem("multiple") != null) {
                    if ("true" == fieldNode.getAttributes().getNamedItem("multiple").getNodeName()) {
                        return defaultHeight * 3; // Return three times the default height
                    }
                }

                // Get the child nodes of the field node
                NodeList itemNodes = fieldNode.getChildNodes();

                // Check if the number of items is within a certain limit
                if (itemNodes != null && itemNodes.getLength() <= 7) {
                    return defaultHeight * 3; // Return three times the default height
                }
                return defaultHeight;
        }

        // If an invalid field type is encountered, throw an exception
        String message = String.format("Invalid field type: %s", fieldType);
        throw new IllegalArgumentException(message);
    }
}

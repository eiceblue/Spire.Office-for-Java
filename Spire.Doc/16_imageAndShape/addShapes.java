import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class addShapes {
    public static void main(String[] args) throws Exception {
        String output = "output/addShapes.docx";

        // Create a new Document object
        Document doc = new Document();

        // Add a new Section to the document
        Section sec = doc.addSection();

        // Add a new Paragraph to the Section
        Paragraph para = sec.addParagraph();

        // Initialize variables for positioning shapes and counting lines
        int x = 60, y = 40, lineCount = 0;

        // Get a Map of ShapeType enum values and corresponding integers
        Map<ShapeType, Integer> shapeTypes = getShapeTypes();

        // Iterate from 1 to 19 (excluding 20)
        for (int i = 1; i < 20; i++) {
            // Check if the line count is divisible by 8 to determine if a page break is needed
            if (lineCount > 0 && lineCount % 8 == 0) {
                para.appendBreak(BreakType.Page_Break);
                x = 60;
                y = 40;
                lineCount = 0;
            }

            // Append a shape to the paragraph with specified dimensions and shape type
            ShapeObject shape = para.appendShape(50, 50, getShapeType(shapeTypes, i));

            // Set the horizontal origin, position, vertical origin, and position of the shape
            shape.setHorizontalOrigin(HorizontalOrigin.Page);
            shape.setHorizontalPosition(x);
            shape.setVerticalOrigin(VerticalOrigin.Page);
            shape.setVerticalPosition(y + 50);

            // Update the x coordinate for the next shape
            x = x + (int) shape.getWidth() + 50;

            // Check if a new line needs to start based on the number of shapes added
            if (i > 0 && i % 5 == 0) {
                y = y + (int) shape.getHeight() + 120;
                lineCount++;
                x = 60;
            }
        }

        // Save the document to the specified output file
        doc.saveToFile(output, FileFormat.Docx);

        // Clean up resources associated with the document
        doc.dispose();
    }

    // Get the ShapeType enum value based on the given integer value from the Map
    private static ShapeType getShapeType(Map<ShapeType, Integer> types, int value) {
        for (Map.Entry<ShapeType, Integer> entry : types.entrySet()) {
            if (entry.getValue().intValue() == value) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Get a Map of ShapeType enum values and corresponding integers
    private static Map<ShapeType, Integer> getShapeTypes() throws Exception {
        // Get all the ShapeType enum constants and fields
        Object[] enums = ShapeType.class.getEnumConstants();
        Field[] fields = ShapeType.class.getDeclaredFields();

        // Create a Map to store ShapeType and corresponding integer values
        Map<ShapeType, Integer> map = new HashMap<ShapeType, Integer>();

        // Iterate through the fields
        for (int i = 0; i < fields.length; i++) {
            // Skip final fields
            if (Modifier.isFinal(fields[i].getModifiers())) {
				continue;
			}

            // Set the field accessible
            fields[i].setAccessible(true);

            // Check if the field type is int
            if (fields[i].getType() == int.class) {
                // Loop through the enum constants
                for (int j = 0; j < enums.length; j++) {
                    // Get the integer value of the field and put it in the map
                    Object o = fields[i].get(enums[j]);
                    map.put(((ShapeType) enums[j]), (Integer) o);
                }
            }
        }
        return map;
    }
}

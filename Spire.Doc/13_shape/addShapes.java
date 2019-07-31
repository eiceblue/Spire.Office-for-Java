import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.ShapeObject;
import java.lang.reflect.*;
import java.util.*;

public class addShapes {
    public static void main(String[] args) throws Exception {
        //create Word document.
        Document doc = new Document();
        Section sec = doc.addSection();
        Paragraph para = sec.addParagraph();
        int x = 60, y = 40, lineCount = 0;
        //add shape and set its size and position.
        Map<ShapeType,Integer> shapeTypes = getShapeTypes();
        for (int i = 1; i < 20; i++) {
            if (lineCount > 0 && lineCount % 8 == 0) {
                para.appendBreak(BreakType.Page_Break);
                x = 60;
                y = 40;
                lineCount = 0;
            }
            ShapeObject shape = para.appendShape(50, 50, getShapeType(shapeTypes,i));
            shape.setHorizontalOrigin(HorizontalOrigin.Page);
            shape.setHorizontalPosition(x);
            shape.setVerticalOrigin(VerticalOrigin.Page);
            shape.setVerticalPosition(y + 50);
            x = x + (int) shape.getWidth() + 50;
            if (i > 0 && i % 5 == 0) {
                y = y + (int) shape.getHeight() + 120;
                lineCount++;
                x = 60;
            }
        }
        doc.saveToFile("output/addShapes.docx", FileFormat.Docx);
    }
    private static ShapeType getShapeType(Map<ShapeType,Integer> types,int value){
        for (Map.Entry<ShapeType,Integer> entry : types.entrySet()){
            if (entry.getValue().intValue() == value)
                return entry.getKey();
        }
        return null;
    }
    private static Map<ShapeType,Integer> getShapeTypes() throws Exception {
        Object[] enums = ShapeType.class.getEnumConstants();
        Field[] fields = ShapeType.class.getDeclaredFields();
        Map<ShapeType,Integer> map = new HashMap<ShapeType,Integer>();
        for (int i = 0; i < fields.length; i++) {
            if (Modifier.isFinal(fields[i].getModifiers()))
                continue;
            fields[i].setAccessible(true);
            if (fields[i].getType() == int.class) {
                for (int j = 0; j < enums.length; j++) {
                    Object o = fields[i].get(enums[j]);
                    map.put(((ShapeType) enums[j]),(Integer) o);
                }
            }
        }
        return map;
    }
}
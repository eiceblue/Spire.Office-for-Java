import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.awt.*;

public class setTableStyleAndBorder {
    public static void main(String[] args) {

        String inputFile="data/tableSample.docx";
        String outputFile="output/setTableStyleAndBorder.docx";

        //create a document and load file
        Document document = new Document();
        document.loadFromFile(inputFile);

        Section section = document.getSections().get(0);

        //get the first table
        Table table = section.getTables().get(0);

        //apply the table style
        table.applyStyle(DefaultTableStyle.Colorful_List);

        //set right border of table
        table.getTableFormat().getBorders().getRight().setBorderType(BorderStyle.Hairline);
        table.getTableFormat().getBorders().getRight().setLineWidth(1.0F);
        table.getTableFormat().getBorders().getRight().setColor(Color.RED /*Color.getRed()*/);

        //set top border of table
        table.getTableFormat().getBorders().getTop().setBorderType(BorderStyle.Hairline);
        table.getTableFormat().getBorders().getTop().setLineWidth(1.0F);
        table.getTableFormat().getBorders().getTop().setColor(Color.GREEN);

        //set left border of table
        table.getTableFormat().getBorders().getLeft().setBorderType(BorderStyle.Hairline);
        table.getTableFormat().getBorders().getLeft().setLineWidth(1.0F);
        table.getTableFormat().getBorders().getLeft().setColor(Color.YELLOW/*.getYellow()*/);

        //set bottom border to none
        table.getTableFormat().getBorders().getBottom().setBorderType(BorderStyle.Dot_Dash);

        //set vertical and horizontal border
        table.getTableFormat().getBorders().getVertical().setBorderType(BorderStyle.Dot);
        table.getTableFormat().getBorders().getHorizontal().setBorderType(BorderStyle.None);
        table.getTableFormat().getBorders().getVertical().setColor(Color.ORANGE /*.getOrange()*/);

        //save the file
        document.saveToFile(outputFile, FileFormat.Docx);
    }
}

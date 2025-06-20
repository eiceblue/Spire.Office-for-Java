import com.spire.doc.*;
import com.spire.doc.documents.*;
import java.awt.*;

public class setTableStyleAndBorder {
    public static void main(String[] args) {
        String inputFile="data/tableSample.docx";
        String outputFile="output/setTableStyleAndBorder.docx";

		// Create a new document object
		Document document = new Document();

		// Load the document from the specified input file
		document.loadFromFile(inputFile);

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Get the first table in the section
		Table table = section.getTables().get(0);

		// Apply the "Colorful_List" default table style to the table
		table.applyStyle(DefaultTableStyle.Colorful_List);

		// Set the right border of the table to a red hairline with a line width of 1.0F
		table.getTableFormat().getBorders().getRight().setBorderType(BorderStyle.Hairline);
		table.getTableFormat().getBorders().getRight().setLineWidth(1.0F);
		table.getTableFormat().getBorders().getRight().setColor(Color.RED);

		// Set the top border of the table to a green hairline with a line width of 1.0F
		table.getTableFormat().getBorders().getTop().setBorderType(BorderStyle.Hairline);
		table.getTableFormat().getBorders().getTop().setLineWidth(1.0F);
		table.getTableFormat().getBorders().getTop().setColor(Color.GREEN);

		// Set the left border of the table to a yellow hairline with a line width of 1.0F
		table.getTableFormat().getBorders().getLeft().setBorderType(BorderStyle.Hairline);
		table.getTableFormat().getBorders().getLeft().setLineWidth(1.0F);
		table.getTableFormat().getBorders().getLeft().setColor(Color.YELLOW/*.getYellow()*/);

		// Set the bottom border of the table to a dot-dash style
		table.getTableFormat().getBorders().getBottom().setBorderType(BorderStyle.Dot_Dash);

		// Set the vertical borders of the table to a dot style and horizontal borders to none
		table.getTableFormat().getBorders().getVertical().setBorderType(BorderStyle.Dot);
		table.getTableFormat().getBorders().getHorizontal().setBorderType(BorderStyle.None);
		table.getTableFormat().getBorders().getVertical().setColor(Color.ORANGE /*.getOrange()*/);

		// Save the modified document to the specified output file in DOCX format
		document.saveToFile(outputFile, FileFormat.Docx);

		// Dispose the document resources
		document.dispose();
    }
}

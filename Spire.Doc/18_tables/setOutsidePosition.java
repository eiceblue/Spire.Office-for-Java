import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.DocPicture;

public class setOutsidePosition {
    public static void main(String[] args) {
		// Create a new document object
		Document doc = new Document();

		// Add a section to the document
		Section sec = doc.addSection();

		// Get the header of the section
		HeaderFooter header = sec.getHeadersFooters().getHeader();

		// Add a paragraph to the header with left alignment
		Paragraph paragraph = header.addParagraph();
		paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);

		// Add an image to the paragraph
		DocPicture headerimage = paragraph.appendPicture("data/Word.png");

		// Add a table to the header
		Table table = header.addTable();

		// Reset the number of cells in the table to 4 rows and 2 columns
		table.resetCells(4, 2);

		// Set the table's wrap text around property to true
		table.getTableFormat().setWrapTextAround(true);

		// Set the table's horizontal absolute positioning to "Outside" the text area
		table.getTableFormat().getPositioning().setHorizPositionAbs(HorizontalPosition.Outside);

		// Set the table's vertical positioning relative to the margin and set the vertical position to 43 points
		table.getTableFormat().getPositioning().setVertRelationTo(VerticalRelation.Margin);
		table.getTableFormat().getPositioning().setVertPosition(43f);

		// Define the data for the table
		String[][] data = {
				{"Spire.Doc.left", "Spire XLS.right"},
				{"Spire.Presentatio.left", "Spire.PDF.right"},
				{"Spire.DataExport.left", "Spire.PDFViewe.right"},
				{"Spire.DocViewer.left", "Spire.BarCode.right"}
		};

		// Populate the table with data
		for (int r = 0; r < 4; r++) {
			TableRow dataRow = table.getRows().get(r);
			for (int c = 0; c < 2; c++) {
				if (c == 0) {
					// Add a left-aligned paragraph to the cell and set its content and width
					Paragraph par = dataRow.getCells().get(c).addParagraph();
					par.appendText(data[r][c]);
					par.getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
					dataRow.getCells().get(c).setCellWidth(180f,CellWidthType.Point);
				} else {
					// Add a right-aligned paragraph to the cell and set its content and width
					Paragraph par = dataRow.getCells().get(c).addParagraph();
					par.appendText(data[r][c]);
					par.getFormat().setHorizontalAlignment(HorizontalAlignment.Right);
					dataRow.getCells().get(c).setCellWidth(180f,CellWidthType.Point);
				}
			}
		}

		// Specify the output file path
		String output = "output/SetOutsidePosition.docx";

		// Save the document to the specified output file in DOCX format
		doc.saveToFile(output, FileFormat.Docx);

		// Dispose the document resources
		doc.dispose();
    }
}

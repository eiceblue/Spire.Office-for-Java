import com.spire.doc.*;
import com.spire.doc.documents.BorderStyle;
import java.awt.*;
import java.io.*;

public class getDiagonalBorderProperties {
    public static void main(String[] args) throws IOException {
        String input = "data/setDiagonalBorder.docx";
        String output = "output/getDiagonalBorderProperties.txt";

		// Load the document from input file
		Document document = new Document();
		document.loadFromFile(input);

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Get the first table in the section
		Table table = section.getTables().get(0);

		// Get the diagonal down border style, line width, and color of the cell at (0, 0)
		BorderStyle cellBorderStyle_down = table.get(0, 0).getCellFormat().getBorders().getDiagonalDown().getBorderType();
		float cellBorderLineWidth_down = table.get(0, 0).getCellFormat().getBorders().getDiagonalDown().getLineWidth();
		Color cellBorderColor_down = table.get(0, 0).getCellFormat().getBorders().getDiagonalDown().getColor();

		// Get the diagonal up border style, line width, and color of the cell at (3, 2)
		BorderStyle cellBorderStyle_up = table.get(3, 2).getCellFormat().getBorders().getDiagonalUp().getBorderType();
		float cellBorderLineWidth_up = table.get(3, 2).getCellFormat().getBorders().getDiagonalUp().getLineWidth();
		Color cellBorderColor_up = table.get(3, 2).getCellFormat().getBorders().getDiagonalUp().getColor();

		// Generate the result string
		String result = "DiagonalUp BorderStyle: " + cellBorderStyle_up +
						";\r\nDiagonalUp BorderColor: " + cellBorderColor_up +
						";\r\nDiagonalUp BorderLineWidth: " + cellBorderLineWidth_up +
						";\r\nDiagonalDown BorderStyle: " + cellBorderStyle_down +
						";\r\nDiagonalDown BorderColor: " + cellBorderColor_down +
						";\r\nDiagonalDown BorderLineWidth: " + cellBorderLineWidth_down +
						";\r\n";

		// Write the result string to output file
		writeStringToTxt(result, output);

		// Dispose the document resources
		document.dispose();
	}
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        FileWriter fWriter= new FileWriter(txtFileName,true);
        try {
            fWriter.write(content);
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try{
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

import java.io.*;
import java.util.ArrayList;
import com.spire.xls.*;
import com.spire.xls.core.IFont;

public class getListOfFontsUsed {

	public static void main(String[] args) {
		// Create a new workbook object
		Workbook workbook = new Workbook();

		// Load an existing workbook from the specified file path
		workbook.loadFromFile("data/templateAz.xlsx");

		// Create an ArrayList to store the fonts used in the workbook
		ArrayList<IFont> fonts = new ArrayList<IFont>();

		// Iterate through each worksheet in the workbook
		for (int i = 0; i < workbook.getWorksheets().getCount(); i++) {
			// Get the current worksheet
			Worksheet sheet = workbook.getWorksheets().get(i);

			// Iterate through each row in the worksheet
			for (int r = 0; r < sheet.getRows().length; r++) {
				// Iterate through each cell in the row
				for (int c = 0; c < sheet.getRows()[r].getCellList().size(); c++) {
					// Get the font of the current cell and add it to the fonts ArrayList
					fonts.add(sheet.getRows()[r].getCellList().get(c).getStyle().getFont());
				}
			}
		}

		// Create a StringBuilder to store the information about the fonts
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < fonts.size(); i++) {
			// Get the font at the current index
			IFont font = fonts.get(i);

			// Append the font name and size information to the StringBuilder
			strB.append(String.format("FontName:" + font.getFontName() + "; FontSize:" + font.getSize() + "\n"));
		}

		// Specify the file path for the resulting text file
		String result = "output/getListOfFontsUsed_result.txt";
		File file = new File(result);
		try {
			// Create a FileWriter to write the contents to the text file
			FileWriter writer = new FileWriter(file);

			// Write the contents of the StringBuilder to the text file
			writer.write(strB.toString());

			// Close the FileWriter
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		// Release resources associated with the workbook
		workbook.dispose();
	}
}

import java.io.*;
import com.spire.xls.*;
import com.spire.xls.core.ITextBoxShape;

public class getTextBoxByName {

	public static void main(String[] args) {
		// Create a new Workbook object
		Workbook workbook = new Workbook();

		// Get the first Worksheet from the Workbook
		Worksheet sheet = workbook.getWorksheets().get(0);

		// Set the text "Name：" in cell A2
		sheet.getCellRange("A2").setText("Name：");

		// Add a new TextBoxShape to the Worksheet at position (2, 2) with width 18 and height 65
		ITextBoxShape textBox = sheet.getTextBoxes().addTextBox(2, 2, 18, 65);

		// Set the name of the TextBoxShape as "FirstTextBox"
		textBox.setName("FirstTextBox");

		// Set the text content for the TextBoxShape
		textBox.setText("Spire.XLS for Java is a professional Java Excel API that enables developers to create, manage, manipulate, convert and print Excel worksheets without using Microsoft Office or Microsoft Excel.");

		// Retrieve the TextBoxShape named "FirstTextBox" from the Worksheet
		ITextBoxShape FindTextBox = sheet.getTextBoxes().get("FirstTextBox");

		// Get the text content of the TextBoxShape
		String text = FindTextBox.getText();

		// Create a StringBuilder to store the result
		StringBuilder content = new StringBuilder();

		// Create a formatted string with the name of the TextBoxShape and its text content
		String result = String.format("The text of \"" + textBox.getName()+"\" is :"+ text);

		// Append the result to the content StringBuilder
		content.append(result);

		// Specify the output file path
		String outputFile = "output/Output.txt";

		// Create a new File object with the output file path
		File file = new File(outputFile);

		try {
			// Create a FileWriter to write to the output file
			FileWriter writer = new FileWriter(file);

		// Write the content to the output file
			writer.write(content.toString());

		// Close the FileWriter
			writer.close();
		} catch (Exception e) {
			// Print stack trace and error message if an exception occurs
			e.printStackTrace();
			e.getMessage();
		}

		// Dispose the Workbook object
		workbook.dispose();
	}
}

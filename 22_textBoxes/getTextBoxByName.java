import java.io.*;
import com.spire.xls.*;
import com.spire.xls.core.ITextBoxShape;

public class getTextBoxByName {

	public static void main(String[] args) {
		//Create a workbook
		Workbook workbook = new Workbook();
		
		//Get the default first  worksheet
		Worksheet sheet = workbook.getWorksheets().get(0);
		
		//Insert a TextBox
		sheet.getCellRange("A2").setText("Name：");
		ITextBoxShape textBox = sheet.getTextBoxes().addTextBox(2, 2, 18, 65);
		
		//Set the name 
		textBox.setName("FirstTextBox");
		
		//Set string text for TextBox 
		textBox.setText("Spire.XLS for Java is a professional Java Excel API that enables developers to create, manage, manipulate, convert and print Excel worksheets without using Microsoft Office or Microsoft Excel.");
		
		//Get the TextBox by the name
		ITextBoxShape FindTextBox = sheet.getTextBoxes().get("FirstTextBox");
		
		//Get the TextBox text 
		String text = FindTextBox.getText();
		
		//Create StringBuilder to save 
		StringBuilder content = new StringBuilder();
		
		//Set string format for displaying
		String result = String.format("The text of \"" + textBox.getName()+"\" is :"+ text);
		
		//Add result string to StringBuilder
		content.append(result);
		
		//String for output file 
		String outputFile = "output/Output.txt";
		
		//Save them to a txt file
		File file = new File(outputFile);
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(content.toString());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
	}

}

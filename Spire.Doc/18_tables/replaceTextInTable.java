import com.spire.doc.*;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Pattern;

public class replaceTextInTable {
    public static void main(String[] args) {
		// Create a new document object
		Document doc = new Document();

		// Load the document from file "data/ReplaceTextInTable.docx"
		doc.loadFromFile("data/ReplaceTextInTable.docx");

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		// Get the first table in the section
		Table table = section.getTables().get(0);

		// Define a regular expression pattern to match text within curly braces {}
		Pattern regex = Pattern.compile("\\{[^\\}]+\\}", 0);

		// Replace the matched text with "E-iceblue" in the table
		table.replace(regex, "E-iceblue");

		// Replace the exact text "Beijing" with "Component" in the table,
		// ignoring case and allowing partial word matching
		table.replace("Beijing", "Component", false, true);

		// Specify the output file path
		String output = "output/ReplaceTextInTable_out.docx";

		// Save the modified document to the output file in DOCX format (compatible with Word 2013)
		doc.saveToFile(output, FileFormat.Docx_2013);

		// Dispose the document resources
		doc.dispose();
    }
}

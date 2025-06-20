import com.spire.doc.*;
import com.spire.doc.formatting.TablePositioning;

import java.io.*;

public class getTablePosition {
    public static void main(String[] args) throws IOException {
        // Create a new document object
        Document document = new Document();

        // Load the document from file "data/TableSample-Az.docx"
        document.loadFromFile("data/TableSample-Az.docx");

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Get the first table in the section
        Table table = section.getTables().get(0);

        // Create a StringBuilder to store the result
        StringBuilder stringBuilder = new StringBuilder();

        // Check if text wrapping is enabled for the table
        if (table.getTableFormat().getWrapTextAround()) {
            // Get the positioning information for the table
            TablePositioning position = table.getTableFormat().getPositioning();

            // Append horizontal positioning details to the StringBuilder
            stringBuilder.append("Horizontal:");
            stringBuilder.append("\r\n");
            stringBuilder.append("Position: " + position.getHorizPosition() + " pt");
            stringBuilder.append("\r\n");
            stringBuilder.append("Absolute Position: " + position.getHorizPositionAbs() +
                    ", Relative to: " + position.getHorizRelationTo());
            stringBuilder.append("\r\n");

            // Append vertical positioning details to the StringBuilder
            stringBuilder.append("Vertical:");
            stringBuilder.append("\r\n");
            stringBuilder.append("Position: " + position.getVertPosition() + " pt");
            stringBuilder.append("\r\n");
            stringBuilder.append("Absolute Position: " + position.getVertPositionAbs() +
                    ", Relative to: " + position.getVertRelationTo());
            stringBuilder.append("\r\n");
            stringBuilder.append("Distance from surrounding text:");
            stringBuilder.append("\r\n");
            stringBuilder.append("Top: " + position.getDistanceFromTop() + " pt, Left: " + position.getDistanceFromLeft() + " pt");
            stringBuilder.append("\r\n");
            stringBuilder.append("Bottom: " + position.getDistanceFromBottom() + " pt, Right: " + position.getDistanceFromRight() + " pt");
        }

        // Specify the result file path
        String result = "output/GetTablePosition_out.txt";

        // Write the contents of the StringBuilder to the result file
        writeStringToTxt(stringBuilder.toString(), result);

        // Dispose the document resources
        document.dispose();
    }

    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        File file = new File(txtFileName);
        if (file.exists()) {
            file.delete();
        }
        FileWriter fWriter = new FileWriter(txtFileName, true);
        try {
            fWriter.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

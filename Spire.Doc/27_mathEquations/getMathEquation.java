import com.spire.doc.*;
import com.spire.doc.fields.omath.*;

public class GetMathEquation {
    public static void main(String[] args) {
        // Create a new Document object
        Document doc = new Document();

        // Load a Word document
        doc.loadFromFile("data/GetMathEquation.docx");

        // Create a StringBuilder to store the MathML code
        StringBuilder stringBuilder = new StringBuilder();

        // Iterate over sections in the document
        for (int i = 0; i < doc.getSections().getCount(); i++) {
            // Iterate over paragraphs in each section
            for (int j = 0; j < doc.getSections().get(i).getParagraphs().getCount(); j++) {
                // Iterate over child objects in each paragraph
                for (int k = 0; k < doc.getSections().get(i).getParagraphs().get(j).getChildObjects().getCount(); k++) {
                    // Get the current DocumentObject
                    DocumentObject obj = doc.getSections().get(i).getParagraphs().get(j).getChildObjects().get(k);

                    // Check if the object is an OfficeMath equation
                    if (obj instanceof OfficeMath) {
                        // Cast the object to OfficeMath
                        OfficeMath math = (OfficeMath) obj;

                        // Append the MathML code of the equation to the StringBuilder
                        stringBuilder.append(math.toMathMLCode()).append("\n");
                    }
                }
            }
        }

        // Print the collected MathML code
        System.out.println(stringBuilder);

        // Dispose of the document resources
        doc.dispose();
    }
}

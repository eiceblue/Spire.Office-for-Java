import com.spire.pdf.PdfDocument;

public class flattenFormField {
    public static void main(String[] args) {
        String inputFile = "data/flattenFormField.pdf";
        String outputFile = "output/flattenFormField.pdf";

        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);
        //Flatten form fields
        doc.getForm().isFlatten(true);

        doc.saveToFile(outputFile);
        doc.close();
    }
}

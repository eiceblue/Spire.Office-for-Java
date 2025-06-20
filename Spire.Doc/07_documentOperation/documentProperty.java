import com.spire.doc.*;

public class documentProperty {
    public static void main(String[] args) {
        // Specify the input file path.
        String input = "data/summary_of_Science.doc";

        // Specify the output file path.
        String output = "output/documentProperty.docx";

        // Create a new Document object
        Document document = new Document();

        // Load the content of the input document.
        document.loadFromFile(input);

        // Access the built-in document properties and set their values accordingly.
        document.getBuiltinDocumentProperties().setTitle("Document Demo Document");
        document.getBuiltinDocumentProperties().setSubject("demo");
        document.getBuiltinDocumentProperties().setAuthor("James");
        document.getBuiltinDocumentProperties().setCompany("e-iceblue");
        document.getBuiltinDocumentProperties().setManager("Jakson");
        document.getBuiltinDocumentProperties().setCategory("Doc Demos");
        document.getBuiltinDocumentProperties().setKeywords("Document, Property, Demo");
        document.getBuiltinDocumentProperties().setComments("This document is just a demo.");

        // Save the modified document to the specified output file path, in the Docx format.
        document.saveToFile(output, FileFormat.Docx);

        // Dispose the document object to release resources
        document.dispose();
    }
}

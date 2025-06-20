import com.spire.doc.*;

import java.text.DateFormat;
import java.util.Date;

public class setDocumentProperties {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load an existing document from the specified file path
        document.loadFromFile("data/Sample.docx");

        // Set the title property of the document
        document.getBuiltinDocumentProperties().setTitle("Document Demo Document");

        // Set the author property of the document
        document.getBuiltinDocumentProperties().setAuthor("James");

        // Set the company property of the document
        document.getBuiltinDocumentProperties().setCompany("e-iceblue");

        // Set the keywords property of the document
        document.getBuiltinDocumentProperties().setKeywords("Document, Property, Demo");

        // Set the comments property of the document
        document.getBuiltinDocumentProperties().setComments("This document is just a demo.");

        // Get the custom document properties of the document
        CustomDocumentProperties custom = document.getCustomDocumentProperties();

        // Add a custom property named "e-iceblue" with a boolean value
        custom.add("e-iceblue", true);

        // Add a custom property named "Authorized By" with a string value
        custom.add("Authorized By", "John Smith");

        // Create a Date object representing the current date and time
        Date date = new Date();

        // Create a DateFormat instance to format the date
        DateFormat df = DateFormat.getDateInstance();

        // Format the date and add a custom property named "Authorized Date" with the formatted date value
        custom.add("Authorized Date", df.format(date));

        // Specify the output file path
        String result = "output/setDocumentProperties_out.docx";

        // Save the modified document to the specified file path in Docx format
        document.saveToFile(result, FileFormat.Docx);

        // Dispose the document object to release resources
        document.dispose();
    }
}

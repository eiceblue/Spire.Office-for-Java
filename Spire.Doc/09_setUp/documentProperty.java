import com.spire.doc.*;

public class documentProperty {
    public static void main(String[] args) {
        String input = "data/summary_of_Science.doc";
        String output = "output/documentProperty.docx";
        //open a blank Word document as template.
        Document document = new Document(input);
        document.getBuiltinDocumentProperties().setTitle("Document Demo Document");
        document.getBuiltinDocumentProperties().setSubject("demo");
        document.getBuiltinDocumentProperties().setAuthor("James");
        document.getBuiltinDocumentProperties().setCompany("e-iceblue");
        document.getBuiltinDocumentProperties().setManager("Jakson");
        document.getBuiltinDocumentProperties().setCategory("Doc Demos");
        document.getBuiltinDocumentProperties().setKeywords("Document, Property, Demo");
        document.getBuiltinDocumentProperties().setComments("This document is just a demo.");

        //save as docx file.
        document.saveToFile(output, FileFormat.Docx);
    }
}

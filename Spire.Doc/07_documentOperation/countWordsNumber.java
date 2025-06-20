import com.spire.doc.*;
public class countWordsNumber {
    public static void main(String[] args) {
        // Create a new Document object.
        Document document = new Document();

        // Load the document from file "Template_Docx_1.docx".
        document.loadFromFile("data/Template_Docx_1.docx");

        // Retrieve the character count of the document (excluding spaces).
        int charCount = document.getBuiltinDocumentProperties().getCharCount();

        // Retrieve the character count of the document (including spaces).
        int charCountWithSpace = document.getBuiltinDocumentProperties().getCharCountWithSpace();

        // Retrieve the word count of the document.
        int wordCount = document.getBuiltinDocumentProperties().getWordCount();

        // Print the character count, character count with spaces, and word count to the console.
        System.out.println("CharCount: " + charCount + "\n CharCountWithSpace: " + charCountWithSpace + "\nWordCount: " + wordCount);

        // Dispose the document object to release resources
        document.dispose();
    }
}

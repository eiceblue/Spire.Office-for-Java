import com.spire.doc.*;
public class getDocumentProperties {
    public static void main(String[] args) {
        // Create a new Document object.
        Document document = new Document();

        // Load the content of the document from file "Properties.docx".
        document.loadFromFile("data/Properties.docx");

        // Create a StringBuilder object to store the content.
        StringBuilder content = new StringBuilder();

        // Retrieve specific built-in document properties and store their values in variables.
        String title = document.getBuiltinDocumentProperties().getTitle();
        String comments = document.getBuiltinDocumentProperties().getComments();
        String author = document.getBuiltinDocumentProperties().getAuthor();
        String keywords = document.getBuiltinDocumentProperties().getKeywords();
        String company = document.getBuiltinDocumentProperties().getCompany();

        // Build a formatted result string with the retrieved built-in document properties.
        String result = String.format("The Builtin document properties:\r\nTitle: " + title + ".\r\nComments: " + comments + ".\r\nAuthor: " + author + ".\r\nKeywords: " + keywords + ".\r\nCompany: " + company);

        // Append the result string to the content StringBuilder.
        content.append(result + "\r\nThe custom document properties:");

        // Iterate through the custom document properties and retrieve and append their names and values to the content.
        for (int i = 0; i < document.getCustomDocumentProperties().getCount(); i++) {
            String customProperties = String.format(document.getCustomDocumentProperties().get(i).getName() + ": " + document.getCustomDocumentProperties().get(i).getValue());
            content.append(customProperties);
        }

        // Print the final content to the console.
        System.out.println(content);

        // Dispose the document object to release resources
        document.dispose();
    }
}

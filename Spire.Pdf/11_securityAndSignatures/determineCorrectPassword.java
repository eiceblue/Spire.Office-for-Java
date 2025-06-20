import com.spire.pdf.PdfDocument;

public class determineCorrectPassword {
    public static void main(String[] args){
        // Specify the input file path
        String input = "data/decryption.pdf";

        // Define an array of passwords to try for decryption
        String[] passwords = new String[]{"password1", "password2", "password3", "test", "sample"};

        // Iterate through each password in the array
        for (int passwordCount = 0; passwordCount < passwords.length; passwordCount++) {
            // Create a new PdfDocument object
            PdfDocument doc = new PdfDocument();
            try {
                // Load the PDF document from the input file path using the current password
                doc.loadFromFile(input, passwords[passwordCount]);
                System.out.println("Password = " + passwords[passwordCount] + " is correct");
            } catch (Exception ex) {
                System.out.println("Password = " + passwords[passwordCount] + " is not correct");
            } finally {
                // Close the PDF document to release resources
                doc.close();
                // Dispose of the PDF document to free up system resources
                doc.dispose();
            }
        }
    }
}

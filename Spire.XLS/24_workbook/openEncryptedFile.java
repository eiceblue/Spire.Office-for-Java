import com.spire.xls.*;

public class openEncryptedFile {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "data/encryptedFile.xlsx";

        // Define a password array
        String[] passwords = new String[]{"password1", "password2", "password3", "1234"};

        // Iterate through the password array
        for (int i = 0; i < passwords.length; i++) {
            try {
                // Create Workbook objects
                Workbook workbook = new Workbook();

                // Set the open password
                workbook.setOpenPassword(passwords[i]);

                // Load the Workbook object from the file
                workbook.loadFromFile(filePath);

                // Output the correct password and successful opening of the encrypted Excel file message
                System.out.println("Password = " + passwords[i] + " is correct." + " The encrypted Excel file opened successfully!");

                // Free the resources of the Workbook object
                workbook.dispose();
            } catch (Exception ex) {
                // Output an incorrect password message
                System.out.println("Password = " + passwords[i] + " is not correct");
            }
        }
    }
}

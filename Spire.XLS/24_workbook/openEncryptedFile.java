import com.spire.xls.*;

public class openEncryptedFile {
    public static void main(String[] args) {
        // File path
        String filePath = "data/encryptedFile.xlsx";

        String[] passwords = new String[]{"password1", "password2", "password3", "1234"};
        for (int i = 0; i < passwords.length; i++) {
            try {
                // Create a workbook
                Workbook workbook = new Workbook();

                // Open password
                workbook.setOpenPassword(passwords[i]);

                // Load the document
                workbook.loadFromFile(filePath);

                System.out.println("Password = " + passwords[i] + " is correct."
                        + " The encrypted Excel file opened successfully!");
            } catch (Exception ex) {
                System.out.println("Password = " + passwords[i] + "  is not correct");
            }
        }

    }
}

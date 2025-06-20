import com.spire.xls.*;

public class checkPasswordProtection {
    public static void main(String[] args) {
        // Create a Workbook instance
        Workbook workbook = new Workbook();

        // Load the Excel document
        workbook.loadFromFile("data/checkPassProtected.xlsx");

        // Get the first worksheet
        Worksheet worksheet = workbook.getWorksheets().get(0);

        // Verify the given password is correct or not
        boolean isCorrect = worksheet.checkProtectionPassword("e-iceblue");

        // If true...
        if (isCorrect){
            System.out.println("the given password is correct");
        }

        // Dispose the workbook
        workbook.dispose();
    }
}

import com.spire.xls.*;

public class readHyperlinks {
    public static void main(String[] args) {
        String inputFile="data/readHyperlinks.xlsx";

        // Create a new instance of Workbook
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Print the address of the first hyperlink in the worksheet
        System.out.println("The first link is " + sheet.getHyperLinks().get(0).getAddress());

        // Print the address of the second hyperlink in the worksheet
        System.out.println("The second link is " + sheet.getHyperLinks().get(1).getAddress());

        // Print the address of the third hyperlink in the worksheet
        System.out.println("The third link is " + sheet.getHyperLinks().get(2).getAddress());

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}

import com.spire.xls.*;

public class verifyProtectedWorksheet {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/protectedWorksheet.xlsx");

        //Get the first worksheet
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Verify the first worksheet 
        boolean detect = worksheet.isPasswordProtected();

        //Print the result
        System.out.println("The first worksheet is password protected or not: " + (detect == true ? "Yes!" : "No!"));

    }
}

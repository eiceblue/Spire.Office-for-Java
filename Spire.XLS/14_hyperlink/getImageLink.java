import com.spire.xls.*;

public class getImageLink {
    public static void main(String[] args) {
        // Create a Workbook instance
        Workbook workbook = new Workbook();

        // Load the Excel document
        workbook.loadFromFile("data/hyperlink.xlsx");

        // Get the first worksheet
        Worksheet worksheet = workbook.getWorksheets().get(0);

        // Get the first picture
        ExcelPicture picture = worksheet.getPictures().get(0);

        // Get the hyperlink address of this picture
        String address = picture.getHyperLink().getAddress();

        // output this address
        System.out.println(address);

        // Dispose the workbook
        workbook.dispose();
    }
}

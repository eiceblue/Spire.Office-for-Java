import com.spire.xls.*;

public class addImageHyperlink {
    public static void main(String[] args) {
        // Create a new instance of Workbook
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the width of column 1 (A) to 22 units
        sheet.setColumnWidth(1, 22);

        // Set the text of cell A1 to "Image Hyperlink"
        sheet.getCellRange("A1").setText("Image Hyperlink");

        // Set the vertical alignment of the cell style in cell A1 to Top
        sheet.getCellRange("A1").getStyle().setVerticalAlignment(VerticalAlignType.Top);

        // Specify the file path for the image to be added
        String picPath = "data/imageSample.png";

        // Add an image picture to the worksheet at row 2, column 1 (B)
        ExcelPicture picture = sheet.getPictures().add(2, 1, picPath);

        // Set the hyperlink for the picture to "https://www.e-iceblue.com/Tutorials/Java/Spire.XLS-for-Java.html"
        picture.setHyperLink("https://www.e-iceblue.com/Tutorials/Java/Spire.XLS-for-Java.html", true);

        // Specify the output file path for the modified workbook
        String output = "output/addImageHyperlink_result.xlsx";

        // Save the modified workbook to the specified output file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}

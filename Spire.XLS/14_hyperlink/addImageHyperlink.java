import com.spire.xls.*;

public class addImageHyperlink {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add the description text
        sheet.setColumnWidth(1,22);
        sheet.getCellRange("A1").setText("Image Hyperlink");
        sheet.getCellRange("A1").getStyle().setVerticalAlignment(VerticalAlignType.Top);

        //Insert an image to a specific cell
        String picPath = "data/imageSample.png";
        ExcelPicture picture = sheet.getPictures().add(2, 1, picPath);
        //Add a hyperlink to the image
        picture.setHyperLink("https://www.e-iceblue.com/Tutorials/Java/Spire.XLS-for-Java.html", true);

        //Save the document
        String output = "output/addImageHyperlink_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}

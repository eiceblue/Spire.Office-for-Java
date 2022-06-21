import com.spire.xls.*;

public class pictureOffset {

    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add an image to the specific cell
        ExcelPicture pic = sheet.getPictures().add(2, 2,"data/SpireXls.png");

        //Set left offset and top offset from the current range
        pic.setLeftColumnOffset(200);
        pic.setTopRowOffset(100);

        //Save the result file
        workbook.saveToFile("output/pictureOffset.xlsx", ExcelVersion.Version2010);

    }
}

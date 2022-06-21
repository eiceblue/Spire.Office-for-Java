import com.spire.xls.*;

public class writeImages {

    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/WriteImages.xlsx");
        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add an image to the specific cell
        sheet.getPictures().add(14, 5,"data/SpireXls.png");

        //Save the result file
        workbook.saveToFile("output/WriteImages.xlsx", ExcelVersion.Version2010);

    }
}

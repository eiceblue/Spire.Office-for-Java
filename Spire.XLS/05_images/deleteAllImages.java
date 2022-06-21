import com.spire.xls.*;
import com.spire.xls.collections.PicturesCollection;

public class deleteAllImages {

    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/images.xlsx");

        //Get the first worksheet
        Worksheet sheet1 = workbook.getWorksheets().get(0);


        //Get pictures from the first worksheet
        PicturesCollection Pictures = sheet1.getPictures();

        //Delete all images in the worksheet.
        for (int i = Pictures.getCount() - 1; i >= 0; i--)
        {
            Pictures.get(i).remove();
        }

        //String for output file
        String outputFile = "output/deleteAllImages.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

    }
}

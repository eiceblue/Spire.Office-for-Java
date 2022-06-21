import com.spire.xls.*;

public class locateImages {

    public static void main(String[] args){
        //Create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/LocateImages.xlsx");

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the first image in the sheet
        ExcelPicture pic = sheet.getPictures().get(0);
        //Set the position
        pic.setLeftColumnOffset(300);
        pic.setTopRowOffset(300);

        //Save the result file
        workbook.saveToFile("output/LocateImages.xlsx", ExcelVersion.Version2010);

    }
}

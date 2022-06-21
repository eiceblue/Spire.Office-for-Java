import com.spire.xls.*;

public class pageBreakPreview {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/template_Xls_4.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the scale of PageBreakView mode in Excel file.
        sheet.setZoomScalePageBreakView(80);

        String result = "output/pageBreakPreview_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}

import com.spire.xls.*;
import com.spire.data.table.*;

public class xlsb {
    public static void main(String[] args) throws Exception {
        String  inputFile = "data/XLSB.xlsb";
        //Export the first sheet data to dataTable
        DataTable datatable=ToDataTable(inputFile,0);
        //create a workbook
        Workbook workbook = new Workbook();
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        //Insert datatable
        sheet.insertDataTable(datatable,true,1,1,-1,-1);
        //Set body style
        CellStyle oddStyle = workbook.getStyles().addStyle("oddStyle");
        oddStyle.getBorders().getByBordersLineType(BordersLineType.EdgeLeft).setLineStyle(LineStyleType.Thin);
        oddStyle.getBorders().getByBordersLineType(BordersLineType.EdgeRight).setLineStyle(LineStyleType.Thin);
        oddStyle.getBorders().getByBordersLineType(BordersLineType.EdgeTop).setLineStyle(LineStyleType.Thin);
        oddStyle.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setLineStyle(LineStyleType.Thin);
        oddStyle.setKnownColor(ExcelColors.LightGreen1);
        CellStyle evenStyle = workbook.getStyles().addStyle("evenStyle");
        evenStyle.getBorders().getByBordersLineType(BordersLineType.EdgeLeft).setLineStyle(LineStyleType.Thin);
        evenStyle.getBorders().getByBordersLineType(BordersLineType.EdgeRight).setLineStyle(LineStyleType.Thin);
        evenStyle.getBorders().getByBordersLineType(BordersLineType.EdgeTop).setLineStyle(LineStyleType.Thin);
        evenStyle.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setLineStyle(LineStyleType.Thin);
        evenStyle.setKnownColor(ExcelColors.LightTurquoise);
        for (CellRange range : sheet.getAllocatedRange().getRows())
        {
            if (range.getRow() % 2 == 0)
                range.setCellStyleName(evenStyle.getName());
            else
                range.setCellStyleName(oddStyle.getName());
        }
        //Set header style
        CellStyle styleHeader = sheet.getRows()[0].getCellStyle();
        styleHeader.getBorders().getByBordersLineType(BordersLineType.EdgeLeft).setLineStyle(LineStyleType.Thin);
        styleHeader.getBorders().getByBordersLineType(BordersLineType.EdgeRight).setLineStyle(LineStyleType.Thin);
        styleHeader.getBorders().getByBordersLineType(BordersLineType.EdgeTop).setLineStyle(LineStyleType.Thin);
        styleHeader.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setLineStyle(LineStyleType.Thin);
        styleHeader.setVerticalAlignment(VerticalAlignType.Center);
        styleHeader.setKnownColor(ExcelColors.Green);
        styleHeader.getExcelFont().setKnownColor(ExcelColors.White);
        styleHeader.getExcelFont().isBold(true);
        sheet.getAllocatedRange().autoFitColumns();
        sheet.getAllocatedRange().autoFitRows();
        sheet.getRows()[0].setRowHeight(20);
        workbook.saveToFile("output/XLSB.xlsb", ExcelVersion.Xlsb2010);
    }
    private static DataTable ToDataTable (String inputFile, int worksheet) {
        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);
        //Export the first sheet data to dataTable
        Worksheet sheet = workbook.getWorksheets().get(worksheet);
        return sheet.exportDataTable();
    }
}

import com.spire.xls.*;

public class getCategoryLabels {
    public static void main(String[] args) throws Exception {
        String input = "data/SampeB_4.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the fisrt sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the chart
        Chart chart = sheet.getCharts().get(0);

        //get the cell range of the category labels
        CellRange cr = chart.getPrimaryCategoryAxis().getCategoryLabels();

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<cr.getCount();i++)
        {
            CellRange cell = cr.getCellList().get(i);
            sb.append(cell.getValue() + "\r\n");
        }
        //print out result
        System.out.println(sb.toString());
    }
}

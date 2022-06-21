import com.spire.xls.*;

public class traverseCellsValue {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/CellValues.xlsx");

        //Get first worksheet of the workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Get the cell range collection
        CellRange[] cellRangeCollection = worksheet.getCells();

        //Create StringBuilder to save
        StringBuilder content = new StringBuilder();
        content.append("Values of the first sheet:"+"\n");

        //Traverse cells value
        for(CellRange cellRange : cellRangeCollection)
        {
            //Set string format for displaying
            String result = String.format("Cell: " + cellRange.getRangeAddress() + "   Value: " + cellRange.getValue());

            //Add result string to StringBuilder
            content.append(result+"\n");
        }
       System.out.println(content);
    }
}

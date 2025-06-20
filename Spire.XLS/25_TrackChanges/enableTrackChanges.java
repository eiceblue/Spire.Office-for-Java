import com.spire.xls.*;

public class enableTrackChanges {
    public static void main(String[] args) {

        String inputFile = "data/textAlign.xlsx";
        String outputFile = "openRevision.xlsx";

		//Create a new Document object
        Workbook workbook = new Workbook();
		
		// Load the xls file
        workbook.loadFromFile(inputFile);
		
        //Enable tracking changes
        workbook.setTrackedChanges(true);
		
		//Save to file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
		
		//Dispose
        workbook.dispose();
    }
}

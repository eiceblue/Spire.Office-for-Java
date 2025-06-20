import com.spire.xls.*;

public class acceptOrRejectTrackedChanges {
    public static void main(String[] args) {

        String inputFile = "data/TrackChanges.xlsx";
        String outputFile = "TrackChanges_out.xlsx";

		//Create a new Document object
        Workbook workbook = new Workbook();
		
		// Load the xls file
        workbook.loadFromFile(inputFile);
		
        // Accept the changes or reject the changes.
        //workbook.acceptAllTrackedChanges();
        workbook.rejectAllTrackedChanges();
		
		//Save to file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
		
		//Dispose
        workbook.dispose();
    }
}

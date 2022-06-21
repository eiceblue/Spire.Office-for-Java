import com.spire.xls.*;

public class toPostScript {

	public static void main(String[] args) {
	    //Create a workbook
        Workbook workbook = new Workbook();

        //Load an excel document
        workbook.loadFromFile("data/ToPostScript.xlsx");

        String result = "output/ToPostScript.ps";
        //Convert to PS file
        workbook.saveToFile(result, FileFormat.PostScript);
	}

}

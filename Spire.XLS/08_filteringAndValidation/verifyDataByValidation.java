import com.spire.xls.*;
import java.io.*;

public class verifyDataByValidation {
    public static void main(String[] args)throws Exception {
        String input = "data/Sample.xlsx";
        String output = "output/verifyDataByValidation.txt";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the Excel document from disk
        workbook.loadFromFile(input);

        //get first worksheet of the workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //cell B4 has the Decimal Validation
        CellRange cell = worksheet.getRange().get("B4");

        //get the valditation of this cell
        Validation validation = cell.getDataValidation();

        //get the specified data range
        Double minimum = Double.parseDouble(validation.getFormula1());
        Double maximum = Double.parseDouble(validation.getFormula2());

        //create StringBuilder to save
        StringBuilder content = new StringBuilder();

        //set different numbers for the cell
        for (int i = 5; i < 100; i=i+40 )
        {
            cell.setNumberValue((double)i);
            String result=null;
            //verify
            if (cell.getNumberValue() < minimum || cell.getNumberValue()> maximum)
            {
                //set string format for displaying
                result = String.format("Is input "+ i +" a valid value for this Cell: false\r\n");
            }
            else
            {
                //set string format for displaying
                result = String.format("Is input " + i + " a valid value for this Cell: true\r\n");
            }
            //add result string to StringBuilder
            content.append(result);
        }
        //save them to a txt file
        writeStringToTxt( content.toString(),output);
    }
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        FileWriter fWriter= new FileWriter(txtFileName,true);
        try {
            fWriter.write(content);
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try{
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}

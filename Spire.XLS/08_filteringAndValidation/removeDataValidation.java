import com.spire.xls.*;

import java.awt.*;

public class removeDataValidation {
    public static void main(String[] args) {
        String inputFilePath="data/removeDataValidation.xlsx";
        String outputFilePath="output/removeDataValidation_out.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFilePath);

        //Create an array of rectangles, which is used to locate the ranges in worksheet.
        Rectangle[] rectangles = new Rectangle[1];

        //Assign value to the first element of the array. This rectangle specifies the cells from A1 to B3.
        rectangles[0] = new Rectangle(0, 0, 1, 2);

        //Remove validations in the ranges represented by rectangles.
        workbook.getWorksheets().get(0).getDVTable().remove(rectangles);

        //Save to file.
        workbook.saveToFile(outputFilePath, ExcelVersion.Version2013);
    }

}

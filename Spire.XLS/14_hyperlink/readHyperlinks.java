import com.spire.xls.*;

public class readHyperlinks {
    public static void main(String[] args) {
        String inputFile="data/readHyperlinks.xlsx";

        //Open xls document
        Workbook workbook = new Workbook();
        workbook.loadFromFile( inputFile);
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        //Print out the comment
        System.out.println("The first link is " + sheet.getHyperLinks().get(0).getAddress());
        System.out.println("The second link is " + sheet.getHyperLinks().get(1).getAddress());
        System.out.println("The third link is " + sheet.getHyperLinks().get(2).getAddress());
    }
}

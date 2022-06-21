import com.spire.xls.*;

public class XlsToETT {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/Sample.xls");
        workbook.saveToFile("output/XlsToETT.ett", FileFormat.ETT);
    }
}

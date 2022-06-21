import com.spire.xls.*;

public class XlsToET {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/Sample.xls");
        workbook.saveToFile("output/XlsToET.et", FileFormat.ET);
    }
}

import com.spire.xls.*;

public class ETtoXls {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/Sample.et");
        workbook.saveToFile("output/ETtoXls.xls", FileFormat.Version97to2003);
    }
}

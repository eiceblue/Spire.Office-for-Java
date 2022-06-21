import com.spire.xls.*;

public class ETTtoXls {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/Sample.ett");
        workbook.saveToFile("output/ETTtoXls.xls", FileFormat.Version97to2003);
    }
}

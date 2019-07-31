import com.spire.pdf.PdfDocument;
import java.io.FileWriter;

public class getNumberOfPages {
    public static void main(String[] args) throws Exception {
        PdfDocument pdf = new PdfDocument("data/getNumberOfPages.pdf");
        int count = pdf.getPages().getCount();
        String outputFile = "output/GetNumberOfPages.txt";
        FileWriter writer = new FileWriter(outputFile);
        writer.write("PagesCount:" + String.valueOf(count));
        writer.flush();
        writer.close();
        pdf.close();
    }
}

import com.spire.pdf.conversion.PdfStandardsConverter;

public class toPDFA {
    public static void main(String[] args) {
        // Create a PdfStandardsConverter instance for the input PDF document "sample.pdf"
        PdfStandardsConverter converter = new PdfStandardsConverter("sample.pdf");

        // Convert the input PDF to PDF/A-1A standard and save it as "ToPdfA1A.pdf"
        converter.toPdfA1A("ToPdfA1A.pdf");

        // Convert the input PDF to PDF/A-1B standard and save it as "ToPdfA1B.pdf"
        converter.toPdfA1B("ToPdfA1B.pdf");

        // Convert the input PDF to PDF/A-2A standard and save it as "ToPdfA2A.pdf"
        converter.toPdfA2A("ToPdfA2A.pdf");

        // Convert the input PDF to PDF/A-2B standard and save it as "ToPdfA2B.pdf"
        converter.toPdfA2B("ToPdfA2B.pdf");

        // Convert the input PDF to PDF/A-3A standard and save it as "ToPdfA3A.pdf"
        converter.toPdfA3A("ToPdfA3A.pdf");

        // Convert the input PDF to PDF/A-3B standard and save it as "ToPdfA3B.pdf"
        converter.toPdfA3B("ToPdfA3B.pdf");
    }
}

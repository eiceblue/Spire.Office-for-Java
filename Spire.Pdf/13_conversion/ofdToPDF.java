import com.spire.pdf.conversion.OfdConverter;

public class ofdToPDF {
    public static void main(String[] args) {
        // Path to the input OFD file
        String inputFile = "data/ofdToPDFSample.ofd";

        // Path to the output PDF file
        String ouputFile = "output/ofdToPDF_out.pdf";

        // Create an instance of OfdConverter with the input file
        OfdConverter ofdConverter = new OfdConverter(inputFile);

        // Convert the OFD file to PDF using the specified output file path
        ofdConverter.toPdf(ouputFile);

        // Dispose of the resources used by the OfdConverter
        ofdConverter.dispose();
    }
}

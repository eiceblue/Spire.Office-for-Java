import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import java.io.*;

public class extract3DVideoFile {
    public static void main(String[] args)throws Exception {

        // Load the old PDF from disk
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("data/3D.pdf");

        // Get the first page of the document
        PdfPageBase firstPage = pdf.getPages().get(0);

        // Get the annotation collection of the first page
        PdfAnnotationCollection annot = firstPage.getAnnotationsWidget();

        // Define a counter variable to track the number of 3D annotations
        int count = 0;

        // Traverse the annotations
        for (int i = 0; i < annot.getList().size(); i++) {
            // Check if it is a Pdf3DAnnotation
            if (annot.get(i) instanceof Pdf3DAnnotation) {
                Pdf3DAnnotation annot3D = (Pdf3DAnnotation) annot.get(i);

                // Get the 3D video data
                byte[] bytes = annot3D.get3DData();

                // Write the data into a .u3d format file
                if (bytes != null) {
                    String output = String.format("output/3d-%d.u3d", count);
                    byteArrayToFile(bytes, output);
                    count++;
                }
            }
        }

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
	
	
        public static void byteArrayToFile(byte[] datas, String destPath) {
        // Create a File object representing the destination file
        File dest = new File(destPath);

        try (
                // Create an InputStream from the byte array using ByteArrayInputStream
                InputStream is = new ByteArrayInputStream(datas);
                // Create an OutputStream for writing bytes to the destination file
                OutputStream os = new BufferedOutputStream(new FileOutputStream(dest, false));
        ) {
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                // Write the bytes read from the input stream to the output stream
                os.write(flush, 0, len);
            }
            // Flush the output stream to ensure all bytes are written to the file
            os.flush();
        } catch (IOException e) {
            // Handle any IO exceptions that may occur during the process
            e.printStackTrace();
        }
    }
}


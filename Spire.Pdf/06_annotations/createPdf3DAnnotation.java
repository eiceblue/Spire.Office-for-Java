import com.spire.pdf.*;
import com.spire.pdf.annotations.*;
import com.spire.pdf.graphics.*;
import java.awt.*;

public class createPdf3DAnnotation {
    public static void main(String[] args) throws Exception{
        /// Create a new PDF document
        PdfDocument pdf = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = pdf.getPages().add();

        // Define a rectangle to draw the canvas area for the 3D file
        Rectangle rt = new Rectangle(0, 80, 200, 200);

        // Create a new Pdf3DAnnotation object and load the .u3d file as the 3D annotation
        Pdf3DAnnotation annotation = new Pdf3DAnnotation(rt, "data/template_az.pdf");

        // Set the activation properties for the 3D annotation
        annotation.setActivation(new Pdf3DActivation());
        annotation.getActivation().setActivationMode(Pdf3DActivationMode.Page_Open);

        // Create a Pdf3DView object and set its properties
        Pdf3DView view = new Pdf3DView();
        // Set the background color for the 3D view
        view.setBackground(new Pdf3DBackground(new PdfRGBColor(128, 0, 128)));

        // Set a name for the view node
        view.setViewNodeName("3DAnnotation");

        // Set the render mode for the 3D view
        view.setRenderMode(new Pdf3DRendermode(Pdf3DRenderStyle.Solid));

        // Set an internal name for the 3D view
        view.setInternalName("3DAnnotation");

        // Set the lighting scheme for the 3D view
        view.setLightingScheme(new Pdf3DLighting());

        // Set the lighting style within the lighting scheme
        view.getLightingScheme().setStyle(Pdf3DLightingStyle.Day);

        // Add the view to the annotation
        annotation.getViews().add(view);

        // Add the annotation to the page
        ((PdfNewPage) page).getAnnotations().add(annotation);

        String outputFile = "output/createPdf3DAnnotation_out.pdf";
        // Save the PDF document
        pdf.saveToFile(outputFile);

        // Close the PDF document
        pdf.close();

        // Dispose of the PDF document (frees up system resources)
        pdf.dispose();
    }
}

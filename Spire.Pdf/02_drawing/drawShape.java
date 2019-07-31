import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class drawShape {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        PdfPageBase page = doc.getPages().add();
        // Draw shape
        drawSpiral(page);
        drawPath(page);;
        drawPie(page);
        drawRectangle(page);
        drawEllipse(page);

        // Save pdf file
        doc.saveToFile("output/drawShape.pdf");
        // Close pdf file
        doc.close();
    }

    static void drawPath(PdfPageBase page)
    {
        Point2D[] points = new Point2D.Float[5];
        for (int i = 0; i < points.length; i++)
        {
            float x = (float)Math.cos(i * 2 * Math.PI / 5);
            float y = (float)Math.sin(i * 2 * Math.PI / 5);
            points[i] = new Point2D.Float(x, y);
        }
        PdfPath path = new PdfPath();
        path.addLine(points[2], points[0]);
        path.addLine(points[0], points[3]);
        path.addLine(points[3], points[1]);
        path.addLine(points[1], points[4]);
        path.addLine(points[4], points[2]);

        //save graphics state
        PdfGraphicsState state = page.getCanvas().save();
        PdfPen pen = new PdfPen(new PdfRGBColor(new Color(0,191,255)), 0.02f);
        PdfBrush brush1 = new PdfSolidBrush(new PdfRGBColor(new Color(95,158,160)));


        page.getCanvas().scaleTransform(50f, 50f);
        page.getCanvas().translateTransform(5f, 1.2f);
        page.getCanvas().drawPath(pen, path);

        page.getCanvas().translateTransform(2f, 0f);
        path.setFillMode(PdfFillMode.Alternate);
        page.getCanvas().drawPath(pen, brush1, path);

        page.getCanvas().translateTransform(2f, 0f);
        path.setFillMode(PdfFillMode.Winding);
        page.getCanvas().drawPath(pen, brush1, path);
        PdfLinearGradientBrush brush2 = new PdfLinearGradientBrush(new Point2D.Float(-2, 0), new Point2D.Float(2, 0), new PdfRGBColor(Color.red), new PdfRGBColor(Color.blue));

        page.getCanvas().translateTransform(-4f, 2f);
        path.setFillMode(PdfFillMode.Alternate);
        page.getCanvas().drawPath(pen, brush2, path);

        PdfRadialGradientBrush brush3 = new PdfRadialGradientBrush(new Point2D.Float(0f, 0f), 0f, new Point2D.Float(0f, 0f), 1f, new PdfRGBColor(Color.red), new PdfRGBColor(Color.blue));
        page.getCanvas().translateTransform(2f, 0f);
        path.setFillMode(PdfFillMode.Winding);
        page.getCanvas().drawPath(pen, brush3, path);

        PdfTilingBrush brush4 = new PdfTilingBrush(new Rectangle2D.Float(0, 0, 4f, 4f));
        brush4.getGraphics().drawRectangle(brush2, 0, 0, 4f, 4f);

        page.getCanvas().translateTransform(2f, 0f);
        path.setFillMode(PdfFillMode.Winding);
        page.getCanvas().drawPath(pen, brush4, path);

        //restore graphics
        page.getCanvas().restore(state);
    }

    static void drawSpiral(PdfPageBase page)
    {
        //Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        //Draw shape - spiral
        PdfPen pen = PdfPens.getDeepSkyBlue();

        int nPoints = 1000;
        double r1 = 30;
        double r2 = 25;
        double p = 35;
        double x1 = r1 + r2 - p;
        double y1 = 0;
        double x2 = 0;
        double y2 = 0;

        page.getCanvas().translateTransform(100, 100);

        for (int i = 0; i < nPoints; i++)
        {
            double t = i * Math.PI / 90;
            x2 = (r1 + r2) * Math.cos(t) - p * Math.cos((r1 + r2) * t / r2);
            y2 = (r1 + r2) * Math.sin(t) - p * Math.sin((r1 + r2) * t / r2);
            page.getCanvas().drawLine(pen, (float)x1, (float)y1, (float)x2, (float)y2);
            x1 = x2;
            y1 = y2;
        }

        //Restore graphics
        page.getCanvas().restore(state);
    }

    static void drawPie(PdfPageBase page)
    {
        //Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        PdfPen pen = new PdfPen(new PdfRGBColor(new Color(139,0,0)), 2f);
        page.getCanvas().drawPie(pen, 220, 320, 100, 90, 360, 360);

        //Restore graphics
        page.getCanvas().restore(state);
    }

    static void drawRectangle(PdfPageBase page)
    {
        //Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        PdfPen pen = new PdfPen(new PdfRGBColor(new Color(210,105,30)), 1f);
        page.getCanvas().drawRectangle(pen, new Rectangle(new Point(20, 310), new Dimension(150, 120)));

        //Restore graphics
        page.getCanvas().restore(state);
    }

    static void drawEllipse(PdfPageBase page)
    {
        //Save graphics state
        PdfGraphicsState state = page.getCanvas().save();

        PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(new Color(95,158,160)));
        page.getCanvas().drawEllipse(brush, 380, 325, 80, 80);

        //Restore graphics
        page.getCanvas().restore(state);
    }
}


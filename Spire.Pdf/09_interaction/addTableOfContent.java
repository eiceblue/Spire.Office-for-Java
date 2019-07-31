import com.spire.pdf.*;
import com.spire.pdf.actions.PdfGoToAction;
import com.spire.pdf.annotations.*;
import com.spire.pdf.general.PdfDestination;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;


public class addTableOfContent {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument("data/addTableOfContent.pdf");
        int pageCount = doc.getPages().getCount();
        PdfPageBase tocPage = doc.getPages().insert(0);
        //Set title
        String title = "Table Of Contents";
        PdfTrueTypeFont titleFont = new PdfTrueTypeFont(new Font("Arial",  Font.BOLD,20));
        PdfStringFormat centerAlignment = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);
        Point2D location = new Point2D.Float((float) tocPage.getCanvas().getClientSize().getWidth() / 2, (float) titleFont.measureString(title).getHeight());
        tocPage.getCanvas().drawString(title, titleFont, PdfBrushes.getCornflowerBlue(), location, centerAlignment);
        //Draw TOC text
        PdfTrueTypeFont titlesFont = new PdfTrueTypeFont(new Font("Arial", Font.PLAIN,14));
        String[] titles = new String[pageCount];
        for (int i = 0; i < titles.length; i++) {
            titles[i] = String.format("This is page%1$s", i + 1);
        }
        float y = (float)titleFont.measureString(title).getHeight() + 10;
        float x = 0;
        for (int i = 1; i <= pageCount; i++) {
            String text = titles[i - 1];
            Dimension2D titleSize = titlesFont.measureString(text);
            PdfPageBase navigatedPage = doc.getPages().get(i);
            String pageNumText = (String.valueOf(i+1));
            Dimension2D pageNumTextSize = titlesFont.measureString(pageNumText);
            tocPage.getCanvas().drawString(text, titlesFont, PdfBrushes.getCadetBlue(), 0, y);
            float dotLocation = (float)titleSize.getWidth() + 2 + x;
            float pageNumlocation = (float)(tocPage.getCanvas().getClientSize().getWidth() - pageNumTextSize.getWidth());
            for (float j = dotLocation; j < pageNumlocation; j++) {
                if (dotLocation >= pageNumlocation) {
                    break;
                }
                tocPage.getCanvas().drawString(".", titlesFont, PdfBrushes.getGray(), dotLocation, y);
                dotLocation += 3;
            }
            tocPage.getCanvas().drawString(pageNumText, titlesFont, PdfBrushes.getCadetBlue(), pageNumlocation, y);
            //Add TOC action
            Rectangle2D titleBounds = new Rectangle2D.Float(0,y,(float)tocPage.getCanvas().getClientSize().getWidth(),(float)titleSize.getHeight());
            PdfDestination Dest = new PdfDestination(navigatedPage, new Point2D.Float(-doc.getPageSettings().getMargins().getTop(), -doc.getPageSettings().getMargins().getLeft()));
            PdfActionAnnotation action = new PdfActionAnnotation(titleBounds, new PdfGoToAction(Dest));
            action.setBorder(new PdfAnnotationBorder(0));
            ((PdfNewPage) ((tocPage instanceof PdfNewPage) ? tocPage : null)).getAnnotations().add(action);
            y += titleSize.getHeight() + 10;
        }

        doc.saveToFile("output/addTableOfContent.pdf");
        doc.close();
    }
}

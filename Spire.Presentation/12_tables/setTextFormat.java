
import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;

public class setTextFormat {
    public static void main(String[] args) throws Exception {

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_1.pptx");


        //Get the table in PowerPoint document.
        for (int i = 0; i < presentation.getSlides().get(0).getShapes().getCount();i ++)
        {
            IShape shape = presentation.getSlides().get(0).getShapes().get(i);
            if (shape instanceof  ITable)
            {
                ITable table = (ITable)shape;
                Cell cell1 = table.getTableRows().get(0).get(0);
                //Set table cell's text alignment type 
                cell1.setTextAnchorType(TextAnchorType.TOP);
                //Set italic style
                cell1.getTextFrame().getTextRange().getFormat().isItalic(TriState.TRUE);

                Cell cell2 = table.getTableRows().get(1).get(0);
                //Set table cell's foreground color
                cell2.getTextFrame().getTextRange().getFill().setFillType(FillFormatType.SOLID);
                cell2.getTextFrame().getTextRange().getFill().getSolidColor().setColor(Color.green);

                //Set table cell's background color
                cell2.getFillFormat().setFillType(FillFormatType.SOLID);
                cell2.getFillFormat().getSolidColor().setColor(Color.lightGray);


                Cell cell3 = table.getTableRows().get(2).get(2);
                //Set table cell's font and font size
                cell3.getTextFrame().getTextRange().setFontHeight(12);
                cell3.getTextFrame().getTextRange().setLatinFont(new TextFont("Arial Black"));
                cell3.getTextFrame().getTextRange().getHighlightColor().setColor(Color.yellow);

                Cell cell4 = table.getTableRows().get(2).get(1);
                //Set table cell's margin and borders
                cell4.setMarginLeft(20);
                cell4.setMarginTop(30);
                cell4.getBorderTop().setFillType(FillFormatType.SOLID);
                cell4.getBorderTop().getSolidFillColor().setColor(Color.red);
                cell4.getBorderBottom().setFillType(FillFormatType.SOLID);
                cell4.getBorderBottom().getSolidFillColor().setColor(Color.red);
                cell4.getBorderLeft().setFillType(FillFormatType.SOLID);
                cell4.getBorderLeft().getSolidFillColor().setColor(Color.red);
                cell4.getBorderRight().setFillType(FillFormatType.SOLID);
                cell4.getBorderRight().getSolidFillColor().setColor(Color.red);

            }
        }

        String result = "output/Result-setTextFormat.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}


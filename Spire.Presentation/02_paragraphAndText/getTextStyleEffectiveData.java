import com.spire.presentation.*;

import java.io.*;

public class getTextStyleEffectiveData {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/template_Az1.pptx");
        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);
        //Get a shape 
        IAutoShape shape = (IAutoShape) presentation.getSlides().get(0).getShapes().get(0);

        StringBuilder str = new StringBuilder();
        for (int p = 0; p < shape.getTextFrame().getParagraphs().getCount(); p++) {
            ParagraphEx paragraph = shape.getTextFrame().getParagraphs().get(p);
            str.append("Text style for Paragraph " + p + " :" + "\r\n");
            //Get the paragraph style
            str.append(" Indent: " + paragraph.getIndent() + "\r\n");
            str.append(" Alignment: " + paragraph.getAlignment() + "\r\n");
            str.append(" Font alignment: " + paragraph.getFontAlignment() + "\r\n");
            str.append(" Hanging punctuation: " + paragraph.getHangingPunctuation() + "\r\n");
            str.append(" Line spacing: " + paragraph.getLineSpacing() + "\r\n");
            str.append(" Space before: " + paragraph.getSpaceBefore() + "\r\n");
            str.append(" Space after: " + paragraph.getSpaceAfter() + "\r\n");
            for (int r = 0; r < paragraph.getTextRanges().getCount(); r++) {
                PortionEx textRange = paragraph.getTextRanges().get(r);
                str.append("  Text style for Paragraph " + p + " TextRange " + r + " :" + "\r\n");
                //Get the text range style
                str.append("    Font height: " + textRange.getFontHeight() + "\r\n");
                str.append("    Language: " + textRange.getLanguage() + "\r\n");
                str.append("    Font: " + textRange.getLatinFont().getFontName() + "\r\n");
            }
        }

        //Save to text file
        String output = "output/getTextStyleEffectiveData.txt";
        FileWriter writer = new FileWriter(output);
        writer.write(str.toString());
        writer.flush();
        writer.close();
    }
}

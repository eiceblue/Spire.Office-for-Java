import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class addPictureCaption {
    public static void main(String[] args) {
        //Create word document
        Document document = new Document();

        //Create a new section
        Section section = document.addSection();

        //Add a new paragraph
        Paragraph par1 = section.addParagraph();

        //Set the afters-pacing
        par1.getFormat().setAfterSpacing(10);

        //Load a picture
        DocPicture pic1 = par1.appendPicture("data/spire.Doc.png");

        //Set picture height
        pic1.setHeight(120);

        //Set picture width
        pic1.setWidth(120);

        //Create a CaptionNumberingFormat
        CaptionNumberingFormat format = CaptionNumberingFormat.Number;

        //Add caption to the picture
        pic1.addCaption("Figure", format, CaptionPosition.Below_Item);

        //Add the second paragraph
        Paragraph par2 = section.addParagraph();

        //Load a picture
        DocPicture pic2 = par2.appendPicture("data/word.png");

        //Set picture height
        pic2.setHeight(120);

        //Set picture width
        pic2.setWidth(120);

        //Add caption to the picture
        pic2.addCaption("Figure", format, CaptionPosition.Below_Item);

        //Update fields
        document.isUpdateFields(true);

        //Save the file
        String output = "output/addPictureCaption_result.docx";
        document.saveToFile(output, FileFormat.Docx);

        //Dispose the document
        document.dispose();
    }
}

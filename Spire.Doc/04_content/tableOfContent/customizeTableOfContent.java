import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.io.*;

public class customizeTableOfContent {
    public static void main(String[] args) throws IOException {

        String image1="data/ornithogalum.jpg";
        String image2="data/rosa.jpg";
        String image3="data/hyacinths.JPG";
        String outputFile="output/customizeTableOfContent.docx";

        //create a document
        Document doc = new Document();
        //add a section
        Section section = doc.addSection();
        //customize table of contents with switches
        TableOfContent toc = new TableOfContent(doc, "{\\o \"1-3\" \\n 1-1}");
        Paragraph para = section.addParagraph();
        para.getItems().add(toc);
        para.appendFieldMark(FieldMarkType.Field_Separator);
        para.appendText("TOC");
        para.appendFieldMark(FieldMarkType.Field_End);
        doc.setTOC(toc);

        Paragraph par = section.addParagraph();
        TextRange tr = par.appendText("Flowers");
        tr.getCharacterFormat().setFontSize(30);
        par.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

        //create paragraph and set the head level
        Paragraph para1 = section.addParagraph();
        para1.appendText("Ornithogalum");
        //apply the Heading1 style
        para1.applyStyle(BuiltinStyle.Heading_1);
        //add paragraphs
        para1 = section.addParagraph();
        DocPicture picture = para1.appendPicture(image1);
        picture.setTextWrappingStyle(TextWrappingStyle.Square);
        para1.appendText("Ornithogalum is a genus of perennial plants mostly native to southern Europe and southern Africa belonging to the family Asparagaceae. Some species are native to other areas such as the Caucasus. Growing from a bulb, species have linear basal leaves and a slender stalk, up to 30 cm tall, bearing clusters of typically white star-shaped flowers, often striped with green.");
        para1 = section.addParagraph();

        Paragraph para2 = section.addParagraph();
        para2.appendText("Rosa");
        //apply the Heading2 style
        para2.applyStyle(BuiltinStyle.Heading_2);
        para2 = section.addParagraph();
        DocPicture picture2 = para2.appendPicture(image2);
        picture2.setTextWrappingStyle(TextWrappingStyle.Square);
        para2.appendText("A rose is a woody perennial flowering plant of the genus Rosa, in the family Rosaceae, or the flower it bears. There are over a hundred species and thousands of cultivars. They form a group of plants that can be erect shrubs, climbing or trailing with stems that are often armed with sharp prickles. Flowers vary in size and  shape and are usually large and showy, in colours ranging from white through yellows and reds. Most species are native to Asia, with smaller numbers native to Europe, North America, and northwestern Africa. Species, cultivars and hybrids are all widely grown for their beauty and often are fragrant. Roses have acquired cultural significance in many societies. Rose plants range in size from compact, miniature roses, to climbers that can reach seven meters in height. Different species hybridize easily, and this has been used in the development of the wide range of garden roses.");
        section.addParagraph();

        Paragraph para3 = section.addParagraph();
        para3.appendText("Hyacinth");
        //apply the Heading3 style
        para3.applyStyle(BuiltinStyle.Heading_3);
        para3 = section.addParagraph();
        DocPicture picture3 = para3.appendPicture(image3);
        picture3.setTextWrappingStyle(TextWrappingStyle.Tight);
        para3.appendText("Hyacinthus is a small genus of bulbous, fragrant flowering plants in the family Asparagaceae, subfamily Scilloideae.These are commonly called hyacinths.The genus is native to the eastern Mediterranean (from the south of Turkey through to northern Israel).");
        para3 = section.addParagraph();
        para3.appendText("Several species of Brodiea, Scilla, and other plants that were formerly classified in the lily family and have flower clusters borne along the stalk also have common names with the word \"hyacinth\" in them. Hyacinths should also not be confused with the genus Muscari, which are commonly known as grape hyacinths.");

        //update TOC
        doc.updateTableOfContents();
        //save to file
        doc.saveToFile(outputFile, FileFormat.Docx);
    }
}

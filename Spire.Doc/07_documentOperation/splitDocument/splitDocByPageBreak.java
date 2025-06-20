import com.spire.doc.*;
import com.spire.doc.documents.*;

public class splitDocByPageBreak {
    public static void main(String[] args) throws Exception {
        //Create Word document.
        Document original = new Document();

        //Load the file from disk.
        original.loadFromFile("data/SplitWordFileByPageBreak.docx");

        //Create a new document
        Document newWord = new Document();

        //Add a new section
        Section section = newWord.addSection();

        //copy the default style,theme and Compatibility
        original.cloneDefaultStyleTo(newWord);
        original.cloneThemesTo(newWord);
        original.cloneCompatibilityTo(newWord);

        //Split the original Word document into separate documents according to page break.
        int index = 0;

        //Traverse through all sections of original document.
        for (int s = 0; s < original.getSections().getCount(); s++) {
            Section sec = original.getSections().get(s);
            //Traverse through all body child objects of each section.
            for (int c = 0; c < sec.getBody().getChildObjects().getCount(); c++) {
                DocumentObject obj = sec.getBody().getChildObjects().get(c);
                if (obj instanceof Paragraph) {
                    Paragraph para = (Paragraph) obj;
                    sec.cloneSectionPropertiesTo(section);
                    //Add paragraph object in original section into section of new document.
                    section.getBody().getChildObjects().add(para.deepClone());
                    for (int i = 0; i < para.getChildObjects().getCount(); i++) {
                        DocumentObject parobj = para.getChildObjects().get(i);
                        if (parobj instanceof Break) {
                            Break break1 = (Break) parobj;
                            if (break1.getBreakType().equals(BreakType.Page_Break)) {
                                //Get the index of page break in paragraph.
                                int indexId = para.getChildObjects().indexOf(parobj);

                                //Remove the page break from its paragraph.
                                Paragraph newPara = (Paragraph) section.getBody().getLastParagraph();
                                newPara.getChildObjects().removeAt(indexId);

                                //Save the new document to a Docx file.
                                newWord.saveToFile("output/result-SplitWordFileByPageBreak_"+index+".docx", FileFormat.Docx);
                                index++;

                                //Create a new document and add a section.
                                newWord = new Document();
                                section = newWord.addSection();
                                original.cloneDefaultStyleTo(newWord);
                                original.cloneThemesTo(newWord);
                                original.cloneCompatibilityTo(newWord);
                                sec.cloneSectionPropertiesTo(section);
                                //Add paragraph object in original section into section of new document.
                                section.getBody().getChildObjects().add(para.deepClone());
                                if (section.getParagraphs().get(0).getChildObjects().getCount() == 0) {
                                    //Remove the first blank paragraph.
                                    section.getBody().getChildObjects().removeAt(0);
                                } else {
                                    //Remove the child objects before the page break.
                                    while (indexId >= 0) {
                                        section.getParagraphs().get(0).getChildObjects().removeAt(indexId);
                                        indexId--;
                                    }
                                }
                            }
                        }
                    }
                }
                if (obj instanceof Table) {
                    //Add table object in original section into section of new document.
                    section.getBody().getChildObjects().add(obj.deepClone());
                }
            }
        }

        //Save to file.
        String result ="output/result-SplitWordFileByPageBreak_"+index+".docx";
        newWord.saveToFile(result, FileFormat.Docx_2013);

        //Dispose the document
        original.dispose();
        newWord.dispose();
    }
}



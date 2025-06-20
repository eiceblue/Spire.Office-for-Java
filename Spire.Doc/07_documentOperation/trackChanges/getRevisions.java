import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import com.spire.doc.formatting.revisions.*;
import java.io.FileWriter;

public class getRevisions {
    public static void main(String[] args) throws Exception{
        //Create a document
        Document document = new Document();

        //Load from a disk file
        document.loadFromFile("data/GetRevisions.docx");
        StringBuilder insertRevision = new StringBuilder();
        insertRevision.append("Insert revisions:"+"\n");
        int index_insertRevision = 0;
        StringBuilder deleteRevision = new StringBuilder();
        deleteRevision.append("Delete revisions:"+"\n");
        int index_deleteRevision = 0;
        //Traverse sections
        for (Section sec : (Iterable<Section>) document.getSections())
        {
            //Iterate through the element under body in the section
            for(DocumentObject docItem : (Iterable<DocumentObject>)sec.getBody().getChildObjects())
            {
                if (docItem instanceof Paragraph)
                {
                    Paragraph para = (Paragraph)docItem;
                    //Determine if the paragraph is an insertion revision
                    if (para.isInsertRevision())
                    {
                        index_insertRevision++;
                        insertRevision.append("Index: " + index_insertRevision+"\n");
                        //Get insertion revision
                        EditRevision insRevison = para.getInsertRevision();

                        //Get insertion revision type
                        EditRevisionType insType = insRevison.getType();
                        insertRevision.append("Type: " + insType+"\n");
                        //Get insertion revision author
                        String insAuthor = insRevison.getAuthor();
                        insertRevision.append("Author: " + insAuthor + "\n");
                    }
                    //Determine if the paragraph is a delete revision
                    else if (para.isDeleteRevision())
                    {
                        index_deleteRevision++;
                        deleteRevision.append("Index: " + index_deleteRevision +"\n");
                        EditRevision delRevison = para.getDeleteRevision();
                        EditRevisionType delType = delRevison.getType();
                        deleteRevision.append("Type: " + delType+ "\n");
                        String delAuthor = delRevison.getAuthor();
                        deleteRevision.append("Author: " + delAuthor + "\n");
                    }
                    //Iterate through the element in the paragraph
                    for(DocumentObject obj : (Iterable<DocumentObject>)para.getChildObjects())
                    {
                        if (obj instanceof TextRange)
                        {
                            TextRange textRange = (TextRange)obj;
                            //Determine if the textrange is an insertion revision
                            if (textRange.isInsertRevision())
                            {
                                index_insertRevision++;
                                insertRevision.append("Index: " + index_insertRevision +"\n");
                                EditRevision insRevison = textRange.getInsertRevision();
                                EditRevisionType insType = insRevison.getType();
                                insertRevision.append("Type: " + insType + "\n");
                                String insAuthor = insRevison.getAuthor();
                                insertRevision.append("Author: " + insAuthor + "\n");
                            }
                            else if (textRange.isDeleteRevision())
                            {
                                index_deleteRevision++;
                                deleteRevision.append("Index: " + index_deleteRevision +"\n");
                                //Determine if the textrange is a delete revision
                                EditRevision delRevison = textRange.getDeleteRevision();
                                EditRevisionType delType = delRevison.getType();
                                deleteRevision.append("Type: " + delType+"\n");
                                String delAuthor = delRevison.getAuthor();
                                deleteRevision.append("Author: " + delAuthor+"\n");
                            }
                        }
                    }
                }
            }
        }
        //Save to a .txt file
        FileWriter writer1 = new FileWriter("data/insertRevisions.txt");
        writer1.write(insertRevision.toString());
        writer1.flush();
        writer1.close();


        //Save to a .txt file
        FileWriter writer2 = new FileWriter("data/deleteRevisions.txt");
        writer2.write(deleteRevision.toString());
        writer2.flush();
        writer2.close();

        //Dispose the document
        document.dispose();
    }
}

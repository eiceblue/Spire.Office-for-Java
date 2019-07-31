import com.spire.pdf.PdfDocument;
import com.spire.pdf.actions.PdfJavaScriptAction;
import com.spire.pdf.fields.PdfField;
import com.spire.pdf.widget.*;
import java.io.FileWriter;

public class extractJavaScript {
    public static void main(String[] args) throws Exception{
        String inputFile = "data/extractJavaScript.pdf";
        String outputFile = "output/extractJavaScript.txt";

        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(inputFile);

        String js = null;

        PdfFormWidget form = (PdfFormWidget)((doc.getForm() instanceof PdfFormWidget) ? doc.getForm() : null);
        for (int i = 0; i < form.getFieldsWidget().getList().size(); i++)
        {
            PdfField field = (PdfField)((form.getFieldsWidget().getList().get(i) instanceof PdfField) ? form.getFieldsWidget().getList().get(i) : null);
            if (field instanceof PdfTextBoxFieldWidget)
            {
                PdfTextBoxFieldWidget textbox = (PdfTextBoxFieldWidget)((field instanceof PdfTextBoxFieldWidget) ? field : null);

                //Find the textbox named total
                if (textbox.getName().equals("total"))
                {
                    //Get the action
                    PdfJavaScriptAction jsa = textbox.getActions().getCalculate();

                    if (jsa != null)
                    {
                        //Get JavaScript
                        js = jsa.getScript();
                    }
                }
            }
        }


        FileWriter writer = new FileWriter(outputFile);
        writer.write(js);
        writer.flush();
        writer.close();
        doc.close();
    }
}

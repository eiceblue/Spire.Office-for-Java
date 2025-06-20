import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.omath.*;

public class addMathEquation {
    public static void main(String[] args) {
        // Array of LaTeX math code
        String[] latexMathCode = {
                "x^{2}+\\sqrt{{x^{2}+1}}+1",
                "2\\alpha - \\sin y + x",
                "1 \\over 2 + x",
                "(1 + \\vert x-[a-b] \\vert)",
                "\\mbox{if $x=1$ or $x=2$}",
                "\\begin{cases} 1 & \\mbox{if $x>0$,} \\\\ 2 & \\mbox{otherwise.} \\end{cases}"
        };
        // Array of MathML code
        String[] mathMLCode = {
                "<mml:math xmlns:mml=\"http://www.w3.org/1998/Math/MathML\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\"><mml:msup><mml:mrow><mml:mi>x</mml:mi></mml:mrow><mml:mrow><mml:mn>2</mml:mn></mml:mrow></mml:msup><mml:mo>+</mml:mo><mml:msqrt><mml:msup><mml:mrow><mml:mi>x</mml:mi></mml:mrow><mml:mrow><mml:mn>2</mml:mn></mml:mrow></mml:msup><mml:mo>+</mml:mo><mml:mn>1</mml:mn></mml:msqrt><mml:mo>+</mml:mo><mml:mn>1</mml:mn></mml:math>",
                "<mml:math xmlns:mml=\"http://www.w3.org/1998/Math/MathML\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\"><mml:mn>2</mml:mn><mml:mi>α</mml:mi><mml:mo>-</mml:mo><mml:mi>s</mml:mi><mml:mi>i</mml:mi><mml:mi>n</mml:mi><mml:mi>y</mml:mi><mml:mo>+</mml:mo><mml:mi>x</mml:mi></mml:math>",
                "<mml:math xmlns:mml=\"http://www.w3.org/1998/Math/MathML\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\"><mml:mfrac><mml:mrow><mml:mn>1</mml:mn></mml:mrow><mml:mrow><mml:mn>2</mml:mn><mml:mo>+</mml:mo><mml:mi>x</mml:mi></mml:mrow></mml:mfrac></mml:math>",
                "<mml:math xmlns:mml=\"http://www.w3.org/1998/Math/MathML\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\"><mml:mfenced><mml:mrow><mml:mn>1</mml:mn><mml:mo>+</mml:mo><mml:mo>|</mml:mo><mml:mi>x</mml:mi><mml:mo>-</mml:mo><mml:mfenced open=\"[\" close=\"]\"><mml:mrow><mml:mi>a</mml:mi><mml:mo>-</mml:mo><mml:mi>b</mml:mi></mml:mrow></mml:mfenced><mml:mo>|</mml:mo></mml:mrow></mml:mfenced></mml:math>",
                "<mml:math xmlns:mml=\"http://www.w3.org/1998/Math/MathML\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\"><mml:mi>i</mml:mi><mml:mi>f</mml:mi><mml:mi> </mml:mi><mml:mi>x</mml:mi><mml:mo>=</mml:mo><mml:mn>1</mml:mn><mml:mi> </mml:mi><mml:mi>o</mml:mi><mml:mi>r</mml:mi><mml:mi> </mml:mi><mml:mi>x</mml:mi><mml:mo>=</mml:mo><mml:mn>2</mml:mn></mml:math>",
                "<mml:math xmlns:mml=\"http://www.w3.org/1998/Math/MathML\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\"><mml:mfenced open=\"{\" close=\"\"><mml:mrow><mml:mtable><mml:mtr><mml:mtd><mml:mn>1</mml:mn></mml:mtd><mml:mtd><mml:mi>i</mml:mi><mml:mi>f</mml:mi><mml:mi> </mml:mi><mml:mi>x</mml:mi><mml:mo>&gt;</mml:mo><mml:mn>0</mml:mn><mml:mo>,</mml:mo></mml:mtd></mml:mtr><mml:mtr><mml:mtd><mml:mn>2</mml:mn></mml:mtd><mml:mtd><mml:mi>o</mml:mi><mml:mi>t</mml:mi><mml:mi>h</mml:mi><mml:mi>e</mml:mi><mml:mi>r</mml:mi><mml:mi>w</mml:mi><mml:mi>i</mml:mi><mml:mi>s</mml:mi><mml:mi>e</mml:mi><mml:mo>.</mml:mo></mml:mtd></mml:mtr></mml:mtable></mml:mrow></mml:mfenced></mml:math>"
        };

        // Create a document
        Document doc = new Document();

        // Load document
        doc.loadFromFile("data/addMathEquation.docx");

        // Get the first section
        Section section = doc.getSections().get(0);

        Paragraph paragraph = null;
        OfficeMath officeMath;

        //Get the first table and add LaTeX code
        Table table1 = section.getTables().get(0);
        for (int i = 0; i < latexMathCode.length; i++) {
            paragraph = table1.getRows().get(i + 1).getCells().get(0).addParagraph();
            paragraph.setText(latexMathCode[i]);
            paragraph = table1.getRows().get(i + 1).getCells().get(1).addParagraph();
            officeMath = new OfficeMath(doc);
            officeMath.fromLatexMathCode(latexMathCode[i]);
            paragraph.getItems().add(officeMath);
        }

        //Get the second table and add MathML code
        Table table2 = section.getTables().get(1);
        for (int i = 0; i < mathMLCode.length; i++) {
            paragraph = table2.getRows().get(i + 1).getCells().get(0).addParagraph();
            paragraph.setText(mathMLCode[i]);
            paragraph = table2.getRows().get(i + 1).getCells().get(1).addParagraph();
            officeMath = new OfficeMath(doc);
            officeMath.fromMathMLCode(mathMLCode[i]);
            paragraph.getItems().add(officeMath);
        }

        //Save the document
        String result = "output/addMathEquation.docx";
        doc.saveToFile(result, FileFormat.Docx_2013);

        // Dispose the document
        doc.dispose();
    }
}

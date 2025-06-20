import com.spire.xls.*;

public class toHtmlWithHiddenWorksheets {
    public static void main(String[] args) {
        //Create a workbook
        Workbook book = new Workbook();

        //Load the document
        book.loadFromFile("data/ToHtmlWithHiddenWorksheets.xlsx");

        //Save the document
        //false --- To Html with the hidden Worksheet
        //true--- To Html without the hidden Worksheet
        String result = "output/ToHtml_result.html";
        book.saveToHtml(result, false);
    }
}

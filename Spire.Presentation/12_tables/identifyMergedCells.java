
import com.spire.presentation.*;

public class identifyMergedCells {
    public static void main(String[] args) throws Exception {

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/MergedCellInTable.pptx");

        ITable table = null;

        //Get the table in PowerPoint document.
        for (int i = 0; i < presentation.getSlides().get(0).getShapes().getCount();i ++) {
            IShape shape = presentation.getSlides().get(0).getShapes().get(i);
            if (shape instanceof ITable) {
                table = (ITable) shape;

                for (int j = 0; j < table.getTableRows().getCount(); j++) {
                    TableRow row = table.getTableRows().get(j);
                    for (int a = 0; a < row.getCount(); a++) {
                        if (row.get(a).getRowSpan() > 1 || row.get(a).getColSpan() > 1) {
                            System.out.println("The cell " + j + ":" + a + "is a part of merged cell with RowSpan=" + row.get(a).getRowSpan() + " and ColSpan=" + row.get(a).getColSpan() + " starting from Cell " + row.get(a).getFirstRowIndex() + " : " + row.get(a).getFirstColumnIndex());
                        }

                    }

                }
            }

        }
    }
}


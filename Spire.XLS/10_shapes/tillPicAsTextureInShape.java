import com.spire.xls.*;
import com.spire.xls.core.IPrstGeomShape;

public class tillPicAsTextureInShape {
    public static void main(String[] args){
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/TillPicAsTextureInShape.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the first shape
        IPrstGeomShape shape = sheet.getPrstGeomShapes().get(0);

        //Fill shape with texture
        shape.getFill().setFillType(ShapeFillType.Texture);

        //Custom texture with picture
        shape.getFill().customTexture("data/logo.png");

        //Tile pciture as texture
        shape.getFill().setTile(true);

        //Save the document
        String output = "output/TillPicAsTextureInShape_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);

    }
}

import com.spire.xls.*;
import com.spire.xls.collections.GroupShapeCollection;
import com.spire.xls.core.IPrstGeomShape;

public class groupShapes {

    public static void main(String[] args) {
        //create a workbook
        Workbook workbook = new Workbook();
		
		//get the first sheet
        Worksheet worksheet = workbook.getWorksheets().get(0);
		
		 //add shapes
        IPrstGeomShape shape1 = worksheet.getPrstGeomShapes().addPrstGeomShape(1, 3, 50, 50, PrstGeomShapeType.RoundRect);
        IPrstGeomShape shape2 = worksheet.getPrstGeomShapes().addPrstGeomShape(5, 3, 50, 50, PrstGeomShapeType.Triangle);
		
		//group
        GroupShapeCollection groupShapeCollection = worksheet.getGroupShapes();
        groupShapeCollection.group(new com.spire.xls.core.IShape[]{shape1,shape2});
		
		//save
        workbook.saveToFile("groupshapes_output.xlsx",ExcelVersion.Version2013);
    }
}

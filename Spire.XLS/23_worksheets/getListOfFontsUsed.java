import java.io.*;
import java.util.ArrayList;
import com.spire.xls.*;
import com.spire.xls.core.IFont;

public class getListOfFontsUsed {

	public static void main(String[] args) {
		//Create a workbook
		Workbook workbook = new Workbook();

		//Load a excel document
		workbook.loadFromFile("data/templateAz.xlsx");

		ArrayList<IFont> fonts = new ArrayList<IFont>();

		//Loop all sheets of workbook
		for(int i = 0; i < workbook.getWorksheets().getCount(); i++)
		{
			Worksheet sheet = workbook.getWorksheets().get(i);

			for(int r = 0; r < sheet.getRows().length; r++)
			{
				for(int c = 0; c < sheet.getRows()[r].getCellList().size(); c++)
				{
					//Get the font of cell and add it to list
					fonts.add(sheet.getRows()[r].getCellList().get(c).getStyle().getFont());
				}
			}
		}

		StringBuilder strB = new StringBuilder();
		for(int i = 0; i < fonts.size(); i++) {
			IFont font = fonts.get(i);
			strB.append(String.format("FontName:"+font.getFontName() +"; FontSize:"+font.getSize()+"\n"));
		}

		String result = "output/getListOfFontsUsed_result.txt";
		File file = new File(result);
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(strB.toString());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

}

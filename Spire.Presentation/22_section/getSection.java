
import com.spire.presentation.*;
public class getSection {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/GetSection.pptx");

        SectionList list= presentation.getSectionList();
        String name =  list.get(0).getName();

        System.out.println("The first section name is "+ name );
    }
}

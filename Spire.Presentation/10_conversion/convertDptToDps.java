import com.spire.presentation.*;

public class convertDptToDps {
    public static void main(String[] args) throws Exception {
        //Load Dpt file.
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/Sample_dpt.dpt", FileFormat.DPT);

        //Convert to Dps file.
        presentation.saveToFile("output/result.dps", FileFormat.DPS);
    }
}

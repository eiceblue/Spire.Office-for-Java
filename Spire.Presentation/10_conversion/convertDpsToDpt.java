import com.spire.presentation.*;

public class convertDpsToDpt {
    public static void main(String[] args) throws Exception {
        //Load Dps file.
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/Sample_dps.dps", FileFormat.DPS);

        //Convert to Dpt file.
        presentation.saveToFile("output/result.dpt", FileFormat.DPT);
    }
}

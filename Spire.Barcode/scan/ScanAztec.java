import com.spire.barcode.*;

public class ScanAztec {
    public static void main(String[] args) throws Exception {
       
        String[] s = BarcodeScanner.scan("Data/Aztec.png", BarCodeType.Aztec);
        System.out.println(s[0]);
    }
}

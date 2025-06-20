import com.spire.barcode.*;
import java.awt.*;

public class GetBarcodeInfo {
    public static void main(String[] args) {
        BarcodeInfo[] barcodeInfos = BarcodeScanner.scanInfo("Data/barcode.png");
        StringBuilder stringBuilder = new StringBuilder();
        String point = "";
        String dataString = "";
        Point[] vertexes = null;
        BarCodeReadType barCodeReadType = null;
        // Get barcode information
        for (BarcodeInfo barcodeInfo : barcodeInfos) {
            // Get Type
            barCodeReadType = barcodeInfo.getReadType();
            // Obtain vertex position information
            vertexes = barcodeInfo.getVertexes();
            // Obtain data values
            dataString = barcodeInfo.getDataString();
        }
        // Get vertexes
        for (int i = 0; i < vertexes.length; i++)
        {
            point += vertexes[i];

        }
        //Add barcode information string to StringBuilder
        stringBuilder.append("barCodeReadType：" + barCodeReadType.toString());
        stringBuilder.append("\n");
        stringBuilder.append("vertexes：" + point);
        stringBuilder.append("\n");
        stringBuilder.append("dataString：" + dataString);
        System.out.println(stringBuilder);
    }

}

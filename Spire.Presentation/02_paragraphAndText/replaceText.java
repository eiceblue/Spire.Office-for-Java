import com.spire.presentation.*;

import java.util.*;

public class replaceText {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Spire.Presentation for Java", "Spire.PPT");

        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile("data/textTemplate.pptx");

        replaceTags(ppt.getSlides().get(0), map);

        //Save the document
        String result = "output/replaceText.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }

    public static void replaceTags(ISlide pSlide, Map<String, String> tagValues) {
        for (int i = 0; i < pSlide.getShapes().getCount(); i++) {
            IShape curShape = pSlide.getShapes().get(i);
            if (curShape instanceof IAutoShape) {
                for (int j = 0; j < ((IAutoShape) curShape).getTextFrame().getParagraphs().getCount(); j++) {
                    ParagraphEx tp = ((IAutoShape) curShape).getTextFrame().getParagraphs().get(j);
                    for (Map.Entry<String, String> entry : tagValues.entrySet()) {
                        String mapKey = entry.getKey();
                        String mapValue = entry.getValue();
                        if (tp.getText().contains(mapKey)) {
                            tp.setText(tp.getText().replace(mapKey, mapValue));
                        }
                    }
                }
            }
        }
    }
}

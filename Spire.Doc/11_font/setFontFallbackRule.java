import com.spire.doc.*;

public class setFontFallbackRule {

    public static void main(String[] args) {
        /*Instructions:
		Support for switching fonts that do not support drawing characters through the FontFallbackRule method in XML when converting to a non-flow layout document.
		
        If there is no XML available, first save an XML using saveFontFallbackRuleSettings and then manually edit the font replacement rules in the XML.
        The rules consist of three attributes: Ranges correspond to Unicode ranges for each character; FallbackFonts correspond to the font names for substitution; BaseFonts correspond to the font names for characters in the document.
        When editing the XML, it is important to note that the rules are searched from top to bottom for character matching.
        After editing the XML, load the rules using the loadFontFallbackRuleSettings method.
        */

        // Create a new Document object
        Document doc = new Document();

        // Load the document from the specified file
        doc.loadFromFile("data/Sample.docx");

        // Save the font fallback rule settings to an XML file
        doc.saveFontFallbackRuleSettings("fontSettings.xml");

        // Load the font fallback rule settings from the XML file
        doc.loadFontFallbackRuleSettings("fontSettings.xml");

        // Save the document to a PDF file with the specified output file name
        doc.saveToFile("output/setFontFallbackRule_output.docx", FileFormat.PDF);

        // Dispose the Document resources
        doc.dispose();
    }
}

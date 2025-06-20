import com.spire.doc.*;
import com.spire.doc.documents.XHTMLValidationType;
import com.spire.doc.documents.converters.html.HtmlUrlLoadEventArgs;
import com.spire.doc.documents.converters.html.HtmlUrlLoadHandler;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class handleUrlWhileConvertHtmlToPDF {


    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();
		
        // Set the custom URL load handler for the document
        document.HtmlUrlLoadEvent = new MyDownloadEvent();
		
        // Load the HTML file into the document
        document.loadFromFile("data/Template_HtmlFile3.html", FileFormat.Html, XHTMLValidationType.None);
		
        // Save the document as a PDF
        document.saveToFile("output/Result.pdf", FileFormat.PDF);
		
		// Dispose of the document to release resources
        document.dispose();
    }

    // Custom URL load handler class
    static class MyDownloadEvent extends HtmlUrlLoadHandler {
        @Override
        public void invoke(Object o, HtmlUrlLoadEventArgs htmlUrlLoadEventArgs) {
            try {
                // Download the bytes from the given URL
                byte[] bytes = downloadBytesFromURL(htmlUrlLoadEventArgs.getUrl());
                // Set the downloaded bytes as the data for the event
                htmlUrlLoadEventArgs.setDataBytes(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Method to download bytes from a URL
    public static byte[] downloadBytesFromURL(String urlString) throws Exception {
        // Create a URL object from the string
        URL url = new URL(urlString);
        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Set the request method to GET
        connection.setRequestMethod("GET");
        // Set connection and read timeouts
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        // Get the response code from the connection
        int responseCode = connection.getResponseCode();
        // If the response code is HTTP OK, read the content
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = connection.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            // Read the input stream into the output stream
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            // Return the byte array
            return outputStream.toByteArray();
        } else {
            // Throw an exception if the response code is not HTTP OK
            throw new Exception("Failed to download content. Response code: " + responseCode);
        }
    }
}
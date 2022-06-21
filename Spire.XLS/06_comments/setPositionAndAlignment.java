import com.spire.xls.*;

import java.awt.*;

public class setPositionAndAlignment {
    public static void main(String[] args) {
        //Open xls document
        Workbook workbook = new Workbook();
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create font
        ExcelFont font1 = workbook.createFont();
        font1.setFontName("Calibri");
        font1.setSize(12);
        font1.setColor(Color.orange);
        font1.isBold(true);

        ExcelFont font2 = workbook.createFont();
        font2.setFontName("Calibri");
        font2.setSize(12);
        font2.setColor(Color.blue);
        font2.isBold(true);


        //Add comment 1 and set its size, text, position and alignment
        sheet.getCellRange("G5").setText("Spire.XLS");
        ExcelComment Comment1 = sheet.getCellRange("G5").getComment();
        Comment1.isVisible(true);
        Comment1.setHeight(150);
        Comment1.setWidth(300);
        Comment1.getRichText().setText("Spire.XLS for Java:\nStandalone Excel component to meet your needs for conversion, data manipulation, charts in workbook etc. ");
        Comment1.getRichText().setFont(0, 19, font1);
        Comment1.setTextRotation(TextRotationType.LeftToRight);
        //Set the position of Comment
        Comment1.setTop(20);
        Comment1.setLeft(40);
        //Set the alignment of text in Comment
        Comment1.setVAlignment(CommentVAlignType.Center);
        Comment1.setHAlignment(CommentHAlignType.Justified);


        //Add comment2 and set its size, text, position and alignment for comparison
        sheet.getCellRange("D14").setText("E-iceblue");
        ExcelComment Comment2 = sheet.getCellRange("D14").getComment();
        Comment2.isVisible(true);
        Comment2.setHeight(150);
        Comment2.setWidth(300);
        Comment2.getRichText().setText("About E-iceblue: \nWe focus on providing excellent office components for developers to operate Word, Excel, PDF, and PowerPoint documents.");
        Comment2.getRichText().setFont(0, 16, font2);
        Comment2.setTextRotation(TextRotationType.LeftToRight);
        //Set the position of Comment
        Comment2.setTop(170);
        Comment2.setLeft(450);
        //Set the alignment of text in Comment
        Comment2.setVAlignment(CommentVAlignType.Top);
        Comment2.setHAlignment(CommentHAlignType.Justified);


        //Save to a file
        workbook.saveToFile("output/setPositionAndAlignment.xlsx", ExcelVersion.Version2013);
    }
}

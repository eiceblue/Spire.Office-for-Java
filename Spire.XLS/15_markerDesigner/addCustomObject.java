import com.spire.xls.*;

import java.util.ArrayList;

public class addCustomObject {
    public static class Student {
        private String Name;
        private int Age;
        public Student(String name, int age) {
            this.Name = name;
            this.Age = age;
        }
    }
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set marker designer field in cell A1
        sheet.getCellRange("A1").setValue("&=Student.Name");
        sheet.getCellRange("B1").setValue("&=Student.Age");
        ArrayList<Student> list = new ArrayList<Student>();

        list.add(new Student("John", 16));
        list.add(new Student("Mary", 17));
        list.add(new Student("Lucy", 17));

        //Fill custom object
        workbook.getMarkerDesigner().addParameter("Student", list);
        workbook.getMarkerDesigner().apply();
        workbook.calculateAllValue();

        //AutoFit
        sheet.getAllocatedRange().autoFitRows();
        sheet.getAllocatedRange().autoFitColumns();

        //Save the document
        String output = "output/addCustomObject.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}

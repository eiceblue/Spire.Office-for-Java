import com.spire.xls.*;
import java.util.ArrayList;

public class addCustomObject {
    // Define a Student class as a nested static class
    public static class Student {
        // Declare private instance variables Name and Age
        private String Name;
        private int Age;

        // Create a constructor that takes name and age as parameters
        public Student(String name, int age) {
            // Initialize the Name and Age instance variables with the provided values
            this.Name = name;
            this.Age = age;
        }
    }
    public static void main(String[] args) {
        // Create a new workbook
        Workbook workbook = new Workbook();

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the value of cell A1 to "&=Student.Name"
        sheet.getCellRange("A1").setValue("&=Student.Name");

        // Set the value of cell B1 to "&=Student.Age"
        sheet.getCellRange("B1").setValue("&=Student.Age");

        // Create an ArrayList to store Student objects
        ArrayList<Student> list = new ArrayList<Student>();

        // Add three Student objects to the list
        list.add(new Student("John", 16));
        list.add(new Student("Mary", 17));
        list.add(new Student("Lucy", 17));

        // Add the "Student" parameter to the workbook's marker designer and assign the list as its value
        workbook.getMarkerDesigner().addParameter("Student", list);

        // Apply the marker design to the workbook
        workbook.getMarkerDesigner().apply();

        // Calculate all the formulas in the workbook
        workbook.calculateAllValue();

        // Automatically adjust the row height of the allocated range in the worksheet
        sheet.getAllocatedRange().autoFitRows();

        // Automatically adjust the column width of the allocated range in the worksheet
        sheet.getAllocatedRange().autoFitColumns();

        // Specify the output file path for the workbook
        String output = "output/addCustomObject.xlsx";

        // Save the workbook to the specified file path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Release any resources used by the workbook
        workbook.dispose();
    }
}

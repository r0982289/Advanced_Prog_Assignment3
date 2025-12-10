import java.io.*;
import java.util.List;

public class EmployeeFileHandler implements Runnable {
    
    private List<Employee> employees;
    private String filename;
    private boolean writing;

    public EmployeeFileHandler(List<Employee> employees, String filename, boolean writing) {
        this.employees = employees;
        this.filename = filename;
        this.writing = writing;
    }

    public void run() {
        if (writing) {
            savingFile();
        } else {
            loadingFile();
        }
    }

    private void savingFile() {
        try {
            FileWriter file = new FileWriter(filename);
            
            for (Employee emp : employees) {
                String data = emp.getEmployeeID() + "," + emp.getFirstName() + " " + 
             emp.getLastName() + "," + emp.getPositionName();
                file.write(data + "\n");
            }
            
            file.close();
            System.out.println("Saved to " + filename);
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void loadingFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            
            System.out.println("\nReading " + filename + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            reader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
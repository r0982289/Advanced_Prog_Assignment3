// package filehandling;

// import employees.Employee;
// import java.io.*;
// import java.util.List;

// public class EmployeeFileHandler implements Runnable {
    
//     private List<Employee> employees;
//     private String filename;
//     private boolean isWriting;

//     public EmployeeFileHandler(List<Employee> employees, String filename, boolean isWriting) {
//         this.employees = employees;
//         this.filename = filename;
//         this.isWriting = isWriting;
//     }

//     @Override
//     public void run() {
//         if (isWriting) {
//             saveFile();
//         } else {
//             readFile();
//         }
//     }

//     // Save to the file
//     private void saveFile() {
//         try {
//             FileWriter file = new FileWriter(filename);
            
//             for (Employee emp : employees) {
//                 file.write(emp.toString() + "\n");
//             }
            
//             file.close();
//             System.out.println("✓ Saved: " + filename);
            
//         } catch (IOException e) {
//             System.err.println("Error saving file: " + e.getMessage());
//         }
//     }

//     // Read from the file
//     private void readFile() {
//         try {
//             BufferedReader reader = new BufferedReader(new FileReader(filename));
            
//             System.out.println("\n--- Reading: " + filename + " ---");
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 System.out.println(line);
//             }
//             System.out.println("--- End ---\n");
            
//             reader.close();
            
//         } catch (FileNotFoundException e) {
//             System.err.println("File not found: " + filename);
//         } catch (IOException e) {
//             System.err.println("Error reading file: " + e.getMessage());
//         }
//     }
// }
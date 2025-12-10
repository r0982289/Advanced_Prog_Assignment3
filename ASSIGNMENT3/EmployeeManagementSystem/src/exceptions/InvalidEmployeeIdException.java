package exceptions;

public class InvalidEmployeeIdException extends Exception {
    
    public InvalidEmployeeIdException(String message) {
        super(message);
    }

    public static void validateEmployeeID(String employeeID) {
        try {
            if (employeeID == null) {
                throw new InvalidEmployeeIdException("Employee ID cannot be null.");
            }
            if (employeeID.length() < 5) {
                throw new InvalidEmployeeIdException("Employee ID must be at least 5 characters long.");
            }
            System.out.println("✓ Employee ID is valid: " + employeeID);
            
        } catch (InvalidEmployeeIdException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }
}
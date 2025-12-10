package exceptions;

public class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }

    public static void DateValidation(String date) {
        try {
            if (date == null || date.trim().isEmpty()) {
                throw new InvalidDateException("Date cannot be null or empty.");
            }
            if (!date.matches("\\d{2}-\\d{2}-\\d{4}")) {
                throw new InvalidDateException("Date must be in the format DD-MM-YYYY.");
            }
            String[] parts = date.split("-");
            // int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            
            if (month < 1 || month > 12) {
                throw new InvalidDateException("Bad month: " + month);
            }
            if (day < 1 || day > 31) {
                throw new InvalidDateException("Bad day: " + day);
            }
        } catch (InvalidDateException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
}

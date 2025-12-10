package exceptions;
public class InvalidExceptions extends Exception {
    public InvalidExceptions(String message) {
        super(message);
    }

    public static void salaryValidate(double salary){
        try{
             if(salary < 0){
            throw new InvalidExceptions("Salary cannot be negative.");
        } 
        }
        catch (InvalidExceptions e) {
            System.out.println(e.getMessage());
        }   
    }

    public static void nameValidate(String name){
        try{
             if(name == null || name.trim().isEmpty()){
            throw new InvalidExceptions("Name cannot be null or empty.");
        } 
        }
        catch (InvalidExceptions e) {
            System.out.println(e.getMessage());
        }   
    }  
}


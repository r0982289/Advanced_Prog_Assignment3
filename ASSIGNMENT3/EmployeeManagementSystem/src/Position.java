import exceptions.*;

public class Position {

    private String positionName;
    private Department department;

    public Position(String positionName, Department department) {
        try {
            if (positionName == null || positionName.trim().isEmpty()) {
                throw new InvalidExceptions("Position name cannot be empty");
            }
            if (department == null) {
                throw new InvalidExceptions("Department cannot be null");
            }
            
            this.positionName = positionName;
            this.department = department;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public String getPositionName() {
        return positionName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        try {
            if (department == null) {
                throw new InvalidExceptions("Department cannot be null");
            }
            this.department = department;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void setPositionName(String positionName) {
        try {
            if (positionName == null || positionName.trim().isEmpty()) {
                throw new InvalidExceptions("Position name cannot be empty");
            }
            this.positionName = positionName;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
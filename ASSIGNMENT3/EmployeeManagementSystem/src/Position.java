public class Position {

    private String PositionName;
    private Department department;

    public Position(String positionName, Department department) {
        this.PositionName = positionName;
        this.department = department;
    }

    public String getPositionName() {
        return PositionName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setPositionName(String positionName) {
        this.PositionName = positionName;
    }

}

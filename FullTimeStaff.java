public class FullTimeStaff extends StaffHire {
    private double salary;
    private int weeklyFractionalHours;
    
    public FullTimeStaff(int vacancyNumber, String designationType,
    String jobType,String staffName, String joiningDate, String qualification, 
    String appointedBy, boolean joined, double salary, int weeklyFractionalHours) {
        super(vacancyNumber, designationType, jobType, staffName, joiningDate, 
        qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }
    
    // Getter methods
    public double getSalary(){
        return salary;
    }
    
    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }
    
    // Setter methods
    public void setSalary(double salary) {
        if(getJoined()) {
            this.salary=salary;
        }
        else {
            System.out.println("Staff not appointed. Cannot set salary");
        }
    }
    
    public void setWeeklyFractionalHours(int weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }
    
    @Override
    public void display() {
        super.display();
        if (getJoined()) {
            System.out.println("Weekly Fractional Hours: " +weeklyFractionalHours);
            System.out.println("Salary: " +salary);
        }
        else {
            System.out.println("Staff not found - cannot assign salary");
        }
    }
}
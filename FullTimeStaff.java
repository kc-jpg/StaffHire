//FullTimeStaff is a subclass of StaffHire
public class FullTimeStaff extends StaffHire {
    private double salary;      //Attributes specific to full time staff
    private int weeklyFractionalHours;
    //Constructor initialises both superclass and subclass attributes
    public FullTimeStaff(int vacancyNumber, String designationType,
    String jobType,String staffName, String joiningDate, String qualification, 
    String appointedBy, boolean joined, double salary, int weeklyFractionalHours) {
        //call superclass constructor to set common staff attributes
        super(vacancyNumber, designationType, jobType, staffName, joiningDate, 
        qualification, appointedBy, joined);    
        //set full-time specific fields
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
    //Method to update salary that only updates if the staff has joined
    public void setSalary(double salary) {
        if(getJoined()) { //updating the salary because they have joined
            this.salary=salary;
        }
        else {  //displays a warning message as the staff hasn't joined
            System.out.println("Staff not appointed. Cannot set salary");
        }
    }
    //Method to update the working hours 
    public void setWeeklyFractionalHours(int weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }
    //overriding the display method from StaffHire
    @Override
    public void display() {
        super.display(); //Calling the display method from the superclass to print shared attributes
        if (getJoined()) {  //only display salary and working hours if the staff is joined
            System.out.println("Weekly Fractional Hours: " +weeklyFractionalHours);
            System.out.println("Salary: " +salary);
            System.out.println("------------------------------------------------------");
        }
        else {
            System.out.println("* * * * * * * * * * * * * * * * * * * * *");
            System.out.println("Staff not found - cannot assign salary");
            System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        }
    }
}
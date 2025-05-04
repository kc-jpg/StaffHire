//PartTimeStaff class is a subclass of StaffHire
public class PartTimeStaff extends StaffHire {
    private int workingHours;   //Attributes specific to part time staff class
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;
    //constructor to initialise both super and sub class attributes
    public PartTimeStaff(int vacancyNumber, String designationType,
    String jobType,String staffName, String joiningDate, String qualification, 
    String appointedBy, boolean joined, double wagesPerHour, 
    int workingHours, String shifts) {
        super(vacancyNumber, designationType, jobType, staffName, joiningDate, 
        qualification, appointedBy, joined); //calling superclass constructor
        this.workingHours = workingHours;   //initialising part time specific fields
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false; //default value on creation
        
    }
    
    //Getter methods
    public int getWorkingHours() {
        return workingHours;
    }
    
    public double getWagesPerHour() {
        return wagesPerHour;
    }
    
    public String getShifts(){
        return shifts;
    }
    
    public boolean getTerminated() {
        return terminated;
    }
    
    // Setter method for shifts to update if the staff already exists
    public void setShifts(String shifts) {
        if (getJoined()) {
            this.shifts = shifts;
        }
        else {
            System.out.println("Cannot change shifts. Staff has not joined yet");
        }
    }
    
    //Method to terminate staff
    public void terminateStaff (){
        if(terminated) {
            System.out.println("The staff member is already terminated");
        }
        else {  //clears personal information
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);   //updating booleans
            terminated = true;
            System.out.println("Staff member terminated successfully.");
        }
    }
    //overriding display method from super staff hire class
    @Override
    public void display() {
        super.display();    //calling staff hire for the general details
        if (getJoined()) {  //including the additional part time staff info
            System.out.println("Working Hours: " +workingHours);
            System.out.println("Wages Per Hour: " +wagesPerHour);
            System.out.println("Shifts: " +shifts);
            System.out.println("Terminated: " +terminated);
             //calculating and displaying the daily income
            System.out.println("Daily Income: " +(wagesPerHour * workingHours));
            System.out.println("------------------------------------------------------");
        }
    }
} 
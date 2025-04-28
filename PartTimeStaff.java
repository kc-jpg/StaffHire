public class PartTimeStaff extends StaffHire {
    private int workingHours;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;
    
    public PartTimeStaff(int vacancyNumber, String designationType,
    String jobType,String staffName, String joiningDate, String qualification, 
    String appointedBy, boolean joined, double wagesPerHour, 
    int workingHours, String shifts) {
        super(vacancyNumber, designationType, jobType, staffName, joiningDate, 
        qualification, appointedBy, joined);
        this.workingHours = workingHours;
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
    
    // Setter method for shifts
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
        else {
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            terminated = true;
            System.out.println("Staff terminated successfully.");
        }
    }
    
    @Override
    public void display() {
        super.display();
        if (getJoined()) {
            System.out.println("Working Hours: " +workingHours);
            System.out.println("Wages Per Hour: " +wagesPerHour);
            System.out.println("Shifts: " +shifts);
            System.out.println("Terminated: " +terminated);
            System.out.println("Daily Income: " +(wagesPerHour * workingHours));
        }
    }
} 
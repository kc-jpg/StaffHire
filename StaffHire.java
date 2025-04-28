public class StaffHire {
    private int vacancyNumber;
    private String designationType;
    private String jobType;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
    
    public StaffHire(int vacancyNumber, String designationType,String jobType,
    String staffName, String joiningDate, String qualification, 
    String appointedBy, boolean joined) {
        this.vacancyNumber = vacancyNumber;
        this.designationType = designationType;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
     }
    
     //Getter and Setter methods
    public int getVacancyNumber() {
        return vacancyNumber;
    }
    public void setVacancyNumber(int vacancyNumber){
        this.vacancyNumber = vacancyNumber;
    }
    
    public String getDesignationType() {
        return designationType;
    }
    public void setDesignationType() {
        this.designationType = designationType;
    }
    
    public String getJobType(){
        return jobType;
    }
    public void setJobType(String jobType){
        this.jobType = jobType;
    }
    
    public String getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    
    public String getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }
    
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification){
        this.qualification = qualification;
    }
    
    public String getAppointedBy() {
        return appointedBy;
    }
    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }
    
    public boolean getJoined() {
        return joined;
    }
    public void setJoined(boolean joined){
        this.joined = joined;
    }
    
    public void Hired(String NewName, String NewJoiningDate, String NewQualification,
    String NewAppointedBy) {
        if( joined == false) {
            staffName = NewName;
            joiningDate = NewJoiningDate;
            qualification = NewQualification;
            appointedBy = NewAppointedBy;
            joined = true;
        }
        else{
            System.out.println("A Staff Member is already assigned to this position");
        }
    }
    
    public void display() {
        System.out.println("Vacancy Number: " +vacancyNumber);
        System.out.println("Designation: " +designationType);
        System.out.println("Job Type: " +jobType);
        System.out.println("Staff Name: " +staffName);
        System.out.println("Joining Date: " +joiningDate);
        System.out.println("Qualification: " +qualification);
        System.out.println("Appointed By: " +appointedBy);
        System.out.println("Joined: " +joined);
    }
}
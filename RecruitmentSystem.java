//import the necessary swing and event handling libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
//stating this class will build the GUI and manage staff data
public class RecruitmentSystem extends JFrame implements ActionListener {
    private ArrayList<StaffHire> staffList = new ArrayList<>();
    //array list to store both fulltime and parttime staffhire objects
    //GUI components
    private JTextField txtVacancyNumber, txtDesignationType, txtJobType, txtStaffName,
    txtJoiningDate, txtQualification, txtAppointedBy, txtSalary, txtWeeklyFractionalHours, 
    txtWorkingHours, txtWagesPerHour, txtShifts, txtDisplayNumber;
    
    private JButton btnAddFullTime, btnAddPartTime, btnSetSalary, btnSetShifts,
    btnTerminate, btnDisplay, btnClear;
    //constructor to set up the GUI layout and components
    public RecruitmentSystem() {
        setTitle("Recruitment System");
        setLayout(new GridLayout(18,2)); //a layout with 18 rows and 2 columns
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Adding text fields and labels to the frame
        add(new JLabel(" Vacancy Number: "));
        txtVacancyNumber = new JTextField();
        add(txtVacancyNumber);
        
        add(new JLabel(" Designation Type: "));
        txtDesignationType = new JTextField();
        add(txtDesignationType);
        
        add(new JLabel(" Job Type: "));
        txtJobType = new JTextField();
        add(txtJobType);
        
        add(new JLabel(" Staff Name: "));
        txtStaffName = new JTextField();
        add(txtStaffName);
        
        add(new JLabel(" Joining Date: "));
        txtJoiningDate = new JTextField();
        add(txtJoiningDate);
        
        add(new JLabel(" Qualification: "));
        txtQualification = new JTextField();
        add(txtQualification);
        
        add(new JLabel(" Appointed By: "));
        txtAppointedBy = new JTextField();
        add(txtAppointedBy);
        
        add(new JLabel(" Salary (Full Time): "));
        txtSalary = new JTextField();
        add(txtSalary);
        
        add(new JLabel(" Weekly Hours (Full Time): "));
        txtWeeklyFractionalHours = new JTextField();
        add(txtWeeklyFractionalHours);
        
        add(new JLabel(" Working Hours (Part time): "));
        txtWorkingHours = new JTextField();
        add(txtWorkingHours);
        
        add(new JLabel(" Wages Per Hour (Part Time): "));
        txtWagesPerHour = new JTextField();
        add(txtWagesPerHour);
        
        add(new JLabel(" Shifts (Part Time): "));
        txtShifts = new JTextField();
        add(txtShifts);
        
        add(new JLabel(" Display Index: "));
        txtDisplayNumber = new JTextField();
        add(txtDisplayNumber);
        
        //Buttons with the appropriate labels
        btnAddFullTime = new JButton("Add Full Time Staff");
        btnAddPartTime = new JButton("Add Part Time Staff");
        btnSetSalary = new JButton("Set Salary - Full Time");
        btnSetShifts = new JButton("Set Shifts - Part Time");
        btnTerminate = new JButton("Terminate Part Time");
        btnDisplay = new JButton("Display");
        btnClear = new JButton("Clear");
        //adding the buttons to the frame
        add(btnAddFullTime); add(btnAddPartTime);
        add(btnSetSalary); add(btnSetShifts);
        add(btnTerminate); add(btnDisplay);
        add(btnClear);
        
        //Action Listeners registered to the buttons
        btnAddFullTime.addActionListener(this);
        btnAddPartTime.addActionListener(this);
        btnSetSalary.addActionListener(this);
        btnSetShifts.addActionListener(this);
        btnTerminate.addActionListener(this);
        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        //show the GUI window
        setVisible(true);
    }
    //A helper method to safely convert user input into an int for indexing 
    // and checks its within a valid range to avoid errors
    private int getDisplayIndex() {
        try {
            int index = Integer.parseInt(txtDisplayNumber.getText().trim());
            if (index >= 0 && index < staffList.size()) {
                return index;   //when it is a valid index
            } 
            else{   //there is an error with the input
                JOptionPane.showMessageDialog(this, "Index out of range.");
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid index input.");
        }
        return -1;  //error indicator
    }
    
    @Override   //Handling all the button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddFullTime) {  //if the addFullTime button was clicked
            try {   //create and add new FullTimeStaff object to the list
                int vacancy = Integer.parseInt(txtVacancyNumber.getText().trim());
                String designation = txtDesignationType.getText().trim();
                String jobType = txtJobType.getText().trim();
                String staffName = txtStaffName.getText().trim();
                String joiningDate = txtJoiningDate.getText().trim();
                String qualification = txtQualification.getText().trim();
                String appointedBy = txtAppointedBy.getText().trim();
                boolean joined = !staffName.equals("");
                double salary = Double.parseDouble(txtSalary.getText().trim());
                int weeklyHours = Integer.parseInt(txtWeeklyFractionalHours.getText().trim());
                
                FullTimeStaff fullStaff = new FullTimeStaff(vacancy, designation,
                jobType, staffName, joiningDate, qualification, appointedBy, joined,
                salary, weeklyHours);
                staffList.add(fullStaff);
                JOptionPane.showMessageDialog(this, "Full-time staff added.");
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
            }
        }
        else if (e.getSource() == btnAddPartTime) { //if the addPartTime button was clicked
            try {   //create and add new PartTimeStaff object to the list
                int vacancy = Integer.parseInt(txtVacancyNumber.getText().trim());
                String designation = txtDesignationType.getText().trim();
                String jobType = txtJobType.getText().trim();
                String staffName = txtStaffName.getText().trim();
                String joiningDate = txtJobType.getText().trim();
                String qualification = txtQualification.getText().trim();
                String appointedBy = txtAppointedBy.getText().trim();
                boolean joined = !staffName.equals("");
                int workingHours = Integer.parseInt(txtWorkingHours.getText().trim());
                int wagePerHour = Integer.parseInt(txtWagesPerHour.getText().trim());
                String shifts = txtShifts.getText().trim();
                
                PartTimeStaff partStaff = new PartTimeStaff(vacancy, designation,
                jobType, staffName, joiningDate, qualification, appointedBy, joined,
                workingHours, wagePerHour, shifts);
                staffList.add(partStaff);
                JOptionPane.showMessageDialog(this, "Part-time staff added.");
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
            }
        }
        else if (e.getSource() == btnSetSalary) {
            int index = getDisplayIndex();
            //checking if index is valid and the object there is a FullTimeStaff
            if (index != -1 && staffList.get(index) instanceof FullTimeStaff) {
                FullTimeStaff staff = (FullTimeStaff) staffList.get(index);
                double newSalary = Double.parseDouble(txtSalary.getText().trim());
                staff.setSalary(newSalary);
                JOptionPane.showMessageDialog(this, "Salary updated.");
            }
        }
        else if (e.getSource() == btnSetShifts) {
            int index = getDisplayIndex();
            //checking if index is valid and the object there is a PartTimeStaff
            if (index != -1 && staffList.get(index) instanceof PartTimeStaff) {
                PartTimeStaff staff = (PartTimeStaff) staffList.get(index);
                String newShift = txtShifts.getText().trim();
                staff.setShifts(newShift);
                JOptionPane.showMessageDialog(this, "Shifts updated.");
            }
        } 
        else if (e.getSource() == btnTerminate) {
            int index = getDisplayIndex();
            //checking if index is valid and the object there is a PartTimeStaff
            if (index != -1 && staffList.get(index) instanceof PartTimeStaff) {
                PartTimeStaff staff = (PartTimeStaff) staffList.get(index);
                staff.terminateStaff();
            }
        }
        else if (e.getSource() == btnDisplay) {
            int index = getDisplayIndex();
            //Display staff info by calling the display() method
            if (index != -1) {
                staffList.get(index).display(); //prints to console
            }
        }
        else if (e.getSource() == btnClear) {
            //Loop through all of the components and clear and JTextField
            for (Component c : getContentPane().getComponents()) {
                if (c instanceof JTextField) {
                    ((JTextField) c).setText(""); //to clear the text field
                }
            }
        }
    }
    //main method to run the program
    public static void main(String[] args) {
        new RecruitmentSystem(); //to launch the GUI
    }
}

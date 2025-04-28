import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class RecruitmentSystem extends JFrame implements ActionListener {
    private ArrayList<StaffHire> staffList = new ArrayList<>();
    
    //GUI components
    private JTextField txtVacancyNumber, txtDesignationType, txtJobType, txtStaffName,
    txtJoiningDate, txtQualification, txtAppointedBy, txtSalary, txtWeeklyFractionalHours, 
    txtWorkingHours, txtWagesPerHour, txtShifts, txtDisplayNumber;
    
    private JButton btnAddFullTime, btnAddPartTime, btnSetSalary, btnSetShifts,
    btnTerminate, btnDisplay, btnClear;
    
    public RecruitmentSystem() {
        setTitle("Recruitment System");
        setLayout(new GridLayout(18,2));
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Add fields and labels
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
        
        //Buttons
        btnAddFullTime = new JButton("Add Full Time Staff");
        btnAddPartTime = new JButton("Add Part Time Staff");
        btnSetSalary = new JButton("Set Salary - Full Time");
        btnSetShifts = new JButton("Set Shifts - Part Time");
        btnTerminate = new JButton("Terminate Part Time");
        btnDisplay = new JButton("Display");
        btnClear = new JButton("Clear");
        
        add(btnAddFullTime); add(btnAddPartTime);
        add(btnSetSalary); add(btnSetShifts);
        add(btnTerminate); add(btnDisplay);
        add(btnClear);
        
        //Action Listeners
        btnAddFullTime.addActionListener(this);
        btnAddPartTime.addActionListener(this);
        btnSetSalary.addActionListener(this);
        btnSetShifts.addActionListener(this);
        btnTerminate.addActionListener(this);
        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        
        setVisible(true);
    }
    
    private int getDisplayIndex() {
        try {
            int index = Integer.parseInt(txtDisplayNumber.getText().trim());
            if (index >= 0 && index < staffList.size()) {
                return index;
            } 
            else{
                JOptionPane.showMessageDialog(this, "Index out of range.");
            }
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid index input.");
        }
        return -1;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAddFullTime) {
            try {
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
        else if (e.getSource() == btnAddPartTime) {
            try {
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
            if (index != -1 && staffList.get(index) instanceof FullTimeStaff) {
                FullTimeStaff staff = (FullTimeStaff) staffList.get(index);
                double newSalary = Double.parseDouble(txtSalary.getText().trim());
                staff.setSalary(newSalary);
                JOptionPane.showMessageDialog(this, "Salary updated.");
            }
        }
        else if (e.getSource() == btnSetShifts) {
            int index = getDisplayIndex();
            if (index != -1 && staffList.get(index) instanceof PartTimeStaff) {
                PartTimeStaff staff = (PartTimeStaff) staffList.get(index);
                String newShift = txtShifts.getText().trim();
                staff.setShifts(newShift);
                JOptionPane.showMessageDialog(this, "Shifts updated.");
            }
        } 
        else if (e.getSource() == btnTerminate) {
            int index = getDisplayIndex();
            if (index != -1 && staffList.get(index) instanceof PartTimeStaff) {
                PartTimeStaff staff = (PartTimeStaff) staffList.get(index);
                String newShift = txtShifts.getText().trim();
                staff.setShifts(newShift);
                JOptionPane.showMessageDialog(this, "Shifts updated.");
            }
        }
        else if (e.getSource() == btnDisplay) {
            int index = getDisplayIndex();
            if (index != -1) {
                staffList.get(index).display();
            }
        }
        else if (e.getSource() == btnClear) {
            for (Component c : getContentPane().getComponents()) {
                if (c instanceof JTextField) {
                    ((JTextField) c).setText("");
                }
            }
        }
    }
    public static void main(String[] args) {
        new RecruitmentSystem();
    }
}

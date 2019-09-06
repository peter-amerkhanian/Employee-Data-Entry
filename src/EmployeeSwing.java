import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EmployeeSwing extends JFrame implements ActionListener {
    // GUI dimensions
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;
    // Input fields
    private JTextField name;
    private JTextField age;
    private JTextField hourlySalary;
    private JTextField hours;
    // Dynamic label
    private JLabel currentEmployee;
    // Employee counting
    private int employeeCount = 1;
    private int totalEmployeeCount;
    // Error message
    private String inErrorMessage = "Incorrect Input Format. Please enter a positive, non-zero number, i.e. 4";
    // Resulting list of employees
    private ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeSwing() {
        super();
        // Initialize the GUI
        setTitle("Employee Spreadsheet Creator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = getContentPane();
        content.setLayout(new GridLayout(4, 1));
        content.setBackground(Color.WHITE);
        // Get user input for how many employees will be entered
        JOptionPane in = new JOptionPane();
        while (true) {
            String strResponse = in.showInputDialog(
                    null,
                    "How many employees will you be entering?",
                    "Employee Spreadsheet Creator",
                    JOptionPane.INFORMATION_MESSAGE);
            if (strResponse != null) {
                try {
                    totalEmployeeCount = Integer.parseInt(strResponse);
                    if (totalEmployeeCount <= 0) {
                        JOptionPane.showMessageDialog(null, inErrorMessage);
                    } else {
                        break;
                    }
                } catch (Exception NumberFormatException) {
                    JOptionPane.showMessageDialog(null, inErrorMessage);
                }
            } else {
                System.exit(0);
            }
        }

        // Build panes for each input
        // Name
        JPanel buttonPane1 = new JPanel();
        buttonPane1.setBackground(Color.LIGHT_GRAY);
        JLabel nameLabel = new JLabel("Name: ");
        name = new JTextField(15);
        buttonPane1.add(nameLabel);
        buttonPane1.add(name);
        // Hourly Salary
        JPanel buttonPane2 = new JPanel();
        buttonPane2.setBackground(Color.WHITE);
        JLabel hourlySalaryLabel = new JLabel("Hourly Salary: ");
        hourlySalary = new JTextField(8);
        buttonPane2.add(hourlySalaryLabel);
        buttonPane2.add(hourlySalary);
        // Hours
        JPanel buttonPane3 = new JPanel();
        buttonPane3.setBackground(Color.LIGHT_GRAY);
        JLabel hoursLabel = new JLabel("Hours Worked: ");
        hours = new JTextField(8);
        buttonPane3.add(hoursLabel);
        buttonPane3.add(hours);
        // "Enter" and "Clear" buttons
        JPanel buttonPane4 = new JPanel();
        buttonPane4.setBackground(Color.WHITE);
        JButton enter = new JButton("Enter");
        enter.addActionListener(this);
        JButton clear = new JButton("Clear");
        clear.addActionListener(this);
        currentEmployee = new JLabel(String.format("Employee %s of %s", employeeCount, totalEmployeeCount));
        buttonPane4.add(enter);
        buttonPane4.add(clear);
        buttonPane4.add(currentEmployee);
        // Add all panes to the GUI
        content.add(buttonPane1);
        content.add(buttonPane2);
        content.add(buttonPane3);
        content.add(buttonPane4);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter")) {
            try {
                Employee newEmployee = new Employee(
                        name.getText(),
                        0,
                        Double.parseDouble(hourlySalary.getText().replace("$", "")),
                        Double.parseDouble(hours.getText()));
                employees.add(newEmployee);
                employeeCount++;
                clear();
                if (employeeCount > totalEmployeeCount) {
                    String successMessage = "All employees successfully entered!\n" +
                            "Results have been exported to employee.csv";
                    JOptionPane.showMessageDialog(null, successMessage);
                    Employee.printSalaryReport(employees);
                    dispose();
                } else {
                    currentEmployee.setText(String.format("Employee %s of %s", employeeCount, totalEmployeeCount));
                }
            } catch (impossibleHoursException | NumberFormatException | negativeNumberException error) {
                JOptionPane.showMessageDialog(null, String.format("ERROR: %s", error.getMessage()));
            }
        } else if (e.getActionCommand().equals("Clear")) {
            clear();
        } else {
            System.out.println("Button Error");
        }

    }

    /**
     * Clears the user's input
     * Helper method for actionPerformed
     */
    private void clear() {
        this.name.setText(null);
        this.hourlySalary.setText(null);
        this.hours.setText(null);
    }
}

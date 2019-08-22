import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstSwingWindow extends JFrame implements ActionListener {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;
    private JTextField name;
    private JTextField age;
    private JTextField hourlySalary;
    private JTextField hours;
    private JLabel currentEmployee;
    private int employeeCount = 1;

    public FirstSwingWindow() {
        super();
        setTitle("First Window");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container content = getContentPane();
        content.setLayout(new GridLayout(5,1));
        content.setBackground(Color.WHITE);

        JPanel buttonPane1 = new JPanel();
        buttonPane1.setBackground(Color.LIGHT_GRAY);
        JLabel nameLabel = new JLabel("Name: ");
        name = new JTextField(15);
        buttonPane1.add(nameLabel);
        buttonPane1.add(name);

        JPanel buttonPane2 = new JPanel();
        buttonPane2.setBackground(Color.WHITE);
        JLabel ageLabel = new JLabel("Age: ");
        age = new JTextField(8);
        buttonPane2.add(ageLabel);
        buttonPane2.add(age);

        JPanel buttonPane3 = new JPanel();
        buttonPane3.setBackground(Color.LIGHT_GRAY);
        JLabel hourlySalaryLabel = new JLabel("Hourly Salary: ");
        hourlySalary = new JTextField(8);
        buttonPane3.add(hourlySalaryLabel);
        buttonPane3.add(hourlySalary);

        JPanel buttonPane4 = new JPanel();
        buttonPane4.setBackground(Color.WHITE);
        JLabel hoursLabel = new JLabel("Hours Worked: ");
        hours = new JTextField(8);
        buttonPane4.add(hoursLabel);
        buttonPane4.add(hours);

        JPanel buttonPane5 = new JPanel();
        buttonPane5.setBackground(Color.LIGHT_GRAY);
        JButton enter = new JButton("Enter");
        enter.addActionListener(this);
        currentEmployee = new JLabel(String.format("Employee %s of 12", employeeCount));
        buttonPane5.add(enter);
        buttonPane5.add(currentEmployee);

        content.add(buttonPane1);
        content.add(buttonPane2);
        content.add(buttonPane3);
        content.add(buttonPane4);
        content.add(buttonPane5);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter")) {
            String message = new Employee(
                    name.getText(),
                    Integer.parseInt(age.getText()),
                    Double.parseDouble(hourlySalary.getText()),
                    Double.parseDouble(hours.getText())).toString();
            JOptionPane.showMessageDialog(null, message);
            employeeCount ++;
            currentEmployee.setText(String.format("Employee %s of 12", employeeCount));
            name.setText("");
            age.setText("");
            hourlySalary.setText("");
            hours.setText("");
        }
        else {
            System.out.println("Button Error");
        }

    }

}

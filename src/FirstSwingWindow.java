import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstSwingWindow extends JFrame implements ActionListener {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public FirstSwingWindow() {
        super();
        setTitle("First Window");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.WHITE);

        JPanel infoPanel = new JPanel();
        JLabel nameLabel = new JLabel("Name");
        JTextField name = new JTextField();
        infoPanel.setLayout(new FlowLayout());
        infoPanel.add(nameLabel);
        infoPanel.add(name);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.WHITE);


        JButton ageField = new JButton("Enter");
        ageField.addActionListener(this);
        buttonPanel.add(ageField);

        JLabel nameField = new JLabel("Employee 1 of 12");
        buttonPanel.add(nameField);

        content.add(buttonPanel, BorderLayout.SOUTH);
        content.add(infoPanel, BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {
        Container content = getContentPane();

        if (e.getActionCommand().equals("Enter"))
            content.setBackground(Color.GRAY);
        else
            System.out.println("Error");

    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistrationForm extends JFrame implements ActionListener {
    JLabel nameLabel, genderLabel, courseLabel, addressLabel;
    JTextField nameField;
    JRadioButton maleButton, femaleButton;
    JComboBox<String> courseBox;
    JTextArea addressArea;
    JButton submitButton, clearButton;
    ButtonGroup genderGroup;

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        genderLabel = new JLabel("Gender:");
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);

        courseLabel = new JLabel("Course:");
        String[] courses = { "B.Tech", "B.Sc", "B.Com", "BA", "M.Tech", "M.Sc" };
        courseBox = new JComboBox<>(courses);

        addressLabel = new JLabel("Address:");
        addressArea = new JTextArea(3, 20);
        JScrollPane addressScroll = new JScrollPane(addressArea);

        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");

        submitButton.addActionListener(this);
        clearButton.addActionListener(this);

        add(nameLabel);      add(nameField);
        add(genderLabel);    add(genderPanel);
        add(courseLabel);    add(courseBox);
        add(addressLabel);   add(addressScroll);
        add(submitButton);   add(clearButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Not selected";
            String course = (String) courseBox.getSelectedItem();
            String address = addressArea.getText();

            JOptionPane.showMessageDialog(this,
                "Registration Details:\n" +
                "Name: " + name + "\n" +
                "Gender: " + gender + "\n" +
                "Course: " + course + "\n" +
                "Address: " + address,
                "Registration Successful",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else if (e.getSource() == clearButton) {
            nameField.setText("");
            genderGroup.clearSelection();
            courseBox.setSelectedIndex(0);
            addressArea.setText("");
        }
    }

    public static void main(String[] args) {
        new StudentRegistrationForm();
    }
}
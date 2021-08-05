import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterAdmin implements ActionListener {

    JFrame frame = new JFrame("Restaurant Reservation System");
    JLabel registerLabel = new JLabel("Enter details:");
    JLabel nameLabel = new JLabel("Full Name");
    JLabel staffIDLabel = new JLabel("Staff ID");
    JLabel passwordLabel = new JLabel("Password");
    JLabel confirmLabel = new JLabel("Confirm \r\n Password");
    JButton registerbutton = new JButton("Register");
    JButton backbutton = new JButton("Back");
    JTextField nameField = new JTextField();
    JTextField staffIDField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmField = new JPasswordField();

    public RegisterAdmin() {

        nameLabel.setBounds(50, 100, 100, 25);
        staffIDLabel.setBounds(50, 130, 100, 25);
        passwordLabel.setBounds(50, 160, 100, 25);
        confirmLabel.setBounds(50, 190, 100, 25);

        registerLabel.setBounds(20, 50, 300, 30);
        registerLabel.setFont(new Font(null, Font.ITALIC, 15));

        nameField.setBounds(150, 100, 200, 25);
        staffIDField.setBounds(150, 130, 200, 25);
        passwordField.setBounds(150, 160, 200, 25);
        confirmField.setBounds(150, 190, 200, 25);

        registerbutton.setBounds(100, 270, 200, 30);
        registerbutton.setFocusable(false);
        registerbutton.addActionListener(this);

        backbutton.setBounds(10, 10, 70, 30);
        backbutton.setFocusable(false);
        backbutton.addActionListener(this);

        frame.add(registerbutton);
        frame.add(backbutton);
        frame.add(nameLabel);
        frame.add(staffIDLabel);
        frame.add(passwordLabel);
        frame.add(confirmLabel);
        frame.add(registerLabel);
        frame.add(nameField);
        frame.add(staffIDField);
        frame.add(passwordField);
        frame.add(confirmField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == registerbutton) {
                String name = nameField.getText();
                String id = staffIDField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String confirm = String.valueOf(confirmField.getPassword());

                if (name.isEmpty() || password.isEmpty() || confirm.isEmpty() || id.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter your details");
                } else {
                    if(password.equals(confirm)){
                        JOptionPane.showMessageDialog(null, "Registration success\n\rID: " + id +"\r\nPassword: " + password);
                        CheckLogin checkLogin = new CheckLogin();
                        checkLogin.WriteLogin(name.toUpperCase(), id,password,confirm);
                        WelcomePage welcomePage = new WelcomePage();
                        frame.dispose();

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Password do not match");
                    }
                }
            }
            else if(e.getSource() == backbutton){

                AdminPage adminPage = new AdminPage();
                frame.dispose();
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error Occur!!");
        }
    }
}

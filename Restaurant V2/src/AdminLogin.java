import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class AdminLogin implements ActionListener {

    private static Scanner x;
    private static String filepath = "StaffLogin.txt";

    JFrame frame = new JFrame("Restaurant Reservation System");
    JLabel adminLabel = new JLabel("Admin ID");
    JLabel passwordLabel = new JLabel("Password");
    JLabel messageLabel = new JLabel();
    JTextField adminField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginbutton = new JButton("Login");
    JButton resetbutton = new JButton("Reset");
    JButton backbutton = new JButton("Back");

    AdminLogin(){

        adminLabel.setBounds(50, 120, 100, 25);
        passwordLabel.setBounds(50, 160, 100, 25);

        adminField.setBounds(150, 120, 200, 25);
        passwordField.setBounds(150, 160, 200, 25);

        loginbutton.setBounds(100, 210, 200, 30);
        loginbutton.setFocusable(false);
        loginbutton.addActionListener(this);

        resetbutton.setBounds(100, 260, 200, 30);
        resetbutton.setFocusable(false);
        resetbutton.addActionListener(this);

        backbutton.setBounds(10, 10, 70, 30);
        backbutton.setFocusable(false);
        backbutton.addActionListener(this);

        frame.add(loginbutton);
        frame.add(resetbutton);
        frame.add(backbutton);
        frame.add(messageLabel);
        frame.add(adminField);
        frame.add(passwordField);
        frame.add(adminLabel);
        frame.add(passwordLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean found = false;
        try {

            if (e.getSource() == loginbutton) {

                String admin = adminField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (admin.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter your ID & password");
                } else {
                    CheckLogin checkLogin = new CheckLogin();
                    found=checkLogin.ReadLogin(admin, password);
                }
                if(found){

                    frame.dispose();
                }
            }
            else if (e.getSource() == resetbutton) {

                    adminField.setText("");
                    passwordField.setText("");

                } else if (e.getSource() == backbutton) {

                    WelcomePage welcomePage = new WelcomePage();
                }
        }catch (Exception E) {
            messageLabel.setForeground(Color.red);
            messageLabel.setText("Error Occur !!");
        }
    }
}


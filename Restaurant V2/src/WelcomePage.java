import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {

    JFrame frame = new JFrame("Restaurant Reservation System");
    JLabel welcomePage = new JLabel("WELCOME TO ABC RESTAURANT");
    JLabel messageLabel = new JLabel();
    JButton reservationbutton = new JButton("Make Reservation");
    JButton checkbutton = new JButton("Check Reservation");
    JButton adminbutton = new JButton("Admin");

    public static void main(String[] args) {

        WelcomePage welcomePage = new WelcomePage();
    }

    public WelcomePage(){

        messageLabel.setBounds(150,300,300,30);
        messageLabel.setFont(new Font(null,Font.ITALIC,15));

        welcomePage.setBounds(75,40,300,30);
        welcomePage.setFont(new Font(null,Font.BOLD,15));

        reservationbutton.setBounds(100,90,200,100);
        reservationbutton.setFocusable(false);
        reservationbutton.addActionListener(this);

        checkbutton.setBounds(100,220,200,100);
        checkbutton.setFocusable(false);
        checkbutton.addActionListener(this);

        adminbutton.setBounds(10, 10, 70, 20);
        adminbutton.setFocusable(false);
        adminbutton.addActionListener(this);

        frame.add(reservationbutton);
        frame.add(checkbutton);
        frame.add(adminbutton);
        frame.add(messageLabel);
        frame.add(welcomePage);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if(e.getSource()==reservationbutton){

                MakeReservation makeReservation = new MakeReservation();
                frame.dispose();

            }

            else if(e.getSource()==checkbutton){

                CheckReservation checkReservation = new CheckReservation();
                frame.dispose();

            }
            else if(e.getSource()==adminbutton){

                AdminLogin adminLogin = new AdminLogin();
                frame.dispose();
            }
        }
        catch(Exception E){
            JOptionPane.showMessageDialog(null,"Error Occur !!");
        }
    }
}




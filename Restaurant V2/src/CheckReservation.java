import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckReservation implements ActionListener {

    JFrame frame = new JFrame("Restaurant Reservation System");
    JButton checkbutton = new JButton("Check");
    JButton backbutton = new JButton("Back");
    JTextField bookingIDField = new JTextField();
    JLabel bookingIDLabel = new JLabel("Booking ID");
    JLabel messageLabel = new JLabel();

    public CheckReservation(){

        bookingIDLabel.setBounds(50, 100, 100, 30);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        bookingIDField.setBounds(150, 100, 200, 25);

        checkbutton.setBounds(100, 150, 200, 30);
        checkbutton.setFocusable(false);
        checkbutton.addActionListener(this);

        backbutton.setBounds(10, 10, 70, 30);
        backbutton.setFocusable(false);
        backbutton.addActionListener(this);

        frame.add(bookingIDLabel);
        frame.add(bookingIDField);
        frame.add(messageLabel);
        frame.add(checkbutton);
        frame.add(backbutton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean found = false;
        try {
            if (e.getSource() == checkbutton) {

                String bookingID = bookingIDField.getText();
                BookingInfo bookingInfo = new BookingInfo();
                found = bookingInfo.ReadRecord(bookingID);

                if(found){
                    frame.dispose();
                }
            }
            else if (e.getSource() == backbutton){

                WelcomePage welcomePage = new WelcomePage();
                frame.dispose();

            }

        }
        catch(Exception E){
            JOptionPane.showMessageDialog(null,"Error Occur!!");
        }
    }
}

import javax.swing.*;
import java.awt.*;

public class BookingDetails {

    JFrame frame = new JFrame("Restaurant Reservation System");
    JLabel bookingID = new JLabel();
    JLabel nameID = new JLabel();
    JLabel dateID = new JLabel();
    JLabel timeID = new JLabel();
    JLabel dinersID = new JLabel();
    JLabel descriptions = new JLabel("Your booking details: ");

    BookingDetails(String[] details){

        descriptions.setBounds(100,50,300,30);
        descriptions.setFont(new Font(null,Font.ITALIC,20));
        bookingID.setText("Booking ID: "+details[0]);
        bookingID.setBounds(100,90,300,30);
        bookingID.setFont(new Font(null,Font.ITALIC,20));
        nameID.setText("Name: " + details[1]);
        nameID.setBounds(100,130,300,30);
        nameID.setFont(new Font(null,Font.ITALIC,20));
        dateID.setText("Date: " + details[3]);
        dateID.setBounds(100,170,300,30);
        dateID.setFont(new Font(null,Font.ITALIC,20));
        timeID.setText("Time: "+details[4]+" hours");
        timeID.setBounds(100,210,300,30);
        timeID.setFont(new Font(null,Font.ITALIC,20));
        dinersID.setText("Number of Diners: " + details[5]);
        dinersID.setBounds(100,250,300,30);
        dinersID.setFont(new Font(null,Font.ITALIC,20));

        frame.add(bookingID);
        frame.add(dateID);
        frame.add(timeID);
        frame.add(nameID);
        frame.add(dinersID);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

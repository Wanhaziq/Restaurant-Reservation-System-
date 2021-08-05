import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.util.Random;

public class MakeReservation implements ActionListener {

    JFrame frame = new JFrame("Restaurant Reservation System");
    JLabel bookingLabel = new JLabel("Enter your reservation details:");
    JLabel messageLabel = new JLabel();
    JLabel nameLabel = new JLabel("Full Name");
    JLabel contactLabel = new JLabel("Contact Number");
    JLabel dateLabel = new JLabel("Booking Date");
    JLabel timeLabel = new JLabel("Dine Time");
    JLabel numOfPeopleLabel = new JLabel("<html>Number of<br/>People</html>");
    JButton reservebutton = new JButton("Reserve");
    JButton resetbutton = new JButton("Reset");
    JButton backbutton = new JButton("Back");
    JTextField nameField = new HintTextField("Full Name");
    JTextField contactField = new HintTextField("Without '-' ex. 0123456789");
    JTextField dateField = new HintTextField("DD/MM/YY");
    JTextField timeField = new HintTextField("HH.MM ex. 13.00 ");
    JTextField numberOfPeopleField = new HintTextField("Enter Whole Number");

    public MakeReservation() {

        nameLabel.setBounds(50, 100, 100, 25);
        contactLabel.setBounds(50, 130, 100, 25);
        dateLabel.setBounds(50, 160, 100, 25);
        timeLabel.setBounds(50, 190, 100, 25);
        numOfPeopleLabel.setBounds(50, 220, 100, 30);

        messageLabel.setBounds(100, 200, 300, 30);
        messageLabel.setFont(new Font(null, Font.ITALIC, 15));

        bookingLabel.setBounds(20, 50, 300, 30);
        bookingLabel.setFont(new Font(null, Font.ITALIC, 15));

        nameField.setBounds(150, 100, 200, 25);
        contactField.setBounds(150, 130, 200, 25);
        dateField.setBounds(150, 160, 200, 25);
        timeField.setBounds(150, 190, 200, 25);
        numberOfPeopleField.setBounds(150, 220, 200, 25);

        reservebutton.setBounds(100, 270, 200, 30);
        reservebutton.setFocusable(false);
        reservebutton.addActionListener(this);

        resetbutton.setBounds(100, 320, 200, 30);
        resetbutton.setFocusable(false);
        resetbutton.addActionListener(this);

        backbutton.setBounds(10, 10, 70, 30);
        backbutton.setFocusable(false);
        backbutton.addActionListener(this);

        frame.add(reservebutton);
        frame.add(resetbutton);
        frame.add(backbutton);
        frame.add(messageLabel);
        frame.add(bookingLabel);
        frame.add(nameLabel);
        frame.add(dateLabel);
        frame.add(timeLabel);
        frame.add(contactLabel);
        frame.add(numOfPeopleLabel);
        frame.add(numberOfPeopleField);
        frame.add(dateField);
        frame.add(timeField);
        frame.add(nameField);
        frame.add(contactField);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if (e.getSource() == reservebutton) {

                messageLabel.setForeground(Color.green);
                messageLabel.setText("reserve");
                String name = nameField.getText();
                String contact = contactField.getText();
                String date = dateField.getText();
                String time = timeField.getText();
                String people = numberOfPeopleField.getText();
                if (name.isEmpty() || contact.isEmpty() || time.isEmpty() || date.isEmpty() || people.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please insert your booking details");
                }
                else {
                    Random rand = new Random();
                    int bookingID = (int) (10000 * (rand.nextDouble()));
                    String ID = Integer.toString(bookingID);

                    BookingInfo bookingInfo = new BookingInfo();
                    bookingInfo.WriteRecord(ID, name, contact, date, time, people);
                    String[] reservationDetail = {ID, name, contact, date, time, people};
                    BookingDetails bookingDetails = new BookingDetails(reservationDetail);
                    frame.dispose();
                }

            } else if (e.getSource() == resetbutton) {

                nameField.setText("");
                contactField.setText("");
                dateField.setText("");
                timeField.setText("");
                numberOfPeopleField.setText("");

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
    class HintTextField extends JTextField implements FocusListener {

        private final String hint;
        private boolean showingHint;

        public HintTextField(final String hint) {
            super(hint);
            this.hint = hint;
            this.showingHint = true;
            super.addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText("");
                showingHint = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText(hint);
                showingHint = true;
            }
        }

        @Override
        public String getText() {
            return showingHint ? "" : super.getText();
        }
    }

}


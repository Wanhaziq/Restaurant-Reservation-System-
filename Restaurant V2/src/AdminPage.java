import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminPage implements ActionListener {

    private static Scanner z;
    String[] header = {"ID","Name","Contact Number", "Date","Time","Diners"};
    JFrame frame = new JFrame("Restaurant Reservation System");
    JLabel descriptions = new JLabel("Reservation details: ");
    JButton registerbutton = new JButton("New User");
    JButton backbutton = new JButton("Back");
    static JTable reservations = new JTable();
//    JScrollPane reservations2 = new JScrollPane(reservations);

    AdminPage(){

        descriptions.setBounds(165,10,300,30);
        descriptions.setFont(new Font(null,Font.ITALIC,20));

        registerbutton.setBounds(100, 420, 300, 30);
        registerbutton.setFocusable(false);
        registerbutton.addActionListener(this);

        backbutton.setBounds(10, 10, 70, 30);
        backbutton.setFocusable(false);
        backbutton.addActionListener(this);

        reservations = new JTable(ReservationTable(),header);
        reservations.setBounds(30,50,450,350);

//        reservations2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        reservations2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.add(registerbutton);
        frame.add(descriptions);
        frame.add(reservations);
        frame.add(backbutton);
//        frame.add(reservations2,BorderLayout.NORTH);
//        frame.add(reservations2,BorderLayout.WEST);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520,520);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == registerbutton) {
                RegisterAdmin registerAdmin = new RegisterAdmin();
                frame.dispose();

            }
            else if(e.getSource() == backbutton){

                WelcomePage welcomePage = new WelcomePage();
                frame.dispose();
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Error Occur!!");
        }
    }
    public static String[][] ReservationTable(){

        ArrayList<String> booking = new ArrayList<String>();
        String[] split;

        try {
            z = new Scanner(new File("Booking Records.txt"));
            while (z.hasNext()) {

                String details = z.nextLine();
                booking.add(details);
            }
            String[][] booking3 = new String[booking.size()][6];
            for (int i = 0; i < booking.size(); i++) {
                String booking1 = booking.get(i);
                split = booking1.split(",");
                for (int j = 0; j < 6; j++) {
                    booking3[i][j] = split[j];
                }
            }
            return booking3;

        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Error occur!!");
        }
        return null;
    }
//    public static void main(String[] args) {
//        AdminPage adminPage = new AdminPage();
//    }
}

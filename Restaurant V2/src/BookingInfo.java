import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class BookingInfo<found> {

    private static Scanner x;
    private static String filepath = "Booking Records.txt";

    public static void WriteRecord(String ID, String name, String contact, String date, String time, String people) {

        try {

            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(ID + "," + name.toUpperCase().trim() + "," + contact + "," + date + "," + time + "," + people);
            pw.flush();
            pw.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Record not saved");
        }
    }

    public static boolean ReadRecord(String ID) {
        boolean found = false;
        String[] booking = new String[6];

        try {
            x = new Scanner(new File(filepath));
            while (x.hasNext() && !found) {

                String details = x.nextLine();
                booking = details.split(",");

                if (booking[0].equals(ID)) {
                    found = true;
                } else {
                    found = false;
                }
            }
            if (found) {
                BookingDetails bookingDetails = new BookingDetails(booking);

            } else {
                JOptionPane.showMessageDialog(null,"No reservation found.\r\nPlease make a reservation");
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Occur!!");
        }
        return found;
    }
}

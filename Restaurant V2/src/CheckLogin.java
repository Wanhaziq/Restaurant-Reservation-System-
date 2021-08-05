import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.util.*;

public class CheckLogin {

    private static Scanner y;
    private static String filepath = "StaffLogin.txt";

    public static void WriteLogin(String name,String ID,String password1,String password2){

        try{
            if(password1.equals(password2)){

                FileWriter fw = new FileWriter(filepath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println(ID + ","+ password1 +","  + name.toUpperCase().trim());
                pw.flush();
                pw.close();

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Record not saved");
        }
    }

    public static boolean ReadLogin(String ID,String password){
        boolean found = false;
        String[] staffDetails = new String[3];

        try{
            y = new Scanner(new File(filepath));
            while(y.hasNext() && !found){

                String details = y.nextLine();
                staffDetails = details.split(",");

                if (staffDetails[0].equals(ID) && staffDetails[1].equals(password)){
                    found = true;
                    AdminPage adminPage = new AdminPage();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Enter correct ID & password");
                    found = false;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error Occur!!");
        }
        return found;
    }
}

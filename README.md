# Restaurant-Reservation-System-
Using JAVA Swing

This system uses build in swing GUI that is code with the simplicity in mind. 

It have a welcome page consist of 3 buttons:
1) Make Reservation 
2) Check Reservation 
3) Admin 

a- Click '1) Make Reservation' it will go to 'Make Reservation' page which ask for booking details:
1) Name
2) Contact Number
3) Date
4) Time
5) Number of Diners
And have a 'Reserve' button when click will place your booking with your booking ID 
and display in 'Booking Details' page.

b- Click '2) Check Reservation' will display textfield to enter your Booking ID.
Have a 'Check' button that will display 'Booking details' page.

Both (a) and (b) have a 'Booking info' class that will check for the details and store it txt format files.

Click '3) Admin' will display a 'Admin Login' page that will ask for:
1) ID
2) password
And have a 'Login' button to go to 'Admin Page' and aso 'Back' button that will go back to 'Welcome Page'.

'Admin Page' will display JTable of ALL reservation details and a 'New User' button.
'New user' will allow Admin to add a new Admin into the system.

'New User' button will go to 'Register Page' that display JTextField to be fill by new admin:
1) Name
2) ID
3) Password
4) Confirm Password
And also a 'Register' button.

'Register' button will go to 'Check Login' class to write the details in .txt file.

both 'Booking Info' & 'Check Login' class have a read & write class to help extract and amend deatils inside the .txt files.

Hope that you can understand the program.
Thanks!!

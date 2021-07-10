package library.management.system;

import java.awt.*;
import javax.swing.*;                                                           // It is used for making "Frame".
import java.awt.event.*;                                                        // It is used for handling "Events".
import java.sql.*;                                                              // It is used for database connection.

public class Login_user extends JFrame implements ActionListener{               // "JFrame" is the class present inside "Swing" Package. It is used for creating frames.
                                                                                // "ActionListener" is an interface. We are implementing this interface for handling events.
    private final JPanel panel;
    private final JTextField textField;
    private final JPasswordField passwordField;
    private final JButton b1,b2,b3;
    
    public Login_user(){                                                        // This is our constructor. All the code of our "Frame" is written inside constructor.
        
        setLayout(null);                                                        // Here we are specifying that we are not going to use default layout.
        setBackground(new Color(169,169,169));
        setBounds(600,300,600,400);                                             // (x-cordinate,y-cordinate, length, breadth)
        
        panel = new JPanel();                                                   // It is same as Html container 'div'.
        panel.setBackground(new Color(176,224,230));
        setContentPane(panel);
        panel.setLayout(null);
        
        
        // We are creating "Lables".
        
        JLabel l1 = new JLabel("Username : ");                                  // "Username Label"
        l1.setBounds(124, 89, 95, 24);
        panel.add(l1);
        
        JLabel l2 = new JLabel("Password : ");                                  // "Password Label"
        l2.setBounds(124, 124, 95, 24);
        panel.add(l2);
        
        
        
        // We are creating our "Feilds" to input data.
        
        textField = new JTextField();                                           // "Feild" for username.
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);
        
        passwordField = new JPasswordField();                                   // "Feild" for password.
        passwordField.setBounds(210,128,157,20);
        panel.add(passwordField);
       
        
        // We are creating Buttons
        
        b1 = new JButton("Login");
        b1.addActionListener(this);      
        
        b1.setForeground(new Color(46,139,87));
        b1.setBackground(new Color(250,250,210));
        b1.setBounds(149,181,113,39);
        panel.add(b1);
        
        
        b2 = new JButton("SignUp");
        b2.addActionListener(this);      
        
        b2.setForeground(new Color(139, 69, 19));
        b2.setBackground(new Color(255,235,205));
        b2.setBounds(289,181,113,39);
        panel.add(b2);
        
        
        
        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);      
        
        b3.setForeground(new Color(205,92,92));
        b3.setBackground(new Color(253,245,230));
        b3.setBounds(199,231,179,39);
        panel.add(b3);
        
        
        // "Trouble In Login" Label.
        
        JLabel l3 = new JLabel("Trouble in Login?");
        l3.setFont(new Font("Tahoma",Font.PLAIN, 15));
        l3.setForeground(new Color(255,0,0));
        l3.setBounds(70,240,130,20);
        panel.add(l3);
        
        
    }

    @Override                                                                   // As we know that "ActionListener" is an interface. Hence it is compulsory to to implement all its methods. So we are 'Over-riding' it.
    public void actionPerformed(ActionEvent e){                                 // "ActionEvent" is a class. "e" is its object, by which we can see which button is clicked.                         
        
        if(e.getSource() == b1)                                                 // If 'b1' (Login) button is clicked.
        {                                               
            Boolean status = false;
            try{
                conn con = new conn();                                                    // Creating Object of our 'conn' class, which is our connection class.  (IMP Note :- Whenever we need data from database or required to manipulate database we are required to create object of our 'conn' class.)
                String sql = "select * from account where username = ? and password = ? ";// This is our SQL Query. Here "?" is just like a placeholder. It will be replaced by "User's input", which is held inside "textFeild" and "passwordFeild" variables.
                PreparedStatement st = con.c.prepareStatement(sql);                       // 1] With the help of "conn" Class Object 'con', calling the 'Connection' interface 'c'.                
                                                                                          // 2] 'prepareStatement()' is the method of "Connection" interface. Using it the Statement 'st' is created.
                                                                                      
                                                                                          
                st.setString(1, textField.getText());                                     // Injecting the "User's Input" inside our created sql-statement. This done using "getText()" method. For setting anything inside our textfeild we can use "setText()".
                st.setString(2, passwordField.getText());                                 // setString() is the method which replaces "?" with user's data.
                
                ResultSet rs = st.executeQuery();                                         // 1] .executeQuery() is used whenever we need to match something inside our database. (Note :- When 'Select' query is present use it.)
                                                                                          // 2] .executeUpdate() is used whenever we are updating the data inside our database.  (Note :- When 'Insert' query is present use it.)
                                                                                          // 3] .executeQuery() has returned "ResultSet" Class's Object. It is stored inside 'rs'.
                                                                                          // 4] 'rs' goes through each row of the table till it finds the data which matches with user's input.                                                                       
                                                                                          
                if(rs.next()){                                                            // If data is found then this code is executed. 
                    this.setVisible(false);                                               // This will close our current frame.(Login_user.java).
                    new Loading().setVisible(true);                                       // We are creating the object of "Loading" Class and set it as 'true'.
                }
                else{                                                                     // If data is not found then this code is executed.
                    JOptionPane.showMessageDialog(null, "Invalid Login!");                // It just shows the pop-up of "Invalid Login".
                }
                
            }
            catch(HeadlessException | SQLException error){
            }
        }    
        
        if(e.getSource() == b2)                                                           // If "b2" (Sign-Up) button is clicked.
        {                                                          
            this.setVisible(false);                                                       // Closing our current frame.
            new Signup().setVisible(true);                                                // We are creating the object of "Signup" Class and making its frame visible.
	
        }   
            
        if(e.getSource() == b3)                                                 // If "b3" (Forgot) button is clicked.
        {                                                          
            this.setVisible(false);                                                   // Closing our Current Frame.
            new Forgot().setVisible(true);                                            // Creating Object of "Forgot" class and making its frame visible.
        }                                                                             // Note : By default all the frames of "Swing" are invisible.
                
    }
    
    public static void main(String[] args){                                     // Entire Code starts running from this line.
        new Login_user().setVisible(true);                                      // Creating the Object of current class and making its frame visible.
    }
}


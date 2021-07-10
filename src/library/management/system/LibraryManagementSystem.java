/************************ Whole Project Starts from here ***********************/
package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener{
    
    JLabel l1;
    JButton b1;
    
    public LibraryManagementSystem() {
        
        setSize(1366,390);
        setLayout(null);
        setLocation(100,300);
        
        l1 = new JLabel("");
        b1 = new JButton("Next");
        
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/first.jpg"));      // Picking the image
        Image i2 = i1.getImage().getScaledInstance(1366, 390,Image.SCALE_DEFAULT);                                      // Changing size and putting into new object.
        ImageIcon i3 = new ImageIcon(i2);                                                                               // Giving this to the constructor of new object.
        l1 = new JLabel(i3);                                                                                            // Finally giving it to label.
        
        b1.setBounds(1050,250,200,60);
	l1.setBounds(0, 0, 1366, 390);
        
        l1.add(b1);               // Adding button into label
	this.add(l1);             // Adding label to current frame.
        
         b1.addActionListener(this);  // Attaching action listener to our button.
    } 
    
    public static void main(String[] args) {
        new LibraryManagementSystem().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Login_user().setVisible(true);
        this.setVisible(false);
    }
    
}

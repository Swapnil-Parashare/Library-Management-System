package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable{
    
    /* Here we have used "Multi-Threading".
       It can be done using two ways :- 1] Extends Thread         (Thread is a class)
                                        2] Implements Runnable    (Runnable is a interface)
       
        As java does not allow "Multiple Inheritance". We can achieve is using "interfaces".
        Hence we are using 2nd Method.
        As we cannot do ----> public class Loading extends JFrame, Thread{....}
    */
    
    private JPanel contentPane;
    private JProgressBar progressBar;
    Connection conn;
    int s;
    Thread th;
    
    public static void main(String[] args){
        new Loading().setVisible(true);                                         // Making our current class frame visible.
    }
    
    public void setUploading() {
            setVisible(false);
            th.start();                                                         // Here we are calling 'start' method on Thread Object, this will internally call run() method specified below.
    }

    @Override
    public void run() {
            try {
                for (int i = 0; i < 200; i++) {
                    s = s + 1;
                    int m = progressBar.getMaximum();// 100
                    int v = progressBar.getValue();  // Initially 0.
                    if (v < m) {
                        progressBar.setValue(progressBar.getValue() + 1);
                    } 
                    else {                                                      // This is the instance were "Current Value" of Progress Bar is equal to its "Maximum Vallue"
                        i = 201;
                        setVisible(false);                                      // We are closing our current frame
                        new Home().setVisible(true);                            // Here we are opening our new frame.
                    }
                    Thread.sleep(50);                                           // Before doing each increment we are waiting for 50ms.
                }
            } catch (Exception e) {
		e.printStackTrace();
            }
    }
    
    public  Loading() {                                                         // This is our Constructor, all code is written inside it.
        
        super("Loading");                                                       // It sets the heading of the frame. It should be the first statement.
        
        th = new Thread((Runnable) this);                                       // Creating Object of "Thread" Class.
        
        setBounds(600,300,600,400);
        contentPane = new JPanel();   // It is like a container.
        setContentPane(contentPane);
        contentPane.setLayout(null);  // Specifying that we are not going to use default layout.
        
        // Creating our Heading Label
        JLabel lbllibraryManagement = new JLabel("Smart Library v5.1");
        lbllibraryManagement.setForeground(new Color(72, 209, 204));
        lbllibraryManagement.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lbllibraryManagement.setBounds(130, 46, 500, 35);
        contentPane.add(lbllibraryManagement);                                  // Adding our Label in the container.
        
        // Creating our Progress Bar.
        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        contentPane.add(progressBar);                                           // Adding our Progress Bar in the Container.
        
        // Creating our Please Wait Label
        JLabel lblNewLabel_2 = new JLabel("Please Wait....");
        lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblNewLabel_2.setForeground(new Color(160, 82, 45));
        lblNewLabel_2.setBounds(200, 165, 150, 20);
        contentPane.add(lblNewLabel_2);
        
        // Creating a Seprate Panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 590, 390);
        contentPane.add(panel);
        
        setUploading();
    }
    
    
}

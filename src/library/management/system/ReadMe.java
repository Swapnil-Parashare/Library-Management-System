package library.management.system;

import java.awt.*;
import javax.swing.*;

public class ReadMe extends JFrame{
    
    private JPanel contentPane;
    
    public static void main(String[] args){
        new ReadMe().setVisible(true);
    }
    
    public ReadMe() {
        
        super("Read Me - Library Management System");
        setBounds(500,250,700,500);
        
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel l3 = new JLabel("Library");
        l3.setForeground(new Color(0,250,154));
        l3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
        l3.setBounds(160,40,150,55);
        contentPane.add(l3);
        
        JLabel l4 = new JLabel("Management System");
        l4.setForeground(new Color(127,255,0));
        l4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 34));
        l4.setBounds(70,90,405,40);
        contentPane.add(l4);
        
        JLabel l5 = new JLabel("v11.3");
        l5.setForeground(new Color(30,144,255));
        l5.setFont(new Font("Trebuchet MS", Font.BOLD , 25));
        l5.setBounds(185,140,100,21);
        contentPane.add(l5);
        
        JTextArea l6 = new JTextArea("Developed By :- Swapnil Parashare");
        l6.setForeground(new Color(30,144,255));
        l6.setFont(new Font("Trebuchet MS", Font.BOLD , 30));
        l6.setBounds(70,180,600,120);
        contentPane.add(l6);
        
        JTextArea l7 = new JTextArea("");
        l7.setFont(new Font("Trebuchet MS", Font.BOLD , 20));
        l7.setBounds(70,300,200,600);
        contentPane.add(l7);
        
        contentPane.setBackground(Color.WHITE);
    }
    
    
}
    


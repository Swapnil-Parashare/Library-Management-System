package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import java.awt.event.*;

public class Forgot extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2,b3;
    
    public static void main(String[] args)
    {
        new Forgot().setVisible(true);
    }
    
    public Forgot() {                                       // This is our constructor, all code is written inside it.
        
     
        setBounds(500, 200, 650, 500);                       // Setting Size of our "Main Frame".
	contentPane = new JPanel();                          // It works as a container.
	setContentPane(contentPane);                         // Adding "contentpane" to our frame.
        contentPane.setBackground(Color.WHITE);              // Setting background color to white.  
	contentPane.setLayout(null);                         // There are different layout like BorderLayout(Default), Flow Layout, Grid Layout but we will design our own, hence set it as null.
        
        // Creating our Labels.
	JLabel l1 = new JLabel("Username");                  // l1------> Username.
	l1.setFont(new Font("Tahoma", Font.BOLD, 13));
	l1.setBounds(109, 83, 87, 29);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Name");                      // l2------> Name.
	l2.setFont(new Font("Tahoma", Font.BOLD, 13));
	l2.setBounds(109, 122, 75, 21);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Your Security Question");    // l3------> Your Security Question.
	l3.setFont(new Font("Tahoma", Font.BOLD, 13));
	l3.setBounds(109, 154, 156, 27);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Answer");                    // l4------> Answer
	l4.setFont(new Font("Tahoma", Font.BOLD, 13));
	l4.setBounds(109, 192, 104, 21);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Password");                  // l5-------> Password.
	l5.setFont(new Font("Tahoma", Font.BOLD, 13));
	l5.setBounds(109, 224, 104, 21);
	contentPane.add(l5);

        // Creating our Text Feilds.
	t1 = new JTextField();
	t1.setFont(new Font("Tahoma", Font.BOLD, 13));
	t1.setForeground(new Color(105, 105, 105));
	t1.setBounds(277, 88, 139, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();                                // Text Feild of "Name"----> Non-Editable.
	t2.setEditable(false);
	t2.setFont(new Font("Tahoma", Font.BOLD, 13));
	t2.setForeground(new Color(165, 42, 42));
	t2.setColumns(10);
	t2.setBounds(277, 123, 139, 20);
	contentPane.add(t2);

	t3 = new JTextField();                               // Text Feild of "Security Question"----> Non-Editable.
	t3.setEditable(false);
	t3.setFont(new Font("Tahoma", Font.BOLD, 12));
	t3.setForeground(new Color(72, 61, 139));
	t3.setColumns(10);
	t3.setBounds(277, 161, 221, 20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setFont(new Font("Tahoma", Font.BOLD, 13));
	t4.setForeground(new Color(205, 92, 92));
	t4.setColumns(10);
	t4.setBounds(277, 193, 139, 20);
	contentPane.add(t4);

	t5 = new JTextField();                               // Text Feild of "Password"----> Non-Editable.
	t5.setEditable(false);
	t5.setFont(new Font("Tahoma", Font.BOLD, 13));
	t5.setForeground(new Color(50, 205, 50));
	t5.setColumns(10);
	t5.setBounds(277, 225, 139, 20);
	contentPane.add(t5);

        // Creating Buttons
	b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setFont(new Font("Tahoma", Font.BOLD, 12));
	b1.setBounds(428, 83, 80, 29);
	b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

	b2 = new JButton("Retrieve");
	b2.addActionListener(this);
	b2.setFont(new Font("Tahoma", Font.BOLD, 12));
	b2.setBounds(426, 188, 85, 29);
	b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	b3 = new JButton("Back");
	b3.addActionListener(this);
	b3.setFont(new Font("Tahoma", Font.BOLD, 13));
	b3.setBounds(233, 270, 101, 29);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	contentPane.add(b3);
        
        // Creating Panel for "Border".
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(139, 69, 19), 2), "Forgot-Panel",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(178, 34, 34)));
	panel.setBounds(47, 45, 508, 281);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae){                                // Method of Interface "ActionListener".
        
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from account where username=?";          // Parametrized Sql Query
		PreparedStatement st = con.c.prepareStatement(sql);             // Creating a Statement using "Connection" Interface of "conn".

		st.setString(1, t1.getText());                                  // getText() will get the data from TextFeild--->t1, setString() will replace '?' with the data. Now we have a proper SQL Query.
		ResultSet rs = st.executeQuery();                               // As we have "Select" query hence we will used ".executeQuery()" method. As we are just fetching the data.
                                                                                // "ResultSet" Class's Object 'rs'will go through entire tabel row by row to find the record specified by our SQL Query. 
		while (rs.next()) {                                             // If record is found then this code block is executed.                  
                                                                                // Now we are filling the text feilds with fetched data.
                    t2.setText(rs.getString("name"));                           // rs.getString("data")----->Now 'rs' Object will go column to column so to fetch the specified data of that record.
                    t3.setText(rs.getString("sec_q"));                          // t.setText()-------------->It will set the fetched-data in specified text feild.
		}

            }
            if(ae.getSource() == b2){
                
                String sql = "select * from account where sec_ans=?";           // Parametrized SQL Query.
		PreparedStatement st = con.c.prepareStatement(sql);             // Creating statement using "Connection" Interface of "conn" class.

		st.setString(1, t4.getText());                                  // Getting text from the text feild and setting it inside our Statement.
		ResultSet rs = st.executeQuery();                               // As we have "Select" query, therefore we will use ".executeQuery()". We are going to fetch data and not modify it.
                                                                                // Query is executed and 'rs' object will find the record.
		while (rs.next()) {                                             // If record is found then this block is executed.
                    	t5.setText(rs.getString("password"));                   // With the help of 'rs' Object fetching 'password' of found record.
		}                                                               // Setting that 'password' into textfeild so that it is visible to 'admin'.

            }                                                                 
            if(ae.getSource() == b3){
                this.setVisible(false);
		new Login_user().setVisible(true);
			
            }
        }catch(SQLException e){
            
        }
    }  

    
   
}

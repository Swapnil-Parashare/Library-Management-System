package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class AddBook extends JFrame implements ActionListener {
    
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6;
    JComboBox comboBox;
    private JButton b1,b2;
    
    public static void main(String[] args){
        new AddBook().setVisible(true);                                         // Making our current Frame Visible.
    }
    
    public void random(){                                                       // Creating a random number and setting it up inside text feild of book_id.
        Random rd = new Random();
        t1.setText("" + rd.nextInt(1000 + 1));
    }
    
    public AddBook() {                                                          // This is our constructor. All code is written inside it.
        
        super("Add Book");
        setBounds(600, 200, 518, 442);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        // Creating 7 Labels.
        
        JLabel l1 = new JLabel("Name");
	l1.setForeground(new Color(47, 79, 79));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(73, 84, 90, 22);
	contentPane.add(l1);

	JLabel l2 = new JLabel("ISBN");
	l2.setForeground(new Color(47, 79, 79));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(73, 117, 90, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Publisher");
	l3.setForeground(new Color(47, 79, 79));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(73, 150, 90, 22);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Price");
	l4.setForeground(new Color(47, 79, 79));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(73, 216, 90, 22);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Pages");
	l5.setForeground(new Color(47, 79, 79));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(73, 249, 90, 22);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Book_id");
	l6.setForeground(new Color(47, 79, 79));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(73, 51, 90, 22);
	contentPane.add(l6);

	JLabel l7 = new JLabel("Edition");
	l7.setForeground(new Color(47, 79, 79));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(73, 183, 90, 22);
	contentPane.add(l7);
        
        // Creating 6 textfeilds and 1 combo-box.
        
        t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t1.setBounds(169, 54, 198, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(169, 87, 198, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(169, 120, 198, 20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setForeground(new Color(47, 79, 79));
	t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t4.setColumns(10);
	t4.setBounds(169, 153, 198, 20);
	contentPane.add(t4);

        t5 = new JTextField();
	t5.setForeground(new Color(47, 79, 79));
	t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t5.setColumns(10);
	t5.setBounds(169, 219, 198, 20);
	contentPane.add(t5);

	t6 = new JTextField();
	t6.setForeground(new Color(47, 79, 79));
	t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t6.setColumns(10);
	t6.setBounds(169, 252, 198, 20);
	contentPane.add(t6);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
	comboBox.setBounds(173, 186, 194, 20);
	contentPane.add(comboBox);
        
        // Creating 2 Buttons
        b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b1.setBounds(102, 300, 100, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b2.setBounds(212, 300, 108, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);
        
        // Creating a panel for adding a border.
        JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Add Books", TitledBorder.LEADING,
			TitledBorder.TOP, null, new Color(0, 0, 255)));
	panel.setBounds(10, 29, 398, 344);
	contentPane.add(panel);
        
        panel.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
	random();
        
    }

    

    @Override                                                                   // Overiding Method of ActionListener Interface. All the logic part is here.
    public void actionPerformed(ActionEvent ae) {
        
        try{
            
            conn con = new conn();                                              // Creating Object of Connection Class as we are going to interact with database.
            
            if(ae.getSource() == b1)                                           
            {
                String sql = "insert into book(book_id, name, isbn, publisher, edition, price, pages) values(?,?,?,?,?,?,?)"; // Parameterized Query.
                
                PreparedStatement st = con.c.prepareStatement(sql);                                                     // Creating 'Statement' from 'SQL Query' by using Connection Interface of conn Class.
                
                st.setString(1, t1.getText());                                  // textfeild.getText()-----> Getting text from Text Feilds.
		st.setString(2, t2.getText());                                  // statement.setString()---> Setting the text inside our statement.
		st.setString(3, t3.getText());
		st.setString(4, t4.getText());
		st.setString(5, (String) comboBox.getSelectedItem());           
		st.setString(6, t5.getText());
		st.setString(7, t6.getText());
                
                // Now we have full fleched SQL Statement. So now execute it.
                
                int rs = st.executeUpdate();                                    // If Statement is executed successfully then 1 is returned, which is held by 'rs'.
                if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Added");  // If Query is successfully executed then showing this pop-up
		else
                    JOptionPane.showMessageDialog(null, "Error");               // If any error occured then showing this pop-up.                                            
                
                /* Note : 1]As this is "Insert Query" it is shows that we are going to update data from the database.
                          2]Hence we are using "statement.executeUpdate()" method.
                          3]If we are just fetching the data from database then obviously our Query would be of type "Select".
                          4]Then we would have used "statement.executeQuery()".
                */
                
                // Setting all our Text Feilds to Empty.
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                
                //Closing our Statement 
		st.close();
             
            }
            
            if(ae.getSource() == b2){                                           // If "Back" Button is clicked.
                this.setVisible(false);
                new Home().setVisible(true);
            }
            
            // Finally Closing our Connection. (Remember the 5th Step of JDBC)
            con.c.close();           
                 
        }catch(Exception e){
            
        }
    }
    
}

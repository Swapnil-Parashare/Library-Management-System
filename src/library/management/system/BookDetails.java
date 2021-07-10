package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;      // This additional thing is required for tables.
import java.sql.*;
import java.awt.event.*;


public class BookDetails extends JFrame implements ActionListener{
    
    private JPanel contentPane;
    private JTable table;            // This our Book Details Table.
    private JTextField search;
    private JButton b1,b2;
    
    
    public static void main(String[] args){
        new BookDetails().setVisible(true);                                     // Making our current Frame visible.
    }

    public void Book() {                                                        // (I think)This is to display "Book Table" from Database to our created tabel in GUI                              
        try{                                                                    // This is the reason we are running it at the bottom of our constructor, so data will be instantly visible as soon as Frame is opened.
            
            conn con = new conn();                                              // Creating Connection
            String sql = "select * from book";                                  // Simple SQL Query
            PreparedStatement st = con.c.prepareStatement(sql);                 // Preparing a Statement.
            ResultSet rs = st.executeQuery();                                   // Executing the Statement.
                                                                                // Now 'rs' holds entire data of "book" table.
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        }catch(Exception e){
            
        }
    }
    
    public BookDetails(){                                                       // This is our constructor, all code is placed inside it.
        
       // Creating Main Frame.
        setBounds(350, 200, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();                             // For creating a 'table' first we need "JScrollPane" Class's Object. After creating a 'table' we need to add it inside "JScrollPane" Object.
	scrollPane.setBounds(79, 133, 771, 282);                                // Location of our table and its length and breadth is decided by JScrollPane Object.
	contentPane.add(scrollPane);
        
     /***********************************************************************************************************************************************************/  
        
        // Creating a Table
        
        table = new JTable();                                                  
        
        table.setBackground(new Color(240, 248, 255));
	table.setForeground(Color.DARK_GRAY);
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	scrollPane.setViewportView(table);                                      // We are adding our table inside "JScrollPane" Object.
        
	table.addMouseListener(new MouseAdapter() {                             // We are attaching a Mouse Listener Event to our "Table".
            @Override
            public void mouseClicked(MouseEvent arg0) {
             
                int row = table.getSelectedRow();                               // 'row' holds the completed data of the row which user clicked.	
                search.setText(table.getModel().getValueAt(row, 1).toString()); //  1]We are taking out the data from 1st column from the above selected row.
                                                                                //  2]Converting the data into string.
            }                                                                   //  3]"getModel()" method of the 'table' which returs current data. Hence our data is now returned.                 
                                                                                //  4] Finally we are setting the returned data into the textfeild ---> 'search'.
	});                                                                     
        
        /* IMP
        
        Note :- 1] For "Buttons" we were attaching button.addActionListner().
                2] We were passing "ActionListener" Object inside it as an argument.
                3] As our class itself is implemented from "Interface :- ActionListener", hence we were passing "this".
                4] There we were "Overriding" ---> actionPerformed() method which was taking "ActionEvent" object as an argument.
                5] "ActionEvent" Object holds the information of which "Button" is clicked.
                
        
        Similarly.....
                1] For "Table" we are attaching table.addMouseListener().
                2] Here we are passing "MouseListener" Object inside it as an argument. 
                3] "MouseAdapter" is a class implmented from "Interface :- MouseListener", hence we are passing "MouseAdapter" Object inside it.
                4] Here we are "Overriding" ---> mouseClicked() method which takes "MouseEvent" object as an argument.
                5] "MouseEvent" Object holds the information of which "Row" is clicked from the table.
                
       
        */
        
        /**********************************************************************************************************************************************************************/
         
        
        
        // Creating Buttons
        b1 = new JButton("Search");
	b1.addActionListener(this);
	b1.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/eight.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setIcon(i3);                                                         // Here we are setting up an image on our button itself.
	b1.setForeground(new Color(199, 21, 133));
	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b1.setBounds(564, 89, 138, 33);
	contentPane.add(b1);

	b2 = new JButton("Delete");
	b2.addActionListener(this);
	ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/nineth.png"));
        Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b2.setIcon(i6);
        b2.setForeground(new Color(199, 21, 133));
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	b2.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
	b2.setBounds(712, 89, 138, 33);
	contentPane.add(b2);

        // Label 1 :- Book Details    ------> This is our "Main Heading".
	JLabel l1 = new JLabel("Book Details");
	l1.setForeground(new Color(107, 142, 35));
	l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
	l1.setBounds(300, 15, 400, 47);
	contentPane.add(l1);

        
        
        // Label 2 :- Back         --------> Here this label will acts as a button as we are attaching a mouseListner to it.
	JLabel l2 = new JLabel("Back");
	l2.addMouseListener(new MouseAdapter() {                                // Attaching "mouseListner"
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
	l2.setForeground(Color.GRAY);
	l2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/tenth.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l2.setIcon(i9);
	l2.setBounds(97, 89, 72, 33);
	contentPane.add(l2);
        
        // Text Feild :- Search
	search = new JTextField();
	search.setBackground(new Color(255, 240, 245));
	search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
	search.setForeground(new Color(47, 79, 79));
	search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
	search.setBounds(189, 89, 357, 33);
	contentPane.add(search);
	search.setColumns(10);
        
        // Creating a Panel for Border Purpose
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "Book-Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
	panel.setBounds(67, 54, 793, 368);
	contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        
        // Calling our "Book()" Method.
	Book();
	

        
    }

    
    @Override                                                                   // Overriding the method of "ActionListener" Interface as our class is implemented from it.
    public void actionPerformed(ActionEvent ae){
       
        try{
            
            conn con = new conn();                                              // As we are interacting with database hence we need to create object of "Connection" Class.
            
            // Searching Book from the record.
            if(ae.getSource() == b1){
             
                String sql = "select * from book where concat(name, book_id) like ?";  // 1]We have concatenated a string "Book_Name+Book_ID".
		                                                                       // 2]Now fetch all recored from the table.
                                                                                       // 3]Where "Concatenated String" contains the 'text' entered by user at any location. ( Intially, In-Between, At-the-End )
                                                                                          
                
                PreparedStatement st = con.c.prepareStatement(sql);                    // Preparing Statement.
                
		st.setString(1, "%" + search.getText() + "%");                         // Injecting user's data into our statement. Note :- This line is responsible for our pattern selection ( %or% )
		
                ResultSet rs = st.executeQuery();                                      // Executing the Query.
                
		table.setModel(DbUtils.resultSetToTableModel(rs));                     // Injecting the data held by "ResultSet" object 'rs' into our table to display it to user.
                
                rs.close();                                                            // Closing 'rs' object.
                
                st.close();                                                            // Closing our statement.

            }
            
            // Deleting Book from the record.
            if(ae.getSource() == b2){
                String sql = "delete from book where name = '" + search.getText() + "'";           // Deletion query which deletes record whose 'name' is equal to the text from text feild.
		PreparedStatement st = con.c.prepareStatement(sql);                                // Preparing Statement.
                
		JDialog.setDefaultLookAndFeelDecorated(true);                                      // Using Default layout for our dialog box.
		
                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
		if (response == JOptionPane.YES_OPTION) {                       // If user confirms the operation then we execute the statement.
                    int rs = st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deleted !!!");         // Show conformation message.
                } 
                
                st.close();                                                     // Then close our statement.
			
            }            
            /* Dialog Box.
            1] JOptionPane.showMessageDialog() ----------> If we want to show some information.
            2] JOptionPane.showConfirmDialog() ----------> When we are about to perform a operation, but still want to confirm from user weather he wants to proceed or not.( Used in operation like ---> Delection )
            3] JoptionPane.showInputDialog()   ----------> If we want to take any input from user.            
            */
            con.c.close();                                                      // Finally Closing the connection.            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}

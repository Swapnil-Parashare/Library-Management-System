package library.management.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{

	private JPanel contentPane;
        private JButton b1,b2,b3,b4,b5,b6;

	public static void main(String[] args) {
            new Home().setVisible(true);
	}
        
        public Home() {
	
            setBounds(300, 50, 1000, 750);
            contentPane = new JPanel();
            setContentPane(contentPane);
            contentPane.setLayout(null);

            // Creating "Menu Bar"
            JMenuBar menuBar = new JMenuBar();
            menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
            menuBar.setBackground(Color.CYAN);
            menuBar.setBounds(0, 10, 1000, 35);
            contentPane.add(menuBar);
            
            // 1st Menu :- Exit
            JMenu mnExit = new JMenu("Exit");
            mnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
            
            // Adding "Menu Items" to "Exit"
            JMenuItem mntmLogout = new JMenuItem("Logout");
            mntmLogout.setBackground(new Color(211, 211, 211));
            mntmLogout.setForeground(new Color(105, 105, 105));
            mntmLogout.addActionListener(this);
            mnExit.add(mntmLogout);                                             // Logout --------> 'Exit'
            
            JMenuItem mntmExit = new JMenuItem("Exit");
            mntmExit.setForeground(new Color(105, 105, 105));
            mntmExit.setBackground(new Color(211, 211, 211));
            mntmExit.addActionListener(this);
            mnExit.add(mntmExit);                                               // Exit ----------> 'Exit'
                
            
            // 2nd Menu :- "Help"
            JMenu mnHelp = new JMenu("Help");
            mnHelp.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
            
            
            // Adding "Menu Items" to "Help"
            JMenuItem mntmReadme = new JMenuItem("Read Me");
            mntmReadme.setBackground(new Color(211, 211, 211));
            mntmReadme.setForeground(new Color(105, 105, 105));
            mntmReadme.addActionListener(this);
            mnHelp.add(mntmReadme);                                             // Read Me ---------> "Help"

            JMenuItem mntmAboutUs = new JMenuItem("About Us");
            mntmAboutUs.setForeground(new Color(105, 105, 105));
            mntmAboutUs.setBackground(new Color(211, 211, 211));
            mntmAboutUs.addActionListener(this);                                // About Us ---------> "Help"
            mnHelp.add(mntmAboutUs);

            // 3rd Menu :- "Record"
            JMenu mnRecord = new JMenu("Record");
            mnRecord.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
            
            
            // Adding "Menu Items" to "Record"
            JMenuItem bookdetails = new JMenuItem("Book Details");
            bookdetails.addActionListener(this);
            bookdetails.setBackground(new Color(211, 211, 211));
            bookdetails.setForeground(Color.DARK_GRAY);
            mnRecord.add(bookdetails);                                          // Book Details ----------> "Record"

            JMenuItem studentdetails = new JMenuItem("Student Details");
            studentdetails.setBackground(new Color(211, 211, 211));
            studentdetails.setForeground(Color.DARK_GRAY);
            studentdetails.addActionListener(this);
            mnRecord.add(studentdetails);                                       // Student Details ---------> "Record"
            
            // Adding all the 3 Menu's inside our "Menu Bar".
            menuBar.add(mnRecord);
            menuBar.add(mnHelp);
            menuBar.add(mnExit);

            
            // Creating Heading
            JLabel l1 = new JLabel("Library Management System");
            l1.setForeground(new Color(204, 51, 102));
            l1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
            l1.setBounds(268, 30, 701, 80);
            contentPane.add(l1);
            
            // Creating the 3 images for 3 buttons and combining all 6 into a panel.
            
            // 3 Images
            JLabel l2 = new JLabel("");
            l2.setVerticalAlignment(SwingConstants.TOP);
            ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/second.png"));       // This returns image object which is held by i1.
            Image i2 = i1.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);                                         // Setting Size of the image.
            ImageIcon i3 = new ImageIcon(i2);                                                                                 // We cannot this image object directly into label. Hence creating a new Image object reference and pass our object to it.
            l2 = new JLabel(i3);                                                                                              // Passing i3 to the label.
            l2.setBounds(60, 140, 159, 152);                                                                                  // Setting up labels location.
            contentPane.add(l2);                                                                                              // Finally adding that label to our panel.

            JLabel l3 = new JLabel("");
            ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/third.png"));
            Image i5 = i4.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            l3 = new JLabel(i6);
            l3.setBounds(300, 160, 134, 128);
            contentPane.add(l3);

            JLabel l4 = new JLabel("");
            ImageIcon i7  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/fourth.png"));
            Image i8 = i7.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i9 = new ImageIcon(i8);
            l4 = new JLabel(i9);
            l4.setBounds(530, 140, 225, 152);
            contentPane.add(l4);

            // 3 Buttons
            b1 = new JButton("Add Books");
            b1.addActionListener(this);
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE);
            b1.setBounds(60, 320, 159, 44);
            contentPane.add(b1);

            b2 = new JButton("Statistics");
            b2.addActionListener(this);
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE);
            b2.setBounds(313, 320, 139, 44);
            contentPane.add(b2);

            b3 = new JButton("Add Student");
            b3.addActionListener(this);
            b3.setBackground(Color.BLACK);
            b3.setForeground(Color.WHITE);
            b3.setBounds(562, 320, 167, 44);
            contentPane.add(b3);

            // Creating Panel inorder to create border.
            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Operation", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
            panel.setBounds(20, 120, 750, 260);
            panel.setBackground(Color.WHITE);
            contentPane.add(panel);                 

            
            // Same process is repeated for remaining 3 Images and 3 Buttons
            b4 = new JButton("Issue Book");
            b4.addActionListener(this);
            b4.setBackground(Color.BLACK);
            b4.setForeground(Color.WHITE);
            b4.setBounds(76, 620, 143, 41);
            contentPane.add(b4);

            b5 = new JButton("Return Book");
            b5.addActionListener(this);
            b5.setBackground(Color.BLACK);
            b5.setForeground(Color.WHITE);
            b5.setBounds(310, 620, 159, 41);
            contentPane.add(b5);

            b6 = new JButton("About Us");
            b6.addActionListener(this);
            b6.setBackground(Color.BLACK);
            b6.setForeground(Color.WHITE);
            b6.setBounds(562, 620, 159, 41);
            contentPane.add(b6);

            JLabel l5 = new JLabel("");
            ImageIcon i10  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/fifth.png"));
            Image i11 = i10.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i12 = new ImageIcon(i11);
            l5 = new JLabel(i12);
            l5.setBounds(60, 440, 159, 163);
            contentPane.add(l5);

            JLabel l6 = new JLabel("");
            ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/sixth.png"));
            Image i14 = i13.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i15 = new ImageIcon(i14);
            l6 = new JLabel(i15);
            l6.setBounds(332, 440, 139, 152);
            contentPane.add(l6);

            JLabel l7 = new JLabel("");
            ImageIcon i16  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/seventh.png"));
            Image i17 = i16.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
            ImageIcon i18 = new ImageIcon(i17);
            l7 = new JLabel(i18);
            l7.setBounds(562, 440, 157, 152);
            contentPane.add(l7);

            JPanel panel2 = new JPanel();
            panel2.setBorder(new TitledBorder(new LineBorder(new Color(205, 133, 63), 2), "Action", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(233, 150, 122)));
            panel2.setBounds(20, 420, 750, 270);
            panel2.setBackground(Color.WHITE);
            contentPane.add(panel2);
            
            getContentPane().setBackground(Color.WHITE);
            contentPane.setBackground(Color.WHITE);
	}
        
        @Override                                                               // Overridding the method of Action Listener Interface. All Logical things happens here.
        public void actionPerformed(ActionEvent ae){
            
            String msg = ae.getActionCommand();                                 // For checking which buttons is clicked "ae.getSource()" is used.
                                                                                // Similarly for checking which "Menu Item" is clicked "ae.getActionCommand()" is used.
                                                                                // It returns String. So we can compare it to check.
           
            // Checking which "Menu Item" is clicked and then opening respected Frame.
            switch (msg) {
                case "Logout":
                    setVisible(false);
                    new Login_user().setVisible(true);
                    break;
                case "Exit":
                    System.exit(ABORT);
                case "Read Me":
                    setVisible(false);
                    new ReadMe().setVisible(true);
                    break;
                case "About Us":
                    setVisible(false);
                    new aboutUs().setVisible(true);
                    break;
                case "Book Details":
                    setVisible(false);
                    new BookDetails().setVisible(true);
                    break;
                case "Student Details":
                    setVisible(false);
                    new StudentDetails().setVisible(true);
                    break;
                default:
                    break;
            }
            
            // Checking which button is clicked then opening respected Frame.
            if(ae.getSource() == b1){
                this.setVisible(false);
                new AddBook().setVisible(true);
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Statistics().setVisible(true);
            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new AddStudent().setVisible(true);
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
                new IssueBook().setVisible(true);
            }
            if(ae.getSource() == b5){
                this.setVisible(false);
                new ReturnBook().setVisible(true);
            
            }
            if(ae.getSource() == b6){
                this.setVisible(false);
                new aboutUs().setVisible(true);
            
            }
            
        }
}
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class createStudents extends JInternalFrame {

	JPanel pnlContentPane;
	JPanel pnlHeader;
	JPanel pnlContent ;
	JPanel pnlControls ;
	JPanel pnlSearch;
	JPanel pnlfilter;
	JPanel pnlTable;
	JScrollPane scrollContentPane;
	/*LABELS FOR TITILE*/
	
	actionListener alistener=new actionListener();
	addFocusListener focuslistner =new addFocusListener();
	JLabel lblTitle=new JLabel("CREATE STUDENTS");
	/*Group 1 -Basic Detail*/
	JLabel lblstudent=new JLabel("Student name",SwingConstants.RIGHT); 
	JLabel lblclass=new JLabel("Class",SwingConstants.RIGHT);
	JLabel lblrollno=new JLabel("Roll no.",SwingConstants.RIGHT);
	JLabel lbljoinDate=new JLabel("Join Date.",SwingConstants.RIGHT);
	JLabel lblsection=new JLabel("Section",SwingConstants.RIGHT);
	
	/*Group 2-Personal Detail*/
	JLabel lblFathername=new JLabel("Father name",SwingConstants.RIGHT);
	JLabel Mothername=new JLabel("Mother Name",SwingConstants.RIGHT);
	JLabel Address=new JLabel("Address",SwingConstants.RIGHT);
	JLabel Contactno=new JLabel("Contact no",SwingConstants.RIGHT);
	JLabel lbldobDate=new JLabel("Date of Birth",SwingConstants.RIGHT);
	JLabel lblcStatus=new JLabel("Current Status",SwingConstants.RIGHT);
	/*[search controls]*/
	Object[] tblSearchcolumns ={"Student name","Roll no"," Class","Dob","Father's name","Contactno","Status","Modify","Delete"};
	Object[][] tblSearchRawdata=new Object[][]{
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"},
			{"Ramesh ","15212","V-A","01-10-2005","Mr Mohan","986512121","Active","Modify","Delete"}
			
	};
 	JScrollPane jtblSearchScrollbar=new JScrollPane();
	JLabel lblSearchStd =new JLabel("Student name",SwingConstants.RIGHT);
	JLabel lblSearchRollno =new JLabel("Roll no. ",SwingConstants.RIGHT);
	
	JTextField txtSearchStd =new JTextField(20);
	JTextField txtSearchRollno =new JTextField(20);
	
	JButton btnSearchFilter =new JButton("Filter");
	JButton btnSearchReset =new JButton(" Reset ");
	
	/*[Search controls closed]*/
	
	/*Input controls for all */
	JTextField txtStudentname =new JTextField(20);
	JTextArea txtAddress =new JTextArea(3,1);
	JComboBox cbClass =new JComboBox(clsContants.classList);
	JComboBox cbSectoin =new JComboBox(clsContants.sectionList);
	JTextField txtRollno =new JTextField(20);
	JTextField txtJbdate =new JTextField(20);
	JTextField txtFathername =new JTextField(20);
	JTextField txtMothername =new JTextField(20);
	JTextField txtContactno =new JTextField(20);
	JTextField txtDob =new JTextField(20);
	JCheckBox ckCurrentStatus=new JCheckBox("Current Status");	
	/*Closed input*/
	JTextField txtClassname=new JTextField(20);
	JTextField txtSection=new JTextField(20);
	JTextField txtClassTeacher=new JTextField(20);
	
	JButton btnClose=new JButton("Close");
	JButton btnSave=new JButton("Save");
	
	 JTable tblStudent;
	  
	
	public createStudents()
	{
		setTitle("------------CREATE CLASS--------------");
		setVisible(true);
		setMaximizable(false);
		setLocation(1,1);
		setClosable(true);
		pnlHeader=new JPanel();
		pnlContent=new JPanel();
		pnlControls=new JPanel();
		 
		pnlContentPane=new JPanel(new BorderLayout());
		scrollContentPane=new JScrollPane();
		pnlContentPane.add(scrollContentPane);
		setClosable(true);
		try{
			setSelected(true);}catch(PropertyVetoException ae)
			{
				ae.printStackTrace();
			}
	}
	public JInternalFrame createStudents()
	{
		
		pnlHeader.setBackground(utils.titlebackground);
		lblTitle.setFont(utils.titlefont);
		lblTitle.setForeground(utils.titleforeground);
		pnlHeader.add(lblTitle);
		
		
		//getContentPane().setLayout();
		JPanel pnlClassDetail=new JPanel();
		
		JPanel pnlbasicDetail=new JPanel();
		pnlbasicDetail.setBorder(BorderFactory.createTitledBorder("Basic Detail"));
		txtStudentname.addFocusListener(focuslistner);
		pnlbasicDetail.setFont(utils.groupfont);
		/*Add basic Detail ------------------- */
		
		//GridLayout gbLayout =new GridLayout(6,2);
		GridBagLayout bglayout=new GridBagLayout();
		GridBagConstraints c =new GridBagConstraints();
		pnlbasicDetail.setLayout(bglayout);
		c.ipadx=5;
		c.ipady=5;
		c.insets=new Insets(0,0,0,5);
		c.gridx=0;c.gridy=0;c.fill=GridBagConstraints.HORIZONTAL;		
		pnlbasicDetail.add(lblstudent,c);		
		txtStudentname.setFont(utils.textboxfont);
		c.gridx=1;c.gridy=0;
		pnlbasicDetail.add(txtStudentname,c);
		c.gridx=0;c.gridy=1;
		pnlbasicDetail.add(lblclass,c);
		c.gridx=1;c.gridy=1;
		pnlbasicDetail.add(cbClass,c);
		cbClass.setFont(utils.dropboxfont);
		c.gridx=0;c.gridy=2;
		pnlbasicDetail.add(lblsection,c);
		c.gridx=1;c.gridy=2;
		cbSectoin.setFont(utils.dropboxfont);		
		pnlbasicDetail.add(cbSectoin,c);
		c.gridx=0;c.gridy=3;
		pnlbasicDetail.add(lblrollno,c);
		c.gridx=1;c.gridy=3;
		pnlbasicDetail.add(txtRollno,c);
		txtRollno.setFont(utils.textboxfont);
		c.gridx=0;c.gridy=4;
		pnlbasicDetail.add(lbljoinDate,c);
		c.gridx=1;c.gridy=4;
		pnlbasicDetail.add(txtJbdate,c);
		txtJbdate.setFont(utils.textboxfont);
		c.gridx=0;c.gridy=5;
		pnlbasicDetail.add(lbldobDate,c);		
		txtDob.setFont(utils.textboxfont);
		c.gridx=1;c.gridy=5;
		pnlbasicDetail.add(txtDob,c);
		
		
		/*Add Personal Detail   -------------------------*/
		GridBagLayout bgplayout=new GridBagLayout();
		GridBagConstraints cc =new GridBagConstraints();
		cc.insets=new Insets(0,0,0,5);
		cc.fill=GridBagConstraints.HORIZONTAL;
		
		JPanel pnlPersonalDetail=new JPanel();
		pnlPersonalDetail.setBorder(BorderFactory.createTitledBorder("Personal Detail"));
		pnlPersonalDetail.setLayout(bgplayout);
		pnlPersonalDetail.setFont(utils.groupfont);
		JScrollPane scrollpane =new JScrollPane(txtAddress);
		
		
		cc.gridx=0;cc.gridy=0;
		pnlPersonalDetail.add(lblFathername,cc);
		txtFathername.setFont(utils.textboxfont);
		cc.gridx=1;cc.gridy=0;
		pnlPersonalDetail.add(txtFathername,cc);
		
		cc.gridx=0;cc.gridy=1;
		pnlPersonalDetail.add(Mothername,cc);
		txtMothername.setFont(utils.textboxfont);
		cc.gridx=1;cc.gridy=1;
		pnlPersonalDetail.add(txtMothername,cc);
		
		cc.gridx=0;cc.gridy=2;cc.weighty=3;
		pnlPersonalDetail.add(Address,cc);
		txtAddress.setFont(utils.textboxfont);
		cc.gridx=1;cc.gridy=2;
		
		pnlPersonalDetail.add(scrollpane,cc);
		txtAddress.setBorder(BorderFactory.createEtchedBorder());
		cc.gridx=0;cc.gridy=3;cc.weighty=1;
		pnlPersonalDetail.add(Contactno,cc);
		txtContactno.setFont(utils.textboxfont);
		cc.gridx=1;cc.gridy=3;
		pnlPersonalDetail.add(txtContactno,cc);
		cc.gridx=0;cc.gridy=4;
		pnlPersonalDetail.add(lblcStatus,cc);
		ckCurrentStatus.setFont(utils.textboxfont);
		cc.gridx=1;cc.gridy=4;
		pnlPersonalDetail.add(ckCurrentStatus,cc);
		
		/*---------Closing -------------------------*/
		
		/*--------Search will be here ------------------*/
		
		tblStudent=new JTable(tblSearchRawdata,tblSearchcolumns);
		/*Set JTable Properties*/
		tblStudent.getColumnModel().getColumn(0).setPreferredWidth(300);
		tblStudent.getColumnModel().getColumn(1).setPreferredWidth(150);
		tblStudent.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblStudent.getColumnModel().getColumn(3).setPreferredWidth(200);
		tblStudent.getColumnModel().getColumn(4).setPreferredWidth(300);
		tblStudent.getColumnModel().getColumn(5).setPreferredWidth(200);
		tblStudent.getColumnModel().getColumn(6).setPreferredWidth(150);
		
		
		/*--------------------------*/
		
		jtblSearchScrollbar=new JScrollPane(tblStudent);
		pnlSearch=new JPanel();
		pnlTable =new JPanel();
		pnlSearch.setSize(600, 300);
		pnlSearch.setBorder(BorderFactory.createTitledBorder("Students List"));
		pnlSearch.setLayout(new BorderLayout());
		pnlfilter=new JPanel(new FlowLayout());
		pnlfilter.add(lblSearchStd);
		txtSearchStd.setFont(utils.textboxfont);
		txtSearchRollno.setFont(utils.textboxfont);
		pnlfilter.add(txtSearchStd);
		pnlfilter.add(lblSearchRollno);
		pnlfilter.add(txtSearchRollno);
		pnlfilter.add(btnSearchFilter);
		pnlfilter.add(btnSearchReset);
		pnlTable.setLayout(new BorderLayout());
		pnlTable.setBorder(BorderFactory.createEtchedBorder());
		
		pnlTable.add(jtblSearchScrollbar,BorderLayout.CENTER);
		
		pnlSearch.add(pnlfilter,BorderLayout.NORTH);
		pnlSearch.add(pnlTable,BorderLayout.CENTER);
		
		//pnlSearch.setBorder(//BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Students",, titlePosition, titleFont));
		/*-----------Closed ---------------------*/
		
		
		JScrollPane scrollcontentpnl;
		pnlContent.setLayout(new BorderLayout());
		pnlContent.add(pnlbasicDetail,BorderLayout.WEST);
		pnlContent.add(pnlPersonalDetail,BorderLayout.EAST);
		//pnlContent.add(pnlSearch,BorderLayout.SOUTH);
		//pnlPersonalDetail.add(lblFathername);
		//pnlContent.add(pnlPersonalDetail,BorderLayout.SOUTH);
		/*Add buttons with a panel*/
		JPanel pnlControls=new JPanel();
		pnlControls.setLayout(new FlowLayout());
		pnlControls.add(btnSave);
		pnlControls.add(btnClose);
		pnlControls.setBorder(BorderFactory.createEmptyBorder());
		pnlContent.add(pnlControls,BorderLayout.NORTH);
		scrollcontentpnl=new JScrollPane(pnlContent);
		setContentPane(pnlContentPane);
		getContentPane().add(pnlHeader,BorderLayout.NORTH);
		
		getContentPane().add(scrollcontentpnl,BorderLayout.CENTER);
		getContentPane().add(pnlSearch,BorderLayout.SOUTH);
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		return this;
	}
	
	public class actionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource()==btnClose)
			{
				try{
							setClosed(true);
				}catch(PropertyVetoException ae)
				{
					ae.printStackTrace();
				}
				
			}
			if (e.getSource()==btnSave)
			{
				JOptionPane.showMessageDialog (null, "Save Called", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			
			
		}
		
	}
	
	public class addFocusListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
					if (e.getSource()==txtStudentname)
					{
						txtStudentname.selectAll();
					}
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

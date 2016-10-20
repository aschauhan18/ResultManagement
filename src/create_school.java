import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

import sun.awt.HorizBagLayout;


public class create_school extends JFrame{
	JInternalFrame frame_school ;
	JPanel pnlControls=new JPanel();
	JTextField txtSchoolname =new JTextField(25);
	JTextArea txtAdd1 =new JTextArea(2,25);
	JTextArea txtAdd2 =new JTextArea(2,25);
	JTextField txtCity =new JTextField(25);
	JTextField txtState =new JTextField(25);
	JTextField txtCountry =new JTextField(25);
	JTextField txtPincode =new JTextField(25);
	JTextField txtWebsite =new JTextField(25);
	JTextField txtPhone =new JTextField(25);
	 
	 JButton btnlogo=new JButton("Browse Logo");
	 JFileChooser filelogo =new JFileChooser();
	 Calendar cal = new GregorianCalendar();
	 JTextField txtestd =new JTextField(20);
	 JTextField txtPrincipal =new JTextField(25);
	 JButton btnUpdate=new JButton("Update");
	 JButton btnClose=new JButton("Close");
	 
	public create_school()
	{
		frame_school=new JInternalFrame();
		frame_school.setTitle("------------------CREATE SCHOOL INFORMATION-----------------");
		frame_school.setVisible(true);
		frame_school.setLocation(1,1);
		//frame_school.setSize(500, 500);
		//frame_school.setResizable(true);
		frame_school.setMaximizable(true);
		frame_school.setClosable(true);
		frame_school.setIconifiable(true);
		frame_school.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);	
		try{
		frame_school.setSelected(true);}
		catch(java.beans.PropertyVetoException e)
		{
			System.out.print("error in creating Schoor internal Frame");
			
		}
	}
	public JInternalFrame createSchoolFrame()
	{
		JPanel pnlTitle=new JPanel();
		
		JLabel lblTitle=new JLabel("Create School Entry");
		lblTitle.setFont(utils.titlefont);
		lblTitle.setForeground(Color.WHITE);
		pnlTitle.add(lblTitle);
		pnlTitle.setBorder(BorderFactory.createEtchedBorder());
		pnlTitle.setBackground(Color.GRAY);
		frame_school.add(pnlTitle,BorderLayout.NORTH);
		create_controls();
		frame_school.pack();
		return frame_school;
		
	}
	public void create_controls()
	{
		JPanel pnlContent =new JPanel();
		actionListener alistener= new actionListener();
		GridLayout glayout =new GridLayout(13,2,10,5);
		GridBagLayout gblayout =new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
		
		pnlContent.setLayout(gblayout);
		c.gridx=0;c.gridy=0;c.fill=GridBagConstraints.HORIZONTAL;c.ipadx=5;c.insets=new Insets(2,2, 2, 5);
		
		pnlContent.add(new JLabel("School name",SwingConstants.RIGHT),c);
		c.gridx=1;c.gridy=0;c.ipady=10;
		txtSchoolname.setFont(utils.textboxfont);
		pnlContent.add(txtSchoolname,c);
		c.gridx=0;c.gridy=1;
		pnlContent.add(new JLabel("Address Line 1",SwingConstants.RIGHT),c);
		c.gridx=1;c.gridy=1;
		txtAdd1.setBorder(BorderFactory.createEtchedBorder());
		txtAdd1.setFont(utils.textboxfont);
		c.weighty=2;
		pnlContent.add(txtAdd1,c);
		
		c.gridx=0;c.gridy=2;
		c.weighty=1;
		
		pnlContent.add(new JLabel("Address Line2",SwingConstants.RIGHT),c);
		c.gridx=1;c.gridy=2;
		c.weighty=1;
		txtAdd2.setBorder(BorderFactory.createEtchedBorder());
		txtAdd2.setFont(utils.textboxfont);
		pnlContent.add(txtAdd2,c);
		
		c.gridx=0;c.gridy=3;c.weighty=1;
		pnlContent.add(new JLabel("City",SwingConstants.RIGHT),c);
		c.gridx=1;c.gridy=3;
		txtCity.setFont(utils.textboxfont);
		pnlContent.add(txtCity,c);
		
		c.gridx=0;c.gridy=4;
		pnlContent.add(new JLabel("State",SwingConstants.RIGHT),c);
		txtState.setFont(utils.textboxfont);
		c.gridx=1;c.gridy=4;
		pnlContent.add(txtState,c);
		
		c.gridx=0;c.gridy=5;
		pnlContent.add(new JLabel("Country",SwingConstants.RIGHT),c);
		txtCountry.setFont(utils.textboxfont);
		c.gridx=1;c.gridy=5;
		pnlContent.add(txtCountry,c);
		
		c.gridx=0;c.gridy=6;
		pnlContent.add(new JLabel("Pincode",SwingConstants.RIGHT),c);
		txtPincode.setFont(utils.textboxfont);
		c.gridx=1;c.gridy=6;
		pnlContent.add(txtPincode,c);
		
		c.gridx=0;c.gridy=7;
		pnlContent.add(new JLabel("Phone ",SwingConstants.RIGHT),c);
		txtPhone.setFont(utils.textboxfont);
		c.gridx=1;c.gridy=7;
		pnlContent.add(txtPhone,c);
		
		c.gridx=0;c.gridy=8;
		pnlContent.add(new JLabel("Website",SwingConstants.RIGHT),c);
		txtWebsite.setFont(utils.textboxfont);
		c.gridx=1;c.gridy=8;
		pnlContent.add(txtWebsite,c);
		
		c.gridx=0;c.gridy=9;
		pnlContent.add(new JLabel("Logo",SwingConstants.RIGHT),c);
		c.gridx=1;c.gridy=9;
		pnlContent.add(btnlogo,c);
		
		c.gridx=0;c.gridy=10;
		pnlContent.add(new JLabel("Establishment Date",SwingConstants.RIGHT),c);
		c.gridx=1;c.gridy=10;
		txtestd.setFont(utils.textboxfont);
		pnlContent.add(txtestd,c);
		
		c.gridx=0;c.gridy=11;
		pnlContent.add(new JLabel("Principal Name",SwingConstants.RIGHT),c);
		c.gridx=1;c.gridy=11;
		txtPrincipal.setFont(utils.textboxfont);
		pnlContent.add(txtPrincipal,c);
		
/*		c.gridx=0;c.gridy=12;
		btnClose.addActionListener(alistener);
		pnlContent.add(btnClose,c);
		c.gridx=1;c.gridy=12;
		btnUpdate.addActionListener(alistener);
		pnlContent.add(btnUpdate,c);*/
		
		frame_school.add(pnlContent,BorderLayout.CENTER);
		
		pnlControls.setLayout(new FlowLayout());
		btnClose.addActionListener(alistener);
		pnlControls.add(btnClose);
		btnUpdate.addActionListener(alistener);
		pnlControls.add(btnUpdate);
		frame_school.add(pnlControls,BorderLayout.SOUTH);
		
		
	}
	class actionListener implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==btnUpdate)
			{
				JOptionPane.showMessageDialog (null, "Update Called", "Update Called", JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getSource()==btnClose)
			{
				try{
				frame_school.setClosed(true);}catch(PropertyVetoException ae)
				{
					ae.printStackTrace();
				}
				// JMenuItem menuItem = ((JMenuItem) e.getSource());
		         //JInternalFrame frame = (JInternalFrame)  //frames.get(menuItem.getText());
		         // close the frame
		         //frame.getDesktopPane().getDesktopManager().closeFrame(frame);
				
				
				
			}
			
		}
		
	}
	
	
}

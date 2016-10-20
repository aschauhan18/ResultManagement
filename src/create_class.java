import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class create_class extends JInternalFrame {
		JPanel pnlHeader;
		JPanel pnlContent ;
		JPanel pnlControls ;
		actionListener alistener=new actionListener();
		JLabel lbltitle=new JLabel("CREATE CLASS");
		JLabel lblclass=new JLabel("Class name",SwingConstants.RIGHT); 
		JLabel lblsection=new JLabel("Section",SwingConstants.RIGHT);
		JLabel lblclassteacher=new JLabel("Class Teacher",SwingConstants.RIGHT);
		JTextField txtClassname=new JTextField(25);
		JTextField txtSection=new JTextField(25);
		JTextField txtClassTeacher=new JTextField(25);
		JButton btnClose;
		JButton btnSave;
	
	public create_class()
	{
		setTitle("------------CREATE CLASS--------------");
		setVisible(true);
		setMaximizable(false);
		setLocation(1,1);
		setClosable(true);
		txtClassname.setFont(utils.textboxfont);
		txtSection.setFont(utils.textboxfont);
		txtClassTeacher.setFont(utils.textboxfont);
		pnlHeader=new JPanel();
		pnlContent=new JPanel() ;
		btnClose=new JButton("Close");
		btnSave=new JButton("Save");
		btnClose.addActionListener(alistener);
		btnSave.addActionListener(alistener);
		pnlControls=new JPanel();
		try{
		setSelected(true);}catch(PropertyVetoException ae)
		{
			ae.printStackTrace();
		}
		
	}
	public JInternalFrame createClass()
	{
		lbltitle.setFont(utils.titlefont);
		pnlHeader.setBackground(utils.titlebackground);
		lbltitle.setForeground(utils.titleforeground);
		
		pnlHeader.add(lbltitle);
		getContentPane().add(pnlHeader,BorderLayout.NORTH);
		GridBagLayout gblayout=new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
		pnlContent.setLayout(gblayout);
		c.fill=GridBagConstraints.HORIZONTAL;
		//c.gridx=0;c.gridy=0;c.weightx=2;
		//pnlContent.add(new JSeparator(),c);
		
		c.gridx=0;c.gridy=1;c.weightx=1;c.ipady=10;c.ipadx=5;c.insets=new Insets(2, 2, 2, 5);
		pnlContent.add(lblclass,c);
		c.gridx=1;c.gridy=1;
		pnlContent.add(txtClassname,c);		
		c.gridx=0;c.gridy=2;
		pnlContent.add(lblclassteacher,c);
		c.gridx=1;c.gridy=2;
		pnlContent.add(txtClassTeacher,c);
		getContentPane().add(new JSeparator());
		getContentPane().add(pnlContent,BorderLayout.CENTER);
		pnlControls.setLayout(new FlowLayout());
		pnlControls.add(btnClose);
		pnlControls.add(btnSave);
		getContentPane().add(pnlControls,BorderLayout.SOUTH);
		
		pack();
		return this;
	}
	
	/*ACTION LISTENER WILL BE HERE*/
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
	

}

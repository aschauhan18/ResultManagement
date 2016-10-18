import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import com.sun.xml.internal.ws.api.server.Container;


public class mainPage implements ActionListener {

	static JFrame window;
	static JLabel headerlabel;
	static JPanel jpanel;
	static JPanel panelbody;
	static JPanel panelfooter;
	static JLabel lusername;
	static JLabel lpassword;
	static JTextField tusername;
	static JPasswordField tpassword;
	static JButton btnlogin;
	
	public static void main(String[] args)
	{
		new mainPage();
			
	}
	mainPage()
	{
		window=new JFrame("Create Marksheets");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		headerlabel=new JLabel("Login please");
		jpanel=new JPanel();
		/*initialize all controls*/
		lusername=new JLabel();
		lpassword=new JLabel();
		tusername=new JTextField();
		tpassword=new JPasswordField();
		/*closed*/
		
		btnlogin=new JButton("btnLogin");
		btnlogin.setText("Login me");
		
		btnlogin.addActionListener(this);
		
		//window.setLocation(500,300);
		window.setAlwaysOnTop(true);
		window.setContentPane(jpanel);
		
		setLoginPanel(jpanel);
		centerOnScreen(window,true);
		window.setResizable(false);
		//window.pack();
		window.setVisible(true);
	}
	public static void setLoginPanel(JPanel jpanel)
	{
		
		jpanel.setLayout(new BorderLayout());
		jpanel.setSize(200,200);
		JPanel paneltitle=new JPanel();
		paneltitle.setBorder(BorderFactory.createEtchedBorder());
		paneltitle.setBackground(Color.GRAY);
		headerlabel.setForeground(Color.WHITE);
		Font font=new Font("Serif", Font.ITALIC | Font.BOLD, 15);
		headerlabel.setFont(font);
		paneltitle.add(headerlabel);
		jpanel.add(paneltitle,BorderLayout.NORTH);
		
		/*Content body will be here */
		
		panelbody=new JPanel();
		//panelbody.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridLayout layout=new GridLayout(2,2);
		
		
		//GridBagLayout layout=new GridBagLayout();
		GridBagConstraints t=new GridBagConstraints();
		
		t.fill=GridBagConstraints.HORIZONTAL;
		t.weightx=.5;
		t.gridx=0;
		t.gridy=0;
		panelbody=new JPanel(layout);
		
		lusername=new JLabel();
		lusername.setText("User name");
		panelbody.add(lusername);
		t.weightx=.5;
		t.gridx=1;
		t.gridy=0;
		tusername=new JTextField(20);
		tusername.setToolTipText("Please Enter user name.");
		t.weightx=.5;
		t.gridx=0;
		t.gridy=1;
		panelbody.add(tusername);
		
		
		lpassword=new JLabel();
		lpassword.setText("Password");
		panelbody.add(lpassword);
		//   ---------textboxes --------------//
		
		
		tpassword=new JPasswordField(20);
		t.weightx=.5;
		t.gridx=0;
		t.gridy=1;
		
		panelbody.add(tpassword);
		panelbody.setBorder(BorderFactory.createEtchedBorder());
		jpanel.add(panelbody,BorderLayout.CENTER);
		
		//-----footer -----
		panelfooter=new JPanel();
		
		panelfooter.add(btnlogin);
		jpanel.add(panelfooter,BorderLayout.SOUTH);
		/*content bodyadded*/
		
	}
	
	 public void actionPerformed(ActionEvent e) {
		  System.out.println("Button1 has been clicked"+e.getActionCommand());
	    if (e.getActionCommand().equals("Login me")) {
	      System.out.println("Button1 has been clicked");
	     desktopmain d=new desktopmain();
	     d.createWindow();
	     window.setVisible(false);
	     window.dispose();
	     
	     
	    }
	 }
	
	 public static void centerOnScreen(JFrame window, boolean packFrame) {
	        //Validate frames that have preset sizes
	        //Pack frames that have useful preferred size info, e.g. from their layout
	        if (packFrame) {
	            window.pack();
	        } else {
	            window.validate();
	        }

	        //Center the frame window
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        Dimension frameSize = window.getSize();

	        if (frameSize.height > screenSize.height) {
	            frameSize.height = screenSize.height;
	        }

	        if (frameSize.width > screenSize.width) {
	            frameSize.width = screenSize.width;
	        }

	        window.setLocation((screenSize.width - frameSize.width) / 2,
	                (screenSize.height - frameSize.height) / 2);
	        
	    }
	 
	
	 
}

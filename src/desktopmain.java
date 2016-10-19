import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sun.media.sound.Toolkit;


public class desktopmain extends JFrame{
	JDesktopPane jdpDesktop;
	static int openFrameCount = 0;
	create_school crschoold;
	create_class crclass;
	createStudents crStudetents;
	createSession crSession;
	public desktopmain() {
		super("JInternalFrame Usage Demo");
		// Make the main window positioned as 50 pixels from each edge of the
		// screen.
		int inset = 50;
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 2,
				screenSize.height - inset * 2);
		// Add a Window Exit Listener
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// Create and Set up the GUI.
		jdpDesktop = new JDesktopPane();
		// A specialized layered pane to be used with JInternalFrames
		//createFrame(); // Create first window
		setContentPane(jdpDesktop);
		setJMenuBar(createMenuBar());
		// Make dragging faster by setting drag mode to Outline
		jdpDesktop.putClientProperty("JDesktopPane.dragMode", "outline");
	}
	protected JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Masters Entry");		
		
		menu.setMnemonic(KeyEvent.VK_N);
		JMenuItem menuSchoolItem = new JMenuItem("Create School");
		menuSchoolItem.setFont(utils.menuitemfont);
		menuSchoolItem.setForeground(utils.menuitemfgColor);
		menuSchoolItem.setMnemonic(KeyEvent.VK_N);		
		menuSchoolItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				crschoold =new create_school();		
			   jdpDesktop.add(crschoold.createSchoolFrame());
			}
		});		
		menu.add(menuSchoolItem);
		menu.addSeparator();
		/*MENU FOR CLASS*/
		JMenuItem menuClassItem = new JMenuItem("Create Class");
		menuClassItem.setMnemonic(KeyEvent.VK_A);		
		menuClassItem.setFont(utils.menuitemfont);
		menuClassItem.setForeground(utils.menuitemfgColor);
		menuClassItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				crclass=new create_class();
			   jdpDesktop.add(crclass.createClass());
			}
		});		

		menu.add(menuClassItem);
		/*CLASS MENU CLOSED */
		menu.addSeparator();
		/*MENU FOR STUDENTS*/
		JMenuItem menuStudentItem = new JMenuItem("Create Students");
		menuStudentItem.setMnemonic(KeyEvent.VK_S);		
		menuStudentItem.setFont(utils.menuitemfont);
		menuStudentItem.setForeground(utils.menuitemfgColor);
		menuStudentItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				crStudetents=new createStudents();
			   jdpDesktop.add(crStudetents.createStudents());
			}
		});		

		menu.add(menuStudentItem);
		/*MENU FOR STUDENTS CLOSED*/
		/*SESSION*/
		
		
		menu.addSeparator();
		/*----------MENU FOR Session--------------------*/
		JMenuItem menuSessionItem = new JMenuItem("Create Session");
		menuSessionItem.setMnemonic(KeyEvent.VK_S);		
		menuSessionItem.setFont(utils.menuitemfont);
		menuSessionItem.setForeground(utils.menuitemfgColor);
		menuSessionItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				crSession=new createSession();
			   jdpDesktop.add(crSession.createSessionwindow());
			}
		});		

		menu.add(menuSessionItem);
		/*-----------SESSION MENU CLOSED-----------*/
		
		
		menuBar.add(menu);
		return menuBar;
	}
	protected void createFrame() {
		MyInternalFrame frame = new MyInternalFrame();
		frame.setTitle("Create School");
		frame.setVisible(true);
		// Every JInternalFrame must be added to content pane using JDesktopPane
		jdpDesktop.add(frame);
		try {
			frame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
		}
	}
	/*public static void main(String[] args) {
		desktopmain frame = new desktopmain();
		frame.setVisible(true);
	}*/
	public void createWindow()
	{
		desktopmain frame = new desktopmain();
		frame.setVisible(true);
	}
	class MyInternalFrame extends JInternalFrame {

		static final int xPosition = 30, yPosition = 30;
		public MyInternalFrame() {
			super("IFrame #" + (++openFrameCount), true, // resizable
					true, // closable
					true, // maximizable
					true);// iconifiable
			setSize(300, 300);
			// Set the window's location.
			setLocation(xPosition * openFrameCount, yPosition
					* openFrameCount);
		}
	}

}

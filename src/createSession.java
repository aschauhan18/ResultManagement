import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import sun.management.snmp.util.JvmContextFactory;

public class createSession extends JInternalFrame {
	/* Declaration of Controls here */
	JPanel pnlHeader;
	JPanel pnlContainer;
	JPanel pnlEditCtrl;
	JPanel pnlSaveCtrl;
	JPanel pnlGrid;
	
	sessionactionevents clslistener =new sessionactionevents();
	JTextField txtfromdt=new JTextField(25);
	//Edit controls
	JLabel lblsession=new JLabel("Session ",SwingConstants.RIGHT);
	JLabel lblTitle=new JLabel("CREATE SESSION ",SwingConstants.CENTER);
	JLabel lblCrSession=new JLabel("Current Session ",SwingConstants.RIGHT);
	JCheckBox ckcrSession =new JCheckBox("Select to make Current Session.");
	JTextField txtSession=new JTextField(20);
	
	
	/*JDate picker implementation*/
	UtilDateModel modelfrom ;
	JDatePanelImpl datePanelfrom;
	JDatePickerImpl datePickerfrom ;
	
	
	UtilDateModel modelto ;
	JDatePanelImpl datePanelto;
	JDatePickerImpl datePickerto ;
	
	
	/*Declaration is closed*/
	JSeparator bottomSeparator;
	JButton btnSave ;
	JButton btnClose;
	
	Object[] columnnames ={"Session","Strat From","End to","Current"};
	Object[][] rowdata ={
			 {"16-17","01-Apr-2016","31-Mar-2017","Y"},
			 {"15-16","01-Apr-2015","31-Mar-2016",""}
	 };
	DefaultTableModel tblmodel ; 
	JTable sessionList ; 
	JScrollPane scrollSessionlist;
	JScrollPane scrollSessioncontainer;
	 
	
		public createSession()
		{
			 pnlHeader=new JPanel();
			 pnlContainer =new JPanel();
			 pnlEditCtrl=new JPanel();
			 pnlGrid=new JPanel();
			 pnlSaveCtrl=new JPanel();
			 modelfrom= new UtilDateModel();
			 modelto= new UtilDateModel();
			 Properties p = new Properties();
			 bottomSeparator=new JSeparator();
			 p.put("text.today", "Today");
			 p.put("text.month", "Month");
			 p.put("text.year", "Year");
			 modelfrom.setSelected(true);
			 modelto.setSelected(true);
			 btnSave =new JButton("Save");
			 btnClose =new JButton("Close");
			 btnClose.addActionListener(clslistener);
			// datePickerfrom.setFont(utils.textboxfont);
			 //datePickerto.setFont(utils.textboxfont);
			 datePanelfrom= new JDatePanelImpl(modelfrom, p);
			 datePickerfrom = new JDatePickerImpl(datePanelfrom,new DateLabelFormatter());
			 datePickerfrom.setDefaultLocale(Locale.US);
			 datePanelto= new JDatePanelImpl(modelto, p);
			 datePickerto = new JDatePickerImpl(datePanelto,new DateLabelFormatter());
			 datePickerto.setDefaultLocale(Locale.US);
			 lblTitle.setFont(utils.titlefont);
			 setTitle("------------CREATE Session--------------");
			 setVisible(true);
			 setMaximizable(false);
			 setLocation(1,1);
			 setClosable(true);
		}
	public JInternalFrame createSessionwindow()
	{
		Dimension widownsize =this.getSize();
		//pnlContainer.setLayout(new BorderLayout());
		pnlContainer.setLayout(new BoxLayout(pnlContainer,BoxLayout.Y_AXIS));
		pnlHeader.setLayout(new FlowLayout());
		lblTitle.setForeground(utils.titleforeground);
		pnlHeader.add(lblTitle);
		//pnlContainer.add(pnlHeader,BorderLayout.NORTH);
		pnlContainer.add(pnlHeader);
		GridBagLayout bgLayout =new GridBagLayout();
		GridBagConstraints c=new GridBagConstraints();
		pnlEditCtrl.setLayout(bgLayout);
		c.insets=new Insets(0, 5, 5, 5);
		c.gridx=0;c.gridy=0;
		c.fill=GridBagConstraints.HORIZONTAL;
		pnlEditCtrl.add(lblsession,c);
		c.gridx=1;c.gridy=0;
		txtSession.setFont(utils.textboxfont);
		pnlEditCtrl.add(txtSession,c);
		c.gridx=0;c.gridy=1;
		pnlEditCtrl.add(new JLabel("Sesssion Start From ") ,c);
		c.gridx=1;c.gridy=1;
		pnlEditCtrl.add(datePickerfrom ,c);
		c.gridx=0;c.gridy=2;
		pnlEditCtrl.add(new JLabel("Sesssion end To ") ,c);
		c.gridx=1;c.gridy=2;
		pnlEditCtrl.add(datePickerto ,c);
		c.gridx=0;c.gridy=3;
		pnlEditCtrl.add(lblCrSession,c);
		c.gridx=1;c.gridy=3;
		pnlEditCtrl.add(ckcrSession,c);
		
		scrollSessioncontainer=new JScrollPane(pnlEditCtrl);
		//pnlContainer.add(scrollSessioncontainer,BorderLayout.CENTER);
		pnlContainer.add(pnlEditCtrl);
		pnlGrid.setLayout(new BorderLayout());
		pnlSaveCtrl.setLayout(new FlowLayout());
		pnlSaveCtrl.add(btnSave);
		pnlSaveCtrl.add(btnClose);
		
		pnlGrid.add(pnlSaveCtrl,BorderLayout.NORTH);
		/*Table Binding*/
		tblmodel  = new DefaultTableModel(rowdata, columnnames);
		
		sessionList=new JTable(tblmodel);
		sessionList.getTableHeader().setFont(utils.titlefont);
		scrollSessionlist=new JScrollPane(sessionList);
		JPanel pnltableonly=new JPanel();
		pnltableonly.add(scrollSessionlist);
		
		pnlGrid.add(pnltableonly,BorderLayout.CENTER);
		
		/*Table binding finished*/
		//pnlContainer.add(pnlGrid,BorderLayout.SOUTH);
		pnlContainer.add(pnlGrid);
		getContentPane().add(pnlContainer);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		return this;
	}
	public class sessionactionevents implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==datePickerfrom)
			{
				//model.setDate(datePicker.getModel().getYear(), datePicker.getModel().getMonth(), datePicker.getModel().getDay());
				JOptionPane.showConfirmDialog(getContentPane(),datePickerfrom.getModel().getYear());
			}
			if(e.getSource()==btnClose)
			{
				try{
				setClosed(true);
				}catch(PropertyVetoException ae)
				{
					ae.printStackTrace();
				}
			}
			
		}
		
	}
	public  class DateLabelFormatter extends AbstractFormatter {

	    private String datePattern = "dd-MMM-yyyy";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}
}

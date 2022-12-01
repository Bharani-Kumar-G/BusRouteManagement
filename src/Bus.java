import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Bus extends JPanel implements ActionListener {
	private JRadioButton AC, nonAC;
	private JButton Add;
	private String[] routes;
	private BusController bus;
	private JLabel Title, busNoLab, RouteLab, acORnonAC;
	private JTextField busNo;
	private JComboBox Route;
	Bus() throws SQLException{
		Title = new JLabel();
		Title.setText("BUS MANAGEMENT");
		busNoLab = new JLabel();
		busNoLab.setText("BUS NO");
		busNo = new JTextField(50);
		bus = new BusController();
		routes = bus.getRouteNoArr();
		RouteLab = new JLabel();
		RouteLab.setText("Routes");
		Route = new JComboBox(routes);
		acORnonAC = new JLabel();
		acORnonAC.setText("AC OR Non AC");
		AC = new JRadioButton("AC");
		nonAC = new JRadioButton("NON AC");
		ButtonGroup bg = new ButtonGroup();
		bg.add(AC);bg.add(nonAC);
		Add = new JButton();
		Add.setText("ADD");
		Add.addActionListener(this);
		
		this.add(Title);
		this.add(busNoLab);
		this.add(busNo);
		this.add(RouteLab);
		this.add(Route);
		this.add(acORnonAC);
		this.add(AC);
		this.add(nonAC);
		this.add(Add);
		
		Title.setBounds(650, 20, 200, 30);
	    busNoLab.setBounds(580, 100, 100, 40);
	    busNo.setBounds(650,100, 200, 40);
	    RouteLab.setBounds(580, 150, 100, 40);
	    Route.setBounds(650, 150, 200, 40);
	    acORnonAC.setBounds(650, 200, 200, 40);;
		AC.setBounds(650, 250, 200, 50);
		nonAC.setBounds(650, 300, 200, 50);
		Add.setBounds(650, 350, 100, 40);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Add) {
			JLabel errors;
			boolean Result = true;
			String BusNo = busNo.getText();
			String RouteNo = (String) Route.getSelectedItem();
			byte ac = 0;
			if(AC.isSelected()) {
				ac = 1;
			}
			if(nonAC.isSelected()) {
				ac = 0;
			}
			try {
				Result = bus.checkBusData(BusNo, RouteNo, ac);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			errors = new JLabel();
			this.add(errors);
			errors.setBounds(600, 400, 200, 100);
			if(!Result) {
				errors.setText("ADDED SUCCESSFULLY");
			}
			else {
				
				errors.setText("FAILED TO ADD ROUTE");
			}
		}
	}
}

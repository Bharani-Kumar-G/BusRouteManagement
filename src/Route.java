import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Route extends JPanel implements ActionListener{
	private RouteController route;
	private static final long serialVersionUID = 1L;
	JLabel Title, RouteNoLab, FromLab, ToLab, DistLab;
	JTextField routeNo, From, To, Dist;
	JButton Add;
	Route(){
		Title = new JLabel();
		Title.setText("ROUTE MANAGEMENT");
		RouteNoLab = new JLabel();
		RouteNoLab.setText("ROUTE NO");
		routeNo = new JTextField(50);
		FromLab = new JLabel();
		FromLab.setText("From");
		From = new JTextField(50);
		ToLab = new JLabel();
		ToLab.setText("To");
		To = new JTextField(50);
		DistLab = new JLabel();
		DistLab.setText("Dist");
		Dist = new JTextField(40);
		Add = new JButton();
		Add.setText("ADD");
		Add.addActionListener(this);
		
		this.add(Title);
		this.add(RouteNoLab);
	    this.add(routeNo);
	    this.add(FromLab);
	    this.add(From);
	    this.add(ToLab);
	    this.add(To);
	    this.add(DistLab);
	    this.add(Dist);
	    this.add(Add);
	    
	    Title.setBounds(650, 20, 200, 30);
	    RouteNoLab.setBounds(580, 100, 100, 40);
	    routeNo.setBounds(650,100, 200, 40);
	    FromLab.setBounds(580, 150, 100, 40);
	    From.setBounds(650, 150, 200, 40);
	    ToLab.setBounds(580, 200, 100, 40);
	    To.setBounds(650, 200, 200, 40);
	    DistLab.setBounds(580, 250, 100, 40);
	    Dist.setBounds(650, 250, 200, 40);
	    Add.setBounds(650, 300, 100, 40);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Add) {
			JLabel errors;
			boolean Result = true;
			String RouteNo = routeNo.getText();
			String Start = From.getText();
			String Destination = To.getText();
			float distance = Float.parseFloat(Dist.getText());
			try {
				route = new RouteController();
				Result = route.checkRouteData(RouteNo, Start, Destination, distance);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("ERROR in SQL");
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

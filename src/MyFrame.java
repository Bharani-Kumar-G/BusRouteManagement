import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MyFrame extends JFrame{
	private static final long serialVersionUID = 1L;

	MyFrame() throws SQLException{
		ImageIcon icon = new ImageIcon(this.getClass().getResource("bus-school.png"));
		JTabbedPane jTabbedPane = new JTabbedPane();
		JPanel Route = new Route();
		JPanel Bus = new Bus();
		Route.setLayout(null);
		Bus.setLayout(null);
		this.setVisible(true);
		this.setSize(1366, 768);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("MANAGEMENT APP");
		this.setResizable(true);
		this.setIconImage(icon.getImage());
	    jTabbedPane.addTab("Route", Route);
	    
	    
	    jTabbedPane.addTab("Bus", Bus);
	    
	    GroupLayout layout = new GroupLayout(getContentPane());
	    getContentPane().setLayout(layout);
	    layout.setHorizontalGroup(
	      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	      .addComponent(jTabbedPane)
	    );
	    layout.setVerticalGroup(
	      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	      .addComponent(jTabbedPane)
	    );
	    
	    
	    
	    this.add(jTabbedPane);
	    
	}
}

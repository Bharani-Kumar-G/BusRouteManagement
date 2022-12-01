import java.sql.*;
public class BaseModel {
	private Statement createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BusReservation","root", "");
		}
		catch (Exception e) {
	         System.out.println("ERROR In CONNECTING DATABASE");
	    }
		Statement stmt = null;
		try {
		   stmt = connection.createStatement( );
		}
		catch (SQLException e) {
			System.out.println("ERROR In DATABASE statement");
		}
		return stmt;
	}
	public boolean insertData (String insertQuery) throws SQLException{
		Statement stmt = this.createConnection();
		boolean result = stmt.execute(insertQuery);
		return result;
	}
	public ResultSet getData (String getQuery) throws SQLException{
		Statement stmt = this.createConnection();
		ResultSet result = stmt.executeQuery(getQuery);
		return result;
	}
}

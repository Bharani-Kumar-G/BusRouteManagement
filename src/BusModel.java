import java.sql.SQLException;
public class BusModel extends BaseModel{
	public boolean addBus(String BusNo, int Route, byte ac) throws SQLException {
		
		String query = "INSERT INTO Bus (BusNo, Route, AC) VALUES ('"+BusNo+"','"+Route+"','"+ac+"')";
		return this.insertData(query);
	}
}

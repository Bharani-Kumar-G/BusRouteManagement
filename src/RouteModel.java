import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RouteModel extends BaseModel {
	private ResultSet Result;
	public boolean addRoute(String RouteNo, String Start, String Destination, float distance) throws SQLException {
		String query = "INSERT INTO Route (RouteNo, Start, Destination, Distance) VALUES ('"+RouteNo+"','"+Start+"','"+Destination+"','"+distance+"')";
		return this.insertData(query);
	}
	public String[] getRouteNoList() throws SQLException {
		String query = "SELECT RouteNo FROM Route";
		Result = this.getData(query);
		ArrayList<String> RouteNo = new ArrayList<String>();
		while(Result.next()) {
			RouteNo.add(Result.getString(1));
		}
		String[] RouteNoArr = new String[RouteNo.size()];
		RouteNoArr = RouteNo.toArray(RouteNoArr);
		return RouteNoArr;
	}
	public int getRoute(String RouteNo) throws SQLException {
		String query = "SELECT id FROM Route WHERE RouteNo = '"+RouteNo+"' LIMIT 1";
		Result = this.getData(query);
		int routeId;
		ArrayList<Integer> RouteId = new ArrayList<Integer>();
		while(Result.next()) {
			RouteId.add(Result.getInt(1));
		}
		Integer[] RouteIdArr = new Integer[RouteId.size()];
		RouteIdArr = RouteId.toArray(RouteIdArr);
		routeId = RouteIdArr[0];
		 return  routeId;
	}
	
}

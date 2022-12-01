import java.sql.SQLException;

public class RouteController extends BaseController {
	private RouteModel route = new RouteModel();
	public boolean checkRouteData(String RouteNo, String Start, String Destination, float distance) throws SQLException {
		if(this.isNumeric(distance)) {
			return route.addRoute(RouteNo, Start, Destination, distance);
		}
		else {
			return false;
		}
	}
	public String[] getRouteNo() throws SQLException {
		route = new RouteModel();
		return route.getRouteNoList();
	}
	public int getRouteId(String RouteNo) throws SQLException {
		
		return route.getRoute(RouteNo);
	}
}

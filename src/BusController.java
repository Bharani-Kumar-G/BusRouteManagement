import java.sql.SQLException;

public class BusController extends BaseController{
	private BusModel bus;
	private RouteController route;
	public boolean checkBusData(String BusNo, String RouteNo,byte ac) throws SQLException {
			bus = new BusModel();
			
			int routeId = route.getRouteId(RouteNo);
			
			return bus.addBus(BusNo, routeId, ac);
	}
	
	public String[] getRouteNoArr() throws SQLException {
		route = new RouteController();
		 return route.getRouteNo();
	}
}

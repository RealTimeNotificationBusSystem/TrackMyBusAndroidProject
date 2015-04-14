package webservice;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import controller.GetAllBusStopDetails;
import controller.GetBusRouteDetails;
import model.BusRoute;
import model.BusStop;

@Path("/getBusRouteAndBusStopDetails")
public class BusRouteAndBusStopService {

	@GET
	@Produces("application/json")
	public String courses() {
		String busStopData = null;
		String busRouteData = null;
		ArrayList<BusStop> busStop = new ArrayList<BusStop>();
		ArrayList<BusRoute> busRoute = new ArrayList<BusRoute>();
		try {
			busStop = new GetAllBusStopDetails().getAllBusStopDetails();
			busRoute = new GetBusRouteDetails().getAllBusRouteDetails();
			Gson gson = new Gson();
			busStopData = gson.toJson(busStop);
			busRouteData = gson.toJson(busRoute);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return busStopData;
	}
}

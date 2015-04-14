package controller;

import java.util.ArrayList;

import javax.ws.rs.Path;

import model.BusRoute;
import model.BusRouteDAO;
import model.DAOFactory;

@Path("/getbusroutedetails")
public class GetBusRouteDetails {

	public ArrayList<BusRoute> getAllBusRouteDetails() {
		DAOFactory factory = new DAOFactory();
		return factory.getDetails(new BusRouteDAO());
	}
	
}

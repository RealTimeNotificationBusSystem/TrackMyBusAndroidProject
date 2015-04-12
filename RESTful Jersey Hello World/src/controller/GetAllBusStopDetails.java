package controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.BusStop;
import model.BusStopDAO;
import model.DAOFactory;

@Path("/getallbusstopdetails")
public class GetAllBusStopDetails {

	public ArrayList<BusStop> getAllBusStopDetails() {
		DAOFactory factory = new DAOFactory();
		return factory.getDetails(new BusStopDAO());
	}


}
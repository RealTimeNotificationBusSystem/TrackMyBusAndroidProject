package controller;

import java.util.ArrayList;


import model.BusStop;
import model.BusStopDAO;
import model.DAOFactory;

public class BusStopDetails {

	public static void main(String args[]) {
		DAOFactory factory = new DAOFactory();
		ArrayList<BusStop> busStopData = factory.getDetails(new BusStopDAO());
		try {
			for (BusStop busStop : busStopData) {
				System.out.println("Bus ID=" + busStop.getBusStopId());
				System.out.println("Bus Name="+busStop.getBusName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package controller;

import java.util.ArrayList;

import model.BusInformation;
import model.BusInformationDAO;
import model.DAOFactory;

public class GetUpdatedBusLocationDetails {

	public ArrayList<BusInformation> getUpdatedBusLocationDetails() {
		DAOFactory factory = new DAOFactory();
		return factory.getDetails(new BusInformationDAO());
	}
	
	public void updateBusLocationInfoDetails(String busLocLongitude,String busLocLatitude, int busId,int BRID)
	{
		DAOFactory factory = new DAOFactory();
		BusInformation busInformation= new BusInformation(busLocLongitude,busLocLatitude,busId,BRID);
		
		factory.update(new BusInformationDAO(), busId);
		
	}
}

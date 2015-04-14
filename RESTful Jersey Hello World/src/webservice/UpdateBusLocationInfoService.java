package webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import controller.GetUpdatedBusLocationDetails;


@Path("/updatebuslocationinfodetails")
public class UpdateBusLocationInfoService {

	@GET
	@Consumes
	public void courses() {
		try {
			new GetUpdatedBusLocationDetails().updateBusLocationInfoDetails("18.100000","18.100000",1,1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}

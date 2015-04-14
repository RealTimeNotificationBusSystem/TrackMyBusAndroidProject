package webservice;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.google.gson.Gson;
import controller.GetUpdatedBusLocationDetails;
import model.BusInformation;


@Path("/getUpdatedBusLocationDetails")
public class UpdatedBusLocationService {

	@GET
	@Produces("application/json")
	public String courses() {
		String busInformationData = null;
		ArrayList<BusInformation> busInformation = new ArrayList<BusInformation>();

		try {
			busInformation = new GetUpdatedBusLocationDetails()
					.getUpdatedBusLocationDetails();
			Gson gson = new Gson();
			busInformationData = gson.toJson(busInformation);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return busInformationData;
	}
}

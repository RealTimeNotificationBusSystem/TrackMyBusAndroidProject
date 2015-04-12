package webservice;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
 

import controller.GetAllBusStopDetails;
import model.BusStop;
 
@Path("/getallbusstopdetails")
public class BusStopDetailsService {

@GET
//@Path("/courses")
@Produces("application/json")
public String courses()
{
String busStopData = null;
ArrayList<BusStop> busStop = new ArrayList<BusStop>();
try
{
	busStop = new GetAllBusStopDetails().getAllBusStopDetails();
Gson gson = new Gson();
busStopData = gson.toJson(busStop);
} catch (Exception e)
{
e.printStackTrace();
}
return busStopData;
}
}

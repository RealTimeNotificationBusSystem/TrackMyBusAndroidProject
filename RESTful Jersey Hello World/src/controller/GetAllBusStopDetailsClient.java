package controller;

import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import model.BusStop;
import model.BusStopDAO;
import model.DAOFactory;

import org.glassfish.jersey.client.ClientConfig;

public class GetAllBusStopDetailsClient {

	private static final String webServiceURI = "http://localhost:8085/TrackMyBus";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);

		DAOFactory factory = new DAOFactory();
		ArrayList<BusStop> busStopData = factory.getDetails(new BusStopDAO());

	}
}

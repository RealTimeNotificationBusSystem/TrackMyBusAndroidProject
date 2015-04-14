package controller;

import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import model.BusRoute;
import model.BusRouteDAO;
import model.DAOFactory;

import org.glassfish.jersey.client.ClientConfig;

public class GetBusRouteDetailsClient {

	private static final String webServiceURI = "http://localhost:8085/TrackMyBus";

	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);

		DAOFactory factory = new DAOFactory();
		ArrayList<BusRoute> busRouteData = factory.getDetails(new BusRouteDAO());

	}
}

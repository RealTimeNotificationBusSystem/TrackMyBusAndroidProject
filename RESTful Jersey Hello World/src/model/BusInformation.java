package model;

public class BusInformation {
	private int busId;
	private String deviceNum;
	private String busLocationLongitude;
	private String busLocationLatitude;
	private String busLastUpdate;
	private int busRouteId;

	public BusInformation()
	{}
	
	public BusInformation(String busLocationLongitude, String busLocationLatitude, int busId, int BRID )
	{
		setBusLocationLongitude(busLocationLongitude);
		setBusLocationLatitude(busLocationLatitude);
		setBusId(busId);
		setBusRouteId(busRouteId);
	}
	
	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	public String getBusLocationLongitude() {
		return busLocationLongitude;
	}

	public void setBusLocationLongitude(String busLocationLongitude) {
		this.busLocationLongitude = busLocationLongitude;
	}

	public String getBusLocationLatitude() {
		return busLocationLatitude;
	}

	public void setBusLocationLatitude(String busLocationLatitude) {
		this.busLocationLatitude = busLocationLatitude;
	}

	public String getBusLastUpdate() {
		return busLastUpdate;
	}

	public void setBusLastUpdate(String busLastUpdate) {
		this.busLastUpdate = busLastUpdate;
	}

	public int getBusRouteId() {
		return busRouteId;
	}

	public void setBusRouteId(int busRouteId) {
		this.busRouteId = busRouteId;
	}

}

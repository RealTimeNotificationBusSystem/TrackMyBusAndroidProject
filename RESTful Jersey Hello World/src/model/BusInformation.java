package model;

public class BusInformation {
	private int busId;
	private String deviceNum;
	private String busLocationLongitude;
	private String bus_LocationLatitude;
	private String busLastUpdate;
	private String busRouteId;

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

	public String getBus_LocationLatitude() {
		return bus_LocationLatitude;
	}

	public void setBus_LocationLatitude(String bus_LocationLatitude) {
		this.bus_LocationLatitude = bus_LocationLatitude;
	}

	public String getBusLastUpdate() {
		return busLastUpdate;
	}

	public void setBusLastUpdate(String busLastUpdate) {
		this.busLastUpdate = busLastUpdate;
	}

	public String getBusRouteId() {
		return busRouteId;
	}

	public void setBusRouteId(String busRouteId) {
		this.busRouteId = busRouteId;
	}

}

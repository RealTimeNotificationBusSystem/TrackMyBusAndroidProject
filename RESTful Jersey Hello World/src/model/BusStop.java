package model;

public class BusStop {
	private int busStopId;
	private String busName;
	private String busLocationLongitude;
	private String busLocationLatitude;
	private String busStatus;

	public int getBusStopId() {
		return busStopId;
	}

	public void setBusStopId(int busStopId) {
		this.busStopId = busStopId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
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

	public String getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(String busStatus) {
		this.busStatus = busStatus;
	}

	@Override
	public String toString() {
		return "BusStop [busStopId=" + busStopId + ", busName=" + busName
				+ ", busLocationLongitude=" + busLocationLongitude
				+ ", busLocationLatitude=" + busLocationLatitude
				+ ", busStatus=" + busStatus + "]";
	}

}

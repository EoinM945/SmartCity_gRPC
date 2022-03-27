package grpc.services.location;

public class Location {
	private String locationRequest;
	private String locationChange;

	public Location() {

	}

	public Location(String locationRequest, String locationChange) {
		this.locationRequest = locationRequest;
		this.locationChange = locationChange;
	}

	public String getlocationRequest() {
		return locationRequest;
	}

	public void setlocationRequest(String locationRequest) {
		this.locationRequest = locationRequest;
	}

	public String getCarChange() {
		return locationChange;
	}

	public void setlocationChange(String locationChange) {
		this.locationChange = locationChange;
	}
}
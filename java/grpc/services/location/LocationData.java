package grpc.services.location;

// Locations handling 
public class LocationData {

	// Variables
	private String type, typeId;
	private boolean on;
	public static LocationData location;

	// Constructors
	public LocationData() {
		this.type = "location";
		this.on = true;
		this.typeId = "location ID";
	}

	// Setters & Getters
	public String gettype() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}

	public String gettypeId() {
		return typeId;
	}

	public void settypeId(String typeId) {
		this.typeId = typeId;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public static LocationData getInstance() {
		if (location == null) {
			location = new LocationData();
		}
		return location;
	}
}
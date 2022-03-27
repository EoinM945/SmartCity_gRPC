package grpc.services.location;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

// Client Side Implementation
public class LocationClient {

	private static LocationServiceGrpc.locationServiceBlockingStub lblockingStub;
	private static LocationServiceGrpc.locationServiceStub lasyncStub;

	// Adds a listener for discovery
	public static class Listener implements ServiceListener {
		// Service resolution
		public void serviceAdded(ServiceEvent serviceEvent) {
			System.out.println("Service added: " + serviceEvent.getInfo());
		}

		// Removed service
		public void serviceRemoved(ServiceEvent serviceEvent) {
			System.out.println("Service removed: " + serviceEvent.getInfo());
		}

		// Service resolved.
		public void serviceResolved(ServiceEvent serviceEvent) {
			System.out.println("Service resolved: " + serviceEvent.getInfo());
			ServiceInfo info = serviceEvent.getInfo();
			final int Port = serviceEvent.getInfo().getPort();
			String address = info.getHostAddresses()[0];
		}
	}

	public static void main(String[] args) throws Exception {

		// gRPC channels
		ManagedChannel locationchannel = ManagedChannelBuilder.forAddress("localhost", 50097).usePlaintext().build();

		// Stubs - generated through proto
		lblockingStub = LocationServiceGrpc.newBlockingStub(locationchannel);
		lasyncStub = LocationServiceGrpc.newStub(locationchannel);

		try {
			// Creates a jmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Adds a service listener
			jmdns.addServiceListener("_http._tcp.local.", new Listener());
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		locationOnOff();
	}
	
	// gRPC services

	// Location Controls
	public static void locationOnOff() {
		LocationRequest request = LocationRequest.newBuilder().setSwitch(false).build();

		// If true, locations are off otherwise, turn locations on
		LocationResponse response = lblockingStub.locationOnOff(request);
		if (response.getSwitch()) {
			System.out.println("Location off!");
		} else {
			System.out.println("Location on!");
		}
	}
}
package grpc.services.location;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.services.building.BuildingServer;
import grpc.services.energy.SwitchRequest;
import grpc.services.energy.SwitchResponse;
import grpc.services.location.LocationServiceGrpc.locationServiceImplBase;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

// Server Side Implementation
public class LocationServer extends locationServiceImplBase {

	private static final Logger logger = Logger.getLogger(BuildingServer.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("Starting gRPC Location Server");

		try {
			// Defines port
			int PORT = 50097;

			// Creating a jmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Adds the service listener
			ServiceInfo serviceLocation = ServiceInfo.create("_http._tcp.local.", "location", 50097, "path=index.html");
			jmdns.registerService(serviceLocation);

			// Getting the reference to the server
			LocationServer locationServer = new LocationServer();
			Server server = ServerBuilder.forPort(PORT).addService(locationServer).build().start();
			logger.info("location server started, listening on " + PORT);
			server.awaitTermination();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	// gRPC services

	// Location
	public void locationOnOff(LocationRequest request, StreamObserver<LocationResponse> responseObserver) {

		// Notification of method invocation
		System.out.println("Receiving request to turn On/Off Location Connection");

		// If true, devices turn off otherwise, they'll turn on
		Boolean OnOffL = request.getSwitch();
		if (OnOffL) {
			System.out.println("Turning Location Connection off!");
		} else {
			System.out.println("Turning Location Connection on!");
		}

		LocationResponse response = LocationResponse.newBuilder().setSwitch(OnOffL).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	protected MethodDescriptor<?, ?> getSwitchLocationMethod() {
		// TODO Auto-generated method stub
		return null;
	}
}
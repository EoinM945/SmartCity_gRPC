package grpc.services.building;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.services.building.BuildingServiceGrpc.BuildingServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

// Server Side Implementation
public class BuildingServer extends BuildingServiceImplBase {

	private static final Logger logger = Logger.getLogger(BuildingServer.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("Starting gRPC Utilities Server");

		try {
			// Defines port
			int PORT = 50098;

			// Creates a jmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Adds the service listener
			ServiceInfo serviceBuilding = ServiceInfo.create("_http._tcp.local.", "building", 50098, "path=index.html");
			jmdns.registerService(serviceBuilding);

			// Gets the reference to the server
			BuildingServer buildingServer = new BuildingServer();
			Server server = ServerBuilder.forPort(PORT).addService(buildingServer).build().start();
			logger.info("Building server started, listening on " + PORT);
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

	// Switch devices
	@Override
	public void switchBuilding(BuildingRequest request, StreamObserver<BuildingResponse> responseObserver) {

		// Notification of method invocation
		System.out.println("Receiving request to turn On/Off devices!");

		// If true, devices are off otherwise, they're turned on
		boolean OnOffD = request.getDevices();
		if (OnOffD) {
			System.out.println("Setting Building Connection off!");
		} else {
			System.out.println("Setting Building Connection on!");
		}

		BuildingResponse response = BuildingResponse.newBuilder().setDevices(OnOffD).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	// Prints the details list
	@Override
	public StreamObserver<PrinterRequest> printList(final StreamObserver<PrinterResponse> responseObserver) {
		return new StreamObserver<PrinterRequest>() {

			// Stringbuilder which holds all details that have been added
			public void onNext(PrinterRequest request) {
				StringBuilder sb = new StringBuilder(request.getPList());
				PrinterResponse toPrint = PrinterResponse.newBuilder().setPList(sb.toString()).build();
				responseObserver.onNext(toPrint);
			}

			public void onError(Throwable t) {
				System.out.println("Printing server failed");
			}

			public void onCompleted() {
				responseObserver.onCompleted();
			}
		};
	}
}
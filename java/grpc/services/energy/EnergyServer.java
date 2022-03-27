package grpc.services.energy;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.services.building.BuildingServer;
import grpc.services.energy.EnergyServiceGrpc.EnergyServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

// Server Side Implementation
public class EnergyServer extends EnergyServiceImplBase {

	private static final Logger logger = Logger.getLogger(BuildingServer.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException {

		System.out.println("Starting gRPC Energy Server");

		try {
			// Defines port
			int PORT = 50099;

			// Creating a jmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Adding the service listener
			ServiceInfo serviceEnergy = ServiceInfo.create("_http._tcp.local.", "energy", 50099, "path=index.html");
			jmdns.registerService(serviceEnergy);

			// Collecting the reference to the server
			EnergyServer energyServer = new EnergyServer();
			Server server = ServerBuilder.forPort(PORT).addService(energyServer).build().start();

			logger.info("Energy server started, listening on " + PORT);
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

	// Switch for HVAC
	@Override
	public void hvacOnOff(SwitchRequest request, StreamObserver<SwitchResponse> responseObserver) {

		// Notification of method invocation
		System.out.println("Receiving request to turn on/off HVAC!");

		// If true, devices will turn off otherwise, they'll turn on
		boolean OnOffH = request.getPower();
		if (request.getPower()) {
			System.out.println("Setting HVAC off!");
		} else {
			System.out.println("Setting HVAC on!");
		}

		SwitchResponse response = SwitchResponse.newBuilder().setPower(OnOffH).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
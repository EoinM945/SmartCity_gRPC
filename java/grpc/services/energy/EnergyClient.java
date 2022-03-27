package grpc.services.energy;

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

// Client Implementation
public class EnergyClient {

	private static EnergyServiceGrpc.EnergyServiceBlockingStub cblockingStub;
	private static EnergyServiceGrpc.EnergyServiceStub casyncStub;
	public static int randomCo = (int) (Math.random() * 100 + 1);

	// Adds a listener for discovery
	public static class Listener implements ServiceListener {
		// Service resolution
		public void serviceAdded(ServiceEvent serviceEvent) {
			System.out.println("Service added: " + serviceEvent.getInfo());
		}

		// Removes service
		public void serviceRemoved(ServiceEvent serviceEvent) {
			System.out.println("Service removed: " + serviceEvent.getInfo());
		}

		// Service resolved
		public void serviceResolved(ServiceEvent serviceEvent) {
			System.out.println("Service resolved: " + serviceEvent.getInfo());
			ServiceInfo info = serviceEvent.getInfo();
			final int Port = serviceEvent.getInfo().getPort();
			String address = info.getHostAddresses()[0];
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		// gRPC channel
		ManagedChannel energychannel = ManagedChannelBuilder.forAddress("localhost", 50099).usePlaintext().build();

		// Stubs - generated through proto
		cblockingStub = EnergyServiceGrpc.newBlockingStub(energychannel);
		casyncStub = EnergyServiceGrpc.newStub(energychannel);

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

		energyOnOff();
	}


	 // gRPC services

	// Switch for HVAC
	public static void energyOnOff() {

		SwitchRequest request = SwitchRequest.newBuilder().setPower(false).build();

		SwitchResponse response = cblockingStub.energyOnOff(request);
		// If true, Energy connection off otherwise, on
		if (response.getPower()) {
			System.out.println("Energy Connection Off");
		} else {
			System.out.println("Energy Connection On");
		}
	}
}
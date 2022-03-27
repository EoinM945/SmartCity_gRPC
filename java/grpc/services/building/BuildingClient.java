package grpc.services.building;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import grpc.services.location.LocationRequest;
import grpc.services.location.LocationResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

// Client Implementation
public class BuildingClient {

	private static BuildingServiceGrpc.BuildingServiceBlockingStub ublockingStub;
	private static BuildingServiceGrpc.BuildingServiceStub uasyncStub;

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

		// Service resolved
		public void serviceResolved(ServiceEvent serviceEvent) {
			System.out.println("Service resolved: " + serviceEvent.getInfo());
			ServiceInfo info = serviceEvent.getInfo();
			final int Port = serviceEvent.getInfo().getPort();
			String address = info.getHostAddresses()[0];
		}
	}

	public static void main(String[] args) throws Exception {

		// gRPC channels
		ManagedChannel buildingchannel = ManagedChannelBuilder.forAddress("localhost", 50098).usePlaintext().build();

		// Stubs - generated through proto
		ublockingStub = BuildingServiceGrpc.newBlockingStub(buildingchannel);
		uasyncStub = BuildingServiceGrpc.newStub(buildingchannel);

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

		switchBuilding();
		printList();
	}

	// gRPC services

	// Switches for devices
	public static void switchBuilding() {

		BuildingRequest request = BuildingRequest.newBuilder().setBuilding(false).build();

		// Notification of method invocation
		BuildingResponse response = ublockingStub.switchBuilding(request);
		if (response.getSwitch()) {
			System.out.println("Building Connection off!");
		} else {
			System.out.println("Building Connection on!");
		}
	}

	// Prints the building details list
	public static void printList() {

		StreamObserver<PrinterResponse> responseObserver = new StreamObserver<PrinterResponse>() {

			public void onNext(PrinterResponse value) {
				System.out.println("Printing details list: " + value.getPList());
			}

			public void onError(Throwable t) {
			}

			public void onCompleted() {
			}

		};

		StreamObserver<PrinterRequest> requestObserver = uasyncStub.printList(responseObserver);
		try {
			// Details list
			requestObserver.onNext(PrinterRequest.newBuilder().setPList("1. NCI, Energy Rating: B, Location: D01X00Y").build());
			requestObserver.onNext(PrinterRequest.newBuilder().setPList("2. Test").build());
			requestObserver.onNext(PrinterRequest.newBuilder().setPList("3. ").build());
			requestObserver.onNext(PrinterRequest.newBuilder().setPList("4. ").build());
			requestObserver.onNext(PrinterRequest.newBuilder().setPList("5. ").build());

			Thread.sleep(500);
		} catch (RuntimeException e) {
			requestObserver.onError(e);
			throw e;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		requestObserver.onCompleted();
	}
}
package jmDNS;

import java.io.IOException;
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class ServiceRegistration {

	public static JmDNS jmdns;

	public static void main(String[] args) throws InterruptedException {
	}

	public void jmdnsRegister(int energyPort, int locationPort, int buildingPort) throws InterruptedException {

		try {
			// Creating a jmDNS instance
			jmdns = JmDNS.create(InetAddress.getLocalHost());

			// Register all of the services
			System.out.println("Service Registration.");
			ServiceInfo serviceBuilding = ServiceInfo.create("_http._tcp.local.", "building", 50098, "path=index.html");
			ServiceInfo serviceEnergy = ServiceInfo.create("_http._tcp.local.", "energy", 50099, "path=index.html");
			ServiceInfo servicelocation = ServiceInfo.create("_http._tcp.local.", "location", 50097, "path=index.html");

			jmdns.registerService(serviceBuilding);
			jmdns.registerService(serviceEnergy);
			jmdns.registerService(servicelocation);
			System.out.println("Registering Services.");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// Unregisters all of the services
	public void unRegister() {
		System.out.println("Unregistered.");
		jmdns.unregisterAllServices();
	}
}
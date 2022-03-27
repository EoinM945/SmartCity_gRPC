package scGUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import grpc.services.building.BuildingRequest;
import grpc.services.building.BuildingResponse;
import grpc.services.building.BuildingServiceGrpc;
import grpc.services.building.PrinterRequest;
import grpc.services.building.PrinterResponse;
import grpc.services.energy.EnergyServiceGrpc;
import grpc.services.energy.SwitchRequest;
import grpc.services.energy.SwitchResponse;
import grpc.services.location.LocationRequest;
import grpc.services.location.LocationResponse;
import grpc.services.location.LocationServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import jmDNS.ServiceRegistration;

public class guiClient {

	private JFrame frame;
	private static EnergyServiceGrpc.EnergyServiceBlockingStub cblockingStub;
	private static EnergyServiceGrpc.EnergyServiceStub casyncStub;
	private static LocationServiceGrpc.locationServiceBlockingStub lblockingStub;
	private static LocationServiceGrpc.locationServiceStub lasyncStub;
	private static BuildingServiceGrpc.BuildingServiceBlockingStub ublockingStub;
	private static BuildingServiceGrpc.BuildingServiceStub uasyncStub;
	private static int energyPort = 50099;
	private static int locationPort = 50097;
	private static int buildingPort = 50098;
	public static JTextField messages;

	public static class Listener implements ServiceListener {
		public void serviceAdded(ServiceEvent serviceEvent) {
			System.out.println("Service added: " + serviceEvent.getInfo());
		}

		public void serviceRemoved(ServiceEvent serviceEvent) {
			System.out.println("Service removed: " + serviceEvent.getInfo());
		}

		public void serviceResolved(ServiceEvent serviceEvent) {
			System.out.println("Service resolved: " + serviceEvent.getInfo());
			// Ports for connections will be designated according to each event
			if (serviceEvent.getName().equals("energy")) {
				energyPort = serviceEvent.getInfo().getPort();
			} else if (serviceEvent.getName().equals("location")) {
				locationPort = serviceEvent.getInfo().getPort();
			} else if (serviceEvent.getName().equals("building")) {
				buildingPort = serviceEvent.getInfo().getPort();
			}
		}
	}

	// Launch the app
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() { // check line
			public void run() {// check line
				try {
					guiClient window = new guiClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the app
	public guiClient() throws InterruptedException, IOException {

		initialize();
		ServiceRegistration reg = new ServiceRegistration();
		reg.jmdnsRegister(energyPort, locationPort, buildingPort);

		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			jmdns.addServiceListener("_http._tcp.local.", new guiClient.Listener());
			jmdns.addServiceListener("_http._tcp.local.", new guiClient.Listener());
			jmdns.addServiceListener("_http._tcp.local.", new guiClient.Listener());
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ManagedChannel energychannel = ManagedChannelBuilder.forAddress("localhost", 50099).usePlaintext().build();
		cblockingStub = EnergyServiceGrpc.newBlockingStub(energychannel);
		casyncStub = EnergyServiceGrpc.newStub(energychannel);

		ManagedChannel locationchannel = ManagedChannelBuilder.forAddress("localhost", 50097).usePlaintext().build();
		lblockingStub = LocationServiceGrpc.newBlockingStub(locationchannel);
		lasyncStub = LocationServiceGrpc.newStub(locationchannel);

		ManagedChannel buildingchannel = ManagedChannelBuilder.forAddress("localhost", 50098).usePlaintext().build();
		ublockingStub = BuildingServiceGrpc.newBlockingStub(buildingchannel);
		uasyncStub = BuildingServiceGrpc.newStub(buildingchannel);
	}

	// Initialize the frame
	private void initialize() {

		// Frame, labels & separators
		frame = new JFrame("Smart City Application");
		frame.getContentPane().setForeground(new Color(255, 228, 225));
		frame.setBounds(100, 100, 406, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);

		JLabel TitleLabel = new JLabel("Smart City Application");
		TitleLabel.setForeground(SystemColor.desktop);
		TitleLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		TitleLabel.setBounds(21, 10, 342, 52);
		frame.getContentPane().add(TitleLabel);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-13, 72, 418, 2);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(-13, 162, 418, 2);
		frame.getContentPane().add(separator_2);

		messages = new JTextField();
		messages.setBackground(SystemColor.inactiveCaptionBorder);
		messages.setBounds(0, 231, 395, 25);
		frame.getContentPane().add(messages);
		messages.setColumns(10);

		// Buttons & labels
		JLabel energyLabel = new JLabel("Energy Ratings");
		energyLabel.setForeground(SystemColor.desktop);
		energyLabel.setBounds(145, 84, 107, 26);
		frame.getContentPane().add(energyLabel);
		energyLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		final JToggleButton energyOn = new JToggleButton("Off");
		energyOn.setFont(new Font("Tahoma", Font.BOLD, 11));
		energyOn.setBounds(166, 120, 65, 23);
		frame.getContentPane().add(energyOn);
		energyOn.setSelected(true);
		energyOn.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (energyOn.isSelected()) {
					energyOn.setText("Off");
					energyOnOff(true);
				} else {
					energyOn.setText("On");
					energyOnOff(false);
				}
			}
		});
		
		final JToggleButton locationOn = new JToggleButton("Off");
		locationOn.setFont(new Font("Tahoma", Font.BOLD, 11));
		locationOn.setBounds(166, 120, 65, 23);
		frame.getContentPane().add(locationOn);
		locationOn.setSelected(true);
		locationOn.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (locationOn.isSelected()) {
					locationOn.setText("Off");
					locationOnOff(true);
				} else {
					locationOn.setText("On");
					locationOnOff(false);
				}
			}
		});
		
		// Buttons & labels
		JLabel buildingLabel = new JLabel("Buildings");
		buildingLabel.setForeground(SystemColor.desktop);
		buildingLabel.setBounds(31, 84, 59, 26);
		frame.getContentPane().add(buildingLabel);
		buildingLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel BuildingList = new JLabel("Building List");
		BuildingList.setForeground(SystemColor.desktop);
		BuildingList.setBounds(166, 174, 86, 25);
		frame.getContentPane().add(BuildingList);
		BuildingList.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel locationLabel = new JLabel("Locations");
		locationLabel.setForeground(SystemColor.desktop);
		locationLabel.setBounds(304, 84, 59, 26);
		frame.getContentPane().add(locationLabel);
		locationLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		final JToggleButton buildingOnOff = new JToggleButton("Off");
		buildingOnOff.setFont(new Font("Tahoma", Font.BOLD, 11));
		buildingOnOff.setBounds(31, 120, 62, 23);
		frame.getContentPane().add(buildingOnOff);
		buildingOnOff.setSelected(true);
		buildingOnOff.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (buildingOnOff.isSelected()) {
					buildingOnOff.setText("Off");
					switchBuilding(true);
				} else {
					buildingOnOff.setText("On");
					switchBuilding(false);
				}
			}
		});
		
		final JToggleButton locationOnOff = new JToggleButton("Off");
		locationOnOff.setFont(new Font("Tahoma", Font.BOLD, 11));
		locationOnOff.setBounds(301, 121, 62, 23);
		frame.getContentPane().add(locationOnOff);
		locationOnOff.setSelected(true);
		locationOnOff.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (locationOnOff.isSelected()) {
					locationOnOff.setText("Off");
					switchLocation(true);
				} else {
					locationOnOff.setText("On");
					switchLocation(false);
				}
			}
		});
		
		JButton printLabel = new JButton("Print");
		printLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		printLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printList();
			}
		});

		printLabel.setBorderPainted(false);
		printLabel.setBackground(SystemColor.activeCaption);
		printLabel.setBounds(166, 198, 73, 23);
		frame.getContentPane().add(printLabel);
		
		
	}

	// gRPC & Energy Services
	public static void energyOnOff(boolean onOffE) {

		SwitchRequest request = SwitchRequest.newBuilder().setPower(onOffE).build();
		SwitchResponse response;

		try {
			response = cblockingStub.energyOnOff(request);
		} catch (StatusRuntimeException e) {
			System.out.println("RPC Energy Failed:" + e.getStatus());
			return;
		}
		if (response.getPower()) {
			messages.setText("Ratings Connection off");
		} else {
			messages.setText("Ratings Connection on");
		}
	}
	
	// location Services
	public void locationOnOff(boolean onOfflocations) {

		LocationRequest request = LocationRequest.newBuilder().setSwitch(onOfflocations).build();

		LocationResponse response;
		try {
			response = lblockingStub.locationOnOff(request);
		} catch (StatusRuntimeException e) {
			System.out.println("RPC Location Failed:" + e.getStatus());
			return;
		}

		if (response.getSwitch()) {
			messages.setText("Location Connection off");
		} else {
			messages.setText("Location Connection on");
		}
	}

	// Building Services
	public static void switchBuilding(boolean onOffB) {

		BuildingRequest request = BuildingRequest.newBuilder().setBuilding(onOffB).build();

		BuildingResponse response;
		try {
			response = ublockingStub.switchBuilding(request);
		} catch (StatusRuntimeException e) {
			System.out.println("RPC Buildings Failed:" + e.getStatus());
			return;
		}
		if (response.getSwitch()) {
			messages.setText("Buildings Connection off");
		} else {
			messages.setText("Buildings Connection on");
		}
	}

	public static void switchLocation(boolean onOffL) {

		LocationRequest request = LocationRequest.newBuilder().setSwitch(onOffL).build();

		LocationResponse response;
		try {
			response = ublockingStub.switchLocation(request);
		} catch (StatusRuntimeException e) {
			System.out.println("RPC Location failed:" + e.getStatus());
			return;
		}
		if (response.getSwitch()) {
			messages.setText("Location Connection off");
		} else {
			messages.setText("Location Connection on");
		}
	}
	
	// Prints list of buildings
	public static void printList() {

		final ArrayList<String> listOfDetails = new ArrayList<String>();

		StreamObserver<PrinterResponse> responseObserver = new StreamObserver<PrinterResponse>() {
			public void onNext(PrinterResponse value) {
				listOfDetails.add(value.getPList());
			}

			public void onError(Throwable t) {
				System.out.println("gRPC printer failed: " + t.getMessage());
				t.printStackTrace();
			}

			public void onCompleted() {
				System.out.println("List finished");
				messages.setText("List finished");
			}
		};

		StreamObserver<PrinterRequest> requestObserver = uasyncStub.printList(responseObserver);
		try {
			requestObserver.onNext(PrinterRequest.newBuilder().setPList("1. NCI, Energy Rating: B, Location: D01X00Y").build());
			requestObserver.onNext(PrinterRequest.newBuilder().setPList("2. Test").build());
			requestObserver.onNext(PrinterRequest.newBuilder().setPList("3. ").build());
			requestObserver.onNext(PrinterRequest.newBuilder().setPList("4. ").build());
			requestObserver.onNext(PrinterRequest.newBuilder().setPList("5. ").build());

			Thread.sleep(500);
		} catch (RuntimeException e) {
			System.out.println("Printer failed: " + e.getMessage());
			requestObserver.onError(e);
			throw e;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		requestObserver.onCompleted();
		messages.setText("\nDetails List: " + listOfDetails.size());
		for (String buildings : listOfDetails) {
			messages.setText("Printing Details list: ");
			JOptionPane.showMessageDialog(null, buildings);
			System.out.println("Printing Details list: " + buildings);
		}
	}
}
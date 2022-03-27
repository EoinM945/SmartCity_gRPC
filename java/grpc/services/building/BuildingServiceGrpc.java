package grpc.services.building;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import grpc.services.location.LocationRequest;
import grpc.services.location.LocationResponse;

@javax.annotation.Generated(value = "by gRPC proto compiler (version 1.15.0)", comments = "Source: BuildingService.proto")
public final class BuildingServiceGrpc {

	private BuildingServiceGrpc() {
	}

	public static final String SERVICE_NAME = "Building.BuildingService";

	// Static method descriptors that directly reflects the proto.
	private static volatile io.grpc.MethodDescriptor<grpc.services.building.BuildingRequest, grpc.services.building.BuildingResponse> getSwitchDevicesMethod;

	@io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
			+ "switchDevices", requestType = grpc.services.building.BuildingRequest.class, responseType = grpc.services.building.BuildingResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
	public static io.grpc.MethodDescriptor<grpc.services.building.BuildingRequest, grpc.services.building.BuildingResponse> getSwitchBuildingMethod() {
		io.grpc.MethodDescriptor<grpc.services.building.BuildingRequest, grpc.services.building.BuildingResponse> getSwitchDevicesMethod;
		if ((getSwitchDevicesMethod = BuildingServiceGrpc.getSwitchDevicesMethod) == null) {
			synchronized (BuildingServiceGrpc.class) {
				if ((getSwitchDevicesMethod = BuildingServiceGrpc.getSwitchDevicesMethod) == null) {
					BuildingServiceGrpc.getSwitchDevicesMethod = getSwitchDevicesMethod = io.grpc.MethodDescriptor.<grpc.services.building.BuildingRequest, grpc.services.building.BuildingResponse>newBuilder()
							.setType(io.grpc.MethodDescriptor.MethodType.UNARY)
							.setFullMethodName(generateFullMethodName("Building.BuildingService", "switchDevices"))
							.setSampledToLocalTracing(true)
							.setRequestMarshaller(io.grpc.protobuf.ProtoUtils
									.marshaller(grpc.services.building.BuildingRequest.getDefaultInstance()))
							.setResponseMarshaller(io.grpc.protobuf.ProtoUtils
									.marshaller(grpc.services.building.BuildingResponse.getDefaultInstance()))
							.setSchemaDescriptor(new BuildingServiceMethodDescriptorSupplier("switchDevices")).build();
				}
			}
		}
		return getSwitchDevicesMethod;
	}

	private static volatile io.grpc.MethodDescriptor<grpc.services.building.PrinterRequest, grpc.services.building.PrinterResponse> getPrintListMethod;

	@io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
			+ "printList", requestType = grpc.services.building.PrinterRequest.class, responseType = grpc.services.building.PrinterResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
	public static io.grpc.MethodDescriptor<grpc.services.building.PrinterRequest, grpc.services.building.PrinterResponse> getPrintListMethod() {
		io.grpc.MethodDescriptor<grpc.services.building.PrinterRequest, grpc.services.building.PrinterResponse> getPrintListMethod;
		if ((getPrintListMethod = BuildingServiceGrpc.getPrintListMethod) == null) {
			synchronized (BuildingServiceGrpc.class) {
				if ((getPrintListMethod = BuildingServiceGrpc.getPrintListMethod) == null) {
					BuildingServiceGrpc.getPrintListMethod = getPrintListMethod = io.grpc.MethodDescriptor.<grpc.services.building.PrinterRequest, grpc.services.building.PrinterResponse>newBuilder()
							.setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
							.setFullMethodName(generateFullMethodName("Building.BuildingService", "printList"))
							.setSampledToLocalTracing(true)
							.setRequestMarshaller(io.grpc.protobuf.ProtoUtils
									.marshaller(grpc.services.building.PrinterRequest.getDefaultInstance()))
							.setResponseMarshaller(io.grpc.protobuf.ProtoUtils
									.marshaller(grpc.services.building.PrinterResponse.getDefaultInstance()))
							.setSchemaDescriptor(new BuildingServiceMethodDescriptorSupplier("printList")).build();
				}
			}
		}
		return getPrintListMethod;
	}

	// Creates a new async stub that supports all call types for the service
	public static BuildingServiceStub newStub(io.grpc.Channel channel) {
		return new BuildingServiceStub(channel);
	}

	// Creates a new blocking-style stub that supports unary & streaming output calls on the service
	public static BuildingServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
		return new BuildingServiceBlockingStub(channel);
	}

	// Creates a new ListenableFuture-style stub that supports unary calls on the service
	public static BuildingServiceFutureStub newFutureStub(io.grpc.Channel channel) {
		return new BuildingServiceFutureStub(channel);
	}

	public static abstract class BuildingServiceImplBase implements io.grpc.BindableService {

		public void switchBuilding(grpc.services.building.BuildingRequest request,
				io.grpc.stub.StreamObserver<grpc.services.building.BuildingResponse> responseObserver) {
			asyncUnimplementedUnaryCall(getSwitchBuildingMethod(), responseObserver);
		}

		public io.grpc.stub.StreamObserver<grpc.services.building.PrinterRequest> printList(
				io.grpc.stub.StreamObserver<grpc.services.building.PrinterResponse> responseObserver) {
			return asyncUnimplementedStreamingCall(getPrintListMethod(), responseObserver);
		}

		public final io.grpc.ServerServiceDefinition bindService() {
			return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
					.addMethod(getSwitchBuildingMethod(), asyncUnaryCall(
							new MethodHandlers<grpc.services.building.BuildingRequest, grpc.services.building.BuildingResponse>(
									this, METHODID_SWITCH_DEVICES)))
					.addMethod(getPrintListMethod(), asyncBidiStreamingCall(
							new MethodHandlers<grpc.services.building.PrinterRequest, grpc.services.building.PrinterResponse>(
									this, METHODID_PRINT_LIST)))
					.build();
		}
	}

	public static final class BuildingServiceStub extends io.grpc.stub.AbstractStub<BuildingServiceStub> {
		private BuildingServiceStub(io.grpc.Channel channel) {
			super(channel);
		}

		private BuildingServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected BuildingServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new BuildingServiceStub(channel, callOptions);
		}

		public void switchLocation(grpc.services.building.BuildingRequest request,
				io.grpc.stub.StreamObserver<grpc.services.building.BuildingResponse> responseObserver) {
			asyncUnaryCall(getChannel().newCall(getSwitchBuildingMethod(), getCallOptions()), request, responseObserver);
		}

		public io.grpc.stub.StreamObserver<grpc.services.building.PrinterRequest> printList(
				io.grpc.stub.StreamObserver<grpc.services.building.PrinterResponse> responseObserver) {
			return asyncBidiStreamingCall(getChannel().newCall(getPrintListMethod(), getCallOptions()),
					responseObserver);
		}
	}

	public static final class BuildingServiceBlockingStub extends io.grpc.stub.AbstractStub<BuildingServiceBlockingStub> {
		private BuildingServiceBlockingStub(io.grpc.Channel channel) {
			super(channel);
		}

		private BuildingServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected BuildingServiceBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new BuildingServiceBlockingStub(channel, callOptions);
		}

		public grpc.services.building.BuildingResponse switchBuilding(grpc.services.building.BuildingRequest request) {
			return blockingUnaryCall(getChannel(), getSwitchBuildingMethod(), getCallOptions(), request);
		}

		public LocationResponse switchLocation(LocationRequest request) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	public static final class BuildingServiceFutureStub extends io.grpc.stub.AbstractStub<BuildingServiceFutureStub> {
		private BuildingServiceFutureStub(io.grpc.Channel channel) {
			super(channel);
		}

		private BuildingServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected BuildingServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new BuildingServiceFutureStub(channel, callOptions);
		}

		public com.google.common.util.concurrent.ListenableFuture<grpc.services.building.BuildingResponse> switchDevices(
				grpc.services.building.BuildingRequest request) {
			return futureUnaryCall(getChannel().newCall(getSwitchBuildingMethod(), getCallOptions()), request);
		}
	}

	private static final int METHODID_SWITCH_DEVICES = 0;
	private static final int METHODID_SWITCH_CAMERA_ON = 1;
	private static final int METHODID_PRINT_LIST = 2;

	private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
			io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
			io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
			io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
		private final BuildingServiceImplBase serviceImpl;
		private final int methodId;

		MethodHandlers(BuildingServiceImplBase serviceImpl, int methodId) {
			this.serviceImpl = serviceImpl;
			this.methodId = methodId;
		}

		@java.lang.SuppressWarnings("unchecked")
		public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
			switch (methodId) {
			case METHODID_SWITCH_DEVICES:
				serviceImpl.switchBuilding((grpc.services.building.BuildingRequest) request,
						(io.grpc.stub.StreamObserver<grpc.services.building.BuildingResponse>) responseObserver);
				break;
			default:
				throw new AssertionError();
			}
		}

		@java.lang.SuppressWarnings("unchecked")
		public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
			switch (methodId) {
			case METHODID_PRINT_LIST:
				return (io.grpc.stub.StreamObserver<Req>) serviceImpl.printList(
						(io.grpc.stub.StreamObserver<grpc.services.building.PrinterResponse>) responseObserver);
			default:
				throw new AssertionError();
			}
		}
	}

	private static abstract class BuildingServiceBaseDescriptorSupplier
			implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
		BuildingServiceBaseDescriptorSupplier() {
		}

		public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
			return grpc.services.building.BuildingServiceImpl.getDescriptor();
		}

		public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
			return getFileDescriptor().findServiceByName("BuildingService");
		}
	}

	private static final class BuildingServiceFileDescriptorSupplier extends BuildingServiceBaseDescriptorSupplier {
		BuildingServiceFileDescriptorSupplier() {
		}
	}

	private static final class BuildingServiceMethodDescriptorSupplier extends BuildingServiceBaseDescriptorSupplier
			implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
		private final String methodName;

		BuildingServiceMethodDescriptorSupplier(String methodName) {
			this.methodName = methodName;
		}

		public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
			return getServiceDescriptor().findMethodByName(methodName);
		}
	}

	private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

	public static io.grpc.ServiceDescriptor getServiceDescriptor() {
		io.grpc.ServiceDescriptor result = serviceDescriptor;
		if (result == null) {
			synchronized (BuildingServiceGrpc.class) {
				result = serviceDescriptor;
				if (result == null) {
					serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
							.setSchemaDescriptor(new BuildingServiceFileDescriptorSupplier())
							.addMethod(getSwitchBuildingMethod())
							.addMethod(getPrintListMethod()).build();
				}
			}
		}
		return result;
	}
}
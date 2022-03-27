package grpc.services.location;

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

import com.google.common.util.concurrent.ListenableFuture;

import io.grpc.ClientCall;
import io.grpc.MethodDescriptor;
import io.grpc.stub.StreamObserver;

@javax.annotation.Generated(value = "by gRPC proto compiler (version 1.15.0)", comments = "Source: locationService.proto")
public final class LocationServiceGrpc {

	private LocationServiceGrpc() {
	}

	public static final String SERVICE_NAME = "location.locationService";

	private static volatile io.grpc.MethodDescriptor<grpc.services.location.LocationRequest, grpc.services.location.LocationResponse> getlocationsOnOffMethod;

	@io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
			+ "locationsOnOff", requestType = grpc.services.location.LocationRequest.class, responseType = grpc.services.location.LocationResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
	public static io.grpc.MethodDescriptor<grpc.services.location.LocationRequest, grpc.services.location.LocationResponse> getlocationsOnOffMethod() {
		io.grpc.MethodDescriptor<grpc.services.location.LocationRequest, grpc.services.location.LocationResponse> getlocationsOnOffMethod;
		if ((getlocationsOnOffMethod = LocationServiceGrpc.getlocationsOnOffMethod) == null) {
			synchronized (LocationServiceGrpc.class) {
				if ((getlocationsOnOffMethod = LocationServiceGrpc.getlocationsOnOffMethod) == null) {
					LocationServiceGrpc.getlocationsOnOffMethod = getlocationsOnOffMethod = io.grpc.MethodDescriptor.<grpc.services.location.LocationRequest, grpc.services.location.LocationResponse>newBuilder()
							.setType(io.grpc.MethodDescriptor.MethodType.UNARY)
							.setFullMethodName(generateFullMethodName("location.locationService", "locationsOnOff"))
							.setSampledToLocalTracing(true)
							.setRequestMarshaller(io.grpc.protobuf.ProtoUtils
									.marshaller(grpc.services.location.LocationRequest.getDefaultInstance()))
							.setResponseMarshaller(io.grpc.protobuf.ProtoUtils
									.marshaller(grpc.services.location.LocationResponse.getDefaultInstance()))
							.setSchemaDescriptor(new locationServiceMethodDescriptorSupplier("locationsOnOff")).build();
				}
			}
		}
		return getlocationsOnOffMethod;
	}

	// Creates a new async stub that supports all call types for the service
	public static locationServiceStub newStub(io.grpc.Channel channel) {
		return new locationServiceStub(channel);
	}

	// Creates a new blocking-style stub that supports unary & streaming output calls on the service
	public static locationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
		return new locationServiceBlockingStub(channel);
	}

	// Creates a new ListenableFuture-style stub that supports unary calls on the service
	public static locationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
		return new locationServiceFutureStub(channel);
	}

	public static abstract class locationServiceImplBase implements io.grpc.BindableService {

		public void locationsOnOff(grpc.services.location.LocationRequest request,
				io.grpc.stub.StreamObserver<grpc.services.location.LocationResponse> responseObserver) {
			asyncUnimplementedUnaryCall(getlocationsOnOffMethod(), responseObserver);
		}
		
		public void switchLocation(grpc.services.location.LocationRequest request,
				io.grpc.stub.StreamObserver<grpc.services.location.LocationResponse> responseObserver) {
			asyncUnimplementedUnaryCall(getSwitchLocationMethod(), responseObserver);
		}

		protected abstract MethodDescriptor<?, ?> getSwitchLocationMethod();

		public final io.grpc.ServerServiceDefinition bindService() {
			return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(getlocationsOnOffMethod(), asyncUnaryCall(
							new MethodHandlers<grpc.services.location.LocationRequest, grpc.services.location.LocationResponse>(
									this, METHODID_locationS_ON_OFF)))
					.build();
		}
	}

	public static final class locationServiceStub extends io.grpc.stub.AbstractStub<locationServiceStub> {
		private locationServiceStub(io.grpc.Channel channel) {
			super(channel);
		}

		private locationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected locationServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new locationServiceStub(channel, callOptions);
		}
		
		public void locationsOnOff(grpc.services.location.LocationRequest request,
				io.grpc.stub.StreamObserver<grpc.services.location.LocationResponse> responseObserver) {
			asyncUnaryCall(getChannel().newCall(getlocationsOnOffMethod(), getCallOptions()), request, responseObserver);
		}
	}

	public static final class locationServiceBlockingStub extends io.grpc.stub.AbstractStub<locationServiceBlockingStub> {
		private locationServiceBlockingStub(io.grpc.Channel channel) {
			super(channel);
		}

		private locationServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected locationServiceBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new locationServiceBlockingStub(channel, callOptions);
		}

		public grpc.services.location.LocationResponse locationOnOff(grpc.services.location.LocationRequest request) {
			return blockingUnaryCall(getChannel(), getlocationsOnOffMethod(), getCallOptions(), request);
		}
	}

	public static final class locationServiceFutureStub extends io.grpc.stub.AbstractStub<locationServiceFutureStub> {
		private locationServiceFutureStub(io.grpc.Channel channel) {
			super(channel);
		}

		private locationServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected locationServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new locationServiceFutureStub(channel, callOptions);
		}

		public com.google.common.util.concurrent.ListenableFuture<grpc.services.location.LocationResponse> locationsOnOff(
				grpc.services.location.LocationRequest request) {
			return futureUnaryCall(getChannel().newCall(getlocationsOnOffMethod(), getCallOptions()), request);
		}
	}

	private static final int METHODID_location = 0;
	private static final int METHODID_locationS_ON_OFF = 1;
	private static final int METHODID_location_INTENSITY = 2;

	private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
			io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
			io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
			io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
		private final locationServiceImplBase serviceImpl;
		private final int methodId;

		MethodHandlers(locationServiceImplBase serviceImpl, int methodId) {
			this.serviceImpl = serviceImpl;
			this.methodId = methodId;
		}

		@java.lang.SuppressWarnings("unchecked")
		public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
			switch (methodId) {
			case METHODID_locationS_ON_OFF:
				serviceImpl.locationsOnOff((grpc.services.location.LocationRequest) request,
						(io.grpc.stub.StreamObserver<grpc.services.location.LocationResponse>) responseObserver);
				break;
			default:
				throw new AssertionError();
			}
		}

		public StreamObserver<Req> invoke(StreamObserver<Resp> responseObserver) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	private static abstract class locationServiceBaseDescriptorSupplier
			implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
		locationServiceBaseDescriptorSupplier() {
		}

		public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
			return grpc.services.location.LocationServiceImpl.getDescriptor();
		}

		public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
			return getFileDescriptor().findServiceByName("locationService");
		}
	}

	private static final class locationServiceFileDescriptorSupplier extends locationServiceBaseDescriptorSupplier {
		locationServiceFileDescriptorSupplier() {
		}
	}

	private static final class locationServiceMethodDescriptorSupplier extends locationServiceBaseDescriptorSupplier
			implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
		private final String methodName;

		locationServiceMethodDescriptorSupplier(String methodName) {
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
			synchronized (LocationServiceGrpc.class) {
				result = serviceDescriptor;
				if (result == null) {
					serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
							.setSchemaDescriptor(new locationServiceFileDescriptorSupplier())
							.addMethod(getlocationsOnOffMethod())
							.build();
				}
			}
		}
		return result;
	}
}
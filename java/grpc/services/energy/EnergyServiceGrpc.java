package grpc.services.energy;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

@javax.annotation.Generated(value = "by gRPC proto compiler (version 1.15.0)", comments = "Source: EnergyService.proto")
public final class EnergyServiceGrpc {

	private EnergyServiceGrpc() {
	}

	public static final String SERVICE_NAME = "Energy.EnergyService";

	// Static method descriptors which directly reflects the proto.
	private static volatile io.grpc.MethodDescriptor<grpc.services.energy.SwitchRequest, grpc.services.energy.SwitchResponse> getHvacOnOffMethod;

	@io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/'
			+ "HvacOnOff", requestType = grpc.services.energy.SwitchRequest.class, responseType = grpc.services.energy.SwitchResponse.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
	public static io.grpc.MethodDescriptor<grpc.services.energy.SwitchRequest, grpc.services.energy.SwitchResponse> getEnergyOnOffMethod() {
		io.grpc.MethodDescriptor<grpc.services.energy.SwitchRequest, grpc.services.energy.SwitchResponse> getHvacOnOffMethod;
		if ((getHvacOnOffMethod = EnergyServiceGrpc.getHvacOnOffMethod) == null) {
			synchronized (EnergyServiceGrpc.class) {
				if ((getHvacOnOffMethod = EnergyServiceGrpc.getHvacOnOffMethod) == null) {
					EnergyServiceGrpc.getHvacOnOffMethod = getHvacOnOffMethod = io.grpc.MethodDescriptor.<grpc.services.energy.SwitchRequest, grpc.services.energy.SwitchResponse>newBuilder()
							.setType(io.grpc.MethodDescriptor.MethodType.UNARY)
							.setFullMethodName(generateFullMethodName("Energy.EnergyService", "HvacOnOff"))
							.setSampledToLocalTracing(true)
							.setRequestMarshaller(io.grpc.protobuf.ProtoUtils
									.marshaller(grpc.services.energy.SwitchRequest.getDefaultInstance()))
							.setResponseMarshaller(io.grpc.protobuf.ProtoUtils
									.marshaller(grpc.services.energy.SwitchResponse.getDefaultInstance()))
							.setSchemaDescriptor(new EnergyServiceMethodDescriptorSupplier("HvacOnOff")).build();
				}
			}
		}
		return getHvacOnOffMethod;
	}

	// Creates a new async stub that supports all call types for the service
	public static EnergyServiceStub newStub(io.grpc.Channel channel) {
		return new EnergyServiceStub(channel);
	}


	// Creates a new blocking-style stub that supports unary & streaming output calls on the service
	public static EnergyServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
		return new EnergyServiceBlockingStub(channel);
	}

	// Creates a new ListenableFuture-style stub that supports unary calls on the service
	public static EnergyServiceFutureStub newFutureStub(io.grpc.Channel channel) {
		return new EnergyServiceFutureStub(channel);
	}

	public static abstract class EnergyServiceImplBase implements io.grpc.BindableService {

		public void hvacOnOff(grpc.services.energy.SwitchRequest request,
				io.grpc.stub.StreamObserver<grpc.services.energy.SwitchResponse> responseObserver) {
			asyncUnimplementedUnaryCall(getEnergyOnOffMethod(), responseObserver);
		}

		public final io.grpc.ServerServiceDefinition bindService() {
			return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
					.addMethod(getEnergyOnOffMethod(), asyncUnaryCall(
							new MethodHandlers<grpc.services.energy.SwitchRequest, grpc.services.energy.SwitchResponse>(
									this, METHODID_HVAC_ON_OFF)))
					.build();
		}
	}

	public static final class EnergyServiceStub extends io.grpc.stub.AbstractStub<EnergyServiceStub> {
		private EnergyServiceStub(io.grpc.Channel channel) {
			super(channel);
		}

		private EnergyServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected EnergyServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new EnergyServiceStub(channel, callOptions);
		}

		public void hvacOnOff(grpc.services.energy.SwitchRequest request,
				io.grpc.stub.StreamObserver<grpc.services.energy.SwitchResponse> responseObserver) {
			asyncUnaryCall(getChannel().newCall(getEnergyOnOffMethod(), getCallOptions()), request, responseObserver);
		}
	}

	public static final class EnergyServiceBlockingStub extends io.grpc.stub.AbstractStub<EnergyServiceBlockingStub> {
		private EnergyServiceBlockingStub(io.grpc.Channel channel) {
			super(channel);
		}

		private EnergyServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected EnergyServiceBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new EnergyServiceBlockingStub(channel, callOptions);
		}

		public grpc.services.energy.SwitchResponse energyOnOff(grpc.services.energy.SwitchRequest request) {
			return blockingUnaryCall(getChannel(), getEnergyOnOffMethod(), getCallOptions(), request);
		}
	}

	public static final class EnergyServiceFutureStub extends io.grpc.stub.AbstractStub<EnergyServiceFutureStub> {
		private EnergyServiceFutureStub(io.grpc.Channel channel) {
			super(channel);
		}

		private EnergyServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			super(channel, callOptions);
		}

		@java.lang.Override
		protected EnergyServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
			return new EnergyServiceFutureStub(channel, callOptions);
		}

		public com.google.common.util.concurrent.ListenableFuture<grpc.services.energy.SwitchResponse> hvacOnOff(
				grpc.services.energy.SwitchRequest request) {
			return futureUnaryCall(getChannel().newCall(getEnergyOnOffMethod(), getCallOptions()), request);
		}
	}

	private static final int METHODID_HVAC_ON_OFF = 0;
	private static final int METHODID_HVAC_TEMPERATURE = 1;
	private static final int METHODID_CHECK_CO = 2;

	private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
			io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
			io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
			io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
		private final EnergyServiceImplBase serviceImpl;
		private final int methodId;

		MethodHandlers(EnergyServiceImplBase serviceImpl, int methodId) {
			this.serviceImpl = serviceImpl;
			this.methodId = methodId;
		}

		@java.lang.SuppressWarnings("unchecked")
		public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
			switch (methodId) {
			case METHODID_HVAC_ON_OFF:
				serviceImpl.hvacOnOff((grpc.services.energy.SwitchRequest) request,
						(io.grpc.stub.StreamObserver<grpc.services.energy.SwitchResponse>) responseObserver);
				break;
			default:
				throw new AssertionError();
			}
		}

		@java.lang.SuppressWarnings("unchecked")
		public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
			switch (methodId) {
			default:
				throw new AssertionError();
			}
		}
	}

	private static abstract class EnergyServiceBaseDescriptorSupplier
			implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
		EnergyServiceBaseDescriptorSupplier() {
		}

		public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
			return grpc.services.energy.EnergyServiceImpl.getDescriptor();
		}

		public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
			return getFileDescriptor().findServiceByName("EnergyService");
		}
	}

	private static final class EnergyServiceFileDescriptorSupplier extends EnergyServiceBaseDescriptorSupplier {
		EnergyServiceFileDescriptorSupplier() {
		}
	}

	private static final class EnergyServiceMethodDescriptorSupplier extends EnergyServiceBaseDescriptorSupplier
			implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
		private final String methodName;

		EnergyServiceMethodDescriptorSupplier(String methodName) {
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
			synchronized (EnergyServiceGrpc.class) {
				result = serviceDescriptor;
				if (result == null) {
					serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
							.setSchemaDescriptor(new EnergyServiceFileDescriptorSupplier())
							.addMethod(getEnergyOnOffMethod()).build();
				}
			}
		}
		return result;
	}
}
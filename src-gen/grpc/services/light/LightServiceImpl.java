// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: locationService.proto

package grpc.services.location;

public final class locationServiceImpl {
  private locationServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_location_locationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_location_locationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_location_locationsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_location_locationsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_location_locationsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_location_locationsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_location_IntensityResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_location_IntensityResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_location_IntensityRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_location_IntensityRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_location_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_location_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022locationService.proto\022\005location\"F\n\020locationR" +
      "esponse\022\017\n\007locationId\030\001 \001(\t\022\016\n\006status\030\002 \001(\t" +
      "\022\021\n\tintensity\030\003 \001(\005\"\037\n\rlocationsRequest\022\016\n\006" +
      "switch\030\001 \001(\010\" \n\016locationsResponse\022\016\n\006switch" +
      "\030\001 \001(\010\"&\n\021IntensityResponse\022\021\n\tintensity" +
      "\030\001 \001(\005\"%\n\020IntensityRequest\022\021\n\tintensity\030" +
      "\001 \001(\005\"\007\n\005Empty2\312\001\n\014locationService\0223\n\010location" +
      "ing\022\014.location.Empty\032\027.location.locationRespon" +
      "se\"\000\022<\n\013locationsOnOff\022\024.location.locationsReques" +
      "t\032\025.location.locationsResponse\"\000\022G\n\016locationInten" +
      "sity\022\027.location.IntensityRequest\032\030.location.In" +
      "tensityResponse\"\000(\001B)\n\023grpc.services.lig" +
      "htB\020locationServiceImplP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_location_locationResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_location_locationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_location_locationResponse_descriptor,
        new java.lang.String[] { "locationId", "Status", "Intensity", });
    internal_static_location_locationsRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_location_locationsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_location_locationsRequest_descriptor,
        new java.lang.String[] { "Switch", });
    internal_static_location_locationsResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_location_locationsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_location_locationsResponse_descriptor,
        new java.lang.String[] { "Switch", });
    internal_static_location_IntensityResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_location_IntensityResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_location_IntensityResponse_descriptor,
        new java.lang.String[] { "Intensity", });
    internal_static_location_IntensityRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_location_IntensityRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_location_IntensityRequest_descriptor,
        new java.lang.String[] { "Intensity", });
    internal_static_location_Empty_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_location_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_location_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
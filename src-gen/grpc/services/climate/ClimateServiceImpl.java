// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: EnergyService.proto

package grpc.services.energy;

public final class EnergyServiceImpl {
  private EnergyServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Energy_SwitchRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Energy_SwitchRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Energy_SwitchResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Energy_SwitchResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Energy_HvacRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Energy_HvacRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Energy_HvacResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Energy_HvacResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Energy_CoLevelRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Energy_CoLevelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Energy_ExtractionResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Energy_ExtractionResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024EnergyService.proto\022\007Energy\"\036\n\rSwitc" +
      "hRequest\022\r\n\005power\030\001 \001(\010\"\037\n\016SwitchRespons" +
      "e\022\r\n\005power\030\001 \001(\010\"\033\n\013HvacRequest\022\014\n\004temp\030" +
      "\001 \001(\005\"\034\n\014HvacResponse\022\014\n\004temp\030\001 \001(\005\"\037\n\016C" +
      "oLevelRequest\022\r\n\005level\030\001 \001(\005\"#\n\022Extracti" +
      "onResponse\022\r\n\005level\030\001 \001(\0052\327\001\n\016EnergySer" +
      "vice\022>\n\tHvacOnOff\022\026.Energy.SwitchReques" +
      "t\032\027.Energy.SwitchResponse\"\000\022B\n\017HvacTemp" +
      "erature\022\024.Energy.HvacRequest\032\025.Energy." +
      "HvacResponse\"\0000\001\022A\n\007checkCO\022\027.Energy.Co" +
      "LevelRequest\032\033.Energy.ExtractionRespons" +
      "e\"\000B-\n\025grpc.services.energyB\022EnergySer" +
      "viceImplP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Energy_SwitchRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Energy_SwitchRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Energy_SwitchRequest_descriptor,
        new java.lang.String[] { "Power", });
    internal_static_Energy_SwitchResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Energy_SwitchResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Energy_SwitchResponse_descriptor,
        new java.lang.String[] { "Power", });
    internal_static_Energy_HvacRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Energy_HvacRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Energy_HvacRequest_descriptor,
        new java.lang.String[] { "Temp", });
    internal_static_Energy_HvacResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_Energy_HvacResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Energy_HvacResponse_descriptor,
        new java.lang.String[] { "Temp", });
    internal_static_Energy_CoLevelRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_Energy_CoLevelRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Energy_CoLevelRequest_descriptor,
        new java.lang.String[] { "Level", });
    internal_static_Energy_ExtractionResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_Energy_ExtractionResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Energy_ExtractionResponse_descriptor,
        new java.lang.String[] { "Level", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

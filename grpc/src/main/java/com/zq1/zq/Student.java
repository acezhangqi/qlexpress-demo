// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Student.proto

package com.zq1.zq;

public final class Student {
  private Student() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn.zq_zq_MyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn.zq_zq_MyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn.zq_zq_MyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn.zq_zq_MyResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn.zq_zq_StudentResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn.zq_zq_StudentResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn.zq_zq_StudentRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn.zq_zq_StudentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn.zq_zq_StudentResponseList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn.zq_zq_StudentResponseList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn.zq_zq_StreamResquest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn.zq_zq_StreamResquest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn.zq_zq_StreamResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn.zq_zq_StreamResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rStudent.proto\022\016cn.zq.zq\"\035\n\tMyReq" +
      "uest\022\020\n\010username\030\001 \001(\t\"\036\n\nMyResponse\022\020\n\010" +
      "realname\030\002 \001(\t\":\n\017StudentResponse\022\014\n\004nam" +
      "e\030\001 \001(\t\022\013\n\003age\030\002 \001(\005\022\014\n\004city\030\003 \001(\t\"\036\n\016St" +
      "udentRequest\022\014\n\004name\030\001 \001(\t\"O\n\023StudentRes" +
      "ponseList\0228\n\017studentResponse\030\002 \003(\0132\037.com" +
      ".gongdao.zq.StudentResponse\"&\n\016StreamRes" +
      "quest\022\024\n\014request_info\030\001 \001(\t\"\'\n\016StreamRes" +
      "ponse\022\025\n\rresponse_info\030\002 \001(\t2\351\002\n\016Student" +
      "Service\022P\n\025GetRealNameByUsername\022\031.com.g" +
      "ongdao.zq.MyRequest\032\032.cn.zq.zq.MyR" +
      "esponse\"\000\022W\n\020GetStudentsByAge\022\036.com.gong" +
      "dao.zq.StudentRequest\032\037.cn.zq.zq.S" +
      "tudentResponse\"\0000\001\022\\\n\021GetStudentsByList\022" +
      "\036.cn.zq.zq.StudentRequest\032#.com.go" +
      "ngdao.zq.StudentResponseList\"\000(\001\022N\n\006BiTa" +
      "lk\022\036.cn.zq.zq.StreamResquest\032\036.com" +
      ".gongdao.zq.StreamResponse\"\000(\0010\001B\033\n\016com." +
      "gongdao.zqB\007StudentP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_cn.zq_zq_MyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_cn.zq_zq_MyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn.zq_zq_MyRequest_descriptor,
        new String[] { "Username", });
    internal_static_cn.zq_zq_MyResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_cn.zq_zq_MyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn.zq_zq_MyResponse_descriptor,
        new String[] { "Realname", });
    internal_static_cn.zq_zq_StudentResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_cn.zq_zq_StudentResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn.zq_zq_StudentResponse_descriptor,
        new String[] { "Name", "Age", "City", });
    internal_static_cn.zq_zq_StudentRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_cn.zq_zq_StudentRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn.zq_zq_StudentRequest_descriptor,
        new String[] { "Name", });
    internal_static_cn.zq_zq_StudentResponseList_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_cn.zq_zq_StudentResponseList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn.zq_zq_StudentResponseList_descriptor,
        new String[] { "StudentResponse", });
    internal_static_cn.zq_zq_StreamResquest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_cn.zq_zq_StreamResquest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn.zq_zq_StreamResquest_descriptor,
        new String[] { "RequestInfo", });
    internal_static_cn.zq_zq_StreamResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_cn.zq_zq_StreamResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn.zq_zq_StreamResponse_descriptor,
        new String[] { "ResponseInfo", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

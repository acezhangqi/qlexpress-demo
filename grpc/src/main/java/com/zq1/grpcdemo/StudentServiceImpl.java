package com.zq1.grpcdemo;

import com.gongdao.zq.*;
import com.zq1.zq.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

/**
 * @author zhangqi
 * @date 2019/3/22 下午11:54
 */

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public StreamObserver<StreamResquest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamResquest>() {
            @Override
            public void onNext(StreamResquest streamResquest) {
                System.out.println(streamResquest.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        };
    }

    @Override
    public StreamObserver<StudentRequest> getStudentsByList(StreamObserver<StudentResponseList> responseObserver) {
      return  new StreamObserver<StudentRequest>() {

            @Override
            public void onNext(StudentRequest studentRequest) {
                System.out.println(studentRequest.getName());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
              StudentResponse studentResponse =  StudentResponse.newBuilder().setCity("北京").setName("张三").setAge(11).build();
              StudentResponse studentResponse1 = StudentResponse.newBuilder().setCity("上海").setName("李四").setAge(12).build();
              StudentResponseList studentResponseList = StudentResponseList.newBuilder().addStudentResponse(studentResponse).addStudentResponse(studentResponse1).build();
              responseObserver.onNext(studentResponseList);
              responseObserver.onCompleted();
            }
        };
    }

    @Override
            public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
                System.out.println("接收到流式消息");
                responseObserver.onNext(StudentResponse.newBuilder().setAge(1).setName("zhasan1").setCity("beijing1").build());
                responseObserver.onNext(StudentResponse.newBuilder().setAge(2).setName("zhasan2").setCity("beijing2").build());
                responseObserver.onNext(StudentResponse.newBuilder().setAge(3).setName("zhasan3").setCity("beijing3").build());
                responseObserver.onNext(StudentResponse.newBuilder().setAge(4).setName("zhasan4").setCity("beijing4").build());
                responseObserver.onCompleted();
            }



    @Override
    //通过第二个参数返回结果
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到客户端信息");
        request.getUsername();
        responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
        responseObserver.onCompleted();
    }
}
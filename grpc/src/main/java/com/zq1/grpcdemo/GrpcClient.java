package com.zq1.grpcdemo;

import com.gongdao.zq.*;
import com.zq1.zq.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDate;
import java.util.Iterator;

/**
 * @author zhangqi
 * @date 2019/3/23 上午9:13
 */

public class GrpcClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",8989).usePlaintext(true).build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        MyResponse myResponse = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("zhangsan").build());
        Iterator<StudentResponse> iterator = blockingStub.getStudentsByAge(StudentRequest.newBuilder().setName("123").build());
        while (iterator.hasNext()){
           StudentResponse studentResponse =  iterator.next();
            System.out.println(studentResponse.getAge());
            System.out.println(studentResponse.getCity());
            System.out.println(studentResponse.getName());
        }
        System.out.println(myResponse.getRealname());
        StudentServiceGrpc.StudentServiceStub studentServiceStub = StudentServiceGrpc.newStub(managedChannel);
        StreamObserver<StudentResponseList> studentResponseListStreamObserver = new StreamObserver
            <StudentResponseList>() {
            @Override
            public void onNext(StudentResponseList studentResponseList) {
                studentResponseList.getStudentResponseList().forEach(s->{
                    System.out.println(s.getName());
                    System.out.println(s.getAge());
                    System.out.println(s.getCity());
                });
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("completed");
            }
        };

        StreamObserver<StudentRequest> studentRequestStreamObserver =   studentServiceStub.getStudentsByList(studentResponseListStreamObserver);
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setName("zhansan").build());
        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setName("张三").build());
        studentRequestStreamObserver.onCompleted();

        StreamObserver<StreamResquest> resquestStreamObserver =studentServiceStub.biTalk(
            new StreamObserver<StreamResponse>() {
                @Override
                public void onNext(StreamResponse streamResponse) {
                    System.out.println(streamResponse.getResponseInfo());
                }

                @Override
                public void onError(Throwable throwable) {

                }

                @Override
                public void onCompleted() {

                }
            });
        for (int i =0;i<10;i++) {
            resquestStreamObserver.onNext(
                StreamResquest.newBuilder().setRequestInfo(LocalDate.now().toString()).build());
        }


        Thread.sleep(50000);
    }
}

package com.zq1.grpcdemo;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author zhangqi
 * @date 2019/3/23 上午9:05
 */

public class GrpcServer {

    private Server server;

    private void start() throws IOException {
        this.server = ServerBuilder.forPort(8989).addService(new StudentServiceImpl()).build().start();
        System.out.println("server start");
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("jvm关闭");
            GrpcServer.this.stop();
        }));

    }

    private void stop(){
        if (null != this.server){
            this.server.shutdown();
        }
    }

    private void awaitTermination() throws InterruptedException {
        if (null != this.server){
            this.server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer server = new GrpcServer();
        server.start();
        server.awaitTermination();
    }
}

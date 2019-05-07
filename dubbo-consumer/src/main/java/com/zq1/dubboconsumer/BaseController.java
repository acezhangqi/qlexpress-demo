package com.zq1.dubboconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spi.Hello;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangqi
 * @date 2019/2/26 下午8:30
 */
@RestController
public class BaseController {


    public   Map<String,Integer> map = new HashMap<>();
    {
        map.put("1",1);
    }


    @Autowired
    private Hello hello;

    @RequestMapping("/get")
    public String test1() throws ExecutionException, InterruptedException {
       return hello.sayHello("s");
    }

    @RequestMapping("/testArthas")
    public String test2() throws InterruptedException {
       for (int i =0;i<10;i++){
           new Thread(new MyRunable(map)).start();
       }
       return map.get("1")+"";
    }


}

class  MyRunable implements Runnable{
    private Map<String,Integer> map ;

    public MyRunable(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put("1",map.get("1")+1);
        }
    }
}
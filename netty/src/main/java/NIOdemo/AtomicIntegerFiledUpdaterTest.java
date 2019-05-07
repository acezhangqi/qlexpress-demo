package NIOdemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author zhangqi
 * @date 2019/4/28 下午8:11
 */

public class AtomicIntegerFiledUpdaterTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        AtomicIntegerFieldUpdater<Person> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Person.class,"age");
        Person person = new Person();
        for (int i=0;i<1000;i++){
            new Thread(()->{
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicIntegerFieldUpdater.incrementAndGet(person);
               countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(person.age);
    }

}
class Person{
    volatile  int age = 1;
}
package thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.genrated.PersonService;

/**
 * @author zhangqi
 * @date 2019/3/20 下午9:13
 */

public class ThriftClient {
    public static void main(String[] args) throws TException {
        TTransport transport = new TFastFramedTransport(new TSocket("localhost",8899),600);
        TProtocol protocol = new TCompactProtocol(transport);
        thrift.genrated.PersonService.Client client = new PersonService.Client(protocol);
        try {
            transport.open();
            thrift.genrated.Person1 person1 = client.getPersonByUsername("张三");
            System.out.println(person1.getAge());
            System.out.println(person1.getUsername());
            System.out.println(person1.isMarried());
        }catch (Exception e){

        }
    }
}

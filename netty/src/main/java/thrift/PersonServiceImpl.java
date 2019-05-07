package thrift;

import org.apache.thrift.TException;
import thrift.genrated.Person1;
import thrift.genrated.PersonService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangqi
 * @date 2019/3/20 下午8:55
 */

public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public thrift.genrated.Person1 getPersonByUsername(String username) throws thrift.genrated.DataException1, TException {
        Person1 person1 =  new Person1();
        person1.setAge(1);
        person1.setMarried(true);
        person1.setUsername("123");
        return person1;
    }

    @Override
    public void savePerson(thrift.genrated.Person1 person) throws thrift.genrated.DataException1, TException {
        System.out.println("保存");
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("0");
        BigDecimal b = new BigDecimal("0");
        System.out.println(b.compareTo(bigDecimal));
        System.out.println(bigDecimal.equals(b));

    }
}

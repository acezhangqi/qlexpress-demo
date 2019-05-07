package rocketMQFirst;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangqi
 * @date 2019/3/19 下午3:56
 */

public class SyncProducer {


        private final static Comparator<Object> CHINA_COMPARE = Collator.getInstance(java.util.Locale.CHINA);

        public static void main(String[] args) {
            String a="a";
            String b="b";
            List<String> lists= new ArrayList<String>();
            lists.add(a);
            lists.add(b);
            Collections.sort(lists,(o1,o2)->
                o1.compareTo(o2)
            );
            System.out.println(lists);
        }
    }


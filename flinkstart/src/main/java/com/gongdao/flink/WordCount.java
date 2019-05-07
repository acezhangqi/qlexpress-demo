package com.gongdao.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangqi
 * @date 2019/3/13 下午12:55
 */

public class WordCount {

    public static void main(String[] args) throws Exception {
        List<String> strings = new ArrayList<>();
        strings.add("2019年互预民字第1547178260429号");
        Collections.sort(strings,(o1,o2)->{
            return o1.compareTo(o2);
        });
        System.out.println(strings);

    }
}




package com.gongdao.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;
import org.junit.Test;

import java.util.List;

/**
 * @author zhangqi
 * @date 2019/3/13 下午7:36
 */

public class Map$flatMap {
    @Test
    public void maptest() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        DataStream<Integer>  dataStream = env.fromElements(1,2,3,4);
        dataStream = dataStream.map(value->value*2);
        dataStream.print();
        env.execute("Window WordCount");
    }


    @Test
    public void coflatmap() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
        DataStream<String>  dataStream = env.fromElements("zhang san","li si","wang wu");
        dataStream = dataStream.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String value, Collector<String> out) throws Exception {
                for(String word: value.split(" ")){
                    out.collect(word);
                }
            }
        });
        dataStream.print();
        env.execute("Window WordCount");
    }

    //@Test
    //public void maptest2() throws Exception {
    //    StreamExecutionEnvironment env = StreamExecutionEnvironment.createLocalEnvironment();
    //    DataStream<String> dataStream = env.fromElements("zhang san", "li si", "wang wu");
    //    DataStream<List<String>> singleOutputStreamOperator = dataStream.map(new MapFunction<String, String>() {
    //        @Override
    //        public String map(String s){
    //            for (String ss : s.split(" ")){
    //                //ss;
    //            }、
    //            return null;
    //        }
    //    });
    //    dataStream.print();
    //    env.execute("Window WordCount");
    //}










}

package com.tjpu.Flink_Demo.Streaming.streamAPI;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;

/**
 * collection 集合作为数据源env.fromCollection(data);
 */
public class StreamFromCollection {


    public static void main(String[] args) throws Exception {
        //获取Flink运行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //自定义数据源
        ArrayList<Integer> data = new ArrayList<Integer>();
        data.add(10);
        data.add(15);
        data.add(20);

        //指定数据源
        DataStreamSource collectionData = env.fromCollection(data);

        //通过Map对数据进行处理
        MapFunction<Integer,Integer> mymap = new myMap();
        collectionData.map(mymap).print().setParallelism(1);
        //直接打印
        env.execute();
    }
}

class myMap implements MapFunction<Integer,Integer>{

    @Override
    public Integer map(Integer value) throws Exception {
        return value+1;
    }
}
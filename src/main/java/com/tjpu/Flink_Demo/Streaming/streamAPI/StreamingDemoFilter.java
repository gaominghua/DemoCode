package com.tjpu.Flink_Demo.Streaming.streamAPI;

import com.tjpu.Flink_Demo.Streaming.DataSourceByCustorm.MyNoParalleSource;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * Filter演示
 *
 */
public class StreamingDemoFilter {

    public static void main(String[] args) throws Exception {
        //获取Flink的运行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //获取数据源
        DataStreamSource<Long> text = env.addSource(new MyNoParalleSource()).setParallelism(1);//注意：针对此source，并行度只能设置为1
        //1.执行filter过滤，满足条件的数据会被留下
        //2.每4秒钟处理一次数据
        //3.打印结果
        DataStreamSink<Long> num = text
                .map(new myMap4())
                .filter(new myMap4_fliter())
                .map(new myMap4_result())
                .timeWindowAll(Time.seconds(4))
                .sum(0)
                .print()
                .setParallelism(1);;

        String jobName = StreamingDemoFilter.class.getSimpleName();
        env.execute(jobName);
    }
}
class myMap4 implements MapFunction<Long,Long>{
    @Override
    public Long map(Long value) throws Exception {
        System.out.println("原始接收到数据：" + value);
        return value;
    }
}
class myMap4_fliter implements FilterFunction<Long>{
    //把所有的奇数过滤掉
    @Override
    public boolean filter(Long value) throws Exception {
        return value % 2 == 0;
    }
}
class myMap4_result implements MapFunction<Long,Long>{
    @Override
    public Long map(Long value) throws Exception {
        System.out.println("过滤之后的数据：" + value);
        return value;
    }
}
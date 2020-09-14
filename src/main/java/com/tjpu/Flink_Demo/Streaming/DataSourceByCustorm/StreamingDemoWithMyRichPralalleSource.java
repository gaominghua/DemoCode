package com.tjpu.Flink_Demo.Streaming.DataSourceByCustorm;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * 使用多并行度的source
 *
 * Created by xuwei.tech on 2018/10/23.
 */
public class StreamingDemoWithMyRichPralalleSource {

    public static void main(String[] args) throws Exception {
        //获取Flink的运行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //获取数据源
        DataStreamSource<Long> text = env.addSource(new MyRichParalleSource()).setParallelism(1);

        //每2秒钟处理一次数据  //打印结果
        DataStreamSink<Long> num = text
                .map(new myMap1())
                .timeWindowAll(Time.seconds(2))
                .sum(0)
                .print().setParallelism(1);;

        String jobName = StreamingDemoWithMyRichPralalleSource.class.getSimpleName();
        env.execute(jobName);
    }
}
class myMap1 implements MapFunction<Long,Long>{
    @Override
    public Long map(Long value) throws Exception {
        System.out.println("接收到数据：" + value);
        return value;
    }
}

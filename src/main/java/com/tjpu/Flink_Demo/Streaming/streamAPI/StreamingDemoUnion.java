package com.tjpu.Flink_Demo.Streaming.streamAPI;

import com.tjpu.Flink_Demo.Streaming.DataSourceByCustorm.MyNoParalleSource;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

/**
 * union
 * 合并多个流，新的流会包含所有流中的数据，但是union是一个限制，就是所有合并的流类型必须是一致的
 */
public class StreamingDemoUnion {

    public static void main(String[] args) throws Exception {
        //获取Flink的运行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        //获取数据源
        DataStreamSource<Long> text1 = env.addSource(new MyNoParalleSource()).setParallelism(1);//注意：针对此source，并行度只能设置为1

        DataStreamSource<Long> text2 = env.addSource(new MyNoParalleSource()).setParallelism(1);

        //1. 把text1和text2组装到一起
        //2. 每2秒钟处理一次数据
        //3. 打印结果
        DataStream<Long> text = text1.union(text2);

        DataStreamSink<Long> num = text
                .map(new myMap5())
                .timeWindowAll(Time.seconds(2))
                .sum(0)
                .print()
                .setParallelism(1);;

        String jobName = StreamingDemoUnion.class.getSimpleName();
        env.execute(jobName);
    }
}
class myMap5 implements MapFunction<Long,Long>{
    @Override
    public Long map(Long value) throws Exception {
        System.out.println("原始接收到数据：" + value);
        return value;
    }
}
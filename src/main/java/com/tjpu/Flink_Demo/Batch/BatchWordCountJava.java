package com.tjpu.Flink_Demo.Batch;

import com.tjpu.Flink_Demo.Streaming.streamAPI.StreamingDemoFilter;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSink;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.core.fs.FileSystem;
import org.apache.flink.util.Collector;

/**
 * Created by xuwei.tech on 2018/10/8.
 */
public class BatchWordCountJava {

    public static void main(String[] args) throws Exception{
        String inputPath = "H:\\flink_data\\input";
        String outPath = "H:\\flink_data\\output";

        //获取运行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        //获取文件中的内容
        DataSource<String> text = env.readTextFile(inputPath);

        DataSink<Tuple2<String, Integer>> counts = text
                .flatMap(new Tokenizer())
                .groupBy(0) //按照第一个字段分组
                .sum(1) //按照第二个字段统计
                .writeAsCsv(outPath,"\n"," ", FileSystem.WriteMode.OVERWRITE)
                .setParallelism(1);

        String jobName = BatchWordCountJava.class.getSimpleName();
        env.execute(jobName);

    }

}


 class Tokenizer implements FlatMapFunction<String,Tuple2<String,Integer>>{
    public void flatMap(String value, Collector<Tuple2<String, Integer>> out) throws Exception {
        String[] tokens = value.toLowerCase().split("\\W+");//  如果是\\s则是空白字符 \\W表示非任意字符就是空格
        for (String token: tokens) {
            if(token.length()>0){
                out.collect(new Tuple2<String, Integer>(token,1));
            }
        }
    }
}
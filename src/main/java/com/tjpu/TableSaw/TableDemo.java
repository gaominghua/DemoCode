package com.tjpu.TableSaw;

import tech.tablesaw.api.*;
import tech.tablesaw.io.csv.CsvReadOptions;

import java.net.URL;
import java.time.LocalDate;

import static tech.tablesaw.api.ColumnType.*;

public class TableDemo {
    public static void main(String[] args) {

        //#######################################创建表##########################################################
        String[] students = {"小明", "李雷", "小二"};
        double[] scores = {90.1, 84.3, 99.7};
        Table table = Table.create("学生分数统计表").addColumns(
                StringColumn.create("姓名", students),
                DoubleColumn.create("分数", scores));
        System.out.println(table.print());

        //##########################################添加列及其数据#######################################################

        double[] values = { 7, 9, 11.11};
        DoubleColumn doubleColumn = DoubleColumn.create("my numbers", values);
        table.addColumns(doubleColumn);
        System.out.println(table.print());


        LocalDate[] valueDate={LocalDate.now().plusMonths(1),LocalDate.now().plusMonths(2),LocalDate.now().plusMonths(3)};
        DateColumn dateColumn =DateColumn.create("时间",valueDate);
        table.addColumns(dateColumn);
        System.out.println(table.print());
        //##########################################添加、修改、列数据#######################################################
        dateColumn.set(0,LocalDate.now());
        doubleColumn.set(0,7.77);
        doubleColumn.set(1,9.99);

        System.out.println(table.print());

        //##########################################URL获取数据创建表#######################################################
        try {
            ColumnType[] types = {LOCAL_DATE, SHORT, STRING};
            String location =
                    "https://raw.githubusercontent.com/jtablesaw/tablesaw/master/data/bush.csv";

            Table table2 = Table.read()
                    .usingOptions(CsvReadOptions
                            .builder(new URL(location))
                            .tableName("bush")
                            .columnTypes(types));
            System.out.println(table2.print());
        }catch (Exception e){
            System.out.println("异常------------------"+e.getMessage());
        }
    }
}

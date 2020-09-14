package com.Test;

import java.util.Scanner;

class OJ_Demo {

    public static void main(String[] args) {
        //创建一个扫描对象，用于接收键盘数据
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            //注意while处理多个case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }

        /**
         * 扫描仪也可以使用除空格之外的分隔符。 此示例从字符串读取几个项目：
         */
//        String input = "1 fish 2 fish red fish blue fish";
//        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
//        System.out.println(s.nextInt());
//        System.out.println(s.nextInt());
//        System.out.println(s.next());
//        System.out.println(s.next());
//        s.close();
        /**
         * next()
         * 一定要读取到有效字符后才可以结束输入。
         * 对输入有效字符之前遇到的空白，next()方法会自动将其去掉。
         * 只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
         * next()不能得到带有空格的字符串。
         */
        System.out.println("使用next方式接受：");
        //判断用户有没有输入字符串
        while (in.hasNext()){
            //使用next方式接受
            String str = in.next();//程序会等待用户输入完毕
            System.out.println("输出的内容为："+str);

        }

        /**
         *nextLine()
         * 以Enter为结束符，也就是说nextLine()方法放回的是输入回车之前的所有字符。
         * 可以获得空白
         */
//        System.out.println("使用nextLine方式接受：");
//        while (in.hasNextLine()){ //判断是否还有输入
//            String s = in.nextLine(); //等待用户去输入
//            System.out.println("输出的内容为："+s);
//        }
//        in.close();//节省内存资源。用完关掉。
    }
}

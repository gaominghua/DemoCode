package com.tjpu.Algorithm_Code.algorithm.DP;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Arrays;
import java.util.Scanner;
class MaxSeq{

    int result;
    public int getMax(int n,int m){
        int[][] memory = new int[n][2];
        result=0;
        Scanner in = new Scanner(System.in);
//        String  line =in.nextLine();
//        String[] str=line.split(" ");
//        for (int i=0;i<memory.length;i++){
//            memory[i]=Integer.parseInt(str[i]);
//        }


        for (int i = 0; i < memory.length; i++) {
            memory[i][0] = in.nextInt();
            memory[i][1] = in.nextInt();
        }





        System.out.println(Arrays.toString(memory));
        //result=compare(memory,m);
        return result;
    }
    private int compare(int[] memory,int m){
        int max=0;
        for(int i=0;i<memory.length;i++){
            int temp=memory[i];
            for(int j=0;j<memory.length;j++){
                temp+=memory[j];
                if(temp%m>max){
                    max=temp;
                    return max;
                }
            }
        }
        return -1;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            MaxSeq maxSeq =new MaxSeq();
            System.out.println("输入的n:"+n+"输入的m:"+m);
            System.out.print(maxSeq.getMax(n,m));
        }

    }
}
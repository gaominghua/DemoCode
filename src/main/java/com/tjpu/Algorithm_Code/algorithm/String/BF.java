package com.tjpu.Algorithm_Code.algorithm.String;

/**
 * BF 算法，即暴风(Brute Force)算法，也叫朴素匹配算法，是普通的模式匹配算法，
 * 这种算法的字符串匹配方式很“暴力”，当然也就会比较简单、好懂，但相应的性能
 * 也不高，所以 BF 算法也是一种蛮力算法。
 */
public class BF {

    /**
     * 使用bf算法在主串t中匹配子串p
     * @param t 主串
     * @param p 子串
     * @return
     */
    public  int bf(String t,String p){
        //数据合法性校验
        if (t.length()==0||t==null||p.length()==0||p==null||t.length()<p.length()){
            return -1;
        }

        //将字符串转成数组方便操作
        char[] tArray=t.toCharArray();
        char[] pArray=p.toCharArray();

        //匹配过程
        return match(tArray,pArray);

    }
    private int match(char[] t,char[] p){
        //定义主串和子串下标
        int i=0; //主下角标
        int j=0; //子下角标
        int posi=0; //找到的位置
        while (i<t.length&&j<p.length){
            if (t[i]==p[j]){
                i++;
                j++;
            }else {
                i++;
            }
        }
        if (i<=t.length){
            System.out.println("i:"+i+" P:"+p.length);
            posi=i-p.length;
        }else {
            posi=-1;
        }
        return posi;
    }

    public static void main(String[] args) {
        BF bf =new BF();
        int res = bf.bf("cdabcd","cd");
        System.out.println(res);
    }
}

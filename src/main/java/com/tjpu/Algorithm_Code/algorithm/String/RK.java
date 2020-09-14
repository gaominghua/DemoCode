package com.tjpu.Algorithm_Code.algorithm.String;

public class RK {

    public int rk(String t,String p){
        if (t==null||t.length()==0||p.length()==0||p==null||p.length()>t.length()) {
            return -1;
        }
        int hash =hash(p,26,31,0,p.length());
        for(int i=0;i<t.length();i++){
            if (hash(t,26,31,i,p.length())==hash&&match(t,p,i)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 基于哈希
     * @param string
     * @param R 进制数
     * @param K 将字符串影射k的范围
     * @param start 从string p开始的位置
     * @param len  子串的长度
     * @return
     */
    private int hash(String string ,int R,int K,int start,int len){
        int hash=0;
        for (int i=start;i<start+len;i++){
            hash=(R*hash+string.charAt(i)%K);
        }
        return hash%K;
    }

    /**
     * 匹配的方法
     * @param t 主串
     * @param p 子串
     * @param i 从主串下标为i的地方开始比较
     * @return
     */
    private boolean match(String t,String p,int i){
        for (int j=0;j<p.length();j++){
            if (p.charAt(j)!=t.charAt(j+i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String test="abcef";
        String sub ="e";
        RK rk =new RK();
        int res = rk.rk(test,sub);
        System.out.println(res);
    }
}

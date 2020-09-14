package com.tjpu.Algorithm_Code.LeetCode;

public class AddBinary_67 {
    public String addBinary(String a, String b) {
        int r1=Integer.parseInt(a, 2);
        int r2 = Integer.parseInt(b, 2);
        String res =Integer.toBinaryString(r1+r2);

        return res;
    }

    public static void main(String[] args) {
        AddBinary_67 demo =new AddBinary_67();
        System.out.println(demo.addBinary("11", "1"));
    }
}

package com.tjpu.java.shallowCopy;

public class ShallowCopy {
    public static void main(String[] args) {
        Subject subject = new Subject("yuwen");

        Student studentA = new Student();
        studentA.setSubject(subject);
        studentA.setName("Lynn");
        studentA.setAge(20);

        Student studentB = (Student) studentA.clone();
        studentB.setName("Lily");
        studentB.setAge(18);
        Subject subjectB = studentB.getSubject();
        subjectB.setName("lishi");//原本subject为语文被修改成了历史

        System.out.println("studentA:" + studentA.toString());
        System.out.println("studentB:" + studentB.toString());
    }
}

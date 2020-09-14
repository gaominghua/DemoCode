package com.tjpu.thread_demo.CAS;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

class User{
    String userName;
    int age;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}

public class ABA_AtomicReference {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference =new AtomicReference<>();
        User z3=new User("Z3",22);
        User Li4=new User("Li4",25);
        atomicReference.set(z3);

        //第一次是期望得值z3，所以返回true
        System.out.println(atomicReference.compareAndSet(z3, Li4)+" "+atomicReference.get().toString());
        //由于第一次修改成li4所以这次期望得值不相同返回false
        System.out.println(atomicReference.compareAndSet(z3, Li4)+" "+atomicReference.get().toString());

    }
}

package com.tjpu.Reflect.BasicDemo;
//Class类创建的三种方式
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person =new Person();
        Student student =new Student();
        System.out.println(person.hashCode());
        //方式一通过对象获得
        Class c1 =person.getClass();
        System.out.println(c1.hashCode());

        //方式二通过Class.froName（）
        Class c2 =Class.forName("com.tjpu.Reflect.BasicDemo.Person");
        System.out.println(c2.hashCode());

        //方式三
        Class c3 =Person.class;
        System.out.println(c3.hashCode());

        //获得父类类型
        Class classParent =student.getClass().getSuperclass();
        System.out.println(classParent);


    }
}


class Person{

}
class Teacher extends Person{

}
class  Student extends Person{

}



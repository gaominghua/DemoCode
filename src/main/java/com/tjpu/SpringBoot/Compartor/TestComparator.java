package com.tjpu.SpringBoot.Compartor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {
    public static void main(String[] args) {
        List<User> list =new ArrayList<>();

        //模拟数据
        User user1 =new User();
        user1.setId("a");
        user1.setName("我是A");
        user1.setAge(50);
        User user2 =new User();
        user2.setId("c");
        user2.setName("我是B");
        user2.setAge(30);
        User user3 =new User();
        user3.setId("b");
        user3.setName("我是C");
        user3.setAge(20);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        //查看未排序结果
        for (User user: list ){
            System.out.println("未排序的结果："+user.getId()+" "+user.getName()+" "+user.getAge());
        }
        System.out.println("=========================================================================");

        System.out.println("=====================================按照年龄升序排序：o1-o2====================================");
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        for (User user: list ){
            System.out.println("排序的结果："+user.getId()+" "+user.getName()+" "+user.getAge());
        }
        System.out.println("=====================================按照年龄降序排序：o2-o1====================================");
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        for (User user: list ){
            System.out.println("排序的结果："+user.getId()+" "+user.getName()+" "+user.getAge());
        }

        System.out.println("=====================================按照id升序排序：o1 compareTo(o2)===================================");
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        for (User user: list ){
            System.out.println("排序的结果："+user.getId()+" "+user.getName()+" "+user.getAge());
        }
        System.out.println("=====================================按照id降序排序：o2 compareTo(o1)====================================");
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });
        for (User user: list ){
            System.out.println("排序的结果："+user.getId()+" "+user.getName()+" "+user.getAge());
        }
    }
}

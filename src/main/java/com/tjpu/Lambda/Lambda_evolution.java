package com.tjpu.Lambda;

/***
 * 以下示例演示了lambda演进的过程，
 * 1.函数式接口
 * 2实现类
 * 3.静态内部类
 * 4.局部内部类
 * 5.匿名内部类，没有类的名称，必须借助接口或者父类
 */
public class Lambda_evolution {
    //3.静态内部类
    static class Like2 implements  ILike{
        public void lambda(){
            System.out.println("I like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();

        //1,2函数式接口，实现类
        like.lambda();

        //3.静态内部类
        like = new Like2();
        like.lambda();


        //4.局部内部类
        class Like3 implements  ILike{
            public void lambda(){
                System.out.println("I like lambda3");
            }
        }

        //4.局部内部类
        like = new Like3();
        like.lambda();

        //5.匿名内部类，没有类的名称，必须借助接口或者父类
        like= new Like(){
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        like.lambda();

        //6.用lambda简化
        like=()->{
            System.out.println("I like lambda5");
        };
        like.lambda();



    }
}


//1.函数式接口
interface ILike{
    void lambda();
}
//2.实现类
class Like implements  ILike{
    public void lambda(){
        System.out.println("I like lambda");
    }
}
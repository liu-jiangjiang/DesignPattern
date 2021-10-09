package com.java.designPattern.liskov.liskovImporve;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/08/23:27
 * @Description: 里氏替换原则
 *          * 我们发现原来运行正常的相减功能发生了错误。原因就是类B无意中重写了父类的方法，造成原有功能出现错误。
 *          * 在实际编程中，我们常常会通过重写父类的方法完成新的功能，这样写起来虽然简单，但整个继承体系的复用性
 *          * 会比较差。特别是运行多态比较频繁的时候
 *          *
 *          * 通用的做法是：原来的父类和子类都继承一个更通俗的基类，原有的继承关系去掉，采用依赖，聚合，组合等关系代替.
 *          *
 *          * 改进代码
 */
public class Liskov {
    public static void main(String[] args) {
        A a=new A();
        System.out.println("11-3="+a.func1(11,3));
        System.out.println("1-8="+a.func1(1,8));

        System.out.println("-----------------------");
        B b=new B();
        //这里本意是求出11-3
        System.out.println("11-3="+b.func3(11,3));
        //1-8
        System.out.println("1-8="+b.func3(1,8));
        System.out.println("11+3+9="+b.func2(11,3));
        //11+3
        System.out.println("11+3=" + b.func1(11,3));
    }
}

class Base{

}
class A extends Base{
    //返回两个数的差
    public int func1(int num1,int num2){
        return num1 - num2;
    }
}

//B 类继承A类
//增加了一个新功能：完成两个数相加,然后和9求和
class B extends Base {

    private A a = new A();
    public int func1(int a, int b){
        return a + b;
    }

    public int func2(int a, int b){
        return func1(a,b) + 9;
    }

    public int func3(int a, int b){
        return this.a.func1(a, b);
    }

}
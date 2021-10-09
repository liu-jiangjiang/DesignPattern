package com.java.designPattern.liskov.liskovDemo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/08/23:25
 * @Description: 里氏替换原则
 *
 * 基本介绍
 * 1）如果对每个类型为T1的对象o1，都有类型为T2的对象o2，
 * 使得以T1定义的所有程序P在所有的对象o1都代换成o2时，程序P的行为没有发生变化，
 * 那么类型T2是类型T1的子类型。换句话说，所有引用基类的地方必须能透明地使用其子类的对象。
 *
 * 2）在使用继承时，遵循里氏替换原则，在子类中尽量不要重写父类的方法
 *
 * 3）里氏替换原则告诉我们，继承实际上让两个类耦合性增强了，在适当的情况下，可以通过聚合，
 * 组合，依赖来解决问题。
 */
public class Liskov {
    public static void main(String[] args) {
        A a=new A();
        System.out.println("11-3="+a.func1(11,3));
        System.out.println("1-8="+a.func1(1,8));

        System.out.println("-----------------------");
        B b=new B();
        /**
         * 我们发现原来运行正常的相减功能发生了错误。原因就是类B无意中重写了父类的方法，造成原有功能出现错误。
         * 在实际编程中，我们常常会通过重写父类的方法完成新的功能，这样写起来虽然简单，但整个继承体系的复用性
         * 会比较差。特别是运行多态比较频繁的时候
         *
         * 通用的做法是：原来的父类和子类都继承一个更通俗的基类，原有的继承关系去掉，采用依赖，聚合，组合等关系代替.
         *
         * 改进代码见improve
         */
        //这里本意是求出11-3
        System.out.println("11-3="+b.func1(11,3));
        //1-8
        System.out.println("1-8="+b.func1(1,8));
        System.out.println("11+3+9="+b.func2(11,3));
    }
}

class A{
    //返回两个数的差
    public int func1(int num1,int num2){
        return num1 - num2;
    }
}

//B 类继承A类
//增加了一个新功能：完成两个数相加,然后和9求和
class B extends A{
    public int func1(int a, int b){
        return a + b;
    }

    public int func2(int a, int b){
        return func1(a,b) + 9;
    }

}
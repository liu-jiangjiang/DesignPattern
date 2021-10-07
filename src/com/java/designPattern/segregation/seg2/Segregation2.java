package com.java.designPattern.segregation.seg2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/07/22:49
 * @Description: 接口隔离原则
 *
 * 1.需求  一个接口 interface1 里面有 operation1 2 3 4 5 五个方法
 *  A A通过Interface1 会依赖（使用）B
 *  但是A中只有使用到接口的1 2 3 三个方法
 *
 *  B  C通过interface1 会依赖（使用）D
 *  但是C中只会使用到接口 1 4 5 三个方法
 *
 *  正确做法：将interface1 拆成几个独立的接口，类A 和 类C 分别和他们所需要的接口建立关系
 */
public class Segregation2 {
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
    }
}

//接口1
interface interface1{
    void operation1();
}

//接口2
interface interface2{
    void operation2();
    void operation3();
}
//接口3
interface interface3{
    void operation4();
    void operation5();
}
class B implements interface1, interface2{

    @Override
    public void operation1() {
        System.out.println("B 实现接口operation1方法");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现接口operation2方法");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现接口operation3方法");
    }
}

class D implements interface1, interface3{

    @Override
    public void operation1() {
        System.out.println("D 实现接口operation1方法");
    }

    @Override
    public void operation4() {
        System.out.println("D 实现接口operation4方法");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现接口operation5方法");
    }
}


class A {
    public void depend1(interface1 i){
        i.operation1();
    }
    public void depend2(interface2 i){
        i.operation2();
    }
    public void depend3(interface2 i){
        i.operation3();
    }
}

class C {
    public void depend1(interface1 i){
        i.operation1();
    }
    public void depend4(interface3 i){
        i.operation4();
    }
    public void depend5(interface3 i){
        i.operation5();
    }
}
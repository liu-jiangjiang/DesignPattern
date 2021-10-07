package com.java.designPattern.segregation.seg1;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/07/22:49
 * @Description: 接口隔离原则  (错误实例)
 *
 * 1.需求  一个接口 interface1 里面有 operation1 2 3 4 5 五个方法
 *  A A通过Interface1 会依赖（使用）B
 *  但是A中只有使用到接口的1 2 3 三个方法
 *
 *  B  C通过interface1 会依赖（使用）D
 *  但是C中只会使用到接口 1 4 5 三个方法
 */
public class Segregation {

}

interface interface1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}
class B implements interface1{

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

    @Override
    public void operation4() {
        System.out.println("B 实现接口operation4方法");
    }

    @Override
    public void operation5() {
        System.out.println("B 实现接口operation5方法");
    }
}

class D implements interface1{

    @Override
    public void operation1() {
        System.out.println("D 实现接口operation1方法");
    }

    @Override
    public void operation2() {
        System.out.println("D 实现接口operation2方法");
    }

    @Override
    public void operation3() {
        System.out.println("D 实现接口operation3方法");
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
    public void depend2(interface1 i){
        i.operation2();
    }
    public void depend3(interface1 i){
        i.operation3();
    }
}

class C {
    public void depend1(interface1 i){
        i.operation1();
    }
    public void depend4(interface1 i){
        i.operation4();
    }
    public void depend5(interface1 i){
        i.operation5();
    }
}
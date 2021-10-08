package com.java.designPattern.inversion.inversionImporve;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/08/20:21
 * @Description: 依赖倒转原则
 *
 * 1)接口传递应用案例代码
 * 2)构造方法传递应用案例代码
 * 3)setter方式传递
 * 在DependencyPass类中演示
 */
public class Inversion {
    public static void main(String[] args) {
        Person p = new Person();
        p.receive(new Email());
        p.receive(new WeChat());
    }
}

class Person{
    public void receive(IReceiver iReceiver){
        System.out.println("收到了"+ iReceiver.getName());
    }
}

interface IReceiver{
    String getName();
}

class Email implements IReceiver{
    public String getName(){
        return "一封邮件";
    }
}
class WeChat implements IReceiver{
    public String getName(){
        return "微信消息";
    }
}
package com.java.singleton.test4;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/12/22:55
 * @Description: 懒汉式(线程安全，同步方法)
 *
 * 优缺点说明：
 * 1) 解决了线程不安全问题
 * 2) 效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行
 * 同步。而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，
 * 直接return就行了。方法进行同步效率太低
 * 3) 结论：在实际开发中，不推荐使用这种方式
 */
public class Singleton {
    private static Singleton singleton;
    private Singleton(){}

    //加入同步代码，解决线程不安全问题
    public static synchronized Singleton getInstance(){
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

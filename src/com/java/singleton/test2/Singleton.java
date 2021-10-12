package com.java.singleton.test2;


/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/12/22:31
 * @Description: 单例模式之饿汉式（静态代码块）
 *
 *优缺点说明：
 * 1) 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块
 * 中，也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。优
 * 缺点和上面是一样的。
 * 2) 结论：这种单例模式可用，但是可能造成内存浪费
 */
public class Singleton {
    private static Singleton singleton;

    static {
        singleton = new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance(){
        return singleton;
    }
}

package com.java.singleton.test3;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/12/22:36
 * @Description: 懒汉式(线程不安全)
 *
 * 优缺点说明：
 * 1) 起到了Lazy Loading的效果，但是只能在单线程下使用。
 * 2) 如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及
 * 往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以
 * 在多线程环境下不可使用这种方式
 * 3) 结论：在实际开发中，不要使用这种方式
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}

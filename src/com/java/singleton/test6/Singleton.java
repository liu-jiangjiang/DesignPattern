package com.java.singleton.test6;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/12/23:03
 * @Description: 双重检查
 *
 * 优缺点说明：
 * 1) Double-Check概念是多线程开发中常使用到的，如代码中所示，我们进行了两
 * 次if (singleton == null)检查，这样就可以保证线程安全了。
 * 2) 这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，
 * 直接return实例化对象，也避免的反复进行方法同步.
 * 3) 线程安全；延迟加载；效率较高
 * 4) 结论：在实际开发中，推荐使用这种单例设计模式
 */
public class Singleton {
    private static volatile Singleton singleton;
    private Singleton(){}

    //加入同步代码，解决线程不安全问题
    public static Singleton getInstance(){
        if (singleton == null) {
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

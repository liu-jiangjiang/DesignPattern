package com.java.singleton.test5;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/12/23:01
 * @Description: 懒汉式(线程安全，同步代码块)
 *
 * 优缺点说明：
 * 1) 这种方式，本意是想对第四种实现方式的改进，因为前面同步方法效率太低，
 * 改为同步产生实例化的的代码块
 * 2) 但是这种同步并不能起到线程同步的作用。跟第3种实现方式遇到的情形一
 * 致，假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
 * 另一个线程也通过了这个判断语句，这时便会产生多个实例
 * 3) 结论：在实际开发中，不能使用这种方式
 */
public class Singleton {
    private static Singleton singleton;
    private Singleton(){}

    //加入同步代码，解决线程不安全问题
    public static Singleton getInstance(){
        if (singleton == null) {
            synchronized (Singleton.class){
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}

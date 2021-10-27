package com.java.singleton.test7;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/12/23:03
 * @Description: 枚举
 *
 * 优缺点说明：
1) 这借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而
且还能防止反序列化重新创建新的对象。
2) 这种方式是Effective Java作者Josh Bloch 提倡的方式
3) 结论：推荐使用
 */
public class Test{
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}
enum Singleton {
    INSTANCE;
    public void method(){
        System.out.println("say ok~");
    }

}

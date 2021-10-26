package com.java.designPattern.singleResponsibility;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/07/20:30
 * @Description: 单一职责原则
 * 对类来说的，即一个类应该只负责一项职责。如类A负责两个不同职责：职责1，职责2。
 * 当职责1需求变更而改变A时，可能造成职责2执行错误，所以需要将类A的粒度分解为
 * A1，A2
 */
public class SingleResponsibility3 {
    public static void main(String[] args) {
        Vehicle1 vehicle1 = new Vehicle1();
        vehicle1.landRun("汽车");
        vehicle1.seaRun("轮船");
        vehicle1.skyRun("飞机");
    }
}
class Vehicle1 {

    public void landRun(String vehicle) {
        System.out.println(vehicle + " 在公路上移動");
    }
    public void skyRun(String vehicle) {
        System.out.println(vehicle + " 在天空上移動");
    }
    public void seaRun(String vehicle) {
        System.out.println(vehicle + " 在大海上移動");
    }

}
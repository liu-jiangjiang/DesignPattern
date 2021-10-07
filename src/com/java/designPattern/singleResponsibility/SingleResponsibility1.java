package com.java.designPattern.singleResponsibility;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/07/19:56
 * @Description: 单一职责原则
 * 次案例违背 单一职责原则
 * Vehicle 功能太笼统
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("轮船");
        vehicle.run("飞机");
    }

}


class Vehicle {

    public void run(String vehicle) {
        System.out.println(vehicle + " 在公路上移動");
    }

}
package com.java.designPattern.SingleResponsibility;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/07/20:17
 * @Description: 单一职责原则
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
        LandVehicle landVehicle = new LandVehicle();
        landVehicle.run("汽车");

        SkyVehicle skyVehicle = new SkyVehicle();
        skyVehicle.run("飞机");

        SeaVehicle seaVehicle = new SeaVehicle();
        seaVehicle.run("轮船");
    }
}

class LandVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + " 在陆地上跑。。");
    }
}

class SkyVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + " 在天空上跑。。");
    }
}

class SeaVehicle{
    public void run(String vehicle){
        System.out.println(vehicle + " 在大海上跑。。");
    }
}
package com.java.designPattern.inversion.inversionImporve;

/**
 * Created with IntelliJ IDEA.
 * @Auther: liujiang
 * @Date: 2021/10/08/20:32
 * @Description: 依赖倒转原则
 *
 * 1)低层模块尽量都要有抽象类或接口，或者两者都有，程序稳定性更好.
 *
 * 2)变量的声明类型尽量是抽象类或接口,这样我们的变量引用和实际对象间，
 * 就存在一个缓冲层，利于程序扩展和优化
 *
 * 3)继承时遵循里氏替换原则
 *
 * 1)接口传递
 * 2)构造方法传递
 * 3)setter方式传递
 */
public class DependencyPass{
    public static void main(String[] args) {
        XiaoMi xiaoMi = new XiaoMi();
        // 1)接口传递应用案例代码
//        OpenAndClose openAndClose = new OpenAndClose();
//        openAndClose.open(xiaoMi);
//        openAndClose.close(xiaoMi);

        // 2)构造方法传递应用案例代码
/*        OpenAndClose openAndClose = new OpenAndClose(xiaoMi);
        openAndClose.open();*/

        // 3)setter方式传递
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.setTV(xiaoMi);
        openAndClose.open();
    }
}

/*// 1)接口传递应用案例代码
//开关的接口
interface IOpenAndClose{
    void open(ITV itv);
    void close(ITV itv);
}
//电视接口
interface ITV{
    void play();
    void close();
}

class OpenAndClose implements IOpenAndClose{

    @Override
    public void open(ITV itv) {
        itv.play();
    }

    @Override
    public void close(ITV itv) {
        itv.close();
    }
}
*/
/*// 2)构造方法传递应用案例代码
interface IOpenAndClose{
    void open();
}

interface ITV{
    void play();
}

class OpenAndClose implements IOpenAndClose{
    private ITV itv;
    public OpenAndClose(ITV itv){
        this.itv = itv;
    }
    @Override
    public void open() {
        itv.play();
    }
}*/
// 3)setter方式传递
interface IOpenAndClose{
    void open();

    void setTV(ITV itv);
}

interface ITV{
    void play();
}

class OpenAndClose implements IOpenAndClose{
    private ITV itv;
    @Override
    public void open() {
        itv.play();
    }

    @Override
    public void setTV(ITV itv) {
        this.itv = itv;
    }
}

class XiaoMi implements ITV{

    @Override
    public void play() {
        System.out.println("打开了小米电视");
    }

//    @Override
//    public void close() {
//        System.out.println("关闭了小米电视");
//    }
}
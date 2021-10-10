package com.java.designPattern.openAndClose.ocpDemo;
/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/10/19:35
 * @Description: 开闭原则
 *
 * 1) 开闭原则（Open Closed Principle）是编程中最基础、最重要的设计原则
 * 2) 一个软件实体如类，模块和函数应该对扩展开放(对提供方)，对修改关闭(对使用
 * 方)。用抽象构建框架，用实现扩展细节。
 * 3) 当软件需要变化时，尽量通过扩展软件实体的行为来实现变化，而不是通过修改已
 * 有的代码来实现变化。
 * 4) 编程中遵循其它原则，以及使用设计模式的目的就是遵循开闭原则。
 */
public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Rectangle());
    }
}

/**
 * 分析：
 * 1) 优点是比较好理解，简单易操作。
 * 2) 缺点是违反了设计模式的ocp原则，即对扩展开放(提供方)，对修改关闭(使用方)。
 * 即当我们给类增加新功能的时候，尽量不修改代码，或者尽可能少修改代码.
 * 3) 比如我们这时要新增加一个图形种类 三角形，我们需要做如下修改，修改的地方
 * 较多
 *
 * 改进案例见improve
 */
class GraphicEditor {
    public void drawShape(Shape s) {
        if (s.m_type == 1)
            drawRectangle(s);
        else if (s.m_type == 2)
            drawCircle(s);
    }
    private void drawRectangle(Shape r) {
        System.out.println("矩形");}
    private void drawCircle(Shape r) {
        System.out.println("圆形");
    }}
class Shape {
    int m_type;
}
class Rectangle extends Shape {
    public Rectangle() {
        super.m_type = 1;
    }
}
class Circle extends Shape {
    public Circle() {
        super.m_type = 2;
    }
}
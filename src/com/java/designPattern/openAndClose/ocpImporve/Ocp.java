package com.java.designPattern.openAndClose.ocpImporve;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/10/19:36
 * @Description: 开闭原则
 * 把创建Shape类做成抽象类，并提供一个抽象的draw方法，让子类去实现即可，
 * 这样我们有新的图形种类时，只需要让新的图形类继承Shape，并实现draw方法即可，
 * 使用方的代码就不需要修 -> 满足了开闭原则
 */
public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Others());
    }
}

class GraphicEditor {
    public void drawShape(Shape s) {
        s.draw();
    }
}
abstract class Shape {
    int m_type;

    public abstract void draw();
}
class Rectangle extends Shape {
    public Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("画矩形");
    }
}
class Circle extends Shape {
    public Circle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("画圆形");
    }
}

class Others extends Shape{

    @Override
    public void draw() {
        System.out.println("画其他");
    }
}

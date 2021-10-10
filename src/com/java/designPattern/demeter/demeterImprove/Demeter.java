package com.java.designPattern.demeter.demeterImprove;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: liujiang
 * @Date: 2021/10/10/20:12
 * @Description: 迪米特法则
 *
 * 1)前面设计的问题在于SchoolManager中，CollegeEmployee类并不是SchoolManager类的直接朋友(分析)
 * 2)按照迪米特法则，应该避免类中出现这样非直接朋友关系的耦合
 * 3)对代码按照迪米特法则
 */
public class Demeter {
    public static void main(String[] args) {
        System.out.println("~~~使用迪米特法则的改进~~~");
        //创建了一个SchoolManager对象
        SchoolManager schoolManager=new SchoolManager();
        //输出学院的员工id和学校总部的员工信息
        schoolManager.printAllEmployee(new CollegeManager());
    }
}
class Employee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


class CollegeEmployee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}


class CollegeManager {
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id= " + i);
            list.add(emp);
        }
        return list;
    }
    public void printManager() {
        List<CollegeEmployee> list1 =getAllEmployee();
        System.out.println("------------分公司员工------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
    }
}

//学校管理类
// 分析SchoolManager类的直接朋友类有哪些Employee、CollegeManager
// CollegeEmployee不是直接朋友而是一个陌生类，这样违背了迪米特法则
class SchoolManager {
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();

        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("学校总部员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    //该方法完成输出学校总部和学院员工信息(id)
    void printAllEmployee(CollegeManager sub) {
        sub.printManager();
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}
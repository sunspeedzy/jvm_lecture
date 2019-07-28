package zy.jvm.classloader;

/**
 * 类继承关系 与 初始化顺序和类加载顺序的 联系
 */
class Parent {
    static int a = 3;
    static {
        System.out.println("Parent static block");
    }
}
class Child extends Parent {
    static int b = 4;
    static {
        System.out.println("Child static block");
    }
}
/**
 * @author zhangyan_g
 */
public class MyTest9 {
    static {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
        /*
运行结果：类的初始化顺序确定类要被直接引用后，要先初始化父类，先加载父类
[Loaded zy.jvm.classloader.MyTest9 from file:/D:/gitRepo/jvm_lecture/out/production/classes/]
MyTest9 static block
[Loaded zy.jvm.classloader.Parent from file:/D:/gitRepo/jvm_lecture/out/production/classes/]
[Loaded zy.jvm.classloader.Child from file:/D:/gitRepo/jvm_lecture/out/production/classes/]
Parent static block
Child static block
4
         */
        System.out.println(Child.b);
    }
}

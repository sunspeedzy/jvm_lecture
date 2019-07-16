package zy.jvm.classloader;

import java.util.Random;

/**
 * 演示方法，编译 MyTest5 之后，删除 MyParent5.class 或 MyChild5.class文件，
 * 再在 Terminal 中 D:\gitRepo\jvm_lecture\build\classes\java\main>java zy.jvm.classloader.MyTest5
 * 可以正常运行，由此得出以下结论
 *
 * 当一个接口在初始化时，并不要求其父接口都完成了初始化。
 *
 * 在使用 接口的、在编译期内确定值的 静态常量时，就不会去加载这个接口，更不要求初始化这个接口及其父接口。
 * 在使用 接口的、在运行期内确定值的 静态常量时，或者在使用实现类的非静态常量时，就会去加载这个接口及其父接口。
 * 对于接口来说，它只能定义静态常量。
 *
 * @author zhangyan_g
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);
    }
}

interface MyParent5 {
//    public static final int a = 5;
//    public static final int a = new Random().nextInt(4);
}

class MyChild5 implements MyParent5 {
    public static int b = 6;
//    public static final int b = new Random().nextInt(4);
}
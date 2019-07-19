package zy.jvm.classloader;

/**
 * 验证类加载的双亲机制
 */
public class MyTest7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());  // 返回 null，因为 java.lang.String 是由 bootstrap classloader加载

        Class<?> clazz2 = Class.forName("zy.jvm.classloader.C");
        System.out.println(clazz2.getClassLoader()); // 返回 sun.misc.Launcher$AppClassLoader@18b4aac2，C 由应用类加载器加载
    }
}

class C {

}
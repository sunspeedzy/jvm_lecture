package zy.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 自定义类加载器
 * 1. 需要定义一个 ClassLoader 的名字。通过构造函数 MyTest16(String classLoaderName)
 * 2. 可以给这个类加载器指定一个父加载器。通过构造函数 MyTest16(ClassLoader parent, String classLoaderName)
 * 3. 实现 findClass 方法，通过类名可以加载到这个类。通过 loadClassData(String name) 实现
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        // 使用getSystemClassLoader()方法返回的ClassLoader（即系统类加载器）作为
        // parent ClassLoader来创建一个新的ClassLoader
        super();
        this.classLoaderName = classLoaderName;
    }

    /**
     * 使用指定的parent类加载器作为委托的类加载器去创建一个新的类加载器。
     * Creates a new class loader using the specified parent class loader for
     * delegation.
     *
     *
     * @param parent The parent class loader
     * @throws SecurityException If a security manager exists and its
     *                           <tt>checkCreateClassLoader</tt> method doesn't allow creation
     *                           of a new class loader.
     * @since 1.2
     */
    public MyTest16(ClassLoader parent, String classLoaderName) {
        // 显示指定该类加载器的父加载器
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]" ;
    }

    /**
     * 根据类名寻找这个类，由 java.lang.ClassLoader 的 loadClass 方法调用
     * @param className
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] data = this.loadClassData(className);

        // defineClass方法 将 字节数组data 转换为Class实例，在使用这个Class实例之前，它必须是已被解析的
        return defineClass(className, data, 0, data.length);
    }

    /**
     * 加载类数据，自定义的私有方法，由 findClass 方法调用
     * 要读取类文件的字节数组
     * @param name 要加载的类的名字
     * @return
     */
    private byte[] loadClassData(String name) {
        InputStream is = null;
        // 存储返回值
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {
            // 将类名中包的分隔符变为当前文件系统的分隔符
            this. classLoaderName = this.classLoaderName.replace(".", File.separator);

            is = new FileInputStream(new File(name + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;
            // 每次从输入流读取一个字节
            while ( -1 != (ch = is.read())) {
                baos.write(ch);
            }
            // 将字节数组输出流的内容直接转换为字节数组
            data = baos.toByteArray();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return data;
    }

    public static void test(ClassLoader classLoader) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // loadClass方法，加载指定二进制名字的类，调用loadClass(String className, false)方法去加载类
        // loadClass(String className, false)方法默认实现搜索类的顺序如下
        // 1.  Invoke findLoadedClass(String) to check if the class has already been loaded.
        // 2. Invoke the {@link #loadClass(String) <tt>loadClass</tt>} method
        //  on the parent class loader.  If the parent is <tt>null</tt> the class
        //  loader built-in to the virtual machine is used, instead.
        // 3. Invoke the {@link #findClass(String)} method to find the class.
        Class<?> clazz = classLoader.loadClass("zy.jvm.classloader.MyTest1");
        Object object = clazz.newInstance();

        System.out.println(object);
    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        MyTest16 locader1 = new MyTest16("loader1");
        test(locader1);
    }
}

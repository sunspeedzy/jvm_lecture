package zy.jvm.bytecode.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSubject(rs);
        Class<?> cls = rs.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(
                cls.getClassLoader(), cls.getInterfaces(), ds);
//        Subject subject = (Subject) Proxy.newProxyInstance(
//                RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), ds);
        subject.request();

        System.out.println(subject.getClass());
        System.out.println(subject.getClass().getSuperclass());
        // 结果是
        // class com.sun.proxy.$Proxy0
        // class java.lang.reflect.Proxy
        // 说明subject是动态创建出来的，而其父类就是 java.lang.reflect.Proxy

        for (Class<?> anInterface : cls.getInterfaces()) {
            System.out.println(anInterface);
        }
        // 结果是 interface zy.jvm.bytecode.dynamicproxy.Subject

    }
}

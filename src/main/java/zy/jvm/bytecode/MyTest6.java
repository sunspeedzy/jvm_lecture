package zy.jvm.bytecode;

public class MyTest6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit orange = new Orange();

        apple.test();
        orange.test();
        // 以上两句代码的执行结果是
        // Apple
        // Orange

        apple = new Orange();
        apple.test();
        // 以上代码的执行结果是
        // Orange
    }

}

class Fruit {
    public void test() {
        System.out.println("Fruit");
    }
}

class Apple extends Fruit {
    public void test() {
        System.out.println("Apple");
    }
}

class Orange extends Fruit {
    public void test() {
        System.out.println("Orange");
    }
}

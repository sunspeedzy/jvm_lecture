这个工程的代码，是《深入理解JVM 张龙》的课程代码

zy.jvm.classloader.MyTest1 用来演示Java类的主动使用和被动使用的区别
zy.jvm.classloader.MyTest2 用来演示静态常量对Java类主动/被动使用的影响
zy.jvm.classloader.MyTest3 用来演示运行期间才能确定值的类静态常量会导致主动使用这个静态常量所在的类
zy.jvm.classloader.MyTest4 用来演示 引用类型和基本类型的数组的创建
zy.jvm.classloader.MyTest5 用来演示 接口的初始化规则
zy.jvm.classloader.MyTest6 用来演示 类加载器准备阶段的初始化过程 以及 初始化阶段的执行顺序
zy.jvm.classloader.MyTest5_2 用来演示 接口的初始化规则
zy.jvm.classloader.MyTest7 用来验证 类加载的双亲机制
zy.jvm.classloader.MyTest8 用来验证 static final的成员在编译时确定则被引用时不会引起所属类的加载，
                           在运行时确定则被引用时会引起所属类的加载，与 MyTest3 类似，不再编写
zy.jvm.classloader.MyTest9 用来验证 类继承关系 与 初始化顺序和类加载顺序的 联系
zy.jvm.classloader.MyTest10 与 MyTest9 类似，只是对Parent类的使用方式不同，使Parent类的初始化不会由Child类的初始化引起
zy.jvm.classloader.MyTest11 通过子类去访问父类里定义的内容（方法、变量、常量），是对父类的主动使用，而不是对子类的主动使用，
                            是否是主动使用要看定义内容的类，而不是看调用方是谁
zy.jvm.classloader.MyTest12 用来验证 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
                            反射会造成主动使用类
zy.jvm.classloader.MyTest13 用来查看各个类加载器的层级关系
zy.jvm.classloader.MyTest14 用来验证 对于数组实例来说，其类型是由JVM在运行期动态生成的
zy.jvm.classloader.MyTest15 用来验证类加载器的JavaDoc中关于ClassLoader的描述
zy.jvm.classloader.MyTest16 自定义一个类加载器，对类加载器的双亲委托机制进行深度剖析
zy.jvm.classloader.MyCat    第19课创建，用来演示在一个类中创建另一个类的实例时类加载的情况
zy.jvm.classloader.MySample
zy.jvm.classloader.MyTest17
zy.jvm.classloader.MyTest18 用来查看 启动类加载器、扩展类加载器、系统类加载器 所加载的类的路径
                            在第24课用来演示如何 将自定义的ClassLoader作为系统类加载器
zy.jvm.classloader.MyTest18_1 用来验证 自定义类如果放在 启动类加载器所加载类的路径中，那么这个类将会被启动类加载器加载
zy.jvm.classloader.MyTest19 用来验证 扩展类加载器 加载类的情况
zy.jvm.classloader.MyTest20 用来验证 类加载器所加载的类 在反射时的使用情况
zy.jvm.classloader.MyPerson
zy.jvm.classloader.MyTest21 验证 同名类在不同的命名空间之间互不可见
zy.jvm.classloader.MyTest24 用来讲解线程类上下文类加载器
zy.jvm.classloader.MyTest25 验证线程的上下文类加载器是 AppClassLoader
zy.jvm.classloader.MyTest26 ServiceLoader在SPI中的作用，第29课视频
zy.jvm.classloader.MyTest27 通过JDBC驱动加载深刻理解线程上下文类加载器机制，第30课视频

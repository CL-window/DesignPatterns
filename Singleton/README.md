## 单例模式
* 单例类只有一个实例对象；
* 该单例对象必须由单例类自行创建；
* 单例类对外提供一个访问该单例的全局访问点；

### 单例模式的实现
* 普通类的构造函数是公有的，外部类可以通过“new 构造函数()”来生成多个实例; 单例模式的类的构造函数设为私有的
* 懒汉式
    ```
    public class LazySingleton {
        public static volatile LazySingleton instance = null;
        private LazySingleton() {
            //
        }

        public static synchronized LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }
    }
    ```
* 饿汉式
    ```
    public static class HungrySingleton {
        private static final HungrySingleton instance = new HungrySingleton();
        private HungrySingleton(){}
        public static HungrySingleton getInstance() {
            return instance;
        }

        public void run() {
            System.out.println("HungrySingleton run...");
        }
    }
    ```
* 通过枚举类创建
    ```
    public static enum EnumSingleton {
        INSTANCE;
        public void fun1() {
            System.out.println("EnumSingleton fun1...");
        }
        public void fun2() {
            System.out.println("EnumSingleton fun2...");
        }
    }
    ```
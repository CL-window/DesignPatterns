
public class Singleton {

    /**
     * 如果式多线程，需要加上关键字volatile 和 synchronized，否则将存在线程非安全的问题
     */
    public static class LazySingleton {
        private static volatile LazySingleton instance = null;
        private LazySingleton() {
            //
        }

        public static synchronized LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }

        public void run() {
            System.out.println("LazySingleton run...");
        }
    
    }

    /**
     * 饿汉式单例是在类创建的同时就已经创建好一个静态的对象，没有线程安全的问题
     */
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

    /**
     * 通过 枚举 enum 实现单例
     * 枚举类无法被反射调用构造方法
     */
    public static enum EnumSingleton {
        INSTANCE;

        public static EnumSingleton getInstance() {
            return INSTANCE;
        }

        public void fun1() {
            System.out.println("EnumSingleton fun1...");
        }
        public void fun2() {
            System.out.println("EnumSingleton fun2...");
        }
    }

    public static void main(String[] args) {
        LazySingleton.getInstance().run();
        HungrySingleton.getInstance().run();
        EnumSingleton.INSTANCE.fun1();
        EnumSingleton.getInstance().fun2();
    }
}


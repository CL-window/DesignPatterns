
public class Template {

    /**
     * 抽象类
     */
    public static abstract class Method {

        public abstract void run1();

        public boolean needRun2() {
            return true;
        }

        public abstract void run2();

        public abstract void run3();

        public void run() {
            run1();
            if (needRun2()) {
                run2();
            }
            run3();
        }
    }

    /**
     * 具体子类
     */
    public static class ConcreteMethod extends Method {
        @Override
        public void run1() {
            System.out.println("run1...");
        }

        @Override
        public boolean needRun2() {
            return false;
        }

        @Override
        public void run2() {
            System.out.println("run2...");
        }

        @Override
        public void run3() {
            System.out.println("run3...");
        }

    }

    public static void main(String[] args) {
        ConcreteMethod method = new ConcreteMethod();
        method.run();
    }
}
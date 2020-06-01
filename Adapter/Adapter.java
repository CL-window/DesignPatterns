
/**
 * 以电压为例，国内电压220V, 手机充电正常5V，欧美等国家电压110V
 * 给手机充电需要适配器，出国旅游需要一个新的适配器（国内的用不了）
 */
public class Adapter {

    /**
     * 电压, 适配者类
     */
    public interface AC {
        void print();
    }

    public static class AC220 implements AC {
        @Override
        public void print() {
            System.out.println("220V");
        }
    }

    public static class AC110 implements AC {
        @Override
        public void print() {
            System.out.println("110V");
        }
    }

    /**
     * 手机5v电压适配器, 目标抽象类
     */
    public interface AC5Adapter {
        void printAC5();
    }

    /**
     * 适配器类
     */
    public static class AC220Adapter implements AC5Adapter {

        private AC220 ac220 = new AC220();

        @Override
        public void printAC5() {
            ac220.print();
            System.out.println("5V");
        }
    }

    public static class AC110Adapter implements AC5Adapter {

        private AC110 ac110 = new AC110();

        @Override
        public void printAC5() {
            ac110.print();
            System.out.println("5V");
        }
    }

    public static AC5Adapter getAdapter(AC ac) {
        AC5Adapter adapter = null;
        if (ac instanceof AC220) {
            adapter = new AC220Adapter();
        }
        if (ac instanceof AC110) {
            adapter = new AC110Adapter();
        }
        if (adapter == null){
            throw new  IllegalArgumentException("没有找到合适的适配器");
        }
        return adapter;
    }

    public static void main(String[] args) {
        AC ac220 = new AC220();
        AC5Adapter adapter = getAdapter(ac220);
        adapter.printAC5();

        AC ac110 = new AC220();
        adapter = getAdapter(ac110);
        adapter.printAC5();

    }
}
/**
 * 以购买股票基金为例，比如支付宝上的很多基金
 * 用户通过支付宝直接购买基金，该基金有专业的经理人打理，把投资者的分散资金集中起来，投资于股票,债券等等
 */
public class Facade {

    /**
     * 子系统 基类
     */
    public static abstract class Shares {
        abstract void print();
    }

    /**
     * 子系统 实现类
     */
    public static class Shares1 extends Shares {
        @Override
        void print() {
            System.out.println("股票1...");
        }
    }

    public static class Shares2 extends Shares {
        @Override
        void print() {
            System.out.println("股票2...");
        }
    }

    public static class Shares3 extends Shares {
        @Override
        void print() {
            System.out.println("股票3...");
        }
    }

    /**
     * 外观
     * 基金类
     */
    public static class Fund {

        private Shares shares1;
        private Shares shares2;
        private Shares shares3;

        public Fund() {
            shares1 = new Shares1();
            shares2 = new Shares2();
            shares3 = new Shares3();
        }

        /**
         * 购买
         */
        public void buy() {
            System.out.println("购买...");
            shares1.print();
            shares2.print();
            shares3.print();
        }

        /**
         * 出售
         */
        public void sell() {
            System.out.println("出售...");
            shares1.print();
            shares2.print();
            shares3.print();
        }
    }

    /**
     * 客户端
     */
    public static void main(String[] args) {
        Fund fund = new Fund();
        fund.buy();
        fund.sell();
    }
}
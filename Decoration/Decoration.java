/**
 * 以喝奶茶为例
 * 奶茶可以是原味奶茶, 可以是红茶，也可以是绿茶；奶茶里可以料,比如珍珠奶茶，布丁奶茶，仙草奶茶等等
 * 加了料之后奶茶的价格就要发生变化，
 */
public class Decoration {

    /**
     * 抽象构件角色
     */
    public interface TeaMilk {
        int price();
    }

    /**
     * 具体构件角色
     * 红茶 原味奶茶 
     */
    public static class BlackTeaMilk implements TeaMilk {
        @Override
        public int price() {
            System.out.print("使用红茶, ");
            return 5;
        }
    }

    public static class GreenTeaMilk implements TeaMilk {
        @Override
        public int price() {
            System.out.print("使用绿茶, ");
            return 5;
        }
    }

    /**
     * 抽象装饰角色
     */
    public static class TeaMilkWithMaterial implements TeaMilk {

        private TeaMilk teaMilk;
        public TeaMilkWithMaterial(TeaMilk teaMilk) {
            this.teaMilk = teaMilk;
        }

        @Override
        public int price() {
            return teaMilk.price();
        }
    }

    /**
     * 具体装饰角色
     * 珍珠奶茶
     */
    public static class PearlTeaMilk extends TeaMilkWithMaterial {

        public PearlTeaMilk(TeaMilk teaMilk) {
            super(teaMilk);
        }

        @Override
        public int price() {
            return super.price() + 1;
        }
    }

    public static class PuddingTeaMilk extends TeaMilkWithMaterial {

        public PuddingTeaMilk(TeaMilk teaMilk) {
            super(teaMilk);
        }

        @Override
        public int price() {
            return super.price() + 2;
        }
    }

    public static void main(String[] args) {
        BlackTeaMilk blackTeaMilk = new BlackTeaMilk();
        PearlTeaMilk pearlTeaMilk = new PearlTeaMilk(blackTeaMilk);
        System.out.println("珍珠奶茶：" + pearlTeaMilk.price());

        GreenTeaMilk greenTeaMilk = new GreenTeaMilk();
        PuddingTeaMilk puddingTeaMilk = new PuddingTeaMilk(greenTeaMilk);
        System.out.println("布丁奶茶：" + puddingTeaMilk.price());
    }
}
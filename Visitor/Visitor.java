import java.util.ArrayList;
/**
 * 访问者举个例子：A去网吧上网，A是访问者，网吧的电脑是具体元素，A可以使用电脑上网，玩游戏，听音乐，但是不可以查看电脑内部，破坏电脑；
 * 即在不修改已有程序结构的前提下，通过添加额外的访问者来完成对已有代码功能的提升
 * 
 * 面粉在包子铺可以加工成包子，在Pizza店可以加工成Pizza
 * 猪肉在包子铺加工成包子馅，在Pizza店可以加工为Pizza上面的肉馅
 * 使用访问者来解析 , 
 */
public class Visitor {

    public static void print(String info) {
        System.out.println(info);
    }

    /**
     * 抽象访问者
     * 提供根据面粉 和 猪肉 的加工方法
     */
    public interface Shop {
        public void machining(Element element);
    }

    /**
     * 具体访问者
     * 包子铺
     */
    public static class Baozipu implements Shop {
        @Override
        public void machining(Element element) {
            if (element instanceof Flour) {
                print("加工为包子");
            } else if (element instanceof Pork) {
                print("加工为包子馅");
            }
        }
    }

    public static class PizzShop implements Shop {
        @Override
        public void machining(Element element) {
            if (element instanceof Flour) {
                print("加工为Pizza");
            } else if (element instanceof Pork) {
                print("加工为Pizza馅");
            }
        }
    }

    /**
     * 抽象元素
     * 提供 访问者的访问
     */
    public interface Element {
        public void accept(Shop shop);
    }

    /**
     * 具体元素
     */
    public static class Flour implements Element {
        @Override
        public void accept(Shop shop) {
            shop.machining(this);
        }
    }

    public static class Pork implements Element {
        @Override
        public void accept(Shop shop) {
            shop.machining(this);
        }
    }

    /**
     * 对象结构
     */
    public static class SetElement {

        private ArrayList<Element> elements = new ArrayList<>();

        public void addElememt(Element element) {
            elements.add(element);
        }

        public void machining(Shop shop) {
            int size = elements.size();
            for (int i = 0; i < size; i++) {
                shop.machining(elements.get(i));
            }
        }
    }

    public static void main(String[] args) {
        SetElement elements = new SetElement();
        elements.addElememt(new Flour());
        elements.addElememt(new Pork());
        elements.machining(new Baozipu());
        elements.machining(new PizzShop());
    }
}
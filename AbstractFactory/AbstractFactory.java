/**
 * 以工厂生产披萨pizza为例, 都是用面粉加工的，除了做pizza, 还可以做面条，比如意大利面等
 */
public class AbstractFactory {
    public interface Pizza {
        public void show();
    }

    public interface Noodles {
        public void show();
    }

    public static class FruitPizza implements Pizza {
        @Override
        public void show() {
            System.out.println("水果Pizza");
        }
    }

    public static class SeaFoodPizza implements Pizza {
        @Override
        public void show() {
            System.out.println("海鲜Pizza");
        }
    }

    public static class Pasta implements Noodles {
        @Override
        public void show() {
            System.out.println("意大利面");
        }
    }

    public static class PlainNoodleSoup implements Noodles {
        @Override
        public void show() {
            System.out.println("阳春面");
        }
    }

    public interface Shop {
        // 加工
        public Pizza newPizza();

        public Noodles newNoodles();
    }

    public static class Shop1 implements Shop {

        @Override
        public Pizza newPizza() {
            Pizza pizza = new FruitPizza();
            pizza.show();
            return pizza;
        }

        @Override
        public Noodles newNoodles() {
            Noodles noodles = new Pasta();
            noodles.show();
            return noodles;
        }
    }

    public static class Shop2 implements Shop {

        @Override
        public Pizza newPizza() {
            Pizza pizza = new SeaFoodPizza();
            pizza.show();
            return pizza;
        }

        @Override
        public Noodles newNoodles() {
            Noodles noodles = new PlainNoodleSoup();
            noodles.show();
            return noodles;
        }
    }


    public static void main(String[] args) {
        Shop1 shop1 = new Shop1();
        Shop2 shop2 = new Shop2();
        shop1.newPizza();
        shop1.newNoodles();
        shop2.newPizza();
        shop2.newNoodles();
    }
}
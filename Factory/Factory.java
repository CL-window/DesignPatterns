
/**
 * 以工厂生产披萨pizza为例
 * 有不同口味的，比如水果的，榴莲的，海鲜的
 * 有不同店铺生产的，比如一分店专门生产水果的，二分店专门生产海鲜的
 * 
 */
public class Factory {

    public interface Pizza {
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

    public interface Shop {
        // 加工
        public Pizza newPizza();
    }

    public static class Shop1 implements Shop {

        @Override
        public Pizza newPizza() {
            Pizza pizza = new FruitPizza();
            pizza.show();
            return pizza;
        }
    }

    public static class Shop2 implements Shop {

        @Override
        public Pizza newPizza() {
            Pizza pizza = new SeaFoodPizza();
            pizza.show();
            return pizza;
        }
    }


    public static void main(String[] args) {
        Shop1 shop1 = new Shop1();
        Shop2 shop2 = new Shop2();
        shop1.newPizza();
        shop2.newPizza();
    }
}
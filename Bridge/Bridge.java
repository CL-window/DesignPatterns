/**
 * 以喝咖啡为例
 * 可以选择 大杯不加糖，大杯加糖，中杯不加糖，中杯加糖
 * 如果只是这四个，可以建立四个类，比如“大杯不加糖”类，“大杯加糖”类，但是如果有多糖，少糖，再加上温度纬度，比如常温，热的，加冰的，去冰的，这个需要创建的类就非常多了
 * 涉及多个独立维度，可以考虑使用桥接模式，目前分为大小杯，有无糖两个纬度
 */
public class Bridge {

    /**
     * 抽象
     * 描述甜度
     */
    public interface Sweetness {
        void addSweet();
    }

    /**
     * 扩展抽象
     * 不加糖
     */
    public static class SugarFree implements Sweetness {
        @Override
        public void addSweet() {
            System.out.print("原味， 不加糖, ");
        }
    }

    public static class AddSugar implements Sweetness {
        @Override
        public void addSweet() {
            System.out.print("加糖, ");
        }
    }

    /**
     * 实现
     * 实现 维度的基本操作，提供给 Abstraction 使用。该类一般为接口或抽象类；
     * 
     * 目前只加了甜度， 如果要加入温度纬度，直接在这个类里新增温度纬度
     */
    public static abstract class Coffee {
        private Sweetness sweetness;

        public void setSweetness(Sweetness sweetness) {
            this.sweetness = sweetness;
            this.sweetness.addSweet();
        }

        public abstract void makeCoffee();
    }

    /**
     * 具体实现
     */

     public static class LargeCoffee extends Coffee {
        @Override
        public void makeCoffee() {
            System.out.println("大杯咖啡...");
        }
     }

     public static class MiddleCoffee extends Coffee {
        @Override
        public void makeCoffee() {
            System.out.println("中杯咖啡...");
        }
     }

     /**
      * out:
      * 原味， 不加糖, 大杯咖啡...
      * 加糖, 中杯咖啡...
      */
    public static void main(String[] args) {
        SugarFree sugarFree = new SugarFree();
        AddSugar addSugar = new AddSugar();
        LargeCoffee largeCoffee = new LargeCoffee();
        largeCoffee.setSweetness(sugarFree);
        largeCoffee.makeCoffee();

        MiddleCoffee middleCoffee = new MiddleCoffee();
        middleCoffee.setSweetness(addSugar);
        middleCoffee.makeCoffee();
    }
}
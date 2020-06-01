
public class Builder {


    public static class Product {
        private String partA;
        private String partB;
        private String partC;

        public void setPartA(String partA) {
            this.partA = partA;
        }

        public void setPartB(String partB) {
            this.partB = partB;
        }

        public void setPartC(String partC) {
            this.partC = partC;
        }

        public void show() {
            System.out.println("Product: " + partA + ", " + partB + ", " + partC);
        }
    }
    /**
     * 抽象建造者
     */
    public static abstract class AbstractBuilder {
        //创建产品对象
        protected Product product = new Product();
        public abstract void buildPartA();
        public abstract void buildPartB();
        public abstract void buildPartC();
        //返回产品对象
        public Product getResult(){
            return product;
        }
    } 

    public static class Builder1 extends AbstractBuilder {
        public void buildPartA(){
            product.setPartA("1 建造 PartA");
        }
        public void buildPartB(){
            product.setPartB("1 建造 PartB");
        }
        public void buildPartC(){
            product.setPartC("1 建造 PartC");
        }
    }

    public static class Builder2 extends AbstractBuilder {
        public void buildPartA(){
            product.setPartA("2 建造 PartA...");
        }
        public void buildPartB(){
            product.setPartB("2 建造 PartB...");
        }
        public void buildPartC(){
            product.setPartC("2 建造 PartC...");
        }
    }


    /**
     * 指挥者
     */
    public static class Director {
        public Director(){}
        //产品构建与组装方法
        public Product construct(AbstractBuilder builder) {
            builder.buildPartA();
            builder.buildPartB();
            builder.buildPartC();
            Product product = builder.getResult();
            product.show();
            return product;
        }
    }

    public static void main(String[] args) {
        AbstractBuilder builder1 = new Builder1();
        AbstractBuilder builder2 = new Builder2();
        Director director = new Director();
        director.construct(builder1);
        director.construct(builder2);

    }
}
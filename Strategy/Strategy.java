
public class Strategy {

    /**
     * 抽象策略
     */
    public interface Travel{
        void travel();
    }

    /**
     * 具体策略
     */
    public static class CarTravel implements Travel {
        @Override
        public void travel() {
            System.out.println("自驾...");
        }
    }

    public static class TrainTravel implements Travel {
        @Override
        public void travel() {
            System.out.println("火车...");
        }
    }

    public static class AirTravel implements Travel {
        @Override
        public void travel() {
            System.out.println("飞机...");
        }
    }

    /**
     * 环境类
     */
    public static class Traveler {

        public Traveler() {

        }

        public void setTravel(Travel t) {
            t.travel();
        }

    }


    public static void main(String[] args) {
        Traveler traveler = new Traveler();
        traveler.setTravel(new AirTravel());

        traveler.setTravel(new CarTravel());

        traveler.setTravel(new TrainTravel());

    }
}
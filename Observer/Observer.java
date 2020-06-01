import java.util.ArrayList;
/**
 * RxJava 就是一个非常好的对观察者的扩展
 * 以 自动气象观测台为例
 * 气象设备监测到温度变化，通知注册的工作人员
 */
public class Observer {

    /**
     * 抽象观察者
     */
    public interface IObserver {
        public void update(int temperature);
    }

    /**
     * 具体观察者
     * 工作人员
     */
    public static class Personnel implements IObserver {
        private String name;
        public Personnel(String name) {
            this.name = name;
        }

        @Override
        public void update(int temperature) {
            System.out.println(name + ", 收到最新的温度： " + temperature);
        }
    }

    /**
     * 抽象主题
     */
    public interface ISubject {
        public void registerObserver(IObserver o);	//数据源提供用于 （ 观察者想要获取数据源时调用此方法注册）
        public void removeObserver(IObserver o);		//数据源提供用于  （观察者不再需要数据源数据时，退出注册）
    }

    /**
     * 具体主题
     * 气象站台
     */
    public static class WeatherStation implements ISubject {

        private ArrayList<IObserver> observers = new ArrayList<>();

        @Override
        public void registerObserver(IObserver o) {
            observers.add(o);
        }

        @Override
        public void removeObserver(IObserver o) {
            observers.remove(o);
        }

        public void notifyObservers(int temp) {
            int size = observers.size();
            for (int i = 0; i < size; i++) {
                observers.get(i).update(temp);
            }
        }

        /**
         * 更新温度，比如数据从温度传感器获取到
         */
        public void updateTemperature(int temp) {
            notifyObservers(temp);
        }
    }

    public static void main(String[] args) {
        Personnel personnel = new Personnel("slack");
        Personnel jack = new Personnel("Jack");
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.registerObserver(personnel);
        weatherStation.registerObserver(jack);
        
        weatherStation.updateTemperature(20);
        weatherStation.removeObserver(jack);
        weatherStation.updateTemperature(23);
    }
}
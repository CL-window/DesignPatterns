import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyClass {

    /**
     * 静态代理， 以租房为例
     */
    public interface Renting {
        void rentingHouse();
    }

    public static class PeopleA implements Renting {
        @Override
        public void rentingHouse() {
            System.out.println("想要租房...");
        }
    }

    public static class RentingProxy implements Renting {

        private final Renting renting;
        RentingProxy(Renting r) {
            renting = r;
        }

        @Override
        public void rentingHouse() {
            System.out.println("租房中介开始...");
            renting.rentingHouse();
            System.out.println("租房中介结束...");
        }
    }

    /**
     * 动态代理
     */
    public static class DynamicRentingProxy implements InvocationHandler {

        final Object object;
        DynamicRentingProxy(Object object) {
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("动态代理租房中介开始...");
            Object result = method.invoke(object, args);
            System.out.println("动态代理租房中介结束...");
            return result;
        }
    }

    public static void main(String[] args) {
        PeopleA peopleA = new PeopleA();
        peopleA.rentingHouse();

        // 静态代理
        RentingProxy proxy = new RentingProxy(peopleA);
        proxy.rentingHouse();

        // 动态代理
        Renting people = (Renting) Proxy.newProxyInstance(Renting.class.getClassLoader(),
        new Class[]{Renting.class}, new DynamicRentingProxy(peopleA));
        people.rentingHouse();

        
    }
}
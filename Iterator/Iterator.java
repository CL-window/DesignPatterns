import java.util.ArrayList;
/**
 * 迭代器模式使得访问一个聚合对象的内容而无需暴露它的内部表示，即迭代抽象。
 * 迭代器模式为遍历不同的集合结构提供了一个统一的接口，从而支持同样的算法在不同的集合结构上进行操作
 */
public class Iterator {

    //抽象聚合
    public interface Aggregate { 
        public void add(Object obj); 
        public void remove(Object obj); 
        public IIterator getIterator(); 
    }
    //具体聚合
    public static class ConcreteAggregate implements Aggregate { 
        private ArrayList<Object> list=new ArrayList<Object>(); 
        public void add(Object obj) { 
            list.add(obj); 
        }
        public void remove(Object obj) { 
            list.remove(obj); 
        }
        public IIterator getIterator() { 
            return(new ConcreteIterator(list)); 
        }     
    }
    //抽象迭代器
    public interface IIterator {
        Object first();
        Object next();
        boolean hasNext();
    }
    //具体迭代器
    public static class ConcreteIterator implements IIterator { 
        private ArrayList<Object> list=null; 
        private int index=-1; 
        public ConcreteIterator(ArrayList<Object> list) { 
            this.list=list; 
        } 
        public boolean hasNext() { 
            if(index<list.size()-1) { 
                return true;
            }
            else {
                return false;
            }
        }
        public Object first() {
            index=0;
            Object obj=list.get(index);;
            return obj;
        }
        public Object next() { 
            Object obj=null; 
            if(this.hasNext()) { 
                obj=list.get(++index); 
            } 
            return obj; 
        }   
    }

    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate(); 
        ag.add("上海大学"); 
        ag.add("华东理工"); 
        ag.add("上海交大");
        System.out.print("聚合的内容有：");
        IIterator it=ag.getIterator(); 
        while(it.hasNext()) { 
            Object ob=it.next(); 
            System.out.print(ob.toString()+" "); 
        }
        Object ob=it.first();
        System.out.println("\nFirst："+ob.toString());
    }
}
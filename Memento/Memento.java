
public class Memento {

    public static class Memorandum {
        public String state;

        public void setState(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

    //发起人
    public static class Originator { 
        private String state;     
        public void setState(String state) { 
            this.state=state; 
        }
        public String getState() { 
            return state; 
        }
        public Memorandum createMemento() { 
            Memorandum m = new Memorandum();
            m.setState(state);
            return m; 
        } 
        public void restoreMemento(Memorandum m)  { 
            this.setState(m.getState()); 
        } 
    }

    //管理者
    public static class Caretaker { 
        private Memorandum memento;       
        public void setMemento(Memorandum m) { 
            memento=m; 
        }
        public Memorandum getMemento() { 
            return memento; 
        }
    } 
    
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        // 设置状态1
        originator.setState("state1");
        System.out.println(originator.getState());
        // 保存状态1
        caretaker.setMemento(originator.createMemento());
        // 设置状态2
        originator.setState("state2");
        System.out.println(originator.getState());
        // 设置状态3
        originator.setState("state3");
        System.out.println(originator.getState());
        // 恢复状态1
        originator.restoreMemento(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}
/**
 * 以王者荣耀的英雄状态为例
 * 正常状态
 * 走动状态
 * 跑动状态
 * 被控眩晕状态
 * 加速状态
 * 减速状态
 */
public class State {

    public static abstract class IState {
        private String name;
        public IState(String name) {
            this.name = name;
        }

        void print() {
            System.out.println(name + "...");
        }
    }

    public static class RunState extends IState {
        public RunState(){
            super("跑动");
        }
    }

    public static class YunState extends IState {
        public YunState(){
            super("眩晕");
        }
    }

    public static class Hero {

        public void setState(IState state) {
            state.print();        
        }

    }
    public static void main(String[] args) {
        Hero hero = new Hero();

        hero.setState(new RunState());
        hero.setState(new YunState());

    }
}
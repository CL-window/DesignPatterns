import java.util.ArrayList;

public class Composite {

    /**
     * 抽象构件
     */
    public static abstract class Component {
        public String name;
        public Component(String name) {
            this.name = name;
        }

        public void addChild(Component component) {
            //
        }

        public void removeChild(Component component) {
            //
        }

        public Component getChild(int index) {
            return null;
        }

        public abstract String print();
    }

    public static class Branch extends Component {
        private ArrayList<Component> components;
        public Branch(String name) {
            super(name);
            components = new ArrayList<>();
        }

        @Override
        public void addChild(Component component) {
            this.components.add(component);
        }

        @Override
        public void removeChild(Component component) {
            this.components.remove(component);
        }

        @Override
        public Component getChild(int index) {
            return this.components.get(index);
        }

        public String print() {
            StringBuilder builder = new StringBuilder(this.name);
            for (Component component : this.components) {
                builder.append("\n");
                builder.append(component.print());
            }
            return builder.toString();
        }
    }

    public static class Left extends Component {
        public Left(String name) {
            super(name);
        }

        @Override
        public String print() {
            return name;
        }
    }

    public static void main(String[] args) {
        Branch root = new Branch("大树");
        Branch branch1 = new Branch("树枝1");
        Branch branch2 = new Branch("树枝2");
        Left left1 = new Left("叶子1");
        Left left2 = new Left("叶子2");
        Left left3 = new Left("叶子3");

        root.addChild(branch1);
        root.addChild(branch2);
        branch1.addChild(left1);
        branch2.addChild(left2);
        branch2.addChild(left3);
        System.out.println(root.print());
    }
}
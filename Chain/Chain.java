/**
 * 本文以学生请假为例，
 * 假设学生请假时，班主任可以允许2天，系主任可以允许4天，副院长可以允许7天，其他情况要找院长请假
 */
public class Chain {

    /**
     * 抽象处理者
     */
    public static abstract class Leader {

        private String name;
        private Leader next;

        public Leader(String name) {
            this.name = name;
        }

        public void setNext(Leader next) {
            this.next = next;
        }

        public abstract boolean canHandleLeave(int days);

        public void handleLeave(int days) {
            if (canHandleLeave(days)) {
                System.out.println(name + " allow leave..." + days);
            } else {
                if (next != null) {
                    next.handleLeave(days);
                } else {
                    System.out.println("需要联系院长..." + days);
                }
            }
        }
    }

    public static class ClassAdviser extends Leader {
        public ClassAdviser() {
            super("班主任");
        }

        @Override
        public boolean canHandleLeave(int days) {
            if (days > 2) {
                return false;
            }
            return true;
        }

    }

    public static class DepartmentDirector extends Leader {
        public DepartmentDirector() {
            super("系主任");
        }

        @Override
        public boolean canHandleLeave(int days) {
            if (days > 4) {
                return false;
            }
            return true;
        }
    }

    public static class VicePresident extends Leader {
        public VicePresident() {
            super("副院长");
        }

        @Override
        public boolean canHandleLeave(int days) {
            if (days > 7) {
                return false;
            }
            return true;
        }
    }


    public static void main(String[] args) {
        ClassAdviser adviser = new ClassAdviser();
        DepartmentDirector departmentDirector = new DepartmentDirector();
        VicePresident vicePresident = new VicePresident();
        
        adviser.setNext(departmentDirector);
        departmentDirector.setNext(vicePresident);

        adviser.handleLeave(1);
        adviser.handleLeave(6);
        adviser.handleLeave(10);
    }
}
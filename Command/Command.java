/**
 * 遥控电视机，人点击遥控器上的开关，打开电视机， 调整音量
 * 人：请求者
 * 点击遥控器上的开关： 具体的命令
 * 电视机：接收者
 */
public class Command {

    /**
     * 抽象命令类
     */
    public interface ICommand {
        /**
         * 执行命令
         */
        void excude();

        /**
         * 撤销上一条
         */
        void unDo();
    }


    /**
     * 具体命令类
     */
    public static class TVOpenCommand implements ICommand {

        private TV tv;
        public TVOpenCommand(TV tv) {
            this.tv = tv;
        }

        @Override
        public void excude() {
            tv.powerOn();
        }

        @Override
        public void unDo() {
            tv.powerOff();
        }
    }

    /**
     * 接收者
     * 电视机
     */
    public static class TV {

        public void powerOn() {
            System.out.println("Open TV...");
        }

        public void powerOff() {
            System.out.println("Close TV...");
        }
    }


     /**
     * 遥控器
     */
    public static void main(String[] args) {
        TV tv = new TV();
        TVOpenCommand openCommand = new TVOpenCommand(tv);
        openCommand.excude();
        openCommand.unDo();
    }
}
/**
 * 以租房为例，假设没有租房中介，有六个房东需要出租房屋，房屋各不相同、各有各的特点、
 * 适合不一样的人租住。这六个房东之间刚好有点联系。然后都在出租房屋。这时租客A来租房，
 * 看了一号房东的房子不满意、但是一号房东觉得可以让他去看看其他五个朋友的房间。
 * 然后开始联系他的五个朋友。这样运行下去好像有是没有什么问题的。但是其中二号房东如果房屋
 * 不出租或者出租出去了。也就是发生了变化。这是他则需要通知其他五个朋友，告诉他们不用再给
 * 他介绍租客了。这里就造成了中间一个人发生了变化，需要改动其他五个人。那么如何可以解决这种情况呢。
 * 我们回到现在。把中介加进来、那六个房东都把房屋交给中介处理。租客A看房间一不满意直接通过中介看房间二。
 * 当房间二被出租了。中介也只需要通知房东二号、然后他们签订合同。下次还有人看房间就不会再看房间二了。
 * 这里一个出现了变化也就影响改变了一个，并不会影响其他另外五个房东。
 */
public class Mediator {

    /**
     * 抽象同事类
     */
    public static abstract class IColleague {
        public abstract void handle();
    }

    /**
     * 具体同事类
     * 房屋
     */
    public static class House extends IColleague {

        private int houseNum;
        public House(int num) {
            houseNum = num;
        }

        @Override
        public void handle() {
            System.out.println(houseNum + " 间房...");
        }
    }

    /**
     * 抽象中介者
     */
    public static abstract class IMediator {
        public abstract void needHouse(int num);
    }

    /**
     * 具体中介者
     */
    public static class HouseMediator extends IMediator {

        private House one, two, three;
        public HouseMediator() {
            one = new House(1);
            two = new House(2);
            three = new House(3);
        }

        @Override
        public void needHouse(int num) {
            switch (num) {
                case 1:
                    one.handle();
                    break;
                case 2:
                    two.handle();
                    break;
                 case 3:
                    three.handle();
                    break;
                default:
                System.out.println("等一下，查一下系统看看有没有 " + num + " 间房子");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        HouseMediator mediator = new HouseMediator();
        // 模拟找房子
        mediator.needHouse(2);
    }
}
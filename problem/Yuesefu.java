package problem;

/**
 * 循环链表实现约瑟夫圈问题
 *     已知 n 个人（以编号1，2，3…n分别表示）围坐在一张圆桌周围。从编号为 1 的人开始报数，
 * 数到 m 的那个人出列；他的下一个人又从1开始报数，数到 m 的那个人又出列；依此规律重复下去，
 * 直到圆桌周围的人全部出列。
 * Created by Sheldon on 2019/8/17.
 * Project Name: alstudy.
 * Package Name: problem.
 */
public class Yuesefu {

    private int num;       // 编号
    private Yuesefu next;  // 下一个结点

    // 初始化
    public boolean init(int count){
        if (count < 2){
            return false;
        }else {
            Yuesefu node = this;
            Yuesefu next;
            for (int i = 0; i < count; i++){
                node.num = i+1;
                next = new Yuesefu();
                node.next = next;
                node = node.next;
            }
            node.num = this.num;
            node.next = this.next;
            return true;
        }
    }

    // 开始
    public void start(int value){
        Yuesefu node = this.next;
        Yuesefu refnode = new Yuesefu();
        int count = 1;
        while (node.next!=null){
            count += 1;
            if (count == value){
                count = 0;
                System.out.println(node.num);
                refnode.next = node.next;
            }
            refnode = node;
            node = node.next;
            if (node.next == refnode) {
                System.out.println(refnode.num);
                break;
            }
        }
        System.out.println("最后留下的是"+node.num);
    }

    // 测试
    public static void main(String[] args) {
        Yuesefu yuesefu = new Yuesefu();
        yuesefu.init(10);
        // 出厂方式应该是 3-6-9-2-7-1-8-5-10-4
        yuesefu.start(3);
    }

}

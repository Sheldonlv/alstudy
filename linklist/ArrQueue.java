package linklist;

/**
 * 循序队列
 * Created by Sheldon on 2019/4/3.
 * Project Name: alstudy.
 * Package Name: linklist.
 */

// 顺序队列结构
public class ArrQueue {
    // 队列的最大容量
    static final int MAXLEN = 5;
    // 队列数据存储
    private String datas[] = new String[MAXLEN];
    // 队列头
    private int head = 0;
    // 队列尾
    private int tail = 0;

    /**
     * 入队列
     * @Param String
     * @return
     */
    public boolean inQueue(String data){
        // 判断队列满了没
        if (tail==MAXLEN){
            System.out.println("队列满了");
            return false;
        }else {
            // 数据入队列
            datas[tail++] = data;
            return true;
        }
    }

    /**
     * 出队列
     * @return
     */
    public String outQueue(){
        // 检测队列是否空闲
        if (head==tail){
            System.out.println("队列空了");
            return null;
        }else {
            // 数据出队列
            return datas[head++];
        }
    }

    /**
     * 读取队列头
     * @return
     */
    public String peekQueue(){
        if (head==tail){
            System.out.println("队列为空");
            return null;
        }else {
            return datas[head];
        }
    }

    /**
     * 判断队列是否满了
     * @return
     */
    public boolean isFull(){
        return tail==MAXLEN ? true:false;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isNull(){
        return head==tail ? true:false;
    }

    /**
     * 清空队列
     */
    public void clear(){
        head = 0;
        tail = 0;
        System.out.println("队列已清空");
    }

    /**
     * 查看队列长度
     * @return
     */
    public int size(){
        return tail-head;
    }

    public static void main(String[] args) {
        // 创建队列
        ArrQueue queue = new ArrQueue();
        // 入队列
        queue.inQueue("数据1");
        queue.inQueue("数据2");
        queue.inQueue("数据3");
        queue.inQueue("数据4");
        queue.inQueue("数据5");
        queue.inQueue("数据6");
        // 查看对列头
        System.out.println("队列头："+queue.peekQueue());
        // 出队列
        queue.outQueue();
        // 再次查看对列头
        System.out.println("队列头："+queue.peekQueue());
        // 查看队列长度
        System.out.println("队列长度："+queue.size());
        // 清空队列尾
        queue.clear();
        // 查看队列长度
        System.out.println("队列长度："+queue.size());
    }
}

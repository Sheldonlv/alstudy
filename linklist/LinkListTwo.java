package linklist;

/**
 * 双向链表
 * Created by Sheldon on 2019/4/1.
 * Project Name: alstudy.
 * Package Name: linklist.
 */

// 单向链表
class NodeTwo{
    Data data;
    NodeTwo pre;
    NodeTwo next;
}

public class LinkListTwo {

    // 头结点
    NodeTwo head = null;

    /**
     * 追加结点
     * @param data
     * @return
     */
    public boolean addNode(Data data){
        NodeTwo temp = head;
        NodeTwo newNode;
        // 创建新结点对象
        if ((newNode=new NodeTwo())==null){
            System.out.println("申请内存失败！");
        }else {
            // 保存数据
            newNode.data = data;
            if (head==null){
                head = newNode;
                return true;
            }
            // 遍历数组，追加数据
            while (temp.next!=null){
                temp = temp.next;
            }
            // 通过遍历找到最后一个元素，使其后驱指向新结点
            temp.next = newNode;
            // 将新结点的前驱指向‘最后一个元素’
            newNode.pre = temp;
            return true;
        }
        return false;
    }

    /**
     * 查找结点
     * @param key
     */
    public void findByKey(String key){
        NodeTwo temp = head;
        // 遍历结点
        while (temp!=null){
            if (temp.data.key.equals(key)){
                // 打印结点信息
                System.out.println(temp.data.key+"->"+temp.data.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("没有该结点");
    }


    /**
     * 删除结点
     * @param key
     * @return
     */
    public boolean delNode(String key){
        NodeTwo temp = head;
        while (temp!=null){
            if (temp.data.key.equals(key)){
                // 查看该结点是否是头结点
                if (temp==head){
                    // 如果是头结点，将其引用替换成它的后驱
                    head = temp.next;
                    head.pre = null;
                    return true;
                }else {
                    // 将该结点的前驱的‘后驱引用’指向它的后驱
                    // 直接temp = temp.next是无法得到想要的结果的，因为其前驱没发生变化
                    temp.pre.next = temp.next;
                    return true;
                }
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * 显示所有结点
     */
    public void showAllList(){
        NodeTwo temp = head;
        while (temp!=null){
            // 打印结点信息
            System.out.printf(temp.data.key+"->"+temp.data.name+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkListTwo list = new LinkListTwo();
        // 插入结点
        list.addNode(new Data("1","小明"));
        list.addNode(new Data("2","小红"));
        list.addNode(new Data("3","小绿"));
        list.addNode(new Data("4","小黄"));
        // 查看结点效果
        list.showAllList();
        // 查找结点
        list.findByKey("1");
        // 删除结点
        list.delNode("2");
        // 再次查看结点
        list.showAllList();
    }
}

package linklist;

/**
 * 循环链表
 * Created by Sheldon on 2019/4/2.
 * Project Name: alstudy.
 * Package Name: linklist.
 */
// 循环链表数据结构
class Node{
    Data data;
    Node next;
}

public class LinkListLoop {

    Node head;

    /**
     * 追加结点
     * @param data
     * @return
     */
    public boolean addNode(Data data){
        Node temp = head;
        Node newNode;
        if ((newNode=new Node())==null){
            System.out.println("对象创建失败");
            return false;
        }else {
            newNode.data = data;
            if (head==null){
                head = newNode;
                newNode.next = head;
                return true;
            }
            while (temp.next!=head){
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            return true;
        }
    }

    /**
     * 删除结点
     * @param key
     * @return
     */
    public boolean delNodeByKey(String key){
        Node temp = head;
        Node node = head;
        do {
            if (temp.data.key.equals(key)){
                node.next = temp.next;
                return true;
            }
            node = temp;
            temp = temp.next;
        }while (temp!=head);
        return false;
    }

    /**
     * 查找结点
     * @param key
     */
    public void findValueByKey(String key){
        Node temp = head;
        do {
            if (temp.data.key.equals(key)){
                System.out.println(temp.data.key+"->"+temp.data.name);
            }
            temp = temp.next;
        }while(temp!=head);
    }

    /**
     * 打印所有链表结点
     */
    public void showAllList(){
        Node temp = head;
        do{
            System.out.printf(temp.data.key+"->"+temp.data.name+" ");
            temp = temp.next;
        }while(temp!=head);
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkListLoop listLoop = new LinkListLoop();
        // 添加结点
        listLoop.addNode(new Data("1","小明"));
        listLoop.addNode(new Data("2","小红"));
        listLoop.addNode(new Data("3","小黄"));
        // 显示所有结点
        listLoop.showAllList();
        // 删除结点
        listLoop.delNodeByKey("2");
        // 显示所有结点
        listLoop.showAllList();
        // 查找结点
        listLoop.findValueByKey("3");
    }

}

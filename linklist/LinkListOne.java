package linklist;

/**
 * 链表结构（单向）
 * Created by Sheldon on 2019/3/29.
 * Project Name: alstudy.
 * Package Name: linklist.
 */

// 数据对象
class Data{
    String key;
    String name;

    Data(){ }

    Data(String key, String name){
        this.key = key;
        this.name = name;
    }
}

// 单向链表
class NodeOne{
    Data data;
    NodeOne nextNode;
}

// 单向链表操作类
public class LinkListOne {

    // 插入头结点
    public NodeOne addFirst(NodeOne head, Data data){
        NodeOne node;
        // 创建对象
        if ((node = new NodeOne())==null){
            System.out.println("分配内存失败");
            return head;
        }else {
            // 保存数据
            node.data = data;
            // 该引用指向原本的头引用
            node.nextNode = head;
            return node;
        }
    }

    // 追加结点
    public NodeOne addData(NodeOne head, Data data){
        NodeOne node, temp;
        // 创建结点对象
        if ((node=new NodeOne())==null){
            System.out.println("对象创建失败");
            return null;
        }else {
            // 保存数据
            node.data = data;
            // 设置下一个结点为空
            node.nextNode = null;
            // 检测头部是否为空
            if (head==null){
                head = node;
                return head;
            }
            // 头部不为空就查找尾部
            temp = head;
            while (temp.nextNode!=null){
                temp = temp.nextNode;
            }
            temp.nextNode = node;
            return head;
        }
    }

    // 插入结点
    public boolean insertNode(NodeOne head, String key, Data data){
        NodeOne node = head;
        NodeOne temp = head;
        while (temp!=null){
            if (temp.data.key.equals(key)){
                temp.data = data;
                return true;
            }else {
                temp = temp.nextNode;
            }
        }
        return false;
    }

    // 链表反转
    public NodeOne reversal(NodeOne head){
        NodeOne newHead = null;
        NodeOne temp = null;
        while (head!=null){
            temp = head.nextNode;
            head.nextNode = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    // 查找结点
    public NodeOne findNode(NodeOne head, String key){
        NodeOne node = head;
        // 遍历链表数据
        while (node!=null){
            // 对比数据
            if (node.data.key.equals(key)){
                System.out.println(node.data.key+"->"+node.data.name+" ");
                return node;
            }else {
                node = node.nextNode;
            }
        }
        return null;
    }

    // 删除结点
    public NodeOne delList(NodeOne head, String key){
        NodeOne node = head;
        NodeOne temp = head;
        while (temp!=null){
            // 查找关键字
            if (temp.data.key.equals(key)){
                // 将头结点的引用指向关键字的下一个引用
                node.nextNode = temp.nextNode;
                return head;
            }else {
                node = temp;
                // 指向下一个引用
                temp = temp.nextNode;
            }
        }
        return head;
    }

    // 清空链表
    public NodeOne cleadList(NodeOne head){
        return null;
    }

    // 计算链表长度
    public int listSize(NodeOne head){
        int size=0;
        NodeOne node = head;
        // 遍历链表
        while (node!=null){
            // 大小+1
            ++size;
            node = node.nextNode;
        }
        return size;
    }

    // 显示所有结点
    public void showAllList(NodeOne head){
        NodeOne node = head;
        // 遍历链表
        while (node!=null){
            // 打印结点信息
            System.out.printf(node.data.key+"->"+node.data.name+" ");
            node = node.nextNode;
        }
        System.out.println();
    }

    // 测试验证
    public static void main(String[] args) {
        // 创建链表操作对象
        LinkListOne listOne = new LinkListOne();
        // 创建头结点对象
        NodeOne headNode = null;
        // 添加链表对象
        headNode = listOne.addData(headNode, new Data("1","小明"));
        listOne.addData(headNode, new Data("2","小红"));
        listOne.addData(headNode, new Data("3","小兵"));
        listOne.addData(headNode, new Data("4","小黄"));
        // 查看链表数据
        listOne.showAllList(headNode);
        // 新增头引用
        headNode = listOne.addFirst(headNode, new Data("0","小清"));
        // 查看链表数据
        listOne.showAllList(headNode);
        // 链表翻转
        headNode = listOne.reversal(headNode);
        // 查看链表数据
        listOne.showAllList(headNode);
        // 删除链表
        headNode = listOne.delList(headNode, "2");
        // 再查看链表数据
        listOne.showAllList(headNode);
        // 查找单个数据
        listOne.findNode(headNode, "1");
        // 插入数据
        listOne.insertNode(headNode, "1", new Data("1","新小明"));
        // 再查看链表数据
        listOne.showAllList(headNode);
        // 清空链表
        headNode = listOne.cleadList(headNode);
        // 查看链表数据数量情况
        System.out.println(listOne.listSize(headNode));
    }

}

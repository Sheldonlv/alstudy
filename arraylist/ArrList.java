package arraylist;

import java.util.Map;

/**
 * 顺序表简单实现
 * Created by Sheldon on 2019/3/29.
 * Project Name: alstudy.
 * Package Name: arraylist.
 */

// 数据对象
class Data{
    String key;
    String name;

    Data(String key, String name){
        this.key = key;
        this.name = name;
    }
}

public class ArrList {

    // 默认最大长度
    int Max = 100;
    // 对象数组
    Data[] ListData = new Data[Max];
    // 当前长度
    int ListSize;

    // 链表初始化
    ArrList(){
        ListSize = 0;
    }

    // 获取顺序表大小
    public int linkSize(){
        return ListSize;
    }

    // 链表容量检测 true（满了） false（没满）
    public boolean isFull(ArrList list){
        if (list.ListSize >= list.Max){
            return true;
        }else {
            return false;
        }
    }

    // 追加结点
    public boolean addNode(ArrList list, Data data){
        // 检测链表容量
        if (isFull(list)){
            return false;
        }
        // 在数据尾部插入
        list.ListData[list.ListSize++] = data;
        return true;
    }

    // 插入结点
    public boolean insertNode(ArrList list, int index, Data data){
        // 检测链表容量
        if (isFull(list)){
            return false;
        }
        // 查看下标是否越界
        if (index<0 || index>=list.ListSize){
            return false;
        }
        // 条件达成，则在对应位置插入数据
        list.ListData[index] = data;
        return true;
    }

    // 删除结点
    public boolean delNode(ArrList list, int index){
        // 查询结点是否越界
        if (index<0 || index>=list.ListSize){
            return false;
        }
        // 删除对应结点，数据向前位移
        for (int i=index; i < list.ListSize; i++){
            list.ListData[i] = list.ListData[i+1];
        }
        list.ListSize--;
        return true;
    }

    // 查找结点
    public void findNode(ArrList list, int index){
        // 查询结点是否越界
        if (index<0 || index>=list.ListSize){
            System.out.println("下标越界");
        }
        // 打印出数据
        System.out.println("key:"+list.ListData[index].key+" name:"+list.ListData[index].name+"\n");
    }

    // 显示所有结点
    public void findAllNode(ArrList list){
        for (int i=0; i<list.ListSize; i++){
            System.out.println("key:"+list.ListData[i].key+" name:"+list.ListData[i].name);
        }
    }

    public static void main(String[] args) {
        // 创建循序表数组对象
        ArrList list = new ArrList();
        // 添加结点
        list.addNode(list, new Data("1","小明"));
        list.addNode(list, new Data("2","小红"));
        list.addNode(list, new Data("3","小兵"));
        // 查询结点数量
        System.out.println(list.linkSize());
        // 打印单个结点
        list.findNode(list, 1);
        // 打印出所有结点
        list.findAllNode(list);
        // 删除结点
        list.delNode(list, 1);
        // 获取结点数量
        System.out.println(list.linkSize());
        // 打印所有结点
        list.findAllNode(list);
        // 修改其中一个结点
        list.insertNode(list, 0, new Data("1","小红"));
        // 再次打印查看
        list.findAllNode(list);
    }
}

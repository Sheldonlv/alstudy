package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 哈夫曼树
 * Created by Sheldon on 2019/4/11.
 * Project Name: alstudy.
 * Package Name: tree.
 */

// 结点结构
class Node{
    // 权值
    int value;
    // 左结点
    Node leftChild;
    // 右结点
    Node rightChild;

    public Node(int value){
        this.value = value;
    }

    public Node(Node leftChild, Node rightChild){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.value = leftChild.value + rightChild.value;
    }
}

// 哈弗曼树
public class HuffmanTree {

    /**
     * 创建哈弗曼树
     * @param arr
     * @return
     */
    public static Node createHuffmanTree(int arr[]){
        // 将传进来的数组元素创建成结点
        List<Node> nodes = new ArrayList<>();
        for (int value: arr){
            nodes.add(new Node(value));
        }
        // 循环处理以下操作
        while (nodes.size()>1){
            // 依据权值排序（选择排序算法）
            Node temp;
            for (int i=0; i<nodes.size(); i++){
                int k = i;
                for (int j=nodes.size()-1; j>i; j--){
                    if (nodes.get(j).value < nodes.get(k).value){
                        k = j;
                    }
                }
                temp = nodes.get(i);
                nodes.set(i, nodes.get(k));
                nodes.set(k, temp);
            }
            // 取出权值最小的两个二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            // 创建新的二叉树
//            Node parent = new Node(leftNode.value+rightNode.value);
            Node parent = new Node(leftNode, rightNode);
            // 移除取出的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 放入原来的二叉树集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    public static void main(String[] args) {
        int[] arr = {3,7,8,29,5,11,23,14};
        Node root = HuffmanTree.createHuffmanTree(arr);
        System.out.println(root.rightChild.value);
    }
}

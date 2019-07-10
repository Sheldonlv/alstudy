package tree;

/**
 * 红黑树的实现
 * Created by Sheldon on 2019/7/10.
 * Project Name: alstudy.
 * Package Name: tree.
 */

/**
 * 红黑树结点
 * @param <T>
 */
class RBTNode<T extends Comparable<T>>{
    boolean color;       // 颜色
    T key;               // 键值
    RBTNode<T> parent;   // 父节点
    RBTNode<T> left;     // 左节点
    RBTNode<T> right;    // 右节点

    // 初始化
    public RBTNode(boolean color, T key, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right){
        this.color = color;
        this.key = key;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}

/**
 * 红黑树
 * @param <T>
 */
public class RBTree<T extends Comparable<T>>{

    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private RBTNode<T> root;    // 根节点

    // 初始化
    public RBTree(){
        root = null;
    }

    // 判断是否为红色
    private boolean isRed(RBTNode<T> node){
        return ((node!=null)&&(node.color==RED)) ? true : false;
    }

    // 判断是否为黑色
    private boolean isBlack(RBTNode<T> node){
        return ((node!=null)&&(node.color=BLACK)) ? true : false;
    }

    // 设置颜色为红色
    private void setRed(RBTNode<T> node){
        if (node!=null) node.color = RED;
    }

    // 设置颜色为黑色
    private void setBlack(RBTNode<T> node){
        if (node!=null) node.color = BLACK;
    }

    /**
     * 前序遍历红黑树
     * @param node
     */
    private void DLR(RBTNode<T> node){
        if (node != null){
            System.out.print(node.key+" ");
            DLR(node.left);
            DLR(node.right);
        }
    }

    /**
     * 中序遍历红黑树
     * @param node
     */
    private void LDR(RBTNode<T> node){
        if (node != null){
            LDR(node.left);
            System.out.print(node.key+" ");
            LDR(node.right);
        }
    }

    /**
     * 后序遍历红黑树
     * @param node
     */
    private void LRD(RBTNode<T> node){
        if (node != null){
            LRD(node.left);
            LRD(node.right);
            System.out.print(node.key+" ");
        }
    }

    
}

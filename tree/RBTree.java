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

    // 设置颜色为红色
    private void setColorRed(RBTNode<T> node){
        if (node != null) node.color = RED;
    }

    // 设置颜色为黑色
    private void setColorBlack(RBTNode<T> node){
        if (node != null) node.color = BLACK;
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

    /**
     * 递归查找红黑树中键值为key的节点
     * @param x
     * @param key
     * @return
     */
    private RBTNode<T> search(RBTNode<T> x, T key){
        if (x==null) return x;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return search(x.left, key);
        else if (cmp > 0) return search(x.right, key);
        else return x;
    }

    /**
     * 查找红黑树的最小结点
     * @param node
     * @return
     */
    private RBTNode<T> minnode(RBTNode<T> node){
        if (node == null) return null;

        while (node.left != null)
            node = node.left;
        return node;
    }

    public T minnode(){
        RBTNode<T> p = minnode(root);
        if (p != null) return p.key;
        return null;
    }

    /**
     * 查找红黑树的最大结点
     * @param node
     * @return
     */
    private RBTNode<T> maxnode(RBTNode<T> node){
        if (node == null) return null;

        while (node.left != null)
            node = node.right;
        return node;
    }

    public T maxnode(){
        RBTNode<T> p = maxnode(root);
        if (p != null) return p.key;
        return null;
    }

    /**
     * 左旋
     * @param node
     */
    private void leftRotate(RBTNode<T> node){
        RBTNode<T> rightChild = node.right;
        // 将node的右孩子节点指向其右孩子节点的左孩子节点
        node.right = rightChild.left;
        // 将右孩子节点的左孩子节点的父亲指向node
        if (rightChild.left != null){
            rightChild.left.parent = node;
        }
        // 将node的右孩子节点的父亲指向node节点的父亲
        rightChild.parent = node.parent;
        //如果node是根节点，则将根节点设置为其右孩子节点
        if (node.parent == null){
            this.root = rightChild;
        } else {
            //若node是其父节点的左孩子节点
            if (node.parent.left == node){
                node.parent.left = rightChild;
            } else {//若node是其父节点的右孩子节点
                node.parent.right = rightChild;
            }
        }
        //将node设置的右孩子节点的左节点
        rightChild.left = node;
        node.parent = rightChild;
    }

    /**
     * 右旋
     * @param node
     */
    private void rightRotate(RBTNode<T> node){
        // 获取当前结点左子结点
        RBTNode<T> leftChild = node.left;
        // 当前左孩子引用指向其左孩子结点的右孩子结点
        node.left = leftChild.right;
        // 当前结点的左孩子结点的右孩子节点不为null
        if (null != leftChild.right){
            // 其左孩子节点的右孩子结点的父亲指向当前结点
            leftChild.right.parent = node;
        }
        // 将当前node的父亲设置为其左孩子的父亲
        leftChild.parent = node.parent;
        // 如果当前的node是根节点，则将其左孩子设置为根节点
        if (node.parent == null){
            this.root = leftChild;
        }else {
            // 若不是则设置node的左孩子为node父节点的左或右结点
            if (node == node.parent.right){
                node.parent.right = leftChild;
            }else {
                node.parent.left = leftChild;
            }
        }
        // 设置node为左孩子的右节点
        leftChild.right = node;
        // 设置node的父结点为其左孩子
        node.parent = leftChild;
    }

    /**
     * 向红黑树插入结点
     * @param key
     */
    public void insert(T key){
        RBTNode<T> node = new RBTNode<T>(BLACK, key, null, null, null);
        if (node != null) insert(node);
    }

    /**
     * 插入结点
     * @param node
     */
    private void insert(RBTNode<T> node){
        int cmp;
        RBTNode<T> root = this.root;
        RBTNode<T> parent = null;
        // 定位结点添加到哪个父节点下
        while (root != null){
            parent = root;
            cmp = node.key.compareTo(root.key);
            if (cmp < 0)root = root.left;
            else root = root.right;
        }

        node.parent = parent;
        // 表示当前没一个节点， 那么久当新增的节点为根节点
        if (null == parent){
            this.root = node;
        }else {
            // 找出当前父节点下新增节点的位置
            cmp = node.key.compareTo(parent.key);
            if (cmp < 0) parent.left = node;
            else parent.right = node;
        }
        // 设置插入节点的颜色为红色
        node.color = RED;
        // 修正为红黑树
        insertFixUp(node);
    }

    /**
     * 红黑树插入修正
     * @param node
     */
    private void insertFixUp(RBTNode<T> node){
        RBTNode<T> parent, gparent;
        // 节点的父节点存在且为红色
        while (((parent = node.parent) != null)&&isRed(parent)){
            gparent = parent.parent;

            // 如果其祖父节点是空怎么处理
            // 若父节点是祖父节点的左孩子
            if (parent == gparent.left){
                RBTNode<T> uncle = gparent.right;
                if ((uncle != null)&&isRed(uncle)){
                    setColorBlack(uncle);
                    setColorBlack(parent);
                    setColorRed(gparent);
                    node = gparent;
                    continue;
                }

                if (parent.right == node){
                    RBTNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                setColorBlack(parent);
                setColorRed(gparent);
                rightRotate(gparent);
            }else {
                RBTNode<T> uncle = gparent.left;
                if ((uncle != null) && isRed(uncle)){
                    setColorBlack(uncle);
                    setColorBlack(parent);
                    setColorRed(gparent);
                    node = gparent;
                    continue;
                }

                if (parent.left == node){
                    RBTNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                setColorBlack(parent);
                setColorRed(gparent);
                leftRotate(gparent);
            }
        }
        // 维持第一准则：根节点为黑色
        setColorBlack(this.root);
    }

    /**
     * 测试主方法
     * @param args
     */
    public static void main(String[] args) {
        // 创建测试树
        RBTree<Integer> tree = new RBTree<Integer>();
        // 创建结点
        RBTNode<Integer> node1 = new RBTNode<Integer>(RED, 10, null, null, null);
        RBTNode<Integer> node2 = new RBTNode<Integer>(RED, 5, null, null, null);
        RBTNode<Integer> node3 = new RBTNode<Integer>(RED, 9, null, null, null);
        RBTNode<Integer> node4 = new RBTNode<Integer>(RED, 3, null, null, null);
        RBTNode<Integer> node5 = new RBTNode<Integer>(RED, 6, null, null, null);
        // 插入各个结点
        tree.insert(node1);
        tree.insert(node2);
        tree.insert(node3);
        tree.insert(node4);
        tree.insert(node5);
        // 先序遍历输出树
        tree.DLR(tree.root);
    }
}

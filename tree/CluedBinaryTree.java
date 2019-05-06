package tree;

/**
 * 线索二叉树的演示案例
 * Created by Sheldon on 2019/5/6.
 * Project Name: alstudy.
 * Package Name: tree.
 */
// 线索二叉树结点
class ClueNode{
    int value;
    ClueNode left;
    ClueNode right;

    public ClueNode(int value){
        this.value = value;
    }

    /**
     * 添加结点
     * @param node
     */
    public void add(ClueNode node){
        if (node == null){
            return;
        }
        // 当“传入结点的值”比“当前根结点”的值大时
        if (node.value < this.value){
            // 当左子树为空
            if (this.left==null){
                this.left = node;
                // 左子树不为空
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right==null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }
}

// 操作线索二叉树
public class CluedBinaryTree {

    ClueNode root;

    /**
     * 添加二叉树
     * @param node
     */
    public void add(ClueNode node){
        if (root==null){
            root = node;
        }else {
            root.add(node);
        }
    }

    /**
     * 中序遍历（恰好会从小到大排列）
     * @param node
     */
    public void showNode(ClueNode node){
        if(node!=null){
            showNode(node.left);
            System.out.print(node.value+" ");
            showNode(node.right);
        }
    }

    /**
     * 查询结点
     * @param node
     * @param value
     * @return
     */
    public boolean search(ClueNode node, int value){
        if (node==null){
            return false;
        }
        if (node.value == value){
            return true;
        }else if (node.value > value){
            return search(node.left, value);
        }else if (node.value < value){
            return search(node.right, value);
        }
        return false;
    }

    /**
     * 查询最小结点
     * @param node
     * @return
     */
    public ClueNode findMin(ClueNode node){
        if (root!=null){
            if (node.left==null){
                return node;
            }else {
                return findMin(node.left);
            }
        }
        return null;
    }

    /**
     * 查询最大结点
     * @param node
     * @return
     */
    public ClueNode findMax(ClueNode node){
        if (root!=null){
            if (node.right==null){
                return node;
            }else {
                return findMax(node.right);
            }
        }
        return null;
    }

    // 用做测试的主函数
    public static void main(String[] args) {
        // 创建线索二叉树
        CluedBinaryTree clueTree = new CluedBinaryTree();
        int[] arr = new int[]{7,3,10,12,5,1,9};
        // 循环遍历数组，将数据塞进去
        for (int a: arr){
            clueTree.add(new ClueNode(a));
        }
        // 中序遍历
        clueTree.showNode(clueTree.root);
        // 查找结点
        System.out.println(clueTree.search(clueTree.root, 11));
        // 查询最小结点
        System.out.println(clueTree.findMin(clueTree.root).value);
        // 查询最大结点
        System.out.println(clueTree.findMax(clueTree.root).value);
    }
}

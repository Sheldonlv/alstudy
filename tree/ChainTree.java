package tree;

/**
 * 二叉树结构
 * Created by Sheldon on 2019/4/3.
 * Project Name: alstudy.
 * Package Name: tree.
 */

// 二叉树结构
public class ChainTree {

    // 结点数据
    String data;
    // 左子树
    ChainTree leftTree;
    // 右子树
    ChainTree rightTree;
    // 二叉树根结点
    ChainTree root;

    /**
     * 初始化二叉树，向根结点插入数据
     * @param data
     */
    ChainTree(String data){
        this.data = data;
        this.root = this;
    }

    public static ChainTree bulieTree(String[] datas, int index){
        ChainTree node = null;
        if (index<datas.length){
            String value = datas[index];
            if (value=="#"){
                return null;
            }
            node = new ChainTree(value);
//            node.leftTree = bulieTree(datas, 2*index+1);
//            node.rightTree = bulieTree(datas,2*index+2);
            node.addLeftTree(bulieTree(datas, 2*index+1));
            node.addRightTree(bulieTree(datas,2*index+2));
            return node;
        }
        return node;
    }

    /**
     * 添加左子树
     * @return
     */
    public void addLeftTree(ChainTree node){
        leftTree = node;
    }

    /**
     * 添加右子树
     * @return
     */
    public void addRightTree(ChainTree node){
        rightTree = node;
    }

    /**
     * 先序遍历
     * @param root
     */
    public void DLR(ChainTree root){
        ChainTree node = root;
        if (node!=null){
            System.out.printf(node.data+", ");
            DLR(node.leftTree);
            DLR(node.rightTree);
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void LDR(ChainTree root){
        ChainTree node = root;
        if (node!=null){
            LDR(node.leftTree);
            System.out.printf(node.data+", ");
            LDR(node.rightTree);
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void LRD(ChainTree root){
        ChainTree node = root;
        if (node!=null){
            LRD(node.leftTree);
            LRD(node.rightTree);
            System.out.printf(node.data+", ");
        }
    }

    /**
     * 二叉树深度
     * @param node
     * @return
     */
    public int depth(ChainTree node){
        int depleft, depright;
        if (node==null){
            return 0;
        }else {
            depleft = depth(node.leftTree);
            depright = depth(node.rightTree);
            if (depleft>depright){
                return depleft+1;
            }else {
                return depright+1;
            }
        }
    }

    public static void main(String[] args) {
        String[] datas = new String[]{"0","1","2","3","4","5","6","7","8","9","10"};
        // 构建双叉树
        ChainTree chainTree = bulieTree(datas,0);
        // 先序遍历（中->左->右）
        chainTree.DLR(chainTree.root);
        System.out.println();
        // 中序遍历（左->右->中）
        chainTree.LDR(chainTree.root);
        System.out.println();
        // 后序遍历（左->右->中）
        chainTree.LRD(chainTree.root);
        System.out.println();
        // 二叉树深度
        System.out.println(chainTree.depth(chainTree.root));;
    }
}

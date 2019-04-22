package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sheldon on 2019/4/11.
 * Project Name: alstudy.
 * Package Name: tree.
 */
// 数据类
class Data{
    public char key;
    public int value;
    public Data(char key, int value){
        this.key = key;
        this.value = value;
    }
}

// 结点结构
class CodeNode{
    // 权值
    Data data;
    // 左结点
    CodeNode leftChild;
    // 右结点
    CodeNode rightChild;

    public CodeNode(Data data){
        this.data = data;
    }

    public CodeNode(Data data, CodeNode leftChild, CodeNode rightChild){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }
}

public class HuffmanCode {

    /**
     * 创建哈弗曼树
     * @param datas
     * @return
     */
    public static CodeNode createHuffmanTree(Data[] datas){
        // 将传进来的数组元素创建成结点
        List<CodeNode> nodes = new ArrayList<>();
        for (Data d: datas){
            nodes.add(new CodeNode(d));
        }
        // 循环处理以下操作
        while (nodes.size()>1){
            // 依据权值排序（选择排序算法）
            CodeNode temp;
            for (int i=0; i<nodes.size(); i++){
                int k = i;
                for (int j=nodes.size()-1; j>i; j--){
                    if (nodes.get(j).data.value < nodes.get(k).data.value){
                        k = j;
                    }
                }
                temp = nodes.get(i);
                nodes.set(i, nodes.get(k));
                nodes.set(k, temp);
            }
            // 取出权值最小的两个二叉树
            CodeNode leftNode = nodes.get(0);
            CodeNode rightNode = nodes.get(1);
            // 创建新的二叉树
            Data d = new Data('#', leftNode.data.value+rightNode.data.value);
            CodeNode parent = new CodeNode(d, leftNode, rightNode);
            // 移除取出的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 放入原来的二叉树集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    static StringBuilder sb = new StringBuilder();          // 存储编码字符
    static Map<String, String> huffcodes = new HashMap<>();  // 存储编码表

    /**
     * 创建哈夫曼编码编码表
     * @param codeNode
     * @return
     */
    public static Map<String, Integer> createCode(CodeNode codeNode){
        if (codeNode==null){
            return null;
        }
        getCode(codeNode.leftChild, "0", sb);
        getCode(codeNode.rightChild, "1", sb);
        return null;
    }

    public static void getCode(CodeNode codeNode, String code, StringBuilder sb){
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (codeNode.data==null||codeNode.data.key=='#'){
            getCode(codeNode.leftChild,"0",sb2);
            getCode(codeNode.rightChild,"1",sb2);
        }else {
            huffcodes.put(String.valueOf(codeNode.data.key),sb2.toString());
        }
    }

    public static void main(String[] args) {
        String plaintext = "aabbbcaacd";
        char[] ch = plaintext.toCharArray();
        Map<String,Integer> textMap = new HashMap<>();
        // 统计字符出现次数
        for (char c : ch) {
            String cTo = String.valueOf(c);
            if (!textMap.containsKey(cTo)) {
                textMap.put(cTo, 1);
            } else {
                textMap.put(cTo, textMap.get(cTo) + 1);
            }
        }
        System.out.println(textMap.entrySet());
        // 创建结点数组
        Data[] datas = new Data[textMap.size()];
        int i = 0;
        // 结点数组的元素对象创建
        for (Map.Entry<String, Integer> entry: textMap.entrySet()) {
            datas[i] = new Data(entry.getKey().charAt(0),entry.getValue());
            i++;
        }
        // 创建哈夫曼树
        CodeNode root = HuffmanCode.createHuffmanTree(datas);
        // 创建哈夫曼编码表
        HuffmanCode.createCode(root);
        // 输出哈夫曼树
        System.out.println(HuffmanCode.huffcodes);
        StringBuilder textSb = new StringBuilder();
        // 加密文本信息
        for (char c: ch) {
            textSb.append(HuffmanCode.huffcodes.get(String.valueOf(c)));
        }
        // 输出加密前的信息
        System.out.println("加密前："+plaintext);
        // 输出加密后的信息
        System.out.println("加密后："+textSb);
    }
}

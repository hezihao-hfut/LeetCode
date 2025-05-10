package leetcode.tree;

/**
 * 线索二叉树节点定义
 */
public class ThreadedTreeNode {
    public int val;
    public ThreadedTreeNode left;
    public ThreadedTreeNode right;
    public boolean ltag; // 左标志位, true表示指向前驱/后继(线索), false表示指向孩子
    public boolean rtag; // 右标志位, true表示指向前驱/后继(线索), false表示指向孩子

    public ThreadedTreeNode(int val) {
        this.val = val;
        this.ltag = true; // 默认为线索
        this.rtag = true; // 默认为线索
    }
} 
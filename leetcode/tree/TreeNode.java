package leetcode.tree;

/**
 * 二叉树节点定义
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    /**
     * 先序遍历当前节点为根的子树（直接打印）
     * 访问顺序：根节点 -> 左子树 -> 右子树
     */
    public void preorderTraversal() {
        System.out.println("先序遍历结果：");
        preorderTraversal(this);
        System.out.println();
    }
    
    private void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // 根节点
        System.out.print(node.val + " ");
        // 左子树
        preorderTraversal(node.left);
        // 右子树
        preorderTraversal(node.right);
    }
    
    /**
     * 中序遍历当前节点为根的子树（直接打印）
     * 访问顺序：左子树 -> 根节点 -> 右子树
     */
    public void inorderTraversal() {
        System.out.println("中序遍历结果：");
        inorderTraversal(this);
        System.out.println();
    }
    
    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // 左子树
        inorderTraversal(node.left);
        // 根节点
        System.out.print(node.val + " ");
        // 右子树
        inorderTraversal(node.right);
    }
    
    /**
     * 后序遍历当前节点为根的子树（直接打印）
     * 访问顺序：左子树 -> 右子树 -> 根节点
     */
    public void postorderTraversal() {
        System.out.println("后序遍历结果：");
        postorderTraversal(this);
        System.out.println();
    }
    
    private void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // 左子树
        postorderTraversal(node.left);
        // 右子树
        postorderTraversal(node.right);
        // 根节点
        System.out.print(node.val + " ");
    }
} 
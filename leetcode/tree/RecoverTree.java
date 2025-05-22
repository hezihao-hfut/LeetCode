package leetcode.tree;

/**
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root，该树中的恰好两个节点的值被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 */
public class RecoverTree {
    /**
     * 使用中序遍历找到被交换的节点
     * @param root 根节点
     */
    public void recoverTree(TreeNode root) {
        // 待实现
    }
    
    /**
     * 使用O(1)空间的Morris遍历
     * @param root 根节点
     */
    public void recoverTreeMorris(TreeNode root) {
        // 待实现
    }
    
    public static void main(String[] args) {
        RecoverTree solution = new RecoverTree();
        
        // 测试用例1: [1,3,null,null,2] 应该恢复成 [3,1,null,null,2]
        Integer[] nums1 = {1, 3, null, null, 2};
        TreeNode root1 = BuildTree.buildTree(nums1);
        System.out.println("交换前中序遍历:");
        root1.inorderTraversal();
        
        solution.recoverTree(root1);
        
        System.out.println("交换后中序遍历:");
        root1.inorderTraversal();
        
        // 测试用例2: [3,1,4,null,null,2] 应该恢复成 [2,1,4,null,null,3]
        Integer[] nums2 = {3, 1, 4, null, null, 2};
        TreeNode root2 = BuildTree.buildTree(nums2);
        System.out.println("交换前中序遍历:");
        root2.inorderTraversal();
        
        solution.recoverTree(root2);
        
        System.out.println("交换后中序遍历:");
        root2.inorderTraversal();
    }
} 
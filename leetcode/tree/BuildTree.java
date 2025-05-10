package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树节点定义
 */
// Removed TreeNode class definition

public class BuildTree {
    
    /**
     * 根据层序遍历的数组构建二叉树
     * 数组表示的是完全二叉树，null表示该位置没有节点
     * 例如: [3,9,20,null,null,15,7] 表示的二叉树如下:
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 
     * @param nums 表示层序遍历结果的数组，其中null表示缺失的节点
     * @return 构建好的二叉树的根节点
     */
    public static TreeNode buildTree(Integer[] nums) {
        if (nums == null || nums.length == 0 || nums[0] == null) {
            return null;
        }
        
        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < nums.length) {
            TreeNode node = queue.poll();
            
            // 构建左子节点
            if (i < nums.length) {
                Integer leftVal = nums[i++];
                if (leftVal != null) {
                    node.left = new TreeNode(leftVal);
                    queue.offer(node.left);
                }
            }
            
            // 构建右子节点
            if (i < nums.length) {
                Integer rightVal = nums[i++];
                if (rightVal != null) {
                    node.right = new TreeNode(rightVal);
                    queue.offer(node.right);
                }
            }
        }
        
        return root;
    }
    
    /**
     * 前序遍历打印二叉树 (根-左-右)
     */
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    
    /**
     * 中序遍历打印二叉树 (左-根-右)
     */
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }
    
    /**
     * 后序遍历打印二叉树 (左-右-根)
     */
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }
    
    /**
     * 层序遍历打印二叉树
     */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }
    
    /**
     * 测试构建二叉树和遍历方法
     */
    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildTree(nums);
        
        System.out.print("前序遍历: ");
        preOrderTraversal(root);
        System.out.println();
        
        System.out.print("中序遍历: ");
        inOrderTraversal(root);
        System.out.println();
        
        System.out.print("后序遍历: ");
        postOrderTraversal(root);
        System.out.println();
        
        System.out.print("层序遍历: ");
        levelOrderTraversal(root);
        System.out.println();
    }
}

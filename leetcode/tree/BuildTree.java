package leetcode.tree;

import java.util.*;

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
        if (nums == null || nums.length == 0) return null;
        
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
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void preOrderTraversal2(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.print(curr.val + " ");
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }
    
    /**
     * 中序遍历打印二叉树 (左-根-右)
     */
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static void inOrderTraversal2(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root.left != null) {
                root = root.left;
                stack.push(root);
            }
            root = stack.pop();
            System.out.print(root.val + " ");
            if (root.right != null) {
                stack.push(root.right);
                root = root.right;
            }
        }
    }
    
    /**
     * 后序遍历打印二叉树 (左-右-根)
     */
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void postOrderTraversal2(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }
        // 使用Collections.reverse()方法，原地反转
        Collections.reverse(result);

        // 使用reversed()方法，创建一个新的列表，并反转它
        //result = result.reversed();
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }
    
    /**
     * 层序遍历打印二叉树
     */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) return;
        
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
        
        System.out.println("前序遍历: ");
        preOrderTraversal(root);
        System.out.println();
        preOrderTraversal2(root);
        System.out.println();
        
        System.out.println("中序遍历: ");
        inOrderTraversal(root);
        System.out.println();
        inOrderTraversal2(root);
        System.out.println();
        
        System.out.println("后序遍历: ");
        postOrderTraversal(root);
        System.out.println();
        postOrderTraversal2(root);
        System.out.println();
        
        System.out.println("层序遍历: ");
        levelOrderTraversal(root);
        System.out.println();
    }
}

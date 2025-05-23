package leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class IsValidBST {
    /**
     * 递归法，判断每个节点是否在(min, max)范围内
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) return true;
        if (left != null && root.val <= left.val) return false;
        if (right != null && root.val >= right.val) return false;
        return isValid(root.left, left, root) && isValid(root.right, root, right);
    }

    /**
     * 中序遍历，判断是否有序
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        long pre_num = Long.MIN_VALUE;
        TreeNode curr = root;
        while (curr != null || !deque.isEmpty()) {
            while (curr != null) {
                deque.offerFirst(curr);
                curr = curr.left;
            }
            curr = deque.pollFirst();
            if (curr.val <= pre_num) return false;
            pre_num = curr.val;
            curr = curr.right;
        }
        return true;
    }

    public static void main(String[] args) {
        IsValidBST solution = new IsValidBST();

        Integer[] nums = {2, 1, 3};
        TreeNode root = BuildTree.buildTree(nums);
        System.out.println(solution.isValidBST(root));

        nums = new Integer[]{5, 1, 4, null, null, 3, 6};
        root = BuildTree.buildTree(nums);
        System.out.println(solution.isValidBST(root));

        nums = new Integer[]{5,4,6,null,null,3,7};
        root = BuildTree.buildTree(nums);
        System.out.println(solution.isValidBST(root));
    }
}
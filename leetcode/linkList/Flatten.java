package leetcode.linkList;

import leetcode.tree.BuildTree;
import leetcode.tree.TreeNode;

/*
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if (root != null) {
            flatten(root.left);
            flatten(root.right);
            if (root.left != null) {
                TreeNode left_child = root.left;
                while (left_child.right != null)
                    left_child = left_child.right;
                left_child.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }
    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();

        Integer[] nums = {1,2,5,3,4,null,6};
        TreeNode root = BuildTree.buildTree(nums);
        flatten.flatten(root);
        BuildTree.inOrderTraversal(root);
        System.out.println();

        Integer[] nums2 = {null};
        TreeNode root2 = BuildTree.buildTree(nums2);
        flatten.flatten(root2);
        BuildTree.inOrderTraversal(root2);
        System.out.println();

        Integer[] nums3 = {0};
        TreeNode root3 = BuildTree.buildTree(nums3);
        flatten.flatten(root3);
        BuildTree.inOrderTraversal(root3);
        System.out.println();
    }
}

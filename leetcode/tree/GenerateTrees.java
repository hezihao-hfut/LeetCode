package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 * 可以按 任意顺序 返回答案。
 */
public class GenerateTrees {
    /**
     * 递归生成所有不同的二叉搜索树
     * @param n 节点个数
     * @return 所有可能的BST根节点列表
     */
    public List<TreeNode> generateTrees(int n) {
        // 待实现
        return new ArrayList<>();
    }
    
    /**
     * 打印树的结构
     * @param root 根节点
     */
    private void printTree(TreeNode root) {
        System.out.print("前序遍历: ");
        root.preorderTraversal();
        System.out.print("中序遍历: ");
        root.inorderTraversal();
        System.out.println("------------------------");
    }
    
    public static void main(String[] args) {
        GenerateTrees solution = new GenerateTrees();
        
        // 测试用例1: n = 3
        int n1 = 3;
        System.out.println("n = " + n1 + " 时，所有不同的二叉搜索树:");
        List<TreeNode> trees1 = solution.generateTrees(n1);
        System.out.println("总共生成 " + trees1.size() + " 棵不同的树");
        for (TreeNode root : trees1) {
            solution.printTree(root);
        }
        
        // 测试用例2: n = 1
        int n2 = 1;
        System.out.println("n = " + n2 + " 时，所有不同的二叉搜索树:");
        List<TreeNode> trees2 = solution.generateTrees(n2);
        System.out.println("总共生成 " + trees2.size() + " 棵不同的树");
        for (TreeNode root : trees2) {
            solution.printTree(root);
        }
    }
} 
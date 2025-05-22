package leetcode.tree;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 */
public class NumTrees {
    /**
     * 动态规划方法
     * @param n 节点个数
     * @return 不同二叉搜索树的数量
     */
    public int numTrees(int n) {
        // 待实现
        return 0;
    }
    
    /**
     * 数学公式方法（卡特兰数）
     * @param n 节点个数
     * @return 不同二叉搜索树的数量
     */
    public int numTreesMath(int n) {
        // 待实现
        return 0;
    }
    
    public static void main(String[] args) {
        NumTrees solution = new NumTrees();
        
        // 测试用例1: n = 3
        // 输出应为: 5
        int n1 = 3;
        System.out.println("n = " + n1 + " 时，不同的二叉搜索树数量: " + solution.numTrees(n1));
        
        // 测试用例2: n = 1
        // 输出应为: 1
        int n2 = 1;
        System.out.println("n = " + n2 + " 时，不同的二叉搜索树数量: " + solution.numTrees(n2));
        
        // 测试用例3: n = 4
        // 输出应为: 14
        int n3 = 4;
        System.out.println("n = " + n3 + " 时，不同的二叉搜索树数量: " + solution.numTrees(n3));
        
        // 测试用例4: n = 19 (验证大数值)
        // 输出应为: 1767263190
        int n4 = 19;
        System.out.println("n = " + n4 + " 时，不同的二叉搜索树数量: " + solution.numTrees(n4));
    }
} 
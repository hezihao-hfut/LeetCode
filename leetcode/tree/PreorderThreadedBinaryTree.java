package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义线索二叉树节点
 */
class ThreadedTreeNode {
    int val;
    ThreadedTreeNode left;
    ThreadedTreeNode right;
    boolean ltag; // 左标志位, true表示指向前驱/后继(线索), false表示指向孩子
    boolean rtag; // 右标志位, true表示指向前驱/后继(线索), false表示指向孩子

    ThreadedTreeNode(int val) {
        this.val = val;
        this.ltag = true; // 默认为线索
        this.rtag = true; // 默认为线索
    }
}

public class PreorderThreadedBinaryTree {

    private static ThreadedTreeNode pre = null; // 用于线索化过程，记录前驱节点

    /**
     * 将普通二叉树转换为先序线索二叉树 (核心方法)
     * @param node 普通二叉树的当前节点
     * @param threadedNode 线索二叉树的对应节点
     */
    private static void buildThreading(TreeNode node, ThreadedTreeNode threadedNode) {
        if (node == null || threadedNode == null) {
            return;
        }

        // 1. 处理当前节点与前驱节点的关系
        // 如果当前节点没有左孩子，设置前驱线索 (虽然先序遍历通常不用左线索找后继，但可以设置)
        if (node.left == null) {
            threadedNode.ltag = true; // 标记为线索
            // threadedNode.left = pre; // 指向前驱 (先序前驱意义不大，通常不设置)
        } else {
            threadedNode.ltag = false; // 标记为孩子指针
        }

        // 如果前驱节点没有右孩子，设置后继线索
        if (pre != null && pre.rtag) { // pre.rtag == true 意味着 pre.right 原本是空的
            pre.right = threadedNode; // 将 pre 的右线索指向当前节点 (后继)
        }

        // 更新 pre 为当前节点，为下一个节点服务
        pre = threadedNode;

        // 2. 递归处理左子树
        if (node.left != null) {
            threadedNode.left = new ThreadedTreeNode(node.left.val);
            buildThreading(node.left, threadedNode.left);
        }

        // 3. 递归处理右子树
        if (node.right != null) {
            threadedNode.rtag = false; // 标记为孩子指针
            threadedNode.right = new ThreadedTreeNode(node.right.val);
            buildThreading(node.right, threadedNode.right);
        }
    }

    /**
     * 构建先序线索二叉树的入口方法
     * @param root 普通二叉树的根节点
     * @return 先序线索化后的二叉树根节点
     */
    public static ThreadedTreeNode createPreorderThreadedTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        ThreadedTreeNode threadedRoot = new ThreadedTreeNode(root.val);
        pre = null; // 重置前驱节点
        buildThreading(root, threadedRoot);

        // 处理最后一个节点，其后继线索应指向 null (或特定结束标记)
        if (pre != null) {
            pre.rtag = true; // 最后一个节点的右指针一定是线索
            pre.right = null; // 指向 null
        }
        return threadedRoot;
    }

    /**
     * 使用先序线索遍历二叉树 (非递归)
     * @param root 线索二叉树的根节点
     * @return 遍历结果列表
     */
    public static List<Integer> preorderTraversalWithThreads(ThreadedTreeNode root) {
        List<Integer> result = new ArrayList<>();
        ThreadedTreeNode current = root;

        while (current != null) {
            // 1. 访问当前节点
            result.add(current.val);

            // 2. 移动到下一个节点
            if (!current.ltag) { // 如果有左孩子，则下一个访问的是左孩子
                current = current.left;
            } else { // 如果没有左孩子(ltag=true)，或者左指针是线索
                     // 则下一个访问的是右孩子或右线索指向的后继节点
                current = current.right;
                // 注意：这里不需要检查 rtag，因为无论是右孩子还是右线索，
                // 在先序遍历中，它们都是当前节点的直接后继（或后继路径上的第一个节点）
            }
        }
        return result;
    }

    /**
     * 主函数 - 测试示例
     */
    public static void main(String[] args) {
        // 输入数组: [1, 2, 3, 4, null, 5, 6]
        // 对应的普通二叉树结构:
        //      1
        //     / \
        //    2   3
        //   /   / \
        //  4   5   6
        Integer[] nums = {1, 2, 3, 4, null, 5, 6};
        TreeNode root = BuildTree.buildTree(nums); // 使用之前创建的 BuildTree 工具类

        System.out.println("原始树 (中序遍历验证结构):");
        BuildTree.inOrderTraversal(root); // 输出: 4 2 1 5 3 6
        System.out.println("\n原始树 (先序遍历):");
        BuildTree.preOrderTraversal(root); // 输出: 1 2 4 3 5 6
        System.out.println();


        // 进行先序线索化
        ThreadedTreeNode threadedRoot = createPreorderThreadedTree(root);

        // 使用线索进行先序遍历
        System.out.println("\n使用线索进行先序遍历:");
        List<Integer> threadedResult = preorderTraversalWithThreads(threadedRoot);
        System.out.println(threadedResult); // 预期输出: [1, 2, 4, 3, 5, 6]

        // --- 另一个例子 ---
        // 输入数组: [5, 3, 8, 1, 4, 7, 9, null, 2]
        // 对应的普通二叉树结构:
        //         5
        //        / \
        //       3   8
        //      / \ / \
        //     1  4 7  9
        //      \
        //       2
        Integer[] nums2 = {5, 3, 8, 1, 4, 7, 9, null, 2};
        TreeNode root2 = BuildTree.buildTree(nums2);

        System.out.println("\n===== 示例 2 =====");
        System.out.println("原始树 (中序遍历验证结构):");
        BuildTree.inOrderTraversal(root2); // 输出: 1 2 3 4 5 7 8 9
        System.out.println("\n原始树 (先序遍历):");
        BuildTree.preOrderTraversal(root2); // 输出: 5 3 1 2 4 8 7 9
        System.out.println();

        // 进行先序线索化
        ThreadedTreeNode threadedRoot2 = createPreorderThreadedTree(root2);

        // 使用线索进行先序遍历
        System.out.println("\n使用线索进行先序遍历:");
        List<Integer> threadedResult2 = preorderTraversalWithThreads(threadedRoot2);
        System.out.println(threadedResult2); // 预期输出: [5, 3, 1, 2, 4, 8, 7, 9]
    }
}
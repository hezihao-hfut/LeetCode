package leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；
 * 此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。
 * 
 * 任何多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
 * 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * 
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * 
 * 1. 始终以斜杠 '/' 开头。
 * 2. 两个目录名之间必须只有一个斜杠 '/' 。
 * 3. 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 4. 路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 
 * 返回简化后得到的 规范路径 。
 */
public class SimplifyPath {

    /**
     * 简化路径
     * @param path 路径
     * @return 简化后的路径
     */
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        String[] paths = path.split("/");
        Deque<String> pathName = new ArrayDeque<>();
        for (String i : paths) {
            if (!i.isEmpty()) {
                if (i.equals(".")) continue;
                else if (i.equals("..")) {
                    pathName.pollLast();
                    continue;
                }
                pathName.offerLast(i);
            }
        }
        if (pathName.isEmpty()) return "/";
        for (String i : pathName) {
            result.append('/');
            result.append(i);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home/"));
        System.out.println(simplifyPath.simplifyPath("/../"));
        System.out.println(simplifyPath.simplifyPath("/home//foo/"));
        System.out.println(simplifyPath.simplifyPath("/.../a/../b/c/../d/./"));
    }
}

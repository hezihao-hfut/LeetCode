package leetcode.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Java 编程笔记本
 * 记录一些常用的 Java 编程知识和示例代码
 */
public class JavaNotebook {
    /**
     * HashMap 用法示例
     */
    public void hashMapUsage() {
        Map<String, Integer> map = new HashMap<>();
        
        // 添加元素
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);
        
        // 获取元素
        System.out.println("apple的数量: " + map.get("apple")); // 输出: 1
        
        // 检查是否包含某个键
        System.out.println("是否包含apple: " + map.containsKey("apple")); // 输出: true
        
        // 遍历
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        

        // 删除元素
        map.remove("banana");
        System.out.println("移除banana后大小: " + map.size()); // 输出: 2

        // 键遍历
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // 值遍历
        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }
        
        // 清空HashMap
        map.clear();
        System.out.println("清空后大小: " + map.size()); // 输出: 0
    }
    
    /**
     * ArrayList 用法示例
     */
    public void arrayListUsage() {
        // 使用 List 接口声明，ArrayList 实现
        List<String> fruits = new ArrayList<>();
        
        // 添加元素
        fruits.add("苹果");
        fruits.add("香蕉");
        fruits.add("橙子");
        System.out.println("水果列表: " + fruits); // 输出: [苹果, 香蕉, 橙子]
        
        // 在指定位置插入元素
        fruits.add(1, "葡萄");
        System.out.println("添加葡萄后: " + fruits); // 输出: [苹果, 葡萄, 香蕉, 橙子]
        
        // 获取元素
        System.out.println("索引1的水果: " + fruits.get(1)); // 输出: 葡萄
        
        // 修改元素
        fruits.set(0, "红苹果");
        System.out.println("修改后的列表: " + fruits); // 输出: [红苹果, 葡萄, 香蕉, 橙子]
        
        // 删除元素
        fruits.remove("香蕉");
        System.out.println("移除香蕉后: " + fruits); // 输出: [红苹果, 葡萄, 橙子]
        
        // 通过索引删除
        fruits.remove(0);
        System.out.println("移除索引0后: " + fruits); // 输出: [葡萄, 橙子]
        
        // 检查是否包含元素
        System.out.println("是否包含橙子: " + fruits.contains("橙子")); // 输出: true
        
        // 获取列表大小
        System.out.println("列表大小: " + fruits.size()); // 输出: 2
        
        // 遍历列表
        System.out.println("使用for循环遍历:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println("索引 " + i + ": " + fruits.get(i));
        }
        
        // 使用增强for循环遍历
        System.out.println("使用增强for循环遍历:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        // 列表转换为数组
        String[] fruitArray = fruits.toArray(new String[0]);
        System.out.println("转换为数组后第一个元素: " + fruitArray[0]);
        
        // 清空列表
        fruits.clear();
        System.out.println("清空后大小: " + fruits.size()); // 输出: 0
        
        // 从其他集合创建ArrayList
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        
        List<Integer> copyOfNumbers = new ArrayList<>(numbers);
        System.out.println("复制的列表: " + copyOfNumbers); // 输出: [1, 2, 3]
    }
    
    /**
     * HashSet 用法示例
     */
    public void hashSetUsage() {
        // 使用 Set 接口声明，HashSet 实现
        Set<String> set = new HashSet<>();
        
        // 添加元素
        set.add("苹果");
        set.add("香蕉");
        set.add("橙子");
        System.out.println("水果集合: " + set);
        
        // 尝试添加重复元素（不会添加成功）
        boolean added = set.add("苹果");
        System.out.println("添加重复元素'苹果'是否成功: " + added); // 输出: false
        System.out.println("添加重复元素后的集合: " + set);
        
        // 检查元素是否存在
        System.out.println("集合是否包含'香蕉': " + set.contains("香蕉")); // 输出: true
        
        // 删除元素
        set.remove("香蕉");
        System.out.println("移除'香蕉'后: " + set);
        
        // 获取集合大小
        System.out.println("集合大小: " + set.size());
        
        // 遍历集合
        System.out.println("遍历集合:");
        for (String item : set) {
            System.out.println(item);
        }
        
        // 集合转数组
        String[] array = set.toArray(new String[0]);
        System.out.println("转换为数组后的第一个元素: " + array[0]);
        
        // 从其他集合创建HashSet
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2); // 注意这里有重复元素
        numbers.add(3);
        
        Set<Integer> numberSet = new HashSet<>(numbers);
        System.out.println("从列表创建的集合: " + numberSet); // 输出: [1, 2, 3]，重复的2只保留一个
        
        // 集合操作
        Set<String> set1 = new HashSet<>();
        set1.add("苹果");
        set1.add("香蕉");
        
        Set<String> set2 = new HashSet<>();
        set2.add("香蕉");
        set2.add("橙子");
        
        // 复制set1，然后计算并集
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("并集: " + union); // 输出: [苹果, 香蕉, 橙子]
        
        // 复制set1，然后计算交集
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("交集: " + intersection); // 输出: [香蕉]
        
        // 复制set1，然后计算差集
        Set<String> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("差集: " + difference); // 输出: [苹果]
        
        // 清空集合
        set.clear();
        System.out.println("清空后的集合大小: " + set.size()); // 输出: 0
    }
    
    /**
     * Arrays 工具类用法示例
     */
    public void arraysUsage() {
        // 创建数组
        int[] numbers = {5, 3, 9, 1, 7, 2};
        String[] fruits = {"苹果", "香蕉", "橙子", "葡萄"};
        
        // 输出数组 - toString方法
        System.out.println("整数数组: " + Arrays.toString(numbers)); // 输出: [5, 3, 9, 1, 7, 2]
        System.out.println("字符串数组: " + Arrays.toString(fruits)); // 输出: [苹果, 香蕉, 橙子, 葡萄]
        
        // 数组排序 - sort方法
        Arrays.sort(numbers);
        System.out.println("排序后的整数数组: " + Arrays.toString(numbers)); // 输出: [1, 2, 3, 5, 7, 9]
        
        Arrays.sort(fruits);
        System.out.println("排序后的字符串数组: " + Arrays.toString(fruits)); // 输出: [葡萄, 橙子, 苹果, 香蕉] (按照字典序)
        
        // 二分查找 - binarySearch方法 (要求数组已排序)
        int index = Arrays.binarySearch(numbers, 5);
        System.out.println("数字5的索引: " + index);
        
        // 数组填充 - fill方法
        int[] filledArray = new int[5];
        Arrays.fill(filledArray, 10);
        System.out.println("填充数组: " + Arrays.toString(filledArray)); // 输出: [10, 10, 10, 10, 10]
        
        // 部分填充
        int[] partialFilled = new int[5];
        Arrays.fill(partialFilled, 1, 4, 8); // 索引1到3填充为8
        System.out.println("部分填充数组: " + Arrays.toString(partialFilled)); // 输出: [0, 8, 8, 8, 0]
        
        // 数组复制 - copyOf方法
        int[] copiedArray = Arrays.copyOf(numbers, numbers.length);
        System.out.println("复制的数组: " + Arrays.toString(copiedArray));
        
        // 指定新长度的复制（可扩展或截断）
        int[] extendedArray = Arrays.copyOf(numbers, numbers.length + 2); // 扩展2个元素
        System.out.println("扩展的数组: " + Arrays.toString(extendedArray)); // 新元素默认为0
        
        int[] shortenedArray = Arrays.copyOf(numbers, 3); // 只复制前3个元素
        System.out.println("截断的数组: " + Arrays.toString(shortenedArray));
        
        // 数组部分复制 - copyOfRange方法
        int[] partialCopy = Arrays.copyOfRange(numbers, 2, 5); // 复制索引2到4
        System.out.println("部分复制的数组: " + Arrays.toString(partialCopy));
        
        // 数组比较 - equals方法
        int[] numbers2 = {1, 2, 3, 5, 7, 9};
        System.out.println("两个数组是否相等: " + Arrays.equals(numbers, numbers2)); // 输出: true
        
        // 数组转List - asList方法
        List<String> fruitList = Arrays.asList(fruits);
        System.out.println("数组转换为List: " + fruitList);
        // 注意：asList返回的List是固定大小的，不能添加或删除元素
        
        // 二维数组输出 - deepToString方法
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("二维数组: " + Arrays.deepToString(matrix));
        
        // 并行排序 - parallelSort方法 (适用于大数组)
        int[] largeArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Arrays.parallelSort(largeArray);
        System.out.println("并行排序后的数组: " + Arrays.toString(largeArray));
        
        // 使用自定义比较器排序
        Integer[] boxedNumbers = {5, 3, 9, 1, 7, 2};
        Arrays.sort(boxedNumbers, (a, b) -> b - a); // 降序排序
        System.out.println("降序排序后的数组: " + Arrays.toString(boxedNumbers));
        
        // 判断数组中是否有指定元素 (Java 8+)
        boolean hasApple = Arrays.stream(fruits).anyMatch(fruit -> fruit.equals("苹果"));
        System.out.println("数组中是否包含'苹果': " + hasApple);
    }
    
    /**
     * 主函数 - 用于测试各个笔记示例
     */
    public static void main(String[] args) {
        JavaNotebook notebook = new JavaNotebook();
        // System.out.println("===== HashMap 用法示例 =====");
        // notebook.hashMapUsage();
        
        // System.out.println("\n===== ArrayList 用法示例 =====");
        // notebook.arrayListUsage();
        
        // System.out.println("\n===== HashSet 用法示例 =====");
        // notebook.hashSetUsage();
        
        System.out.println("\n===== Arrays 工具类用法示例 =====");
        notebook.arraysUsage();
    }
}

/**
 * LeetCode 常用的链表节点定义
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * LeetCode 常用的二叉树节点定义
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


package leetcode.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
     * String 用法示例
     */
    public void stringUsage() {
        // 字符串创建
        String str1 = "Hello";
        String str2 = new String("World");
        System.out.println("两个字符串: " + str1 + ", " + str2);
        
        // 字符串连接
        String concat1 = str1 + " " + str2; // 使用 + 运算符
        String concat2 = str1.concat(" ").concat(str2); // 使用 concat 方法
        System.out.println("连接结果1: " + concat1);
        System.out.println("连接结果2: " + concat2);
        
        // 字符串长度
        System.out.println("字符串长度: " + concat1.length());
        
        // 字符串比较
        System.out.println("两个连接字符串是否相等: " + concat1.equals(concat2)); // true
        System.out.println("比较字符串: " + str1.compareTo(str2)); // 负数表示 str1 < str2
        System.out.println("忽略大小写比较: " + "hello".equalsIgnoreCase(str1)); // true
        
        // 字符串搜索
        String sentence = "Java is a programming language";
        System.out.println("第一个字符: " + sentence.charAt(0)); // 'J'
        System.out.println("programming 的位置: " + sentence.indexOf("programming")); // 返回起始位置
        System.out.println("最后一个 'a' 的位置: " + sentence.lastIndexOf("a")); // 从后向前搜索
        System.out.println("是否包含 'Java': " + sentence.contains("Java")); // true
        System.out.println("是否以 'Java' 开头: " + sentence.startsWith("Java")); // true
        System.out.println("是否以 'language' 结尾: " + sentence.endsWith("language")); // true
        
        // 提取子字符串
        System.out.println("子字符串(7,9): " + sentence.substring(7, 9)); // "is"
        System.out.println("子字符串(0,4): " + sentence.substring(0, 4)); // "Java"
        
        // 字符串替换
        String modified = sentence.replace("Java", "Python");
        System.out.println("替换后: " + modified);
        
        // 字符串修剪
        String withSpaces = "  Trim me  ";
        System.out.println("原始字符串: '" + withSpaces + "'");
        System.out.println("修剪后字符串: '" + withSpaces.trim() + "'");
        
        // 字符串大小写转换
        System.out.println("转大写: " + sentence.toUpperCase());
        System.out.println("转小写: " + sentence.toLowerCase());
        
        // 字符串分割
        String csvData = "apple,banana,orange,grape";
        String[] fruits = csvData.split(",");
        System.out.println("分割后的数组: " + Arrays.toString(fruits));
        
        // 字符串与其他类型的转换
        int num = 123;
        String numStr = String.valueOf(num); // int 转 String
        System.out.println("数字转字符串: " + numStr);
        
        String floatStr = "3.14";
        double pi = Double.parseDouble(floatStr); // String 转 double
        System.out.println("字符串转浮点数: " + pi);
        
        // 字符串格式化
        String formatted = String.format("名字: %s, 年龄: %d", "张三", 25);
        System.out.println("格式化字符串: " + formatted);
        
        // 字符串与字符数组的转换
        char[] charArray = str1.toCharArray(); // 字符串转字符数组
        System.out.println("字符数组: " + Arrays.toString(charArray));
        
        String fromChars = new String(charArray); // 字符数组转字符串
        System.out.println("从字符数组创建字符串: " + fromChars);
        
        // 字符串构建器 (StringBuilder) - 适用于频繁修改字符串的场景
        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        sb.append('!');
        System.out.println("StringBuilder 结果: " + sb.toString());
        
        // StringBuilder 其他操作
        sb.insert(5, ","); // 在指定位置插入
        System.out.println("插入后: " + sb.toString());
        
        sb.replace(7, 12, "Java"); // 替换指定范围的字符
        System.out.println("替换后: " + sb.toString());
        
        sb.delete(5, 7); // 删除指定范围的字符
        System.out.println("删除后: " + sb.toString());
        
        sb.reverse(); // 反转字符串
        System.out.println("反转后: " + sb.toString());
    }

    /**
     * Stack (栈) 用法示例
     */
    public void stackUsage() {
        // Stack<E> 是一个后进先出 (LIFO) 的数据结构
        Stack<String> stack = new Stack<>(); // 推荐使用 Deque 接口及其实现如 ArrayDeque，但这里演示 Stack 类

        // 压栈 (push) - 向栈顶添加元素
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");
        System.out.println("压栈后: " + stack); // 输出: [Apple, Banana, Cherry]

        // 查看栈顶元素 (peek) - 不移除元素
        String topElement = stack.peek();
        System.out.println("栈顶元素 (peek): " + topElement); // 输出: Cherry
        System.out.println("peek 后栈内容: " + stack); // 输出: [Apple, Banana, Cherry]

        // 弹栈 (pop) - 移除并返回栈顶元素
        String poppedElement = stack.pop();
        System.out.println("弹出的元素 (pop): " + poppedElement); // 输出: Cherry
        System.out.println("pop 后栈内容: " + stack); // 输出: [Apple, Banana]

        // 检查栈是否为空 (isEmpty)
        System.out.println("栈是否为空: " + stack.isEmpty()); // 输出: false

        // 查找元素在栈中的位置 (search) - 返回从栈顶开始的1-based位置，找不到返回-1
        int position = stack.search("Apple");
        System.out.println("'Apple' 的位置 (从栈顶1开始): " + position); // 输出: 2
        int notFoundPos = stack.search("Grape");
        System.out.println("'Grape' 的位置: " + notFoundPos); // 输出: -1

        // 获取栈的大小
        System.out.println("栈的大小: " + stack.size()); // 输出: 2

        // 遍历栈 (虽然可以，但不常用，通常通过 pop/peek 操作)
        System.out.println("遍历栈:");
        for (String item : stack) {
            System.out.println(item); // 注意：遍历顺序可能不是 LIFO 顺序，取决于实现
        }

        // 清空栈
        stack.clear(); // 或者循环调用 pop 直到 isEmpty() 为 true
        System.out.println("清空后栈是否为空: " + stack.isEmpty()); // 输出: true
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
        
        // System.out.println("\n===== Arrays 工具类用法示例 =====");
        // notebook.arraysUsage();
        
        // System.out.println("\n===== String 用法示例 =====");
        // notebook.stringUsage();

        System.out.println("\n===== Stack 用法示例 =====");
        notebook.stackUsage();
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


package leetcode.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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

        // 检查是否包含某个值
        System.out.println("是否包含2: " + map.containsValue(2)); // 输出: true
        
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
        String modified2 = sentence.replaceFirst("Java", "Python");
        String modified3 = sentence.replaceAll("Java", "Python");
        System.out.println("替换后: " + modified);
        System.out.println("替换后: " + modified2);
        System.out.println("替换后: " + modified3);
        
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
     * Deque (双端队列) 用法示例
     */
    public void dequeUsage() {
        // 创建双端队列
        Deque<String> deque = new ArrayDeque<>();
        
        // 在队列两端添加元素
        deque.addFirst("First");  // 在队首添加
        deque.addLast("Last");    // 在队尾添加
        deque.offerFirst("Front"); // 在队首添加（推荐）
        deque.offerLast("Back");   // 在队尾添加（推荐）
        System.out.println("添加元素后: " + deque); // 输出: [Front, First, Last, Back]
        
        // 查看队列两端的元素
        System.out.println("队首元素: " + deque.peekFirst()); // 输出: Front
        System.out.println("队尾元素: " + deque.peekLast()); // 输出: Back
        
        // 移除队列两端的元素
        String first = deque.pollFirst(); // 移除并返回队首元素
        String last = deque.pollLast();   // 移除并返回队尾元素
        System.out.println("移除的队首元素: " + first); // 输出: Front
        System.out.println("移除的队尾元素: " + last); // 输出: Back
        System.out.println("移除后: " + deque); // 输出: [First, Last]
        
        // 作为栈使用
        deque.push("Stack1"); // 压栈（在队首添加）
        deque.push("Stack2");
        System.out.println("作为栈使用: " + deque); // 输出: [Stack2, Stack1, First, Last]
        
        String popped = deque.pop(); // 弹栈（移除队首元素）
        System.out.println("弹出的元素: " + popped); // 输出: Stack2
        
        // 作为队列使用
        deque.offer("Queue1"); // 入队（在队尾添加）
        deque.offer("Queue2");
        System.out.println("作为队列使用: " + deque); // 输出: [Stack1, First, Last, Queue1, Queue2]
        
        String polled = deque.poll(); // 出队（移除队首元素）
        System.out.println("出队的元素: " + polled); // 输出: Stack1
        
        // 检查元素
        System.out.println("是否包含'First': " + deque.contains("First")); // 输出: true
        
        // 获取大小
        System.out.println("队列大小: " + deque.size()); // 输出: 4
        
        // 遍历队列
        System.out.println("遍历队列:");
        for (String item : deque) {
            System.out.println(item);
        }
        
        // 清空队列
        deque.clear();
        System.out.println("清空后是否为空: " + deque.isEmpty()); // 输出: true
    }
    
    /**
     * PriorityQueue (优先队列) 用法示例
     */
    public void priorityQueueUsage() {
        // 创建最小堆（默认）
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 添加元素
        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(1);
        minHeap.offer(9);
        System.out.println("最小堆: " + minHeap); // 输出: [1, 2, 8, 5, 9]
        
        // 查看堆顶元素
        System.out.println("堆顶元素: " + minHeap.peek()); // 输出: 1
        
        // 移除堆顶元素
        int min = minHeap.poll();
        System.out.println("移除的最小元素: " + min); // 输出: 1
        System.out.println("移除后: " + minHeap); // 输出: [2, 5, 8, 9]
        
        // 创建最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.offer(5);
        maxHeap.offer(2);
        maxHeap.offer(8);
        maxHeap.offer(1);
        maxHeap.offer(9);
        System.out.println("最大堆: " + maxHeap); // 输出: [9, 8, 5, 1, 2]
        
        // 使用自定义对象
        PriorityQueue<Student> studentQueue = new PriorityQueue<>((a, b) -> b.score - a.score);
        studentQueue.offer(new Student("张三", 85));
        studentQueue.offer(new Student("李四", 92));
        studentQueue.offer(new Student("王五", 78));
        
        System.out.println("按分数排序的学生:");
        while (!studentQueue.isEmpty()) {
            Student student = studentQueue.poll();
            System.out.println(student.name + ": " + student.score);
        }
        
        // 使用比较器
        PriorityQueue<String> stringQueue = new PriorityQueue<>(String::compareTo);
        stringQueue.offer("banana");
        stringQueue.offer("apple");
        stringQueue.offer("cherry");
        
        System.out.println("按字典序排序的字符串:");
        while (!stringQueue.isEmpty()) {
            System.out.println(stringQueue.poll());
        }
    }
    
    // 用于演示优先队列的学生类
    private static class Student {
        String name;
        int score;
        
        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
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
       
        System.out.println("\n===== Deque 用法示例 =====");
        notebook.dequeUsage();
        
        System.out.println("\n===== PriorityQueue 用法示例 =====");
        notebook.priorityQueueUsage();
    }
}
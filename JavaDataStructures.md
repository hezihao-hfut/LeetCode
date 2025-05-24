# Java 数据结构常用方法速查表

## 接口类

### List接口

| 方法 | 描述 |
|------|------|
| `add(E e)` | 将指定元素添加到列表末尾 |
| `add(int index, E e)` | 在指定位置插入元素 |
| `get(int index)` | 获取指定位置的元素 |
| `set(int index, E e)` | 替换指定位置的元素 |
| `remove(Object o)` | 删除首次出现的指定元素 |
| `remove(int index)` | 删除指定位置的元素 |
| `contains(Object o)` | 检查是否包含指定元素 |
| `size()` | 返回列表中元素的数量 |
| `isEmpty()` | 检查列表是否为空 |
| `clear()` | 移除所有元素 |
| `toArray()` | 将列表转换为数组 |
| `iterator()` | 返回列表的迭代器 |
| `subList(int fromIndex, int toIndex)` | 返回列表的视图，从fromIndex到toIndex |

### Set接口

| 方法 | 描述 |
|------|------|
| `add(E e)` | 添加元素到集合 |
| `contains(Object o)` | 检查是否包含指定元素 |
| `remove(Object o)` | 删除指定元素 |
| `size()` | 返回集合中元素数量 |
| `isEmpty()` | 检查集合是否为空 |
| `clear()` | 移除所有元素 |
| `toArray()` | 将集合转换为数组 |
| `iterator()` | 返回集合的迭代器 |
| `addAll(Collection<? extends E> c)` | 添加指定集合中的所有元素 |
| `containsAll(Collection<?> c)` | 检查是否包含指定集合的所有元素 |
| `removeAll(Collection<?> c)` | 移除指定集合中包含的所有元素 |
| `retainAll(Collection<?> c)` | 仅保留也包含在指定集合中的元素 |

### Map接口

| 方法 | 描述 |
|------|------|
| `put(K key, V value)` | 关联指定的值与指定的键 |
| `get(Object key)` | 获取指定键对应的值 |
| `remove(Object key)` | 移除指定键的映射关系 |
| `containsKey(Object key)` | 检查是否包含指定的键 |
| `containsValue(Object value)` | 检查是否包含指定的值 |
| `size()` | 返回映射中键值对的数量 |
| `isEmpty()` | 检查映射是否为空 |
| `clear()` | 移除所有映射 |
| `keySet()` | 返回所有键的Set视图 |
| `values()` | 返回所有值的Collection视图 |
| `entrySet()` | 返回所有键值对的Set视图 |
| `putAll(Map<? extends K,? extends V> m)` | 将指定映射中的所有映射关系复制到此映射 |

### Queue接口

| 方法 | 描述 |
|------|------|
| `offer(E e)` | 将元素插入队列 |
| `poll()` | 获取并移除队首元素，队列为空时返回null |
| `peek()` | 获取但不移除队首元素，队列为空时返回null |
| `element()` | 获取但不移除队首元素，队列为空时抛出异常 |
| `remove()` | 获取并移除队首元素，队列为空时抛出异常 |
| `size()` | 返回队列中元素的数量 |
| `isEmpty()` | 检查队列是否为空 |
| `contains(Object o)` | 检查队列是否包含指定元素 |
| `clear()` | 移除所有元素 |
| `toArray()` | 将队列转换为数组 |

### Deque接口

| 方法 | 描述 |
|------|------|
| `addFirst(E e)` | 在队首插入元素 |
| `addLast(E e)` | 在队尾插入元素 |
| `offerFirst(E e)` | 在队首插入元素，成功返回true |
| `offerLast(E e)` | 在队尾插入元素，成功返回true |
| `removeFirst()` | 移除并返回队首元素，队列为空时抛出异常 |
| `removeLast()` | 移除并返回队尾元素，队列为空时抛出异常 |
| `pollFirst()` | 移除并返回队首元素，队列为空时返回null |
| `pollLast()` | 移除并返回队尾元素，队列为空时返回null |
| `getFirst()` | 获取但不移除队首元素，队列为空时抛出异常 |
| `getLast()` | 获取但不移除队尾元素，队列为空时抛出异常 |
| `peekFirst()` | 获取但不移除队首元素，队列为空时返回null |
| `peekLast()` | 获取但不移除队尾元素，队列为空时返回null |
| `push(E e)` | 将元素压入栈中（在队首添加元素） |
| `pop()` | 弹出栈顶元素（移除并返回队首元素） |

## 具体实现类

### ArrayList（实现List接口）

**底层实现**：基于动态数组实现，支持随机访问，适合查找操作，不适合频繁插入删除操作。

| 方法 | 描述 |
|------|------|
| `add(E e)` | 添加元素到列表末尾 |
| `add(int index, E e)` | 在指定位置插入元素 |
| `get(int index)` | 获取指定位置的元素 |
| `set(int index, E e)` | 修改指定位置的元素 |
| `remove(Object o)` | 删除首次出现的指定元素 |
| `remove(int index)` | 删除指定位置的元素 |
| `contains(Object o)` | 检查是否包含指定元素 |
| `size()` | 返回列表中元素数量 |
| `toArray(T[] a)` | 将列表转换为数组 |
| `clear()` | 清空列表 |
| `ensureCapacity(int minCapacity)` | 确保列表能够容纳指定数量的元素 |
| `trimToSize()` | 将列表的容量调整为当前大小 |

### LinkedList（实现List接口和Deque接口）

**底层实现**：基于双向链表实现，适合频繁的插入删除操作，不适合随机访问。

| 方法 | 描述 |
|------|------|
| `addFirst(E e)` | 在链表头部添加元素 |
| `addLast(E e)` | 在链表尾部添加元素 |
| `getFirst()` | 获取链表头部元素 |
| `getLast()` | 获取链表尾部元素 |
| `removeFirst()` | 删除并返回链表头部元素 |
| `removeLast()` | 删除并返回链表尾部元素 |
| `offer(E e)` | 在链表尾部添加元素 |
| `poll()` | 移除并返回链表头部元素 |
| `peek()` | 获取但不移除链表头部元素 |

### HashMap（实现Map接口）

**底层实现**：基于哈希表实现（数组+链表+红黑树），通过键的哈希值进行快速查找，不保证元素顺序。Java 8后当链表长度超过阈值（默认8）时转为红黑树。

| 方法 | 描述 |
|------|------|
| `put(K key, V value)` | 添加键值对 |
| `get(Object key)` | 获取指定键对应的值 |
| `containsKey(Object key)` | 检查是否包含某个键 |
| `containsValue(Object value)` | 检查是否包含某个值 |
| `remove(Object key)` | 删除指定键的映射 |
| `size()` | 返回映射中键值对数量 |
| `keySet()` | 返回所有键的Set视图 |
| `values()` | 返回所有值的Collection视图 |
| `entrySet()` | 返回所有键值对的Set视图 |
| `clear()` | 清空HashMap |

### HashSet（实现Set接口）

**底层实现**：基于HashMap实现，使用HashMap的键存储元素，值使用一个常量对象。不保证元素顺序，允许null元素。

| 方法 | 描述 |
|------|------|
| `add(E e)` | 添加元素到集合 |
| `contains(Object o)` | 检查是否包含指定元素 |
| `remove(Object o)` | 删除指定元素 |
| `size()` | 返回集合中元素数量 |
| `toArray(T[] a)` | 将集合转换为数组 |
| `addAll(Collection<? extends E> c)` | 添加另一个集合的所有元素（并集） |
| `retainAll(Collection<?> c)` | 仅保留两个集合都有的元素（交集） |
| `removeAll(Collection<?> c)` | 删除指定集合中存在的所有元素（差集） |
| `clear()` | 清空集合 |

### TreeSet（实现SortedSet接口）

**底层实现**：基于TreeMap实现（红黑树），元素有序排列，不允许null元素。

| 方法 | 描述 |
|------|------|
| `add(E e)` | 添加元素到集合 |
| `ceiling(E e)` | 返回大于等于指定元素的最小元素 |
| `floor(E e)` | 返回小于等于指定元素的最大元素 |
| `first()` | 返回第一个（最小）元素 |
| `last()` | 返回最后一个（最大）元素 |
| `headSet(E toElement)` | 返回小于指定元素的所有元素集合 |
| `tailSet(E fromElement)` | 返回大于等于指定元素的所有元素集合 |
| `subSet(E fromElement, E toElement)` | 返回指定范围内的元素集合 |

### PriorityQueue（优先队列）

**底层实现**：基于堆（默认为最小堆）实现，元素按优先级出队，不允许null元素。

| 方法 | 描述 |
|------|------|
| `offer(E e)` | 添加元素到队列 |
| `peek()` | 查看队首元素但不移除 |
| `poll()` | 移除并返回队首元素 |
| `size()` | 返回队列中元素数量 |
| `isEmpty()` | 检查队列是否为空 |
| `clear()` | 清空队列 |
| `contains(Object o)` | 检查是否包含指定元素 |
| `toArray()` | 将队列转换为数组 |

### ArrayDeque（实现Deque接口）

**底层实现**：基于循环数组实现，比LinkedList更高效的双端队列实现，不允许null元素。

| 方法 | 描述 |
|------|------|
| `addFirst(E e)` | 在队首添加元素 |
| `addLast(E e)` | 在队尾添加元素 |
| `offerFirst(E e)` | 在队首添加元素（推荐） |
| `offerLast(E e)` | 在队尾添加元素（推荐） |
| `peekFirst()` | 查看队首元素但不移除 |
| `peekLast()` | 查看队尾元素但不移除 |
| `pollFirst()` | 移除并返回队首元素 |
| `pollLast()` | 移除并返回队尾元素 |
| `push(E e)` | 压栈（在队首添加） |
| `pop()` | 弹栈（移除队首元素） |
| `offer(E e)` | 入队（在队尾添加） |
| `poll()` | 出队（移除队首元素） |

## Arrays工具类

| 方法 | 描述 |
|------|------|
| `toString(array)` | 返回数组的字符串表示 |
| `sort(array)` | 数组排序 |
| `binarySearch(array, key)` | 二分查找元素（数组必须已排序） |
| `fill(array, val)` | 数组填充为指定值 |
| `fill(array, fromIndex, toIndex, val)` | 数组部分填充为指定值 |
| `copyOf(array, length)` | 复制数组（可扩展或截断） |
| `copyOfRange(array, from, to)` | 复制数组的指定范围 |
| `equals(array1, array2)` | 比较两个数组是否相等 |
| `asList(array)` | 将数组转换为固定大小的List |
| `deepToString(array)` | 返回多维数组的字符串表示 |
| `parallelSort(array)` | 并行排序（适用于大数组） |

## String

| 方法 | 描述 |
|------|------|
| `length()` | 返回字符串长度 |
| `charAt(int index)` | 返回指定位置的字符 |
| `concat(String str)` | 连接字符串 |
| `equals(Object obj)` | 比较字符串是否相等 |
| `equalsIgnoreCase(String str)` | 比较字符串是否相等（忽略大小写） |
| `compareTo(String str)` | 按字典顺序比较两个字符串 |
| `indexOf(String str)` | 查找子字符串首次出现的位置 |
| `lastIndexOf(String str)` | 查找子字符串最后出现的位置 |
| `contains(CharSequence s)` | 检查是否包含指定字符序列 |
| `startsWith(String prefix)` | 检查是否以指定前缀开头 |
| `endsWith(String suffix)` | 检查是否以指定后缀结尾 |
| `substring(int begin, int end)` | 提取子字符串 |
| `replace(CharSequence target, CharSequence replacement)` | 替换所有匹配的子字符串 |
| `trim()` | 删除前导和尾随空白 |
| `toUpperCase()` | 转换为大写 |
| `toLowerCase()` | 转换为小写 |
| `split(String regex)` | 按正则表达式分割字符串 |
| `valueOf(primitive)` | 将基本类型转换为字符串 |
| `toCharArray()` | 转换为字符数组 |

## 数据结构翻转方法

| 数据结构 | 翻转方法 |
|---------|---------|
| List | `Collections.reverse(list)` |
| List (Java 21+) | `list.reversed()` |
| String | `new StringBuilder(str).reverse().toString()` |
| Array | 手动实现或使用`Collections.reverse(Arrays.asList(array))`（仅限包装类数组） | 
### 数组(Array)

数组是一种**线性数据结构**；用一组**连续的内存空间**，来存储一组具有**相同类型的数据**。

##### 时间复杂度分析

###### 1、插入(insert)：

- 最好：时间复杂度：O(1)，insert在数组的末尾

- 最坏：时间复杂度：O(n)，insert在数组的开始及中间

- 平均：时间复杂度：O(n)

###### 2、删除(delete)：

- 最好：时间复杂度：O(1)，delete在数组的末尾

- 最坏：时间复杂度：O(n)，delete在数组的开始及中间

- 平均：时间复杂度：O(n)

###### 3、查询(access)：

- 平均：时间复杂度：O(1)，根据下标即可访问元素

注：由于数组插入/删除效率不高，所以链表应运而生



---



### 数组常见解题方法：

#### 1、哈希表

哈希表查询时间复杂度：O(1)

##### 常见题目：

- [1. 两数之和](https://leetcode.cn/problems/two-sum/)

- [15. 三数之和](https://leetcode.cn/problems/3sum/)

#### 2、双指针法

##### 常见题目：

- [26. 删除排序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array/)

- #### [27. 移除元素](https://leetcode.cn/problems/remove-element/)


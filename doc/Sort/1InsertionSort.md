### 插入排序（Insertion Sort）

> 可以类比打牌,从未排序中取一张牌,向已排序牌中插入一张牌。

遍历数组，找到数据应该插入的位置将其插入即可。

将数组中的数据分为两个区间，**已排序区间**和**未排序区间**。初始已排序区间只有一个元素，就是数组的第一个元素。

插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。

![](img/InsertionSort/insertionSort.gif)

---

##### 时间复杂度：

最好：O(n)，最坏：O(n²)，平均：O(n²)

|    是否原地排序     | 是否稳定排序 | 是否基于比较 |
|:-------------:|:------:|:------:|
| 是（时间复杂度 O(1)） |   是    |   是    |
|    不需要额外空间    |        |        |

---

```Java
class InsertionSort {
    private static void sort(int[] array) {
        if (array.length <= 1) return;
        // 从下标1的元素开始选择合适的位置插入,因为下标0的只有一个元素,默认是有序的
        for (int i = 1; i < array.length; i++) {
            // 记录要插入的数据
            int temp = array[i];
            // 从已经排序的序列最右边的开始比较,找到比其小的数
            int j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            // 存在比其小的数,插入
            if (j != i) {
                array[j] = temp;
            }
        }
    }
}
```


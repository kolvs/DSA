### 冒泡排序（Bubble Sort）

冒泡排序只会操作相邻的两个数据。每次冒泡操作都会**对相邻的两个元素进行比较**，看是否满足大小关系要求。如果不满足就让它俩互换。

![](img/BubbleSort/BubbleSort.gif)

冒泡排序包含两个操作：

**元素比较**

相邻两个数进行比较：array[i] > array[i + 1]

**元素移动**

交换赋值移动元素： int t = i; i = j; j = t;

##### 时间复杂度：

最好：O(n)，最坏：O(n²)，平均：O(n^2)

|    是否原地排序     | 是否稳定排序 | 是否基于比较 |
|:-------------:|:------:|:------:|
| 是（时间复杂度 O(1)） |   是    |   是    |

---

注意：Java中的交换需要中间变量

优化：通过标记，判断是否已经排序过

```Java
class Bubble {
    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //有序标记，每一轮的初始是true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
```

冒泡排序是由两个for循环构成，第一个for循环的变量 i 表示总共需要多少轮比较，第二个for循环的变量 j
表示每轮参与比较的元素下标【0,1，......，length-i】，因为每轮比较都会出现一个最大值放在最右边，所以每轮比较后的元素个数都会少一个，这也是为什么
j 的范围是逐渐减小的。
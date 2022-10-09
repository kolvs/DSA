### 快速排序（Quick Sort）

**算法**

- 从数列中挑出一个元素，称为 "基准"（pivot）;
- 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
- 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；

![](img/QuickSort/quickSort.gif)

##### 时间复杂度：

最好：O(nlogn),最坏：O(n²),平均：O(nlogn)

##### 空间复杂度：

O(1)

|    是否原地排序     | 是否稳定排序 | 是否基于比较 | 是否需要额外空间 |
|:-------------:|:------:|:------:|:--------:|
| 是（时间复杂度 O(1)） |   否    |   是    |    否     |

```Java
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{11, 5, 8, 6, 3, 9, 2, 1, 4, 7};
        int[] sort = sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            sort(arr, left, index - 1);
            sort(arr, index + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int pivot, int right) {
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```


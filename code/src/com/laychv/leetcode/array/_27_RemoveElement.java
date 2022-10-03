package com.laychv.leetcode.array;

import static com.laychv.common.PrintIntegerArray.integerArrayToString;
import static com.laychv.common.PrintIntegerArray.stringToIntegerArray;

/***
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *  
 *
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _27_RemoveElement {

    public static void main(String[] args) {
        String line ="";
        int[] nums = stringToIntegerArray(line);
        int val = Integer.parseInt(line);
        int ret = new _27_RemoveElement().removeElement1(nums, val);
        String out = integerArrayToString(nums, ret);
        System.out.print(out);
    }

    /**
     * 标签：拷贝覆盖
     * 主要思路是遍历数组nums，每次取出的数字变量为num，同时设置一个下标ans
     * 在遍历过程中如果出现数字与需要移除的值不相同时，则进行拷贝覆盖nums[ans] = num，ans自增1
     * 如果相同的时候，则跳过该数字不进行拷贝覆盖，最后ans即为新的数组长度
     * 这种思路在移除元素较多时更适合使用，最极端的情况是全部元素都需要移除，遍历一遍结束即可
     * 时间复杂度：O(n)，空间复杂度：O(1)
     * <p>
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/remove-element/solution/hua-jie-suan-fa-27-yi-chu-yuan-su-by-guanpengchn/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num != val) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }

    /**
     * * 解法一: 双指针
     * *
     * * 思路
     * * 既然问题要求我们就地删除给定值的所有元素，我们就必须用 O(1) 的额外空间来处理它。如何解决？我们可以保留两个指针 i 和 j，其中 i 是慢指针，j 是快指针。
     * *
     * * 算法
     * *
     * * 当 nums[j] 与给定的值相等时，递增 j 以跳过该元素。只要 nums[j] != val ，我们就复制 nums[j]  到 nums[i] 并同时递增两个索引。重复这一过程，直到 j 到达数组的末尾，该数组的新长度为 i。
     * *
     * * 作者：LeetCode
     * * 链接：https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/
     * * 来源：力扣（LeetCode）
     * * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 第二种思路
     * 标签：交换移除
     * 主要思路是遍历数组nums，遍历指针为i，总长度为ans
     * 在遍历过程中如果出现数字与需要移除的值不相同时，则i自增1，继续下一次遍历
     * 如果相同的时候，则将nums[i]与nums[ans-1]交换，即当前数字和数组最后一个数字进行交换，交换后就少了一个元素，故而ans自减1
     * 这种思路在移除元素较少时更适合使用，最极端的情况是没有元素需要移除，遍历一遍结束即可
     * 时间复杂度：O(n)，空间复杂度：O(1)
     * <p>
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/remove-element/solution/hua-jie-suan-fa-27-yi-chu-yuan-su-by-guanpengchn/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int removeElement2(int nums[], int val) {
        int i = nums.length;
        for (int j = 0; j < i; ) {
            if (nums[j] == val) {
                nums[j] = nums[i - 1];
                i--;
            } else {
                j++;
            }
        }
        return i;
    }

    /**
     * 双指针: 当要删除的元素很少时
     *
     * 思路
     *
     * 现在考虑数组包含很少的要删除的元素的情况。例如，num=[1，2，3，5，4]，Val=4num=[1，2，3，5，4]，Val=4。之前的算法会对前四个元素做不必要的复制操作。另一个例子是 num=[4，1，2，3，5]，Val=4num=[4，1，2，3，5]，Val=4。似乎没有必要将 [1，2，3，5][1，2，3，5] 这几个元素左移一步，因为问题描述中提到元素的顺序可以更改。
     *
     * 算法
     *
     * 当我们遇到 nums[i] = valnums[i]=val 时，我们可以将当前元素与最后一个元素进行交换，并释放最后一个元素。这实际上使数组的大小减少了 1。
     *
     * 请注意，被交换的最后一个元素可能是您想要移除的值。但是不要担心，在下一次迭代中，我们仍然会检查这个元素。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int removeElement3(int nums[], int val) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j - 1];
                j--;
            } else {
                i++;
            }
        }
        return j;
    }
}

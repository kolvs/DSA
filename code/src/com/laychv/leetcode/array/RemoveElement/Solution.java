package com.laychv.leetcode.array.RemoveElement;

public class Solution {

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
}

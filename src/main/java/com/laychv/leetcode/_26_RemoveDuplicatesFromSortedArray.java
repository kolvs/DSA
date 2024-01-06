package com.laychv.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 26. 删除有序数组中的重复项 🟢
 * <p>
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么nums的前 k 个元素应该保存最终结果。
 * 将最终结果插入nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 判题标准:
 * 系统会用下面的代码来测试你的题解:
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 * int k = removeDuplicates(nums); // 调用
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按 升序 排列
 * <p>
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 */
public class _26_RemoveDuplicatesFromSortedArray {

    /**
     * set
     * error for leetcode
     */
    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        for (int num : nums) {
            if (set.contains(num)) {
                System.out.println(set);
                return set.size();
            }
        }
        return -1;
    }

    /**
     * 双指针
     */
    public static int removeDuplicates0(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
//                j++;
//                nums[j] = nums[i];
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }

    static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (nums[i] != n) {
                nums[++i] = n;//
            }
        }
        return ++i;//
    }

    /**
     * 双指针-快慢指针
     */
    public static int removeDuplicates3(int[] nums) {
        if (nums.length == 0) return 0;

        // 同向出发，slow走一步，fast走两步
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }

    /**
     * 移除重复项通用解法
     * k为重复项的个数
     */
    public static int removeDuplicates4(int[] nums) {
        return remove(nums, 1);
    }

    private static int remove(int[] nums, int k) {
        int res = 0;
        for (int n : nums) {
            if (res < k || nums[res - k] != n) {
                nums[res++] = n;
            }
        }
        return res;
    }
}

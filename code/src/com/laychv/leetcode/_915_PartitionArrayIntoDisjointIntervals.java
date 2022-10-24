package com.laychv.leetcode;

/**
 * 915. 分割数组 🟠
 * <p>
 * 给定一个数组nums，将其划分为两个连续子数组left和right，使得：
 * left中的每个元素都小于或等于right中的每个元素。
 * left 和right都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回left的长度。
 * 用例可以保证存在这样的划分方法。
 * <p>
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * <p>
 * 输入：nums = [1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 * <p>
 * 提示：
 * 2 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。
 * <p>
 * https://leetcode.cn/problems/partition-array-into-disjoint-intervals
 */
public class _915_PartitionArrayIntoDisjointIntervals {

    public static void main(String[] args) {
        System.out.println("3->:" + partitionDisjoint4(new int[]{5, 3, 0, 8, 6}));
        System.out.println("4->:" + partitionDisjoint3(new int[]{1, 1, 1, 0, 6, 12}));
        System.out.println("1->:" + partitionDisjoint2(new int[]{26, 51, 40, 58, 42, 76, 30, 48, 79, 91}));
        System.out.println("1->:" + partitionDisjoint(new int[]{26, 51, 40, 58, 42, 76, 30, 48, 79, 91}));
    }

    /**
     * 两次遍历
     * 依据题目要求得出：本题的本质是求分割点，使得分割点的「左边的子数组的最大值」小于等于「右边的子数组的最小值」。
     * 我们可以先通过一次遍历（从后往前）统计出所有后缀的最小值 min，其中 min[i] = x 含义为下标范围在 [i,n−1] 的 nums[i] 的最小值为 x，
     * 然后再通过第二次遍历（从前往后）统计每个前缀的最大值（使用单变量进行维护），找到第一个符合条件的分割点即是答案。
     * https://leetcode.cn/problems/partition-array-into-disjoint-intervals/solution/by-ac_oier-yyen/
     */
    public static int partitionDisjoint(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;

        int[] minRight = new int[n];
        minRight[n - 1] = nums[n - 1];

        // right,nums.length - 2，i 的遍历范围应当是 [0, n-2]
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }

        // left,nums.length - 1
        for (int i = 0, leftMax = 0; i < n - 1; i++) {
            leftMax = Math.max(leftMax, nums[i]);
            if (leftMax <= minRight[i + 1]) {
                return i + 1;
            }
        }

        return n - 1;
    }

    /**
     * 一次遍历
     */
    public static int partitionDisjoint2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int leftMax = nums[0], leftPos = 0, curMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }

    public static int partitionDisjoint3(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
            right[n - i - 1] = Math.min(right[n - i], nums[n - i - 1]);
        }

        for (int i = 1; i < n; i++) {
            if (left[i - 1] <= right[i]) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 一次遍历
     * max1
     * 5   [3  0  8  6]
     * max2
     * [5,3,0] <= [8,6]
     */
    public static int partitionDisjoint4(int[] nums) {
        int res = 0;
        int max1 = nums[0];
        int max2 = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (max1 > nums[i]) {
                res = i;
                max1 = Math.max(max1, max2);
            }
            max2 = Math.max(max2, nums[i]);
        }

        return res + 1;
    }

}

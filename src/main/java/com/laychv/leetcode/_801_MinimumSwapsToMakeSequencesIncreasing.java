package com.laychv.leetcode;

/**
 * 801. 使序列递增的最小交换次数 🔴
 * <p>
 * 我们有两个长度相等且不为空的整型数组nums1和nums2。在一次操作中，我们可以交换nums1[i]和nums2[i]的元素。
 * <p>
 * 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
 * 返回 使 nums1 和 nums2 严格递增所需操作的最小次数 。
 * <p>
 * 数组arr严格递增 且arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1]。
 * <p>
 * 输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
 * 输出: 1
 * 解释: 交换 A[3] 和 B[3] 后，两个数组如下: A = [1, 3, 5, 7] ， B = [1, 2, 3, 4] 两个数组均为严格递增的。
 * <p>
 * 输入: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
 * 输出: 1
 * <p>
 * <a href="https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing">...</a>
 */
public class _801_MinimumSwapsToMakeSequencesIncreasing {

    public static void main(String[] args) {
        int[] x = {1, 3, 5, 4};
        int[] y = {1, 2, 3, 7};
        System.out.println(minSwap(x, y));

        int[] a = {0, 3, 5, 8, 9};
        int[] b = {2, 1, 4, 6, 9};
        System.out.println(minSwap2(a, b));
    }

    /**
     * 动态规划
     * 定义i：dp[i][j]；i：表示nums1和nums2所在位置的index，j：状态值：[0]表示不交换，[1]表示交换
     *
     * <p>
     * https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/solution/zhua-wa-mou-si-tu-jie-leetcode-by-muse-7-kmio/
     */
    public static int minSwap(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][2];
        dp[0][0] = 0;// 0 不交换
        dp[0][1] = 1;// 1 交换
        for (int i = 1; i < nums1.length; i++) {
            int a1 = nums1[i - 1], a2 = nums1[i];
            int b1 = nums2[i - 1], b2 = nums2[i];
            if ((a1 < a2 && b1 < b2) && (b1 < a2 && a1 < b2)) {
                // 如果i【不互换】，则i-1可【互换】也可【不互换】
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                // 如果i【互换】，则i-1可【互换】也可【不互换】
                dp[i][1] = dp[i][0] + 1;
            } else if (a1 < a2 && b1 < b2) {
                // 如果i【不互换】，则i-1必须【不互换】
                dp[i][0] = dp[i - 1][0];
                // 如果i【互换】，则i-1必须【互换】
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                // 如果i【不互换】，则i-1必须【互换】
                dp[i][0] = dp[i - 1][1];
                // 如果i【互换】，则i-1必须【不互换】
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[nums1.length - 1][0], dp[nums1.length - 1][1]);
    }

    /**
     * 滚动数组
     * <a href="https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/solution/shi-xu-lie-di-zeng-de-zui-xiao-jiao-huan-ux2y/">...</a>
     */
    public static int minSwap2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int at = a, bt = b;
            a = b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                a = Math.min(a, at);
                b = Math.min(b, bt + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, bt);
                b = Math.min(b, at + 1);
            }
        }
        return Math.min(a, b);
    }
}

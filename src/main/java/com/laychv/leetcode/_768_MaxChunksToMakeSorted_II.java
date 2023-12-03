package com.laychv.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 768. 最多能完成排序的块 II 🔴
 * <p>
 * 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * 我们最多能将数组分成多少块？
 * <p>
 * 输入: arr = [5,4,3,2,1]
 * 输出: 1
 * 解释:将数组分成2块或者更多块，都无法得到所需的结果。例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。
 * <p>
 * 输入: arr = [2,1,3,4,4]
 * 输出: 4
 * 解释:我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。
 * <p>
 * https://leetcode.cn/problems/max-chunks-to-make-sorted-ii
 */
public class _768_MaxChunksToMakeSorted_II {

    public static void main(String[] args) {
        int[] x = {5,4,3,2,1};
        System.out.println(maxChunksToSorted(x));
    }

    /**
     * 单调栈
     */
    public static int maxChunksToSorted(int[] arr) {
//        Deque<Integer> stack = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        for (int a : arr) {
            if (stack.isEmpty() || a >= stack.peek()) {
                stack.push(a);
            } else {
                int mx = stack.pop();
                while (!stack.isEmpty() && stack.peek() > a) {
                    stack.pop();
                }
                stack.push(mx);
            }
        }
        return stack.size();
    }

}

package com.laychv.leetcode;

import java.util.*;

import static com.laychv.common.PrintIntegerArray.integerArrayToString;

/**
 * 870. 优势洗牌
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * 类似田忌赛马
 * <p>
 * https://leetcode.cn/problems/advantage-shuffle/
 */
public class _870_AdvantageShuffle {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] b = {1, 10, 4, 11};
        System.out.println(integerArrayToString(advantageCount(a, b)));
        System.out.println(integerArrayToString(advantageCount2(a, b)));
        System.out.println(integerArrayToString(advantageCount3(a, b)));
    }

    // TreeMap
    // 采用TreeMap来存放num1中的数字，然后遍历num2，找num2中的每个元素的匹配元素
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        // 返回结果数组
        int[] res = new int[nums1.length];
        // 用TreeMap存放nums1元素
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // 遍历存放nums1
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);// + 1 ？？？
        }
//        for (int i = 0; i < nums1.length; i++) {
//            map.put(nums1[i],map.getOrDefault(nums1[i],0));
//        }
        // 遍历nums2
        for (int i = 0; i < nums2.length; i++) {
            // 从TreeMap中找到大于 nums2[i]的最小元素
            Integer min = map.higherKey(nums2[i]);
            // 没有取 num1 中的最小值
            if (min == null) {
                min = map.firstKey();
            }
            res[i] = min;
            if (map.get(min) == 1) {
                map.remove(min);
            } else {
                map.put(min, map.get(min) - 1);
            }
        }

        return res;
    }

    // TreeSet
    // 从每个 nums2[i]nums2[i] 出发考虑，使用哪个 nums1[i]nums1[i] 去匹配最为合适
    // 实时维护一个候选集合，该集合支持高效查询比某个数大的数值操作；
    // 对候选集合中每个数值的可使用次数进行记录，当使用到了候选集合中的某个数后，要对其进行计数减一操作，若计数为 00，则将该数值从候选集合中移除。
    // https://leetcode.cn/problems/advantage-shuffle/solution/by-ac_oier-i01s/
    public static int[] advantageCount2(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) == 1) set.add(i);
        }

        for (int i = 0; i < nums2.length; i++) {
            Integer min = set.ceiling(nums2[i] + 1);
            if (min == null) {
                min = set.ceiling(-1);
            }
            res[i] = min;
            map.put(min, map.get(min) - 1);
            if (map.get(min) == 0) {
                set.remove(min);
            }
        }

        return res;
    }

    // 排序 + 双指针
    //
    public static int[] advantageCount3(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            List<Integer> list = map.getOrDefault(nums2[i], new ArrayList<>());
            list.add(i);
            map.put(nums2[i], list);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0, j = 0, k = nums1.length - 1; i < nums1.length; i++) {
            int t = nums1[i] > nums2[j] ? j : k;
            List<Integer> list = map.get(nums2[t]);
            int idx = list.remove(list.size() - 1);
            res[idx] = nums1[i];
            if (t == j) j++;
            else k--;
        }

        return res;
    }
}

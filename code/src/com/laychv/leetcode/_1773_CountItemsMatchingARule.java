package com.laychv.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量 🟢
 * <p>
 * 给你一个数组 items ，其中items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
 * 另给你一条由两个字符串ruleKey 和 ruleValue 表示的检索规则。
 * 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
 * ruleKey == "type" 且 ruleValue == typei 。
 * ruleKey == "color" 且 ruleValue == colori 。
 * ruleKey == "name" 且 ruleValue == namei 。
 * 统计并返回 匹配检索规则的物品数量 。
 * <p>
 * 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * 输出：1
 * 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
 * <p>
 * 输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * 输出：2
 * 解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。
 * <p>
 * 提示：
 * 1 <= items.length <= 10^4
 * 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
 * ruleKey 等于 "type"、"color" 或 "name"
 * 所有字符串仅由小写字母组成
 * <p>
 * https://leetcode.cn/problems/count-items-matching-a-rule
 */
public class _1773_CountItemsMatchingARule {

    public static void main(String[] args) {
        String items = "[[phone,blue,pixel],[computer,silver,lenovo],[phone,gold,iphone]]";

        List<List<String>> item = new ArrayList<>();
        List<String> s = new ArrayList<>();
        s.add("phone");
        s.add("blue");
        s.add("pixel");
        item.add(s);
        List<String> s2 = new ArrayList<>();
        s2.add("computer");
        s2.add("silver");
        s2.add("lenovo");
        item.add(s2);
        List<String> s3 = new ArrayList<>();
        s3.add("phone");
        s3.add("gold");
        s3.add("iphone");
        item.add(s3);

        String ruleKey = "color";
        String ruleValue = "silver";
        System.out.println("1->:" + countMatches(item, ruleKey, ruleValue));
        System.out.println("1->:" + countMatches2(item, ruleKey, ruleValue));
        System.out.println("1->:" + countMatches3(item, ruleKey, ruleValue));
    }

    /**
     * HashMap
     * 可以利用哈希表把输入 ruleKey 转换为 items[i] 的下标，然后再遍历一遍 items，找出符合条件的物品数量。
     */
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("type", 0);
        map.put("color", 1);
        map.put("name", 2);
        int idx = map.get(ruleKey);

        int res = 0;
        for (List<String> item : items) {
            if (item.get(idx).equals(ruleValue)) {
                res++;
            }
        }
        return res;
    }

    public static int countMatches2(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        for (List<String> item : items) {
            if (ruleKey == "type" && ruleValue == item.get(0)) {
                res++;
            } else if (ruleKey == "color" && ruleValue == item.get(1)) {
                res++;
            } else if (ruleKey == "name" && ruleValue == item.get(2)) {
                res++;
            }
        }
        return res;
    }

    public static int countMatches3(List<List<String>> items, String ruleKey, String ruleValue) {
        int i = ruleKey.charAt(0) == 't' ? 0 : (ruleKey.charAt(0) == 'c' ? 1 : 2);
        int res = 0;
        for (var v : items) {
            if (v.get(i).equals(ruleValue)) {
                ++res;
            }
        }
        return res;
    }
}

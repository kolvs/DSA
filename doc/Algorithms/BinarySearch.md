Binary Search

把待搜索区间分为3部分:
- [mid], 直接返回
- [left,mid - 1],设置边界 right = mid - 1
- [right,mid + 1],设置边界 left = mid + 1

|                              LeetCode                              | Level |                            力扣                            |
|:------------------------------------------------------------------:|:-----:|:--------------------------------------------------------:|
| [704. Binary Search](https://leetcode.com/problems/binary-search/) |  🟢   | [704. 二分查找](https://leetcode.cn/problems/binary-search/) |
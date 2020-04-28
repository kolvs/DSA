### 二分查找算法 

把待搜索区间分为3部分:

- [mid], 直接返回
- [left,mid - 1],设置边界 right = mid - 1
- [right,mid + 1],设置边界 left = mid + 1
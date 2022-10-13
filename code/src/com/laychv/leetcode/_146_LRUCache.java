package com.laychv.leetcode;

import com.laychv.common.DoubleNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存 🟡
 * <p>
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。
 * 如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * https://leetcode.cn/problems/lru-cache
 */
public class _146_LRUCache {

    /**
     * Hash + DoubleLinkedList
     */

    int size;
    int category;
    DoubleNode head, tail;
    Map<Integer, DoubleNode> cache = new HashMap<>();

    public _146_LRUCache(int category) {
        size = 0;
        this.category = category;
        head = new DoubleNode();
        tail = new DoubleNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * LRU Cache Test
     *
     * @param args
     */
    public static void main(String[] args) {
        _146_LRUCache lRUCache = new _146_LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }

    /**
     * 根据key查找
     *
     * @param key
     * @return
     */
    public int get(int key) {
        DoubleNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 添加后, 指针移到head
        toHead(node);
        return node.value;
    }

    /**
     * 存入 key,value
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DoubleNode out = cache.get(key);
        // 查询有没有node
        if (out == null) {
            // 没有node创建
            DoubleNode in = new DoubleNode(key, value);
            cache.put(key, in);
            addHead(in);
            ++size;
            if (size > category) {
                DoubleNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 直接使用,移动指针
            out.value = value;
            toHead(out);
        }
    }

    /**
     * 移除尾节点
     * --0--
     *
     * @return
     */
    private DoubleNode removeTail() {
        DoubleNode node = tail.prev;
        removeNode(node);
        return node;
    }

    /**
     * 添加到头节点
     *
     * @param node
     */
    private void addHead(DoubleNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 先移除,再添加
     *
     * @param node
     */
    private void toHead(DoubleNode node) {
        removeNode(node);
        addHead(node);
    }

    /**
     * 移除节点
     * 前指针:
     * 后指针
     *
     * @param node
     */
    private void removeNode(DoubleNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

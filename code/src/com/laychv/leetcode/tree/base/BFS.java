package com.laychv.leetcode.tree.base;

import java.util.Queue;
import java.util.Set;

/**
 * 广度优先搜索
 */
public class BFS {

    int bfs(Node start, Node target) {
        Queue<Node> q = null;
        Set<Node> visited = null;
        q.offer(start);

        visited.add(start);
        int step = 0;

        while (q != null) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                Node cur = q.poll();
                if (cur == target) {
                    return step;
                }
//                for (Node x : cur.adj()) {
//                    if (x != visited) {
//                        q.offer(x);
//                        visited.add(x);
//                    }
//                }
            }
            step++;
        }
        return 0;
    }

}

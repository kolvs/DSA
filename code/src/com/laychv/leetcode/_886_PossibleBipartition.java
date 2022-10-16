package com.laychv.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 886. 可能的二分法 🟡
 * <p>
 * 给定一组n人（编号为1, 2, ..., n），我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 给定整数 n和数组 dislikes，其中dislikes[i] = [ai, bi]，表示不允许将编号为 ai和bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 * <p>
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * <p>
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * <p>
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 * <p>
 * 提示：
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai< bi
 * dislikes中每一组都 不同
 * <p>
 * https://leetcode.cn/problems/possible-bipartition
 */
public class _886_PossibleBipartition {

    public static void main(String[] args) {
        int[][] x = {{1, 2}, {1, 3}, {2, 4}};
        int xt = 4;
        int[][] y = {{1, 2}, {1, 3}, {2, 3}};
        int yt = 3;
        int[][] z = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        int zt = 5;
        System.out.println(possibleBipartition(yt, y));
        System.out.println(possibleBipartition2(zt, z));
        System.out.println(possibleBipartition3(zt, z));
    }

    // 染色法-bfs
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        //
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        //
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        //
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                Queue<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    int t = queue.poll();
                    for (int next : g[t]) {
                        if (color[next] > 0 && color[next] == color[t]) return false;
                        if (color[next] == 0) {
                            color[next] = 3 ^ color[t];//
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return true;
    }

    // 染色法-dfs
    public static boolean possibleBipartition2(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(i, 1, color, g)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int curnode, int nowcolor, int[] color, List<Integer>[] g) {
        color[curnode] = nowcolor;
        for (int nextnode : g[curnode]) {
            if (color[nextnode] != 0 && color[nextnode] == color[curnode]) {
                return false;
            }
            if (color[nextnode] == 0 && !dfs(nextnode, 3 ^ nowcolor, color, g)) {
                return false;
            }
        }
        return true;
    }

    // 并查集 Disjoint Set Union
    // https://leetcode.cn/problems/possible-bipartition/solution/by-lcbin-rgi1/
    public static boolean possibleBipartition3(int n, int[][] dislikes) {
        int[] p = new int[n];
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            g[i] = new ArrayList<>();
        }
        for (var e : dislikes) {
            int a = e[0] - 1, b = e[1] - 1;
            g[a].add(b);
            g[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            for (int j : g[i]) {
                if (find(i, p) == find(j, p)) {
                    return false;
                }
                p[find(j, p)] = find(g[i].get(0), p);
            }
        }
        return true;
    }

    private static int find(int x, int[] p) {
        if (p[x] != x) {
            p[x] = find(p[x], p);
        }
        return p[x];
    }
}

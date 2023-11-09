package leetcodeDaily;

//给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，它表示一个网格图。每个格子为下面 3 个值之一：
// 0 表示草地。
// 1 表示着火的格子。
// 2 表示一座墙，你跟火都不能通过这个格子。
// 一开始你在最左上角的格子 (0, 0) ，你想要到达最右下角的安全屋格子 (m - 1, n - 1) 。每一分钟，你可以移动到 相邻 的草地格子。每次你
//移动 之后 ，着火的格子会扩散到所有不是墙的 相邻 格子。
//请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1 。如果不管你在初始位置停留多久，
//你总是能到达安全屋，请你返回 10⁹ 。
// 注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。
// 如果两个格子有共同边，那么它们为 相邻 格子。
// 示例 1：
// 输入：grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0
//,0,0,0,0,0,0]]
//输出：3
//解释：上图展示了你在初始位置停留 3 分钟后的情形。
//你仍然可以安全到达安全屋。
//停留超过 3 分钟会让你无法安全到达安全屋。
// 示例 2：
// 输入：grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
//输出：-1
//解释：上图展示了你马上开始朝安全屋移动的情形。
//火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
//所以返回 -1 。
// 示例 3：
// 输入：grid = [[0,0,0],[2,2,0],[1,2,0]]
//输出：1000000000
//解释：上图展示了初始网格图。
//注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
//所以返回 10⁹ 。
// 提示：
// m == grid.length
// n == grid[i].length
// 2 <= m, n <= 300
// 4 <= m * n <= 2 * 10⁴
// grid[i][j] 是 0 ，1 或者 2 。
// grid[0][0] == grid[m - 1][n - 1] == 0
// Related Topics 广度优先搜索 数组 二分查找 矩阵 👍 96 👎 0

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class C2258 {
    public static void main(String[] args) {
        int[][] grid = {{0,2,0,0,0,0,0},{0,0,0,2,2,1,0},{0,2,0,0,1,2,0},{0,0,0,0,0,0,0}};
        System.out.println(new C2258().maximumMinutes(grid));
    }
    static final int INF = 1000000000;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] fireTime = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(fireTime[i], INF);
        }
        /* 通过 bfs 求出每个格子着火的时间 */
        bfs(grid, fireTime);
        /* 二分查找找到最大停留时间 */
        int ans = -1;
        int low = 0, high = m * n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(fireTime, grid, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans >= m * n ? INF : ans;
    }
    //add(int index,E element) 在列表的指定位置插入指定元素，将当前位于该位置的元素和任何后续元素移动   超出队列界限的 抛出异常让处理
    //offer(E e)  在尾部添加一个元素 超出队列界限的 返回false
    //remove()  从队列头部删除一个元素  没有元素的时候报异常
    //poll()    从队列头部删除一个元素  没有元素的时候返回null
    public void bfs(int[][] grid, int[][] fireTime) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
            }
        }

        int time = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] arr = queue.poll();
                int cx = arr[0], cy = arr[1];
                for (int j = 0; j < 4; j++) {
                    int nx = cx + dirs[j][0];
                    int ny = cy + dirs[j][1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                        if (grid[nx][ny] == 2 || fireTime[nx][ny] != INF) {
                            continue;
                        }
                        queue.offer(new int[]{nx, ny});
                        fireTime[nx][ny] = time;
                    }
                }
            }
            time++;
        }
    }

    public boolean check(int[][] fireTime, int[][] grid, int stayTime) {
        int m = fireTime.length;
        int n = fireTime[0].length;
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{0, 0, stayTime});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int cx = arr[0], cy = arr[1], time = arr[2];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dirs[i][0];
                int ny = cy + dirs[i][1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (visit[nx][ny] || grid[nx][ny] == 2) {
                        continue;
                    }
                    /* 到达安全屋 */
                    if (nx == m - 1 && ny == n - 1) {
                        return fireTime[nx][ny] >= time + 1;
                    }
                    /* 火未到达当前位置 */
                    if (fireTime[nx][ny] > time + 1) {
                        queue.offer(new int[]{nx, ny, time + 1});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        return false;
    }
}

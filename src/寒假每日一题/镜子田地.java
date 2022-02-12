package 寒假每日一题;

import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/12 10:50
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1931/ 环图 (所有点的度数都小于等于2的图，仅由链和简单环组成)
 */
public class 镜子田地 {

    static int N = 1010;
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static char[][] g = new char[N][N];
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    static int dfs(int x, int y, int d){
        if(x < 0 || x >= n || y < 0 || y >= m) return 0;
        if(g[x][y] == '/') d ^= 1;
        else d ^= 3;
        return dfs(x + dx[d], y + dy[d], d) + 1;
    }

    public static void main(String[] args) {
        n = sc.nextInt(); m = sc.nextInt();
        for(int i = 0; i < n; i ++ )
            g[i] = sc.next().toCharArray();
        int res = -1;
        for(int i = 0; i < n; i ++ ){
            res = Math.max(res, dfs(i, 0, 1));
            res = Math.max(res, dfs(i, m - 1, 3));
        }
        for(int i = 0; i < m; i ++ ){
            res = Math.max(res, dfs(0, i, 2));
            res = Math.max(res, dfs(n - 1, i, 0));
        }
        System.out.println(res);
        return;
    }
}

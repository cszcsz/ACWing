package 寒假每日一题;

import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/2 17:58
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/2007/ dfs搜索
 */

public class 马蹄铁 {

    static Scanner sc = new Scanner(System.in);
    static int N = 6;
    static int n;
    static char[][] g = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int ans;

    static void dfs(int x, int y, int l, int r){
        st[x][y] = true;
        if(l == r){
            ans = Math.max(ans, l + r);
            st[x][y] = false;
            return;
        }
        for(int i = 0; i < 4; i ++ ){
            int a = x + dx[i], b = y + dy[i];
            if(a < 0 || a >= n || b < 0 || b >= n || st[a][b]) continue;
            if(g[x][y] == ')' && g[a][b] == '(') continue;
            if(g[a][b] == '(') dfs(a, b, l + 1, r);
            else dfs(a, b, l, r + 1);
        }
        st[x][y] = false;
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        for(int i = 0; i < n; i ++ )
            g[i] = sc.next().toCharArray();

        if(g[0][0] == '(')
            dfs(0, 0, 1, 0);
        System.out.println(ans);
        return;
    }
}

package 寒假每日一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/19 13:16
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1857/ 枚举
 */
public class 愤怒的奶牛 {

    static int N = 110;
    static int INF = (int)2e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[N];
        p[0] = -INF; p[n + 1] = INF;
        for(int i = 1; i <= n; i ++ ) p[i] = sc.nextInt();
        Arrays.sort(p, 1, n + 1);
        int res = 0;
        for(int i = 1; i <= n; i ++ ){
            int l = 1, r = 1, a = i, b = i;
            while(p[a] - p[a - 1] <= l){
                int k = a - 1;
                while(p[a] - p[k - 1] <= l) k -- ;
                a = k;
                l ++ ;
            }
            while (p[b + 1] - p[b] <= r){
                int k = b + 1;
                while (p[k + 1] - p[b] <= r) k ++ ;
                b = k;
                r ++ ;
            }
            res = Math.max(res, b - a + 1);
        }
        System.out.println(res);
    }
}

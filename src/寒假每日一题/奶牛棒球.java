package 寒假每日一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/10 17:57
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1947/ 双指针 时间复杂度：O(n^2)
 */
public class 奶牛棒球 {

    static int N = 1010;
    static int[] p = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i ++ ) p[i] = sc.nextInt();
        Arrays.sort(p, 0, n);
        int res = 0;
        for(int i = 0; i + 2 < n; i ++ )
            for(int j = i + 1, l = j + 1, r = j + 1; j + 1 < n; j ++ ){
                while(l < n && p[l] < 2 * p[j] - p[i]) l ++ ;
                while(r < n && p[r] <= 3 * p[j] - 2 * p[i]) r ++ ;
                res += r - l;
            }
        System.out.println(res);
    }
}

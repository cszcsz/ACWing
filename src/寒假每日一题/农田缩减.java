package 寒假每日一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/21 15:05
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1828/ 枚举
 */
public class 农田缩减 {

    static int N = 50010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[N], y = new int[N], a = new int[N], b = new int[N];
        for(int i = 0; i < n; i ++ ){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            a[i] = x[i];
            b[i] = y[i];
        }
        Arrays.sort(a, 0, n);
        Arrays.sort(b, 0, n);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++ ){
            int x1, x2, y1, y2;
            x1 = x[i] == a[0] ? a[1] : a[0];
            x2 = x[i] == a[n - 1] ? a[n - 2]: a[n - 1];
            y1 = y[i] == b[0] ? b[1] : b[0];
            y2 = y[i] == b[n - 1] ? b[n - 2] : b[n - 1];
            res = Math.min(res, (y2 - y1) * (x2 - x1));
        }
        System.out.println(res);
    }

}

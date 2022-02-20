package 寒假每日一题;

import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/20 10:15
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1845/ 枚举
 */
public class 圆形牛棚 {

    static int N = 1010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[N];
        for(int i = 1; i <= n; i ++ ) p[i] = sc.nextInt();
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i ++ ){
            int sum = 0, j = i + 1, dis = 1;
            if(j == n + 1) j = 1;
            while (j != i){
                sum += p[j] * dis;
                dis ++ ;
                j ++ ;
                if(j == n + 1) j = 1;
            }
            res = Math.min(res, sum);
        }
        System.out.println(res);
    }
}

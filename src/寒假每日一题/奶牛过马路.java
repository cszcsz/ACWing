package 寒假每日一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/6 10:19
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1980/ 排序 + 前缀最值
 */
public class 奶牛过马路 {

    static int N = 100010;
    static Line[] l = new Line[N];
    static int[] pmax = new int[N], smin = new int[N];  // 记录前缀最大值和后缀最小值

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i ++ ){
            int a = sc.nextInt(), b = sc.nextInt();
            l[i] = new Line(a, b);
        }
        Arrays.sort(l, 1, n + 1, (o1, o2) -> o1.a - o2.a);
        pmax[0] = Integer.MIN_VALUE;
        smin[n + 1] = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i ++ ) pmax[i] = Math.max(pmax[i - 1], l[i].b);
        for(int i = n; i >= 1; i -- ) smin[i] = Math.min(smin[i + 1], l[i].b);

        int res = 0;
        for(int i = 1; i <= n; i ++ ){
            if(l[i].b > pmax[i - 1] && l[i].b < smin[i + 1])
                res ++ ;
        }
        System.out.println(res);
    }

    static class Line{
        int a, b;
        Line(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

}

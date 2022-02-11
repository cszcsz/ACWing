package 寒假每日一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/11 10:11
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1936/  二路归并
 */
public class 贝茜放慢脚步 {

    static int N = 10010;
    static Scanner sc = new Scanner(System.in);
    static int[] t = new int[N], d = new int[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        int j = 0, k = 0;
        for(int i = 0; i < n; i ++ ){
            String op = sc.next();
            int x = sc.nextInt();
            if(op.equals("T")) t[j ++ ] = x;
            else d[k ++ ] = x;
        }
        Arrays.sort(t, 0, j);
        Arrays.sort(d, 0, k);
        double[] a = new double[N];
        int p = 0, q = 0, z = 0;
        double cur_t = 0, cur_v = 1, cur_d = 0;
        while(p < j && q < k){
            if((d[q] - cur_d) * cur_v < t[p] - cur_t){
                cur_t += (d[q] - cur_d) * cur_v;
                cur_d = d[q];
                q ++ ;
            }else {
                cur_d +=  (t[p] - cur_t) / cur_v;
                cur_t = t[p];
                p ++ ;
            }
            cur_v ++ ;
            a[z ++ ] = cur_d;
        }
        while (p < j){
            cur_d +=  (t[p] - cur_t) / cur_v;
            cur_t = t[p];
            p ++ ;
            cur_v ++ ;
            a[z ++ ] = cur_d;
        }
        while (q < k){
            a[z ++ ] = d[q ++ ];
        }
        double res = 0;
        cur_v = 1; cur_d = 0;
        for(int i = 0; i < z; i ++ ){
            res += (a[i] - cur_d) * cur_v;
            cur_d = a[i];
            cur_v ++ ;
        }
        res += (1000 - cur_d) * cur_v;
        System.out.printf("%.0f", res);
    }
}

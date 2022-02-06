package 寒假每日一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/4 10:14
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/2016/ 枚举
 */
import java.util.Arrays;
import java.util.Scanner;

public class 岛 {

    static Scanner sc = new Scanner(System.in);
    static int N = 100010;
    static int[] h = new int[N];
    static Island[] q = new Island[N];
    public static void main(String[] args) {
        int n = sc.nextInt();
        for(int i = 1; i <= n; i ++ ) h[i] = sc.nextInt();
        int m = 1;
        for(int i = 1; i <= n; i ++ ){
            if(i == 1 || h[i] != h[i - 1]){
                h[m] = h[i];
                m ++ ;
            }
        }
        m -- ;
        h[m + 1] = 0;
        for(int i = 1; i <= m + 1; i ++ ) q[i] = new Island(h[i], i);
        Arrays.sort(q, 1, m + 1, (o1, o2) -> o1.h - o2.h);
        int cnt = 1, res = 1;
        for(int i = 1; i <= m; i ++ ){
            int k = q[i].k;
            if(h[k] > h[k - 1] && h[k] > h[k + 1]) cnt -- ;
            else if(h[k] < h[k - 1] && h[k] < h[k + 1]) cnt ++ ;
            if(q[i].h != q[i + 1].h)  // 如果是最后一个才更新，因为隔的很远处可能有相同高度，需要同步更新
                res = Math.max(res, cnt);
        }
        System.out.println(res);
    }

    static class Island{
        int h, k;
        Island(int h, int k){
            this.h = h;
            this.k = k;
        }
    }
}

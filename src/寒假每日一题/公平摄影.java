package 寒假每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/14 18:03
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1915/ 前缀和 + 哈希表
 */
public class 公平摄影 {

    static Scanner sc = new Scanner(System.in);
    static int N = 100010;
    static Pair[] q = new Pair[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 1; i <= n; i ++ ){
            int x = sc.nextInt();
            String type = sc.next();
            if(type.equals("G")) q[i] = new Pair(x, 1);
            else q[i] = new Pair(x, -1);
        }
        Arrays.sort(q, 1, n + 1, (o1, o2) -> o1.x - o2.x);
        int res = 0, sum = 0, last = 1;
        for(int i = 1; i <= n; i ++ ){
            // -1和1的个数相等的情况
            if(!hash.containsKey(sum)) hash.put(sum, q[i].x);
            sum += q[i].t;
            if(hash.containsKey(sum)) res = Math.max(res, q[i].x - hash.get(sum));
            // 全为-1或全为1的情况
            if(i == 1 || q[i].t != q[last].t) last = i;
            res = Math.max(res, q[i].x - q[last].x);
        }

        System.out.println(res);
    }


    static class Pair{
        int x, t;
        public Pair(int x, int t) {
            this.x = x;
            this.t = t;
        }
    }
}

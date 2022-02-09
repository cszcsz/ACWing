package 寒假每日一题;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/9 18:43
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1954/ 差分 + 离散化
 */
public class 金发姑娘和N头牛 {

    static int N = 20010;
    static int INF = (int)2e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
        Map<Integer, Integer> b = new TreeMap();
        for(int i = 0; i < n; i ++ ){
            int l = sc.nextInt(), r = sc.nextInt();
            b.put(-INF, b.getOrDefault(-INF, 0) + x);
            b.put(l, b.getOrDefault(l, 0) - x + y);
            b.put(r + 1, b.getOrDefault(r + 1, 0) - y + z);
            b.put(INF, b.getOrDefault(INF, 0) - z);
        }
        int res = 0, sum = 0;
        for(int k : b.keySet()){
            sum += b.get(k);
            res = Math.max(res, sum);
        }
        System.out.println(res);
        return;
    }
}

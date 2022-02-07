package 寒假每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/7 16:07
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1971/ 我的做法：哈希表  yxc的做法：滑动窗口双指针（队列实现）
 */
public class 品种邻近 {

    static int N = 50010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        Map<Integer, Integer> m = new HashMap<>();
        int res = -1;
        for(int i = 0; i < n; i ++ ){
            int id = sc.nextInt();
            if(m.containsKey(id) && i - m.get(id) <= k )
                res = Math.max(res, id);
            m.put(id, i);
        }
        System.out.println(res);
    }

}

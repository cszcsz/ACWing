package 寒假每日一题;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/5 10:24
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1989/ 差分 + 离散化
 */
public class 粉刷栅栏 {

    static int N = 100010;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> m = new TreeMap<>((o1, o2) -> o1 - o2);
        int n, x = 0, y;
        String op;
        n = sc.nextInt();
        for(int i = 0; i < n; i ++ ){
            y = sc.nextInt();
            op = sc.next();
            if(op.equals("R")){
                m.put(x, m.getOrDefault(x, 0) + 1);
                m.put(x + y, m.getOrDefault(x + y, 0) - 1);
                x = x + y;
            }else{
                m.put(x - y, m.getOrDefault(x - y, 0) + 1);
                m.put(x, m.getOrDefault(x, 0) - 1);
                x = x - y;
            }
        }
        int res = 0, last = 0, sum = 0;
        for(int i : m.keySet()){
            if(sum >= 2) res += i - last;
            sum += m.get(i);
            last = i;
        }
        System.out.println(res);
        return;
    }
}

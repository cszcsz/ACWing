package 寒假每日一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/13 17:10
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1924/  双指针
 */
public class 懒惰的牛 {

    static int N = 100010;
    static Scanner sc = new Scanner(System.in);
    static int n, m;
    static Grass[] q = new Grass[N];

    public static void main(String[] args) {
        n = sc.nextInt(); m = sc.nextInt();
        for(int i = 0; i < n; i ++ ){
            int t1 = sc.nextInt(), t2 = sc.nextInt();
            q[i] = new Grass(t1, t2);
        }
        Arrays.sort(q, 0, n, (o1, o2) -> o1.x - o2.x);
        int res = 0, sum = 0;
        for(int i = 0, j = 0; i < n; i ++ ){
            sum += q[i].g;
            while(q[i].x - q[j].x > 2 * m) sum -= q[j ++ ].g;
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }

    static class Grass{
        int g, x;
        Grass(int g, int x){
            this.g = g;
            this.x = x;
        }
    }
}

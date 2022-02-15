package 寒假每日一题;

import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/15 18:48
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1906/  模拟，思维题
 */
public class 奶牛慢跑 {

    static Scanner sc = new Scanner(System.in);
    static int N = 100010;
    static int[] v = new int[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        for(int i = 0; i < n; i ++ ){
            int x = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int res = 0, curMin = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i -- ){
            if(v[i] <= curMin){
                res ++ ;
                curMin = v[i];
            }
        }
        System.out.println(res);
    }
}

package 寒假每日一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/8 18:31
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1962/ 位运算 + 状态压缩 + 找环
 * 注：状态压缩：将01串表示的状态用一个整数(int)表示
 */
public class 闪烁 {

    static int N = 1 << 16;
    static int n, state;
    static long m;
    static int[] p = new int[N];   // p数组记录每个状态是第几步走到的

    static void print(int state){
        for(int i = 0; i < n; i ++ ){
            System.out.println(state >> i & 1);
        }
    }
    static int update(int state){
        int res = 0;
        for(int i = 0; i < n; i ++ ){
            int j = (i - 1 + n) % n;   // 它右边的那位
            int x = state >> i & 1, y = state >> j & 1;
            res |= (x ^ y) << i;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextLong();
        Arrays.fill(p, -1);
        for(int i = 0; i < n; i ++ ){
            int x = sc.nextInt();
            state |= x << i;
        }
        p[state] = 0;
        for(int i = 1; ; i ++ ){
            state = update(state);
            if(i == m){
                print(state);
                break;
            }
            else if(p[state] == -1) p[state] = i;
            else{
                int len = i - p[state];
                int r = (int) ((m - i) % len);
                while(r -- > 0) state = update(state);
                print(state);
                break;
            }
        }
        return;
    }
}

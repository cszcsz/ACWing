package 寒假每日一题;

import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/22 10:35
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1815/ 枚举
 */
public class 方块游戏 {

    static int N = 110;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] a = new String[N], b = new String[N];
        for(int i = 0; i < n; i ++ ){
            a[i] = sc.next();
            b[i] = sc.next();
        }
        int[] res = new int[27];
        for(int i = 0; i < n; i ++ ){
            int[] x = new int[27], y = new int[27];
            for(int j = 0; j < a[i].length(); j ++ )
                x[a[i].charAt(j) - 'a'] ++ ;
            for(int j = 0; j < b[i].length(); j ++ )
                y[b[i].charAt(j) - 'a'] ++ ;
            for(int j = 0; j < 26; j ++ )
                res[j] += Math.max(x[j], y[j]);
        }
        for(int i = 0; i < 26; i ++ )
            System.out.println(res[i]);
    }
}

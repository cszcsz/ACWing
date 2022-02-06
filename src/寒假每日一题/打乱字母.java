package 寒假每日一题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/3 9:46
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1998/ 贪心 + 二分
 */
public class 打乱字母 {

    static Scanner sc = new Scanner(System.in);
    static int N = 50010;
    static String[] a = new String[N], b = new String[N], c = new String[N];

    public static void main(String[] args) {
        int n = sc.nextInt();
        for(int i = 1; i <= n; i ++ ){
            String s = sc.next();
            a[i] = s;
            char[] t = s.toCharArray();
            Arrays.sort(t);
            c[i] = new String(t);
            b[i] = new StringBuilder(c[i]).reverse().toString();
        }
        Arrays.sort(b, 1, n + 1);
        Arrays.sort(c, 1, n + 1);
        for(int i = 1; i <= n; i ++ ){
            char[] t = a[i].toCharArray();
            Arrays.sort(t);
            String s = new String(t);
            int l = 1, r = n;
            while(l < r){
                int mid = l + r >> 1;
                if(b[mid].compareTo(s) >= 0) r = mid;
                else l = mid + 1;
            }
            System.out.print(r + " ");

            s = new StringBuilder(s).reverse().toString();
            l = 1; r = n;
            while (l < r){
                int mid = l + r + 1>> 1;
                if(c[mid].compareTo(s) <= 0) l = mid;
                else r = mid - 1;
            }
            System.out.println(r);
        }

        return;
    }
}

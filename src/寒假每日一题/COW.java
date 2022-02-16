package 寒假每日一题;

import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/16 12:13
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1886/ 递推、状态机DP
 */
public class COW {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] s = sc.next().toCharArray();
        long a = 0, b = 0, c = 0;
        for(int i = 0; i < s.length; i ++ ){
            if(s[i] == 'C') a ++ ;          // 记录前面字符串"C"出现的次数
            else if(s[i] == 'O') b += a;    // 记录前面字符串"CO"出现的次数
            else c += b;                    // 记录前面字符串"COW"出现的次数
        }
        System.out.println(c);
    }
}

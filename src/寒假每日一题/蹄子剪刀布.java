package 寒假每日一题;

import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/24 10:01
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1803/ 枚举
 */
public class 蹄子剪刀布 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输赢矩阵只存在两种情况，枚举这两种情况看哪种赢的场数多即可
        int[][] case1 = {{0, -1, 1}, {1, 0, -1}, {-1, 1, 0}}, case2 = {{0, 1, -1}, {-1, 0, 1}, {1, -1, 0}};
        int n = sc.nextInt();
        int p1 = 0, p2 = 0, res = 0;
        for(int i = 0; i < n; i ++ ){
            int a = sc.nextInt(), b = sc.nextInt();
            a -- ; b -- ;
            if(case1[a][b] == 1) p1 ++ ;
            if(case2[a][b] == 1) p2 ++ ;
        }
        res = Math.max(p1, p2);
        System.out.println(res);
    }

}

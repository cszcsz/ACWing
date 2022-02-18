package 寒假每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * @author: CaiSongZhi
 * @date: 2022/2/18 16:53
 * @project: 寒假每日一题
 * @content: https://www.acwing.com/problem/content/1877/ 二进制枚举
 */

public class 贝茜的报复 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = "BESIGOM".toCharArray();
        Map<Character, Integer> ji = new HashMap<>();
        Map<Character, Integer> ou = new HashMap<>();
        int n = sc.nextInt();
        // 预处理输入，得到每种字符取值奇数出现多少次、偶数出现多少次
        for(int i = 0; i < n; i ++ ){
            char c = sc.next().toCharArray()[0];
            int x = sc.nextInt();
            if(x % 2 == 0) ou.put(c, ou.getOrDefault(c, 0) + 1);
            else ji.put(c, ji.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        Map<Character, Integer> v = new HashMap<>();
        for(int i = 0; i < 1 << 7; i ++ ){
            for(int j = 0; j < 7; j ++ )
                v.put(str[j], i >> j & 1);
            if((v.get('B') + v.get('I')) * (v.get('G') + v.get('O') + v.get('E') + v.get('S')) * v.get('M') % 2 == 0){
                int sum = 1;
                for(int j = 0; j < 7; j ++ ){
                    if(v.get(str[j]) == 1) sum *= ji.getOrDefault(str[j], 0);
                    else sum *= ou.getOrDefault(str[j], 0);
                }
                res += sum;
            }
        }
        System.out.println(res);
    }
}

package Leetcode.week1;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/27 11:59
 * @project: Leetcode.week1
 * @content: https://leetcode-cn.com/problems/zigzag-conversion/ 中等
 */

public class P6_Z字形变换 {
    public String convert(String s, int n) {
        if(n == 1) return s;
        String res = "";
        for(int i = 0; i < n; i ++ ){
            if(i == 0 || i == n - 1){
                for(int j = i; j < s.length(); j += 2 * n - 2)
                    res += s.charAt(j);
            }else {
                for(int j = i, k = 2 * n - 2 - i; j < s.length() || k < s.length(); j += 2 * n - 2, k += 2 * n - 2){
                    if(j < s.length()) res += s.charAt(j);
                    if(k < s.length()) res += s.charAt(k);
                }
            }
        }
        return res;
    }
}

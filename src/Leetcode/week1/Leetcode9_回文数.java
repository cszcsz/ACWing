package Leetcode.week1;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/23 9:15
 * @project: Leetcode.week1
 * @content: https://leetcode-cn.com/problems/palindrome-number/ 简单
*            进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class Leetcode9_回文数 {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        long res = 0, t = x;
        while(x != 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res == t;
    }
}

package Leetcode.week1;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/28 9:33
 * @project: Leetcode.week1
 * @content: https://leetcode-cn.com/problems/reverse-integer/ 中等
 */
public class P7_整数反转 {

    public int reverse(int x) {
        int res = 0;
        while(x != 0){
            if(res > 0 && res > (Integer.MAX_VALUE - x % 10) / 10) return 0;
            if(res < 0 && res < (Integer.MIN_VALUE - x % 10) / 10) return 0;
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}

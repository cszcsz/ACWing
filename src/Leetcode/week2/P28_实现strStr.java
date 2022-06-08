package Leetcode.week2;

/**
 * @author: CaiSongZhi
 * @date: 2022/3/8 8:56
 * @project: Leetcode.week2
 * @content: https://leetcode-cn.com/problems/implement-strstr/submissions/ 简单
 * KMP next[i]的含义：所有p[1~i]相等的前缀和后缀中，长度的最大值。（这里的前缀和后缀是非平凡的，即不包括本身即是前缀又是后缀那组情况）
 */
public class P28_实现strStr {
    public int strStr(String s, String p) {
        if(p.equals("")) return 0;
        int n = s.length(), m = p.length();
        s = " " + s; p = " " + p;
        int[] next = new int[m + 1];
        for(int i = 2, j = 0; i <= m; i ++ ){
            while (j > 0 && p.charAt(i) != p.charAt(j + 1)) j = next[j];
            if(p.charAt(i) == p.charAt(j + 1)) j ++ ;
            next[i] = j;
        }

        for(int i = 1, j = 0; i <= n; i ++ ){
            while (j > 0 && s.charAt(i) != p.charAt(j + 1)) j = next[j];
            if(s.charAt(i) == p.charAt(j + 1)) j ++ ;
            if(j == m) return i - m;
        }
        return -1;
    }
}



package Leetcode.week2;

/**
 * @author: CaiSongZhi
 * @date: 2022/2/26 11:03
 * @project: Leetcode.week2.Leetcode14
 * @content: https://leetcode-cn.com/problems/longest-common-prefix/ 简单
 */
public class Leetcode14_最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs.length == 0) return res;
        for(int i = 0; ; i ++ ){
            if(strs[0].length() <= i) return res;
            char c = strs[0].charAt(i);
            for(int j = 0; j < strs.length; j ++ ){
                if(strs[j].length() <= i || strs[j].charAt(i) != c) return res;
            }
            res += c;
        }
    }

}

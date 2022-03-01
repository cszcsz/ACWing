package Leetcode.week2;

import java.util.*;

/**
 * @author: CaiSongZhi
 * @date: 2022/3/1 8:56
 * @project: Leetcode.week2
 * @content: https://leetcode-cn.com/problems/integer-to-roman/ 中等
 */
public class P12_整数转罗马数字 {
    public String intToRoman(int num) {
        String res = "";
        Map<String, Integer> h = new HashMap<>();
        h.put("I", 1); h.put("IV", 4); h.put("V", 5); h.put("IX", 9); h.put("X", 10);
        h.put("XL", 40); h.put("L", 50); h.put("XC", 90); h.put("C", 100); h.put("CD", 400);
        h.put("D", 500); h.put("CM", 900); h.put("M", 1000);
        String[] s = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        while (num != 0){
            for(int i = s.length - 1; i >= 0; i -- ){
                if(num >= h.get(s[i])){
                    num -= h.get(s[i]);
                    res += s[i];
                    break;
                }
            }
        }
        return res;
    }
}

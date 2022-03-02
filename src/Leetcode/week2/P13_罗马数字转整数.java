package Leetcode.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: CaiSongZhi
 * @date: 2022/3/2 8:55
 * @project: Leetcode.week2
 * @content: https://leetcode-cn.com/problems/roman-to-integer/ 简单
 */
public class P13_罗马数字转整数 {
    public int romanToInt(String s) {
        int res = 0;
        Map<String, Integer> h = new HashMap<>();
        h.put("I", 1); h.put("IV", 4); h.put("V", 5); h.put("IX", 9); h.put("X", 10);
        h.put("XL", 40); h.put("L", 50); h.put("XC", 90); h.put("C", 100); h.put("CD", 400);
        h.put("D", 500); h.put("CM", 900); h.put("M", 1000);
        for(int i = 0; i < s.length(); i ++ ){
            if (i + 1 < s.length() && h.get("" + s.charAt(i)) < h.get("" + s.charAt(i + 1))){
                String tmp = "" + s.charAt(i) + s.charAt(i + 1);
                res += h.get(tmp);
                i ++;
            }
            else{
                res += h.get("" + s.charAt(i));
            }
        }
        return res;
    }
}

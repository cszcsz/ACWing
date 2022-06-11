package 暑假每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/6/11 10:30
 * @project: 暑假每日一题
 * @content: https://www.acwing.com/problem/content/4272/
 */
public class 校庆 {

    static Scanner sc = new Scanner(System.in);
    static int N = 100010;
    static Map<String, Boolean> h = new HashMap<>();

    public static void main(String[] args) {
        int n = sc.nextInt();
        for(int i = 0; i < n; i ++ ){
            String id = sc.next();
            h.put(id, true);
        }
        int m = sc.nextInt(), cnt = 0;
        int g_min = Integer.MAX_VALUE, v_min =  Integer.MAX_VALUE;
        String g = "", v = "";
        for(int i = 0; i < m; i ++ ){
            String id = sc.next();
            int day = birth_to_day(id);
            if(day < v_min){
                v_min = day;
                v = id;
            }
            if(h.getOrDefault(id, false)){
                cnt ++ ;
                if(day < g_min){
                    g_min = day;
                    g = id;
                }
            }
        }
        System.out.println(cnt);
        if(!g.equals("")) System.out.println(g);
        else System.out.println(v);
    }

    public static int birth_to_day(String id){
        String birth = id.substring(6, 14);
        String year = birth.substring(0, 4), month = birth.substring(4, 6), day = birth.substring(6, 8);
        return Integer.parseInt(year) * 365 + Integer.parseInt(month) * 30 + Integer.parseInt(day);
    }
}

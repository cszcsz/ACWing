package 暑假每日一题;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author: CaiSongZhi
 * @date: 2022/6/13 9:11
 * @project: 暑假每日一题
 * @content: https://www.acwing.com/problem/content/4276/
 */
public class 链表合并 {

    static int N = 100010;

    static class Node{
        String address;
        String next;
        int v;
        public Node(String address, String next, int v) {
            this.address = address;
            this.next = next;
            this.v = v;
        }
    }
    static Map<String, Node> h = new HashMap<>();
    static ArrayList<Node> tempA = new ArrayList<>();
    static ArrayList<Node> tempB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        String a = str[0], b = str[1];
        int n = Integer.parseInt(str[2]);
        for(int i = 0; i < n; i ++ ){
            str = br.readLine().split(" ");
            String address = str[0];
            int v = Integer.parseInt(str[1]);
            String next = str[2];
            h.put(address, new Node(address, next, v));
        }
        String p = a, q = b;
        while (!p.equals("-1")){
            Node cur = h.get(p);
            tempA.add(cur);
            p = cur.next;
        }
        while (!q.equals("-1")){
            Node cur = h.get(q);
            tempB.add(cur);
            q = cur.next;
        }
        if(tempB.size() < tempA.size()){
            Collections.reverse(tempB);
        }else {
            Collections.reverse(tempA);
            ArrayList temp = tempA;
            tempA = tempB;
            tempB = temp;
        }
        int i = 0, j = 0, cnt = 0;
        while (i < tempA.size() && j < tempB.size()){
            if(cnt < 2){
                Node cur = tempA.get(i);
                if(cnt == 1) cur.next = tempB.get(j).address;
                System.out.println(cur.address + " " + cur.v + " " + cur.next);
                cnt ++ ;
                i ++ ;
            }
            else if(cnt == 2){
                Node cur = tempB.get(j);
                cur.next = tempA.get(i).address;
                System.out.println(cur.address + " " + cur.v + " " + cur.next);
                cnt = 0 ;
                j ++ ;
            }
        }
        while (i < tempA.size()){
            Node cur = tempA.get(i);
            System.out.println(cur.address + " " + cur.v + " " + cur.next);
            i ++ ;
        }

    }
}

package 暑假每日一题;

import java.util.Scanner;

/**
 * @author: CaiSongZhi
 * @date: 2022/6/10 9:13
 * @project: 暑假每日一题
 * @content: https://www.acwing.com/problem/content/4271/
 */
public class 性感素数 {

    static boolean isPrime(int n){
        if(n < 2) return false;
        for(int i = 2; i * i <= n; i ++ )
            if(n % i == 0) return false;
        return true;
    }

    static boolean isSexPrime(int n){
        if(!isPrime(n)) return false;
        return isPrime(n - 6) || isPrime(n + 6);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(isSexPrime(n)){
            System.out.println("Yes");
            if(isPrime(n - 6)) System.out.println(n - 6);
            else System.out.println(n + 6);
        }
        else{
            System.out.println("No");
            for(int i = n ; ; i ++ ){
                if(isSexPrime(i)){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}

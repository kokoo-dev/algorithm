package com.algorithm.kokoo.baekjoon;
import java.util.*;
public class Baekjoon2579 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] wine = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            wine[i] = sc.nextInt();
        }

        dp[1] = wine[1];

        if(2 <= n)
            dp[2] = wine[1] + wine[2];

        for(int i=3; i<=n; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + wine[i-1]) + wine[i];
        }

        System.out.println(dp[n]);
    }
}

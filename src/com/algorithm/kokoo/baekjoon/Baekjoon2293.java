package com.algorithm.kokoo.baekjoon;
import java.util.*;
public class Baekjoon2293 {

    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] dp = new int[k+1];

        dp[0] = 1;

        for(int i=0; i<n; i++){
            int coin = sc.nextInt();
            for(int j=coin; j<=k; j++){
                dp[j] += dp[j-coin];
            }
        }

        System.out.println(dp[k]);
    }
}

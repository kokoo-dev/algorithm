package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon12865 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] bags = new int[n+1][2];
        int[][] dp = new int[n+1][k+1];

        for(int i=1; i<=n; i++){
            bags[i][0] = sc.nextInt();
            bags[i][1] = sc.nextInt();
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=k; j++){
                if(bags[i][0] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(bags[i][1] + dp[i-1][j-bags[i][0]], dp[i-1][j]);
            }
        }

        System.out.println(dp[n][k]);
    }
}

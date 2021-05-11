package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon1309 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][3];
        int mod = 9901;

        for(int i=0; i<3; i++){
            dp[0][i] = 1;
        }

        for(int i=1; i<n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % mod;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
        }

        int answer = (dp[n-1][0] + dp[n-1][1] + dp[n-1][2]) % mod;
        System.out.println(answer);
    }
}

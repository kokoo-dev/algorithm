package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon1932 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n-(n-1)+i; j++){
                dp[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<n-(n-1)+i; j++){
                if(j > 0){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + dp[i][j];
                    continue;
                }

                dp[i][j] = dp[i][j] + dp[i-1][j];
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            answer = Math.max(dp[n-1][i], answer);
        }

        System.out.println(answer);
    }
}

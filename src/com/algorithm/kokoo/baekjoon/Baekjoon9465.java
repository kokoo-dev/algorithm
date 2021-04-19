package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon9465 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] sticker;
        int[][] dp;

        for(int i=0; i<n; i++){
            int col = sc.nextInt();
            sticker = new int[2][col+1];
            dp = new int[2][col+1];

            for(int j=0; j<2; j++)
                for(int k=1; k<=col; k++)
                    sticker[j][k] = sc.nextInt();

            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for(int j=2; j<=col; j++){
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + sticker[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + sticker[1][j];
            }

            System.out.println(Math.max(dp[0][col], dp[1][col]));
        }
    }
}

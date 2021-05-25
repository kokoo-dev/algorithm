package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon11660 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] table = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        int[] answers = new int[m];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                table[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + table[i][j];
            }
        }

        for(int i=0; i<m; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            answers[i] = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1];
        }

        for (int i=0; i<m; i++){
            System.out.println(answers[i]);
        }
    }
}

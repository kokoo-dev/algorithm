package com.algorithm.kokoo.baekjoon;
import java.util.*;

public class Baekjoon1890 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        long[][] dp = new long[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==n-1&&j==n-1) continue;

                int jump = board[i][j];
                int ni = i+jump;
                int nj = j+jump;

                if(ni < n)
                    dp[ni][j] += dp[i][j];

                if(nj < n)
                    dp[i][nj] += dp[i][j];

            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}

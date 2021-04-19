package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon11048 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                maze[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = maze[0][0];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i!=0)
                    dp[i][j] = Math.max(maze[i][j] + dp[i-1][j], dp[i][j]);

                if(j!=0)
                    dp[i][j] = Math.max(maze[i][j] + dp[i][j-1], dp[i][j]);
            }
        }

        System.out.println(dp[n-1][m-1]);
    }
}

package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon10164 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x1 = 1;
        int x2 = n;
        int y1 = 1;
        int y2 = m;
        int[][] dp = new int[n+1][m+1];

        int count = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(count == k) {
                    x2 = i;
                    y2 = j;
                }

                count++;
            }
        }

        dp[1][1] = 1;

        calc(dp, x1, x2, y1, y2);

        if (k != 0) {
            x1 = x2;
            y1 = y2;
            x2 = n;
            y2 = m;

            calc(dp, x1, x2, y1, y2);
        }

        System.out.println(dp[n][m]);
    }

    public void calc(int[][] dp, int x1, int x2, int y1, int y2){
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if(x1 == i && y1 == j)
                    continue;

                dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
            }
        }
    }
}

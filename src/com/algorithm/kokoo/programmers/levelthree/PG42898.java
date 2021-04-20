package com.algorithm.kokoo.programmers.levelthree;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42898
 * 레벨3 - 등굣길
 * DP 풀이
 * 웅덩이 있는경우 0으로 지정
 */
public class PG42898 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        int mod = 1000000007;

        for(int i=0; i<puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }


        dp[1][1] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] += dp[i-1][j] % mod + dp[i][j-1] % mod;
            }
        }

        return dp[n][m] % mod;
    }
}

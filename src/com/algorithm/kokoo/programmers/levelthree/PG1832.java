package com.algorithm.kokoo.programmers.levelthree;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/1832
 * 레벨3 - 보행자 천국
 * DP 풀이
 * 직진만 가능한 경우가 있기에 right, down을 따로 구함
 */
public class PG1832 {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][] right = new int[m+1][n+1];
        int[][] down = new int[m+1][n+1];

        right[1][1] = 1;
        down[1][1] = 1;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                int city = cityMap[i-1][j-1];

                if(city == 0){
                    right[i][j] += (right[i][j-1] + down[i-1][j]) % MOD;
                    down[i][j] += (down[i-1][j] + right[i][j-1]) % MOD;
                } else if(city == 1){
                    right[i][j] = 0;
                    down[i][j] = 0;
                } else if(city == 2){
                    right[i][j] = right[i][j-1] % MOD;
                    down[i][j] = down[i-1][j] % MOD;
                }
            }
        }

        return right[m][n] % MOD;
    }
}

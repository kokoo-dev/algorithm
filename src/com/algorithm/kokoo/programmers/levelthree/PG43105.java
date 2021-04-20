package com.algorithm.kokoo.programmers.levelthree;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42898
 * 레벨3 - 정수 삼각형
 * DP 풀이
 * i-1,j 와 i-1,j-1 중 합산 값이 높은 수로 저장
 */
public class PG43105 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];

        for(int i=1; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                dp[i][j] = dp[i-1][j] + triangle[i][j];

                if(j > 0)
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + triangle[i][j]);
            }
        }

        for(int i=0; i<dp[dp.length-1].length; i++){
            answer = Math.max(answer, dp[dp.length-1][i]);
        }

        return answer;
    }
}

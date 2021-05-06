package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon2602 {
    public static final int DEVIL = 0;
    public static final int ANGEL = 1;

    public void run(){
        Scanner sc = new Scanner(System.in);

        String scroll = sc.next();
        String devil = sc.next();
        String angel = sc.next();

        int[][][] dp = new int[2][devil.length()][scroll.length()];

        if (scroll.charAt(0) == devil.charAt(0))
            dp[DEVIL][0][0] = 1;

        if (scroll.charAt(0) == angel.charAt(0))
            dp[ANGEL][0][0] = 1;

        for(int i=1; i<devil.length(); i++){
            dp[DEVIL][i][0] = devil.charAt(i) == scroll.charAt(0) ? dp[DEVIL][i-1][0] + 1 : dp[DEVIL][i-1][0];
            dp[ANGEL][i][0] = angel.charAt(i) == scroll.charAt(0) ? dp[ANGEL][i-1][0] + 1 : dp[ANGEL][i-1][0];

            for(int j=1; j<scroll.length(); j++){
                dp[DEVIL][i][j] = devil.charAt(i) == scroll.charAt(j) ? dp[DEVIL][i-1][j] + dp[ANGEL][i-1][j-1] : dp[DEVIL][i-1][j];
                dp[ANGEL][i][j] = angel.charAt(i) == scroll.charAt(j) ? dp[ANGEL][i-1][j] + dp[DEVIL][i-1][j-1] : dp[ANGEL][i-1][j];
            }
        }

        System.out.println(dp[DEVIL][devil.length()-1][scroll.length()-1] + dp[ANGEL][devil.length()-1][scroll.length()-1]);
    }
}

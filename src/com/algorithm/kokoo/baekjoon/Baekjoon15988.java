package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon15988 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] dp = new long[1000000];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;

        for(int i=0; i<t; i++){
            int num = sc.nextInt();

            for (int j = 3; j < num; j++) {
                dp[j] = (dp[j - 3] + dp[j - 2] + dp[j - 1]) % 1000000009;
            }

            System.out.println(dp[num-1]);
        }
    }
}

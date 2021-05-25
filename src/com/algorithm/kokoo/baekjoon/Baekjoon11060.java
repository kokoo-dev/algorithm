package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon11060 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] jump = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            jump[i] = sc.nextInt();
            dp[i] = -1;
        }

        dp[0] = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(dp[j] == -1 || i-j > jump[j])
                    continue;

                if(dp[i] == -1 || dp[j] + 1 < dp[i])
                    dp[i] = dp[j] + 1;
            }
        }

        System.out.println(dp[n-1]);
    }
}

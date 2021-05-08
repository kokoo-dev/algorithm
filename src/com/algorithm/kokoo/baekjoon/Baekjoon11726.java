package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon11726 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n];

        if (n < 2){
            System.out.println(n);
        } else {
            dp[0] = 1;
            dp[1] = 2;

            for(int i=2; i<n; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            }

            System.out.println(dp[n-1]);
        }
    }
}

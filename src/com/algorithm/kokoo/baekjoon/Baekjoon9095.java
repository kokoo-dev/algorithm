package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon9095 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=1; i<=n; i++){
            System.out.println(getCase(sc.nextInt()));
        }
    }

    public int getCase(int a){
        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=a; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[a];
    }
}

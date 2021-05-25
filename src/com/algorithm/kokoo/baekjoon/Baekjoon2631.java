package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon2631 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] children = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            children[i] = sc.nextInt();
        }

        dp[0] = 1;

        for(int i=1; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(children[i] > children[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
        }

        int answer = 0;
        for(int i : dp)
            answer = answer < i ? i : answer;

        System.out.println(n - answer);
    }
}

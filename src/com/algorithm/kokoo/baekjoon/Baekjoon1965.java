package com.algorithm.kokoo.baekjoon;
import java.util.*;
public class Baekjoon1965 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] box = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            box[i] = sc.nextInt();
        }

        Arrays.fill(dp,1);

        int max = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(box[j] < box[i] && dp[i] <=dp[j])
                    dp[i] = dp[j] + 1;
            }
            if(max < dp[i])
                max = dp[i];
        }

        System.out.println(max);
    }
}

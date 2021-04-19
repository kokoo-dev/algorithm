package com.algorithm.kokoo.baekjoon;
import java.util.*;
public class Baekjoon1912 {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = scanner.nextInt();
        }

        dp[0] = nums[0];
        int max = nums[0];

        for(int i=1; i<n; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}

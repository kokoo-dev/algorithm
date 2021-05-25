package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon1495 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] dp = new boolean[n][m+1];
        int[] volumes = new int[n];

        for(int i=0; i<n; i++){
            volumes[i] = sc.nextInt();
        }

        if(s + volumes[0] <= m)
            dp[0][s + volumes[0]] = true;

        if(s - volumes[0] >= 0)
            dp[0][s - volumes[0]] = true;

        for(int i=1; i<n; i++){
            for(int j=0; j<=m; j++){
                if(!dp[i-1][j])
                    continue;

                if(j + volumes[i] <= m)
                    dp[i][j + volumes[i]] = true;

                if(j - volumes[i] >= 0)
                    dp[i][j - volumes[i]] = true;
            }
        }

        int answer = -1;
        for(int i=m; i>=0; i--){
            if(dp[n-1][i]){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}

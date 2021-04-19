package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon13305 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] distance = new long[n-1];
        long[] cost = new long[n];

        for(int i=0; i<n-1; i++){
            distance[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            cost[i] = sc.nextInt();
        }

        long answer = 0;
        long minCost = cost[0];

        for(int i=0; i<n-1; i++){

            if(minCost > cost[i])
                minCost = cost[i];

            answer += minCost * distance[i];

        }

        System.out.println(answer);
    }
}

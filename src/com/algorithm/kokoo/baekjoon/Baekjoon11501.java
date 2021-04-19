package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon11501 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int t = sc.nextInt();
            int[] prices = new int[t];
            for(int j=0; j<t; j++){
                prices[j] = sc.nextInt();
            }
            System.out.println(getBenefit(prices));

        }
    }

    public long getBenefit(int[] prices){
        long answer = 0;

        int limitPrice = Integer.MIN_VALUE;

        for(int i=prices.length-1; i>=0; i--){
            if(limitPrice < prices[i]){
                limitPrice = prices[i];
            } else {
                answer += limitPrice - prices[i];
            }
        }

        return answer;
    }
}

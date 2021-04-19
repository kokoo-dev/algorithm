package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon11047 {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] coin = new int[n];
        for(int i=0; i<n; i++){
            coin[i] = scanner.nextInt();
        }

        int answer = 0;

        for(int i=n-1; i>=0; i--){
            if(k>=coin[i]){
                answer+=k/coin[i];
                k=k%coin[i];
            }
        }

        System.out.println(answer);
    }
}

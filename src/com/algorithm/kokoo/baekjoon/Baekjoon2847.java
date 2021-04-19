package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon2847 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for(int i=0; i<n; i++){
            scores[i] = sc.nextInt();
        }

        int tmp = scores[n-1];
        int answer = 0;
        for(int i=n-2; i>=0; i--){
            int score = scores[i];
            if(score >= tmp){
                int result = score - tmp + 1;
                scores[i] = tmp - 1;
                tmp = tmp - 1;
                answer += result;
                continue;
            }

            tmp = score;
        }

        System.out.println(answer);
    }
}

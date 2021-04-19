package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon5585 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int change = 1000 - n;
        int[] coin = {500, 100, 50, 10, 5, 1};

        int index = 0;
        int answer = 0;
        while(change > 0){
            if(coin[index] <= change){
                change -= coin[index];
                answer++;
                continue;
            }

            index++;
        }

        System.out.println(answer);
    }
}

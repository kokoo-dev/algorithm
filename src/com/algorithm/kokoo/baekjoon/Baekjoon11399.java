package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon11399 {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] time = new int[n];
        for(int i=0; i<n; i++){
            time[i] = scanner.nextInt();
        }

        Arrays.sort(time);

        int acc = 0;
        int answer = 0;
        for(int a : time){
            acc +=a;
            answer += acc;
        }

        System.out.println(answer);
    }
}

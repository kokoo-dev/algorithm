package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon1946 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int[] grades = new int[n+1];

            for(int j=0; j<n; j++){
                int document = sc.nextInt();
                int interview = sc.nextInt();
                grades[document] = interview;
            }

            int highScore = grades[1];
            int answer = 1;

            for(int j=2; j<=n; j++){
                if(grades[j] < highScore){
                    highScore = grades[j];
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}

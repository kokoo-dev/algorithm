package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon2798 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] cards = new int[n];
        int max = 0;

        for(int i=0; i<n; i++){
            cards[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    int temp = cards[i] + cards[j] + cards[k];

                    if(temp <= m){
                        max = Math.max(max, temp);
                    }
                }
            }
        }

        System.out.println(max);
    }
}

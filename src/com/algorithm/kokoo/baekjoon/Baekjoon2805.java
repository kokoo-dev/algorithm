package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon2805 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] trees = new int[n];

        for(int i=0; i<n; i++){
            trees[i] = sc.nextInt();
        }

        Arrays.sort(trees);

        long left = 0;
        long right = trees[n-1];

        while(left <= right){
            long mid = (left + right) / 2;
            long meter = 0;
            for(int i=0; i<n; i++){
                if(trees[i] > mid) {
                    meter += trees[i] - mid;
                }
            }

            if(meter < m){
                right = mid - 1;
            } else if(meter >= m){
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}

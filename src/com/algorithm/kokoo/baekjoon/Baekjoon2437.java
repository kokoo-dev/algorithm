package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon2437 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int sum = 0;
        for(int i=0; i<n; i++){
            if(sum+1 < arr[i])
                break;

            sum += arr[i];
        }

        System.out.println(sum+1);
    }
}

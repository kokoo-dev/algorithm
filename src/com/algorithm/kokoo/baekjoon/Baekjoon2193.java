package com.algorithm.kokoo.baekjoon;
import java.util.*;
public class Baekjoon2193 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        if(n <= 2){
            arr[n-1] = 1;
        } else {
            arr[0] = 1;
            arr[1] = 1;
            for(int i=2; i<n; i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
        }

        System.out.println(arr[n-1]);
    }
}

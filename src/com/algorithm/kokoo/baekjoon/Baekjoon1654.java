package com.algorithm.kokoo.baekjoon;
import java.util.*;
public class Baekjoon1654 {

    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        long left = 1;
        long right = 0;
        for(int i=0; i<n; i++){
            int cm = sc.nextInt();
            arr[i] = cm;
            right = Math.max(right, cm);
        }

        while(left<=right){
            long mid = (left + right) / 2;
            long tmp = 0;
            for(int i=0; i<n; i++){
                tmp += arr[i] / mid;
            }

            if(tmp < m){
                right = mid - 1;
            } else if(tmp >= m){
                left = mid + 1;
            }
        }

        System.out.println(right);
    }
}

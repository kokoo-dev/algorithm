package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon2231 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            String s = String.valueOf(i);
            int temp = i;

            for(int j=0; j<s.length(); j++){
                temp += s.charAt(j)-'0';
            }

            if(temp == n) {
                min = Math.min(min, i);
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}

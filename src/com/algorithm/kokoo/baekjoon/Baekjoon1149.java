package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon1149 {

    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;
    public void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] rgb = new int[n][3];

        for(int i=0; i<n; i++){
            rgb[i][RED] = sc.nextInt();
            rgb[i][GREEN] = sc.nextInt();
            rgb[i][BLUE] = sc.nextInt();
        }

        for(int i=1; i<n; i++){
            rgb[i][RED] += Math.min(rgb[i-1][GREEN], rgb[i-1][BLUE]);
            rgb[i][GREEN] += Math.min(rgb[i-1][RED], rgb[i-1][BLUE]);
            rgb[i][BLUE] += Math.min(rgb[i-1][GREEN], rgb[i-1][RED]);
        }

        System.out.println(Math.min(rgb[n-1][RED], Math.min(rgb[n-1][GREEN], rgb[n-1][BLUE])));
    }
}

package com.algorithm.kokoo.baekjoon;

import java.util.*;

public class Baekjoon2775 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] apt = new int[15][15];

        for(int i=0; i<15; i++){
            apt[i][0] = 1;
            if(i == 0) {
                for (int j = 0; j < 15; j++) {
                    apt[i][j] = j+1;
                }
            }
        }

        for(int i=1; i<15; i++){
            for(int j=1; j<15; j++){
                apt[i][j] = apt[i][j-1] + apt[i-1][j];
            }
        }

        for(int i=0; i<n; i++){
            int level = sc.nextInt();
            int ho = sc.nextInt();

            System.out.println(apt[level][ho-1]);
        }
    }
}

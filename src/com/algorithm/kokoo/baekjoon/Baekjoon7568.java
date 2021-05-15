package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon7568 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] size = new int[n][2];
        int[] rank = new int[n];

        for(int i=0; i<n; i++){
            size[i][0] = sc.nextInt();
            size[i][1] = sc.nextInt();
        }


        for(int i=0; i<n; i++){
            int startRank = 1;

            for(int j=0; j<n; j++){
                if(i == j)
                    continue;

                if(size[i][0] < size[j][0] && size[i][1] < size[j][1])
                    startRank++;
            }
            rank[i] = startRank;
        }

        for(int i=0; i<n; i++){
            System.out.print(rank[i] + " ");
        }
    }
}

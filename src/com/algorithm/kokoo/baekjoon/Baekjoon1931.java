package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon1931 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] time = new int[n][2];

        for(int i=0; i<n; i++){
            time[i][0] = sc.nextInt();
            time[i][1] = sc.nextInt();
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];

                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int endTime = -1;
        for(int i=0; i<n; i++){
            if(endTime <= time[i][0]){
                endTime = time[i][1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}

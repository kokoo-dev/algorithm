package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon10819 {
    int answer;
    int n;
    int[] arr;
    int[] permArr;
    boolean[] visited;

    public void run(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        answer = 0;
        arr = new int[n];
        visited = new boolean[n];
        permArr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        permutation(0);

        System.out.println(answer);
    }

    public void permutation(int index){
        if(index == n){
            int sum = 0;

            for (int i=0; i<n-1; i++) {
                sum += Math.abs(permArr[i] - permArr[i+1]);
            }

            answer = Math.max(answer, sum);

            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]) {
                visited[i] = true;
                permArr[index] = arr[i];
                permutation(index + 1);
                visited[i] = false;
            }
        }
    }
}

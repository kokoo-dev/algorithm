package com.algorithm.kokoo.baekjoon;
import java.util.*;
public class Baekjoon2217 {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] rope = new int[n];

        for(int i=0; i<n; i++){
            rope[i] = scanner.nextInt();
        }

        Arrays.sort(rope);

        int answer=0;
        for(int i=0; i<n; i++){
            int weight = (n-i) * rope[i];
            if(answer < weight){
                answer = weight;
            }
        }

        System.out.println(answer);
    }
}

package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon14888 {
    int n;
    int[] nums;
    int[] operator;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public void run(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];
        operator = new int[4];

        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        for(int i=0; i<4; i++){
            operator[i] = sc.nextInt();
        }

        dfs(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public void dfs(int index, int sum){
        if(index == n){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for(int i=0; i<4; i++){
            if(operator[i] > 0){
                operator[i]--;

                switch (i){
                    case 0:
                        dfs(index + 1, sum + nums[index]);
                        break;
                    case 1:
                        dfs(index + 1, sum - nums[index]);
                        break;
                    case 2:
                        dfs(index + 1, sum * nums[index]);
                        break;
                    case 3:
                        dfs(index + 1, sum / nums[index]);
                        break;
                }

                operator[i]++;
            }
        }
    }
}

package com.algorithm.kokoo.baekjoon;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Baekjoon10974 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n+1];
        Set<Integer> set = new LinkedHashSet<>();

        for(int i=1; i<=n; i++){
            numbers[i] = i;
        }

        permutation(numbers, set, n);
    }

    public void permutation(int[] numbers, Set<Integer> set, int n){
        if(set.size() == n){
            for(Integer i : set)
                System.out.print(i + " ");

            System.out.println();
            return;
        }

        for(int i=1; i<=n; i++){
            int number = numbers[i];

            if(!set.contains(number)){
                set.add(number);
                permutation(numbers, set, n);
                set.remove(number);
            }
        }
    }
}

package com.algorithm.kokoo.baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Baekjoon2891 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int r = sc.nextInt();
        int answer = 0;

        int[] damageTeam = new int[s];
        Set<Integer> extraTeam = new HashSet<>();

        for(int i=0; i<s; i++)
            damageTeam[i] = sc.nextInt();

        for(int i=0; i<r; i++)
            extraTeam.add(sc.nextInt());

        for(int i=0; i<s; i++){
            int team = damageTeam[i];

            if(extraTeam.contains(team-1))
                extraTeam.remove(team-1);

            if(extraTeam.contains(team+1))
                extraTeam.remove(team+1);

            answer++;
        }

        System.out.println(answer);
    }
}

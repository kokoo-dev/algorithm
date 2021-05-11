package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Beakjoon10162 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] buttons = new int[3];

        while(n >= 10){
            if(n >= 300){
                buttons[0]++;
                n -= 300;
            } else if(n >= 60){
                buttons[1]++;
                n -= 60;
            } else if(n >= 10){
                buttons[2]++;
                n -= 10;
            }
        }

        String answer = buttons[0] + " " + buttons[1] + " " + buttons[2];
        System.out.println(n == 0 ? answer : -1);
    }
}

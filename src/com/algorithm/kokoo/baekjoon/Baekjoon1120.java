package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon1120 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int answer = Integer.MAX_VALUE;
        int diff = b.length() - a.length();
        int maxLen = b.length();

        if(diff == 0){
            answer = getSameChar(a, b, 0, maxLen);
        } else {
            for(int i=0; i<=diff; i++){
                answer = Math.min(answer, getSameChar(a, b, i, diff - i));
            }
        }

        System.out.println(answer);
    }

    public int getSameChar(String a, String b, int start, int end){
        int result = 0;

        String prev = "";
        String post = "";
        for(int i=0; i<start; i++){
            prev += "@";
        }

        for(int i=0; i<end; i++){
            post += "@";
        }

        a = prev + a;
        a += post;

        for(int i=start; i<b.length(); i++){
            if(a.charAt(i) != b.charAt(i) && a.charAt(i) != '@')
                result++;
        }

        return result;
    }
}

package com.algorithm.kokoo.baekjoon;
import java.util.*;

public class Baekjoon1541 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        String[] mns = n.split("-");
        int answer = Integer.MAX_VALUE;

        for(int i=0; i<mns.length; i++){
            int tmp = 0;

            for(String z : mns[i].split("\\+")){
                tmp += Integer.parseInt(z);
            }

            if(answer == Integer.MAX_VALUE)
                answer = tmp;
            else
                answer -= tmp;
        }

        System.out.println(answer);
    }
}

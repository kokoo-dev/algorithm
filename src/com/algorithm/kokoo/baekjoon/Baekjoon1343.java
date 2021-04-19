package com.algorithm.kokoo.baekjoon;
import java.util.*;

public class Baekjoon1343 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        String answer = "";

        int xCount = 0;
        boolean error = false;
        for(int i=0; i<n.length(); i++){
            char c = n.charAt(i);

            if(c == 'X'){
                xCount++;
                if(xCount == 4){
                    answer += "AAAA";
                    xCount = 0;
                }

            } else if (c == '.'){
                if(xCount % 2 == 1) {
                    System.out.println(-1);
                    error = true;
                    break;
                }

                if(xCount == 2)
                    answer+="BB";
                answer += ".";
                xCount = 0;
            }
        }

        if(!error) {
            if (xCount % 2 == 1) {
                System.out.println(-1);
            } else {
                if (xCount == 2)
                    answer += "BB";

                System.out.println(answer);
            }
        }
    }
}

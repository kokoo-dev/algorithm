package com.algorithm.kokoo.baekjoon;

import java.util.*;

public class Baekjoon1620 {

    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, String> num = new HashMap<>();
        Map<String, String> name = new HashMap<>();
        for(int i=1; i<=n; i++){
            String pocketmon = sc.next();
            num.put(String.valueOf(i), pocketmon);
            name.put(pocketmon,String.valueOf(i));
        }

        for(int i=0; i<m; i++){
            String question = sc.next();
            if(checkNum(question)){
                System.out.println(num.get(question));
            } else {
                System.out.println(name.get(question));
            }
        }
    }

    public boolean checkNum(String s) {
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c < 48 || c > 58){
                return false;
            }
        }
        return true;
    }
}

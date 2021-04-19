package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon11478 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<s.length()-1; i++){
            String tmp = s.charAt(i)+"";
            set.add(tmp);
            for(int j=i+1; j<s.length(); j++){
                String tmp2 = s.charAt(j)+"";
                set.add(tmp2);
                tmp+=tmp2;

                set.add(tmp);
            }
        }

        System.out.println(set.size());
    }
}

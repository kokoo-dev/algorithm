package com.algorithm.kokoo.baekjoon;

import java.util.*;
public class Baekjoon10809 {
    public void run(){
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        String[] a = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "n", "m", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Map<String,Integer> map = new HashMap<>();

        for(int i=0; i<a.length; i++){
            map.put(a[i], -1);
        }

        for(int i=0; i<n.length(); i++){
            String tmp = n.charAt(i)+"";

            if(map.get(tmp) == -1){
                map.put(tmp, i);
            }
        }

        for(String key : map.keySet())
            System.out.print(map.get(key) + " ");
    }
}

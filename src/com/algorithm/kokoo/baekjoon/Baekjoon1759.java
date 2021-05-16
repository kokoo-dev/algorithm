package com.algorithm.kokoo.baekjoon;

import java.util.*;

public class Baekjoon1759 {
    Set<Character> set;
    PriorityQueue<String> results;
    char[] alphabets;
    int l;
    int c;

    public void run(){
        set = new LinkedHashSet<>();
        results = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        c = sc.nextInt();
        alphabets = new char[c];

        for(int i=0; i<c; i++){
            alphabets[i] = sc.next().charAt(0);
        }

        Arrays.sort(alphabets);

        permutation(0,0,0,0);
    }

    public void permutation(int index, int count, int vCount, int cCount){
        if(l == count){

            if(vCount >= 1 && cCount >= 2){
                String temp = "";

                for(char c : set){
                    temp += c+"";
                }

                if(isValid(temp))
                    System.out.println(temp);
            }

            return;
        }

        for(int i=index; i<c; i++){
            char alphabet = alphabets[i];
            if(!set.contains(alphabet)){
                set.add(alphabet);
                permutation(i+1, count + 1, vCount + (isVowel(alphabet) ? 1 : 0), cCount + (isVowel(alphabet) ? 0 : 1));
                set.remove(alphabet);
            }
        }
    }

    public boolean isValid(String s){
        char prev = s.charAt(0);

        for(int i=1; i<s.length(); i++){
            char now = s.charAt(i);

            if(prev > now)
                return false;

            prev = now;
        }

        return true;
    }

    public boolean isVowel(char c){
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' )
            return true;

        return false;
    }
}

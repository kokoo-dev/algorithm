package com.algorithm.kokoo.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon12845 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int index = 0;
        int answer = 0;
        List<Integer> cardList = new ArrayList<>();

        for(int i=0; i<n; i++){
            int card = sc.nextInt();
            cardList.add(card);

            if(card > max){
                max = card;
                index = i;
            }
        }

        while(cardList.size() > 1){
            int prev = 0;
            int next = 0;
            int now = cardList.get(index);

            if(index > 0)
                prev = cardList.get(index-1);

            if(index < cardList.size()-1)
                next = cardList.get(index+1);

            int removeIdx = index;

            if(prev < next){
                answer += now + next;

                if(now > next)
                    removeIdx += 1;

            } else {
                answer += now + prev;

                if(now > prev) {
                    removeIdx -= 1;
                    index -= 1;
                }
            }

            cardList.remove(removeIdx);
        }

        System.out.println(answer);
    }
}

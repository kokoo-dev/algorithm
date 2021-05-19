package com.algorithm.kokoo.programmers.levelthree;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/77486
 * 레벨3 - 다단계 칫솔 판매
 * 해쉬
 */
public class PG77486 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> relation = new HashMap<>();
        Map<String, Integer> moneyMap = new HashMap<>();

        for(int i=0; i<enroll.length; i++){
            relation.put(enroll[i], referral[i]);
            moneyMap.put(enroll[i], 0);
        }

        for(int i=0; i<seller.length; i++){
            String name = seller[i];
            int money = amount[i] * 100;

            while(true){
                if("-".equals(name))
                    break;

                int fee = Math.round(money/10);
                money -= fee;
                moneyMap.put(name, moneyMap.get(name) + money);
                name = relation.get(name);
                money = fee;
            }
        }

        for(int i=0; i<enroll.length; i++){
            answer[i] = moneyMap.get(enroll[i]);
        }

        return answer;
    }
}

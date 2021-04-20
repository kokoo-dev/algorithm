package com.algorithm.kokoo.programmers.levelthree;
/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/12971
 * 레벨3 - 스티커 모으기(2)
 * dp를 이용 하며, 첫번째 스티커를 떼는 경우와 안떼는 경우 두 경우 중 큰 값을 리턴
 */
public class PG12971 {
    public int solution(int sticker[]) {
        int len = sticker.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];

        if(len == 1)
            return sticker[0];


        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for(int i=2; i<len-1; i++){
            dp1[i] = Math.max(dp1[i-2] + sticker[i] , dp1[i-1]);
        }

        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2; i<len; i++){
            dp2[i] = Math.max(dp2[i-2] + sticker[i] , dp2[i-1]);
        }


        return Math.max(dp1[len-2], dp2[len-1]);
    }
}

package com.algorithm.kokoo.programmers.levelthree;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/64062
 * 레벨3 - 징검다리 건너기
 * 이분탐색
 */
public class PG64062 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0;
        int right = Integer.MIN_VALUE;

        for(int stone : stones)
            right = Math.max(right, stone);

        while(left <= right){
            int mid = (left + right) / 2;

            if(isValid(mid, k, stones)){
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public boolean isValid(int n, int k, int[] stones){
        int count = 0;

        for(int stone : stones){
            if(stone - n < 0)
                count++;
            else
                count = 0;

            if(count == k)
                return false;
        }

        return true;
    }
}

package com.algorithm.kokoo.programmers.levelthree;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/43238
 * 레벨3 - 입국심사
 * 이분탐색
 */
public class PG43238 {
    public long solution(int n, int[] times) {
        long start = 1;
        Arrays.sort(times);
        long end = (long)times[times.length-1]*n;
        long mid=0;
        long answer = end;

        while(start <= end){
            long sum = 0;
            mid = (start + end) / 2;
            for(int time : times){
                sum += mid/time;
            }

            if(sum >= n){
                if(mid<answer){
                    answer=mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return answer;
    }
}

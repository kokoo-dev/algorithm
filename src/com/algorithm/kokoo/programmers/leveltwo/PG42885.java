package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42885
 * 레벨2 - 구명보트
 * 정렬 후 가장 가벼운 사람과 무거운 사람을 태운 경우로 확인
 */
public class PG42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int end = people.length-1;
        int index=0;

        while(true){

            if(index >= end){
                if(index == end){
                    answer++;
                }

                break;
            }

            if(people[index] + people[end] <= limit){
                index ++;
            }

            answer++;
            end--;
        }

        return answer;
    }
}

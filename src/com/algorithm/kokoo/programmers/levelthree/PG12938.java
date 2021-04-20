package com.algorithm.kokoo.programmers.levelthree;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/12938
 * 레벨3 - 최고의 집합
 * s를 n만큼 나눈 값을 배열 fill
 * s를 n으로 나눈 나머지 값을 배열 인덱스마다 +
 */
public class PG12938 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if(n > s)
            return new int[]{-1};

        Arrays.fill(answer, s/n);

        for(int i=0; i<s%n; i++)
            answer[i]++;

        Arrays.sort(answer);

        return answer;
    }
}

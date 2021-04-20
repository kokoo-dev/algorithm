package com.algorithm.kokoo.programmers.levelthree;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/12987
 * 레벨3 - 숫자 게임
 * 양쪽 배열을 오름차순 정렬 후, 인덱스 증가하며 이기는 횟수 비교
 */
public class PG12987 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int aIdx = 0;
        int bIdx = 0;

        while(aIdx != A.length && bIdx != B.length){

            if(A[aIdx] >= B[bIdx]){
                bIdx++;
            } else if(A[aIdx] < B[bIdx]){
                answer++;
                aIdx++;
                bIdx++;
            }
        }

        return answer;
    }
}

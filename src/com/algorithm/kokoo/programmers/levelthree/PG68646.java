package com.algorithm.kokoo.programmers.levelthree;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/68646
 * 레벨3 - 풍선 터트리기
 * 양쪽 끝은 가능, 가운데 숫자는 start,end 한쪽보다 작으면 남을 수 있음
 */
public class PG68646 {
    public int solution(int[] a) {
        int answer = 2;

        int start = a[0];
        int end = a[a.length-1];
        for(int i=1; i<a.length-1; i++){
            if(start > a[i]) {
                start = a[i];
                answer++;
            }

            if(end > a[a.length - 1 - i]){
                end = a[a.length - 1 - i];
                answer++;
            }
        }

        return start == end ? answer - 1 : answer;
    }
}

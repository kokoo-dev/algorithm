package com.algorithm.kokoo.programmers.leveltwo;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/12899
 * 레벨2 - 124 나라의 숫자
 * 숫자 n을 3으로 나눈 나머지 값을 이용해 값 추출
 */

public class PG12899 {
    public String solution(int n) {
        String answer = "";
        String[] arr = new String[]{"4", "1", "2"};

        while(n > 0){
            int nmg = n%3;
            n /= 3;

            if(nmg == 0)
                n -= 1;

            answer = arr[nmg] + answer;
        }

        return answer;
    }
}

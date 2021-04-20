package com.algorithm.kokoo.programmers.leveltwo;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/12980
 * 레벨2 - 점프와 순간 이동
 * 숫자 n부터 시작해서 2로 나누어 떨어질 경우 순간이동, 아닌 경우 점프
 */
public class PG12980 {
    public int solution(int n) {
        int ans = 0;

        while(n > 0){
            if(n%2 == 0){
                n /= 2;
            } else if(n%2 == 1){
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
}

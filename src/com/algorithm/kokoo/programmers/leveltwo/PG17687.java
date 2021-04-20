package com.algorithm.kokoo.programmers.leveltwo;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/17686
 * 레벨2 - [3차] n진수 게임
 * 미리 구할 숫자 갯수 * 인원 만큼 n진수를 구한 후 순서대로 출력
 */
public class PG17687 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        String number = "";

        for(int i=0; i<t*m; i++){
            number += convert(n, i);
        }

        int cnt=0;
        int seq=p-1;

        while(cnt < t){
            answer.append(number.charAt(seq));
            seq +=m;
            cnt++;
        }

        return answer.toString();
    }

    public String convert(int n, int num){
        StringBuilder builder = new StringBuilder();
        String[] alphabet = {"A", "B", "C", "D", "E", "F"};
        int remain;
        if(num == 0){
            builder.append(0);
        } else {
            while (num >= 1) {
                remain = num % n;
                if(remain >= 10){
                    builder.insert(0, alphabet[remain%10]);
                } else {
                    builder.insert(0, num % n);
                }
                num /= n;
            }
        }

        return builder.toString();
    }
}

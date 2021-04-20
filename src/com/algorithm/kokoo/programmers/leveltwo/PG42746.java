package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42746
 * 레벨2 - 가장 큰 수
 * 숫자 배열을 문자열로 변경하여 더 큰수가 앞으로 오도록 정렬
 */
public class PG42746 {
    public String solution(int[] numbers) {
        String answer = "";

        String[] array = new String[numbers.length];

        for(int i=0; i<numbers.length; i++){
            array[i] = String.valueOf(numbers[i]);

        }

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if("0".equals(array[0])){
            return "0";
        }

        for(String str : array){
            answer += str;
        }

        return answer;
    }
}

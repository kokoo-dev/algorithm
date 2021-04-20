package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/67257
 * 레벨2 - 수식 최대화
 * 1. 숫자, 연산자 따로 List에 add
 * 2. 순열을 이용해 연산자 우선순위를 구한 후 List에서 값 제거해가며 계산
 */
public class PG67257 {
    List<Long> numList;
    List<Character> operList;
    long answer;
    public long solution(String expression) {
        answer = 0;
        numList = new ArrayList<>();
        operList = new ArrayList<>();
        char[] operators = {'+', '-', '*'};
        String num = "";

        for(char c : expression.toCharArray()){
            if(c >= 48  && c <= 57){
                num += c;
            } else {
                numList.add(Long.parseLong(num));
                operList.add(c);
                num = "";
            }
        }

        numList.add(Long.parseLong(num));

        for(char operator : operators){
            Set<Character> set = new LinkedHashSet<>();
            set.add(operator);
            permutation(operators, set);
        }

        return answer;
    }

    public void permutation(char[] operators, Set<Character> set){
        if(set.size() == operators.length){
            List<Long> cNumList = new ArrayList<>(numList);
            List<Character> cOperList = new ArrayList<>(operList);

            long result = 0;
            for(char c : set){
                for(int i=0; i<cOperList.size(); i++){
                    if(c == cOperList.get(i)) {
                        result = calculate(cNumList.remove(i), cNumList.remove(i), cOperList.remove(i));
                        cNumList.add(i, result);
                        i--;
                    }
                }

            }

            answer = Math.max(answer, Math.abs(result));
            return;
        }

        for(char operator : operators){
            if(!set.contains(operator)){
                set.add(operator);
                permutation(operators, set);
                set.remove(operator);
            }
        }
    }

    public Long calculate(Long num1, Long num2, Character oper){
        long result = 0;

        if(oper == '*')
            result = num1 * num2;
        else if(oper == '+')
            result = num1 + num2;
        else if(oper == '-')
            result = num1 - num2;

        return result;
    }
}

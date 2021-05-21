package com.algorithm.kokoo.programmers.leveltwo;

import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/76502
 * 레벨2 - 괄호 회전하기
 * Stack, Map, List
 */
public class PG76502 {
    public int solution(String s) {
        int answer = 0;
        LinkedList<Character> list = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        for(int i=0; i<s.length(); i++){
            list.add(s.charAt(i));
        }

        for(int i=0; i<s.length(); i++){
            list.add(list.remove(0));

            if(isValid(list, map))
                answer ++;
        }

        return answer;
    }

    public boolean isValid(List<Character> list, Map<Character, Character> map){
        Stack<Character> stack = new Stack<>();

        for(Character c : list){
            if (!stack.isEmpty()) {
                if (map.get(stack.peek()) == c) {
                    stack.pop();
                    continue;
                }
            }

            stack.push(c);
        }


        return stack.isEmpty();
    }
}

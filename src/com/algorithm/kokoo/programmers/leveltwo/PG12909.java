package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/12909
 * 레벨2 - 올바른 괄호
 * stack이용
 */
public class PG12909 {
    public boolean solution(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                stack.add(s.charAt(i));
            } else{
                if(')' == s.charAt(i) && stack.peek() == '('){
                    stack.pop();
                } else {
                    stack.add(s.charAt(i));
                }
            }
        }

        return stack.size() == 0 ? true : false;
    }
}

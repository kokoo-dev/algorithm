package com.algorithm.kokoo.programmers.levelthree;

import java.util.Stack;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/77886
 * 레벨3 - 110 옮기기
 * 그리디, 스택
 */
public class PG77886 {
    public static final String SPECIAL_NUM = "110";
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for(int i=0; i<s.length; i++){
            Stack<Character> stack = new Stack<>();
            String str = s[i];
            int count = 0;

            for(int j=0; j<str.length(); j++) {

                if(stack.size() >= 2){
                    char c2 = stack.pop();
                    char c1 = stack.pop();
                    char c3 = str.charAt(j);

                    if(SPECIAL_NUM.equals(c1 + "" + c2 + "" + c3 + "")){
                        count++;
                    } else {
                        stack.add(c1);
                        stack.add(c2);
                        stack.add(c3);
                    }
                } else {
                    stack.add(str.charAt(j));
                }
            }

            StringBuilder cutStr = new StringBuilder();
            while(!stack.isEmpty()){
                cutStr.insert(0, stack.pop());
            }

            int index = cutStr.toString().lastIndexOf("0")+1;

            if(count > 0){
                StringBuilder sb = new StringBuilder(cutStr.toString());
                while(count > 0){
                    sb.insert(index, SPECIAL_NUM);
                    index+=3;
                    count--;
                }

                answer[i] = sb.toString();
            } else {
                answer[i] = s[i];
            }
        }

        return answer;
    }
}

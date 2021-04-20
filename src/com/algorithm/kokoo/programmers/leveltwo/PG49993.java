package com.algorithm.kokoo.programmers.leveltwo;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/49993
 * 레벨2 - 스킬트리
 * 문자 하나하나 비교해가며 선행 스킬 순서와 비교
 */
public class PG49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String s : skill_trees){
            answer += checkSkill(skill, s);
        }

        return answer;
    }

    public int checkSkill(String order, String skill){
        char[] orders = order.toCharArray();
        boolean[] checked = new boolean[orders.length];

        for(int i=0; i<skill.length(); i++){
            for(int j=0; j<orders.length; j++){
                if(orders[j] == skill.charAt(i)){
                    checked[j] = true;

                    if(j > 0 && checked[j] && !checked[j-1])
                        return 0;
                }

            }
        }

        return 1;
    }
}

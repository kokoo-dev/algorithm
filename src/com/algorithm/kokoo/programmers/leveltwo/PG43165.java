package com.algorithm.kokoo.programmers.leveltwo;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/43165
 * 레벨2 - 타겟 넘버
 * DFS를 이용해 numbers 길이 만큼 숫자 +- 하여 최종값 비교
 */
public class PG43165 {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    public int dfs(int[] numbers, int target, int index, int sum){
        if(numbers.length <= index){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        int p1 = sum + numbers[index];
        int p2 = sum - numbers[index];

        return dfs(numbers, target, index+1, p1) + dfs(numbers, target, index+1, p2);
    }
}

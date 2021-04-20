package com.algorithm.kokoo.programmers.levelthree;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42895
 * 레벨3 - N으로 표현
 * DFS 풀이
 * 5가 주어졌을 때 55, 555로 표현이 가능하므로 (값 * 10 + N) 해주며 연산 
 */
public class PG42895 {
    int answer = Integer.MAX_VALUE;
    public int solution(int N, int number) {

        dfs(N, number, 0, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public void dfs(int N, int number, int count, int prev){
        if(count > 8){
            return;
        }

        if(number == prev){
            answer = Math.min(answer, count);
            return;
        }

        int temp = N;
        for(int i=0; i<8-count; i++){
            dfs(N, number, count+i+1, prev+temp);
            dfs(N, number, count+i+1, prev-temp);
            dfs(N, number, count+i+1, prev*temp);
            dfs(N, number, count+i+1, prev/temp);
            temp = temp * 10 + N;
        }
    }
}

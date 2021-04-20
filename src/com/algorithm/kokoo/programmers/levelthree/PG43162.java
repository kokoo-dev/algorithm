package com.algorithm.kokoo.programmers.levelthree;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/43162
 * 레벨3 - 네트워크
 * DFS 풀이
 * visited 방문 여부 확인하며 연결된 번호까지 방문
 */
public class PG43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]) {
                dfs(i, visited, computers);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int node, boolean[] visited, int[][] computers){
        if(visited[node]){
            return;
        }

        visited[node] = true;
        for(int i=0; i<computers.length; i++){
            if(node != i && !visited[i] && computers[node][i] == 1){
                dfs(i, visited, computers);
            }
        }

    }
}

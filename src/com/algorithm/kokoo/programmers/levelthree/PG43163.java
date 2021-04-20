package com.algorithm.kokoo.programmers.levelthree;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/43163
 * 레벨3 - 단어 변환
 * DFS이용, 두 문자간 틀린 갯수 확인하여 유효성 검사
 */
public class PG43163 {
    int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        int len = words.length;

        boolean include = false;

        for(int i=0; i<len; i++){
            if(target.equals(words[i])){
                include = true;
                break;
            }
        }

        if(!include)
            return 0;

        for(int i=0; i<len; i++){
            boolean[] visited = new boolean[len];
            if(isChangeValid(begin, words[i]))
                dfs(words[i], target, words, visited, i, 1);
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public void dfs(String begin, String target, String[] words, boolean[] visited, int index, int count){
        if(target.equals(words[index])){
            answer = Math.min(answer, count);
            return;
        }

        visited[index] = true;

        for(int i=index+1; i<words.length; i++){
            if(isChangeValid(begin, words[i]) && !visited[i])
                dfs(words[i], target, words, visited, i, count+1);
        }
    }

    public boolean isChangeValid(String s, String target){
        int count = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != target.charAt(i))
                count++;

            if(count > 1)
                return false;
        }

        return true;
    }
}

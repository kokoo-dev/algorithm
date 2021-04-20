package com.algorithm.kokoo.programmers.levelthree;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/43164
 * 레벨3 - 여행경로
 * DFS이용, 현재 티켓 end와 다음 티켓 start 맞는지 비교
 * String 문자열을 이어붙여 알파벳 순으로 정렬
 */
public class PG43164 {
    List<String> list;
    public String[] solution(String[][] tickets) {
        boolean[] visited;
        list = new ArrayList<>();

        for(int i=0; i<tickets.length; i++){
            visited = new boolean[tickets.length];
            if("ICN".equals(tickets[i][0])){
                visited[i] = true;

                dfs("ICN", tickets[i][1], tickets, visited, 0);
            }

        }

        Collections.sort(list);

        return list.get(0).split(",");
    }

    public void dfs(String route, String end, String[][] tickets, boolean[] visited, int index){
        route += "," + end;

        if(index == tickets.length-1){
            list.add(route);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            String s = tickets[i][0];
            String e = tickets[i][1];

            if(!visited[i] && end.equals(s)){
                visited[i] = true;
                dfs(route, e, tickets, visited, index+1);
                visited[i] = false;
            }
        }
    }
}

package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/1835
 * 레벨2 - 단체사진 찍기
 * 순열을 이용해 프렌즈 조합 후 data[] 조건에 맞는지 확인
 */
public class PG1835 {
    int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
        Map<String,Integer> map = new HashMap<>();

        dfs(friends, data, new LinkedHashMap<>());

        return answer;
    }

    public void dfs(String[] friends, String[] data, Map<String,Integer> map){
        if(map.size() == friends.length){
            if(isValid(map, data))
                answer++;

            return;
        }

        for(int i=0; i<friends.length; i++){
            String friend = friends[i];
            if(!map.containsKey(friend)){
                map.put(friend, map.size()+1);
                dfs(friends, data, map);
                map.remove(friend);
            }
        }
    }

    public boolean isValid(Map<String,Integer> map, String[] data){
        String compare;
        int a,b,val;

        for(String s : data){
            a = map.get(s.charAt(0)+"");
            b = map.get(s.charAt(2)+"");
            compare = s.charAt(3)+"";
            val = s.charAt(4)-'0'+1;

            if("<".equals(compare)){
                if(Math.abs(a-b) >= val) return false;
            } else if(">".equals(compare)){
                if(Math.abs(a-b) <= val) return false;
            } else if("=".equals(compare)){
                if(Math.abs(a-b) != val) return false;
            }
        }

        return true;
    }
}

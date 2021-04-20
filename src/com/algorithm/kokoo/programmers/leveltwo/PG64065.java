package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/64065
 * 레벨2 - 튜플
 * Map에 숫자 카운팅 후 정렬
 */
public class PG64065 {
    public int[] solution(String s) {
        String tmp = s.replace("{", "").replace("}", "");

        HashMap<Integer, Integer> map = new HashMap<>();

        for(String t : tmp.split(",")){
            int tNum = Integer.parseInt(t);
            map.put(tNum,map.getOrDefault(tNum, 0)+1);
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);
            }
        });

        Iterator it = list.iterator();

        int[] answer = new int[list.size()];
        int idx=0;
        while(it.hasNext()){
            answer[idx++] = (int)it.next();
        }

        return answer;
    }
}

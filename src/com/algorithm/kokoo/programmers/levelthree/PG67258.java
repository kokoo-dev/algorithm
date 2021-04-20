package com.algorithm.kokoo.programmers.levelthree;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/67258
 * 레벨3 - 보석 쇼핑
 *
 */
public class PG67258 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        Map<String,Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for(String gem : gems)
            set.add(gem);

        if(set.size() == 1)
            return new int[]{1,1};

        int sIndex = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;

        for(String gem : gems){
            map.put(gem, map.getOrDefault(gem,0) + 1);
            queue.offer(gem);

            while(true){
                String s = queue.peek();

                if(map.get(s) > 1){
                    map.put(s, map.get(s)-1);
                    queue.poll();
                    sIndex++;
                } else {
                    break;
                }

            }

            if(map.size() == set.size() && length > queue.size()){
                length = queue.size();
                start = sIndex;
            }
        }

        answer[0] = start + 1;
        answer[1] = start + length;

        return answer;
    }
}

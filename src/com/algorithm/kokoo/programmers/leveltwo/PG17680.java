package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/17680
 * 레벨2 - [1차] 캐시
 * 큐에 cacheSize 만큼 적재하며 cities[] 동일한 값이 있는지 확인
 */
public class PG17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        for(String city : cities){
            String lowerName = city.toLowerCase();

            if(!queue.contains(lowerName))
                answer += 5;
            else
                answer += 1;

            if(cacheSize == 0)
                continue;

            if(queue.size() == cacheSize) {
                if(!queue.contains(lowerName))
                    queue.poll();
                else
                    queue.remove(lowerName);
            }

            queue.offer(lowerName);

        }

        return answer;
    }
}

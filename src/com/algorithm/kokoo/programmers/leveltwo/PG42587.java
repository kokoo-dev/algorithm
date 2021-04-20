package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
* 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42587
* 레벨2 - 프린터
* 큐를 이용하여 출력 순서 확인
*/
public class PG42587 {
    class Printer {
        int priority;
        int location;

        Printer(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Printer> queue = new LinkedList<>();

        for(int i=0; i<priorities.length; i++)
            queue.offer(new Printer(priorities[i], i));

        while(!queue.isEmpty()){
            Printer printer = queue.peek();

            boolean flag = false;
            for(Printer p : queue){
                if(p.priority > printer.priority) {
                    flag = true;
                }
            }

            if(flag){
                queue.offer(queue.poll());
            } else {
                if(queue.poll().location == location){
                    answer = priorities.length - queue.size();
                }
            }
        }

        return answer;
    }
}

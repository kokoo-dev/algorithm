package com.algorithm.kokoo.baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon2109 {
    class Schedule implements Comparable<Schedule>{
        int pay;
        int day;

        Schedule(int pay, int day){
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(Schedule s){
            if(this.pay == s.pay)
                return this.day - s.day;

            return s.pay - this.pay;
        }
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        int maxDay = 0;
        PriorityQueue<Schedule> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int pay = sc.nextInt();
            int day = sc.nextInt();

            pq.offer(new Schedule(pay, day));
            maxDay = Math.max(day, maxDay);
        }

        boolean[] visited = new boolean[maxDay+1];

        while(!pq.isEmpty()){
            Schedule schedule = pq.poll();
            int pay = schedule.pay;
            int day = schedule.day;

            for(int i=day; i>0; i--){
                if(!visited[i]){
                    visited[i] = true;
                    answer += pay;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}

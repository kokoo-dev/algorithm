package com.algorithm.kokoo.programmers.levelthree;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42861
 * 레벨3 - 길 찾기 게임
 * 크루스칼 이용, 최소비용 계산
 */
public class PG42861 {
    class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;
        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            if(this.cost < o.cost)
                return -1;
            else if(this.cost == o.cost)
                return 0;
            else
                return 1;
        }
    }
    int[] parent;
    boolean[] visit;
    public int solution(int n, int[][] costs) {
        int answer = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parent = new int[n+1];
        visit = new boolean[n+1];

        for(int i=0; i<costs.length; i++){
            pq.add(new Edge(costs[i][0],costs[i][1],costs[i][2]));
        }


        for(int i= 1; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<costs.length; i++){
            Edge edge = pq.poll();

            int start = edge.v1;
            int end = edge.v2;
            int a = find(start);
            int b= find(end);
            if(a==b)continue;

            union(start,end);
            answer+=edge.cost;
        }

        return answer;
    }


    public int find(int a){
        if(a==parent[a])
            return a;

        parent[a] = find(parent[a]);
        return parent[a];
    }

    public void union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);

        if(root1 != root2){
            parent[root1] = b;
        } else {
            return;
        }
    }
}

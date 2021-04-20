package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/12978
 * 레벨2 - 배달
 * 다익스트라를 이용해 경로별 최단거리 계산
 */
public class PG12978 {
    class Node implements Comparable<Node> {

        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return this.index;
        }

        public int getDistance() {
            return this.distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }

    public final int INF = Integer.MAX_VALUE;
    public ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public int[] d = new int[51];

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        for(int i=0; i<=N; i++)
            graph.add(new ArrayList<Node>());

        for (int i = 0; i<road.length; i++) {
            graph.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            graph.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }

        Arrays.fill(d, INF);

        dijkstra(1);

        for (int i = 1; i <= N; i++) {
            if(d[i] < INF && d[i] <= K){
                answer++;
            }

        }

        return answer;
    }


    public void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if (d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                int nowNodeLink = graph.get(now).get(i).getIndex();
                if (cost < d[nowNodeLink]) {
                    d[nowNodeLink] = cost;
                    pq.offer(new Node(nowNodeLink, cost));
                }
            }
        }
    }
}

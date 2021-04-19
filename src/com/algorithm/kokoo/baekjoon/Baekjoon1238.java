package com.algorithm.kokoo.baekjoon;

import java.util.*;

public class Baekjoon1238 {
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

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        int inf = Integer.MAX_VALUE;
        int[] goParty = new int[n+1];
        int[] goHome = new int[n+1];

        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node(b,c));
        }

        int max = 0;
        for(int i=1; i<=n; i++){
            Arrays.fill(goParty, inf);
            Arrays.fill(goHome, inf);
            int[] pResult = dijkstra(i, goParty);
            int[] hResult = dijkstra(x, goHome);

            int dist = pResult[x] + hResult[i];
            if(dist>max)
                max = dist;
        }

        System.out.println(max);

    }

    public int[] dijkstra(int start, int[] d) {
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

        return d;
    }
}

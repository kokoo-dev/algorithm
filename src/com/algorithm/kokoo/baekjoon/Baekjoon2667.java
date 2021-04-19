package com.algorithm.kokoo.baekjoon;
import java.util.*;
public class Baekjoon2667 {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    boolean[][] visited;
    int count;

    public void run(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String input = scanner.next();
            for(int j=0; j<n; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }

        PriorityQueue pq = new PriorityQueue();
        List<Integer> countList = new ArrayList<>();
        int dCount = 0;
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    count = 0;
                    dfs(i, j, n, map);
                    dCount++;
                    pq.add(count);
                }
            }
        }

        System.out.println(dCount);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

    public void dfs(int x, int y, int n, int[][] map){
        if(map[x][y] == 0 || visited[x][y]){
            return;
        }

        if(map[x][y] == 1 && !visited[x][y]){
            visited[x][y] = true;
            count++;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx > n-1 || ny < 0 || ny > n-1)
                continue;

            dfs(nx, ny, n, map);
        }
    }
}

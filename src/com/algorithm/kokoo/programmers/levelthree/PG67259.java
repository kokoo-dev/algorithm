package com.algorithm.kokoo.programmers.levelthree;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/67259
 * 레벨3 - 경주로 건설
 * BFS이용 최단거리 계산, 이전 방향과 비교하여 방향이 다를 경우 커브이므로 +500
 */
public class PG67259 {
    class Point{
        int x;
        int y;
        int direct;
        int cost;
        Point(int x, int y, int direct, int cost){
            this.x = x;
            this.y = y;
            this.direct = direct;
            this.cost = cost;
        }
    }

    public int solution(int[][] board) {
        int len = board.length;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int[][] costs = new int[len][len];
        boolean[][] visited = new boolean[len][len];
        Queue<Point> queue = new LinkedList<>();

        visited[0][0] = true;
        queue.offer(new Point(0,0, -1, 0));

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            int direct = point.direct;
            int cost = point.cost;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx > len-1 || ny < 0 || ny > len-1)
                    continue;

                if(board[nx][ny] == 1)
                    continue;

                int nCost = cost;

                if(direct == -1)
                    nCost += 100;
                else if(direct == i)
                    nCost += 100;
                else
                    nCost += 600;

                if(!visited[nx][ny] || nCost <= costs[nx][ny]){
                    visited[nx][ny] = true;
                    costs[nx][ny] = nCost;
                    queue.offer(new Point(nx, ny, i, nCost));
                }
            }
        }

        return costs[len-1][len-1];
    }
}

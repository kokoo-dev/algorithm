package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/1844
 * 레벨2 - 게임 맵 최단거리
 * BFS를 이용해 최단거리 계산
 */
public class PG1844 {
    class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        return bfs(maps);
    }

    public int bfs(int[][] maps){
        int[][] visited = new int[maps.length][maps[0].length];
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        visited[0][0] = 1;
        queue.offer(new Point(0,0));

        while(!queue.isEmpty()){
            Point point = queue.poll();

            for(int i=0; i<4; i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length){
                    if(visited[nx][ny] == 0 && maps[nx][ny] != 0){
                        visited[nx][ny] = visited[point.x][point.y] + 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }

        return visited[visited.length-1][visited[0].length-1] == 0 ? -1 : visited[visited.length-1][visited[0].length-1];
    }
}

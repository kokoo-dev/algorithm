package com.algorithm.kokoo.baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon14502 {
    int n;
    int m;
    int maxSafetyZone;
    int[][] lab;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void run(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        lab = new int[n][m];
        maxSafetyZone = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                lab[i][j] = sc.nextInt();
            }
        }

        makeWall(0);

        System.out.println(maxSafetyZone);
    }

    //dfs로 벽만들기
    public void makeWall(int wallCount){
        if(wallCount == 3){
            maxSafetyZone = Math.max(getSafetyZone(), maxSafetyZone);
            return;
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(lab[i][j] == 0){
                    lab[i][j] = 1;
                    makeWall(wallCount+1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    //bfs로 바이러스 퍼뜨린 후 안전구역 구하기
    public int getSafetyZone(){
        int safetyZone = 0;
        int[][] virusLab = new int[n][m];
        Queue<Point> queue = new LinkedList<>();

        //연구실 복사
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                virusLab[i][j] = lab[i][j];
                if(virusLab[i][j] == 2)
                    queue.offer(new Point(i, j));
            }
        }

        while(!queue.isEmpty()){
            Point point = queue.poll();

            for(int i=0; i<4; i++){
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if(nx < 0 || nx > n-1 || ny < 0 || ny > m-1)
                    continue;

                if(virusLab[nx][ny] == 0) {
                    virusLab[nx][ny] = 2;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(virusLab[i][j] == 0)
                    safetyZone++;
            }
        }

        return safetyZone;
    }
}

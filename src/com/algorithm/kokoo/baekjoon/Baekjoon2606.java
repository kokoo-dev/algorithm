package com.algorithm.kokoo.baekjoon;

import java.util.*;

public class Baekjoon2606 {

    int count;
    public void run(){
        count = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int linked = scanner.nextInt();

        int[][] computer = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];

        for(int i=0; i<linked; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            computer[x][y] = 1;
            computer[y][x] = 1;
        }

        dfs(1, computer, visited);
        System.out.println(count);
    }

    public void dfs(int n, int[][] computer, boolean[] visited){

        for(int i=1; i<computer.length; i++){
            if(computer[n][i]==1 && !visited[i] && i != 1){
                visited[i] = true;
                dfs(i, computer, visited);
                count++;
            }
        }
    }
}

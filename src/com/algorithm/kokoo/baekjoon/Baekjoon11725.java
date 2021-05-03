package com.algorithm.kokoo.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baekjoon11725 {
    public void run(){
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> nodeList = new ArrayList<>();
        int n = sc.nextInt();
        boolean[] visited = new boolean[n+1];
        int[] parent = new int[n+1];

        for(int i=0; i<=n; i++){
            nodeList.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            nodeList.get(node1).add(node2);
            nodeList.get(node2).add(node1);
        }

        dfs(1, nodeList, parent, visited);

        for(int i=2; i<parent.length; i++){
            System.out.println(parent[i]);
        }
    }

    public void dfs(int index, List<List<Integer>> list, int[] parent, boolean[] visited){
        for(int i : list.get(index)){
            if(!visited[i]) {
                parent[i] = index;
                visited[i] = true;
                dfs(i, list, parent, visited);
            }
        }
    }
}

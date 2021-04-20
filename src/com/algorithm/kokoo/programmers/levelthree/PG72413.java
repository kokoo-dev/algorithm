package com.algorithm.kokoo.programmers.levelthree;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/72413
 * 레벨3 - 합승 택시 요금
 * 플로이드 와샬 알고리즘
 */
public class PG72413 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j] = 200000000;
            }

            map[i][i] = 0;
        }
        for(int i=0; i<fares.length; i++){
            map[fares[i][0]][fares[i][1]] = fares[i][2];
            map[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        floydWarshall(n, map);

        int answer = map[s][a] + map[s][b];

        for(int i=1; i<=n; i++)
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);

        return answer;
    }


    public static void floydWarshall(int n, int[][] map) {
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                if(i==k) continue;
                for(int j=1; j<=n; j++) {
                    if(j==k || i==j) continue;
                    map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                }
            }
        }
    }
}

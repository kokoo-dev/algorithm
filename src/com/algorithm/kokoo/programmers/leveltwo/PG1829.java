package com.algorithm.kokoo.programmers.leveltwo;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/1829
 * 레벨2 - 카카오프렌즈 컬러링북
 * dfs를 이용해 방문지역 확인
 */
public class PG1829 {
    int count = 0;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visit = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j] && picture[i][j] != 0){
                    dfs(i, j, m, n, picture[i][j], picture, visit);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                    numberOfArea++;
                    count = 0;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public void dfs(int x, int y, int m, int n, int num, int[][] picture, boolean[][] visit){
        if(visit[x][y] || picture[x][y] == 0 || picture[x][y] != num) {
            return;
        }

        count++;
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx > m-1 || ny < 0 || ny > n-1)
                continue;

            dfs(nx, ny, m, n, num, picture, visit);
        }

    }
}

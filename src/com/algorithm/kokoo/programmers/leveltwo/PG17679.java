package com.algorithm.kokoo.programmers.leveltwo;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/17679
 * 레벨2 - [1차] 프렌즈4블록
 */
public class PG17679 {
    char[][] block;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        block = new char[m][n];


        for(int i=0; i<board.length; i++){
            block[i]  = board[i].toCharArray();
        }

        while(true){
            int count = checkBlock(m, n);

            if(count == 0)
                break;

            answer += count;
            downBlock(m,n);
        }

        return answer;
    }

    public int checkBlock(int m, int n){
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        for(int i=0; i<m-1; i++){
            for(int j=0; j<n-1; j++){
                if(block[i][j] == '0')
                    continue;

                count += checkFour(i, j, visited);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j])
                    block[i][j] = '0';
            }
        }

        return count;
    }

    public int checkFour(int x, int y, boolean[][] visited){
        char friend = block[x][y];
        int count = 0;

        for(int i=x; i<x+2; i++){
            for(int j=y; j<y+2; j++){
                if(friend != block[i][j])
                    return 0;
            }
        }

        for(int i=x; i<x+2; i++){
            for(int j=y; j<y+2; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public void downBlock(int m, int n){
        for(int j=0; j<n; j++){
            for(int i=m-1; i>=0; i--){
                if(block[i][j] == '0'){
                    for(int k=i-1; k>=0; k--){
                        if(block[k][j] != '0'){
                            block[i][j] = block[k][j];
                            block[k][j] = '0';
                            break;
                        }
                    }
                }
            }
        }
    }
}

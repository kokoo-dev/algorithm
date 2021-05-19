package com.algorithm.kokoo.programmers.leveltwo;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/77485
 * 레벨2 - 행렬 테두리 회전하기
 *
 */
public class PG77485 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] rectangle = new int[rows+1][columns+1];
        int index = 1;

        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                rectangle[i][j] = index++;
            }
        }

        for(int i=0; i<queries.length; i++){
            answer[i] = rotate(queries[i], rectangle);
        }

        return answer;
    }

    public int rotate(int[] query, int[][] rectangle){
        int min = Integer.MAX_VALUE;
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        int now = rectangle[x1][y1];

        //상
        for(int i=y1+1; i<=y2; i++){
            min = Math.min(min, now);
            now = move(x1, i, now, rectangle);
        }

        //우
        for(int i=x1+1; i<=x2; i++){
            min = Math.min(min, now);
            now = move(i, y2, now, rectangle);
        }

        //하
        for(int i=y2-1; i>=y1; i--){
            min = Math.min(min, now);
            now = move(x2, i, now, rectangle);
        }

        //좌
        for(int i=x2-1; i>=x1; i--){
            min = Math.min(min, now);
            now = move(i, y1, now, rectangle);
        }

        return min;
    }

    public int move(int x, int y, int value, int[][] rectangle){
        int temp = value;
        value = rectangle[x][y];
        rectangle[x][y] = temp;

        return value;
    }
}

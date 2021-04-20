package com.algorithm.kokoo.programmers.levelthree;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/12979
 * 레벨3 - 기지국 설치
 */
public class PG12979 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;

        for(int i=0; i<stations.length; i++){
            int station = stations[i];

            int left = station-w;

            answer += (left - position) / (w*2+1);

            if((left - position) % (w*2+1) > 0)
                answer++;

            position = station + w + 1;
        }

        if(position <= n){
            int rest = n - position + 1;

            answer += rest / (w*2+1);

            if(rest % (w*2+1) > 0)
                answer++;
        }

        return answer;
    }
}

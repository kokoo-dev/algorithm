package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42586
 * 레벨2 - 기능개발
 * 반복문을 통해 처리일자 비교해가며 List에 add
 */
public class PG42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        int cnt = 0;
        int tmp = 0;
        int tmp2 = 0;
        List<Integer> list = new ArrayList<Integer>();

        for(int i=0; i<progresses.length; i++){
            tmp = (100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] > 0 ? 1 : 0);

            if(tmp2 < tmp){
                if(tmp2 != 0)
                    list.add(cnt);

                tmp2 = tmp;
                cnt = 1;
            } else {
                cnt ++;
            }

            if(i == progresses.length - 1)
                list.add(cnt);
        }

        int[] answer = new int[list.size()];

        for(int j=0; j<list.size(); j++){
            answer[j] = list.get(j);
        }

        return answer;
    }
}

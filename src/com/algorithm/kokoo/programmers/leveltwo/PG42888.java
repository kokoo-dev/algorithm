package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42888
 * 레벨2 - 오픈채팅방
 * Map에 id 저장하여 명령어 적재 후 메시지 출력
 */
public class PG42888 {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        Map<String, String> idMap = new HashMap<>();
        String enterMsg = "님이 들어왔습니다.";
        String leaveMsg = "님이 나갔습니다.";

        for(String r : record){
            String[] alert = r.split(" ");
            String command = alert[0];

            if("Enter".equals(command)){
                idMap.put(alert[1], alert[2]);
                list.add(alert[1] + "@" + enterMsg);
            } else if("Leave".equals(command)){
                list.add(alert[1] + "@" + leaveMsg);
            } else if("Change".equals(command)){
                idMap.put(alert[1], alert[2]);
            }
        }

        String[] answer = new String[list.size()];

        for(int i=0; i<list.size(); i++){
            String[] msg = list.get(i).split("@");

            answer[i] = idMap.get(msg[0]) + msg[1];
        }

        return answer;
    }
}

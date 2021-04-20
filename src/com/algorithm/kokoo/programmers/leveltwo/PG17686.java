package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/17686
 * 레벨2 - [3차] 파일명 정렬
 * 파일명 구분 후 Comparable을 상속받아 HEAD -> Number 순으로 정렬
 */
public class PG17686 {
    public class FileName implements Comparable<FileName>{
        String fileName;
        String head;
        int number;

        FileName(String fileName, String head, int number){
            this.fileName = fileName;
            this.head = head;
            this.number = number;
        }

        @Override
        public int compareTo(FileName o) {
            int h = this.head.toLowerCase().compareTo(o.head.toLowerCase());

            if(h == 0){
                int n = this.number - o.number;
                if(n != 0){
                    return n;
                }
            }

            return h;
        }

    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        FileName[] fileNames = new FileName[files.length];

        for(int i=0; i<files.length; i++){
            String file = files[i];

            int fileLeng = file.length();
            String head = "";
            String number = "";
            boolean headFlag = false;

            for(int j=0; j<fileLeng; j++){
                char f = file.charAt(j);
                if(Character.isDigit(f)){
                    headFlag = true;
                    number += f+"";
                }

                if(!headFlag)
                    head += f+"";

                if(!Character.isDigit(f) && headFlag)
                    break;
            }
            fileNames[i] = new FileName(file, head, Integer.parseInt(number));
        }

        Arrays.sort(fileNames);

        for(int i=0; i< fileNames.length; i++){
            answer[i] = fileNames[i].fileName;
        }

        return answer;
    }
}

package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42890
 * 레벨2 - 후보키
 * 순열을 이용해 1~relation 길이 까지 조합을 구한 후 튜플 중복 여부 확인
 */
public class PG42890 {
    Set<Set<Integer>> waste;
    int answer;
    public int solution(String[][] relation) {
        waste = new HashSet<>();
        answer = 0;

        int len = relation[0].length;

        for(int i=0; i<len; i++){
            permutation(i+1, relation, new LinkedHashSet<>());
        }

        return answer;
    }

    public void permutation(int depth, String[][] relation, Set<Integer> set){
        if(depth == set.size()){

            for(Set w : waste)
                if(set.containsAll(w))
                    return;

            Set<String> checkSet = new HashSet<>();
            for(int i=0; i<relation.length; i++){
                String tmp = "";
                for(int s : set){
                    tmp += relation[i][s];
                }

                if(checkSet.contains(tmp))
                    return;
                else
                    checkSet.add(tmp);
            }

            answer++;

            Set<Integer> wSet = new HashSet<>();
            for(int s : set)
                wSet.add(s);

            waste.add(wSet);

            return;
        }

        for(int i=0; i<relation[0].length; i++){
            if(!set.contains(i)){
                set.add(i);
                permutation(depth, relation, set);
                set.remove(i);
            }
        }
    }
}

package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/72411
 * 레벨2 - 메뉴 리뉴얼
 * 순열을 이용해 course 길이 별 조합 추출 후 유효 값 적재
 */
public class PG72411 {
    Map<String, Integer> menu;
    public String[] solution(String[] orders, int[] course) {
        menu = new HashMap<>();
        for(int c : course){
            for(String order : orders){
                if(order.length() < c)
                    continue;

                Set<String> trash = new HashSet<>();
                permutation(0,c, order.toCharArray(), new HashSet<>(), trash);
            }
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(menu.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<String> ansList = new ArrayList<>();
        Map<Integer, Integer> filter = new HashMap<>();

        for(Map.Entry<String,Integer> m : list){
            String key = m.getKey();
            int value = m.getValue();
            int keyLen = key.length();

            if(value < 2) {
                continue;
            }

            if (filter.get(keyLen) == null) {
                ansList.add(key);
                filter.put(keyLen, value);
            } else if(filter.get(keyLen) == value){
                ansList.add(key);
            }

        }

        Collections.sort(ansList);

        String[] answer = new String[ansList.size()];
        ansList.toArray(answer);

        return answer;
    }

    public void permutation(int index, int course, char[] order, Set<Character> set, Set<String> trash){
        if(course == set.size()){
            String combi = "";
            List<Character> list = new ArrayList<>(set);

            Collections.sort(list);
            for(char l : list)
                combi += l;

            if(trash.contains(combi))
                return;

            trash.add(combi);
            menu.put(combi, menu.getOrDefault(combi, 0) + 1);
            return;
        }

        for(int i=index; i<order.length; i++){
            if(!set.contains(order[i])){
                set.add(order[i]);
                permutation(index +1, course, order, set, trash);
                set.remove(order[i]);
            }
        }
    }
}

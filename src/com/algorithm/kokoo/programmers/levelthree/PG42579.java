package com.algorithm.kokoo.programmers.levelthree;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42579
 * 레벨3 - 베스트앨범
 * 해시이용
 */
public class PG42579 {
    class Album{
        String genre;
        int play;
        int index;

        Album(String genre, int play, int index){
            this.genre = genre;
            this.play = play;
            this.index = index;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        List<Album> albums = new ArrayList<>();
        Map<String, Integer> albumMap = new HashMap<>();

        for(int i=0; i<len; i++){
            String genre = genres[i];
            int play = plays[i];
            albums.add(new Album(genre, play, i));
            albumMap.put(genres[i], albumMap.getOrDefault(genre,0) + play);
        }

        Collections.sort(albums, new Comparator<Album>() {
            @Override
            public int compare(Album o1, Album o2) {
                return o2.play - o1.play;
            }
        });

        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(albumMap.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<Integer> answerList = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : entries){
            String key = entry.getKey();
            int count = 0;

            for(Album a : albums){
                if(key.equals(a.genre)) {
                    count++;
                    answerList.add(a.index);
                }

                if(count == 2)
                    break;
            }

        }

        int index = 0;
        int[] answer = new int[answerList.size()];
        for(int l : answerList)
            answer[index++] = l;

        return answer;
    }
}

package com.algorithm.kokoo.programmers.leveltwo;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42839
 * 레벨2 - 소수 찾기
 * 순열을 이용해 숫자 조합 후 소수 여부 확인
 */
public class PG42839 {
    String numbers;
    int[] num;
    HashSet<Integer> set;

    public int solution(String numbers) {
        this.numbers = numbers;
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        num = new int[numbers.length()];
        set = new HashSet<>();

        for(int i=0; i<numbers.length(); i++)
            num[i] = numbers.charAt(i)-'0';

        for(int i=0; i<num.length; i++){
            int[] list = new int[i+1];
            permutation(0, i+1, visited, list);
        }

        Iterator<Integer> it = set.iterator();


        while(it.hasNext()){
            if(isPrime(it.next()))
                answer++;

        }

        return answer;
    }

    public void permutation(int depth, int len, boolean[] visited, int[] list) {
        if(depth == len) {
            String tmp = "";
            for(int n : list)
                tmp += n;

            set.add(Integer.parseInt(tmp));
            return;
        }

        for (int i = 0; i < numbers.length(); i++){
            if (!visited[i]) {
                visited[i] = true;                    // 중복 체크
                list[depth] = num[i];
                permutation(depth +1, len, visited, list);
                visited[i] = false;
            }
        }

    }

    public boolean isPrime(int num){
        if(num == 2)
            return true;

        if(num < 2 || num % 2 == 0)
            return false;

        int sqrt = (int) Math.sqrt(num);
        for(int i=3; i<=sqrt; i++){
            if(num%i == 0)
                return false;
        }

        return true;
    }
}

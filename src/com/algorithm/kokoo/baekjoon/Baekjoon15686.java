package com.algorithm.kokoo.baekjoon;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Baekjoon15686 {
    int answer;
    int n;
    int m;
    List<Point> chickens;
    List<Point> houses;
    Set<Point> selected;

    public void run(){
        Scanner sc = new Scanner(System.in);
        answer = Integer.MAX_VALUE;
        n = sc.nextInt();
        m = sc.nextInt();
        chickens = new ArrayList<>();
        houses = new ArrayList<>();
        selected = new HashSet<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int now = sc.nextInt();

                if(now == 1)
                    houses.add(new Point(i, j));

                if(now == 2)
                    chickens.add(new Point(i, j));
            }
        }

        selectChickens(0,0);

        System.out.println(answer);
    }

    public void selectChickens(int count, int index){
        if(count == m){
            calcDistance();

            return;
        }

        for(int i=index; i<chickens.size(); i++){
            selected.add(chickens.get(i));
            selectChickens(count+1, i+1);
            selected.remove(chickens.get(i));
        }
    }

    public void calcDistance(){
        int result = 0;

        for(Point house : houses){
            int min = Integer.MAX_VALUE;

            for(Point chicken : selected){
                int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                min = Math.min(min, dist);
            }

            result += min;

            if(result >= answer)
                return;
        }

        answer = result;
    }
}

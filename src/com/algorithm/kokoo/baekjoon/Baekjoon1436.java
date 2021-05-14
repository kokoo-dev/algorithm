package com.algorithm.kokoo.baekjoon;

import java.util.Scanner;

public class Baekjoon1436 {

    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int num = 665;

        while(n > count){
            num++;

            if(isValid(num))
                count++;
        }

        System.out.println(num);
    }

    public boolean isValid(int num){
        String strNum = String.valueOf(num);
        int count = 0;

        for(int i=0; i<strNum.length(); i++){
            if(strNum.charAt(i) == '6')
                count++;
            else
                count = 0;

            if(count == 3)
                return true;
        }

        return false;
    }
}

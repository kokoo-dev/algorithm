package com.algorithm.kokoo.baekjoon;
import java.util.*;
public class Baekjoon2042 {
    static long[] arr;
    static long[] tree;
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        arr = new long[n+1];
        tree = new long[n*4];

        for(int i=1; i<=n; i++){
            arr[i] = sc.nextLong();
        }

        init(1, n, 1);

        for(int i=0; i<m+k; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();

            if(a==1){
                long dif = c - arr[b];
                arr[b] = c;
                update(1, n, 1, b, dif);
            } else {
                System.out.println(sum(1, n, 1, b, (int)c));
            }
        }

    }

    public long init(int start, int end, int node){
        if(start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start+end)/2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }

    public long sum(int start, int end, int node, int left, int right) {
        if(left>end || right < start) {
            return 0;
        }
        if(left <=start && end <=right) {
            return tree[node];
        }

        int mid = (start+end)/2;
        return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
    }

    public void update(int start, int end, int node, int index, long dif) {
        if(index < start || index > end) {
            return;
        }
        tree[node] += dif;
        if(start == end) {
            return;
        }

        int mid = (start + end)/2;
        update(start, mid, node*2, index, dif);
        update(mid+1, end, node*2+1, index, dif);
    }
}

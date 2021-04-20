package com.algorithm.kokoo.programmers.levelthree;
import java.util.*;

/**
 * 문제 출처: https://programmers.co.kr/learn/courses/30/lessons/42892
 * 레벨3 - 길 찾기 게임
 * y값에 따라 노드 순서 정렬, x값에 따라 left, right 지정
 */
public class PG42892 {
    class Node implements Comparable<Node>{
        int x;
        int y;
        int data;
        Node left;
        Node right;

        Node(int data, int x, int y){
            this.data = data;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node n){
            return n.y - this.y;
        }
    }

    int index;
    public int[][] solution(int[][] nodeinfo) {
        int nodeLen = nodeinfo.length;
        int[][] answer = new int[2][nodeLen];
        List<Node> nodeList = new ArrayList<>();

        for(int i=0; i<nodeLen; i++){
            nodeList.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(nodeList);

        Node root = nodeList.get(0);

        for(int i=1; i<nodeList.size(); i++) {
            createAndSearchNode(root, nodeList.get(i));
        }

        index = 0;
        prevOrder(root, answer);
        index = 0;
        beforeOrder(root, answer);

        return answer;
    }

    public void createAndSearchNode(Node root, Node node){
        if(root.x > node.x){
            if(root.left == null)
                root.left = node;
            else
                createAndSearchNode(root.left, node);
        } else {
            if(root.right == null)
                root.right = node;
            else
                createAndSearchNode(root.right, node);
        }
    }

    public void prevOrder(Node node, int[][] answer){
        answer[0][index++] = node.data;
        if(node.left != null) prevOrder(node.left, answer);
        if(node.right != null) prevOrder(node.right, answer);
    }

    public void beforeOrder(Node node, int[][] answer){
        if(node.left != null) beforeOrder(node.left, answer);
        if(node.right != null) beforeOrder(node.right, answer);
        answer[1][index++] = node.data;
    }
}

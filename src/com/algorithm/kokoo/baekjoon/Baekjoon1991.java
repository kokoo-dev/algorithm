package com.algorithm.kokoo.baekjoon;
import java.util.*;

public class Baekjoon1991 {

    class Node{
        char data;
        Node left;
        Node right;

        Node(char data){
            this.data = data;
        }
    }

    class Tree {
        Node root;

        public void createNode(char data, char leftData, char rightData) {
            if(root == null) {
                root = new Node(data);

                if(leftData != '.')
                    root.left = new Node(leftData);

                if(rightData != '.')
                    root.right = new Node(rightData);

            } else {
                searchNode(root, data, leftData, rightData);
            }
        }

        public void searchNode(Node root, char data, char leftData, char rightData) {
            if(root == null) {
                return;
            } else if(root.data == data) {
                if(leftData != '.')
                    root.left = new Node(leftData);

                if(rightData != '.')
                    root.right = new Node(rightData);
            } else {
                searchNode(root.left, data, leftData, rightData);
                searchNode(root.right, data, leftData, rightData);
            }
        }

        public void preorder(Node root){
            System.out.print(root.data);
            if(root.left!=null) preorder(root.left);
            if(root.right!=null) preorder(root.right);
        }

        public void inorder(Node root){
            if(root.left!=null) inorder(root.left);
            System.out.print(root.data);
            if(root.right!=null) inorder(root.right);
        }

        public void postorder(Node root){
            if(root.left!=null) postorder(root.left);
            if(root.right!=null) postorder(root.right);
            System.out.print(root.data);
        }

    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Tree tree = new Tree();

        for(int i=0; i<n; i++){
            String s = sc.nextLine();
            char[] arr = s.replace(" ","").toCharArray();
            if(arr.length == 0)
                continue;
            tree.createNode(arr[0],arr[1],arr[2]);
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
    }
}

package com.ds.algo;

public class Main {

    public static void main(String[] args) {
        /* ######### Tower of hanoi ########## */
//        towerOfHanoi(3, "A", "B", "C");
        /* ######### Partition Array in equal sums ########## */
//        partitionEqualSumArray(new int[]{2, 1, 2, 3, 4, 8});
//        partitionEqualSumArray(new int[]{3, 3, 3, 3, 3, 3, 1, 1});

        /* ######### N Queens ########## */
//        int[][] chessBoard = new int[5][5];
//        nQueens(0, 0, chessBoard);
//        for(int i = 0; i< chessBoard.length; i++){
//            for (int j = 0; j < chessBoard.length; j++) {
//                System.out.print(chessBoard[i][j]+" ");
//            }
//            System.out.println(); 
//        }
        /* ############# Reverse Linked List ############## */
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        Node.printLinkedList(head);
        Node.printLinkedList(reverseLinkedList(head));

    }

    private static void towerOfHanoi(int n, String from, String using, String to) {

        if (n > 0) {
            towerOfHanoi(n - 1, from, to, using);
            System.out.printf("Moving from %s to %s%n", from, to);
            towerOfHanoi(n - 1, using, from, to);
        }
    }

    private static void partitionEqualSumArray(int[] a) {
        int sum = 0;
        for (int j : a) {
            sum += j;
        }
        boolean[] picks = new boolean[a.length];
        boolean isPossible = sum % 2 == 0 && pick(a, sum / 2, 0, picks);
        if (isPossible) {
            printArray(picks);
        } else {
            System.out.println("It's not possible to divide give array in two equal sums array!!");
        }
    }

    private static boolean pick(int[] a, int sumToForm, int index, boolean[] picks) {
        if (index >= a.length || sumToForm < 0) return false;
        if (sumToForm == 0) {
            return true;
        }
        picks[index] = true;
        boolean isPossibleWithPick = pick(a, sumToForm - a[index], index + 1, picks);
        if (isPossibleWithPick) {
            System.out.printf("picked %s\n", a[index]);
            return true;
        }
        picks[index] = false;
        return pick(a, sumToForm, index + 1, picks);
    }

    private static boolean nQueens(int queen, int col, int[][] a) {
        if(queen >= a.length){
            return true;
        }
        if (col >= a.length) {
            return false;
        }
        if (isValidLocation(queen, col, a)) {
            a[queen][col] = 1;
            if(!nQueens(queen + 1, 0, a)){
                a[queen][col] = 0;
                return nQueens(queen, col+1, a);
            }
            return true;
        } else {
            return nQueens(queen, col + 1, a);
        }
    }

    private static boolean isValidLocation(int x, int y, int[][] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i][y] == 1) {
                return false;
            }
            if (a[x][i] == 1) {
                return false;
            }
        }
        int col = 0;
        int row1 = x - y;
        int row2 = x + y;
        while (col < a.length) {
            if (row1 < a.length && row1 >= 0 && a[row1][col] == 1) {
                return false;
            }
            if (row2 < a.length && row2 >= 0 && a[row2][col] == 1) {
                return false;
            }
            col++;
            row1++;
            row2--;
        }
        return true;
    }

    private static void printArray(boolean[] array) {
        for (boolean j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    private static class Node{
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public static void printLinkedList(Node head){
            System.out.print(head.data+" ");
            head = head.next;
            while (head!=null){
                System.out.print(head.data+" ");
                head = head.next;
            }
            System.out.println();
        }
    }

    private static Node reverseLinkedList(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node prev = null;
        Node next;
        while(head.next!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next=prev;
        return head;
    }
}

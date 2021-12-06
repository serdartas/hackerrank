import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }

        this.tail = node;
    }
}

class DoublyLinkedListPrintHelper {
    public static void printList(DoublyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.println(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.println(sep);
            }
        }
    }
}

class Result {
    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
    // Method 1: Recursive. Input list is already sorted and all is asked for to find the 
    // correct position for data so previous node data should be smaller and next one is 
    // bigger. Not that, although list is sorted, values can be repeated.
    // In worst case algorithm iterates once in list items os complexity is O(n)
        if(llist.prev == null && llist.data>data){// data should be the head of list
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            newNode.next = llist;
            return llist;
        }
        if(data>=llist.data &&(llist.next == null|| data<llist.next.data)){//position found
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            newNode.next = llist.next;
            llist.next = newNode;
            return llist;
        }
        llist.next = sortedInsert(llist.next, data);
        return llist;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                DoublyLinkedList llist = new DoublyLinkedList();

                int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

                IntStream.range(0, llistCount).forEach(i -> {
                    try {
                        int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

                        llist.insertNode(llistItem);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int data = Integer.parseInt(bufferedReader.readLine().trim());

                DoublyLinkedListNode llist1 = Result.sortedInsert(llist.head, data);

                DoublyLinkedListPrintHelper.printList(llist1, " ");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
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

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep) throws IOException {
        while (node != null) {
            System.out.print(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                System.out.print(String.valueOf(sep));
            }
        }
    }
}

class Result {
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
    // I couldn't come up with a non-recursive method to solve this problem.
    // The solution I suggest here recurses inside the linked list until it
    // reaches the provided position. It returns list.next until the position
    // and returns new node+next in the position
    // as it needs to recurse once until position and position might equal to 
    // n-1, complexity is O(n)
        if(position==0){
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            newNode.next = llist;
            return newNode;
        }
        llist.next = insertNodeAtPosition(llist.next, data, position-1);
        return llist;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        SinglyLinkedList llist = new SinglyLinkedList();
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

        int position = Integer.parseInt(bufferedReader.readLine().trim());

        SinglyLinkedListNode llist_head = Result.insertNodeAtPosition(llist.head, data, position);

        SinglyLinkedListPrintHelper.printList(llist_head, " ");

        bufferedReader.close();
    }
}

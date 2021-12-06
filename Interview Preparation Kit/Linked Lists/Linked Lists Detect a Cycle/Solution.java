/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head)
{
// Fastest way to implement this is to have two pointers where one of them moves faster
// than the other. If there's no loop, fast one will hit a null point and algorithm will
// exit. If there's a loop two pointers will eventually match at some point.
    Node slow = head, fast = head;
    while (slow != null && fast != null && fast.next != null)
    {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast)
            return true;
    }
    return false;
}
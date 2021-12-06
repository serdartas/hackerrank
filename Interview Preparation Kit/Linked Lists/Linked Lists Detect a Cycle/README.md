# Linked Lists: Detect a Cycle
A linked list is said to contain a cycle if any node is visited more than once while traversing the list. For example, in the following graph there is a cycle formed when node *5* points back to node *3*.

https://s3.amazonaws.com/hr-assets/0/1527604250-43ac8fbfaf-filtrationExample.png

## Function Description
Complete the function has_cycle in the editor below. It must return a boolean true if the graph contains a cycle, or false.

has_cycle has the following parameter(s):

- head: a pointer to a Node object that points to the head of a linked list.

## Returns
- boolean: True if there is a cycle, False if there is not
Note: If the list is empty,  will be null.

## Input Format
There is no input for this challenge. A random linked list is generated at runtime and passed to your function.

## Sample Input
The following linked lists are passed as arguments to your function:

https://s3.amazonaws.com/hr-assets/0/1527605967-9c8887640c-hascycleS0.png

https://s3.amazonaws.com/hr-assets/0/1527605730-b50d823d5c-hascycleS1.png

## Sample Output
0
1
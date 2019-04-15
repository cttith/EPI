package linkedList;

import java.util.List;

public class reverseSublist_8_2 {


  // given s and f
  // reverse nodes in range [s, f]

  public ListNode<Integer> reverseSublist(int s, int f, ListNode<Integer> root) {
    if (s == f) return root;

    // assume s and f are valid ranges in the sublist
    // let's save   (for rewiring)
    // node before start
    // node after finished
    // node at start
    // node at finished
    ListNode<Integer> savedHead = root;
    ListNode<Integer> headS = root;
    ListNode<Integer> savedTail = root;
    ListNode<Integer> tailF = root;
    ListNode<Integer> tmp = root;
    int position = 1;
    while (position != f + 1) {
      if (position == s - 1)
        savedHead = tmp;

      if (position == f)
        tailF = tmp;

      position++;
      tmp = tmp.next;
    }

    savedTail = tailF.next;
    headS = savedHead.next;

    // reverse linked list in range
    // need 3 intermediate nodes
    ListNode<Integer> currNode, prevNode, nextNode;
    currNode = savedHead.next;
    prevNode = null;
    nextNode = currNode.next;

    while (nextNode != savedTail){
      currNode.next = prevNode;
      prevNode = currNode;
      currNode = nextNode;
      nextNode = nextNode.next;
    }
    currNode.next = prevNode;

    // rewire head and tail of old list
    savedHead.next = tailF;
    headS.next = savedTail;


    myLinkedList<Integer> list = new myLinkedList<>();
    list.add(root);
    list.printList();

    return root;
  }




}

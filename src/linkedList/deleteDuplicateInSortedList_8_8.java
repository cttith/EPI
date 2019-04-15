package linkedList;

import java.util.List;

public class deleteDuplicateInSortedList_8_8 {

  // iterate list, currNum, prevNum
  // actual no need for calling remove
  // we can just say while (curr.data == prev.data)
    // advance currNode
  // when they are finally not equivalent
  // make prev point to new position of current
  public ListNode<Integer> deleteDuplicates(ListNode<Integer> root){

    removeNode_8_6 remover = new removeNode_8_6();
    ListNode<Integer> dummyHead = new ListNode<Integer>();
    dummyHead.next = root;

    ListNode<Integer> currNode = dummyHead.next.next;
    ListNode<Integer> prevNode = dummyHead.next;

    while (currNode != null){
      if (prevNode.data == currNode.data){
        remover.deleteNode(currNode);
        currNode = prevNode.next;
      } else{
        prevNode = prevNode.next;
        currNode = currNode.next;
      }
    }

    System.out.println("after removing duplicates");
    myLinkedList<Integer> list = new myLinkedList<>();
    list.add(dummyHead.next);
    list.printList();

    return dummyHead.next;
  }
}

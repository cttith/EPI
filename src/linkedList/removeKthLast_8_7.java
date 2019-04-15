package linkedList;


import java.util.List;

public class removeKthLast_8_7 {

  // could iterate to find kth last, but this requires 2 passes ( inefficient )
  // let's traverse k times and then have a 2nd ptr that traverses when we have traversed k times with the 1st ptr
  // when 1st ptr is null, the 2nd ptr will be at the (k)th last node

    // remove 2nd to last
  // a -> B -> C, K = 2
  // A -> b -> C, k = 2 -> 1
  // A -> B -> c, k = 1 -> 0

  // while (first != null)
    // second next
    // first next
  // second = B
    // use removeNode
    // results in A -> C


  public ListNode<Integer> removeKthLast(ListNode<Integer> root, int k){

    ListNode<Integer> dummyHead = new ListNode<>();
    dummyHead.next = root;
    ListNode<Integer> first = dummyHead.next;
    while (k-- > 0 && first != null){
      first = first.next;
    }


    // size of list < k
    // remove first node
    ListNode<Integer> second = dummyHead.next;
    if (k > 0){
      return second.next;
    }

    while (first != null){
      second = second.next;
      first = first.next;
    }

    removeNode_8_6 help = new removeNode_8_6();
    help.deleteNode(second);

    myLinkedList<Integer> list = new myLinkedList<>();
    list.add(dummyHead.next);
    list.printList();

    return root;





  }
}

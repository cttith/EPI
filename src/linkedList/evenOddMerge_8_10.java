package linkedList;

public class evenOddMerge_8_10 {

  // list start with number 0 .... n
  // merge s.t. even precedes odds

  // have three pointers, one for even one for odd, one dummyHead for odd starting point
  // even.next = every other node (if not null)
  // odd.next = even.next every other node after even nodes (if not null)

  // even tai next => odd head


  public ListNode<Integer> evenOddMerge(ListNode<Integer> root){

    ListNode<Integer> evenNode, oddNode, dummyOddHead;

    // see if list starts with even/odd (problem says start with 0)
//    if (root.data%2 == 0) evenNode = root;
//    else oddNode = root;

    dummyOddHead = root.next;
    evenNode = root;
    oddNode = root.next;
    while (evenNode.next != null && oddNode.next != null){      // list ends in even or odd
      evenNode.next = evenNode.next.next;
      evenNode = evenNode.next;
      oddNode.next = evenNode.next;
      oddNode = oddNode.next;
    }


    evenNode.next = dummyOddHead;

    return root;



  }



}

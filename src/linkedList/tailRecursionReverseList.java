package linkedList;


public class tailRecursionReverseList {



  public ListNode<Integer> driver(ListNode<Integer> root){

    root = tailRecursive(root, null);
    myLinkedList<Integer> list = new myLinkedList<>();
    list.add(root);
    list.printList();
    return root;
  }

  // base case if curr == null, prev == new head
  private ListNode<Integer> tailRecursive(ListNode<Integer> curr, ListNode<Integer> prev){

    if(curr == null){
      return prev;
    }

    ListNode<Integer> newStart = curr.next;
    curr.next = prev;
    return tailRecursive(newStart, curr);
  }


}

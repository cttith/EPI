package linkedList;

public class testCycle_8_3 {


  public ListNode<Integer> findCycle(ListNode<Integer> root){
    ListNode<Integer> doubleNext = root;

    while( doubleNext != null ){

      if(doubleNext == root) return doubleNext;

      doubleNext = doubleNext.next != null ? doubleNext.next.next : doubleNext.next;
      root = root.next;

    }

    return doubleNext;
  }

}

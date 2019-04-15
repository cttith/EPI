package linkedList;


public class cyclicRightShift_8_9 {

  // idea 1:
  // could do a hashmap
  // store values at each node and store it in the (i+k)%k position
  // cons: O(N) memory


  // idea 2:
  // we know that if we shift current node k units, the following node should move k+1 (aka next to new shift position)
  // so we can split the LL into sublists
  // [head, len-kth node] [len-kth+1, tail]
  // new LL => len-kth+1 == new head, old tail points to old head, new tail == len-kth node
  // pros: O(1) memory
  public ListNode<Integer> shiftKtoTheRight(ListNode<Integer> root, int k){

//    // keep dummy for return
//    ListNode<Integer> dummyHead = new ListNode<>(-1);
//    dummyHead.next = root;
//
    int listLength, lengthMinusK;
    // let's find length of list
    listLength = lengthList(root);
    lengthMinusK = listLength - k;
    if (lengthMinusK == 0) return root;

    // adjust k if > size(list)
    k %= listLength;

    // split LL
    // grab currentHead(dummyHead.next) and
    // len-kth+1 node (new head) and old tail(this is going to be the predecessor to old head after shift)
    ListNode<Integer> oldHead, newHead, oldTail, newTail;
    newTail = root;
    oldHead = root;

    // grabbing len-k (new tail) and len-k+1 (new head)
    while (--lengthMinusK > 0){
      newTail = root.next;
      root = root.next;
    }
    // node x's successor, where x is the new tail
    newHead = newTail == null ? oldHead.next : newTail.next;

    // grabbing old tail
    oldTail = root;
    while (oldTail.next != null){
      oldTail = oldTail.next;
    }

    // point newTail to null
    newTail.next = null;
    // oldTail to oldHead
    oldTail.next = oldHead;



    return newHead;


  }



  private int lengthList(ListNode<Integer> root){
    int count = 0;
    while (root != null){
      count++;
      root = root.next;
    }

    return count;
  }

}

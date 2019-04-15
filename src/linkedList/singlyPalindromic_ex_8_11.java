package linkedList;

import static linkedList.linkedListDriver.lengthList;

public class singlyPalindromic_ex_8_11 {

  // maybe make list circular
  // can we traverse forwards and backwards?
  // we could reverse sublist @ half point...
  // cons : a lot of traversing
    // traverse entire list to find size
    // traverse once more to half point
    // reverse (requires another traverse)
    // traverse one more time to see if palindrome
    // O(1) memory, O(n) time

  // we coudl also create new list that copies old list and reverse the new list and iterate both at the same time

  // let's reverse half point
  // if even #, reverse @ [half-point,tail]
  // if odd #, reverse @ [

  public boolean isPalindromic(ListNode<Integer> root){

    int lengthList, halfIdx;
    lengthList = lengthList(root);

    if (lengthList%2 == 0) halfIdx = (lengthList/2)+1;
    else halfIdx = (lengthList/2)+2;

    // reverse second half
    reverseSublist_8_2 reverse = new reverseSublist_8_2();
    root = reverse.reverseSublist(halfIdx, lengthList, root);

    // traverse to second half
    ListNode<Integer> secondHalfPtr = root;
    while (--halfIdx > 0)
      secondHalfPtr = secondHalfPtr.next;


    while (secondHalfPtr != null){
      if (secondHalfPtr.data != root.data) return false;

      secondHalfPtr = secondHalfPtr.next;
      root = root.next;
    }

    return true;
  }
}

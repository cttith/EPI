package linkedList;

public class listPivoting_8_12 {

  // given value k pivot
  // make list s.t. three regions <k ==k >k

  public ListNode<Integer> pivotList(ListNode<Integer> root, int k){

    // do three rgions (three ptrs)
    ListNode<Integer> lessThan, dummyLess, equalTo, dummyEqual, greaterThan, dummyGreater;
    lessThan = new ListNode<>();
    equalTo = new ListNode<>();
    greaterThan = new ListNode<>();
    dummyLess = lessThan;
    dummyEqual = equalTo;
    dummyGreater = greaterThan;

    while (root != null){

      if (root.data < k) {
        lessThan.next = root;
        lessThan = lessThan.next;
      } else if (root.data == k){
        equalTo.next = root;
        equalTo = equalTo.next;
      } else{
        greaterThan.next = root;
        greaterThan = greaterThan.next;
      }

      root = root.next;
    }
    greaterThan.next = null;

    lessThan.next = dummyEqual.next;
    equalTo.next = dummyGreater.next;

    return dummyLess.next;

  }
}

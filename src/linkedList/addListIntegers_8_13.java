package linkedList;

import static linkedList.linkedListDriver.lengthList;

public class addListIntegers_8_13 {

  // given lists Least significant is the head of list
  // given 3 -> 1 -> 4
  //       7 -> 0 -> 9
  // 413 + 907 = 1320
  // result List = 0 -> 2 -> 3 -> 1

  // given 3 -> 1 -> 4 -> 1
  //       7 -> 0 -> 9
  // 1413 + 904 = 2320

  // compute sum @ each respective idx
  // add to result list

  // need to find length of both lists
  // find greater l

  public ListNode<Integer> addLists(ListNode<Integer> numOne, ListNode<Integer> numTwo){

    int lengthOne, lengthTwo, carry, sum;
    ListNode<Integer> greaterLength, lesserLength, result, dummyResult;

    lengthOne = lengthList(numOne);
    lengthTwo = lengthList(numTwo);

    if (lengthOne > lengthTwo){
      greaterLength = numOne;
      lesserLength = numTwo;
    }
    else {
      greaterLength = numTwo;
      lesserLength = numOne;
    }

    result = new ListNode<>(0);
    dummyResult = result;
    carry = 0;
    while (greaterLength != null && lesserLength != null){
      sum = greaterLength.data + lesserLength.data + carry;
      if (sum >= 10) carry = 1;
      else carry = 0;
      sum %= 10;
      result.next = new ListNode<>(sum);
      result = result.next;

      greaterLength = greaterLength.next;
      lesserLength = lesserLength.next;

    }

    if (greaterLength != null || lesserLength != null){
      if (lesserLength != null){
        lesserLength.data +=carry;
        result.next = lesserLength;
      }
      else {
        greaterLength.data += carry;
        result.next = greaterLength;
      }
      carry = 0;
    }

    if (carry == 1) result.next = new ListNode<>(1);



    return dummyResult.next;
  }
}

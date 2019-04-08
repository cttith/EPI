package linkedList;

public class merge2Lists_8_1 {

  public myLinkedList<Integer> merge(ListNode<Integer> listOne, ListNode<Integer> listTwo){


    // grab root of each list
    // create sentinel incase both lists are empty

    ListNode<Integer> sentinel = new ListNode<>();


    ListNode<Integer> currNode = sentinel;


    while(listOne != null && listTwo != null){
      System.out.println("in while");

      int valOne = listOne.data;
      int valTwo = listTwo.data;

      if (valOne < valTwo) {
        currNode.next = listOne;
        listOne = listOne.next;
      }
      else {
        currNode.next = listTwo;
        listTwo = listTwo.next;
      }

      currNode = currNode.next;
    }

    currNode.next = listOne == null ? listTwo : listOne;

    myLinkedList<Integer> list = new myLinkedList<>();
    list.add(sentinel.next);

    list.printList();
    return list;

  }





}

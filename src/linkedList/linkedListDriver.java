package linkedList;

public class linkedListDriver {



  public static void main(String[] args){

    ListNode<Integer> listOne = new ListNode<>(1);
    listOne.next = new ListNode<>(3);
    listOne.next.next = new ListNode<>(5);
    ListNode<Integer> listTwo = new ListNode<>(2);
    listTwo.next = new ListNode<>(4);
    listTwo.next.next = new ListNode<>(6);


    merge2Lists_8_1 ex_8_1 = new merge2Lists_8_1();
    ex_8_1.merge(listOne, listTwo);





  }
}

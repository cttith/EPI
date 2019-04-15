package linkedList;

public class linkedListDriver {



  public static void main(String[] args){

    // regular list [0,6]
    ListNode<Integer> listZero = new ListNode<>(0);
    listZero.next = new ListNode<>(1);
    listZero.next.next = new ListNode<>(2);
    listZero.next.next.next = new ListNode<>(3);
    listZero.next.next.next.next = new ListNode<>(4);
    listZero.next.next.next.next.next = new ListNode<>(5);
    listZero.next.next.next.next.next.next = new ListNode<>(6);

    // cycle list
    ListNode<Integer> cycleList = new ListNode<>(0);
    ListNode<Integer> cycleListOne = new ListNode<>(0);
    ListNode<Integer> cycleListTwo = new ListNode<>(0);
    ListNode<Integer> cycleListThree = new ListNode<>(0);
    cycleList.next = cycleListOne;
    cycleListOne.next = cycleListTwo;
    cycleListTwo.next = cycleListThree;
    cycleListThree.next = cycleList;

    // intersecting node
    ListNode<Integer> intersectedNode = new ListNode<>(100);
    intersectedNode.next = new ListNode<>(-1);
    intersectedNode.next.next = new ListNode<>(-1);

    // [odd numbers] [1,5]
    ListNode<Integer> listOne = new ListNode<>(1);
    listOne.next = new ListNode<>(3);
    listOne.next.next = new ListNode<>(5);

    // [even numbers [2,6]
    ListNode<Integer> listTwo = new ListNode<>(2);
    listTwo.next = new ListNode<>(4);
    listTwo.next.next = new ListNode<>(6);


    merge2Lists_8_1 ex_8_1 = new merge2Lists_8_1();
    ex_8_1.merge(listOne, listTwo);
    System.out.println();
    System.out.println();

    reverseSublist_8_2 ex_8_2 = new reverseSublist_8_2();
    ex_8_2.reverseSublist(2,5, listZero);

    System.out.println();
    System.out.println();
    tailRecursionReverseList practiceRecursion = new tailRecursionReverseList();
    listZero = practiceRecursion.driver(listZero);

    System.out.println();
    System.out.println();
    testCycle_8_3 ex_8_3 = new testCycle_8_3();
    ListNode<Integer> cycleNode = ex_8_3.findCycle(cycleList);
    System.out.println("cycleNode data = " + cycleNode.data);



    // set intersecting node
    listTwo.next.next.next = intersectedNode;
    listOne.next.next.next = intersectedNode;

    System.out.println();
    findIntersectingNode_8_4 ex_8_4 = new findIntersectingNode_8_4();
    ListNode<Integer> ans = ex_8_4.findIntersection(listOne, listTwo);
    System.out.println();
    System.out.println("Intersecting node value = " + ans.data);
    System.out.println();
    System.out.println();

    removeKthLast_8_7 ex_8_7 = new removeKthLast_8_7();
    ex_8_7.removeKthLast(listZero, 2);


    ListNode<Integer> duplicatesList = new ListNode<>(1);
    duplicatesList.next = new ListNode<>(1);
    duplicatesList.next.next = new ListNode<>(1);
    duplicatesList.next.next.next = new ListNode<>(1);
    duplicatesList.next.next.next.next = new ListNode<>(1);
    duplicatesList.next.next.next.next.next = new ListNode<>(2);
    duplicatesList.next.next.next.next.next.next = new ListNode<>(2);
    duplicatesList.next.next.next.next.next.next.next = new ListNode<>(3);
    duplicatesList.next.next.next.next.next.next.next.next = new ListNode<>(4);


    deleteDuplicateInSortedList_8_8 ex_8_8 = new deleteDuplicateInSortedList_8_8();
    ex_8_8.deleteDuplicates(duplicatesList);
    System.out.println();



    cyclicRightShift_8_9 ex_8_9 = new cyclicRightShift_8_9();
    ListNode<Integer> newHead = ex_8_9.shiftKtoTheRight(duplicatesList, 5);
    print(newHead);
  }



  public static void print(ListNode<Integer> root){
    System.out.println("===============================");
    myLinkedList<Integer> list = new myLinkedList<>();
    list.add(root);
    list.printList();
  }
}

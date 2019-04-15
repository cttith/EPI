package linkedList;

public class findIntersectingNode_8_4 {


  // traverse both lists until reaching end; get lengths
  // subtract longer from smaller
  // traverse larger list longer-smaller times
    // this will now mean they both x nodes away from the intersecting node
  // traverse both lists at same time one by one, if they == ; return that node



  public ListNode<Integer> findIntersection(ListNode<Integer> listOne, ListNode<Integer> listTwo){

    int lengthOne = 0;
    int lengthTwo = 0;

    ListNode<Integer> tmp = listOne;
    while (tmp != null){
      lengthOne++;
      tmp = tmp.next;
    }

    tmp = listTwo;
    while (tmp != null) {
      lengthTwo++;
      tmp = tmp.next;
    }


    // get both lists x nodes away from intersecting node
    if (lengthOne > lengthTwo){
      int diff = lengthOne - lengthTwo;
      while (diff != 0){
        listOne = listOne.next;
        diff--;
      }
    } else{
      int diff = lengthTwo - lengthOne;
      while (diff != 0){
        listTwo = listTwo.next;
        diff--;
      }
    }



    while (listOne != listTwo && listOne != null && listTwo != null){
      System.out.println("listOne data = " + listOne.data);
      System.out.println("listTwo data = " + listTwo.data);

      listOne = listOne.next;
      listTwo = listTwo.next;
    }

    return listOne;




  }
}

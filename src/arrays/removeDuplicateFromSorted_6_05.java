package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class removeDuplicateFromSorted_6_05 {

  public List<Integer> removedDuplicates(List<Integer> sortedArr){
    // go through elements, and save prev element, if current element == prev element
    // if curr == prev
    //  set curr to 0
    // else prev = curr

    // to deal with zeroes we can iterate through arr and if we find a 0 swap with the next availabe number
    // O(n2)

    // a diff way to get O(n) time but O(n) space is to replace a zero with next avail number
    // append 0 to end of list until it reaches size

    // method 2, use hashmap, add to a new list if value is new
    // copy ne wlist to old list

    int prev = -10;
    int curr;
    sortedArr = new ArrayList<>(sortedArr); // List.of() makes a unmodifiable list

    for(int i = 0; i < sortedArr.size(); i++){
      curr = sortedArr.get(i);
      if(prev == curr){
        sortedArr.set(i, 0);
      }else {
        prev = curr;
      }
    }


    return sortedArr;
  }
}

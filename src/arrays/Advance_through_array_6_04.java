package arrays;

import java.util.ArrayList;
import java.util.List;

public class Advance_through_array_6_04 {

  public boolean canFinish(List<Integer> arr){

    // from each position i, max u can reach from there is i + A[i]
    // iterate through entire arr and stop if i > furthestWeCanReach because we will never make it to the i'th spot

    int furthestWeCanReach = 0;
    for(int i = 0; i <= furthestWeCanReach && i < arr.size(); i++){
      furthestWeCanReach = Math.max(furthestWeCanReach, i + arr.get(i));
    }
    return furthestWeCanReach >= arr.size()-1;

  }


  // dynamic programming, need to test out all possibilities
  // keep a separate array(+infinity values) of minimum number of jumps to get to index i
  // iterate through entire array of possible jumps. fill out separate array with minimum jumps to get to index i
  // at current iteration, check all possible indexes that can be reaches from. i + current_Val , i + current_val - 1, i + current_val - 2.....
  // if the value at the jumped to index is > i+1 ; replace value at jumped to index.
  // repeat until
  public int minSteps(List<Integer> arr){

    if(!canFinish(arr)) return -1;

    List<Integer> minSteps = new ArrayList<>();
    for(int i = 0; i < arr.size(); i++){
      minSteps.add(Integer.MAX_VALUE);
    }

    minSteps.set(0, 0);
    for(int i = 0; i < arr.size(); i++){
      for(int j = 1; j <= arr.get(i) && i+j < arr.size(); j++){
        int steps = minSteps.get(i);
        if (steps+1 < minSteps.get(i+j)){
          minSteps.set(i+j, steps+1);
        }
      }
    }


    return minSteps.get(arr.size()-1);



  }
}

package strings;

import java.util.ArrayList;
import java.util.List;

public class replaceAndRemove {

  // remove each 'b'
  // replace all 'a' with 2 'd'
  // assume array has empty spots at end if not full
  // O(n) time, O(n) space
  public char[] transform(char[] arr, int numChanges){

    // remove all b, then hold available positions
    List<Integer> availPositions = new ArrayList<>();

    for(int i = 0; i < arr.length; i++){
      if(arr[i] == 'b'){
        availPositions.add(i);
        arr[i] = '_';
        numChanges--;
      }else if(arr[i] == '_' ){
        availPositions.add(i);
      }

      if(numChanges == 0) return arr;
    }

    int availIdx = 0;
    int arrLength = arr.length-1;
    for(int i = 0; i < arr.length; i++){

      if (arr[i] == 'a'){
        arr[i] = 'd';
        if (availIdx < availPositions.size()){
          arr[availPositions.get(availIdx++)] = 'd';
        }else{
          arr[arrLength--] = 'd';
        }
        numChanges--;
      }
      if (numChanges == 0) return arr;
    }

    return arr;

  }

  // try to achieve O(1) space by shifting
  public char[] transformV1(char[] arr, int numChanges){

    int writeIdx = 0;
    int aCount = 0;

    //REMOVE
    for(int i = 0; i < arr.length; i++){
      if(arr[i] != 'b'){
        arr[writeIdx++] = arr[i];         // overwrites b's with writeIdx for character at i
      }

      if(arr[i] == 'a'){
        aCount++;
      }
    }

    // REPLACE
    // (0, writeIdx - 1) - bound without any b's
    // find a's to remove and place d's at empty spots
    int currIdx = writeIdx - 1; // current domain range of chars (0, currIdx)
    writeIdx += aCount - 1;   // start from end of array and fill with d's

    // writeIdx - currIdx == empty spaces from b's removed
        // if a found
          // place 2 d's
        // else
          // place last valid character from (0, currIdx) at writeIdx
    // currIdx - end bound of valid characters, go backwards (backward iteration)
    while (currIdx >= 0){
      if (arr[currIdx] == 'a'){
        arr[writeIdx--] = 'd';
        arr[writeIdx--] = 'd';
      } else {
        arr[writeIdx--] = arr[currIdx];
      }
      currIdx--;
    }

    return arr;
  }
}

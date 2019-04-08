package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApplyPermutation {

  static int arr[] = new int[]{50, 40, 70, 60, 90};
  static int index[] = new int[]{3,  0,  4,  1,  2};

  // Method to reorder elements of arr[] according
  // to index[]
  public void reorder()
  {
    // Fix all elements one by one
    for (int i=0; i<arr.length; i++)
    {
      // While index[i] and arr[i] are not fixed
      while (index[i] != i)
      {
        // Store values of the target (or correct)
        // position before placing arr[i] there
        int  oldTargetI  = index[index[i]];
        char oldTargetE  = (char)arr[index[i]];

        // Place arr[i] at its target (or correct)
        // position. Also copy corrected index for
        // new position
        arr[index[i]] = arr[i];
        index[index[i]] = index[i];

        // Copy old target values to arr[i] and
        // index[i]
        index[i] = oldTargetI;
        arr[i]   = oldTargetE;
      }
    }

    for(int num : arr){
      System.out.print(num + " ");
    }

  }

}
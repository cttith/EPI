package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pascalsTriangle {

  void returnNRowsOfPascalsTriangle(int n){

    // can we use one list?
    List<List<Integer>> pascalsTriangle = new ArrayList<>();
    if(n >= 2){
      pascalsTriangle.add(List.of(1));
      pascalsTriangle.add(List.of(1,1));
    }

    for(int i = 3; i <= n; i++) { // create list of 1's
      List<Integer> pascalRow = new ArrayList<>(Collections.nCopies(i, 1));
      for(int j = 1; j < i - 1; j++){
        int leftElement = pascalsTriangle.get(i-2).get(j-1);
        int rightElement = pascalsTriangle.get(i-2).get(j);
        pascalRow.set(j, leftElement + rightElement);
      }
      pascalsTriangle.add(pascalRow);
    }



    for(List<Integer> list : pascalsTriangle){
      for(int num : list){
        System.out.print(num + " ");
      }
      System.out.println();
    }

  }

}

package arrays;

import java.util.List;

public class spiralArray {

  // work way inwards with counters to change position of traversal
  public void spiralPrint(List<List<Integer>> arr){
    System.out.println();
    int rowStart, rowEnd, colStart, colEnd;
    rowStart = 0;
    rowEnd = arr.size() - 1;
    colStart = 0;
    colEnd = arr.get(0).size() - 1;
    System.out.println();
    while(rowEnd >= rowStart || colEnd >= colStart){
      int i = 0;  // for rows
      int j = 0;  // for cols

      for(j = colStart;  j <= colEnd; j++){
        System.out.print(arr.get(rowStart).get(j) + " ");
      }

      for(i = rowStart + 1; i <= rowEnd; i++){
        System.out.print(arr.get(i).get(colEnd) + " ");
      }

      for(j = colEnd - 1; j >= colStart; j--){
        System.out.print(arr.get(rowEnd).get(j) + " ");
      }

      for(i = rowEnd - 1; i >= rowStart + 1; i--){
        System.out.print(arr.get(i).get(colStart) + " ");
      }

      rowStart++;
      colStart++;
      rowEnd--;
      colEnd--;

    }

  }

}

package arrays;

public class rotate2DArray {

  // NxN array
  public void rotateArr(int[][] arr){
    // lastRow => first column
    // lastRow-- => 2nd column
    // ..
    // ..

    // ^ requires O(n2) space

    // O(1) space => do layer by layer (outside -> in)
    // observing test case, there is a cycle of placing numbers based on position
    System.out.println();
    final int arrSize = arr.length - 1;
    for(int i = 0; i < arr.length/2; i++){      // layers
      for(int j = i; j < arrSize - i; j++){         // swaps
        int topLeft = arr[i][j];
        int topRight = arr[j][arrSize - i];
        int bottomRight = arr[arrSize-i][arrSize - j];
        int bottomLeft = arr[arrSize-j][i];

//        System.out.println("============== i = " + i);
//        System.out.println("topLeft = " + topLeft);
//        System.out.println("topRight = " + topRight);
//        System.out.println("bottomRight = " + bottomRight);
//        System.out.println("bottomLeft = " + bottomLeft);

        arr[j][arrSize - i] = topLeft;      // top right
        arr[arrSize - i][arrSize - j] = topRight;  // bottom right
        arr[arrSize - j][i] = bottomRight;    // bottom left
        arr[i][j] = bottomLeft;         // top left

      }
    }

    for(int i = 0; i < arr.length; i++){
      for(int j = 0; j < arr.length; j++){
        System.out.println(arr[i][j] + " ");
      }
      System.out.println();
    }
  }


}

package arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class sudoku_6_16 {

  public boolean isValidSudoku(List<List<Integer>> partialSudoku){

    // check for row constraints
    for(int i = 0; i < partialSudoku.size(); i++){
      if(hasDuplicates(partialSudoku, i, i+1, 0, partialSudoku.size()))
        return false;
    }

    // check for column constraints
    for(int j = 0; j < partialSudoku.size(); j++){
      if(hasDuplicates(partialSudoku, 0, partialSudoku.size(), j, j+1))
        return false;
    }

    // check for 3x3 grids
    int regionSize = (int) Math.sqrt(partialSudoku.size());
    for (int k = 0; k < regionSize; k++){
      for (int l = 0; l < regionSize; l++){
        if(hasDuplicates(partialSudoku, regionSize * k, regionSize * (k+1), regionSize * l, regionSize * (l+1)))
          return false;
      }
    }

    return true;

  }


  public boolean hasDuplicates(List<List<Integer>> partialSudoku, int startRow, int endRow, int startCol, int endCol){

    List<Boolean> isPresent = new ArrayList<>(Collections.nCopies(9, false));

    for(int i = startRow; i < endRow; i++){
      for(int j = startCol; j < endCol; j++){

        if(partialSudoku.get(i).get(j) != 0 && isPresent.get((partialSudoku.get(i).get(j)))){
          return true;
        }

        isPresent.set(partialSudoku.get(i).get(j), true);
      }

    }

    return false;

  }


}

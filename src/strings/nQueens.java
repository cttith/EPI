package strings;

import java.util.Arrays;

public class nQueens {
  // queen can attack row/col/diagonally (any length)
  // can only have one queen per row

  // goal:
    // place one queen per row
    // if at last row and queen placed GG

  // constraints:
    // only one queen per row
    // cannot have queen in square perimeter

  // choice:
    // place queen at this column

  private boolean isQueenInVicinity(int row, int col, char[][] board){

    // upper diagonally (only need to check left side)
    for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--)
      if (board[i][j] == 'Q') return true;

    // lower diagonally
    for (int i = row+1, j = col-1; i <= board.length-1 && j >= 0; i++, j--)
      if (board[i][j] == 'Q') return true;

    // horizontally (left side)
    for (int i = col-1; i >= 0; i--)
      if (board[row][i] == 'Q') return true;

    return false;
  }

  public boolean helper(int n){

    char[][] board = new char[n][n];

    for (char[] row : board)
      Arrays.fill(row, '_');

    return recursiveQueen(board, 0);
  }


  private boolean recursiveQueen(char[][] board, int col){

    if(col == board.length){
      for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board.length; j++){
          System.out.print(board[i][j] + " ");
        }
        System.out.println();
      }
      System.out.println();
      System.out.println();
      return true;
    }

    // try all rows for current column
    for(int row = 0; row < board.length; row++){
      // constraint
      if(isQueenInVicinity(row, col, board)) continue;      // if can't place, go to next row

      board[row][col] = 'Q';                // choose
      recursiveQueen(board, col+1);     // explore to see if leads to answer
      board[row][col] = '_';               // unchoose
    }

    return false;
  }
}

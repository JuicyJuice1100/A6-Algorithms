/* SLIT.java - Two solutions to the SLIT problem
*
*  @version CS 321 - Fall 2018 - A6
*
*  @author FIRST STUDENT'S FULL NAME GOES HERE
*
*  @author 2nd STUDENT'S FULL NAME GOES HERE (DELETE THIS LINE IF NOT NEEDED)
*
*  @bug The brute-force algorithm [does/does not] work fully. [delete one]
*
*  @bug The faster algorithm  [does/does not] work fully. [delete one]
*
*/

class SLIT {

  /* given a matrix and a slit window, return T - R where:
      + the slit window is a sub-matrix of the input matrix defined by:
      - the row index r of its top-left corner
      - the column index c of its top-left corner
      - its width (i.e., number of columns)
      - a height of 2 rows (always)
      + T is the number of occurrences of 'T' in the slit window
      + R is the number of occurrences of the rest of the bases (i.e., 'A',
      'C', and 'G') in the slit window

      For example, if the input matrix is:

      TTTACTCT     and r = 5 then T = 1 and the method returns -6
      CTTTTTGG         c = 3      R = 7
      AGTTATCT         w = 4
      TAATTTTT
      TTTCCTCT
      GTTCAGTA
      TTTCACGG
      TGCTTTTT
  */
  static int count(char[][] mat, int r, int c, int w) {
    // int numberT = 0;
    // int nonNumberT = 0;
    int sum = 0;
    for (int i = r; i < r + 2; i++) {
      for (int j = c; j < c + w; j++) {
        if (mat[i][j] == 'T') {
          sum++;
        } else {
          sum--;
        }
      }
    }
    return sum;
  }// count method

  /*
   * your implementation of the brute-force algorithm whose pseudocode is given in
   * the handout
   */
  static int algorithm1(char[][] mat, int n) {

    int slit = 0;

    for (int row = 0; row <= n - 2; row++) {
      for (int col = 0; col <= n - 1; col++) {
        for (int w = 1; w <= n - col; w++) {
          slit = Math.max(slit, count(mat, row, col, w));
        }
      }
    }

    return slit;
  }// algorithm1 method

  /*
   * your implementation of the second algorithm, which you must design
   */
  static int algorithm2(char[][] m, int n) {
    if(n < 2){
      return 0;
    } 

    int slit = 0;
    for(int row = 0; row <= n-2; row++){
      slit = Math.max(slit, maxTRec(m, 0, n, row));
    }

    return slit;
  }// algorithm2 method

  /*
   * implement your helper method(s) below this point
   */

  static int maxTRec(char[][] m, int l, int r, int row){
    if(l == r){
      return count(m, row, l, 1);
    }

    int mid = (l + r)/2;
    int maxL = maxTRec(m, l, mid, row);
    int maxR = maxTRec(m, mid + 1, r, row);

    int maxSumL = 0;
    int maxSumR = 0;
    int sum = 0;
    for(int i = mid; i >= l; i--){
      sum += count(m, row, i, 1);
      if(sum > maxSumL){
        maxSumL = sum;
      }
    }

    sum = 0;
    for(int j = mid + 1; j < r; j++){
      sum += count(m, row, j, 1);
      if(sum > maxSumR){
        maxSumR = sum;
      }
    }

    return Math.max(Math.max(maxL, maxR), maxSumL + maxSumR);

  }
}// SLIT class

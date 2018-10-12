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
          // numberT++;
          sum++;
        } else {
          // nonNumberT++;
          sum--;
        }
      }
    }
    // return numberT - nonNumberT;
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
  // static int algorithm2(char[][] m, int n) {
  //   if(n == 0){
  //     return 0;
  //   } 
  //   if(n == 1){
  //     return m[1][1] == 'T' ? 1 : -1; 
  //   }
  //   return algorithm2helper(m, 0, 0, n);
  // }// algorithm2 method

  static int algorithm2(char[][] m, int n){
    // int slit = 0;
    // for (int row = 0; row <= n-2; row++){
    //   for(int col = 0; col <= n-1; row++){
    //     slit = Math.min
    //   }
    // }
    return -1;
  }//algorithm2 method

  /*
   * implement your helper method(s) below this point
   */
   
   //recursive method that returns 1/4 the array until we get a 2x2 matrix
   //this was getting difficult to make it even faster so going with an easier method first
  //  static int algorithm2helper(char[][] m, int row, int col, int n){
  //    //assuming that n is always even
  //    if(n == 2){
  //      //basecase
  //      return count(m, row, col, n);
  //    }
  //   //  need to finish recursive function
  //   //  checks each quarter of matrix
  //    int nw = algorithm2helper(m, row, col, n/2);
  //    int ne = algorithm2helper(m, row, n/2, n/2);
  //    int sw = algorithm2helper(m, n/2, col, n/2);
  //    int se = algorithm2helper(m, n/2, n/2, n/2);
  //    int slit = Math.min(nw + ne, sw + se);
  //    slit = Math.min(slit, al);
  //  }

  //May not need, may be able to make this even faster
  //  static int rowCount(char[] row, int n){
  //    int count = 0;
  //    for(int col = 0; col < n; col++){
  //      if(row[col] != 'T'){
  //        count++;
  //      }
  //    }
  //    return count;
  //  }

}// SLIT class

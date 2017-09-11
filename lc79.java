class lc79 {

  public static void main( String args[] ) {
    char[][] board = {
      {'a','b','c','e'},
      {'s','f','c','s'},
      {'a','d','e','e'}
    };
    String word = "abcced";

    lc79 sol = new lc79();

    int res = sol.exist( board, word ) ? 1 : 0 ;  
    System.out.println( board );

    System.out.println( res );

    System.out.println("result" + (sol.exist( board, word )) ); 

  }

  public boolean exist( char [][] board, String word ) {

    int m = board.length;
    int n = board[0].length;

    for (int i = 0; i < m; i++ ) {
      for ( int j = 0; j < n; j++ ) {
        if ( dfs( board, word, 0, i, j ) ) {
          return true; 
        }
      }
    }

    return false;
  }

  private boolean dfs ( 
      char[][] board, 
      String word,
      int len, // len of previously matched strings. It also indicates the starting location 
      // of the next char to be matched in word
      int i, // starting location in board
      int j // starting location in board 
      ) 
  {
    int m = board.length;
    int n = board[0].length;

    if ( i< 0 || j < 0 || i>=m || j >= n ) {
      return false;
    }

    boolean res = false;
    if ( word.charAt( len ) == board[i][j] ) {
      char temp = word.charAt( len );
      board[i][j]= '#'; // Special character to indicated this is visited already

      if ( len == word.length() - 1 ) {
        res = true; 
      } 
      else if ( 
          dfs( board, word, len + 1, i - 1, j ) ||
          dfs( board, word, len + 1, i + 1, j ) ||
          dfs( board, word, len + 1, i, j - 1 ) ||
          dfs( board, word, len + 1, i, j+1 ) ) {
        res = true; 
          }
    
      board[i][j] = temp; 
    }

    return res; 

  }



}
